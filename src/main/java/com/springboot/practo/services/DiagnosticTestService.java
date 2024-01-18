package com.springboot.practo.services;

import java.util.List;

import com.springboot.practo.Entities.DiagnosticTest;
import com.springboot.practo.Entities.User;




public interface DiagnosticTestService {
	DiagnosticTest createDiagnosticTest(DiagnosticTest diagnosticTest);
	List<DiagnosticTest> getDiagnosticTest();
	DiagnosticTest findById(Long diagnosticTest_id);
	DiagnosticTest updateDiagnosticTest(Long diagnosticTest_id, DiagnosticTest diagnosticTest);
	String deleteDiagnosticTest(Long diagnosticTest_id);
	String bookingDiagnosticTest(User user);
}
