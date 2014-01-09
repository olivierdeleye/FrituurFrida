package be.vdab.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class ServletFilter
 */
//@WebFilter("*.htm")
public class ServletFilter implements Filter {
	
	private static final List<String>EXTENSIES = new ArrayList<>(Arrays.asList("png","css","jpg","js","htm"));
	private static final String STATISTIEKEN = "statistieken";

    /**
     * Default constructor. 
     */
    public ServletFilter() {
        
    }

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		voegRequestUrlToe(httpRequest);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		filterConfig.getServletContext().setAttribute(STATISTIEKEN, new ConcurrentHashMap<String,Integer>());
		
	}
	
	 public synchronized void voegRequestUrlToe(HttpServletRequest request) {
	    	
	    	@SuppressWarnings("unchecked")
			Map<String,Integer>statistieken = (Map<String,Integer>)request.getServletContext().getAttribute(STATISTIEKEN);
	    	if(statistieken != null) {
	    		
	    	  String url = request.getRequestURI();
	    	  int index = url.indexOf(";jsessionid=");
	    	  
	    	   if (index != -1) {
	    		   url = url.substring(0,index);
	    	   }
	    	   String extensie= null;
	    	   int indexPunt = url.lastIndexOf(".");
	    	   if(indexPunt != -1) {
	    	      extensie = url.substring(indexPunt +1).toLowerCase();
	    	   }
	    	   if (!EXTENSIES.contains(extensie)) {
	    	        if(statistieken.containsKey(url)) {
	    		       statistieken.put(url, statistieken.get(url) + 1);
	    	         }
	    	        else {
	    		        statistieken.put(url, 1);
	    	         }
	   	         }
	    	   }
	    	
	    	
	    	request.getServletContext().setAttribute(STATISTIEKEN,statistieken);
	    }

}
