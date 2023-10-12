package com.telusko.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servletDispatch1")
public class servletDispatch1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 @Override
		public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	System.out.println("request received 2nd dispatcher");
	    	
	    	response.sendRedirect("/servletRequestDispatch/second.html");
	    	
		}
}
