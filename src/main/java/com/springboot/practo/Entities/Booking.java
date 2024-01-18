package com.springboot.practo.Entities;




import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name="booking")
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long booking_id;
	private String booked_by;
	private String choose_test;
	private String booking_date;
	private String choose_lab;
	private String choose_slot;
	private Double total_price;
	private Long p_id;
	
		
//	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//	private Lab lab;
//	
//	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//	private Slot slot;

	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonIgnore
	private User user;
	
//	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//	private DiagnosticTest diagnosticTest;
	

}
