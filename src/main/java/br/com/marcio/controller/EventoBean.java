package br.com.marcio.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.marcio.jdbc.EventoJDBC;
import br.com.marcio.model.Evento;

@Named
@SessionScoped
public class EventoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Evento evento = new Evento();
	private List<Evento> eventos = new ArrayList<Evento>();
	
	public String mostrarEventos() {
		EventoJDBC ev = new EventoJDBC();
		eventos.clear();
		eventos = ev.listEventos();
		clean();
		return "";
	}
	
	public void adicionarEvento() {
		EventoJDBC ev = new EventoJDBC();
		ev.adicionarEvento(evento);
		mostrarEventos();
	}
	
	//Não consegui pegar os valores de cada coluna do datatable para 
	//realizar o delete
	public void deletarEvento() {
		EventoJDBC ev = new EventoJDBC();
		ev.deletarEvento(evento);
		mostrarEventos();
	}
	
	//Não consegui gerar um campo ao clicar no botão atualizar e realizar
	//update na tabela
	public void atualizarEvento() {
		EventoJDBC ev = new EventoJDBC();
		ev.atualizarEvento(evento);
		mostrarEventos();
	}
	
	private void clean() {
		this.evento = new Evento();
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
}
