package be.vdab.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Application Lifecycle Listener implementation class RequestUrlListener
 *
 */

public class RequestUrlListener implements ServletRequestListener,ServletContextListener {

	//private static final String STATISTIEKEN = "statistieken";
	//private static final List<String>EXTENSIES = new ArrayList<>(Arrays.asList("png","css","jpg","js"));
	

	public RequestUrlListener() {
		
	}
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		//event.getServletContext().setAttribute(STATISTIEKEN, new ConcurrentHashMap<String,Integer>());
		
	}
	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    @Override
	public void requestDestroyed(ServletRequestEvent event) {
    	
    	/**if (event instanceof HttpServletRequest) {
       	 HttpServletRequest request = (HttpServletRequest)event.getServletRequest();
            verwijderRequestUrl(request);
            
       	 }**/
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    
  
    @Override
	public void requestInitialized(ServletRequestEvent event) {
    	/** if (event.getServletRequest() instanceof HttpServletRequest) {
    	   HttpServletRequest request = (HttpServletRequest)event.getServletRequest();
           voegRequestUrlToe(request);
           
    	    } **/
    	    
     }
    
  /**  public synchronized void voegRequestUrlToe(HttpServletRequest request) {
    	
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
    }**/
    
    @Override
	public void contextDestroyed(ServletContextEvent event) {
		
		
	}
   /** public synchronized void verwijderRequestUrl(HttpServletRequest request) {
    	
    	@SuppressWarnings("unchecked")
		Map<String,Integer>statistieken = (Map<String,Integer>)request.getServletContext().getAttribute(STATISTIEKEN);
    	String url = request.getRequestURI();
    	
    	statistieken.remove(url);
    	request.getServletContext().setAttribute(STATISTIEKEN, statistieken);
	 
    		
    	}**/
	
	
    	
    
	
}
