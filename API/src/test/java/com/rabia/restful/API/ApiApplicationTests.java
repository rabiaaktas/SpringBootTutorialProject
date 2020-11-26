package com.rabia.restful.API;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static com.jayway.restassured.RestAssured.*;

import com.jayway.restassured.RestAssured;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApiApplication.class)
@TestPropertySource(value = {"classpath:applicationtest.properties"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ApiApplicationTests {
	@Value("${server.port}")
	int port;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	public void getProductsTest(){
		get("/products").getBody().print();
	}
	@Test
	void contextLoads() {
	}

	@Before
	public void setBaseURI(){
		RestAssured.port  = port;
		RestAssured.baseURI = "http://localhost"; // will be replaced a properied one
	}
}
