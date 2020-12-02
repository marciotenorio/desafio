package br.com.marcio.model;

import java.io.Serializable;

public class Evento implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nome;
	
	
	public Evento() {}
	
	public Evento(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
