package com.entities;


import javax.persistence.*;

@Entity
@Table(name = "SuDungMay")
@IdClass(UseMachineId.class)
public class UseMachine {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maKH", referencedColumnName = "maKH")
    private Customer customer;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maMay", referencedColumnName = "maMay")
    private Machine machine;

    @Id
    private String ngayBD;

    @Id
    private String gioBD;
    @Column
    private Integer thoigianSD;

    public UseMachine(Customer customer, Machine machine, String ngayBD, String gioBD, Integer thoigianSD) {
        this.customer = customer;
        this.machine = machine;
        this.ngayBD = ngayBD;
        this.gioBD = gioBD;
        this.thoigianSD = thoigianSD;
    }

    public UseMachine() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
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

    public Integer getThoigianSD() {
        return thoigianSD;
    }

    public void setThoigianSD(Integer thoigianSD) {
        this.thoigianSD = thoigianSD;
    }

    @Override
    public String toString() {
        return "UseMachine{" +
                "customer=" + customer +
                ", machine=" + machine +
                ", ngayBD='" + ngayBD + '\'' +
                ", gioBD='" + gioBD + '\'' +
                ", thoigianSD=" + thoigianSD +
                '}';
    }
}
