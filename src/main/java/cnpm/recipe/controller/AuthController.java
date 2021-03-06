package cnpm.recipe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cnpm.recipe.model.User;
import cnpm.recipe.service.UserService;
import cnpm.recipe.url.JspConst;
import cnpm.recipe.url.UrlConst;

@WebServlet(name = "auth", urlPatterns = {
		UrlConst.SIGN_IN,
		UrlConst.SIGN_UP,
		UrlConst.SIGN_OUT,
		UrlConst.LANDING_PAGE,
		UrlConst.LOG_OUT
})
public class AuthController extends HttpServlet {

	
	private UserService service;
	private String action;
	private HttpSession session;
	
	@Override
	public void init() throws ServletException {
		super.init();
		service = new UserService();
		action ="";
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		action=req.getServletPath();
		session = req.getSession();
		super.service(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		switch(action) {
		case UrlConst.SIGN_IN:
			req.getRequestDispatcher(JspConst.SIGN_IN)
			.forward(req,resp);
		case UrlConst.TRANG_CHU:
			break;
		case UrlConst.SIGN_UP:
			req.getRequestDispatcher(JspConst.SIGN_UP)
			.forward(req,resp);
			break;
		case UrlConst.LANDING_PAGE:
			req.getRequestDispatcher(JspConst.LANDING_PAGE)
			.forward(req,resp);
			break;
		case UrlConst.LOG_OUT:
			
			//.removeValue(request, "login");
			session.removeAttribute("user");
			session.removeAttribute("iduser");
			session.invalidate();
			req.getRequestDispatcher(JspConst.LANDING_PAGE)
			.forward(req,resp);
			break;
			
		default:
			break;
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password1 = req.getParameter("password1");
		String password2 = req.getParameter("password2");
		
		if(username != null && password1 != null && password2!=null ) {
			
			User user = new User();
			user.setUsername(username);
			user.setPassword(password1);
			
			if(password1.length()>8 && service.insertUser(user)) {
				resp.sendRedirect(req.getContextPath() + UrlConst.EDIT_PROFILE);
			}
			else {
				resp.sendRedirect(req.getContextPath() + UrlConst.SIGN_UP);
			}
				
		}
		
		String password = req.getParameter("password");
		if(username!=null && password!=null) {
			User login = service.checkLogIn(username, password);
			if(login!=null) {
				
				session.setAttribute("user", login);
				session.setAttribute("iduser", login.getId());
				session.setMaxInactiveInterval(360);
				
				//req.setAttribute("username", login.getUsername());
				//req.setAttribute("AccountId", login.getId());
				//req.getRequestDispatcher(JspConst.EDIT_PROFILE).forward(req, resp);
				resp.sendRedirect(req.getContextPath() + UrlConst.TRANG_CHU);
			}
			else {
				resp.sendRedirect(req.getContextPath() + UrlConst.SIGN_IN);
			}
		}
	
}
}
