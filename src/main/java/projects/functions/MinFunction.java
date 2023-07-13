package projects.functions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MinFunction extends BaseFunction {
	public MinFunction(Connection connect) {
		super(connect);
	}

	public double getMin(String table, String property, String alias) throws Exception {
		Statement stmt = null;
		try {
			double min = 0;
			stmt = getConnection().createStatement();
			String sql = this.getSql("MIN");
			sql = sql.replace("@property@", property);
			sql = sql.replace("@table@", table);
			sql = sql.replace("@alias@", alias);
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				min = rs.getDouble(alias);
			}
			return min;
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}
}