package com.repository;

import com.entities.Customer;
import com.entities.PageAble;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerRepository {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public List<Customer> getAll(){
        Session session = sessionFactory.openSession();
        List<Customer> customerList = session.createQuery("SELECT p FROM Customer p", Customer.class)
                .getResultList();;
        return customerList;
    }

    @Transactional
    public void delete(String maKH) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("DELETE FROM Customer WHERE maKH = :id ");
//        query.setParameter("id", maKH);
        query.setString("id", maKH);
        int count = query.executeUpdate();
    }

    @Transactional
    public void add(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Transactional
    public Customer find(String maKH) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.find(Customer.class, maKH);
        return customer;
    }

    @Transactional
    public void update(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Transactional
    public List<Customer> getAllPageAble(PageAble pageAble) {
        Session session = sessionFactory.getCurrentSession();
        List<Customer> customerList = session.createQuery("SELECT p FROM Customer p", Customer.class)
                .setFirstResult(pageAble.getFirstSelect())// offset
                .setMaxResults(pageAble.getSize()) // limit
                .getResultList();
        return customerList;
    }
}
