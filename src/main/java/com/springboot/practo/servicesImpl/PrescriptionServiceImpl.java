package com.springboot.practo.servicesImpl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.practo.Entities.Prescription;
import com.springboot.practo.repositories.PrescriptionRepository;
import com.springboot.practo.services.PrescriptionService;

@Service
public class PrescriptionServiceImpl implements PrescriptionService{
	
	@Autowired
	PrescriptionRepository prescriptionRepository;
	
	public Prescription handleFileUpload( MultipartFile file) throws IOException {
        Prescription prescription = new Prescription();
        prescription.setFile_name(file.getOriginalFilename());
        prescription.setFile_type(file.getContentType());
        prescription.setFile(file.getBytes());

        return prescriptionRepository.save(prescription);
      }

	@Override
	public ResponseEntity<byte[]> downloadFile(Long id) {
		Optional<Prescription> optionalPrescription = prescriptionRepository.findById(id);
		if (optionalPrescription.isPresent()) {
            Prescription prescription = optionalPrescription.get();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(prescription.getFile_type()));
            headers.setContentDispositionFormData("attachment", "prescription_" + id + getFileExtension(prescription.getFile_type()));
            return new ResponseEntity<>(prescription.getFile(), headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}
	
	private String getFileExtension(String contentType) {
	    MimeType mimeType = MimeTypeUtils.parseMimeType(contentType);
	    String extension = mimeType.getSubtype();  // Assuming you want the subtype as the extension
	    System.out.println("." + extension);
	    return "." + extension;
	}

	@Override
	public Prescription findById(Long id) {
		return prescriptionRepository.findById(id).get();
	}


}
	


