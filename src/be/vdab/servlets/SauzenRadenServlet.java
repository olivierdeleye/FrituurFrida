package be.vdab.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.vdab.dao.SauzenDAO;
import be.vdab.entities.Saus;
import be.vdab.entities.SauzenRaden;

/**
 * Servlet implementation class SauzenRadenServlet
 */
//@WebServlet("/sauzenraden.htm")
public class SauzenRadenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/sauzenraden.jsp";
	private static final String REDIRECT_URL = "/sauzenraden.htm";
	private final SauzenDAO sauzenDAO = new SauzenDAO();
	private SauzenRaden sauzenRaden;
      
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if (session.getAttribute("sauzenRaden") == null){
		
			Iterable<Saus> sauzen = sauzenDAO.findAll();
			List<Saus> sauzenlijst = new ArrayList<>();
			for (Saus saus : sauzen){
				sauzenlijst.add(saus);
			}
			Random generator = new Random();
			int randomGetal = generator.nextInt(sauzenlijst.size());
		    Saus saus = sauzenlijst.get(randomGetal);
		    sauzenRaden = new SauzenRaden(saus.getNaam());
			session.setAttribute("sauzenRaden", sauzenRaden);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (request.getParameter("Nieuw") != null){
		 
			 session.removeAttribute("sauzenRaden");
			
		}
		else {
			    String letter = request.getParameter("letter");
				SauzenRaden sauzenRaden = (SauzenRaden)session.getAttribute("sauzenRaden");
				
				if((sauzenRaden != null) && (letter != null) && !letter.isEmpty()){
				sauzenRaden.checkLetter(letter.charAt(0));
				session.setAttribute("sauzenRaden", sauzenRaden);
				}
	   }
	response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+REDIRECT_URL));
	}

}
