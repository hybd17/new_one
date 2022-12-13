package jdbc;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DruidDemo {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt  =null;
        conn = JDBCUtils.getConnection();
        String sql = "insert into account values (null,?,?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,"wangwu");
        pstmt.setDouble(2,3000);
        int i = pstmt.executeUpdate();
        System.out.println(i);
        JDBCUtils.close(pstmt,conn);
    }
}
