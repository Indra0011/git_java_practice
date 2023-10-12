package com.telusko.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/req2")
public class req2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		
		//getting old session object for same user
		HttpSession session = request.getSession(false);
		
		if(session == null)
		{
			pw.println("This is a new session and no session information is available");
		}
		else
		{
			Enumeration<String> attnames = session.getAttributeNames();
			
			while (attnames.hasMoreElements())
			{
				String name = attnames.nextElement();
				Object value = session.getAttribute(name);
				pw.println(name + " "+value);
				
			}
			
		}
		
	}

}
