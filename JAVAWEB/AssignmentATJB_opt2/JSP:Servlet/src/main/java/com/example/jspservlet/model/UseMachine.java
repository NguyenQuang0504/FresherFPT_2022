package com.example.jspservlet.model;

public class UseMachine {
    private String maKH;
    private String maMay;
    private String ngayBD;
    private String gioBD;
    private Integer thoigianSD;

    public UseMachine(String maKH, String maMay, String ngayBD, String gioBD, Integer thoigianSD) {
        this.maKH = maKH;
        this.maMay = maMay;
        this.ngayBD = ngayBD;
        this.gioBD = gioBD;
        this.thoigianSD = thoigianSD;
    }

    public UseMachine() {
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaMay() {
        return maMay;
    }

    public void setMaMay(String maMay) {
        this.maMay = maMay;
    }

    public String getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(String ngayBD) {
        this.ngayBD = ngayBD;
    }

    public String getGioBD() {
        return gioBD;
    }

    public void setGioBD(String gioBD) {
        this.gioBD = gioBD;
    }

    public Integer getThoigianSD() {
        return thoigianSD;
    }

    public void setThoigianSD(Integer thoigianSD) {
        this.thoigianSD = thoigianSD;
    }

    @Override
    public String toString() {
        return "UseMachine{" +
                "maKH='" + maKH + '\'' +
                ", maMay='" + maMay + '\'' +
                ", ngayBD='" + ngayBD + '\'' +
                ", gioBD='" + gioBD + '\'' +
                ", thoigianSD=" + thoigianSD +
                '}';
    }
}
