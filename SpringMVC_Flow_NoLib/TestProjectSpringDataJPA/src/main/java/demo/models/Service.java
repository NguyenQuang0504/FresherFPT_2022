package demo.models;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "DichVu")
public class Service {

    @Id
    @Pattern(regexp = "^(DV)[0-9]{3}$", message = "Invalid!!!")
    private String maDV;

    @Column(columnDefinition = "nvarchar(50)")
    @Pattern(regexp = "^[0-9a-z A-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]{1,}$", message = "Invalid!!!")
    private String tenDV;

    @Column(columnDefinition = "nvarchar(50)")
    @Pattern(regexp = "^[0-9a-z A-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]{1,}$", message = "Invalid!!!")
    private String donVi;

    @Column
    private Integer donGia;

    @OneToMany(mappedBy = "service", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UseService> serviceList;

    public Service(String maDV, String tenDV, String donVi, Integer donGia) {
        this.maDV = maDV;
        this.tenDV = tenDV;
        this.donVi = donVi;
        this.donGia = donGia;
    }

    public Service(String maDV) {
        this.maDV = maDV;
    }

    public Service() {
    }

    public List<UseService> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<UseService> serviceList) {
        this.serviceList = serviceList;
    }

    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public Integer getDonGia() {
        return donGia;
    }

    public void setDonGia(Integer donGia) {
        this.donGia = donGia;
    }
}
