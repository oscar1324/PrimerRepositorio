package com.java.funcionalidad;

import com.java.excepciones.LibreriaException;

public class Libro {

	private String idea;

	private int id;
	private String titulo;
	private int numEjemplares;
	
	public Libro(int id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.numEjemplares = 1;
	}
	
	public void incrementarNumEjemplares() {
		numEjemplares++;
	}

	public void decrementarNumEjemplares() throws LibreriaException {
		if(numEjemplares > 0) {
			numEjemplares--;
		}else {
			throw new LibreriaException("No hay ejemplares disponibles del libro " + titulo);
		}
	}
	
	public String recuperarCantidadEjemplares() {
		if (numEjemplares > 0) {
			return "Hay "+numEjemplares+" ejemplares del libro "+ titulo;
		} else {
			return "No hay ejemplares disponibles del libro "+ titulo;
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getNumEjemplares() {
		return numEjemplares;
	}
	public void setNumEjemplares(int numEjemplares) {
		this.numEjemplares = numEjemplares;
	}
}
