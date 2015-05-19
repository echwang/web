package com.neo.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import com.neo.support.MyValidatorFactory;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/users/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
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
		Object object = request.getParameter("userId");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		

		
		HttpSession session = request.getSession();
		
		if(object == null){
			System.out.println("object null");
			response.sendRedirect("/");
			return;
		}
		
		if(SessionUtils.isEmpty(session, "loginId")) {
			System.out.println("session empty");
			response.sendRedirect("/");
			return;			
		}
		
		String userId = (String)object;
		String loginId = SessionUtils.getStringValue(session, "loginId");
		if(!loginId.equals(userId)){
			System.out.println("user different");
			response.sendRedirect("/");
			return;
		}

		User user = new User(userId, password, name, email);
		
		System.out.println(user.toString());
		
		Validator validator = MyValidatorFactory.createValidator();
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
		if(constraintViolations.size() > 0) {
			request.setAttribute("user", user);
			forwardJSP(request, response, constraintViolations.iterator().next().getMessage());
			return;
		}
		
		UserDao userDao = new UserDao();
		try {
			userDao.updateUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("/");
	}
	

	private void forwardJSP(HttpServletRequest request,
			HttpServletResponse response, String errorMessage) throws ServletException, IOException {
		request.setAttribute("errorMessage", errorMessage );	
		RequestDispatcher rd = request.getRequestDispatcher("/update_form.jsp");
		rd.forward(request, response);
	}

}
