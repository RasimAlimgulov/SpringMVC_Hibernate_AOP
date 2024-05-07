package spring.mvc_hibernate_aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.mvc_hibernate_aop.dao.DancerDAO;
import spring.mvc_hibernate_aop.entity.Dancer;

import java.util.List;
@Service
public class DancerServiceImpl implements DancerService{
    @Autowired
    private DancerDAO dancerDAO;
    @Override
    @Transactional
    public List<Dancer> getAllDancers() {
        return dancerDAO.getAllDancers();
    }

    @Override
    @Transactional
    public void addDancer(Dancer dancer) {
        dancerDAO.addDancer(dancer);
    }

    @Override
    @Transactional
    public Dancer getDancer(int id) {
        return dancerDAO.getDancer(id);
    }

    @Override
    @Transactional
    public void deleteDancer(int id) {
        dancerDAO.deleteDancer(id);
    }
}
