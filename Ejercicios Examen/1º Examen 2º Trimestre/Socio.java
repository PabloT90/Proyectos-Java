/*
 * Propiedades basicas:
 * 	- numSocio: int consultable.
 * 	- apellidosNombre: String consultable.
 * 	- cuota: double consultable y modificable.
 * 	- edad: int consultable y modificable.
 * 	- genero: char consutable y modificable.
 * 	- deporte: EnumDeporte consultable y modificable.
 * Propiedades derivadas:
 * 	- relevancia: double consultable.
 * Propiedades compartidas:
 * 	- factorRelevancia double.
 * 	- contadorSocio int.
 * 
 * Metodos añadidos:
 * - Los de la clase Object.
 * Restricciones:
 * 	- genero debe ser 'M' o 'F'
 * 	- edad tiene que ser mayor de 18.
 *  - la cuota debe ser mayor que 0.
 * 
 * getter y setter
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
public class Socio implements IntSocio, Comparable<Socio>, Cloneable{
	private int numSocio;
	private String apellidosNombre;
	private double cuota;
	private int edad;
	private char genero;
	private EnumDeporte deporte;
	
	//Compartidas:
	private static final double factorRelevancia = 0.15;
	private static int contadorSocio=0;
	
	//constructor por defecto
	public Socio(){
		numSocio = contadorSocio++;
		apellidosNombre = new String();
		cuota = 0.0;
		edad = 0;
		genero = 'F';
		deporte = EnumDeporte.DEFAULT;
	}
	
	//Constructor con parametros
	public Socio(String apellidosNombre, double cuota, int edad, char genero, EnumDeporte deporte){
		this.numSocio = contadorSocio++;
		this.apellidosNombre = apellidosNombre;
		this.cuota = cuota;
		this.edad = edad;
		this.genero = genero;
		this.deporte = deporte;
	}
	
	//Constructor de copia
	public Socio(Socio copia){
		this.numSocio = copia.getNumSocio();
		this.apellidosNombre = copia.getApellidosNombre();
		this.cuota = copia.getCuota();
		this.edad = copia.getEdad();
		this.genero = copia.getGenero();
		this.deporte = copia.getDeporte();
	}
	
	public int getNumSocio(){
		return numSocio;
	}
  
	public String getApellidosNombre(){
		return apellidosNombre;
	}
  
	public double getCuota(){
	  return cuota;
	}
	public void setCuota(double cuota)throws Excepciones{
		if(cuota >= 0)
			this.cuota = cuota;
		else throw new Excepciones("Cuota incorrecta");
	}
  
	public int getEdad(){
		return edad;
	}
	public void setEdad(int edad)throws Excepciones{
		if(edad >= 18)
			this.edad = edad;
		else throw new Excepciones("Edad incorrecta");
	}
  
	public char getGenero(){
		return genero;
	}
	public void setGenero(char genero)throws Excepciones{
		if(genero == 'F' || genero == 'M')
			this.genero = genero;
		else throw new Excepciones("Genero incorrecto");
	}
  
	public EnumDeporte getDeporte(){
		return deporte;
	}
	public void setDeporte(EnumDeporte deporte){
		this.deporte = deporte;
	}
  
	public double getRelevancia(){
		return cuota*factorRelevancia;
	}
	
	//Metodos de la clase Object
	
	@Override
	public String toString(){
		return "NumSocio: "+getNumSocio()+","+" Apellidos Nombre: : "+getApellidosNombre()+","+" cuota: "+getCuota()+","+"edad: "+getEdad()+","+"genero: "+getGenero()+","+"deporte: "+getDeporte()+","+"relevancia: "+getRelevancia();
	}
	
	//Criterio de igualdad: dos socios son iguales si tienen el mismo numero de socio.
	@Override
	public boolean equals(Object obj){
		boolean ret = false;
		
		if(this == obj)
			ret = true;
		else{
			if(obj != null && obj instanceof Socio){
				Socio otro = (Socio)obj;
				if(this.getNumSocio() == otro.getNumSocio()){
					ret = true;
				}
			}	
		}
		return ret;
	}
	
	@Override
	public Socio clone(){
		Socio copia = null;
		
		try{
			copia = (Socio)super.clone();
		}catch(CloneNotSupportedException error){
			System.out.println("Error en la copia");
		}
		return copia;
	}
	
	@Override
	public int hashCode(){
		return numSocio; //Mirar este hashCode.
	}
	
	/*
	 * Criterio de comparacion segun el numero de socio.
	 * Devuelve 1 si el socio recibido por parametro es menor.
	 * Devuelve 0 en caso que ambos tengan el mismo numero de socio.
	 * Devuelve -1 en caso que el socio recibido por parametro tenga un mayor numero de socio
	 * */
	public int compareTo(Socio otro){
		int ret = 0;
		
		if(this.numSocio < otro.numSocio)
			ret = -1;
		else if(this.numSocio > otro.numSocio)
			ret = 1;
			
		return ret;
	}
	
}
