package br.com.pilares.msstorage.model.enums;

import java.util.Arrays;
import java.util.List;

public enum Artifact {
	
	DOCUMENT(0L,"DOCUMENT");
	
	private Long id;
	private String nome;
	
	private Artifact() {
		// TODO Auto-generated constructor stub
	}
	
	private Artifact(Long id, String nome) {
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

	public static List<Artifact> valores(){
		return Arrays.asList(values());
	}

}
