/**
 * 
 */
package fr.epita.iam.datamodel;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Rohit Chauhan
 * Description: Identity is the part of the datamodel package. It helps in creating the structure of the Identity table.
 *
 */
@Entity
@Table(name="ADDRESS")
public class Address   {
	
	
	public Address() {
	}

	public Address(String street, String city, String country, String zipcode) {
		this.street = street;
		this.city = city;
		this.country = country;
		this.zipcode = zipcode;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ADDRESS_ID")
	private long addressId;
	
	@Column(name = "ADDRESS_STREET")
	private String street;

	@Column(name = "ADDRESS_CITY")
	private String city;
	
	@Column(name = "ADDRESS_COUNTRY")
	private String country;
	
	@Column(name = "ADDRESS_ZIPCODE")
	private String zipcode;
	
	
	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public long getId() {
		return addressId;
	}
	
	@Override
	public String toString() {
		return "Address [ Identity ID = "+"Street=" + street + ", City=" + city + ", Country=" + country + "Zipcode= "+zipcode+"]";
	}

}

