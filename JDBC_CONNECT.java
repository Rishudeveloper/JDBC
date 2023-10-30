package learnCoding.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC_CONNECT {

    static Connection con;
    public static void main(String[] args) {
    	

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load the MySQL JDBC driver
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbnew","root","root");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("create table emp (eno int, ename varchar(20), esal double)");

            System.out.println("Connection established");
            con.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
