package demo.models;

import java.io.Serializable;
import java.util.Objects;

public class UseMachineId implements Serializable {

    private static final long serialVersionUID = 1L;
    private String ngayBD;
    private String gioBD;
    private String maKH;
    private String maDV;

    public UseMachineId(String ngayBD, String gioBD, String maKH, String maDV) {
        this.ngayBD = ngayBD;
        this.gioBD = gioBD;
        this.maKH = maKH;
        this.maDV = maDV;
    }

    public UseMachineId() {
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

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UseMachineId that = (UseMachineId) o;
        return Objects.equals(ngayBD, that.ngayBD) && Objects.equals(gioBD, that.gioBD) && Objects.equals(maKH, that.maKH) && Objects.equals(maDV, that.maDV);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ngayBD, gioBD, maKH, maDV);
    }
}
