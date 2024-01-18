package com.springboot.practo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.practo.Entities.Slot;
import com.springboot.practo.services.SlotService;

@RestController
@RequestMapping("/api/slot")
public class SlotController {
	
	@Autowired
	SlotService slotService;
	
	@PostMapping("/create")
	public Slot createSlot(@RequestBody Slot slot) {
		return slotService.createSlot(slot);
	}
	
	@GetMapping("/show")
	public List<Slot> getSlot(){
		return slotService.getSlot();
	}

}
