package service;

import exception.InvalidDOBException;
import exception.InvalidFullNameException;
import exception.InvalidPhoneNumberException;
import model.GoodStudent;
import model.NormalStudent;
import model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentService {
    public static final String PATH_GOOD_STUDENT = "/Users/raymundoortizjr/Documents/FresherFPT/Java/ExampleFinal/src/main/java/data/goodStudent.csv";
    public static final String PATH_NORMAL_STUDENT = "/Users/raymundoortizjr/Documents/FresherFPT/Java/ExampleFinal/src/main/java/data/normalStudent.csv";
    public static final String Reg_FullName = "^[a-zA-Z0-9 ]{10,50}$";
    public static final String Reg_Phone = "^095[0-9]{7}$|^097[0-9]{7}$|^091[0-9]{7}$|^031[0-9]{7}$|^035[0-9]{7}$|^038[0-9]{7}$";
    public static final String Reg_Date = "^[ ][0-9]{2}[/][0-9]{2}[/][0-9]{4}$";

    ReadWriteFile readWriteFile = new ReadWriteFile();
    public List<GoodStudent> goodStudentList() {
        List<GoodStudent> goodStudentList = new ArrayList<>();
        List<String> listStudentString = readWriteFile.readFile(PATH_GOOD_STUDENT);
        for (int i = 0 ; i<listStudentString.size();i++){
            GoodStudent goodStudent = new GoodStudent(listStudentString.get(i).split(",")[0], listStudentString.get(i).split(",")[1], listStudentString.get(i).split(",")[2], listStudentString.get(i).split(",")[3], listStudentString.get(i).split(",")[4], listStudentString.get(i).split(",")[5], Double.parseDouble(listStudentString.get(i).split(",")[6]), listStudentString.get(i).split(",")[7]);
            goodStudentList.add(goodStudent);
            if (!checkFullName(listStudentString.get(i).split(",")[0])){
                try {
                    throw new InvalidFullNameException("Do dai full Name " +listStudentString.get(i).split(",")[0]  +"phai tu 10 den 50");
                } catch (InvalidFullNameException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (!checkPhone(listStudentString.get(i).split(",")[3])){
                try {
                    throw new InvalidPhoneNumberException("Sai dinh dang phone" +listStudentString.get(i).split(",")[3]);
                } catch (InvalidPhoneNumberException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (!checkDoB(listStudentString.get(i).split(",")[1])){
                try {
                    throw new InvalidDOBException("Sai dinh dang date" +listStudentString.get(i).split(",")[1]);
                } catch (InvalidDOBException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return goodStudentList;
    }

    public List<NormalStudent> normalStudents() {
        List<NormalStudent> normalStudentList = new ArrayList<>();
        List<String> listStudentString = readWriteFile.readFile(PATH_NORMAL_STUDENT);
        for (int i = 0 ; i<listStudentString.size();i++){
            NormalStudent normalStudent = new NormalStudent(listStudentString.get(i).split(",")[0], listStudentString.get(i).split(",")[1], listStudentString.get(i).split(",")[2], listStudentString.get(i).split(",")[3], listStudentString.get(i).split(",")[4], listStudentString.get(i).split(",")[5], listStudentString.get(i).split(",")[6],Double.parseDouble(listStudentString.get(i).split(",")[7]));
            normalStudentList.add(normalStudent);
            if (!checkFullName(listStudentString.get(i).split(",")[0])){
                try {
                    throw new InvalidFullNameException("Do dai full Name " +listStudentString.get(i).split(",")[0]  +"phai tu 10 den 50");
                } catch (InvalidFullNameException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (!checkPhone(listStudentString.get(i).split(",")[3])){
                try {
                    throw new InvalidPhoneNumberException("Sai dinh dang phone" +listStudentString.get(i).split(",")[3]);
                } catch (InvalidPhoneNumberException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (!checkDoB(listStudentString.get(i).split(",")[1])){
                try {
                    throw new InvalidDOBException("Sai dinh dang date" +listStudentString.get(i).split(",")[1]);
                } catch (InvalidDOBException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return normalStudentList;
    }

    public boolean checkFullName(String fullName){
        if (fullName.matches(Reg_FullName)){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean checkDoB(String doB){
        if (doB.matches(Reg_Date)){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkPhone(String phone){
        if (phone.matches(Reg_Phone)){
            return true;
        }else {
            return false;
        }
    }

    public List<Student> sortStudent(){
        DatabaseService databaseService = new DatabaseService();
        List<Student> studentList = databaseService.getAllStudent();
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o2.getFullName().compareTo(o1.getFullName())==0){
                    return o1.getPhoneNumber().compareTo(o2.getPhoneNumber());
                }
                return o2.getFullName().compareTo(o1.getFullName());
            }
        });
        return studentList;
    }
}
