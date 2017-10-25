package league.service;

import java.sql.SQLException;

import league.model.UserT;

/**
 * @author harvey.zhao
 *
 */
public interface IUserService {
	
	/**
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public UserT getValidUser(String username, String password) throws SQLException;
	/**
	 * @param userId
	 * @return
	 */
	public UserT getUserById(int userId);
	
	/**
	 * @return
	 */
	public UserT getUserByAge();
}
