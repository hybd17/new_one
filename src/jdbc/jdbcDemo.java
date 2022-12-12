package jdbc;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbcDemo {
    public static void main(String[] args) throws Exception {
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection conn = DriverManager.getConnection("jdbc:mysql:///demo", "root", "535897");
        Connection conn = JDBCUtils.getConnection();
        String sql = "update student set age = age+1";
        Statement statement = conn.createStatement();
        int count = statement.executeUpdate(sql);
        System.out.println(count);
        statement.close();
        conn.close();
    }
}
