package com.repository;

import com.entities.UseService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UseServiceRepository {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public void save(UseService useService) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(useService);
    }

    @Transactional
    public List<UseService> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<UseService> serviceList = session.createQuery("SELECT p FROM UseService p", UseService.class).getResultList();
        return serviceList;
    }
}
