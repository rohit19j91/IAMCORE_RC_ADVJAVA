/**
 * 
 */
package fr.epita.iam.datamodel;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * @author Rohit Chauhan
 * Description: Address is the part of the datamodel package. It helps in creating the structure of the Address table.
 *
 */
@Entity
@Table(name="IDENTITIES")
public class Identity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IDENTITIES_ID")
	private long id;

	@Column(name="IDENTITIES_UID")
	private String uid;
	
	@Column(name="IDENTITIES_DISPLAYNAME")
	private String displayName;
	
	@Column(name="IDENTITIES_EMAIL")
	private String email;

	@Column(name="IDENTITIES_PASS")
	private String password;

	@ManyToOne
	private Address address;


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	/**
	 * Default constructor
	 */
	public Identity() {
		
	}
	
	
	/**
	 * @param uid
	 * @param displayName
	 * @param email
	 */
	public Identity(String uid, String displayName, String email,String password) {
		this.uid = uid;
		this.displayName = displayName;
		this.email = email;
		this.password=password;
	}
	
	
	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}
	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @param password to get
	*/
	public String getPassword() {
		return password;
	}
	
	/**
	 * @param email the email to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Identity [uid=" + uid + ", displayName=" + displayName + ", email=" + email + "]";
	}


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @set the id
	 */
	public void setId(long id) {
		this.id = id;
	}

}