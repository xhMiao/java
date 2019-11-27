package java;

import java.sql.*;
public class TestJdbc {
    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/runoob?useSSL=false&serverTimezone=UTC";

    static final String USER = "root";
    static final String PASS = "";
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            System.out.println("connecting");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt=conn.createStatement();
            String sql;
            sql = "select id from websites";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                System.out.println(rs.getInt("id"));
            }
            rs.close();
            stmt.close();
            conn.close();

        }catch(SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();

        }   
        System.out.println("bye");
    }


}