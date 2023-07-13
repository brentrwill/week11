package projects.functions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AvgFunction extends BaseFunction {
	public AvgFunction(Connection connect) {
		super(connect);
	}
	
	public double getAverage(String table, String property, String alias) throws Exception {
		Statement stmt = null;
		try {
			double average = 0;
			stmt = getConnection().createStatement();
			String sql = this.getSql("AVG");
			sql = sql.replace("@property@", property);
			sql = sql.replace("@table@", table);
			sql = sql.replace("@alias@", alias);
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				average = rs.getDouble(alias);
			}
			return average;
		} finally {
			if(stmt != null) {
				stmt.close();
			}
		}
	}
}
