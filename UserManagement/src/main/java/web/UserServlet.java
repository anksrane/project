package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Message;
import bean.User;
import dao.UserDAO;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	public void init() throws ServletException {
		userDAO=new UserDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/view":
				showViewForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			case "/login":
				loginUser(request, response);
				break;
			case "/logout":
				logout(request, response);
				break;
			case "/search":
				search(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	//New Form
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}
	//Insert user
	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		User newUser = new User(name, email, password,role);
		userDAO.insertUser(newUser);
		response.sendRedirect("list");
	}
	//Delete User
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			userDAO.deleteUser(id);
			response.sendRedirect("list");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//Edit User
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser;
		try {
			existingUser=userDAO.selectUser(id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
			request.setAttribute("user", existingUser);
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//View User
	private void showViewForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser;
		try {
			existingUser=userDAO.selectUser(id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("user-view.jsp");
			request.setAttribute("user", existingUser);
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//Update User
	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");

		User user = new User(id, name, email, password,role);
		userDAO.updateUser(user);
		response.sendRedirect("list");
	}
	//Login User
	private void loginUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		UserDAO userDao=new UserDAO();
		
		User u=userDao.validate(email, password);
		
		if(u==null) {
			//login Error
//			out.println("Invalid Login Details... Please try again");
			Message msg=new Message("Invalid Details! Please try Again","error");
			HttpSession s=request.getSession();
			s.setAttribute("msg", msg);
			response.sendRedirect("login.jsp");
		}
		else {
			System.out.println("Login Servlet User is Not Null");
			HttpSession session=request.getSession();
			session.setAttribute("currentUser",u);
			response.sendRedirect("list");
		}
	}
	//Logout User
	private void logout(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {

		HttpSession session=request.getSession();
		session.removeAttribute("currentUser");
		response.sendRedirect("login.jsp");
	}
	//default list
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		try {
			String find=request.getParameter("search");
			List<User> listUser = userDAO.selectAllUsers();
			request.setAttribute("listUser", listUser);
			RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//Search List
	private void search(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
}
