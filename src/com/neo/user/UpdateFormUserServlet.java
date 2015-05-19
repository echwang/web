package com.neo.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateFormUserServlet
 */
@WebServlet("/user/UpdateFormUserServlet")
public class UpdateFormUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFormUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Object userId = request.getSession().getAttribute("loginId");
		
		if(userId == null){
			response.sendRedirect("/");
			return;
		}
		
		
		
		String loginId = (String) userId;
		
		UserDao userDao = new UserDao();
		User user = null;
		try {
			user = userDao.findByUserId(loginId);
			request.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("/update_form.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
