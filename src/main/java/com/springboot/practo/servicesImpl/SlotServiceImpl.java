package com.springboot.practo.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.practo.Entities.Slot;
import com.springboot.practo.repositories.SlotRepository;
import com.springboot.practo.services.SlotService;
@Service
public class SlotServiceImpl implements SlotService{
	
	@Autowired
	SlotRepository slotRepository;

	@Override
	public Slot createSlot(Slot slot) {
		return slotRepository.save(slot);
	}

	@Override
	public List<Slot> getSlot() {
		return slotRepository.findAll();
	}

}
