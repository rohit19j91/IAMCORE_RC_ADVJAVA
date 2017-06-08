package fr.epita.iam.servlets;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.services.Dao;

@WebServlet(name="UsersServlet", urlPatterns={"/users"})
public class UsersServlet extends HttpServlet{

	@Autowired
	Dao<Identity> dao;
	
	private static final long serialVersionUID = 1L;
	
	
	private static final Logger LOGGER = LogManager.getLogger(UsersServlet.class);
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		RequestDispatcher rd=null;
		//Setting the delmsg attribute to null so that it does not retain the message once the page has been changed or refreshed
		req.getSession().setAttribute("delmsg",null);
		req.getSession().setAttribute("srcmsg",null);
		Identity identity=new Identity();
		String name=req.getParameter("name");
		identity.setDisplayName(name);
		LOGGER.info("Users is searching for : {}",name);
		//Fetching the search result from the search page which the user has entered
		List<Identity> users=dao.get(identity);
		if(users.size()!=0||req.getParameter("search")!=null||req.getParameter("cancel")!=null)
		{
		LOGGER.info("The fetched results are : {}",users);
		req.getSession().setAttribute("users", users);
		 rd = req.getRequestDispatcher("listusers.jsp");
         rd.forward(req, resp);
		}
		else 
		{
		LOGGER.info("There are no results to be fetched");
		Object check=req.getAttribute("welcome");
		System.out.println(check);
		req.getSession().setAttribute("srcmsg", "Sorry, No results found !");
		req.getSession().setAttribute("users", users);
		 rd = req.getRequestDispatcher("listusers.jsp");
         rd.forward(req, resp);
		}
}
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Re-directing the request to the above post method
	        doPost(request,response);
	    }
}
	
