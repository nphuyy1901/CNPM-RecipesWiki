package cnpm.recipe.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mysql.cj.x.protobuf.Mysqlx.Error.Severity;

import cnpm.recipe.model.User;
import cnpm.recipe.service.UserService;
import cnpm.recipe.url.JspConst;
import cnpm.recipe.url.UrlConst;

@MultipartConfig()
@WebServlet(name = "userServlet", urlPatterns = {
		UrlConst.EDIT_PROFILE,UrlConst.PROFILE
})
public class UserServlet extends HttpServlet{
	
	private UserService service;
	private String acction;
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		service = new UserService();
		acction = "";
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		acction=req.getServletPath();
		
		super.service(req, resp);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(acction) {
		case UrlConst.EDIT_PROFILE:
			req.getRequestDispatcher(JspConst.EDIT_PROFILE).forward(req, resp);
			break;
		case UrlConst.PROFILE: 
			User user =  (User) req.getSession().getAttribute("user");
			System.out.println(user.getUsername());
			req.setAttribute("user", user);
			req.getRequestDispatcher(JspConst.PROFILE).forward(req, resp);
			break;
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			Part part = req.getPart("hinhanh");
			String realPath = req.getServletContext().getRealPath("/users");
			String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
			if(!Files.exists(Path.of(realPath))) {
				Files.createDirectory(Path.of(realPath));
			}
			
			part.write(realPath+"/"+fileName);
			String avatar = "users/"+fileName;
			
			String hoten = req.getParameter("hoten");
			String ngaysinh = req.getParameter("ngaysinh");
			if(hoten !=null && ngaysinh!=null && hoten!="" && ngaysinh !="" ) {
				
				User user =  (User) req.getSession().getAttribute("user");
				Date DOB = Date.valueOf(ngaysinh);
				service.updateUser(user.getId(), hoten, DOB, avatar);
				req.getRequestDispatcher(JspConst.PROFILE);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}

		
	}
}
