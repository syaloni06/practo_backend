package com.springboot.practo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.practo.Entities.DiagnosticTest;

public interface DiagnosticTestRepository extends JpaRepository<DiagnosticTest,Long>{

}
