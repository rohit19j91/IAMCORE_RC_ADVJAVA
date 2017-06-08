/**
 * 
 */
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

/**
 * @author tbrou
 *
 */

@WebServlet(name="AuthenticationServlet", urlPatterns={"/authenticate"})
public class AuthenticationServlet extends HttpServlet{
	
	
	@Autowired
	Dao<Identity> dao;
	
	
	private static final long serialVersionUID = 1L;
	
	
	private static final Logger LOGGER = LogManager.getLogger(AuthenticationServlet.class);
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		LOGGER.info("dao instance is : {}", dao);
		String login = req.getParameter("email");
		String password = req.getParameter("pwd");
		
		LOGGER.info("tried to authenticate with this login {}", login);
		RequestDispatcher rd=null;
		Identity identity=new Identity();
		identity.setEmail(login);
		identity.setPassword(password);
		List<Identity> ids = dao.check(identity);
//Checking if the entered login, password is correct or not
			if (ids.size()==0 || login == null ||password == null)
			{
				LOGGER.info("The login or password is not valid {}", login,password);
				req.getSession().setAttribute("msg", "Invalid Login/Password");
				rd = req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
			} 
//Directing the user to the welcome page if the login is successful
			else 
			{
				LOGGER.info("The login is successful{}", login);
				req.getSession().setAttribute("flag", "Logged in Successfully");
				req.getSession().setAttribute("name", ids.get(0).getDisplayName());
				rd=req.getRequestDispatcher("welcome.jsp"); 
				rd.forward(req, resp);
			}
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  
			{
		//Re-directing the request to the Login page
		 req.getRequestDispatcher("login.jsp");
			}
}
