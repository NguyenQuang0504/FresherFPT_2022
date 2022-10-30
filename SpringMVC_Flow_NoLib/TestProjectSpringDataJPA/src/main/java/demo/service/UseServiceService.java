package demo.service;
import demo.models.UseService;
import demo.repository.UseServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UseServiceService {

    @Autowired
    UseServiceRepository useServiceRepository;

    public void save(UseService useService) {
        useServiceRepository.save(useService);
    }

    public List<UseService> getAll() {
        return useServiceRepository.findAll();
    }
}
