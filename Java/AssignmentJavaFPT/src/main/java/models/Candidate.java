package models;

public abstract class Candidate {
    private String candidateID;
    private String fullName;
    private String birthDay;
    private String email;
    private Integer cadidateType;
    private static int cadidateCount = 0;

    public Candidate() {
        cadidateCount++;
    }


    public Candidate(String candidateID, String fullName, String birthDay, String email, Integer cadidateType) {
        this.candidateID = candidateID;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.email = email;
        this.cadidateType = cadidateType;
    }

    public String getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(String candidateID) {
        this.candidateID = candidateID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCadidateType() {
        return cadidateType;
    }

    public void setCadidateType(Integer cadidateType) {
        this.cadidateType = cadidateType;
    }

    public static int getCadidateCount() {
        return cadidateCount;
    }

    public static void setCadidateCount(int cadidateCount) {
        Candidate.cadidateCount = cadidateCount;
    }
    public void showMe(){
        System.out.print("CadidateID: " +this.candidateID + ", FullName: " +this.fullName + ", BirthDay: " +this.birthDay +", Email: " +this.email +", Type: " +this.cadidateType );
    }
}
