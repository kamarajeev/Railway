package com.tcs.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.tcs.bean.BookBean;

import com.tcs.java.DAOClass;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookBean bc=new BookBean();
		DAOClass dao=new DAOClass();
		String submit=request.getParameter("submit");
		if(submit.equals("Confirm")) {
			String name=request.getParameter("name");
			String age=request.getParameter("age");
			String gender=request.getParameter("gender");
			String trainname=request.getParameter("hide");
			String uname=request.getParameter("hid");
			System.out.println(uname+trainname);
			bc.setAge(age);
			bc.setGender(gender);
			bc.setName(name);
			bc.setTrainName(trainname);
			bc.setUname(uname);
			int kt=dao.trainnm(bc);
			request.setAttribute("a", kt);
			request.getRequestDispatcher("JSP/BookSuccess.jsp").forward(request, response);
		}else if(submit.equals("Cancel")) {
			String name=request.getParameter("train");
			String seat=request.getParameter("seat");
			System.out.println(name+seat);
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
