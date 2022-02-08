package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bean.Visitor;

public class VisitorDAO {
	ConnectionManager connectionManager = new ConnectionManager();
	private static final String INSERT_USERS_SQL = "INSERT INTO visitor"
			+ "  (longUrlVisitor,shortUrlVisitor, ipAddress, visitedDate,visitedTime) VALUES "
			+ "((select longUrl from links where longUrl=?),(select shortUrl from links where shortUrl=?),?,?,?);";
	private static final String SELECT_ALL_VISITORS = "select * from visitor order by ipAddress;";
	
	// Insert Visitor into Visitor Table
	public void insertUser(Visitor newVisitor) {
		Connection connection = connectionManager.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1, newVisitor.getLongUrlVisitor());
			preparedStatement.setString(2, newVisitor.getShortUrlVisitor());
			preparedStatement.setString(3, newVisitor.getIpAddress());
			preparedStatement.setString(4, newVisitor.getVisitedDate());
			preparedStatement.setString(5, newVisitor.getVisitedTime());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//List all Visitors
	public List<Visitor> selectAllUsers() {
		List<Visitor> visitors = new ArrayList<>();
		Connection connection = connectionManager.getConnection();
			PreparedStatement preparedStatement;
			try {
				preparedStatement = connection.prepareStatement(SELECT_ALL_VISITORS);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					int id=rs.getInt("uid");
					String longUrlVisitor=rs.getString("longUrlVisitor");
					String shortUrlVisitor=rs.getString("shortUrlVisitor");
					String ipAddress=rs.getString("ipAddress");
					String visitedDate=rs.getString("visitedDate");
					String visitedTime=rs.getString("visitedTime");
					visitors.add(new Visitor(id,longUrlVisitor,shortUrlVisitor,ipAddress,visitedDate,visitedTime));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return visitors;
	}
}
