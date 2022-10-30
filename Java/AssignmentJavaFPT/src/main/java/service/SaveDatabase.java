package service;

import log4j.Log4jDemo;
import models.Experience;
import models.Fresher;
import models.Intern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class SaveDatabase {
    Log4jDemo log4jDemo = new Log4jDemo();

    public void deleteFresher(String candidateID){
        String sql = "DELETE FROM Fresher WHERE candidateID = ?";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //load driver
            String connectionUrl  = "jdbc:sqlserver://localhost:1433;DatabaseName=AssignmentBTJB;encrypt=true;trustServerCertificate=true"; //defind connect URL
            String userName = "sa"; // defind userName
            String password = "123456aA@$"; // defind password
            Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            PreparedStatement prstm = connection.prepareStatement(sql);
            prstm.setString(1, candidateID);
            int s = prstm.executeUpdate();
            if (s!=0) {
                System.out.println("Xoa thanh cong!!!");
                System.out.println("So dong thay doi" + s);
            }
            prstm.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void saveFresher(List<Fresher> fresherList){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //load driver
            String connectionUrl  = "jdbc:sqlserver://localhost:1433;DatabaseName=AssignmentBTJB;encrypt=true;trustServerCertificate=true"; //defind connect URL
            String userName = "sa"; // defind userName
            String password = "123456aA@$"; // defind password
            Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            String sql = "INSERT Fresher(candidateId, fullName, birthDay, email, candidateType,graduationDate, graduationRank, education) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement prstm = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            for (int i = 0 ; i< fresherList.size() ;i++){
                prstm.setString(1,fresherList.get(i).getCandidateID());
                prstm.setString(2, fresherList.get(i).getFullName());
                prstm.setString(3, fresherList.get(i).getBirthDay());
                prstm.setString(4, fresherList.get(i).getEmail());
                prstm.setInt(5, fresherList.get(i).getCadidateType());
                prstm.setString(6, fresherList.get(i).getGraduationDate());
                prstm.setString(7, fresherList.get(i).getGraduationRank());
                prstm.setString(8, fresherList.get(i).getEducation());
                prstm.addBatch();
            }
            prstm.executeBatch();
            System.out.println("OK");
            connection.commit();
            prstm.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            log4jDemo.errorLog(e.getMessage());
        }
    }

    public void saveIntern(List<Intern> internList){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //load driver
            String connectionUrl  = "jdbc:sqlserver://localhost:1433;DatabaseName=AssignmentBTJB;encrypt=true;trustServerCertificate=true"; //defind connect URL
            String userName = "sa"; // defind userName
            String password = "123456aA@$"; // defind password
            Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            String sql = "INSERT Intern(candidateId, fullName, birthDay, email, candidateType,majors, semester, universityName) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement prstm = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            for (int i = 0 ; i< internList.size() ;i++){
                prstm.setString(1, internList.get(i).getCandidateID());
                prstm.setString(2, internList.get(i).getFullName());
                prstm.setString(3, internList.get(i).getBirthDay());
                prstm.setString(4, internList.get(i).getEmail());
                prstm.setInt(5, internList.get(i).getCadidateType());
                prstm.setString(6, internList.get(i).getMajors());
                prstm.setString(7, internList.get(i).getSemester());
                prstm.setString(8, internList.get(i).getUniversityName());
                prstm.addBatch();
            }
            prstm.executeBatch();
            System.out.println("OK");
            connection.commit();
            prstm.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            Log4jDemo log4jDemo = new Log4jDemo();
        }
    }

    public void saveExperience(List<Experience> experienceList){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //load driver
            String connectionUrl  = "jdbc:sqlserver://localhost:1433;DatabaseName=AssignmentBTJB;encrypt=true;trustServerCertificate=true"; //defind connect URL
            String userName = "sa"; // defind userName
            String password = "123456aA@$"; // defind password
            Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            String sql = "INSERT Experience(candidateId, fullName, birthDay, email, candidateType, expInYear, proSkill) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement prstm = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            for (int i = 0 ; i< experienceList.size() ;i++){
                prstm.setString(1, experienceList.get(i).getCandidateID());
                prstm.setString(2, experienceList.get(i).getFullName());
                prstm.setString(3, experienceList.get(i).getBirthDay());
                prstm.setString(4, experienceList.get(i).getEmail());
                prstm.setInt(5, experienceList.get(i).getCadidateType());
                prstm.setInt(6, experienceList.get(i).getExpInYear());
                prstm.setString(7, experienceList.get(i).getProSkill());
                prstm.addBatch();
            }
            prstm.executeBatch();
            System.out.println("OK");
            connection.commit();
            prstm.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            Log4jDemo log4jDemo = new Log4jDemo();
        }
    }
}
