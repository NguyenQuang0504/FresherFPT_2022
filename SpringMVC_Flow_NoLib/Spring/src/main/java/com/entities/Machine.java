package com.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "May")
public class Machine {

    @Id
    @Pattern(regexp = "^(M)[0-9]{3}$", message = "Invalid!!!")
    private String maMay;

    @Column(columnDefinition = "nvarchar(50)")
    @Pattern(regexp = "^[0-9a-z A-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]{1,}$", message = "Invalid!!!")
    private String viTri;

    @Column(columnDefinition = "nvarchar(50)")
    @Pattern(regexp = "^[0-9a-z A-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]{1,}$", message = "Invalid!!!")
    private String trangThai;

    @OneToMany(mappedBy = "machine", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UseMachine> machineList;

    public Machine(String maMay, String viTri, String trangThai) {
        this.maMay = maMay;
        this.viTri = viTri;
        this.trangThai = trangThai;
    }

    public Machine(String maMay, String viTri, String trangThai, List<UseMachine> machineList) {
        this.maMay = maMay;
        this.viTri = viTri;
        this.trangThai = trangThai;
        this.machineList = machineList;
    }

    public Machine() {
    }

    public List<UseMachine> getMachineList() {
        return machineList;
    }

    public void setMachineList(List<UseMachine> machineList) {
        this.machineList = machineList;
    }

    public String getMaMay() {
        return maMay;
    }

    public void setMaMay(String maMay) {
        this.maMay = maMay;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "maMay='" + maMay + '\'' +
                ", viTri='" + viTri + '\'' +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }
}
