package Interface;
import Clases.Fecha;
import Excepciones.*;
/*
 * Propiedades basicas: 
 * 	- ID int, consultable.
 * 	- ApellidosNombre String, consultable.
 *  - Fecha Fecha, consultable.
 *  - NivelActividad ENUM, consultable y modificable.
 *  - Peso double, consultable y modificable.
 *  
 * Propiedades derivadas: 
 *		- Categoria int, consultable.
 * 
 * Propiedades compartidas: contID int.
 * 
 * get/set
 * 
 * public int getID();
	
	public String getApellidosNombre();
	
	public Fecha getFecha();
	
	public EnumActividad getNivelActividad();
	public void setNivelActividad(EnumActividad actividad);
	
	public double getPeso();
	public void setPeso(double peso);
	
	public int getCategoria();
 * 
 * */
import Enums.EnumActividad;;
public interface Ficha {

	public int getID();
	
	public String getApellidosNombre();
	
	public Fecha getFecha();
	
	public EnumActividad getNivelActividad();
	public void setNivelActividad(EnumActividad actividad);
	
	public double getPeso();
	public void setPeso(double peso)throws excepciones;
	
	public int getCategoria();
}