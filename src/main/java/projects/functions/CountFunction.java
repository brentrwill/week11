package projects.functions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CountFunction extends BaseFunction {
	public CountFunction(Connection connect) {
		super(connect);
	}
	
	public int getCount(String table, String property, String alias) throws Exception {
		Statement stmt = null;
		try {
			int count = 0;
			stmt = getConnection().createStatement();
			String sql = this.getSql("COUNT");
			sql = sql.replace("@property@", property);
			sql = sql.replace("@table@", table);
			sql = sql.replace("@alias@", alias);
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt(alias);
			}
			rs.close();
			return count;
		} finally {
			if(stmt != null) {
				stmt.close();
			}
		}
	}
}
