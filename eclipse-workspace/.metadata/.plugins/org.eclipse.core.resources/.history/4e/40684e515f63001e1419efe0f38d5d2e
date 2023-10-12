package com.telusko.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class req1
 */
@WebServlet("/req1")
public class req1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		//gettting session object , to track information of client request
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		if(session.isNew())
		{
			pw.println("New session is created with id :" + session.getId());
		}
		else
		{
			pw.println("Old session id: "+session.getId());
		}
		
		// retrieve the data from the client
		String name = request.getParameter("Name");
		String value = request.getParameter("Value");
		
		// to store above information in session object
		session.setAttribute(name, value);
		
		//to specify session timeout(maximum active time)
		session.setMaxInactiveInterval(60);
		
		//send response to client
		request.getRequestDispatcher("index.html").include(request, response);
		
		pw.close();
	}

}
