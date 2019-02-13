//Interface del tipo Socio
 /* getter y setter
 * int getNumSocio()
 * 
 * String getApellidosNombre()
 * 
 * double getCuota()
 * void setCuota(double cuota)
 * 
 * int getEdad()
 * void setEdad(int edad)
 * 
 * char getGenero()
 * void setGenero(char genero)
 * 
 * EnumDeporte getDeporte()
 * void setDeporte(EnumDeporte deporte)
 * 
 * double getRelevancia()
 * */
public interface IntSocio{
	public int getNumSocio();
  
	public String getApellidosNombre();
	
  
	public double getCuota();
	
	public void setCuota(double cuota) throws Excepciones;
	
  
	public int getEdad();
	
	public void setEdad(int edad)throws Excepciones;
  
	public char getGenero();
	
	public void setGenero(char genero)throws Excepciones;
	
  
	public EnumDeporte getDeporte();
	
	public void setDeporte(EnumDeporte deporte);
  
	public double getRelevancia();
}
