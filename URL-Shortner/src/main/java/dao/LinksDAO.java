package dao;

import java.sql.*;
import bean.Links;

public class LinksDAO {
	private static final String INSERT_LINK_SQL = "INSERT INTO links" + "  (longUrl, shortUrl) VALUES " + " (?, ?);";
	private static final String CHECK_LONG_URL = "select * from links where longUrl=?";
	private static final String CHECK_SHORT_URL = "select * from links where shortUrl=?";

	Links link;
	ConnectionManager connectionManager = new ConnectionManager();

	// Insert New Link
	public void insertLink(Links newLink) {
		Connection connection = connectionManager.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LINK_SQL);
			preparedStatement.setString(1, newLink.getLongUrl());
			preparedStatement.setString(2, newLink.getShortUrl());
			preparedStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Search by Long URL
	public Links searchByLongUrl(String longURL) throws SQLException {
//		Links link = null;
		Connection connection = connectionManager.getConnection();
		PreparedStatement statement = connection.prepareStatement(CHECK_LONG_URL);
		statement.setString(1, longURL);
		// For Execute SQL Query
		ResultSet rs = statement.executeQuery();
		if (rs.next()) {
			link = new Links();
			link.setLongUrl(rs.getString("longUrl"));
			link.setShortUrl(rs.getString("shortUrl"));
		}
		return link;
	}

	// Search by Short URL
	public Links searchByShortUrl(String shortURL) throws SQLException {
//		Links link;
		Connection connection = connectionManager.getConnection();
		PreparedStatement statement = connection.prepareStatement(CHECK_SHORT_URL);
		statement.setString(1, shortURL);
		// For Execute SQL Query
		ResultSet rs = statement.executeQuery();
		System.out.println("RS ="+statement);
		if (rs.next()) {
			link = new Links();
			link.setLongUrl(rs.getString("longUrl"));
			link.setShortUrl(rs.getString("shortUrl"));
		}
		return link;
	}
}
