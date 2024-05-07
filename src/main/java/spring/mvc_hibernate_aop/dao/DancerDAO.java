package spring.mvc_hibernate_aop.dao;

import spring.mvc_hibernate_aop.entity.Dancer;

import java.util.List;

public interface DancerDAO {
    List<Dancer> getAllDancers();
    void addDancer(Dancer dancer);
}
