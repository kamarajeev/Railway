package com.tcs.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.bean.BeanClass;
import com.tcs.bean.BookBean;
import com.tcs.bean.TrainBean;
import com.tcs.java.DAOClass;


/**
 * Servlet implementation class RailwayServlet
 */
@WebServlet("/RailwayServlet")
public class RailwayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RailwayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String submit=request.getParameter("submit");
		BeanClass bc=new BeanClass();
		DAOClass dao=new DAOClass();
		BookBean dc=new BookBean();
		if(submit.equals("New User")) {
			response.sendRedirect("JSP/Register.jsp");
		}else if(submit.equals("Register")) {
			String name=request.getParameter("name");
			String age=request.getParameter("age");
			String password=request.getParameter("password");
			String gender=request.getParameter("gender");
			String place=request.getParameter("place");
			bc.setAge(age);
			bc.setGender(gender);
			bc.setName(name);
			bc.setPassword(password);
			bc.setPlace(place);
			int dup=dao.insert(bc);
			request.setAttribute("value",dup);
			request.getRequestDispatcher("JSP/RegisterSuccess.jsp").forward(request, response);
		}else if(submit.equals("Login")) {
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			bc.setName(name);
			bc.setPassword(password);
			int dup=dao.login(bc);
			request.setAttribute("value",dup);
			request.setAttribute("name", bc.getName());
			request.getRequestDispatcher("JSP/BookPage.jsp").forward(request, response);		
	   }else if(submit.equals("submit")) {
		    String from=request.getParameter("from");
		    String to=request.getParameter("to");
		    String ta=request.getParameter("hid");
		    TrainBean tb=new TrainBean();
		    tb.setFrom(from);
		    tb.setTo(to);
		    ArrayList<TrainBean> dup=dao.train(tb);
		    request.setAttribute("a", dup);
			request.setAttribute("name", ta);
		    request.getRequestDispatcher("JSP/List.jsp").forward(request, response);
	}else if(submit.equals("BOOK TRAIN")) {
		String ta=request.getParameter("hid");
		request.setAttribute("name", ta);
		request.getRequestDispatcher("JSP/bookTicket.jsp").forward(request, response);
	}
	   else if(submit.equals("Book")) {
		String at=request.getParameter("select");
		String ta=request.getParameter("hid");
		request.setAttribute("name", ta);
		request.setAttribute("a", at);
	    request.getRequestDispatcher("JSP/Registertic.jsp").forward(request, response);
	}/*else if(submit.equals("CANCEL TICKET")) {
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String gender=request.getParameter("gender");
		bc.setName(name);
		bc.setAge(age);
		bc.setGender(gender);
	int dup=dao.registertic(bc);
	}*/else if(submit.equals("CHECK BOOKED STATUS")) {
		String uname=request.getParameter("hid");
		ArrayList<BookBean> tb=new ArrayList<BookBean>();
		dc.setUname(uname);
		tb=dao.bookedTrain(dc);
		request.setAttribute("arr",tb);
		request.getRequestDispatcher("JSP/Check.jsp").forward(request, response);
	}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
