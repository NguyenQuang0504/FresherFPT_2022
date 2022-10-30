package demo.models;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "KhachHang")
public class Customer {
    @Id
    @Pattern(regexp = "^(KH)[0-9]{3}$", message = "Invalid!!!")
    private String maKH;

    @Column(columnDefinition = "nvarchar(50)")
    @Pattern(regexp = "^[0-9a-z A-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]{1,}$", message = "Invalid!!!")
    private String tenKH;

    @Column(columnDefinition = "nvarchar(50)")
    @Pattern(regexp = "^[0-9a-z A-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]{1,}$", message = "Invalid!!!")
    private String diaChi;

    @Column
    @Pattern(regexp = "^[0-9]{11,13}$", message = "Invalid!!!")
    private String sdt;

    @Column
    @Pattern(regexp = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", message = "Invalid!!!")
    private String email;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UseService> serviceList;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UseMachine> useMachines;

    public Customer(String maKH, String tenKH, String diaChi, String sdt, String email) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
    }

    public Customer() {
    }

    public Customer(String maKH) {
        this.maKH = maKH;
    }

    public List<UseMachine> getUseMachines() {
        return useMachines;
    }

    public void setUseMachines(List<UseMachine> useMachines) {
        this.useMachines = useMachines;
    }

    public List<UseService> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<UseService> serviceList) {
        this.serviceList = serviceList;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "maKH='" + maKH + '\'' +
                ", tenKH='" + tenKH + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", sdt='" + sdt + '\'' +
                ", email='" + email + '\'' +
                ", serviceList=" + serviceList +
                ", useMachines=" + useMachines +
                '}';
    }
}
