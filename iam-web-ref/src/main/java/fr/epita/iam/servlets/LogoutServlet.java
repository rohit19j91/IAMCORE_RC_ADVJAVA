package fr.epita.iam.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(name = "LogoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {


	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = LogManager.getLogger(LogoutServlet.class);
		@Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//Helps in invalidating the session and kicking out the user
	        request.getSession().invalidate();
	        response.sendRedirect(request.getContextPath() + "login.jsp");
	        LOGGER.info("The User was logged out successfully");
	    }

		 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//Helps in invalidating the session and kicking out the user
			 request.getSession().invalidate();
		        response.sendRedirect(request.getContextPath() + "login.jsp");
		        LOGGER.info("The User was logged out successfully");
		    }
	}
