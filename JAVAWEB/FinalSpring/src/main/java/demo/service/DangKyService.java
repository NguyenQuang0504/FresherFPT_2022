package demo.service;

import demo.dto.DangKyDTO;
import demo.models.DangKyDV;
import demo.repository.DangKyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DangKyService {
    @Autowired
    private DangKyRepository dangKyRepository;

    /*
    * @author: QuangNV51
    * @since: 31/10/2022 16:11
    * @description:
    */
    public void save(DangKyDV dangKy) {
        dangKyRepository.save(dangKy);
    }

    /*
    * @author: QuangNV51
    * @since: 31/10/2022 16:11
    * @description:
    */
    public List<DangKyDTO> find() {
        return dangKyRepository.find();
    }

    /*
    * @author: QuangNV51
    * @since: 31/10/2022 16:11
    * @description:
    */
    public List<DangKyDTO> search(String nameKH, String nameGC) {
        return dangKyRepository.search('%'+nameKH+'%', '%'+nameGC+'%');
    }
    /*
    * @author: QuangNV51
    * @since: 31/10/2022 16:11
    * @description:
    */
    public DangKyDV findDK(String maKH) {
        return dangKyRepository.getKH(maKH);
    }
}
