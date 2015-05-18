package com.neo.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/users/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		try{
			User.login(userId, password);
			session.setAttribute("loginId", userId);
			
			response.sendRedirect("/");
		} catch (UserNotFoundException e){
			forwardError(request, response, "존재하지 않는 사용자입니다. 다시 로그인하세요.");
		} catch (PasswordMismatchException e) {
			forwardError(request, response, "비밀번호가 틀립니다.. 다시 로그인하세요.");	
		}

	}

	private void forwardError(HttpServletRequest request,
			HttpServletResponse response, String errorMessage) throws ServletException, IOException {
		request.setAttribute("errorMessage", errorMessage );	
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
	}

}
