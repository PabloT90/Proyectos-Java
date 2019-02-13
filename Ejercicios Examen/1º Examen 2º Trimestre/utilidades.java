import java.util.Scanner;
public class utilidades{
	/* Comentario: solo leer y valida si quiere ejecutar el programa.
	 * Entrada: -
	 * Precondiciones:-
	 * Salida: char ejecutar.
	 * PostCondiciones: asociado al nombre devuelve el valor de ejecutar ('s' o 'n')
	 * cabecera:  static char LeerValidarEjecutar()
	 * */
	public static char LeerValidarEjecutar(){
		Scanner teclado = new Scanner(System.in);
		char ejecutar = ' ';
		do{
			System.out.println("Quieres ejecutar?  S/N");
			ejecutar = Character.toUpperCase(teclado.next().charAt(0));
		}while(ejecutar != 'S' && ejecutar != 'N');
		return ejecutar;
	}
	/* Comentario: solo leer y valida la cantidad de socios que quiere meter.
	 * Entrada: -
	 * Precondiciones:-
	 * Salida: char cantSocio.
	 * PostCondiciones: asociado al nombre devuelve el numero de socios que desea introducir
	 * cabecera:  static int LeerValidarCantSocio()
	 * */
	 public static int LeerValidarCantSocio(){
		Scanner teclado = new Scanner(System.in);
		int cantSocio = 0;
		do{
			System.out.println("Cuantos socios quieres meter?");
			cantSocio = teclado.nextInt();
		}while(cantSocio <= 0);
		return cantSocio;
	}
	 
	 /* Comentario: solo leer y valida si quiere ejecutar un menu que tendra diferentes opciones.
	 * Entrada: -
	 * Precondiciones:-
	 * Salida: char ejecutar.
	 * PostCondiciones: asociado al nombre devuelve el valor de ejecutar ('s' o 'n')
	 * cabecera:  static char LeerValidarEjecutarMenu()
	 * */
	public static char LeerValidarEjecutarMenu(){
		Scanner teclado = new Scanner(System.in);
		char ejecutar = ' ';
		do{
			System.out.println("Quieres ejecutar el menu?  S/N");
			ejecutar = Character.toUpperCase(teclado.next().charAt(0));
		}while(ejecutar != 'S' && ejecutar != 'N');
		return ejecutar;
	}
	 
	 /* Comentario: solo leer y valida si quiere ejecutar el programa.
	 * Entrada:
	 * Precondiciones:
	 * Salida:
	 * PostCondiciones:
	 * cabecera:
	 * */
	 public static Socio obtenerSocio(){
		 Socio socio;
		 String apellidosNombre;
		 double cuota;
		 int edad;
		 char genero;
		 EnumDeporte deporte;
		 //LeerApellidosNombre
		 apellidosNombre = LeerApellidosNombre();
		 //LeerValidarCuota
		 cuota = LeerValidarCuota();
		 //LeerValidarEdad
		 edad = LeerValidarEdad();
		 //LeerValidarGenero
		 genero = LeerValidarGenero();
		 //LeerValidarDeporte
		 deporte = LeerValidarDeporte();
		 
		 //Construir socio
		 socio = new Socio(apellidosNombre, cuota, edad, genero, deporte);
		 return socio;
	 }
	 
	  /* Comentario: solo leer el nombre del socio.
	 * Entrada: -
	 * Precondiciones: - 
	 * Salida: String nombre
	 * PostCondiciones: asociado al nombre se manda el nombre.
	 * cabecera: static String LeerApellidosNombre()
	 * */
	 public static String LeerApellidosNombre(){
		 String nombre;
		 Scanner teclado = new Scanner(System.in);
		 System.out.println("Dime el nombre:");
		 nombre = teclado.nextLine();
		 return nombre;
	 }
	 
	 /* Comentario: solo leer y validar el nombre del socio.
	 * Entrada: -
	 * Precondiciones: - 
	 * Salida: cuota double
	 * PostCondiciones: asociado al nombre se manda la cuota.
	 * cabecera: static double LeerValidarCuota()
	 * */
	 public static double LeerValidarCuota(){
		 double cuota;
		 Scanner teclado = new Scanner(System.in);
		 do{
			System.out.println("Dime la cuota:");
			cuota = teclado.nextDouble();
		}while(cuota < 0);
		 return cuota;
	 }
	 
	  /* Comentario: solo leer y validar la edad del socio.
	 * Entrada: -
	 * Precondiciones: - 
	 * Salida: edad int
	 * PostCondiciones: asociado al nombre se manda la edad.
	 * cabecera: static int LeerValidarEdad()
	 * */
	 public static int LeerValidarEdad(){
		 int edad;
		 Scanner teclado = new Scanner(System.in);
		 do{
			System.out.println("Dime la edad:");
			edad = teclado.nextInt();
		}while(edad < 18);
		 return edad;
	 }
	 
	  /* Comentario: solo leer y validar el genero del socio.
	 * Entrada: -
	 * Precondiciones: - 
	 * Salida: genero char
	 * PostCondiciones: asociado al nombre se manda el genero. ('M' o 'F')
	 * cabecera: static char LeerValidaGenero()
	 * */
	 public static char LeerValidarGenero(){
		 char genero;
		 Scanner teclado = new Scanner(System.in);
		 do{
			System.out.println("Dime el genero: M o F");
			genero = Character.toUpperCase(teclado.next().charAt(0));
		}while(genero != 'F' && genero != 'M');
		 return genero;
	 }
	 
	 /* Comentario: lee y valida el deporte del socio.
	 * Entrada: -
	 * Precondiciones: - 
	 * Salida: deporte EnumDeporte
	 * PostCondiciones: asociado al nombre se manda el deporte.
	 * cabecera: static EnumDeporte LeerValidarDeporte()
	 * */
	 public static EnumDeporte LeerValidarDeporte(){
		 EnumDeporte deportes;
		 String deporte;
		 Scanner teclado = new Scanner(System.in);
		 do{
			System.out.println("Dime el deporte: Futbol, Tenis, Natacion, Polo");
			deporte = teclado.nextLine();
		}while((!deporte.equals("Futbol")) && (!deporte.equals("Tenis")) &&
		(!deporte.equals("Natacion")) && (!deporte.equals("Polo")));
		
		switch(deporte){
			case "Futbol":
				deportes = EnumDeporte.FUTBOL;
			break;
			
			case "Tenis":
				deportes = EnumDeporte.TENIS;
			break;
			
			case "Natacion":
				deportes = EnumDeporte.NATACION;
			break;
			
			case "Polo":
				deportes = EnumDeporte.POLO;
			break;
			
			default:
				deportes = EnumDeporte.DEFAULT;
			break;
		}
		 return deportes;
	 }
	 
	 /* Comentario: muestra, lee y valida la opcion del menu
	 * Entrada: -
	 * Precondiciones: - 
	 * Salida: int opcion
	 * PostCondiciones: asociado al nombre se manda la opcion y se pinta un menu.
	 * cabecera: static int MostrarLeerValidarOpcionMenu()
	 * */
	public static int MostrarLeerValidarOpcionMenu(){
		Scanner teclado = new Scanner(System.in);
		int opcion;
		
		do{
			System.out.println("1- Numero de socios segun el deporte.");
			System.out.println("2- Porcentaje de socios segun el deporte.");
			opcion = teclado.nextInt();
		}while(opcion != 1 && opcion != 2);
		return opcion;
	}
	
	/* Comentario: muestra el numero de socios por deporte
	 * Entrada: int fut, int nat, in pol, int ten, EnumDeporte deporte
	 * Precondiciones: no hay.
	 * Salida: no hay
	 * PostCondiciones: no hay, solo pinta en pantalla.
	 * cabecera: static void MostrarSociosXDeporte(int fut, int nat, int pol, int ten, EnumDeporte deporte)
	 * */
	public static void MostrarSociosXDeporte(int fut, int nat, int pol, int ten, EnumDeporte deporte){
			if(deporte == EnumDeporte.FUTBOL)
				System.out.println("De: "+deporte.name()+" hay: "+fut);
			else if(deporte == EnumDeporte.NATACION)
				System.out.println("De: "+deporte.name()+" hay: "+nat);
			else if(deporte == EnumDeporte.TENIS)
				System.out.println("De: "+deporte.name()+" hay: "+ten);
			else if(deporte == EnumDeporte.POLO)
				System.out.println("De: "+deporte.name()+" hay: "+pol);
	}
	
	/* Comentario: muestra el porcentaje de socios por deporte
	 * Entrada: int fut, int nat, in pol, int ten, EnumDeporte deporte
	 * Precondiciones: no hay.
	 * Salida: no hay
	 * PostCondiciones: no hay, solo pinta en pantalla.
	 * cabecera: static void PorcentajeXDeporte(int fut, int nat, int pol, int ten, EnumDeporte deporte)
	 * */
	public static void PorcentajeXDeporte(int fut, int nat, int pol, int ten, EnumDeporte deporte){
		int porcentaje=0;
		int total = fut+nat+pol+ten;
			if(deporte == EnumDeporte.FUTBOL){
				porcentaje = (fut*100)/total;
				System.out.println("Porcentaje de socios en futbol: "+ porcentaje+"%");
			}else if(deporte == EnumDeporte.NATACION){
				porcentaje = (nat*100)/total;
				System.out.println("Porcentaje de socios en natacion: "+ porcentaje+"%");
			}else if(deporte == EnumDeporte.TENIS){
				porcentaje = (ten*100)/total;
				System.out.println("Porcentaje de socios en tenis: "+ porcentaje+"%");
			}else if(deporte == EnumDeporte.POLO){
				porcentaje = (pol*100)/total;
				System.out.println("Porcentaje de socios en polo: "+ porcentaje+"%");
			}
	}
	
}
