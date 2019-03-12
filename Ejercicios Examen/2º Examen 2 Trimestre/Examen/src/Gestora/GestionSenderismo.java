package Gestora;

import java.util.Scanner;
import Clases.*;
import Enums.EnumActividad;
import Excepciones.excepciones;
public class GestionSenderismo {
	 /* Esta funcion muestra si quiere añadir, lee y valida si quiere.
     * Entrada: ---
     * Precondiciones: ---
     * Salida: char anadir
     * Postcondiciones: asociado al nombre se envia el caracter elegido valido.
     * Cabecera:  public char LeerValidarAnadirFicha()()
     * */
    public char LeerValidarAnadirFicha(){
        Scanner teclado = new Scanner(System.in);
        char anadir;

        do{
            System.out.println("Quieres anadir mas fichas? s/n");
            anadir = Character.toLowerCase(teclado.next().charAt(0));
        }while(anadir != 's' && anadir != 'n');

        return anadir;
    }
    
    /* Esta funcion crea el perfil de la ficha
     * Entrada: ---
     * Precondiciones: ---
     * Salida: ImplFicha ficha
     * Postcondiciones: asociado al nombre se manda la ficha
     * Cabecera: public ImplFicha CrearFicha()
     * */
    public ImplFicha CrearFicha() throws excepciones{
        Scanner teclado = new Scanner(System.in);
        EnumActividad actividad; int opcionActividad;
        Fecha fecha; int dia, mes, anio;
        double peso;
        int categoria;
        ImplFicha ficha;
        String ApellidosNombre;
        
        //LeerNombre
        System.out.println("Cual es tu nombre?");
        ApellidosNombre = teclado.nextLine();
        
        //Se que estos son modulos y por tanto deberia hacerlos aparte y llamarlos desde este metodo, pero por falta de tiempo lo hare del tiron.
        
        //LeerValidarActividad
        do {
        	System.out.println("Dime el nivel de actividad");
        	System.out.println("1- Alta");
        	System.out.println("2- Media");
        	System.out.println("3- Baja");
        	opcionActividad = teclado.nextInt();
        }while(opcionActividad < 1 && opcionActividad > 3);
        
        switch(opcionActividad) {
        	case 1: actividad = EnumActividad.ALTO; break;
        	case 2: actividad = EnumActividad.MEDIO; break;
        	case 3: actividad = EnumActividad.BAJO; break;
        	default: actividad = EnumActividad.BAJO; break;
        }
        
        //LeerValidarPeso
        do {
        	System.out.println("Dime tu peso, mayor que 0");
        	peso = teclado.nextInt();
        }while(peso <= 0);
   
        //LeerFecha
        	System.out.println("Fecha de alta");
        	System.out.println("Anio");
        	anio = teclado.nextInt();
        	System.out.println("mes");
        	mes = teclado.nextInt();
        	System.out.println("dia");
        	dia = teclado.nextInt();
        	fecha = new Fecha(anio, mes, dia);
        	
        //CalcularCategoria
       //Se que no se hace asi pero creo que es bastante lio validar la fecha y calcular los años de diferencia...
        if(2019- anio > 5)
        	categoria = 5;
        else if(2019 - anio <= 0)
        	categoria = 1;
        else categoria = 2019 - anio;
        
        //Creamos la ficha con el constrcutor con parametros de la clase ImplFicha
        ficha = new ImplFicha(ApellidosNombre, actividad, peso, categoria, fecha);
        
        return ficha;
    }
    
    /* Esta funcion lee y valida la duracion.
     * Entrada: ---
     * Precondiciones: ---
     * Salida: int duracion
     * Postcondiciones: asociado al nombre se envia la duracion.
     * Cabecera:  public int LeerValidarDuracion()
     * */
    public int LeerValidarDuracion(){
        Scanner teclado = new Scanner(System.in);
        int duracion;

        do{
            System.out.println("Dime la duracion en minutos");
            duracion =  teclado.nextInt();
        }while(duracion <= 0);

        return duracion;
    }
    
    /* Esta funcion muestra un menu, lee y valida la opcion elegida.
     * Entrada: ---
     * Precondiciones: ---
     * Salida: int opMenu
     * Postcondiciones: asociado al nombre se envia la opcion elegida
     * Cabecera: public int MostrarLeerValidarMenu()
     * */
    public int MostrarLeerValidarMenu(){
        Scanner teclado = new Scanner(System.in);
        int opMenu;

        do{
            System.out.println("1- Listado de fichas con el mismo nivel de actividad");
            System.out.println("2- Listado de los que han realizado una actividad en particular");
            System.out.println("0- Salir");
            opMenu = teclado.nextInt();
        }while(opMenu < 0 || opMenu > 2);

        return opMenu;
    }
    
    /* Esta funcion muestra las fichas que tienen el mismo nivel de actividad.
     * Entrada: ImplFicha[] lista, String actividad.
     * Precondiciones: el array no puede estar vacio, actividad debe ser alto, medio, bajo.
     * Salida: nada.
     * Postcondiciones: nada, solo muestra en pantalla.
     * Cabecera: public void MostrarMismoNivelActividad(ImplFicha[] lista)
     * */
    	public void MismoNivelActividad(String actividad, ImplFicha[] lista){
        	EnumActividad act;
        	
        	if(actividad.equals("alto"))
    			act = EnumActividad.ALTO;
    		else if(actividad.equals("medio"))
    			act = EnumActividad.MEDIO;
    		else
    			act = EnumActividad.BAJO;
        	
          for(int i=0; i < lista.length; i++) {
        	  if(lista[i].getNivelActividad() == act) {
        		  System.out.println(lista[i].toString());
        	  }
          }
        }
    
    /* Esta funcion calcula los socios que han realizado una actividad en particular.
     * Entrada: String actividad, ImplFicha lista
     * Precondiciones: actividad solo puede ser Alto, Medio, Bajo. La lista no puede estar vacia.
     * Salida: nada.
     * Postcondiciones: nada, solo muestra en pantalla.
     * Cabecera: public void MostrarActividadParticular(String actividad, ImplFicha[] lista)
     * */
    public void MostrarActividadParticular(String actividad, ImplFicha[] lista){
    	EnumActividad act;
    	int cont=0;
    	
    	if(actividad.equals("alto"))
			act = EnumActividad.ALTO;
		else if(actividad.equals("medio"))
			act = EnumActividad.MEDIO;
		else
			act = EnumActividad.BAJO;
    	
      for(int i=0; i < lista.length; i++) {
    	  if(lista[i].getNivelActividad() == act) {
    		  cont++;
    	  }
      }
      System.out.println("Numero de gente que practica una actividad: "+ " activdad "+ " es: "+ cont);
    }
    
    
    /* Esta funcion lee y valida la actividad.
     * Entrada: ---
     * Precondiciones: ---
     * Salida: String actividad
     * Postcondiciones: asociado al nombre se envia la actividad elegida
     * Cabecera: public String LeerValidarActividad()
     * */
    public String LeerValidarActividad(){
        Scanner teclado = new Scanner(System.in);
        String actividad;

        do {
			   System.out.println("Nivel de actividad? alto, medio o bajo?");
			   actividad = teclado.nextLine();
		   }while(!actividad.equals("alto") && !actividad.equals("medio") && !actividad.equals("bajo"));

        return actividad;
    }
    
}
