package com.example.jspservlet.model;

public class Service {
    private String maDV;
    private String tenDV;
    private String donVi;
    private Integer donGia;

    public Service(String maDV, String tenDV, String donVi, Integer donGia) {
        this.maDV = maDV;
        this.tenDV = tenDV;
        this.donVi = donVi;
        this.donGia = donGia;
    }

    public Service() {
    }

    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public Integer getDonGia() {
        return donGia;
    }

    public void setDonGia(Integer donGia) {
        this.donGia = donGia;
    }
}
