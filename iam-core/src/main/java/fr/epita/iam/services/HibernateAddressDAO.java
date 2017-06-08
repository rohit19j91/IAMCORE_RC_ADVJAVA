package fr.epita.iam.services;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import fr.epita.iam.datamodel.Address;

/**
 * @author Rohit Chauhan
 * @param Description: HibernateAddressDAO class extends the interface which we 
 * created and it helps in defining the function/methods which we had defined in the interface
 */

@Repository
public class HibernateAddressDAO implements Dao<Address> {

	private static final Logger LOGGER = LogManager.getLogger(HibernateAddressDAO.class);
	
	@Inject
	SessionFactory sf;
	
	public void write(Address address) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(address);
		transaction.commit();
		LOGGER.debug("=> writeAddress - Address inserted Successfully: {}", address);
		session.close();
		
	}

	public void delete(Address address) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(address);
		transaction.commit();
		LOGGER.debug("=> deleteAddress - Address Deleted Successfully: {}", address);
		session.close();
	}

	public void update(Address address) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(address);
		transaction.commit();
		LOGGER.debug("=> updateAddress - Address Updated Successfully: {}", address);
		session.close();
	}


	public List<Address> get(Address address) {
		LOGGER.debug("=> getAddress - Address list not required : {}", address);
		return null;
		}

	public List<Address> check(Address instance) {
		// Null Method
		return null;
	}
	}

