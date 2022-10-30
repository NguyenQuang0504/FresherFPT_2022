package demo.models;


import javax.persistence.*;

@Entity
@Table(name = "SuDungDV")
@IdClass(UseServiceId.class)
public class UseService {

    @Id
    private String maKH;

    @Id
    private String ngaySD;

    @Id
    private String gioSD;

    @Id
    private String maDV;

    @Column
    private Integer soLuong;


    @ManyToOne
    @JoinColumn(name = "maKH", insertable = false, updatable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "maDV",insertable = false, updatable = false)
    private Service service;



    public UseService(Customer customer, Service service, String ngaySD, String gioSD, Integer soLuong) {
        this.customer = customer;
        this.service = service;
        this.ngaySD = ngaySD;
        this.gioSD = gioSD;
        this.soLuong = soLuong;
    }

    public UseService() {

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
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
