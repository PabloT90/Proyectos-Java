/*
 * Entrada: 
 * 	- Ficha ficha (los datos necesarios para construir un tipo Ficha)
 * 	- char anadirFicha
 * 	- int opcionMenu
 * 	- String actividad
 * Salida:
 * 	- mensajes de comunicacion con el usuario
 *  - listado de las fichas con el mismo nivel de actividad.
 *  - cantidad de socios que han realizado una actividad en particular.
 *  
 *  Restricciones:
 *  	- opcionMenu debe estar entre 1 y 2.
 *  	- anadirFicha debe ser 's' o 'n'.
 * 		- actividad debe ser alto, medio o bajo.
 * 
 * PG
 * INICIO
 * 	mientras quiera añadir Fichas y quede hueco
 * 		CrearFicha*
 * 		LeerValidarDuracion*
 * 		MostrarGastoCalorias
 * 		GuardarFicha
 *  fin_mientras
 *  LeerValidarOpcionMenu
 *  mientras opcionMenu != 0
 *  	segun(opcionMenu)
 *  		opcion 1: ListadoNivelActividad*
 *  		opcion 2: ListadoActividadParticular*
 *  	fin_segun
 *  fin_mientras
 * FIN
 * 
 * PG N1 ListadoNivelActividad*
 * INICIO
 * 		LeerValidarActividad
 * 		MismoNivelActividad
 * FIN
 * 
 *  * PG N1 ListadoActividadParticular*
 * INICIO
 * 		LeerValidarActividad
 * 		MostrarActividadParticular
 * FIN
 * */
import java.util.Scanner;
import Gestora.GestionSenderismo;
import Resguardos.Resguardo;
import Clases.*;
import Excepciones.excepciones;
public class ClubSenderismo {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		GestionSenderismo util = new GestionSenderismo();
		Resguardo res = new Resguardo();
		ImplFicha[] lista = new ImplFicha[10];  //Aqui guardo las fichas que se van creando.
		ImplFicha ficha = new ImplFicha();
		int duracion =0;
		int aux = 0;
		int opcionMenu;
		String actividad;
		
		System.out.println("Aviso: No me ha dado tiempo a hacer que sea automatico, tendra que ser todo a mano");
		
		//mientras quiera añadir Fichas y quede hueco
		while(util.LeerValidarAnadirFicha() == 's' && aux <= 10) { //res.LeerValidarAnadirFicha()
			
		  	//CrearFicha
			//ficha = res.CrearFicha();
			try {
				ficha = util.CrearFicha();
			} catch (excepciones e) {
				System.out.println("Error en la creacion");
			}
			
		  	//LeerValidarDuracion
			//duracion = res.LeerValidarDuracion();
			duracion = util.LeerValidarDuracion();
			
		  	//MostrarGastoCalorias
			System.out.println("Ha quemado: "+ficha.CaloriasQuemadas(duracion)+ " Calorias");
			
			//GuardarFicha   
			//Esto no deberia hacerlo asi pero es la manera mas sencilla y rapida que se me ha ocurrido.
			//El metodo que deberia seguir es: crear una funcion que rellene el array en la primera posicion libre que haya mientras queden huecos libres.
			lista[aux] = ficha;
			aux++;
			System.out.println("Ficha guardada con exito.");
		}//fin_mientras
		
		//LeerValidarOpcionMenu
		//opcionMenu = res.MostrarLeerValidarMenu();
		opcionMenu = util.MostrarLeerValidarMenu();
		
		while(opcionMenu != 0) {//mientras opcionMenu != 0
			
		   switch(opcionMenu) {//segun(opcionMenu)
		   		case 1://opcion 1: ListadoNivelActividad
				   //LeerValidarActividad 
				   //actividad = res.LeerValidarActividad();
				   actividad = util.LeerValidarActividad();
				   
				   //MismoNivelActividad
			   		res.MismoNivelActividad(actividad,lista);
		   		
			   	break;
		   case 2: //opcion 2: ListadoActividadParticular
			   //LeerValidarActividad 
			   //actividad = res.LeerValidarActividad();
			   actividad = util.LeerValidarActividad();
			   
			   //MostrarActividadParticular
			   //res.MostrarActividadParticular(actividad, lista);
			   util.MostrarActividadParticular(actividad, lista);
		   	break;
		   	}//fin_segun
		 }//fin_mientras
	}
}