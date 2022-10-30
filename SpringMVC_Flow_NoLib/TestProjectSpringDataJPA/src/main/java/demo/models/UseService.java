package demo.models;


import javax.persistence.*;

@Entity
@Table(name = "SuDungDV")
@IdClass(UseServiceId.class)
public class UseService {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maKH", referencedColumnName = "maKH")
    private Customer customer;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maDV", referencedColumnName = "maDV")
    private Service service;

    @Id
    @Column
    private String ngaySD;

    @Id
    @Column
    private String gioSD;

    @Column
    private Integer soLuong;

    public UseService(Customer customer, Service service, String ngaySD, String gioSD, Integer soLuong) {
        this.customer = customer;
        this.service = service;
        this.ngaySD = ngaySD;
        this.gioSD = gioSD;
        this.soLuong = soLuong;
    }



    public UseService() {

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
