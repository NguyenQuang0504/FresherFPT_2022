package demo.service;

import demo.models.DangKyThueXe;
import demo.repository.DangKyThueXeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DangKyThueXeService {
    @Autowired
    private DangKyThueXeRepository dangKyThueXeRepository;

    public void save(DangKyThueXe dangKy) {
        dangKyThueXeRepository.save(dangKy);
    }

    public List<DangKyThueXe> findAll() {
        return  dangKyThueXeRepository.findAll();
    }
}
