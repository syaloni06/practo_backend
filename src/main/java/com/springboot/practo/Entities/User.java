package com.springboot.practo.Entities;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long user_id;
	private String user_name;
	private String mobile;
	private String email_id;
	private String password;
	private Double total_cost;
	private String user_type;
	
	@OneToMany(mappedBy="user")
	List<Booking> booking;
	
}
