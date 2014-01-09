package be.vdab.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.dao.SauzenDAO;
import be.vdab.entities.Saus;

/**
 * Servlet implementation class SausenZoekenServlet
 */
//@WebServlet("/sauzenzoeken.htm")
public class SauzenZoekenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/sauzenzoeken.jsp";
	private final SauzenDAO sauzenDAO = new SauzenDAO();
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		String ingredient = request.getParameter("ingredient");
		
		if(ingredient != null){
		  
			Map <String,String> fouten = new HashMap<>();
			
			if(ingredient.isEmpty()){
				fouten.put("fout", "verplicht");
			}
		    else{
				
			    List <Saus> gevondenSauzen = sauzenDAO.findSausByIngredient(ingredient);
			    if(gevondenSauzen.isEmpty()){
				  fouten.put("nietgevonden", "niet gevonden");
			    }
		
			    request.setAttribute("gevondenSauzen",gevondenSauzen);
			  
		    }
			request.setAttribute("fouten", fouten);
				
		 }
			
		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
		dispatcher.forward(request, response);
			
	}
}
