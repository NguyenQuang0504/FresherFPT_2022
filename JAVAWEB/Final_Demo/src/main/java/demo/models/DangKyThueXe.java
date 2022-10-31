package demo.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class DangKyThueXe {
    @Id
    private String maDK;

    @Column
    private String hoTen;

    @ManyToOne
    @JoinColumn(name = "maXe", referencedColumnName = "maXe")
    private XeThue xeThue;

    @Column
    private String gioiTinh;

    @Column
    private Date ngaySinh;

    @Column
    private String diaChi;

    @Column
    private String sdt;

    @Column
    private Date ngayThue;

    @Column
    private String gioBD;

    @Column
    private String gioKT;

    @Column
    private Double tongTien;

    public DangKyThueXe(String maDK, String hoTen, XeThue xeThue, String gioiTinh, Date ngaySinh, String diaChi, String sdt, Date ngayThue, String gioBD, String gioKT, Double tongTien) {
        this.maDK = maDK;
        this.hoTen = hoTen;
        this.xeThue = xeThue;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.ngayThue = ngayThue;
        this.gioBD = gioBD;
        this.gioKT = gioKT;
        this.tongTien = tongTien;
    }

    public DangKyThueXe() {
    }

    public String getMaDK() {
        return maDK;
    }

    public void setMaDK(String maDK) {
        this.maDK = maDK;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public XeThue getXeThue() {
        return xeThue;
    }

    public void setXeThue(XeThue xeThue) {
        this.xeThue = xeThue;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(Date ngayThue) {
        this.ngayThue = ngayThue;
    }

    public String getGioBD() {
        return gioBD;
    }

    public void setGioBD(String gioBD) {
        this.gioBD = gioBD;
    }

    public String getGioKT() {
        return gioKT;
    }

    public void setGioKT(String gioKT) {
        this.gioKT = gioKT;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }
}
