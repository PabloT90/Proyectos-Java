/*
 * Entrada: 
 * 	- apellidosNombre String.
 * 	- edad int.
 * 	- genero char.
 * 	- deporte EnumDeporte.
 * 	- cuota double.
 *  - cantSocio int.
 *  - opcionMenu int.
 *  - ejecutarMenu char.
 * Salida: mensajes de comunicacion con el usuario.
 * 	- numero de socios que hacen un deporte particular.
 * 	- porcentaje de socios en dicho deporte sobre el total.
 * Restricciones:
 * 	- La cuota debe ser superior a o igual a 0.
 * 	- El genero debe ser 'M' O 'F'.
 *  - la edad debe ser mayor o igual a 18
 *  - cantSocio debe ser positivo.
 *  - opcionMenu debe estar entre 1 y 2.
 *  - ejecutarMenu debe ser 'S' o 'N'
 * 
 
PG
INICIO
	LeerValidarEjecutar*
	MostrarMensajeInformacion
	mientras quiera ejecutar
		LeerValidarCantSocio*
		para(int contador = 0; contador < cantSocio; contador++)
			ObtenerFichaSocio*
			ObtenerNumeroDeportes
		fin_para
		LeerValidarEjecutarMenu*
		mientras quiera ejecutar el menu
			LeerValidarOpcionMenu*
			segun(opcionMenu)
				opcionMenu 1:
					leerValidarDeporte*
					SociosXDeporte*
				opcionMenu 2:
					leerValidarDeporte*
					PorcentajeXDeporte*
			fin_segun
		fin_mientras
		LeerValidarEjecutar*
	fin_mientras 
FIN
*/
import java.util.Scanner;
public class mainClub{
	public static void main(String[]args){
		Scanner teclado = new Scanner(System.in);
		EnumDeporte deporte = EnumDeporte.DEFAULT;
		char ejecutar, ejecutarMenu;
		int cantSocio; //Cantidad total de socios que queremos meter.
		int opcionMenu; //Opcion del menu que se prensenta
		int contFutbol=0, contTenis=0, contNatacion=0, contPolo=0; //Contadores para los diferentes deportes. Asi se cuantos socios practica cada deporte.
		Socio socio;
		
		//LeerValidarEjecutar
		ejecutar = utilidades.LeerValidarEjecutar();
		
		//MostrarMensajeInformacion
		System.out.println("Introducir los datos tal y como viene en la orden. Si pone Futbol por ej, la primera letra debe ser mayuscula.");
		
		while(ejecutar == 'S'){//mientras quiera ejecutar
			//LeerValidarCantSocio
			cantSocio = utilidades.LeerValidarCantSocio();
			
			for(int contador =0; contador < cantSocio; contador++){//para(int contador = 0; contador < cantSocio; contador++)
				//ObtenerFichaSocio*
				socio = utilidades.obtenerSocio();
				
				//ObtenerNumeroDeportes //Esto es para saber el numero de socios en cada deporte.
				if(socio.getDeporte() == deporte.FUTBOL){
					contFutbol++;
				}else if(socio.getDeporte() == deporte.POLO){
					contPolo++;
				}else if(socio.getDeporte() == deporte.NATACION){
					contNatacion++;
				}else if(socio.getDeporte() == deporte.TENIS){
					contTenis++;
				}
				
				System.out.println("-----------");
			}//fin_para
			
			//LeerValidarEjecutarMenu
			ejecutarMenu = utilidades.LeerValidarEjecutarMenu();
			
			while(ejecutarMenu == 'S'){//mientras quiera ejecutar el menu
				//Mostrar, LeerValidarOpcionMenu
				opcionMenu = utilidades.MostrarLeerValidarOpcionMenu();
				
				switch(opcionMenu){//segun(opcionMenu)
					case 1://opcionMenu 1:
						//LeerValidarDeporte
						deporte = utilidades.LeerValidarDeporte();
						//SociosXDeporte*
						utilidades.MostrarSociosXDeporte(contFutbol, contNatacion, contPolo, contTenis, deporte);
					break;
					
					case 2: //opcionMenu 2:
						//LeerValidarDeporte
						deporte = utilidades.LeerValidarDeporte();
						//PorcentajeXDeporte*
						utilidades.PorcentajeXDeporte(contFutbol, contNatacion, contPolo, contTenis, deporte);
					break;
				}//fin_segun
			}//fin_mientras
			
			//LeerValidarEjecutar
			ejecutar = utilidades.LeerValidarEjecutar();
		}//fin_mientras 
	}
}
