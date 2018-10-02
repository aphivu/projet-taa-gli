package com.example.repository;

import com.example.entity.Localisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface LocalisationRepository extends JpaRepository<Localisation, Long> {

    @Query()
    public Localisation getLocalisationByVille(String ville);
}
