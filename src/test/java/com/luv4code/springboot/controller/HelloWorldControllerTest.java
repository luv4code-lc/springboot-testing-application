package com.luv4code.springboot.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(value = HelloWorldController.class)
class HelloWorldControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void test_hello_world() throws Exception {

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hello-world")
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals("Hello World", result.getResponse().getContentAsString());

	}

}
