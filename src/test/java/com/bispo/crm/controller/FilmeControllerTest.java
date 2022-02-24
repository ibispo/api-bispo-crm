package com.bispo.crm.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.bispo.crm.model.Filme;
import com.bispo.crm.service.FilmeService;

import io.restassured.http.ContentType;

@WebMvcTest
public class FilmeControllerTest {

	@Autowired
	private FilmeController filmeController;
	
	@MockBean
	private FilmeService filmeService;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.filmeController);
	}
	
	@Test
	public void deveRetornarSucesso_quandoBuscarFilme() {

		when(this.filmeService.obterFilme(1L))
			.thenReturn(new Filme(1L, "Filme de teste"));
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/filmes/{codigo}", 1L)
		.then()
			.statusCode(HttpStatus.OK.value());
		
	}
	
	
	@Test
	public void deveRetornarNaoEncontrado_quandoBuscarFilme() {

		when(this.filmeService.obterFilme(5L))
			.thenReturn(null);
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/filmes/{codigo}", 5L)
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
		
		
	}
	
	
	
}
