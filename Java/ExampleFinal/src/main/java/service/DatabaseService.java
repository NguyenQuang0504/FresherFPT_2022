package service;

import model.GoodStudent;
import model.NormalStudent;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService {
    public void saveListGoodStudent(List<GoodStudent> goodStudentList){
        String sql = "INSERT Student(fullName, doB, sex, phoneNumber, universityName, gradeLevel, gpa, bestRewardName) VALUES(?,?,?,?,?,?,?,?)";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //load driver
            String connectionUrl  = "jdbc:sqlserver://localhost:1433;DatabaseName=FinalJava;encrypt=true;trustServerCertificate=true"; //defind connect URL
            String userName = "sa"; // defind userName
            String password = "123456aA@$"; // defind password
            Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            for (int i = 0 ; i< goodStudentList.size();i++){
                preparedStatement.setString(1,goodStudentList.get(i).getFullName());
                preparedStatement.setString(2,goodStudentList.get(i).getDoB());
                preparedStatement.setString(3,goodStudentList.get(i).getSex());
                preparedStatement.setString(4,goodStudentList.get(i).getPhoneNumber());
                preparedStatement.setString(5,goodStudentList.get(i).getUniversityName());
                preparedStatement.setString(6,goodStudentList.get(i).getGradeLevel());
                preparedStatement.setString(7, String.valueOf(goodStudentList.get(i).getGpa()));
                preparedStatement.setString(8,goodStudentList.get(i).getBestRewardName());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            System.out.println("OK");
            connection.commit();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void saveListNormalStudent(List<NormalStudent> normalStudents){
        String sql = "INSERT Student(fullName, doB, sex, phoneNumber, universityName, gradeLevel, englishScore, entryTestScore) VALUES(?,?,?,?,?,?,?,?)";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //load driver
            String connectionUrl  = "jdbc:sqlserver://localhost:1433;DatabaseName=FinalJava;encrypt=true;trustServerCertificate=true"; //defind connect URL
            String userName = "sa"; // defind userName
            String password = "123456aA@$"; // defind password
            Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            for (int i = 0 ; i< normalStudents.size();i++){
                preparedStatement.setString(1,normalStudents.get(i).getFullName());
                preparedStatement.setString(2,normalStudents.get(i).getDoB());
                preparedStatement.setString(3,normalStudents.get(i).getSex());
                preparedStatement.setString(4,normalStudents.get(i).getPhoneNumber());
                preparedStatement.setString(5,normalStudents.get(i).getUniversityName());
                preparedStatement.setString(6,normalStudents.get(i).getGradeLevel());
                preparedStatement.setString(7, normalStudents.get(i).getEnglishScore());
                preparedStatement.setString(8, String.valueOf(normalStudents.get(i).getEntryTestScore()));
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            System.out.println("OK");
            connection.commit();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<Student> getAllStudent(){
        String sql = "SELECT * FROM Student";
        List<Student> studentList= new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //load driver
            String connectionUrl  = "jdbc:sqlserver://localhost:1433;DatabaseName=FinalJava;encrypt=true;trustServerCertificate=true"; //defind connect URL
            String userName = "sa"; // defind userName
            String password = "123456aA@$"; // defind password
            Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                if (rs.getString("gpa")==null){
                    Student student = new NormalStudent(
                      rs.getString("fullName"),rs.getString("doB"), rs.getString("sex"),
                      rs.getString("phoneNumber"), rs.getString("universityName"), rs.getString("gradeLevel"),
                      rs.getString("englishScore"),Double.parseDouble(rs.getString("entryTestScore"))
                    );
                    studentList.add(student);
                }else {
                    Student student1 = new GoodStudent(
                            rs.getString("fullName"),rs.getString("doB"), rs.getString("sex"),
                            rs.getString("phoneNumber"), rs.getString("universityName"), rs.getString("gradeLevel"),
                           Double.parseDouble(rs.getString("gpa")),rs.getString("bestRewardName")
                    );
                    studentList.add(student1);
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return studentList;
    }
}
