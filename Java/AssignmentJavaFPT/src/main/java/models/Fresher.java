package models;

import java.util.List;

public class Fresher extends Candidate{
    private String graduationDate;
    private String graduationRank;
    private String education;
    private List<Certificated> certificateds;

    public Fresher() {
    }

    public Fresher(String candidateID, String fullName, String birthDay, String email, Integer cadidateType) {
        super(candidateID, fullName, birthDay, email, cadidateType);
    }

    public Fresher(String candidateID, String fullName, String birthDay, String email, Integer cadidateType, String graduationDate, String graduationRank, String education) {
        super(candidateID, fullName, birthDay, email, cadidateType);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public Fresher(String candidateID, String fullName, String birthDay, String email, Integer cadidateType, String graduationDate, String graduationRank, String education, List<Certificated> candidateList) {
        super(candidateID, fullName, birthDay, email, cadidateType);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
        this.certificateds = candidateList;
    }

    public List<Certificated> getCertificateds() {
        return certificateds;
    }

    public void setCertificateds(List<Certificated> certificateds) {
        this.certificateds = certificateds;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void showInfo(){
        super.showMe();
        System.out.println(", GraduationDate: " +this.graduationDate +", GraduationRank: " +this.graduationRank +", Education: " +this.education);
    }
}
