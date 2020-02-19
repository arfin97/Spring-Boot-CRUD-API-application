package com.bookshelf.app.controller;

import com.bookshelf.app.dao.AlienDao;
import com.bookshelf.app.model.Alien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class HomeController {

    @Autowired
    AlienDao alienDao;


    @RequestMapping("/home")
    public ModelAndView home(Alien alien){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("obj", alien);
        return modelAndView;
    }

    //From form save
    @RequestMapping("/addAlien")
    public ModelAndView addAlien(Alien alien){
        System.out.println(alien);
        alienDao.save(alien);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    //From form search
    @RequestMapping("/getAlien")
    public ModelAndView getAlienById(@RequestParam("aid") int aid){
        Alien alien = alienDao.findById(aid).orElse(new Alien());
        ModelAndView modelAndView = new ModelAndView("alien");
        modelAndView.addObject("alien", alien);
        System.out.println(alienDao.findTechSorted("Java"));
        return modelAndView;

    }

    @GetMapping(path="/alien", produces={"application/json"})
    public List<Alien> getAliens(){
        return alienDao.findAll();
    }

    @PostMapping(path="/alien", produces={"application/json"})
    public Alien postAlien(@RequestBody Alien alien){
        System.out.println(alien);
        alienDao.save(alien);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return alien;
    }

    @DeleteMapping("/alien/{aid}")
    public String deleteAlien(@PathVariable("aid") int aid){
        Alien alien = alienDao.getOne(aid);
        alienDao.delete(alien);
        return "Deleted";
    }

    @PutMapping("/alien")
    public Alien saveOrUpdateAlien(@RequestBody Alien alien){
        alienDao.save(alien);
        return alien;
    }

    @GetMapping("/alien/{aid}")
    public Optional<Alien> getAliens(@PathVariable("aid") int aid){
        return alienDao.findById(aid);
    }




}
