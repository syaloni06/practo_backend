package com.springboot.practo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.practo.Entities.Lab;
import com.springboot.practo.services.LabService;

@RestController
@RequestMapping("/api/lab")
public class LabController {
	
	@Autowired
	LabService labService;
	
	@PostMapping("/create")
	public Lab createLab(@RequestBody Lab lab) {
		return labService.createLab(lab);
	}
	
	@GetMapping("/show")
	public List<Lab> getLab(){
		return labService.getLab();
	}
	
	@GetMapping("/find/{lab_id}")
	public Lab findById(@PathVariable Long lab_id) {
		return labService.findById(lab_id);
	}
	
	@PutMapping("/update/{lab_id}")
	public Lab updateLab(@PathVariable Long lab_id, @RequestBody Lab lab) {
		return labService.updateLab(lab_id, lab);
	}
	
	@DeleteMapping("/delete/{lab_id}")
	public String deleteLab(@PathVariable Long lab_id) {
		return labService.deleteLab(lab_id);
	}
}
