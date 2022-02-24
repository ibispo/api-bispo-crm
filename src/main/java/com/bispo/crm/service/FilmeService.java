package com.bispo.crm.service;

import org.springframework.stereotype.Service;

import com.bispo.crm.model.Filme;

@Service
public class FilmeService {

	public Filme obterFilme(Long cod) {

		if ( cod > 100 ) {
			return null;
		}
			
		return new Filme(cod, "Filme criado por mim");
		
	}

}
