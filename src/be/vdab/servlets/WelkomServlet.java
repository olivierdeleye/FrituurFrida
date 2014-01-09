package be.vdab.servlets;


import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Adres;
import be.vdab.entities.Gemeente;



/**
 * Servlet implementation class WelkomServlet
 */
//@WebServlet(urlPatterns="/welkom.htm" ,name="welkomservlet")
public class WelkomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEUW = "/WEB-INF/JSP/welkom.jsp";
	private final Adres adres = new Adres();
	private final Gemeente gemeente = new Gemeente();


     
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    ServletContext context = this.getServletContext();
	    Calendar calendar = Calendar.getInstance();
	    int dagVanDeWeek = calendar.get(Calendar.DAY_OF_WEEK);
	    
		gemeente.setNaam(context.getInitParameter("gemeente"));
		gemeente.setPostCode(Integer.valueOf(context.getInitParameter("postcode")));
		adres.setStraat(context.getInitParameter("straat"));
		adres.setHuisNr(context.getInitParameter("huisnr"));
		adres.setGemeente(gemeente);
		
        request.setAttribute("adres", adres);
        request.setAttribute("openGesloten", (dagVanDeWeek == Calendar.THURSDAY)
        	                  || (dagVanDeWeek == Calendar.MONDAY)?"gesloten":"open");
		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEUW);
		dispatcher.forward(request, response);
	}
	
	

}
