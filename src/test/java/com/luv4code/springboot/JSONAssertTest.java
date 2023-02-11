package com.luv4code.springboot;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JSONAssertTest {

	String actualResponse = "{\"id\":1,\"name\":\"IPhone\",\"price\":132000,\"quantity\":1}";

	@Test
	void jsonAssert_StrictTrue_ExactMatchExceptForSpace() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"IPhone\",\"price\":132000,\"quantity\":1}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
	}
	
	@Test
	void jsonAssert_StrictFalse() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"IPhone\",\"price\":132000}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}

}
