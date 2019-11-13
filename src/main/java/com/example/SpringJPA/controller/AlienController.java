package com.example.SpringJPA.controller;

import com.example.SpringJPA.dao.AlienRepo;
import com.example.SpringJPA.dao.AlienRepoMethod;
import com.example.SpringJPA.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AlienController {
    @Autowired
    AlienRepoMethod repo;
    /*@RequestMapping("/")
    public String home()
    {
        return "home.jsp";
    }*/
    @RequestMapping("/addAlien")
    public String addAlien(Alien alien)
    {
        repo.save(alien);
        return  "home.jsp";
    }
    /*@RequestMapping("/getAlien")
    public String getAlien(@RequestParam int aid)
    {
        ModelAndView mv = new ModelAndView("showAlien.jsp");
        //Alien alien = repo.findAllById(aid);
       // mv.addObject(alien);
        System.out.println(repo.findByAidGreaterthan(102));
        return  "showAlien.jsp";
    }*/
    @RequestMapping("/aliens")
    @ResponseBody
    public Iterable<Alien> getAliens(){
        return repo.findAll();
    }
    @RequestMapping("/aliens/101")
    @ResponseBody
    public String getAlien(){
        return repo.findById(101).toString();
    }
    @RequestMapping("/aliens/{aid}")
    @ResponseBody
    public Optional<Alien> getAlienParam(@PathVariable("aid") int aid){
       // return repo.findById(aid).toString();
        return repo.findById(aid);
    }
    @RequestMapping(value = "/Addalien", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Iterable<Alien> addAliens(@RequestBody Alien alien ){
        repo.save(alien);
        return repo.findAll();
        //return "Success";
    }

    @DeleteMapping(value = "/delete/{aid}")
    @ResponseBody
    public String deleteAlien(@PathVariable int aid){
        // return repo.findById(aid).toString();
       //repo.delete();
       // return repo.findById(aid);*//*
       repo.deleteById(aid);
       return "Deleteed";
    }

    /*@RequestMapping("/customAliens/{aid}")
    @ResponseBody
    public Iterable<Alien> customAliens(@PathVariable int aid){
        return repo.findByaidGreater(aid);
    }

    @RequestMapping(value = "/FindNameAlien", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Iterable<Alien> FindAliens(@RequestBody Alien alien ){
        System.out.println(alien.getAname());
        return repo.findByaidByName(alien.getAname());
        //return "Success";
    }
    @RequestMapping(value = "/FindNameAlienId", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Iterable<Alien> FindNameAlienId(@RequestBody Alien alien ){
        System.out.println(alien.getAname());
        return repo.findByaidByNameid(alien.getAid(),alien.getAname());
        //return "Success";
    }*/

}
