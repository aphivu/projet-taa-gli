package com.example.repository;

import com.example.entity.Activite;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface ActiviteRepository extends JpaRepository<Activite, Long> {
    List<Activite> getAllActivitesByPersonneId(long id);
    Activite getActiviteByPersonneId(long id);
}
