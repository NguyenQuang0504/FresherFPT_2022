package demo.service;

import demo.models.GoiCuoc;
import demo.repository.GoiCuocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
* @author: QuangNV51
* @since: 31/10/2022 15:47
* @description: 
*/
@Service
public class GoiCuocService {
    /*
    * @author: QuangNV51
    * @since: 31/10/2022 15:47
    * @description: 
    */
    @Autowired
    private GoiCuocRepository goiCuocRepository;

    /*
    * @author: QuangNV51
    * @since: 31/10/2022 15:47
    * @description: 
    */
    public List<GoiCuoc> findAll() {
        return goiCuocRepository.findAll();
    }

    /*
    * @author: QuangNV51
    * @since: 31/10/2022 16:10
    * @description: 
    */
    public GoiCuoc findById(String maGC) {
        return goiCuocRepository.getGoiCuoc(maGC);
    }
}
