package learnCoding.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_INSERT {
    static Connection con;

    public static void main(String[] args) throws NumberFormatException, IOException {
        try {
        	 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Load the MySQL JDBC driver
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbnew","root","root");
            PreparedStatement pmt = con.prepareStatement("insert into emp values(?,?,?)");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.println("Enter Emp ID: ");
                int eID = Integer.parseInt(br.readLine());

                System.out.println("Enter Emp Name: ");
                String eName = br.readLine();

                System.out.println("Enter Emp Salary: "); // Corrected the input prompt
                Double eSalary = Double.parseDouble(br.readLine());

                pmt.setInt(1, eID);
                pmt.setString(2, eName);
                pmt.setDouble(3, eSalary);

                int count = pmt.executeUpdate();
                if (count > 0) {
                    System.out.println(count + " record(s) inserted");
                } else {
                    System.out.println("No records inserted");
                }

                System.out.println("Do you want to insert more records? [YES/NO]");
                String ch = br.readLine();
                if (ch.equalsIgnoreCase("NO")) {
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
