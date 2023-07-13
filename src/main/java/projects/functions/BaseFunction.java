package projects.functions;

import java.sql.Connection;

public abstract class BaseFunction {
	private Connection connection;
	private StringBuilder sql = new StringBuilder();
	public BaseFunction(Connection connect) {
		this.connection = connect;
		sql.append("SELECT @operation@(");
		sql.append("@property@");
		sql.append(") ");
		sql.append("AS ");
		sql.append("@alias@ ");
		sql.append("FROM ");
		sql.append("@table@ ");
	}
	
	public Connection getConnection() throws Exception {
		return connection;
	}
	
	public String getSql(String operation) {
		String sqlStr = sql.toString();
		sqlStr = sqlStr.replace("@operation@", operation);
		return sqlStr;
	}
}
