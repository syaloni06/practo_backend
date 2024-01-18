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

import com.springboot.practo.Entities.DiagnosticTest;
import com.springboot.practo.Entities.User;
import com.springboot.practo.services.DiagnosticTestService;

@RestController
@RequestMapping("/api/diagnosticTest")
public class DiagnosticTestController {
	
	@Autowired
	DiagnosticTestService diagnosticTestService;
	
	@PostMapping("/create")
	public DiagnosticTest createDiagnosticTest(@RequestBody DiagnosticTest diagnosticTest) {
		return diagnosticTestService.createDiagnosticTest(diagnosticTest);
	}
	
	@GetMapping("/show")
	public List<DiagnosticTest> getDiagnosticTest() {
		return diagnosticTestService.getDiagnosticTest();
	}
	
	@GetMapping("/find/{diagnostic_id}")
	public DiagnosticTest findById(@PathVariable Long diagnosticTest_id) {
		return diagnosticTestService.findById(diagnosticTest_id);
	}
	
	@PutMapping("/update/{diagnosticTest_id}")
	public DiagnosticTest updateDiagnosticTest(@PathVariable Long diagnosticTest_id, @RequestBody DiagnosticTest diagnosticTest) {
		return diagnosticTestService.updateDiagnosticTest(diagnosticTest_id, diagnosticTest);
	}
	
	@DeleteMapping("/delete/{diagnosticTest_id}")
	public String deleteDiagnosticTest(@PathVariable Long diagnosticTest_id) {
		return diagnosticTestService.deleteDiagnosticTest(diagnosticTest_id);
	}
	
	@PostMapping("/booking_test")
	public String bookingDiagnosticTest(@RequestBody User user) {
		return diagnosticTestService.bookingDiagnosticTest(user);
	}

}
