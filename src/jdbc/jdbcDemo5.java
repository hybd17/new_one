package jdbc;

import util.JDBCUtils;
import util.JDBCUtilsNormal;

import java.sql.*;
import java.util.Scanner;

public class jdbcDemo5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String username = in.nextLine();
        String password = in.nextLine();
        boolean login = new jdbcDemo5().login(username, password);
        if(login){
            System.out.println("登陆成功");
        }
        else {
            System.out.println("登录失败");
        }
    }
    public boolean login(String username,String password){
        if(username == null && password ==null)
        {
            return false;
        }
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from user where username = ? and password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,username);
            stmt.setString(2,password);
            rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsNormal.close(rs,stmt,conn);
        }
    }
}
