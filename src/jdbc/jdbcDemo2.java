package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDemo2 {
    public static void main(String[] args) {
        Statement statement = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "insert into account values(3,'王五',3000)";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "535897");
            statement = conn.createStatement();
            int i = statement.executeUpdate(sql);
            System.out.println(i);
            if(i>0){
                System.out.println("添加成功");
            }
            else
                System.out.println("添加失败");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(statement != null)
            {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(conn != null)
            {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
