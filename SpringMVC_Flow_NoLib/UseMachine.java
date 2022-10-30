package demo.models;


import javax.persistence.*;

@Entity
@Table(name = "SuDungMay")
@IdClass(UseMachineId.class)
public class UseMachine {

    @Id
    private String maKH;

    @Id
    private String ngayBD;

    @Id
    private String gioBD;

    @Id
    private String maMay;

    @Column
    private Integer thoigianSD;

    @ManyToOne
    @JoinColumn(name = "maKH", insertable = false, updatable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "maMay", insertable = false, updatable = false)
    private Machine machine;


    public UseMachine(Customer customer, Machine machine, String ngayBD, String gioBD, Integer thoigianSD) {
        this.customer = customer;
        this.machine = machine;
        this.ngayBD = ngayBD;
        this.gioBD = gioBD;
        this.thoigianSD = thoigianSD;
    }

    public UseMachine() {
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getMaMay() {
        return maMay;
    }

    public void setMaMay(String maMay) {
        this.maMay = maMay;
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
}
