package service;

import log4j.Log4jDemo;
import models.Experience;
import models.Fresher;
import models.Intern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class InsertRow {
    Scanner scanner = new Scanner(System.in);
    Log4jDemo log4jDemo = new Log4jDemo();
    // Method input Fresher
    public Fresher inputFresher(){
        System.out.print("Ban hay nhap candidateID: ");
        String candidateID = scanner.nextLine();
        System.out.print("Ban hay nhap fullName");
        String fullName = scanner.nextLine();
        System.out.print("Ban hay nhap birthDay: ");
        String birthDay = scanner.nextLine();
        System.out.println("Ban hay nhap email: ");
        String email = scanner.nextLine();
        System.out.println("Ban hay nhap graduationDate: ");
        String graduationDate = scanner.nextLine();
        System.out.println("Ban hay nhap graduationRank: ");
        String graduationRank = scanner.nextLine();
        System.out.println("Ban hay nhap education: ");
        String education = scanner.nextLine();
        Fresher fresher = new Fresher(candidateID, fullName, birthDay, email, 1, graduationDate, graduationRank, education);
        return fresher;
    }

    //Method input Intern
    public Intern inputIntern(){
        System.out.print("Ban hay nhap candidateID: ");
        String candidateID = scanner.nextLine();
        System.out.print("Ban hay nhap fullName");
        String fullName = scanner.nextLine();
        System.out.print("Ban hay nhap birthDay: ");
        String birthDay = scanner.nextLine();
        System.out.println("Ban hay nhap email: ");
        String email = scanner.nextLine();
        System.out.println("Ban hay nhap majors: ");
        String majors = scanner.nextLine();
        System.out.println("Ban hay nhap semester: ");
        String semester = scanner.nextLine();
        System.out.println("Ban hay nhap universityName: ");
        String universityName = scanner.nextLine();
        Intern intern = new Intern(candidateID, fullName, birthDay, email, 2,  majors, semester, universityName);
        return intern;
    }

    //Method insert Experience
    public Experience inputExperience(){
        System.out.print("Ban hay nhap candidateID: ");
        String candidateID = scanner.nextLine();
        System.out.print("Ban hay nhap fullName");
        String fullName = scanner.nextLine();
        System.out.print("Ban hay nhap birthDay: ");
        String birthDay = scanner.nextLine();
        System.out.println("Ban hay nhap email: ");
        String email = scanner.nextLine();
        System.out.println("Ban hay nhap expInYear: ");
        Integer expInYear = Integer.parseInt(scanner.nextLine());
        System.out.println("Ban hay nhap proSkill: ");
        String proSkill = scanner.nextLine();
        Experience experience = new Experience(candidateID, fullName, birthDay, email, 2,  expInYear, proSkill);
        return experience;
    }

    //method insert Fresher
    public void insertFresher(Fresher fresher){
        String sql = "SELECT * FROM Fresher";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //load driver
            String connectionUrl  = "jdbc:sqlserver://localhost:1433;DatabaseName=AssignmentBTJB;encrypt=true;trustServerCertificate=true"; //defind connect URL
            String userName = "sa"; // defind userName
            String password = "123456aA@$"; // defind password
            Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            PreparedStatement pstm = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pstm.executeQuery();
            rs.moveToInsertRow();
            rs.updateString("candidateID" , fresher.getCandidateID());
            rs.updateString("fullName", fresher.getFullName());
            rs.updateString("birthDay", fresher.getBirthDay());
            rs.updateString("email", fresher.getEmail());
            rs.updateInt("candidateType", 1);
            rs.updateString("graduationDate", fresher.getGraduationDate());
            rs.updateString("graduationRank", fresher.getGraduationRank());
            rs.updateString("education", fresher.getEducation());
            rs.insertRow();
            rs.moveToCurrentRow();
            rs.close();
            pstm.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            log4jDemo.errorLog(e.getMessage());
        }
    }

    //method insert Intern
    public void insertIntern(Intern intern){
        String sql = "SELECT * FROM Intern";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //load driver
            String connectionUrl  = "jdbc:sqlserver://localhost:1433;DatabaseName=AssignmentBTJB;encrypt=true;trustServerCertificate=true"; //defind connect URL
            String userName = "sa"; // defind userName
            String password = "123456aA@$"; // defind password
            Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = preparedStatement.executeQuery();
            rs.moveToInsertRow();
            rs.updateString("candidateID", intern.getCandidateID());
            rs.updateString("fullName", intern.getFullName());
            rs.updateString("birthDay", intern.getBirthDay());
            rs.updateString("email", intern.getEmail());
            rs.updateInt("candidateType", 2);
            rs.updateString("majors", intern.getMajors());
            rs.updateString("semester", intern.getSemester());
            rs.updateString("universityName", intern.getUniversityName());
            rs.insertRow();
            rs.moveToCurrentRow();
            rs.close();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            log4jDemo.errorLog(e.getMessage());
        }
    }

    //method insert Experience
    public void insertExperience(Experience experience){
        String sql = "SELECT * FROM Experience";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //load driver
            String connectionUrl  = "jdbc:sqlserver://localhost:1433;DatabaseName=AssignmentBTJB;encrypt=true;trustServerCertificate=true"; //defind connect URL
            String userName = "sa"; // defind userName
            String password = "123456aA@$"; // defind password
            Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = preparedStatement.executeQuery();
            rs.moveToInsertRow();
            rs.updateString("candidateID", experience.getCandidateID());
            rs.updateString("fullName", experience.getFullName());
            rs.updateString("birthDay", experience.getBirthDay());
            rs.updateString("email", experience.getEmail());
            rs.updateInt("candidateType", 0);
            rs.updateInt("expInYear", experience.getExpInYear());
            rs.updateString("proSkill", experience.getProSkill());
            rs.insertRow();
            rs.moveToCurrentRow();
            rs.close();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            log4jDemo.errorLog(e.getMessage());
        }
    }
}
