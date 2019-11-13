package com.example.SpringJPA.dao;

import com.example.SpringJPA.model.Alien;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import java.util.List;
public interface AlienRepo extends Repository<Alien,Integer> {

    /*@Query("SELECT aid FROM Alien WHERE aid > ?1")
    Iterable<Alien> findByaidGreater(int aid);*/

    @Query("FROM Alien WHERE aid > ?1")
    Iterable<Alien> findByaidGreater(int aid);

    @Query("FROM Alien WHERE aname = ?1")
    Iterable<Alien> findByaidByName(String aname);

    @Query("FROM Alien WHERE aid > ?1 and aname=?2")
    Iterable<Alien> findByaidByNameid(int aid,String aname);
}
