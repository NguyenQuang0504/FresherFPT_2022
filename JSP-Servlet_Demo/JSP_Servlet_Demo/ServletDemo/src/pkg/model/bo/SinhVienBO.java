package pkg.model.bo;

import java.util.List;

import pkg.model.bean.SinhVien;
import pkg.model.dao.SinhVienDAO;

public class SinhVienBO {

    public List<SinhVien> getAllSinhVien() {
        SinhVienDAO svDao = new SinhVienDAO();
        return svDao.findAllSinhVien();
    }
    
    public SinhVien getSinhVienById(String svId) {
        SinhVienDAO svDao = new SinhVienDAO();
        return svDao.findSinhVienById(svId);
    }
}
