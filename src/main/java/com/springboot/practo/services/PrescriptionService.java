package com.springboot.practo.services;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.practo.Entities.DiagnosticTest;
import com.springboot.practo.Entities.Prescription;



public interface PrescriptionService {
	Prescription handleFileUpload( MultipartFile file) throws IOException;
	ResponseEntity<byte[]> downloadFile(Long id);
	Prescription findById(Long id);
}
