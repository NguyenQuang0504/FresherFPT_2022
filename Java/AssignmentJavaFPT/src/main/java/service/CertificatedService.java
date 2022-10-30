package service;

import log4j.Log4jDemo;
import models.Candidate;
import models.Certificated;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CertificatedService {
    public List<Certificated> getCertificationByIDCandidate(String idCandidate){
        String sql = "SELECT * FROM Certification WHERE candidateID = ?";
        Log4jDemo log4jDemo = new Log4jDemo();
        List<Certificated> certificatedList = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //load driver
            String connectionUrl  = "jdbc:sqlserver://localhost:1433;DatabaseName=AssignmentBTJB;encrypt=true;trustServerCertificate=true"; //defind connect URL
            String userName = "sa"; // defind userName
            String password = "123456aA@$"; // defind password
            Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, idCandidate);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                certificatedList.add(new Certificated(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        }catch (Exception e){
            System.out.println();
        }
        return certificatedList;
    }

    public void saveCertification(List<Certificated> certificateds, String candidateID){
        String sql = "INSERT Certificated VALUES(?,?,?,?,?)";
        Log4jDemo log4jDemo = new Log4jDemo();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //load driver
            String connectionUrl  = "jdbc:sqlserver://localhost:1433;DatabaseName=AssignmentBTJB;encrypt=true;trustServerCertificate=true"; //defind connect URL
            String userName = "sa"; // defind userName
            String password = "123456aA@$"; // defind password
            Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            for (int i = 0 ;i< certificateds.size();i++){
                preparedStatement.setString(1, certificateds.get(i).getCertificatedId());
                preparedStatement.setString(2, certificateds.get(i).getCertificatedName());
                preparedStatement.setString(3, certificateds.get(i).getCertificatedRank());
                preparedStatement.setString(4, certificateds.get(i).getCertificatedDate());
                preparedStatement.setString(5, candidateID);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connection.commit();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            log4jDemo.errorLog(e.getMessage());
        }
    }
}
