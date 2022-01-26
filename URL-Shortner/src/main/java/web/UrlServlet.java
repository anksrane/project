package web;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.validator.routines.UrlValidator;

import com.google.common.hash.Hashing;

import bean.Links;
import bean.Message;
import bean.Users;
import dao.LinksDAO;
import dao.UsersDAO;

@WebServlet("/")
public class UrlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LinksDAO linksDAO;
	private UsersDAO usersDAO;
	

	public UrlServlet() {
		super();
	}

	public void init() throws ServletException {
		linksDAO = new LinksDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
//		doGet(request, response);
		String action = request.getServletPath();
		if(!action.equals("/addurl")&&!action.equals("/visitLink")&&!action.equals("/viewList")) {
			visitLinkByUrl(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		
		if(action.equals("/addUrl")) {
			addShortenUrl(request, response);
		} else if (action.equals("/visitLink")) {
			visitLink(request, response);
		} else if (action.equals("/viewList")) {
			try {
				listUser(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//Visit URL By Link
	private void visitLinkByUrl(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String ShortURL=request.getRequestURL().toString();
		LinksDAO linksDao = new LinksDAO();
		
		try {
			Links l = linksDao.searchByShortUrl(ShortURL);
			if (l != null) {
				String redirectLink = l.getLongUrl();
				// Get Ip Address of User
				URL whatismyip = new URL("http://checkip.amazonaws.com");
				BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
				String ip = in.readLine(); // you get the IP as a String

				// Get Date and Time
				LocalDateTime now = LocalDateTime.now();
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String currentDate = dtf.format(now);
				DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:MM:ss");
				String currentTime = dtf2.format(now);

				UsersDAO usersDao = new UsersDAO();
				Users newUser = new Users(redirectLink,ShortURL, ip, currentDate, currentTime);
				usersDao.insertUser(newUser);
				response.sendRedirect(redirectLink);
			} else {
				Message msg = new Message("Page Not Found!", "error");
				HttpSession s = request.getSession();
				s.setAttribute("msg", msg);
				response.sendRedirect("Error.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//Create Short URL
	private void addShortenUrl(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String LongURL = request.getParameter("longUrl");
		String ShortURL = "";
		String currentHost = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/URL-Shortner/";
		UrlValidator urlValidator = new UrlValidator(new String[] { "http", "https" });
		if (urlValidator.isValid(LongURL)) {
			LocalDateTime time = LocalDateTime.now();
			System.out.println("Time is: "+time);
			ShortURL = currentHost + Hashing.murmur3_32()
					.hashString(LongURL.concat(time.toString()), StandardCharsets.UTF_8).toString();
			
			Links newLink = new Links(LongURL, ShortURL);
			// Check Link Already In Database or Not
			LinksDAO linksDao = new LinksDAO();
			try {
				Links linkObj = linksDao.searchByLongUrl(LongURL); 
				if (linkObj == null) {
					// Create new Entry
					linksDAO.insertLink(newLink);
					request.setAttribute("shortUrlInput", ShortURL);
					Message msg = new Message("URL Successfully Shorten", "success");
					HttpSession s = request.getSession();
					s.setAttribute("msg", msg);
					request.getRequestDispatcher("index.jsp").forward(request, response);
					System.out.println("New URL Inserted: " + ShortURL);
				} 
				else {
					System.out.println("URL Already Exist");
					Message msg = new Message("URL Already Exist", "error");
					HttpSession s = request.getSession();
					s.setAttribute("msg", msg);
					linkObj = linksDao.searchByLongUrl(LongURL);
					request.setAttribute("shortUrlInput", linkObj.getShortUrl());
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}else {
			Message msg = new Message("Invalid URL", "error");
			HttpSession s = request.getSession();
			s.setAttribute("msg", msg);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	
	//Visit Short URL
	private void visitLink(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String ShortURL = request.getParameter("shortUrl");
		LinksDAO linksDao = new LinksDAO();
		try {
			Links l = linksDao.searchByShortUrl(ShortURL);
			if (l != null) {
				String redirectLink = l.getLongUrl();
				// Get Ip Address of User
				URL whatismyip = new URL("http://checkip.amazonaws.com");
				BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
				String ip = in.readLine(); // you get the IP as a String

				// Get Date and Time
				LocalDateTime now = LocalDateTime.now();
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String currentDate = dtf.format(now);
				DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:MM:ss");
				String currentTime = dtf2.format(now);

				UsersDAO usersDao = new UsersDAO();
				Users newUser = new Users(redirectLink, ShortURL, ip, currentDate,currentTime);
				usersDao.insertUser(newUser);
				response.sendRedirect(redirectLink);
			} else {
				Message msg = new Message("Short URL Doesn't Exist", "error");
				HttpSession s = request.getSession();
				s.setAttribute("msg", msg);
				response.sendRedirect("Error.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// List with Search
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
//			List<Users> listUser=usersDAO.selectAllUsers(find);
		UsersDAO usersDao = new UsersDAO();
		List<Users> listUser = usersDao.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("visitor-list.jsp");
		dispatcher.forward(request, response);
	}

}
