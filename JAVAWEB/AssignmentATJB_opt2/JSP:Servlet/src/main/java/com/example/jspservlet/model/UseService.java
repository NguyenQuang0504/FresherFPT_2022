package com.example.jspservlet.model;

public class UseService {
    private String maDV;
    private String maKH;
    private String ngaySD;
    private String gioSD;
    private Integer soLuong;

    public UseService(String maDV, String maKH, String ngaySD, String gioSD, Integer soLuong) {
        this.maDV = maDV;
        this.maKH = maKH;
        this.ngaySD = ngaySD;
        this.gioSD = gioSD;
        this.soLuong = soLuong;
    }

    public UseService() {
    }

    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getNgaySD() {
        return ngaySD;
    }

    public void setNgaySD(String ngaySD) {
        this.ngaySD = ngaySD;
    }

    public String getGioSD() {
        return gioSD;
    }

    public void setGioSD(String gioSD) {
        this.gioSD = gioSD;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }
}
