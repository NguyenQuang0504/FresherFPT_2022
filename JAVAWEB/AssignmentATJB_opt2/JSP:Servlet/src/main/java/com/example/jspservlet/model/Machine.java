package com.example.jspservlet.model;

public class Machine {
    private String maMay;
    private String viTri;
    private String trangThai;

    public Machine(String maMay, String viTri, String trangThai) {
        this.maMay = maMay;
        this.viTri = viTri;
        this.trangThai = trangThai;
    }

    public Machine() {
    }

    public String getMaMay() {
        return maMay;
    }

    public void setMaMay(String maMay) {
        this.maMay = maMay;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "maMay='" + maMay + '\'' +
                ", viTri='" + viTri + '\'' +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }
}
