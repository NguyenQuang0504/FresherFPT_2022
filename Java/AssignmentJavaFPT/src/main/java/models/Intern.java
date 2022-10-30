package models;

import java.util.List;

public class Intern extends Candidate{
    private String majors;
    private String semester;
    private String universityName;
    private List<Certificated> certificateds;

    public Intern() {
    }

    public Intern(String candidateID, String fullName, String birthDay, String email, Integer cadidateType) {
        super(candidateID, fullName, birthDay, email, cadidateType);
    }

    public Intern(String candidateID, String fullName, String birthDay, String email, Integer cadidateType, String majors, String semester, String universityName) {
        super(candidateID, fullName, birthDay, email, cadidateType);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public Intern(String majors, String semester, String universityName, List<Certificated> certificateds) {
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
        this.certificateds = certificateds;
    }

    public Intern(String candidateID, String fullName, String birthDay, String email, Integer cadidateType, String majors, String semester, String universityName, List<Certificated> certificateds) {
        super(candidateID, fullName, birthDay, email, cadidateType);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
        this.certificateds = certificateds;
    }

    public List<Certificated> getCertificateds() {
        return certificateds;
    }

    public void setCertificateds(List<Certificated> certificateds) {
        this.certificateds = certificateds;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public void showInfo(){
        super.showMe();
        System.out.println(", Major: " +this.majors +", Semester: " +this.semester + ", University: " +this.universityName);
    }
}
