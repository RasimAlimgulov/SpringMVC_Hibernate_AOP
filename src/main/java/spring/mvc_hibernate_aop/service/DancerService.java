package spring.mvc_hibernate_aop.service;

import spring.mvc_hibernate_aop.entity.Dancer;

import java.util.List;

public interface DancerService {
    List<Dancer> getAllDancers();
    void addDancer(Dancer dancer);
    Dancer getDancer(int id);
    void deleteDancer(int id);
}
