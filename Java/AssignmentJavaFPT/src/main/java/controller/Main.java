package controller;

import exception.BirthDayException;
import exception.EmailException;
import log4j.Log4jDemo;
import models.Candidate;
import models.Experience;
import models.Fresher;
import models.Intern;
import service.*;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
* @author: QuangNV51
* @since: 13/09/2022 09:18
* @description:
*/
public class Main {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {

////         DowCasting
//        Candidate candidate = new Candidate();
//        if (candidate instanceof Fresher){
//            Fresher fresher = (Fresher) candidate;
//        }
//        if (candidate instanceof Intern){
//            Intern intern = (Intern) candidate;
//        }
//        if (candidate instanceof Experience){
//            Experience experience = (Experience) candidate;
//        }

        Scanner scanner = new Scanner(System.in);
        CandidateService candidateService = new CandidateService();
        SaveDatabase saveDatabase = new SaveDatabase();
        GetDatabase getDatabase = new GetDatabase();
        UpdateTable updateTable = new UpdateTable();
        InsertRow insertRow = new InsertRow();
        Log4jDemo log4jDemo = new Log4jDemo();
        boolean check = true;
        do {
            System.out.println("Nhan 1 de nhap them Candidate!");
            System.out.println("Nhan 2 de xem danh sach Candidate!");
            System.out.println("Nhan 3 de xem danh sach ten tat ca cac Candidate!");
            System.out.println("Nhan 4 de xem thong tin danh sach cac Candidate!!!");
            System.out.println("Nhan 5 de update Candidate!!");
            System.out.println("Nhan 6 de insert du lieu!!!");
            System.out.println("Nhan nut bat ky de thoat!!");
            String option = scanner.nextLine();
            switch (option){
                case "1":
                    System.out.println("Ban da chon them moi Candidate!");
                    System.out.println("Ban hay chon loai CandidateType: 0: Experience, 1: Fresher , 2: Intern:");
                    String option1 = scanner.nextLine();
                    switch (option1){
                        case "0":
                            System.out.println("Ban da chon nhap Candidate Experience!");
                            List<Experience> experienceList = null;
                            try {
                                experienceList = candidateService.createExperience();
                            } catch (BirthDayException | EmailException e) {
                                System.out.println(e.getMessage());
                                log4jDemo.errorLog(e.getMessage());
                            }
                            saveDatabase.saveExperience(experienceList);
                            break;
                        case "1":
                            System.out.println("Ban da chon nhap Candidate Fresher!");
                            List<Fresher> fresherList = null;
                            try {
                                fresherList = candidateService.createFresher();
                            } catch (BirthDayException | EmailException e) {
                                System.out.println(e.getMessage());
                                log4jDemo.errorLog(e.getMessage());
                            }
                            saveDatabase.saveFresher(fresherList);
                            break;
                        case "2":
                            System.out.println("Ban da chon nhap Candidate Intern!");
                            List<Intern> internList = null;
                            try {
                                internList = candidateService.createIntern();
                            } catch (BirthDayException | EmailException e) {
                                System.out.println(e.getMessage());
                                log4jDemo.errorLog(e.getMessage());
                            }
                            saveDatabase.saveIntern(internList);
                            break;
                        default:
                            break;
                    }
                    break;
                case "2":
                    System.out.println("Ban da chon xoa Fresher");
                    System.out.println("Ban hay nhap candiateID");
                    String candidateID = scanner.nextLine();
                    saveDatabase.deleteFresher(candidateID);
                    break;
                case "3":
                    System.out.println("Ten tat ca cac ung vien");
                    StringBuffer name = candidateService.getAllName();
                    System.out.println(name.toString());
                    break;
                case "4":
                    System.out.println("Nhan 1 de xem danh sach Fresher!!!");
                    System.out.println("Nhan 2 de xoa Fresher!!!");
                    System.out.println("Nhan 3 de xem danh sach Experience!!!");
                    System.out.println("Nhan 4 de xem danh sach Candidate khong trung CadidateID!!!");
                    System.out.println("Nhan 5 de xem danh sach Candidate da sap xep!!!");
                    System.out.println("Nhan phim bat ky de thoat!!!");
                    String option2 = scanner.nextLine();
                    switch (option2){
                        case "1":
                            System.out.println("Danh sach cac Fresher!");
                            List<Fresher> fresherList = getDatabase.getAllFresher();
                            for (int i = 0 ; i<fresherList.size();i++){
                                fresherList.get(i).showInfo();
                            }
                            break;
                        case "2":
                            System.out.println("Danh sach cac Intern!");
                            List<Intern> internList = getDatabase.getAllIntern();
                            for (int i = 0 ; i<internList.size();i++){
                               internList.get(i).showInfo();
                            }
                            break;
                        case "3":
                            System.out.println("Danh sach cac Experience!");
                            List<Experience> experienceList = getDatabase.getAllExperience();
                            for (int i = 0 ; i<experienceList.size();i++){
                                experienceList.get(i).showInfo();
                            }
                            break;
                        case "4":
                            System.out.println("Danh sach Candidate khong trung lap CandidateID!!");
                            Map<String, Candidate> fresherMap = candidateService.getCandidate();
                            for (Map.Entry<String, Candidate> fr: fresherMap.entrySet()){
                                System.out.print(fr.getKey() +" : ");
                                fr.getValue().showMe();
                                System.out.println("");
                        }
                            break;
                        case "5":
                            System.out.println("Danh sach Candidate khong trung lap CandidateID!!");
                            List<Candidate> candidateList = candidateService.sortCandidate();
                            for (Candidate fr: candidateList){
                                fr.showMe();
                                System.out.println("");
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case "5":
                    System.out.println("Ban da chon Update Candidate");
                    System.out.println("Nhap 1 de update Fresher");
                    System.out.println("Nhap 2 den update Intern");
                    System.out.println("Nhap 3 de update Experience");
                    String option4 = scanner.nextLine();
                    switch (option4){
                        case "1":
                            System.out.println("Nhap candidateID muon ");
                            String candidateID3 = scanner.nextLine();
                            updateTable.updateFresher(candidateID3);
                            break;
                        case "2":
                            System.out.println("Nhap cadidateID muon update");
                            String candidateID1 = scanner.nextLine();
                            updateTable.updateIntern(candidateID1);
                            break;
                        case "3":
                            System.out.println("Nhap candidateID muon Update");
                            String candidateID2 = scanner.nextLine();
                            updateTable.updateExperience(candidateID2);
                            break;
                    }
                    break;
                case "6":
                    System.out.println("Ban da chon insert candidate!");
                    System.out.println("Ban hay nhap 1 de insert fresher");
                    System.out.println("Ban hay nhap 2 de insert intern");
                    System.out.println("Ban hay nhap 3 de insert experience");
                    String option5 = scanner.nextLine();
                    switch (option5){
                        case "1":
                            System.out.println("Insert Fresher");
                            insertRow.insertFresher(insertRow.inputFresher());
                            break;
                        case "2":
                            System.out.println("Insert Intern");
                            insertRow.insertIntern(insertRow.inputIntern());
                            break;
                        case "3":
                            System.out.println("Insert Experience");
                            insertRow.insertExperience(insertRow.inputExperience());
                            break;
                    }
                    break;
                default:
                    System.out.println("Ban da thoat chuong trinh");
                    check = false;
            }
        }while (check);

    }
}
