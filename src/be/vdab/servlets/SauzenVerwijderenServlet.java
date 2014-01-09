package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.dao.SauzenDAO;

/**
 * Servlet implementation class SausenVerwijderenServlet
 */
@WebServlet("/sauzenverwijderen.htm")
public class SauzenVerwijderenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String REDIRECT_URL = "/sauzen.htm";
	private final SauzenDAO sauzenDAO = new SauzenDAO();
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 if(request.getParameterValues("nummer") != null){
			 try{
				 for(String nummer : request.getParameterValues("nummer")){
					   
					 sauzenDAO.deleteSaus(Long.parseLong(nummer));
				 }
			 }
			 catch(Exception ex){
				  System.err.println(ex.getMessage());
			 }
		 }
		response.sendRedirect(request.getContextPath() + REDIRECT_URL);
	}

}
