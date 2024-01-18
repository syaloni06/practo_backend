package com.springboot.practo.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.practo.Entities.Lab;
import com.springboot.practo.repositories.LabRepository;
import com.springboot.practo.services.LabService;
@Service
public class LabServiceImpl implements LabService{
	
	@Autowired
	LabRepository labRepository;

	@Override
	public Lab createLab(Lab lab) {
		return labRepository.save(lab);
	}

	@Override
	public List<Lab> getLab() {
		return labRepository.findAll();
	}

	@Override
	public Lab findById(Long lab_id) {
		return labRepository.findById(lab_id).get();
	}

	@Override
	public Lab updateLab(Long lab_id, Lab lab) {
		Lab l = labRepository.findById(lab_id).get();
		l.setLab_name(lab.getLab_name());
		l.setLocation(lab.getLocation());
		l.setContact_no(lab.getContact_no());
		return labRepository.save(l);
	}

	@Override
	public String deleteLab(Long lab_id) {
		labRepository.deleteById(lab_id);
		return "Your record has been deleted";
	}

}
