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
@Table(name="lab")
public class Lab {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long lab_id;
	private String lab_name;
	private String location;
	private String contact_no;
	
//	@OneToMany(mappedBy="lab")
//	List<Booking> booking;

}
