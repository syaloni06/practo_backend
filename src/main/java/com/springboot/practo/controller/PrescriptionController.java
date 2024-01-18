package com.springboot.practo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.practo.Entities.Prescription;
import com.springboot.practo.services.PrescriptionService;

@RestController
@RequestMapping("/api/prescription")
public class PrescriptionController {
	
	@Autowired
	PrescriptionService prescriptionService;
	
	@PostMapping("/upload")
    public Prescription handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
		return prescriptionService.handleFileUpload(file);
	}
	
	@GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
    	return prescriptionService.downloadFile(id);
    }

}
