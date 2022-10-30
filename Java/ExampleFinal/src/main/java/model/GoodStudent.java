package model;

public class GoodStudent extends Student{
    private double gpa;
    private String bestRewardName;

    public GoodStudent() {
    }

    public GoodStudent(String fullName, String doB, String sex, String phoneNumber, String universityName, String gradeLevel, double gpa, String bestRewardName) {
        super(fullName, doB, sex, phoneNumber, universityName, gradeLevel);
        this.gpa = gpa;
        this.bestRewardName = bestRewardName;
    }

    public GoodStudent(double gpa, String bestRewardName) {
        this.gpa = gpa;
        this.bestRewardName = bestRewardName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getBestRewardName() {
        return bestRewardName;
    }

    public void setBestRewardName(String bestRewardName) {
        this.bestRewardName = bestRewardName;
    }

    public void showInfor() {
        super.showInfor();
        System.out.println("gpa: " +gpa + ", bestRewardName: " +bestRewardName );
    }
}
