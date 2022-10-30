package controller;

import exception.InvalidDOBException;
import exception.InvalidFullNameException;
import exception.InvalidPhoneNumberException;
import model.GoodStudent;
import model.NormalStudent;
import model.Student;
import service.DatabaseService;
import service.StudentService;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        StudentService service = new StudentService();
        DatabaseService databaseService = new DatabaseService();
        try {
            do {
                System.out.println("1. Chuc nang get du lieu tu file csv");
                System.out.println("2. Chuc nang save du lieu tu csv vao database");
                System.out.println("3. Chuc nang get All Student");
                System.out.println("4. Chuc nang 4");
                System.out.println("Nhap phim khac de thoat");
                System.out.println("Ban hay chon chuc nang!!!");
                String choice = scanner.next();
                switch (choice) {
                    case "1":
                        System.out.println("------------------------GOOD STUDENT-----------------------------");
                        List<GoodStudent> goodStudentList = null;
                            goodStudentList = service.goodStudentList();
                        for (int i = 0; i < goodStudentList.size(); i++) {
                            goodStudentList.get(i).showInfor();
                        }
                        System.out.println("------------------------NORMAL STUDENT-----------------------------");
                        List<NormalStudent> normalStudentList = null;
                            normalStudentList = service.normalStudents();

                        for (int i = 0; i < normalStudentList.size(); i++) {
                            normalStudentList.get(i).showInfor();
                        }
                        break;
                    case "2":
                        System.out.println("Ban da chon chuc nang 2");
                        System.out.println("1. Dua du lieu goodStudent vao");
                        System.out.println("2. Dua du lieu normalStudent vao");
                        String choose = scanner.next();
                        switch (choose) {
                            case "1":
                                System.out.println("Dua goodStudent vao Database");
                                List<GoodStudent> goodStudentList1 = null;
                                    goodStudentList1 = service.goodStudentList();
                                databaseService.saveListGoodStudent(goodStudentList1);
                                break;
                            case "2":
                                System.out.println("Dua normalStudent vao Database");
                                List<NormalStudent> normalStudents = null;
                                    normalStudents = service.normalStudents();
                                databaseService.saveListNormalStudent(normalStudents);
                                break;
                            default:
                                break;
                        }
                        break;
                    case "3":
                        System.out.println("Ban da chon chuc nang 3");
                        List<Student> studentList = service.sortStudent();
                        for (int i = 0 ; i<studentList.size();i++){
                            studentList.get(i).showInfor();
                        }
                        break;
                    case "4":
                        System.out.println("Ban da chon chuc nang 4");
                        break;
                    default:
                        System.out.println("Ban da thoat chuong trinh");
                        check = false;
                }
            } while (check);
        }catch (Exception e){
            System.out.println("Input files have unknow errors!");
        }
    }
}
