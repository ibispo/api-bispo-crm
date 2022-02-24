package com.bispo.crm.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Filme {

	@Id
	private Long id;
	private String description;
	
	
	public Filme(Long id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	
	
	
}
