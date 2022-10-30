package com.repository;

import com.entities.UseMachine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UseMachineRepository {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public void save(UseMachine useMachine) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(useMachine);
    }

    @Transactional
    public List<UseMachine> getAll(){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT p FROM UseMachine p", UseMachine.class).getResultList();
    }
}
