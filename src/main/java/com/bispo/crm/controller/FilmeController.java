package com.bispo.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bispo.crm.model.Filme;
import com.bispo.crm.service.FilmeService;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

	@Autowired
	private FilmeService filmeService;

	@GetMapping("/{codigo}")
	public ResponseEntity<Filme> listaFilmes(@PathVariable Long codigo ) {
		
		Filme filme = this.filmeService.obterFilme(codigo);
		
		if ( filme == null ) {
			return ResponseEntity.notFound().build();
		}
			
		return ResponseEntity.ok(filme);
		
	}
	
	
	
}
