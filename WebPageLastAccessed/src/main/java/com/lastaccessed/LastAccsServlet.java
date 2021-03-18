package com.lastaccessed;

import java.io.*;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;

public class LastAccsServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		int i=Integer.parseInt(req.getParameter("num1"));
		int j=Integer.parseInt(req.getParameter("num2"));
		int k=i+j;
		
		PrintWriter out=res.getWriter();
		out.println("<h1> The result is "+k+"</h1>");
		
		HttpSession hs=req.getSession(true);
		if(hs.isNew()) {
			out.println("<h1> A new session is created </h1>");
		}
		
		Date date=new Date(hs.getLastAccessedTime());
		if(date!=null) {
			out.println("<h2> Last access date and time is "+date+"</h2>");
		}
		
		Date d=new Date();
		hs.getAttribute("d");
		out.println("<h2> Current Session is "+d+"</h2>");
	}

}
