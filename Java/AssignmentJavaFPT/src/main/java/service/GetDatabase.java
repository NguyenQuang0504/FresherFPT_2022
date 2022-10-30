package service;

import log4j.Log4jDemo;
import models.*;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetDatabase {
    CertificatedService certificatedService = new CertificatedService();
    Log4jDemo log4jDemo = new Log4jDemo();
    public List<Fresher> getAllFresher(){
        String sql = "SELECT * FROM Fresher";
        List<Fresher> fresherList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //load driver
            String connectionUrl  = "jdbc:sqlserver://localhost:1433;DatabaseName=AssignmentBTJB;encrypt=true;trustServerCertificate=true"; //defind connect URL
            String userName = "sa"; // defind userName
            String password = "123456aA@$"; // defind password
            Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet resultSet = stm.executeQuery();
            while (resultSet.next()){
                List<Certificated> certificatedList = certificatedService.getCertificationByIDCandidate(resultSet.getString(1));
                Fresher fresher = new Fresher(resultSet.getString("candidateId"),
                        resultSet.getString("fullName"), resultSet.getString("birthDay"),
                        resultSet.getString("email"), resultSet.getInt("candidateType"),
                        resultSet.getString("graduationDate"),resultSet.getString("graduationRank"),
                        resultSet.getString("education"),certificatedList);
                fresherList.add(fresher);
            }
            resultSet.close();
            stm.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            log4jDemo.errorLog(e.getMessage());
        }
        log4jDemo.loggerInfor(sql);
        return fresherList;
    }

    public List<Intern> getAllIntern(){
        String sql = "SELECT * FROM Intern";
        List<Intern> internList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //load driver
            String connectionUrl  = "jdbc:sqlserver://localhost:1433;DatabaseName=AssignmentBTJB;encrypt=true;trustServerCertificate=true"; //defind connect URL
            String userName = "sa"; // defind userName
            String password = "123456aA@$"; // defind password
            Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet resultSet = stm.executeQuery();
            while (resultSet.next()){
                List<Certificated> certificatedList = certificatedService.getCertificationByIDCandidate(resultSet.getString(1));
                Intern intern = new Intern(resultSet.getString("candidateId"),
                        resultSet.getString("fullName"), resultSet.getString("birthDay"),
                        resultSet.getString("email"), resultSet.getInt("candidateType"),
                        resultSet.getString("majors"),resultSet.getString("semester"),
                        resultSet.getString("universityName"), certificatedList);
                internList.add(intern);
            }
            resultSet.close();
            stm.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            log4jDemo.errorLog(e.getMessage());
        }
        log4jDemo.loggerInfor(sql);
        return internList;
    }

    public List<Experience> getAllExperience(){
        String sql = "SELECT * FROM Experience";
        List<Experience> experienceList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //load driver
            String connectionUrl  = "jdbc:sqlserver://localhost:1433;DatabaseName=AssignmentBTJB;encrypt=true;trustServerCertificate=true"; //defind connect URL
            String userName = "sa"; // defind userName
            String password = "123456aA@$"; // defind password
            Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet resultSet = stm.executeQuery();
            while (resultSet.next()){
                List<Certificated> certificatedList = certificatedService.getCertificationByIDCandidate(resultSet.getString(1));
                Experience experience = new Experience(resultSet.getString("candidateId"),
                        resultSet.getString("fullName"), resultSet.getString("birthDay"),
                        resultSet.getString("email"), resultSet.getInt("candidateType"),
                        resultSet.getInt("expInYear"),resultSet.getString("proSkill"), certificatedList
                );
                experienceList.add(experience);
            }
            resultSet.close();
            stm.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            log4jDemo.errorLog(e.getMessage());
        }
        log4jDemo.loggerInfor(sql);
        return experienceList;
    }

    public List<Candidate> getFresherToCandidate(){
        String sql = "SELECT candidateID, fullName, birthDay, email, candidateType FROM Fresher";
        List<Candidate> fresherList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //load driver
            String connectionUrl  = "jdbc:sqlserver://localhost:1433;DatabaseName=AssignmentBTJB;encrypt=true;trustServerCertificate=true"; //defind connect URL
            String userName = "sa"; // defind userName
            String password = "123456aA@$"; // defind password
            Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet resultSet = stm.executeQuery();
            while (resultSet.next()){
                Candidate fresher = new Fresher(resultSet.getString("candidateId"),
                        resultSet.getString("fullName"), resultSet.getString("birthDay"),
                        resultSet.getString("email"), resultSet.getInt("candidateType")
                        );
                fresherList.add(fresher);
            }
            resultSet.close();
            stm.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            log4jDemo.errorLog(e.getMessage());
        }
        log4jDemo.loggerInfor(sql);
        return fresherList;
    }

    public List<Candidate> getInternToCandidate(){
        String sql = "SELECT candidateID, fullName, birthDay, email, candidateType FROM Intern";
        List<Candidate> internList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //load driver
            String connectionUrl  = "jdbc:sqlserver://localhost:1433;DatabaseName=AssignmentBTJB;encrypt=true;trustServerCertificate=true"; //defind connect URL
            String userName = "sa"; // defind userName
            String password = "123456aA@$"; // defind password
            Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet resultSet = stm.executeQuery();
            while (resultSet.next()){
                Candidate intern = new Intern(resultSet.getString("candidateId"),
                        resultSet.getString("fullName"), resultSet.getString("birthDay"),
                        resultSet.getString("email"), resultSet.getInt("candidateType"));
                internList.add(intern);
            }
            resultSet.close();
            stm.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            log4jDemo.errorLog(e.getMessage());
        }
        log4jDemo.loggerInfor(sql);
        return internList;
    }

    public List<Candidate> getExperienceToCandidate(){
        String sql = "SELECT candidateID, fullName, birthDay, email, candidateType FROM Experience";
        List<Candidate> experienceList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //load driver
            String connectionUrl  = "jdbc:sqlserver://localhost:1433;DatabaseName=AssignmentBTJB;encrypt=true;trustServerCertificate=true"; //defind connect URL
            String userName = "sa"; // defind userName
            String password = "123456aA@$"; // defind password
            Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet resultSet = stm.executeQuery();
            while (resultSet.next()){
                Candidate experience = new Experience(resultSet.getString("candidateId"),
                        resultSet.getString("fullName"), resultSet.getString("birthDay"),
                        resultSet.getString("email"), resultSet.getInt("candidateType")
                );
                experienceList.add(experience);
            }
            resultSet.close();
            stm.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            log4jDemo.errorLog(e.getMessage());
        }
        log4jDemo.loggerInfor(sql);
        return experienceList;
    }

    // get all candidate and move to list candidate
    public List<Candidate> getAllCandidate(){
        List<Candidate> candidateList = new ArrayList<>();
        List<Candidate> candidateFresher = getFresherToCandidate();
        List<Candidate> candidateIntern = getInternToCandidate();
        List<Candidate> candidateExperience = getExperienceToCandidate();
        for (int i = 0 ; i< candidateFresher.size() ; i++){
            candidateList.add(candidateFresher.get(i));
        }
        for (int i = 0 ; i< candidateIntern.size() ; i++){
            candidateList.add(candidateIntern.get(i));
        }
        for (int i = 0 ; i< candidateExperience.size() ; i++){
            candidateList.add(candidateExperience.get(i));
        }
        return candidateList;
    }
}
