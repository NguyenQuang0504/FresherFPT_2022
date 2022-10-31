package demo.models;

import javax.persistence.*;

/*
* @author: QuangNV51
* @since: 2022/10/31 13:29
* @description:
*/
@Entity
public class DangKyDV {
    @Id
    private String maKH;

    @Column
    private String hoTen;

    @Column
    private String gioiTinh;

    @Column
    private String ngaySinh;

    @Column
    private String diaChi;

    @Column
    private String sdt;

    @Column
    private String ngayDK;

    @Column
    private String ngayKT;

    @Column
    private String maHD;

    @Column
    private Integer chetKhau;

    @Column
    private Integer giaTriTT;

    @ManyToOne
    @JoinColumn(name = "maGC", referencedColumnName = "maGC")
    private GoiCuoc goiCuoc;

    /*
     * @author: QuangNV51
     * @since: 2022/10/31 13:29
     * @description:
     */
    public DangKyDV(String maKH, String hoTen, String gioiTinh, String ngaySinh, String diaChi, String sdt, String ngayDK, String ngayKT, String maHD, Integer chetKhau, Integer giaTriTT, GoiCuoc goiCuoc) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.ngayDK = ngayDK;
        this.ngayKT = ngayKT;
        this.maHD = maHD;
        this.chetKhau = chetKhau;
        this.giaTriTT = giaTriTT;
        this.goiCuoc = goiCuoc;
    }

    /*
     * @author: QuangNV51
     * @since: 2022/10/31 13:29
     * @description:
     */
    public DangKyDV() {
    }

    /*
     * @author: QuangNV51
     * @since: 2022/10/31 13:29
     * @description:
     */
    public DangKyDV(String maKH, String hoTen, String gioiTinh, String ngaySinh, String diaChi, String sdt, String ngayDK, String ngayKT, String maHD, Integer chetKhau, Integer giaTriTT) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.ngayDK = ngayDK;
        this.ngayKT = ngayKT;
        this.maHD = maHD;
        this.chetKhau = chetKhau;
        this.giaTriTT = giaTriTT;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
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

    public String getNgayDK() {
        return ngayDK;
    }

    public void setNgayDK(String ngayDK) {
        this.ngayDK = ngayDK;
    }

    public String getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(String ngayKT) {
        this.ngayKT = ngayKT;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Integer getChetKhau() {
        return chetKhau;
    }

    public void setChetKhau(Integer chetKhau) {
        this.chetKhau = chetKhau;
    }

    public Integer getGiaTriTT() {
        return giaTriTT;
    }

    public void setGiaTriTT(Integer giaTriTT) {
        this.giaTriTT = giaTriTT;
    }

    public GoiCuoc getGoiCuoc() {
        return goiCuoc;
    }

    public void setGoiCuoc(GoiCuoc goiCuoc) {
        this.goiCuoc = goiCuoc;
    }
}
