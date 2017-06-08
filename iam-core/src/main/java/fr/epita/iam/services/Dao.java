/**
 * 
 */
package fr.epita.iam.services;

import java.util.List;

/**
 * @author Rohit Chauhan
 * @param Description: Its the interface for performing the CRUD operations on the Identities and the address of it.
 */
public interface Dao<T> {
	
	public void write(T instance);
	public void delete(T instance);
	public void update(T instance);
	public List<T> check(T instance);
	public List<T> get(T instance);

}
