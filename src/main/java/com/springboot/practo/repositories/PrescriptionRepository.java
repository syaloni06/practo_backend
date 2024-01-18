package com.springboot.practo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.practo.Entities.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription,Long>{

}
