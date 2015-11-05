package regi.hazi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.kepzes.java.common.UserDTO;

public class RegistrationUtilImpl implements RegistrationUtil {

	@Override
	public void saveRegistration(UserDTO user) {

		PreparedStatement insertUser = null;

		String insertUserString = "INSERT INTO registration"
				+ "(username,"
				+ "fullname,"
				+ "password,"
				+ "email)"
				+ " VALUES " + "(?," + "?," + "?," + "?)";
		Connection conn = null;
		try {
			
			ConnectionUtil connection = new ConnectionUtil();
			conn = connection.getConnection();
			System.out.println("Inserting...");
			insertUser = conn.prepareStatement(insertUserString);
			insertUser.setString(1, user.getUserName());
			insertUser.setString(2, user.getFullName());
			insertUser.setString(3, user.getPassword());
			insertUser.setString(4, user.geteMail());
			//insertUser.setString(5, user.getBornDate());
			//insertUser.setString(6, user.getBornPlace());
			System.out.println("executeUpdate()!");
			insertUser.execute();
			System.out.println("Commit()!");
			System.out.println("Record is inserted into DBUSER table!");
		} catch (SQLException e) {
				System.out.println("SQL exception: " + e.getMessage());
				
		} finally {
			if (insertUser != null) {
				try {
					insertUser.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void queryUsers() {
		String preparedQuery = "SELECT * from registration";
		PreparedStatement prePared = null;
		Connection conn = null;
		ArrayList<UserDTO> userList = new ArrayList<UserDTO>();
		
		try {
			ConnectionUtil connection = new ConnectionUtil();
			conn = connection.getConnection();
			prePared = conn.prepareStatement(preparedQuery);                         
			ResultSet rs = prePared.executeQuery(); 
            while(rs.next()){ 
            	UserDTO u = new UserDTO(
            			rs.getString("username").trim(),
            			rs.getString("password").trim(),
            			rs.getString("fullname").trim(),
            			rs.getString("email").trim(),
            			"0",
            			//rs.getString("birthplace").trim(),
            			"0"
            			//rs.getString("birthdate").trim()
            			);
            	userList.add(u);
            }          
            
            for(UserDTO u: userList) {
    			System.out.println(u.getUserName() + " " + u.getUserName() + "\n");
    		}
			
            prePared.close();                           
		} catch (SQLException e) {
				System.out.println("SQL exception: " + e.getMessage());
				
		} finally {
			if (prePared != null) {
				try {
					prePared.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public ArrayList<UserDTO> getAllUsertoJSON(int start, int length, String search, String orderBy, String orderByMode) {
		//System.out.println("Szelektálás kezdete");
		String preparedQuery = "SELECT * from registration";
		String searchString = "%";
		PreparedStatement prePared = null;
		String orderEr;
		switch(orderBy) {
			case "0":
				orderEr = "username";
				break;
			case "1":
				orderEr = "fullname";
				break;
			case "2":
				orderEr = "email";
				break;
			default:
				orderEr = "username";
				break;
		}
		preparedQuery += " WHERE username LIKE ? or fullname LIKE ? or email LIKE ?" ;
		preparedQuery += " ORDER BY "+ orderEr + " " + orderByMode+  " " ;
		preparedQuery += " LIMIT ?, ?";
		
		Connection conn = null;
		ArrayList<UserDTO> userList = new ArrayList<UserDTO>();
		
		try {
			//System.out.println("Csatlakozás");
			ConnectionUtil connection = new ConnectionUtil();
			conn = connection.getConnection();
			prePared = conn.prepareStatement(preparedQuery);			
			prePared.setString(1, searchString);
			prePared.setString(2, searchString);
			prePared.setString(3, searchString);
			prePared.setInt(4, start);
			prePared.setInt(5, length);
			
			//System.out.println(prePared.toString());
			ResultSet rs = prePared.executeQuery(); 
			//System.out.println("Adatok RS-be olvasása.");
            while(rs.next()){ 
            	UserDTO u = new UserDTO(
            			rs.getString("username").trim(),
            			rs.getString("password").trim(),
            			rs.getString("fullname").trim(),
            			rs.getString("email").trim(),
            			"0",
            			"0"
            			//rs.getString("birthplace").trim() == null?"0":rs.getString("birthplace").trim(),
            			//rs.getString("birthdate").trim() == null?"0":rs.getString("birthdate").trim()
            			);
            	userList.add(u);
            }                                                                  

            rs.close();                                                               
            prePared.close();                           
		} catch (SQLException e) {
				System.out.println("SQL exception: " + e.getMessage());
				
		} finally {
			if (prePared != null) {
				try {
					prePared.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//System.out.println("Megtörtént az SQL lekérés és most a JSON generálás folyik.");
        return userList;
       
       
	}

	@Override
	public UserDTO findUserByName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean alreadyUser(String username) {
		boolean already = false;
		String preParedQuery = "SELECT username FROM registration WHERE username = ? ";
		
		PreparedStatement prePared = null;
		
		Connection conn = null;
		
		try {
			ConnectionUtil connection = new ConnectionUtil();
			conn = connection.getConnection();
			prePared = conn.prepareStatement(preParedQuery);
			prePared.setString(1, username);
			ResultSet rs = prePared.executeQuery();
			
			if(rs.next() == true) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return already;
	}
	
	public boolean alreadyEmail(String email) {
		boolean already = false;
		String preParedQuery = "SELECT email FROM registration WHERE email = ? ";
		
		PreparedStatement prePared = null;
		
		Connection conn = null;
		
		try {
			ConnectionUtil connection = new ConnectionUtil();
			conn = connection.getConnection();
			prePared = conn.prepareStatement(preParedQuery);
			prePared.setString(1, email);
			ResultSet rs = prePared.executeQuery();
			
			if(rs.next() == true) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return already;
	}
	
	@Override
	public List<UserDTO> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
