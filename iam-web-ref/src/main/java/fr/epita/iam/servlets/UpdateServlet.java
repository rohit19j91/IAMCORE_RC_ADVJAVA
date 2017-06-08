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

import fr.epita.iam.datamodel.Address;
import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.services.Dao;

@WebServlet(name = "UpdateServlet", urlPatterns = "/update")
public class UpdateServlet extends HttpServlet{

private static final long serialVersionUID = 1L;

private static final Logger LOGGER=LogManager.getLogger(UpdateServlet.class);

public Long userId; 
public Long addId;
public String pass;
RequestDispatcher rd = null;

	@Autowired
	Dao<Identity> dao;
	
	@Autowired
	Dao<Address> addrdao;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		//Setting the updmsg attribute to null so that it does not retain the message once the page has been changed or refreshed
		req.getSession().setAttribute("updmsg",null);
		RequestDispatcher rd = null; 
        String val = req.getParameter("mId"); 
        userId=(long) Integer.parseInt(val);
        	System.out.print("The Value of ID of the selected record is ="+val); 
        	//Creating the Object of the Identity Class to set the parameter
        	Identity identity=new Identity();
        	identity.setId(userId);
        	//Retrieving the selected row from the Identity Table 
        	List<Identity> updateidentity=dao.get(identity);
            LOGGER.info("Retrieved records are: {}", updateidentity);
          //Retrieving the selected row from the Identity Table
        	 Identity user = updateidentity.get(0);
        	 pass=user.getPassword();
        	 addId=user.getAddress().getAddressId();
        	 LOGGER.info("Address Id is retrieved here: {}", addId);
        	 req.getSession().setAttribute("userupdate", updateidentity);
        	rd = req.getRequestDispatcher("update.jsp");
        	rd.forward(req, resp);
}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid=req.getParameter("uid");
        String name = req.getParameter("name");
        String email = req.getParameter("ema");
        String street= req.getParameter("street");
        String city= req.getParameter("city");
        String country= req.getParameter("country");
        String zipcode= req.getParameter("zipcode");
//Setting the Identity text labels with the appropriate selected user value
        Identity identity=new Identity();
        identity.setUid(uid);
        identity.setDisplayName(name);
        identity.setEmail(email);
        identity.setId(userId);
        identity.setPassword(pass);      
        LOGGER.info("Selected Identity records are: {}", identity);
//Setting the Address text labels with the appropriate selected user value    
        Address address=new Address();
        address.setAddressId(addId);
        address.setStreet(street);
        address.setCity(city);
        address.setCountry(country);
        address.setZipcode(zipcode);
        LOGGER.info("Selected Address records are: {}", address);
//Updating the Address table with the updated values
        addrdao.update(address);
        LOGGER.info("Selected Address records are updated successfully: {}", address);
//Setting the updated Address value in the Identity
        identity.setAddress(address);
//Updating the Identity table with the updated values
    	dao.update(identity);
    	LOGGER.info("Selected Identity records are updated successfully: {}", identity);
        req.getSession().setAttribute("updmsg", "The Update was carried out successfully");
        System.out.println("Update successfully completed");
        //Passing the updated values to the list user page where the latest updated record will be displayed at the search results
        List<Identity> updateidentity=dao.get(identity);
   	 	req.getSession().setAttribute("userupdate", updateidentity);
    	rd = req.getRequestDispatcher("update.jsp");
    	rd.forward(req, resp);
}

	}