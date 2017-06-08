/**
 * 
 */
package fr.epita.iam.services;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import fr.epita.iam.datamodel.Identity;

/**
 * @author Rohit Chauhan
 * @param Description: HibernateDAO class extends the interface which we 
 * created and it helps in defining the function/methods which we had defined in the interface
 */
@Repository
public class HibernateDAO implements Dao<Identity>{
	
	private static final Logger LOGGER = LogManager.getLogger(HibernateDAO.class);

	@Inject
	SessionFactory sf;
	
	
	
	public void write(Identity identity){
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(identity);
		transaction.commit();
		LOGGER.debug("=> writeIdentity : Identity Inserted Successfully : {}", identity);
		session.close();
	}
	
	public void update(Identity identity){
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(identity);
		transaction.commit();
		LOGGER.debug("=> UpdatedIdentity - Identity Updated Successfully: {}", identity);
		session.close();
	}
	 
	public void delete(Identity identity){
		
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(identity);
		transaction.commit();
		LOGGER.debug("=> DeleteIdentity - Identity Deleted Successfully: {}", identity);
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Identity> check(Identity identity) {
		Session session=sf.openSession();
		String queryString = "from Identity as identity where identity.email = :email and identity.password= :password";
		Query query = session.createQuery(queryString);
		query.setParameter("email",  identity.getEmail());
		query.setParameter("password",identity.getPassword());
		List<Identity> identitylist = query.list();
		LOGGER.debug("=> CheckIdentity - Record matches the database: {}", identitylist);
		session.close();
		return identitylist;
	}

	@SuppressWarnings("unchecked")
	public List<Identity> get(Identity identity) {
		Session session = sf.openSession();
		String queryString = "from Identity as identity where identity.displayName like :name OR identity.id= :id ";
		Query query = session.createQuery(queryString);
		query.setParameter("name",identity.getDisplayName()+"%");
		query.setParameter("id",identity.getId());
		List<Identity> identityList = query.list();
		LOGGER.debug("=> getIdentity - List of Identities : {}", identityList);
		session.close();
		return identityList;
	}

}
