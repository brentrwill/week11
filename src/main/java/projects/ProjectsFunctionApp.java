package projects;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import projects.dao.DbConnection;

import projects.functions.AvgFunction;
import projects.functions.CountFunction;
import projects.functions.MaxFunction;
import projects.functions.MinFunction;

public class ProjectsFunctionApp {

	public static void main(String[] args) {;
		Connection conn = null;
		/**
		 * Date helper
		 */
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			/**
			 * Let's create our connection to our Database.
			 */
			conn = DbConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(conn != null) {
			try {
				CountFunction count = new CountFunction(conn);
				int cnt = count.getCount("listing", "listing_id", "TOTAL_NUMBER_OF_LISTINGS");
				System.out.println("Total Number of Listing : " + cnt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(conn != null) {
			try {
				AvgFunction avg = new AvgFunction(conn);
				double average = avg.getAverage("listing", "price", "AVERAGE_PRICE");
				BigDecimal bd = new BigDecimal(average).setScale(2, RoundingMode.HALF_UP); 
				System.out.println("AVERAGE_PRICE Price : " + bd.doubleValue());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(conn != null) {
			try {
				MinFunction min = new MinFunction(conn);
				double minPrice = min.getMin("listing", "price", "CHEAPEST_LISTING");
				System.out.println("CHEAPEST_LISTING Price : " + minPrice);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(conn != null) {
			try {
				MaxFunction max = new MaxFunction(conn);
				double maxPrice = max.getMax("listing", "price", "MOST_EXPENSIZE_LISTING");
				System.out.println("MOST_EXPENSIZE_LISTING Price : " + maxPrice);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
