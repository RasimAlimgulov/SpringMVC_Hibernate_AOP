package spring.mvc_hibernate_aop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.mvc_hibernate_aop.entity.Dancer;

import java.util.List;
@Repository
public class DancerDAOImpl implements DancerDAO{
    @Autowired
    private SessionFactory sessionFactory;
    public List<Dancer> getAllDancers() {
        Session session=sessionFactory.getCurrentSession();
        List<Dancer> dancers=session.createQuery("from Dancer ",Dancer.class).getResultList();
        return dancers;
    }

    @Override
    public void addDancer(Dancer dancer) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(dancer);
    }

    @Override
    public Dancer getDancer(int id) {
        Session session=sessionFactory.getCurrentSession();
        return session.get(Dancer.class,id);
    }

    @Override
    public void deleteDancer(int id) {
        Query<Dancer> query=sessionFactory.getCurrentSession().createQuery("delete from Dancer " +
                "where id=:idParam");
        query.setParameter("idParam",id);
        query.executeUpdate();
    }


}
