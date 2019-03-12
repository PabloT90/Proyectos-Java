package Clases;

import Enums.EnumActividad;
import Clases.Fecha;
import Interface.Ficha;
import Excepciones.*;
/*
 * Propiedades basicas: 
 * 	- ID int, consultable.
 * 	- ApellidosNombre String, consultable.
 *  - Fecha Calendar, consultable.
 *  - NivelActividad ENUM, consultable y modificable.
 *  - Peso double, consultable y modificable.
 * Propiedades derivadas: - Categoria int, consultable.
 * 
 * Propiedades compartidas: contID int.
 * 
 * Restricciones:
 * 	- el peso debe ser mayor a 0.
 *  - categoria debe estar entre 0 y 5.
 * 
 * Metodos Añadidos:
 * 	- CalcularCalorias
 * 	- toString
 *  - compareTo
 *  - equals
 *  - hashCode
 *  - clone
 * 
 * get/set
 * 
 * public int getID();
	
	public String getApellidosNombre();
	
	public EnumActividad getNivelActividad();
	public EnumActividad setNivelActividad(EnumActividad actividad);
	
	public double getPeso();
	public void setPeso(double peso);
	
	public int getCategoria();
 * */
public class ImplFicha implements Ficha, Comparable<ImplFicha>, Cloneable{
	private int ID;
	private String apellidosNombre;
	private EnumActividad nivelActividad;
	private double peso;
	private int categoria;
	private Fecha fecha;
	
	private static int contID = 0;
	
	//Constructor por defecto
	public ImplFicha() {
		ID = contID++;
		apellidosNombre = new String();
		nivelActividad = EnumActividad.BAJO;
		peso = 1;
		categoria = 1;
		fecha = new Fecha();
	}
	
	//Constructor con parametros
	public ImplFicha(String apellidosNombre, EnumActividad nivelActividad, double peso, int categoria, Fecha fecha) throws excepciones { //Se que asi no se debe construir pero no se el tiempo que voy a tardar.
		ID = contID++;
		this.apellidosNombre = apellidosNombre;
		this.nivelActividad = nivelActividad;
		this.peso = peso;
		if(categoria >= 1 && categoria <= 5)
			this.categoria = categoria;
		else
			throw new excepciones  ("Error en la categoria");
		this.fecha = fecha;
	}
	
	//Constructor de copia
	public ImplFicha(ImplFicha ficha) {
		ID = contID++;
		this.apellidosNombre = ficha.getApellidosNombre();
		this.nivelActividad = ficha.getNivelActividad();
		this.peso = ficha.getPeso();
		this.categoria = ficha.getCategoria();
		this.fecha = ficha.getFecha();
	}
	
	//GETS / SETS
	public int getID() {
		return ID;
	}
	
	public String getApellidosNombre() {
		return apellidosNombre;
	}
	
	public Fecha getFecha() {
		return  fecha;
	}
	
	public EnumActividad getNivelActividad() {
		return nivelActividad;
	}
	public void setNivelActividad(EnumActividad actividad) {
		this.nivelActividad = actividad;
	}
	
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) throws excepciones {
		if (peso > 0.0)
			this.peso = peso;
		else
			throw new excepciones("Error");
	}
	
	public int getCategoria() {
		return categoria;
	}
	
	//Metodos Añadidos
	@Override
	public String toString() 
	{
		return "ID: " + getID()+ "  , Actividad: "+getNivelActividad();
	}
	
	@Override
	public int hashCode() {
		return getID()+ apellidosNombre.hashCode();
	}
	
	@Override
	public ImplFicha clone() {
		ImplFicha clon=null;
		
		try {
			clon=(ImplFicha)super.clone();
		}catch(CloneNotSupportedException err) 
		{
			System.out.println("No se ha clonado");
		}
		return clon;
	}
	
	
	//criterio de igualdad: segun el ID
	@Override
	public boolean equals(Object o) 
	{
		boolean res=false;
		
		if(this==o) {
			res=true;
		}else {
			if(o!=null && o instanceof ImplFicha) 
			{
				ImplFicha copia=(ImplFicha) o;
				
				if(this.getID() == copia.getID()) {
					res=true;
				}
			}
		}
		return res;
	}
	
	
	//criterio de igualdad: 
				//devuelve 1 si el ID es mayor que el que entra como parametro.
				//devuelve -1 si el ID es menor que el que entra como parametro.
				//devuelve 0 si son iguales los ID.
	public int compareTo(ImplFicha f){
		int res=0;
		
		if(this.getID() > f.getID()) {
			res=1;
		}else{
			if(this.getID() < f.getID()) {
				res=-1;
			}
		}
		
		return res;
	}

	
	/* Descripcion: calcula las calorias que ha quemado.
	 * Entrada: int duracion
	 * Precondiciones: la duracion debe ser mayor a 0.
	 * Salida: double calorias.
	 * Postcondiciones: asociado al nombre se mandan las calorias que ha quemado.
	 * Cabecera: public double CaloriasQuemadas()
	 * */
	public double CaloriasQuemadas(int duracion) {
		double calorias = 0;
		double CTE;
		
		if(this.getNivelActividad() == EnumActividad.ALTO)
			CTE = 0.35;
		else if(this.getNivelActividad() == EnumActividad.MEDIO)
			CTE = 0.25;
		else
			CTE = 0.15;
		
		calorias = CTE * duracion * this.getPeso();
		
		return calorias;
	}
}
