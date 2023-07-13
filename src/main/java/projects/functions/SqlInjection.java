package projects.functions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import projects.dao.DbConnection;

public class SqlInjection {
	
	String sql = "DELETE * FROM listing";
	
	public String getListingData(String sql) throws Exception {
		Connection conn = DbConnection.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		return "";
	}
}