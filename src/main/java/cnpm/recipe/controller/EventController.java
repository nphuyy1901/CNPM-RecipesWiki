package cnpm.recipe.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import cnpm.recipe.model.Event;
import cnpm.recipe.model.Recipe;
import cnpm.recipe.model.User;
import cnpm.recipe.service.EventService;
import cnpm.recipe.service.RecipeService;
import cnpm.recipe.url.JspConst;
import cnpm.recipe.url.UrlConst;

@MultipartConfig
@WebServlet(name="eventController", urlPatterns = {
		UrlConst.MY_EVENT404,UrlConst.CREATE_A_EVENT,UrlConst.VIEW_A_EVENT, UrlConst.VIEW_ALL_EVENT,UrlConst.MY_EVENT})
public class EventController extends HttpServlet{
	
	private EventService service;
	private String acction;
	private RecipeService serviceRecipe;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		service= new EventService();
		serviceRecipe= new RecipeService();
		acction="";
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		acction=req.getServletPath();
		super.service(req, resp);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(acction) {
		case UrlConst.CREATE_A_EVENT:			
			req.getRequestDispatcher(JspConst.CREATE_A_EVENT).forward(req, resp);
			break;		
		case UrlConst.VIEW_A_EVENT:						
			if (req.getParameter("id") != null) {
				int idEvent = Integer.parseInt(req.getParameter("id"));
				Event event = service.getEventById(idEvent);
				req.setAttribute("event", event);
				List<Recipe> listRecipe =  serviceRecipe.getRecipes();
				req.setAttribute("listRecipe", listRecipe);
			}
			
			
			req.getRequestDispatcher(JspConst.VIEW_A_EVENT).forward(req, resp);
			break;	
		case UrlConst.VIEW_ALL_EVENT:
			List<Event> list_events = service.getEvent();			
			req.setAttribute("xem-tatca-event", list_events);
			req.getRequestDispatcher(JspConst.VIEW_ALL_EVENT).forward(req, resp);	
			
			break;
		case UrlConst.MY_EVENT:
			if(req.getParameter("id")!=null) {
				int idEvent = Integer.parseInt(req.getParameter("id"));
				service.deleteTGEvent(idEvent);
				service.deleteEvent(idEvent);
			}
			int idUser = (int) req.getSession().getAttribute("iduser");	
			List<Event> list_events_ByIdUser = service.getEventByIdUser(idUser);
			req.setAttribute("list_events_ByIdUser", list_events_ByIdUser);
			req.getRequestDispatcher(JspConst.MY_EVENT).forward(req, resp);			
			break;
		}
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			Part part = req.getPart("hinhanh");
			String realPath = req.getServletContext().getRealPath("/Event");
			String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
			if(!Files.exists(Path.of(realPath))) {
				Files.createDirectory(Path.of(realPath));
			}
			
			part.write(realPath+"/"+fileName);
			String anhminhhoa = "Event/"+fileName;
			
			
			Part part1 = req.getPart("hinhanhquangcao");
			String realPath1 = req.getServletContext().getRealPath("/Event");
			String fileName1 = Path.of(part1.getSubmittedFileName()).getFileName().toString();
			if(!Files.exists(Path.of(realPath1))) {
				Files.createDirectory(Path.of(realPath1));
			}
			
			part1.write(realPath1+"/"+fileName1);
			String anhquangcao = "Event/"+fileName1;
			
			String tensukien = req.getParameter("tensk");
		
			String ngaybd = req.getParameter("ngayvagiobatdau");
			
			String ngaykt = req.getParameter("ngayvagioketthuc");
			String giaithuong = req.getParameter("giaithuong");
			String mota = req.getParameter("mota");
			if(tensukien !=null && ngaybd!=null && ngaykt!=null &&
					tensukien!="" && ngaybd!="" && ngaykt !="" ) {
				
				Event event = new Event();
				
				User user = (User) req.getSession().getAttribute("user");	
				event.setTenuser(user.getFullname());
				event.setId_user(user.getId());
				event.setTen(tensukien);
				event.setMota(mota);
				event.setTgbatdau(Date.valueOf(ngaybd));
				event.setTgketthuc(Date.valueOf(ngaykt));			
				event.setSoluong(0);
				event.setGiaithuong(giaithuong);
				event.setHinhanh(anhminhhoa);
				event.setHinhanhquangcao(anhquangcao);  
				
				if (service.insertEvent(event)) {
					req.setAttribute("event", event);				
					List<Recipe> listRecipe =  serviceRecipe.getRecipes();
					req.setAttribute("listRecipe", listRecipe);
					req.getRequestDispatcher(JspConst.VIEW_A_EVENT).forward(req, resp);	
				}
					
							
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}

		
	}
	
	
}
