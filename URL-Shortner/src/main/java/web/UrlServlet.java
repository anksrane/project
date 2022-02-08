package web;

import java.io.*;
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
import bean.Visitor;
import dao.LinksDAO;
import dao.VisitorDAO;

@WebServlet("/")
public class UrlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public LinksDAO linksDAO;
	String longURL="";
	String shortURL="";
	String ipServer="http://checkip.amazonaws.com";

	public UrlServlet() {
		super();
	}

	public void init() throws ServletException {
		linksDAO = new LinksDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		//Handling Actions
		try {
			switch (action) {
				case "/addUrl":
					addShortenUrl(request, response);
					break;
				case "/viewList":
					listUser(request, response);
					break;
				default:
					visitLink(request, response);
					break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	//Generate Unique Short URL
	private void addShortenUrl(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		longURL = request.getParameter("longUrl");
		String currentHost = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/URL-Shortner/";
		UrlValidator urlValidator = new UrlValidator();
		if (urlValidator.isValid(longURL)) {
			LocalDateTime time = LocalDateTime.now();
			shortURL = currentHost + Hashing.murmur3_32()
					.hashString(longURL.concat(time.toString()), StandardCharsets.UTF_8).toString();
			Links newLink = new Links(longURL, shortURL);
			
			// Check Link Already In Database or Not
			LinksDAO linksDao = new LinksDAO();
			try {
				Links linkObj = linksDao.searchByLongUrl(longURL); 
				if (linkObj == null) {
					// Create new Entry
					linksDAO.insertLink(newLink);
					request.setAttribute("shortUrlInput", shortURL);
					Message msg = new Message("URL Successfully Optimized", "success");
					HttpSession s = request.getSession();
					s.setAttribute("msg", msg);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				} 
				else {
					Message msg = new Message("URL Already Exist!", "error");
					HttpSession s = request.getSession();
					s.setAttribute("msg", msg);
					request.setAttribute("shortUrlInput", linkObj.getShortUrl());
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}else {
			Message msg = new Message("Invalid URL!", "error");
			HttpSession s = request.getSession();
			s.setAttribute("msg", msg);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	
	//Fetch Long URL from Short URL
	private void visitLink(HttpServletRequest request, HttpServletResponse response) throws IOException {
		shortURL = request.getParameter("shortUrl");
		if(shortURL==null) {
			shortURL = request.getRequestURL().toString();
		}
		LinksDAO linksDao = new LinksDAO();
		try {
			Links link = linksDao.searchByShortUrl(shortURL);
			if (link != null) {
				String redirectLink = link.getLongUrl();
				// Get Ip Address of User
				URL whatismyip = new URL(ipServer);
				BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
				String ip = in.readLine(); // you get the IP as a String

				// Get Date and Time
				LocalDateTime now = LocalDateTime.now();
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String currentDate = dtf.format(now);
				DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:MM:ss");
				String currentTime = dtf2.format(now);
				System.out.println("Date: "+currentDate+" Time: "+currentTime);

				VisitorDAO usersDao = new VisitorDAO();
				Visitor newUser = new Visitor(redirectLink, shortURL, ip, currentDate,currentTime);
				usersDao.insertUser(newUser);
				response.sendRedirect(redirectLink);
			} else {
				Message msg = new Message("Optimized URL Doesn't Exist!", "error");
				HttpSession s = request.getSession();
				s.setAttribute("msg", msg);
				response.sendRedirect("error.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// List All Visitors
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		VisitorDAO usersDao = new VisitorDAO();
		List<Visitor> listUser = usersDao.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("visitor-list.jsp");
		dispatcher.forward(request, response);
	}
}
