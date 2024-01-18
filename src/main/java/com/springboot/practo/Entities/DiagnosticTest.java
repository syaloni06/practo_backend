package com.springboot.practo.Entities;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="diagnosticTest")
public class DiagnosticTest {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long diagnosticTest_id;
	private String test_name;
//	private Map<String,Long> slot;
	private Double price;
	
//	@OneToMany(mappedBy="diagnosticTest")
//	List<Booking> booking;
	

}
