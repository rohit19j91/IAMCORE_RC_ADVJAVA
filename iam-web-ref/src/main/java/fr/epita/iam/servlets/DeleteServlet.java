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
import fr.epita.iam.datamodel.Address;
import fr.epita.iam.services.Dao;

@WebServlet(name = "DeleteServlet", urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet{

private static final long serialVersionUID = 1L;

private static final Logger LOGGER = LogManager.getLogger(DeleteServlet.class);
	
public Long userId;
public Long addId;

	@Autowired
	Dao<Identity> dao;
	
	@Autowired
	Dao<Address> addrdao;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        RequestDispatcher rd = null;
//Fetching the UserID from the selected RadioButton 
        String id= req.getParameter("mId");
        userId=(long) Integer.parseInt(id);
        LOGGER.info("Selected records user id is : {}", userId);
//Creating the Object of the Identity Class to set the parameter
        Identity identity=new Identity();
        identity.setId(userId);
        List<Identity> updateidentity=dao.get(identity);
        LOGGER.info("Retrieved records are: {}", updateidentity);
//Retrieving the selected row from the Identity Table 
   	 	Identity user = updateidentity.get(0);
//Creating the Object of the Address Class to set the parameter
        Address address=new Address();
        addId=user.getAddress().getAddressId();
        address.setAddressId(addId);
        LOGGER.info("Address to be deleted is: {}", address);
//Deleting the Identity first as there is foreign key constraint for the Address table 
        dao.delete(identity);
        addrdao.delete(address);
        LOGGER.info("Records from Identity and Address table are deleted successfully");
        req.getSession().setAttribute("delmsg", "Record was deleted successfully");
        req.getSession().setAttribute("users", null);
        rd = req.getRequestDispatcher("listusers.jsp");
        rd.forward(req, resp);
        } 
}
