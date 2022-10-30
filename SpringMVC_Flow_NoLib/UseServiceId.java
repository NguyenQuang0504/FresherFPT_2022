package demo.models;

import java.io.Serializable;
import java.util.Objects;

public class UseServiceId implements Serializable {

    private static final long serialVersionUID = 1L;

    private String maKH;
    private String maDV;
    private String ngaySD;
    private String gioSD;

    public UseServiceId(String maKH, String maDV, String ngaySD, String gioSD) {
        this.maKH = maKH;
        this.maDV = maDV;
        this.ngaySD = ngaySD;
        this.gioSD = gioSD;
    }

    public UseServiceId() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UseServiceId that = (UseServiceId) o;
        return Objects.equals(maKH, that.maKH) && Objects.equals(maDV, that.maDV) && Objects.equals(ngaySD, that.ngaySD) && Objects.equals(gioSD, that.gioSD);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maKH, maDV, ngaySD, gioSD);
    }
}
