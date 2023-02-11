package com.luv4code.springboot.business;

import org.springframework.stereotype.Service;

import com.luv4code.springboot.model.Item;

@Service
public class ItemBusinessService {

	public Item retreveHardcodedItem() {
		return new Item(1, "Samsung", 1200, 1);
	}

}
