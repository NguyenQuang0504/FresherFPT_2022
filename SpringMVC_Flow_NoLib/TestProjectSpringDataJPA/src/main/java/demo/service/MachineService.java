package demo.service;
import demo.models.Machine;
import demo.models.PageAble;
import demo.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineService {
    @Autowired
    MachineRepository machineRepository;

    public List<Machine> getAll() {
        return  machineRepository.findAll();
    }

    public void save(Machine machine) {
        machineRepository.save(machine);
    }

    public void delete(String maMay) {
        machineRepository.deleteById(maMay);
    }

    public Machine find(String maMay) {
        return machineRepository.find(maMay);
    }

//    public List<Machine> getAllPageAble(PageAble pageAble) {
//        return machineRepository.getAllPageAble(pageAble);
//    }

    public Integer getTotalPage(PageAble pageAble) {
        return (int)Math.ceil((double) getAll().size()/pageAble.getSize());
    }

    public List<Machine> getAllPageAble(PageAble pageAble) {
        return machineRepository.getAllPageAble((pageAble.getCurrent()-1)*pageAble.getSize(), pageAble.getSize());
    }
}
