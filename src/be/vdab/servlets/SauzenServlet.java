package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.dao.SauzenDAO;

/**
 * Servlet implementation class SauzenServlet
 */
//@WebServlet("/sauzen.htm")
public class SauzenServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/Sauzen.jsp";
	private final SauzenDAO sauzenDAO = new SauzenDAO();
       
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
		request.setAttribute("sauzen",sauzenDAO.findAll());
		dispatcher.forward(request, response);
	}

	
}
