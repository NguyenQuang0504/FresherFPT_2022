package demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.List;

@Entity
public class XeThue {

    @Id
    private String maXe;

    @Column
    private String bienSoXe;

    @OneToMany(mappedBy = "xeThue")
    private List<DangKyThueXe> list;

    @Column
    private String hangXe;

    @Column
    private Date ngayKiemDinh;

    @Column
    private Integer donGia;

    public XeThue(String maXe, String bienSoXe, String hangXe, Date ngayKiemDinh, Integer donGia) {
        this.maXe = maXe;
        this.bienSoXe = bienSoXe;
        this.hangXe = hangXe;
        this.ngayKiemDinh = ngayKiemDinh;
        this.donGia = donGia;
    }

    public XeThue() {
    }

    public XeThue(String maXe) {
        this.maXe = maXe;
    }

    public String getMaXe() {
        return maXe;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    public String getBienSoXe() {
        return bienSoXe;
    }

    public void setBienSoXe(String bienSoXe) {
        this.bienSoXe = bienSoXe;
    }

    public String getHangXe() {
        return hangXe;
    }

    public void setHangXe(String hangXe) {
        this.hangXe = hangXe;
    }

    public Date getNgayKiemDinh() {
        return ngayKiemDinh;
    }

    public void setNgayKiemDinh(Date ngayKiemDinh) {
        this.ngayKiemDinh = ngayKiemDinh;
    }

    public Integer getDonGia() {
        return donGia;
    }

    public void setDonGia(Integer donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "XeThue{" +
                "maXe='" + maXe + '\'' +
                ", bienSoXe='" + bienSoXe + '\'' +
                ", hangXe='" + hangXe + '\'' +
                ", ngayKiemDinh=" + ngayKiemDinh +
                ", donGia=" + donGia +
                '}';
    }
}
