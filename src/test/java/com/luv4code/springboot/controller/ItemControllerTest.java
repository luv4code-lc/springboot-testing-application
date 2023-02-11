package com.luv4code.springboot.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(value = ItemController.class)
class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void test_dummy_item() throws Exception {
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(builder)
			.andExpect(status().isOk())
			.andExpect(content().json("{\r\n"
					+ "  \"id\": 1,\r\n"
					+ "  \"name\": \"IPhone\",\r\n"
					+ "  \"price\": 132000,\r\n"
					+ "  \"quantity\": 1\r\n"
					+ "}"))
				.andReturn();
	}

}
