package com.example.repository;

import com.example.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;


@Transactional
public interface SportRepository extends JpaRepository<Sport, Long> {
}
