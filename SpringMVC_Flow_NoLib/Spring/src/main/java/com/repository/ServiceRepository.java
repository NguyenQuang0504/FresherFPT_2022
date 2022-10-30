package com.repository;

import com.entities.PageAble;
import com.entities.Service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ServiceRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public List<Service> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Service> serviceList = session.createQuery("SELECT p FROM Service p", Service.class).getResultList();
        return serviceList;
    }

    @Transactional
    public void save(Service serviceCreate) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(serviceCreate);
    }

    @Transactional
    public void delete(String maDV) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("DELETE FROM Service WHERE maDV =: id");
        query.setString("id", maDV);
        query.executeUpdate();
    }

    @Transactional
    public Service find(String maDV) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(Service.class, maDV);
    }

    @Transactional
    public List<Service> getAllPageAble(PageAble pageAble) {
        Session session = sessionFactory.getCurrentSession();
        List<Service> list = session.createQuery("SELECT p FROM Service p", Service.class)
                .setFirstResult(pageAble.getFirstSelect())
                .setMaxResults(pageAble.getSize())
                .getResultList();
        return list;
    }
}
