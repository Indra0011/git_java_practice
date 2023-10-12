package com.telusko.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.telusko.model.Model;


@WebServlet({ "/Login", "/login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("Name");
		String password = request.getParameter("Password");
		
		boolean success = Model.fetch(name, password);
		PrintWriter pw = response.getWriter();
		if(success)
		{
			pw.println("Successfull");
		}
		else
		{
			pw.println("Failure");
		}
		
		
		
	}

}
