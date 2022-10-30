package service;

import exception.BirthDayException;
import exception.EmailException;
import log4j.Log4jDemo;
import models.*;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class CandidateService {
    final String RegEx_EMAIL = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    Scanner scanner = new Scanner(System.in);
    SaveDatabase saveDatabase = new SaveDatabase();
    GetDatabase getDatabase = new GetDatabase();
    Log4jDemo log4jDemo = new Log4jDemo();
    CertificatedService certificatedService = new CertificatedService();

    // Method Create Experience
    public List<Experience> createExperience() throws BirthDayException, EmailException{
        boolean check = true;
        List<Experience> experiences = new ArrayList<>();
        do {
            Candidate candidate = new Fresher();
            System.out.print("Ban hay nhap CandidateID: ");
            String candidateID = scanner.nextLine();
            System.out.print("Ban hay nhap fullName:");
            String fullName = scanner.nextLine();
            String birthDay;
            do {
                System.out.print("Ban hay nhap BirthDay:");
                birthDay = scanner.nextLine();
                if (birthDay.length()!=8){
                    throw new BirthDayException("Sai dinh dang birthDay");
                }
            }while (!checkBirthDay(birthDay));
            String email;
            do {
                System.out.print("Ban hay nhap email:");
                email = scanner.nextLine();
                if (email.length()<=11){
                    throw new  EmailException("Do dai email phai lon hon 10");
                }
            }while (!checkEmail(email));
            candidate.setCandidateID(candidateID);
            candidate.setFullName(fullName);
            candidate.setBirthDay(birthDay);
            candidate.setEmail(email);
            candidate.setCadidateType(0);
            System.out.print("Ban hay nhap ExpInYear: ");
            int expInYear = Integer.parseInt(scanner.nextLine());
            System.out.print("Ban hay nhap proSkill: ");
            String proSkill = scanner.nextLine();
            String checkCer;
            List<Certificated> certificatedList = new ArrayList<>();
            do {
                System.out.println("Ban co muon nhap Certificated Y/N ?");
                checkCer = scanner.nextLine();
                if (checkCer.toUpperCase(Locale.ROOT).equals("N")) {
                    break;
                }
                System.out.println("Ban hay nhap CertificatedID");
                String certificatedID = scanner.nextLine();
                System.out.println("Ban hay nhap CertificatedName");
                String certificatedName = scanner.nextLine();
                System.out.println("Ban hay nhap CertificatedDate");
                String certificatedDate = scanner.nextLine();
                System.out.println("Ban hay nhap CertificatedRank");
                String certificatedRank = scanner.nextLine();
                certificatedList.add(new Certificated(certificatedID, certificatedName, certificatedDate, certificatedRank));
            }while (checkCer.toUpperCase(Locale.ROOT).equals("Y"));
            certificatedService.saveCertification(certificatedList, candidateID);
            Experience experience = new Experience(candidate.getCandidateID(), candidate.getFullName(), candidate.getBirthDay(), candidate.getEmail(), candidate.getCadidateType(), expInYear, proSkill);
            experiences.add(experience);
            System.out.println("Ban co muon tiep tuc nhap Candidate Experience? Y/N");
            String option = scanner.nextLine();
            if (option.toUpperCase(Locale.ROOT).equals("Y")){
                System.out.println("Hay tiep tuc nhap Candidate Experience!!");
            }
            else{
                check = false;
            }
        }
        while (check);
        System.out.println("So luong cadidate: " +Candidate.getCadidateCount());
        return experiences;
    }

    // Method Create Intern
    public List<Intern> createIntern() throws BirthDayException, EmailException{
        List<Intern> interns = new ArrayList<>();
        boolean check = true;
        do {
            Candidate candidate = new Fresher();
            System.out.print("Ban hay nhap CandidateID: ");
            String candidateID = scanner.nextLine();
            System.out.print("Ban hay nhap fullName:");
            String fullName = scanner.nextLine();
            String birthDay;
            do {
                System.out.print("Ban hay nhap BirthDay:");
                birthDay = scanner.nextLine();
                if (birthDay.length()!=8){
                    throw new BirthDayException("Sai dinh dang birthDay");
                }
            }while (!checkBirthDay(birthDay));
            String email;
            do {
                System.out.print("Ban hay nhap email:");
                email = scanner.nextLine();
                if (email.length()<=11){
                    throw new  EmailException("Do dai email phai lon hon 10");
                }
            }while (!checkEmail(email));
            candidate.setCandidateID(candidateID);
            candidate.setFullName(fullName);
            candidate.setBirthDay(birthDay);
            candidate.setEmail(email);
            candidate.setCadidateType(2);
            System.out.print("Ban hay nhap majors: ");
            String majors = scanner.nextLine();
            System.out.print("Ban hay nhap semester: ");
            String semester = scanner.nextLine();
            System.out.print("Ban hay nhap university: ");
            String university = scanner.nextLine();
            String checkCer;
            List<Certificated> certificatedList = new ArrayList<>();
            do {
                System.out.println("Ban co muon nhap Certificated Y/N ?");
                checkCer = scanner.nextLine();
                if (checkCer.toUpperCase(Locale.ROOT).equals("N")) {
                    break;
                }
                System.out.println("Ban hay nhap CertificatedID");
                String certificatedID = scanner.nextLine();
                System.out.println("Ban hay nhap CertificatedName");
                String certificatedName = scanner.nextLine();
                System.out.println("Ban hay nhap CertificatedDate");
                String certificatedDate = scanner.nextLine();
                System.out.println("Ban hay nhap CertificatedRank");
                String certificatedRank = scanner.nextLine();
                certificatedList.add(new Certificated(certificatedID, certificatedName, certificatedDate, certificatedRank));
            }while (checkCer.toUpperCase(Locale.ROOT).equals("Y"));
            certificatedService.saveCertification(certificatedList, candidateID);
            Intern intern = new Intern(candidate.getCandidateID(), candidate.getFullName(), candidate.getBirthDay(), candidate.getEmail(), candidate.getCadidateType(), majors, semester, university);
            interns.add(intern);
            System.out.println("Ban co muon tiep tuc nhap Candidate Intern? Y/N");
            String option = scanner.nextLine();
            if (option.toUpperCase(Locale.ROOT).equals("Y")){
                System.out.println("Hay tiep tuc nhap Candidate Intern!!");
            }
            else{
                check = false;
            }
        }while (check);
        System.out.println("So luong cadidate: " +Candidate.getCadidateCount());
        return interns;
    }

    // Method Create Fresher
    public List<Fresher> createFresher() throws BirthDayException, EmailException{
        List<Fresher> freshers = new ArrayList<>();
        boolean check = true;
        do {
            Candidate candidate = new Fresher();
            System.out.print("Ban hay nhap CandidateID: ");
            String candidateID = scanner.nextLine();
            System.out.print("Ban hay nhap fullName:");
            String fullName = scanner.nextLine();
            String birthDay;
            do {
                System.out.print("Ban hay nhap BirthDay:");
                birthDay = scanner.nextLine();
                if (birthDay.length()!=8){
                    throw new BirthDayException("Sai dinh dang birthDay");
                }
            }while (!checkBirthDay(birthDay));
            String email;
            do {
                System.out.print("Ban hay nhap email:");
                email = scanner.nextLine();
                if (email.length()<=11){
                    throw new  EmailException("Do dai email phai lon hon 10");
                }
            }while (!checkEmail(email));
            candidate.setCandidateID(candidateID);
            candidate.setFullName(fullName);
            candidate.setBirthDay(birthDay);
            candidate.setEmail(email);
            candidate.setCadidateType(1);
            System.out.print("Ban hay nhap graduationDate: ");
            String graduationDate = scanner.nextLine();
            System.out.print("Ban hay nhap graduationRank: ");
            String graduationRank = scanner.nextLine();
            System.out.print("Ban hay nhap education: ");
            String education = scanner.nextLine();
            String checkCer;
            List<Certificated> certificatedList = new ArrayList<>();
            do {
                System.out.println("Ban co muon nhap Certificated Y/N ?");
                checkCer = scanner.nextLine();
                if (checkCer.toUpperCase(Locale.ROOT).equals("N")) {
                    break;
                }
                System.out.println("Ban hay nhap CertificatedID");
                String certificatedID = scanner.nextLine();
                System.out.println("Ban hay nhap CertificatedName");
                String certificatedName = scanner.nextLine();
                System.out.println("Ban hay nhap CertificatedDate");
                String certificatedDate = scanner.nextLine();
                System.out.println("Ban hay nhap CertificatedRank");
                String certificatedRank = scanner.nextLine();
                certificatedList.add(new Certificated(certificatedID, certificatedName, certificatedDate, certificatedRank));
            }while (checkCer.toUpperCase(Locale.ROOT).equals("Y"));
            certificatedService.saveCertification(certificatedList, candidateID);
            Fresher fresher = new Fresher(candidate.getCandidateID(), candidate.getFullName(), candidate.getBirthDay(), candidate.getEmail(), candidate.getCadidateType(), graduationDate, graduationRank, education);
            freshers.add(fresher);
            System.out.println("Ban co muon tiep tuc nhap Candidate Fresher? Y/N");
            String option = scanner.nextLine();
            if (option.toUpperCase(Locale.ROOT).equals("Y")){
                System.out.println("Hay tiep tuc nhap Candidate Fresher!!");
            }
            else{
                check = false;
            }
        }while (check);
        System.out.println("So luong cadidate: " +Candidate.getCadidateCount());
        return freshers;
    }


    // Method getAllNameCandidate
    public StringBuffer getAllName(){
        List<Fresher> fresherList = getDatabase.getAllFresher();
        List<Intern> internList = getDatabase.getAllIntern();
        List<Experience> experienceList = getDatabase.getAllExperience();
        List<String> stringList = new ArrayList<>();
        StringBuffer name = new StringBuffer();
        for (int i = 0 ; i< fresherList.size();i++){
            name.append(fresherList.get(i).getFullName());
            name.append(", ");
        }
        for (int j = 0 ; j< internList.size();j++){
            name.append(internList.get(j).getFullName());
            name.append(", ");
        }
        for (int k = 0;k<experienceList.size();k++){
            name.append(experienceList.get(k).getFullName());
            name.append(", ");
        }
        return name;
    }

    //Method check RegEx Email
    public boolean checkEmail(String email){
        return email.matches(RegEx_EMAIL);
    }

    //Method check RegEx BirthDay
    public boolean checkBirthDay(String birthDay){
        String dateNow = String.valueOf(LocalDate.now());
        try {
            Date dateStart = new SimpleDateFormat("yyyyMMdd").parse("19000101");
            Date dateNow1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateNow);
            Date date = new  SimpleDateFormat("yyyyMMdd").parse(birthDay);
            if (date.compareTo(dateStart)<=0 || date.compareTo(dateNow1)>=0){
                return false;
            }
            return true;
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            log4jDemo.errorLog(e.getMessage());
        }
        return false;
    }

    // Method convert string and get year
    public int getYear(String date){
        LocalDate date1 = LocalDate.parse(date);
        int year = date1.getYear();
        System.out.println(year);
        return year;
    }

    // Method sort candidate
    public List<Candidate> sortCandidate(){
        List<Candidate> candidateList = getDatabase.getAllCandidate();
        Collections.sort(candidateList, new Comparator<Candidate>() {
            @Override
            public int compare(Candidate o1, Candidate o2) {
                if (o1.getCadidateType()-(o2.getCadidateType())==0){
                    return getYear(o2.getBirthDay())-(getYear(o1.getBirthDay()));
                }
                return o1.getCadidateType()-(o2.getCadidateType());
            }
        });
        return candidateList;
    }

    // method get Cadidate
    public Map<String, Candidate> getCandidate() {
        List<Candidate> candidateList = getDatabase.getAllCandidate();
        Collections.sort(candidateList, new Comparator<Candidate>() {
            @Override
            public int compare(Candidate o1, Candidate o2) {
                if (o1.getCadidateType()-(o2.getCadidateType())==0){
                    return getYear(o1.getBirthDay())-(getYear(o2.getBirthDay()));
                }
                return o1.getCadidateType()-(o2.getCadidateType());
            }
        });
        Map<String, Candidate> candidateMap = new LinkedHashMap<>();
        for (int i = 0 ; i < candidateList.size();i++){
            candidateMap.put(candidateList.get(i).getCandidateID(), candidateList.get(i));
        }
        return candidateMap;
    }
}
