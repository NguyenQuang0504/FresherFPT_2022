package model;

public class NormalStudent extends Student{
    private String englishScore;
    private double entryTestScore;

    public NormalStudent() {
    }

    public NormalStudent(String fullName, String doB, String sex, String phoneNumber, String universityName, String gradeLevel, String englishScore, double entryTestScore) {
        super(fullName, doB, sex, phoneNumber, universityName, gradeLevel);
        this.englishScore = englishScore;
        this.entryTestScore = entryTestScore;
    }

    public String getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(String englishScore) {
        this.englishScore = englishScore;
    }

    public double getEntryTestScore() {
        return entryTestScore;
    }

    public void setEntryTestScore(double entryTestScore) {
        this.entryTestScore = entryTestScore;
    }

    public void showInfor() {
        super.showInfor();
        System.out.println("EnglishScore: " +englishScore + ", entryTestScore: " +entryTestScore);
    }
}
