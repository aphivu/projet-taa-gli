package com.example.repository;

import com.example.entity.Activite;
import com.example.entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface PersonneRepository extends JpaRepository<Personne, Long> {

    @Query(value = "select a from Activite a where a.personne.id=:id")
    public List<Activite> getActiviteByPersonneId(@Param("id") long id);

}
