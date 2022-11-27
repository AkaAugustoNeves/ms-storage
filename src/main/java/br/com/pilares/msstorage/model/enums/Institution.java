package br.com.pilares.msstorage.model.enums;

import java.util.Arrays;
import java.util.List;

public enum Institution {

	PERSON(0L,"PERSON");
	
	private Long id;
	private String nome;
	
	private Institution() {
		// TODO Auto-generated constructor stub
	}
	
	private Institution(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static List<Institution> valores(){
		return Arrays.asList(values());
	}
	
}
