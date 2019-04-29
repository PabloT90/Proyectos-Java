package main.java.util;

public class Articulo {
	
	private Articulo previous;
	private Articulo next;
	private int id;

	//Constructor por defecto
	public Articulo(){
		previous = null;
		next = null;
		id = 0;
	}

	//Constructor con parámetros
	public Articulo(Articulo previous, Articulo next, int id){
		this.previous = previous;
		this.next = next;
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public Articulo getPrevious() {
		return previous;
	}
	public void setPrevious(Articulo previous) {
		this.previous = previous;
	}
	public Articulo getNext() {
		return next;
	}
	public void setNext(Articulo next) {
		this.next = next;
	}
	
}
