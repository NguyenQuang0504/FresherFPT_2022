package demo.service;
import demo.models.PageAble;
import demo.models.Service;
import demo.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService {
    @Autowired
    ServiceRepository serviceRepository;

    public List<Service> getAll() {
        return serviceRepository.findAll();
    }

    public void save(Service serviceCreate) {
        serviceRepository.save(serviceCreate);
    }

    public void delete(String maDV) {

        serviceRepository.deleteById(maDV);
    }

    public Service find(String maDV) {
        return serviceRepository.findByIdDV(maDV);
    }


//    public List<Service> getAllPageAble(PageAble pageAble) {
//        return serviceRepository.getAllPageAble(pageAble);
//    }
    public Integer getTotalPage(PageAble pageAble){
        return (int) Math.ceil((double) getAll().size()/pageAble.getSize());
    }

    public List<Service> getAllPageAble(PageAble pageAble) {
        return serviceRepository.getAllPageAble((pageAble.getCurrent()-1)*pageAble.getSize(), pageAble.getSize());
    }
}
