package main.java.util;

public class Articulo {
	
	private Articulo previous;
	private Articulo next;
	private int id;

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
