package fr.epita.iam.servlets;

import java.io.IOException;
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

import fr.epita.iam.datamodel.Address;
import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.services.Dao;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = LogManager.getLogger(RegisterServlet.class);
	
	@Autowired
	Dao<Identity> dao;
	
	@Autowired
	Dao<Address> adddao;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        RequestDispatcher rd = null;
        String uid=req.getParameter("UID");
        String name = req.getParameter("name");
        String password = req.getParameter("pwd");
        String rpassword = req.getParameter("rpwd");
        String email = req.getParameter("email");
     //Checking if the entered password and re-type password matches or not on the register page
        if (! password.equals(rpassword)){
        	LOGGER.info("Passwords are not matching ");
            req.setAttribute("msg", "Password doesn't match, please confirm your password.");
            //Forwarding the request back to the register page
            rd = req.getRequestDispatcher("register.jsp");
            rd.forward(req, resp);
        }
        String street=req.getParameter("street");
        String city=req.getParameter("city");
        String country=req.getParameter("country");
        String zipcode=req.getParameter("zipcode");
        //Adding a new Identity and Address by creating an instance of the objects
        Identity identity = new Identity(uid, name, email, password);
        Address address=new Address(street,city,country,zipcode);
        adddao.write(address);
        LOGGER.info("Address was added successfully: {}", address);
        identity.setAddress(address);
        dao.write(identity);
        LOGGER.info("Identity was added successfully: {}", identity);
        req.setAttribute("regmsg", "User registered successfully");
        rd = req.getRequestDispatcher("register.jsp");
        rd.forward(req, resp);
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//Re-directing the request to the above post method
        doPost(request,response);
    }
}
