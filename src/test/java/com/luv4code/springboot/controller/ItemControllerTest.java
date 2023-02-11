package com.luv4code.springboot.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.luv4code.springboot.business.ItemBusinessService;
import com.luv4code.springboot.model.Item;

@WebMvcTest(value = ItemController.class)
class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ItemBusinessService businessService;

	@Test
	void test_dummy_item() throws Exception {
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(builder).andExpect(status().isOk()).andExpect(content().json("{\r\n" + "  \"id\": 1,\r\n"
				+ "  \"name\": \"IPhone\",\r\n" + "  \"price\": 132000,\r\n" + "  \"quantity\": 1\r\n" + "}"))
				.andReturn();
	}

	@Test
	public void test_itemFromBusinessService_basic() throws Exception {
		when(businessService.retreveHardcodedItem()).thenReturn(new Item(2,"IPhone",1000,1));
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/item-from-business-service")
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(builder).andExpect(status().isOk())
				.andExpect(content().json("{id:2,name:IPhone,price:1000}")).andReturn();
	}

}
