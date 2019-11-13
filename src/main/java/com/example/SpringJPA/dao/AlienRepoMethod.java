package com.example.SpringJPA.dao;

import com.example.SpringJPA.model.Alien;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

public interface AlienRepoMethod extends CrudRepository<Alien,Integer> {
}
