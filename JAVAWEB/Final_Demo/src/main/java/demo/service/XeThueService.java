package demo.service;

import demo.models.XeThue;
import demo.repository.XeThueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XeThueService {
    @Autowired
    private XeThueRepository xeThueRepository;

    public List<XeThue> findAll() {
        return xeThueRepository.findAll();
    }

    public XeThue findById(String id) {
        return xeThueRepository.findByIdXeThue(id);
    }
}
