package com.example.repository;

import com.example.entity.Localisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalisationRepository extends JpaRepository<Localisation, Long> {
}
