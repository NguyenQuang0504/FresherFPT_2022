package service;

import log4j.Log4jDemo;

import java.sql.*;
import java.util.Scanner;

public class UpdateTable {
    Scanner scanner = new Scanner(System.in);
    Log4jDemo log4jDemo = new Log4jDemo();
    //method Update Fresher
    public void updateFresher(String candidateID){
        String sql = "SELECT * FROM Fresher WHERE candidateID = ?";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //load driver
            String connectionUrl  = "jdbc:sqlserver://localhost:1433;DatabaseName=AssignmentBTJB;encrypt=true;trustServerCertificate=true"; //defind connect URL
            String userName = "sa"; // defind userName
            String password = "123456aA@$"; // defind password
            Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            PreparedStatement pstm = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm.setString(1, candidateID);
            ResultSet rs = pstm.executeQuery();
            rs.beforeFirst();
            while (rs.next()){
                System.out.println("Cap nhat candidate " +candidateID);
                System.out.println("Ten candidate: " +rs.getString("fullName"));
                System.out.print("Ban hay nhap fullName moi: ");
                String fullName = scanner.nextLine();
                System.out.println("Email candidate: "+rs.getString("email"));
                System.out.print("Ban hay nhap email moi: ");
                String email = scanner.nextLine();
                System.out.println("graduationRank candidate: "+rs.getString("graduationRank"));
                System.out.print("Ban hay nhap graduationRank moi: ");
                String graduationRank = scanner.nextLine();
                System.out.println("Education candidate: "+rs.getString("education"));
                System.out.print("Ban hay nhap education moi: ");
                String education = scanner.nextLine();
                rs.updateString("fullName", fullName);
                rs.updateString("email", email);
                rs.updateString("graduationRank", graduationRank);
                rs.updateString("education", education);
                rs.updateRow();
            }
            rs.close();
            pstm.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            Log4jDemo log4jDemo = new Log4jDemo();
        }
    }

    //method updateIntern
    public void updateIntern(String candidateID){
        String sql = "SELECT * FROM Intern WHERE candidateID = ?";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //load driver
            String connectionUrl  = "jdbc:sqlserver://localhost:1433;DatabaseName=AssignmentBTJB;encrypt=true;trustServerCertificate=true"; //defind connect URL
            String userName = "sa"; // defind userName
            String password = "123456aA@$"; // defind password
            Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            PreparedStatement pstm = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm.setString(1, candidateID);
            ResultSet rs = pstm.executeQuery();
            rs.beforeFirst();
            while (rs.next()){
                System.out.println("Cap nhat candidate " +candidateID);
                System.out.println("Ten candidate: " +rs.getString("fullName"));
                System.out.print("Ban hay nhap fullName moi: ");
                String fullName = scanner.nextLine();
                System.out.println("Email candidate: "+rs.getString("email"));
                System.out.print("Ban hay nhap email moi: ");
                String email = scanner.nextLine();
                System.out.println("majors candidate: "+rs.getString("majors"));
                System.out.print("Ban hay nhap majors moi: ");
                String majors = scanner.nextLine();
                System.out.println("Semester candidate: "+rs.getString("semester"));
                System.out.print("Ban hay nhap semester moi: ");
                String semester = scanner.nextLine();
                System.out.println("UniversityName candidate: "+rs.getString("universityName"));
                System.out.print("Ban hay nhap universityName moi: ");
                String universityName = scanner.nextLine();
                rs.updateString("fullName", fullName);
                rs.updateString("email", email);
                rs.updateString("majors", majors);
                rs.updateString("semester", semester);
                rs.updateString("universityName", universityName);
                rs.updateRow();
            }
            rs.close();
            pstm.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            Log4jDemo log4jDemo = new Log4jDemo();
        }
    }

    //method update Experience
    public void updateExperience(String candidateID){
        String sql = "SELECT * FROM Experience WHERE candidateID = ?";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //load driver
            String connectionUrl  = "jdbc:sqlserver://localhost:1433;DatabaseName=AssignmentBTJB;encrypt=true;trustServerCertificate=true"; //defind connect URL
            String userName = "sa"; // defind userName
            String password = "123456aA@$"; // defind password
            Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            PreparedStatement pstm = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm.setString(1, candidateID);
            ResultSet rs = pstm.executeQuery();
            rs.beforeFirst();
            while (rs.next()){
                System.out.println("Cap nhat candidate " +candidateID);
                System.out.println("Ten candidate: " +rs.getString("fullName"));
                System.out.print("Ban hay nhap fullName moi: ");
                String fullName = scanner.nextLine();
                System.out.println("Email candidate: "+rs.getString("email"));
                System.out.print("Ban hay nhap email moi: ");
                String email = scanner.nextLine();
                System.out.println("expInYear candidate: "+rs.getInt("expInYear"));
                System.out.print("Ban hay nhap expInYear moi: ");
                Integer expInYear = Integer.parseInt(scanner.nextLine());
                System.out.println("proSkill candidate: "+rs.getString("proSkill"));
                System.out.print("Ban hay nhap proSkill moi: ");
                String proSkill = scanner.nextLine();
                rs.updateString("fullName", fullName);
                rs.updateString("email", email);
                rs.updateInt("expInYear", expInYear);
                rs.updateString("proSkill", proSkill);
                rs.updateRow();
            }
            rs.close();
            pstm.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            Log4jDemo log4jDemo = new Log4jDemo();
        }
    }
}
