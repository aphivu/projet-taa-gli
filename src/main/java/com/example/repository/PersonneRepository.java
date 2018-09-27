package com.example.repository;

import com.example.entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface PersonneRepository extends JpaRepository<Personne, Long> {
}
