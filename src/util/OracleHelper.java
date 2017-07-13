/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleHelper {
	private static String DBDRIVER="oracle.jdbc.driver.OracleDriver";
	private static String DBURL="jdbc:oracle:thin:@localhost:1521:ORCL";
	private static String DBUSER="scott";
	private static String DBPASSWORD="system";
    public static Connection getConnect() {
        try {
            Class.forName(DBDRIVER);
            Connection conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);          										
			//×¢ÒâURLµÄÃèÊö¡°&amp;¡±
            return conn;
        } catch (SQLException ex) {
        	ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
        	ex.printStackTrace();
        }
        return null;
    }

    public static void closeResult(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
        }
    }

    public static void closePreparedStatement(PreparedStatement ps) {
        try {
        	if(ps != null)
        		ps.close();
        } catch (SQLException e) {
        }
    }

    public static void closeConneciton(Connection conn) {
        try {
        	if(conn != null)
        		conn.close();
        } catch (SQLException e) {
        }
    }
}
