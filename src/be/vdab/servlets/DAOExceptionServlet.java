package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DAOExceptionServlet
 */
//@WebServlet("/daoexception.htm")
public class DAOExceptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/daoexception.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
         this.getServletContext().log("database fout", throwable);
         RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(VIEW);
         dispatcher.forward(request, response);

	}

	
}

