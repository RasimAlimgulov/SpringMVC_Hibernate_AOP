package spring.mvc_hibernate_aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.mvc_hibernate_aop.entity.Dancer;
import spring.mvc_hibernate_aop.service.DancerService;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private DancerService dancerService;

    @RequestMapping("/")
    public String firstWindow(){
        return "first-page";
    }

    @RequestMapping("/dancerBase")
    public String getAllDancers(Model model){
        List<Dancer> dancers= dancerService.getAllDancers();
        model.addAttribute("dancers",dancers);
        return "dancer-base";
    }
    @RequestMapping("/addDancer")
    public String addDancer(Model model){
        Dancer dancer=new Dancer();
        model.addAttribute("dancer",dancer);
        return "add-Dancer";
    }
    @RequestMapping("saveDancer")
    public String saveDancer(@ModelAttribute("dancer") Dancer dancer){
        dancerService.addDancer(dancer);
        return "redirect:/dancerBase";
    }
    @RequestMapping("/updateDancer")
    public String updateDancer(@RequestParam("dancer_id") int id, Model model){
        Dancer dancer=dancerService.getDancer(id);
        model.addAttribute("dancer",dancer);
        return "add-Dancer";
    }
    @RequestMapping("/deleteDancer")
    public String deleteDancer(@RequestParam("dancer_id")int id){
        dancerService.deleteDancer(id);
        return "redirect:/dancerBase";
    }

}
