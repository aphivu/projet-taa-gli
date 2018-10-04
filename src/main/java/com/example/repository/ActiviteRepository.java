package com.example.repository;

import com.example.entity.Activite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface ActiviteRepository extends JpaRepository<Activite, Long> {

    /*@Query(value = "SELECT a from Activite a WHERE a.personne.id=:pid AND a.sport.id=:sid AND a.localisation.id=:lid")
    public Activite getActiviteByAllId(@Param("pid") long pid,@Param("sid") long sid,@Param("lid") long lid);*/
}
