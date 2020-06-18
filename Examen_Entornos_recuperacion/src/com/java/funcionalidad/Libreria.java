package com.java.funcionalidad;

import java.util.ArrayList;

import com.java.excepciones.LibreriaException;

public class Libreria {

	private String nombre;
	private String direccion;
	private ArrayList<Libro> inventario;
	
	
	public Libreria(String nombre, String direccion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.inventario = new ArrayList<Libro>();
	}
	
	/**
	 * Metodo que ncorpora un nuevo libro al inventario
	 * @param libro
	 * @throws LibreriaException
	 */
	public void nuevoLibro(Libro libro) throws LibreriaException {
		if(inventario != null) {
			inventario.add(libro);
		} else {
			throw new LibreriaException("El inventario no está inicializado");
		}
	}
	
	/**
	 * Método que elimina un libro del inventario
	 * @param id
	 * @return
	 */
	public boolean descatalogarLibro(int id) {
		for (Libro libro : inventario) {
			if(libro.getId() == id) {
				inventario.remove(libro);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Método que elimina un ejemplar del libro del inventario
	 * @param id
	 */
	public void eliminarEjemplarLibro (int id) {
		boolean eliminado = false;
		int i = 0;
		while(eliminado == false && i<inventario.size()) {
			if(inventario.get(i).getId()==id) {
				inventario.remove(i);
				eliminado = true;
			}
			i++;
		}
	}
	
	/**
	 * Método que devolverá un 1 si hay ejemplares del libro, un 2 si no hay ninguno disponible
	 * y un 3 si el libro no está en inventario.
	 * @param id
	 * @return
	 */
	public int recuperarInfoLibro(int id) {
		for (Libro libro : inventario) {
			if (libro.getId() == id){
				if (libro.getNumEjemplares() > 0) {
					return 1;
				} else {
					return 2;
				}
			}
		}
		return 3;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public ArrayList<Libro> getInventario() {
		return inventario;
	}
	public void setInventario(ArrayList<Libro> inventario) {
		this.inventario = inventario;
	}
	
}
