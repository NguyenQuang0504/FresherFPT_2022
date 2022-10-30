package models;

import java.util.List;

public class Experience extends Candidate{
    private Integer expInYear;
    private String proSkill;
    private List<Certificated> certificateds;

    public Experience() {
    }

    public Experience(String candidateID, String fullName, String birthDay, String email, Integer cadidateType) {
        super(candidateID, fullName, birthDay, email, cadidateType);
    }

    public Experience(String candidateID, String fullName, String birthDay, String email, Integer cadidateType, Integer expInYear, String proSkill) {
        super(candidateID, fullName, birthDay, email, cadidateType);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public Experience(Integer expInYear, String proSkill, List<Certificated> certificateds) {
        this.expInYear = expInYear;
        this.proSkill = proSkill;
        this.certificateds = certificateds;
    }

    public Experience(String candidateID, String fullName, String birthDay, String email, Integer cadidateType, Integer expInYear, String proSkill, List<Certificated> certificateds) {
        super(candidateID, fullName, birthDay, email, cadidateType);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
        this.certificateds = certificateds;
    }

    public List<Certificated> getCertificateds() {
        return certificateds;
    }

    public void setCertificateds(List<Certificated> certificateds) {
        this.certificateds = certificateds;
    }

    public Integer getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(Integer expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    public void showInfo(){
        super.showMe();
        System.out.println(", ExpInYear: " +this.expInYear +", ProSkill: " +this.proSkill);
    }
}
