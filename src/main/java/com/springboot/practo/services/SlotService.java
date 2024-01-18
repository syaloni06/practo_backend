package com.springboot.practo.services;

import java.util.List;

import com.springboot.practo.Entities.Slot;

public interface SlotService {
	Slot createSlot(Slot slot);
	List<Slot> getSlot();

}
