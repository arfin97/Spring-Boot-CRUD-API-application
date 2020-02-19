package com.bookshelf.app.dao;

import com.bookshelf.app.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlienDao extends JpaRepository<Alien, Integer> {
    List<Alien> findByTech(String tech);
    List<Alien> findByAidGreaterThan(int aid);


    //find by tech but sorted
    //JPQL
    @Query("from Alien where tech=?1 order by name")
    List<Alien> findTechSorted(String tech);
}