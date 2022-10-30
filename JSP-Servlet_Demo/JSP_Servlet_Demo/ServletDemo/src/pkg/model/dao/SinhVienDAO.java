package pkg.model.dao;

import java.util.ArrayList;
import java.util.List;

import pkg.model.bean.SinhVien;

public class SinhVienDAO {

    public List<SinhVien> findAllSinhVien() {
        //Call database, dung sql de get tat ca sinh vien
        
        //Gia su sinh vien sau khi get se co data dummy nhu sau
        List<SinhVien> sinhVienList = new ArrayList<SinhVien>();
        sinhVienList.add(new SinhVien("SV0001", "Nguyen Van A", 18));
        sinhVienList.add(new SinhVien("SV0002", "Nguyen Van A1", 19));
        sinhVienList.add(new SinhVien("SV0003", "Nguyen Van A2", 20));
        sinhVienList.add(new SinhVien("SV0004", "Nguyen Van A3", 21));
        sinhVienList.add(new SinhVien("SV0005", "Nguyen Van A4", 22));
        
        return sinhVienList;
    }
    
    public SinhVien findSinhVienById(String svId) {
        //Call database, dung sql de get Sinh Vien voi id truyen vao
        
        //Gia su sinh vien sau khi get se co data dummy nhu sau
        SinhVien sv = new SinhVien(svId, "SinhVien Name Dummy", 0);
        
        return sv;
    }
}
