package be.vdab.servlets;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MeisjesJongensServlet
 */
//@WebServlet("/meisjesjongens.htm")
public class MeisjesJongensServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/meisjesjongens.jsp";
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		    if (request.getCookies() != null){
		    	for ( Cookie cookie: request.getCookies()){
		    		if (cookie.getName().equals("meisjesjongens")){
		    			request.setAttribute("meisjesjongens", URLDecoder.decode(cookie.getValue(),"UTF-8"));
		    		}
		    	}
		    }
		    
		    RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
		    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 request.setCharacterEncoding("UTF-8");
		 
	     Cookie cookie = new Cookie("meisjesjongens", URLEncoder.encode(request.getParameter("meisjesjongens"),"UTF-8"));
			 
		 cookie.setMaxAge(60*30);// 30 minuten onthouden
		 
		 response.addCookie(cookie);
		 response.sendRedirect(request.getRequestURI()); // terug naar deze servlet's doGet
		 
		  
	}

}
