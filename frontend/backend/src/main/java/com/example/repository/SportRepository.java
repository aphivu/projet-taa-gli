package com.example.repository;

import com.example.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


@Transactional
public interface SportRepository extends JpaRepository<Sport, Long> {

    @Query()
    public Sport getSportByName(String name);
}
