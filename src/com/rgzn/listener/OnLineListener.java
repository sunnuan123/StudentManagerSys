package com.rgzn.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnLineListener implements HttpSessionListener,HttpSessionAttributeListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		
		ServletContext context = arg0.getSession().getServletContext();
	    Integer  online=	(Integer) context.getAttribute("online");
		  
	   if(online==null||online<=0){
		   
		   online=0;
	   } else {
		   online--;
	   }
		
	  context.setAttribute("online", online);
		
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		String name = arg0.getName();
		
		if("user".equals(name)){
		ServletContext context = arg0.getSession().getServletContext();
	    Integer  online=	(Integer) context.getAttribute("online");
		  
	   if(online==null){
		   
		   online=1;
	   } else {
		   
		   online++;
		   
	   }
		
	     context.setAttribute("online", online);
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		
	}

	

}
