package com.springboot.practo.Entities;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
@Table(name="prescription")
public class Prescription {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long prescription_id;
	private String file_name;
	private String file_type;
    @Lob
    @Column(length = 10485760) // 10 MB in bytes (1024 * 1024 * 10)
    @JsonIgnore
    private byte[] file;
    
       

}
