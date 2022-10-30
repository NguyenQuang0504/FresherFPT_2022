package com.repository;

import com.entities.Machine;
import com.entities.PageAble;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class MachineRepository {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public List<Machine> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Machine> list = session.createQuery("SELECT p FROM Machine p", Machine.class).getResultList();
        return list;
    }

    @Transactional
    public void save(Machine machine) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(machine);
    }

    @Transactional
    public void delete(String maMay) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("DELETE FROM Machine WHERE maMay = :id");
        query.setString("id", maMay);
        query.executeUpdate();
    }

    @Transactional
    public Machine find(String maMay) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(Machine.class, maMay);
    }

    @Transactional
    public List<Machine> getAllPageAble(PageAble pageAble) {
        Session session = sessionFactory.getCurrentSession();
        List<Machine> list = session.createQuery("SELECT p FROM Machine p", Machine.class)
                .setFirstResult(pageAble.getFirstSelect())
                .setMaxResults(pageAble.getSize())
                .getResultList();
        return list;
    }
}
