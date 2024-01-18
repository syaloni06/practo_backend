package com.springboot.practo.servicesImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.practo.Entities.Booking;
import com.springboot.practo.Entities.DiagnosticTest;
import com.springboot.practo.Entities.Lab;
import com.springboot.practo.Entities.Prescription;
import com.springboot.practo.Entities.Slot;
import com.springboot.practo.Entities.User;
import com.springboot.practo.repositories.BookingRepository;
import com.springboot.practo.repositories.DiagnosticTestRepository;
import com.springboot.practo.repositories.LabRepository;
import com.springboot.practo.repositories.PrescriptionRepository;
import com.springboot.practo.repositories.SlotRepository;
import com.springboot.practo.repositories.UserRepository;
import com.springboot.practo.services.DiagnosticTestService;
@Service
public class DiagnosticTestServiceImpl implements DiagnosticTestService{
	
	@Autowired
	DiagnosticTestRepository diagnosticTestRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	SlotRepository slotRepository;
	
	@Autowired
	LabRepository labRepository;
	
	@Override
	public DiagnosticTest createDiagnosticTest(DiagnosticTest diagnosticTest) {
		return diagnosticTestRepository.save(diagnosticTest);
	}

	@Override
	public List<DiagnosticTest> getDiagnosticTest() {
		return diagnosticTestRepository.findAll();
	}

	@Override
	public DiagnosticTest findById(Long diagnosticTest_id) {
		return diagnosticTestRepository.findById(diagnosticTest_id).get();
	}

	@Override
	public DiagnosticTest updateDiagnosticTest(Long diagnosticTest_id, DiagnosticTest diagnosticTest) {
		DiagnosticTest dt = diagnosticTestRepository.findById(diagnosticTest_id).get();
		dt.setTest_name(diagnosticTest.getTest_name());
		dt.setPrice(diagnosticTest.getPrice());
		return diagnosticTestRepository.save(dt);
	}

	@Override
	public String deleteDiagnosticTest(Long diagnosticTest_id) {
		diagnosticTestRepository.deleteById(diagnosticTest_id);
		return "Your record has been deleted";
	}

	@Override
	public String bookingDiagnosticTest(User user) {
		
		List<Booking> booking = user.getBooking();
		Long id = user.getUser_id();
		User u = userRepository.findById(id).get();
		Double sum =0.00;
		System.out.println(booking);
		for(Booking i: booking) {
//			DiagnosticTest dt = diagnosticTestRepository.findById(i.getDiagnostic_test()).get();
			
			i.setBooked_by(u.getUser_name());
			i.setUser(u);
			
//			Prescription p = prescriptionRepository.findById(i.getP_id()).get();
//			i.set  
			
//			Lab lab= labRepository.findById(i.getChoose_lab()).get();
//			i.setLab(lab);
			
					
			try {
				
				List<DiagnosticTest> dg = diagnosticTestRepository.findAll();
				for(DiagnosticTest dt : dg) {
					if(i.getChoose_test().equals(dt.getTest_name())) {
//						i.setDiagnosticTest(dt);
						sum += dt.getPrice();
						i.setTotal_price(dt.getPrice());
//						dt.setSlot_capacity(dt.getSlot_capacity()-1);
										
					}
				}
				
//				List<Slot> s = slotRepository.findAll();
//				for(Slot slot : s) {
//					if(i.getChoose_slot().equals(slot.getSlot_name())) {
//						i.setSlot(slot);
////						diagnosticTestRepository.save(dt);
////						i.setDiagnosticTest(dt);
////						dt.setSlot_capacity(dt.getSlot_capacity()-1);
//										
//					}
//				}
//				List<Lab> l = labRepository.findAll();
//				for(Lab lb : l) {
//					if(i.getChoose_lab().equals(lb.getLab_name())) {
//						i.setLab(lb);
////						diagnosticTestRepository.save(dt);
////						i.setDiagnosticTest(dt);
////						dt.setSlot_capacity(dt.getSlot_capacity()-1);
//										
//					}
//				}
//				
				
				
				
			}
			catch(RuntimeException e) {
				return e.getMessage();
			}
			bookingRepository.save(i);
	
		}
		if(u.getTotal_cost()!=null) {
		u.setTotal_cost(sum+u.getTotal_cost());
		}else {
			u.setTotal_cost(sum);
		}
		userRepository.save(u);
		return "Your booking is successful";
		
			// slot booking functionality using map
			/*for(Map.Entry<String, Long> entry : dt.getSlot().entrySet()) {
			slot_name = entry.getKey();
			slot_capacity = entry.getValue();
			if(i.getChose_slot().equals(slot_name)) {
				if(slot_capacity==0) {
					throw new RuntimeException(slot_name+" is not available");
				}
				slot_capacity -= 1;
				entry.setValue(slot_capacity);
				diagnosticTestRepository.save(dt);
				sum += dt.getPrice();
				i.setTotal_price(sum);
				bookingRepository.save(i);
			}
		} */
	}
	

}
