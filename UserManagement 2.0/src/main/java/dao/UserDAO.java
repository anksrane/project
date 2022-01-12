package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.User;

public class UserDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/userdb?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "ankit";
	private String jdbcDriver = "com.mysql.jdbc.Driver";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, password,role) VALUES "
			+ " (?, ?, ?,?);";
	private static final String SELECT_USER_BY_ID = "select id,name,email,password,role from users where id =?";
	private static final String SELECT_ALL_USERS_ADMIN = "select * from users";
	private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
	private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, password =?,role=? where id = ?;";
	private static final String LOGIN_USERS_SQL = "select * from users where email=? and password=?";
	private static final String CHECK_USER_AVAILABLE = "select * from users where email=?";
	private static final String CHANGE_LOGIN_STATUS = "update users set checkLogin= ? where email = ?;";
			
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(jdbcDriver);
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	//Check Existing User
	public User validateUserExist(String email) {
		User user=null;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(CHECK_USER_AVAILABLE);) {
			statement.setString(1, email);
			//For Execute SQL Query
			ResultSet rs=statement.executeQuery();
			System.out.println(rs);
			if(rs.next()) {
				user=new User();
				user.setName(rs.getString("name"));
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setpassword(rs.getString("password"));
				user.setrole(rs.getString("role"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	//Insert User
	public void insertUser(User user)throws SQLException{

		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			System.out.println(INSERT_USERS_SQL);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getpassword());
			preparedStatement.setString(4, user.getrole());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	//Select User by Id
	public User selectUser(int id) {
		User user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query to Return ResultSet
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String role = rs.getString("role");
				user = new User(id, name, email, password,role);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}
	
	//Select User List
	public List<User> selectAllUsers(String find) {
		
		System.out.println("Search Valud in DAO User List: "+find);
		List<User> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();){
			if(find==null) {
				// Step 2:Create a statement using connection object
				
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS_ADMIN);
			// Step 3: Execute the query to Return ResultSet
			ResultSet rs = preparedStatement.executeQuery();
	
			// Step 4: Process the ResultSet object.
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String email = rs.getString("email");
					String password = rs.getString("password");
					String role = rs.getString("role");
					users.add(new User(id, name, email, password,role));
				}
			}else {
				PreparedStatement preparedStatement = connection.prepareStatement
					("select * from users where name LIKE '%"+find+"%' or email LIKE '%"+find+"%' or role LIKE '%"+find+"%' ");
				// Step 3: Execute the query to Return ResultSet
				ResultSet rs = preparedStatement.executeQuery();
		
				// Step 4: Process the ResultSet object.
					while (rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						String email = rs.getString("email");
						String password = rs.getString("password");
						String role = rs.getString("role");
						users.add(new User(id, name, email, password,role));
					}
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}
	
	//Update User
	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getpassword());
			statement.setString(4, user.getrole());
			statement.setInt(5, user.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	//Delete User
	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
		
	//Check Before Login
	public User validateLogin(String email,String password) {
		User user=null;
		//Find User For Login
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(LOGIN_USERS_SQL);) {
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet rs=statement.executeQuery();
			System.out.println(rs);
			if(rs.next()) {
				user=new User();
				user.setName(rs.getString("name"));
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setpassword(rs.getString("password"));
				user.setrole(rs.getString("role"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//After user found
		if(user!=null) {
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(CHANGE_LOGIN_STATUS);) {
				statement.setInt(1, 0);
				statement.setString(2, email);
				//For Execute SQL Query
				ResultSet rs=statement.executeQuery();
				System.out.println(statement);
				if(rs.next()) {
					user=new User();
					user.setName(rs.getString("name"));
					user.setId(rs.getInt("id"));
					user.setEmail(rs.getString("email"));
					user.setpassword(rs.getString("password"));
					user.setrole(rs.getString("role"));
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

		
		
		return user;
	}
	
	//SQL Exception
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
