package be.vdab.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StatistiekServlet
 */
//@WebServlet("/statistieken.htm")
public class StatistiekServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/statistieken_url.jsp";
       
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		@SuppressWarnings("unchecked")
		Map<String,Integer>statistiek = (Map<String,Integer>)this.getServletContext().getAttribute("statistieken");
		
		if (statistiek == null) {
			request.setAttribute("fout", "er werd geen statistiekenmap aangemaakt");
		}
		RequestDispatcher dispachter = request.getRequestDispatcher(VIEW);
		dispachter.forward(request, response);
	}

	

}
;