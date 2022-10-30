package demo.models;

import java.io.Serializable;
import java.util.Objects;

public class UseMachineId implements Serializable {

    private static final long serialVersionUID = 1L;
    private String ngayBD;
    private String gioBD;
    private Customer customer;
    private Machine machine;

    public UseMachineId(String ngayBD, String gioBD, Customer customer, Machine machine) {
        this.ngayBD = ngayBD;
        this.gioBD = gioBD;
        this.customer = customer;
        this.machine = machine;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UseMachineId that = (UseMachineId) o;
        return Objects.equals(ngayBD, that.ngayBD) && Objects.equals(gioBD, that.gioBD) && Objects.equals(customer, that.customer) && Objects.equals(machine, that.machine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ngayBD, gioBD, customer, machine);
    }
}
