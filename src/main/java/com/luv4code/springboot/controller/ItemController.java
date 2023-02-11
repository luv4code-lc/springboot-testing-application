package com.luv4code.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv4code.springboot.business.ItemBusinessService;
import com.luv4code.springboot.model.Item;

@RestController
public class ItemController {

	@Autowired
	private ItemBusinessService businessService;

	@GetMapping("/dummy-item")
	public Item dummyItem() {
		return new Item(1, "IPhone", 132000, 1);
	}

	@GetMapping("/item-from-business-service")
	public Item itemFromBusinessService() {
		return businessService.retreveHardcodedItem();
	}

}
