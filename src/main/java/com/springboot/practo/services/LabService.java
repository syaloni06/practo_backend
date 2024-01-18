package com.springboot.practo.services;

import java.util.List;

import com.springboot.practo.Entities.Lab;

public interface LabService {
	Lab createLab(Lab lab);
	List<Lab> getLab();
	Lab findById(Long lab_id);
	Lab updateLab(Long lab_id, Lab lab);
	String deleteLab(Long lab_id);

}
