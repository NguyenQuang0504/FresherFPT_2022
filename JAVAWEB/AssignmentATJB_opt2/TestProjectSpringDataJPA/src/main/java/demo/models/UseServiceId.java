package demo.models;

import java.io.Serializable;
import java.util.Objects;

public class UseServiceId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Customer customer;
    private Service service;
    private String ngaySD;
    private String gioSD;

    public UseServiceId(Customer customer, Service service, String ngaySD, String gioSD) {
        this.customer = customer;
        this.service = service;
        this.ngaySD = ngaySD;
        this.gioSD = gioSD;
    }

    public UseServiceId() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UseServiceId that = (UseServiceId) o;
        return Objects.equals(customer, that.customer) && Objects.equals(service, that.service) && Objects.equals(ngaySD, that.ngaySD) && Objects.equals(gioSD, that.gioSD);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, service, ngaySD, gioSD);
    }
}
