/*Autor: Pablo Prats Jimenez
 * PG 0
 * 
 * INICIO
 * PresentarMenu, leeryValidaropcionMenu
 * mientras opcionMenu != 4
 * 	segun(opcionMenu)
 * 		caso 1
 * 			PintarRombo
 * 		fin_caso 1
 * 		caso 2
 * 			NumeroHambriento
 * 		fin_caso 2
 * 		caso 3
 * 			JugarNaipeMagico
 * 		fin_caso 3
 * 	fin_segun
 * 	PresentarMenu, leeryValidaropcionMenu
 * fin_mientras
 * FIN
 * 
 * PG PintarRombo
 * Breve descripcion: dado un numeroRombo (caracteres de la diagonal), y un caracter de relleno pintara un rombo.
 * INICIO
 * 	leeryValidarNumeroRombo
 * 	leeryValidarCaracter
 * 	mostrarRombo (en construccion)
 * FIN
 * 
 * PG NumeroHambriento
 * en construccion hasta saber las especificaciones del ejercicio.
 * 
 * PG JugarNaipeMagico
 * Breve descripcion: juego de cartas francesas generadas al azar.
 * 
 * Victoria:				 - gana si saca cualquier figura y es de corazones.
 * 							 - gana si saca un as de picas.
 * Derrota: 				 - pierde si saca cualquier pica(excepto as de picas).
 * 							 - pierde si saca 2 de treboles.
 * Empate:  				 - empata en cualquier otro caso no mencianado arriba.
 * 
 * INICIO
 * 	leeryValidarNumeroJugadas
 * 	para(entero ronda=0; ronda<numeroJugadas; ronda++)
 * 		MostrarQuienComienza //El jugador inicial sera la Persona.
 * 		GenerarCartayPaloAleatorios
 * 		MostrarCartaGenerada
 * 		CalcularyMostrarGanadorRonda
 * 	fin_para
 * 	MostrarResultadoGeneral
 * 	ActualizarVariables
 * FIN
 * 
 * Para mas documentacion consultar folio adjunto. El estudio de bucles lo realizo en el codigo.
 * */
import java.util.Scanner;
import java.util.Random;
public class miniJuegos{
	public static void main(String[]args){
		int opcionMenu=0, numeroRombo=0,numeroRondas=0, numeroCarta=0,palo=0,ganadorRonda=1;
		int vicPC=0, vicPersona=0, empate=0; //contadores de las victorias
		char relleno = ' ';
		Scanner teclado = new Scanner(System.in);
		Random rdn = new Random();
		
		//PresentarMenu, leeryValidaropcionMenu
		do{
			System.out.println();
			System.out.println("1- Pintar Rombo");
			System.out.println("2- Numero Hambriento");
			System.out.println("3- Jugar Naipe Magico");
			System.out.println("4- Salir");
			System.out.println();
			opcionMenu = teclado.nextInt();
		}while(opcionMenu < 1 || opcionMenu > 4);
		
		while(opcionMenu !=4){//mientras opcionMenu != 4
			switch(opcionMenu){//segun(opcionMenu)
				case 1://caso 1
					//PintarRombo
					
					/* VCB: centinela (cualquier numero menor que 1 y mayor que 4)
					 * Inicializacion:lectura anticipada antes de la primera iteracion.
					 * Actualizacion: lectura final, fisicamente al final.
					 * Condicion entrada: numeroRombo < 1 || numeroRombo > 9 || numeroRombo % 2 == 0
					 * Condicion salida: numeroRombo => 1 && numeroRombo <= 9 && numeroRombo % 2 != 0
					 * */
					//leeryValidarNumeroRombo
					do{
						System.out.println("Cantidad de caracteres de la diagonal del rombo? Entre 1 y 9. Impar");
						numeroRombo = teclado.nextInt();
					}while(numeroRombo < 1 || numeroRombo > 9 || numeroRombo % 2 == 0);
					
					/* VCB: centinela (cualquier caracter distinto de 'x', '+', '*')
					 * Inicializacion: lectura anticipada antes de la primera iteracion.
					 * Actualizacion: lectura final, fisicamente al final.
					 * Condicion entrada: relleno != '*' && relleno != '+' && relleno != 'x'
					 * Condicion salida: relleno == '*' || relleno == '+' || relleno == 'x'
					 * */
					//leeryValidarCaracter
					do{
						System.out.println("Caracter de relleno posible: *, +, x");
						relleno = teclado.next().charAt(0);
					}while(relleno != '*' && relleno != '+' && relleno != 'x');
					
					//mostrarRombo (en construccion)
					System.out.println("El resto se encuentra en construccion");
				break;//fin_caso 1
				
				case 2://caso 2
					//NumeroHambriento
					System.out.println("Este minijuego se encuentra en construccion");
				break; //fin_caso 2
				
				case 3: //caso 3
					//JugarNaipeMagico
					
					/* VCB: centinela (cualquier numero menor que 1).
					 * Inicializacion: lectura anticipada antes de la primera iteracion.
					 * Actualizacion: lectura final, fisicamente al final.
					 * Condicion entrada: numeroRondas < 1
					 * Condicion salida: numeroRondas >= 1
					 * */
					//leeryValidarNumeroRondas
					do{
						System.out.println("Cuantas rondas quieres?"); //Cada partida se compone del numero de rondas que introduzca el usuario.
						numeroRondas = teclado.nextInt();
					}while(numeroRondas < 1);
					
					/* VCB: contador
					 * Inicializacion: al inicio del bucle a 0.
					 * Actualizacion: despues de la iteracion al evaluar la condicion.
					 * Condicion entrada: rondaActual < numeroRondas
					 * Condicion salida: rondaActual >= numeroRondas
					 * */
					for(int rondaActual=0; rondaActual < numeroRondas;rondaActual++){ //para(entero rondaActual=0; rondaActual<numeroRondas; rondaActual++)
						//MostrarQuienComienza //El jugador inicial sera la Persona.
						if(ganadorRonda == 1){ //Establezco que el ganadorRonda 1 es la persona y el 0 el PC
							System.out.println();
							System.out.println("Sale persona: ");
							System.out.println("------------");
						}else{
							System.out.println();
							System.out.println("Sale el PC: ");
							System.out.println("------------");
						}
						
						//GenerarCartayPaloAleatorios
						numeroCarta = rdn.nextInt(13)+1;
						palo = rdn.nextInt(4)+1;
						
						//MostrarCartaGenerada
						switch(numeroCarta){
							case 1: 
								System.out.print("Has sacado el as de ");
							break;
							
							case 11:
								System.out.print("Has sacado el as de ");
							break;
							
							case 12:
								System.out.print("Has sacado la dama de ");
							break;
							
							case 13:
								System.out.print("Has sacado el rey de ");
							break;
							
							default:
								System.out.print("Has sacado el " + numeroCarta +" de");
							break;
						}
						
						switch(palo){
							case 1:
								System.out.print(" corazones");
							break;
							
							case 2:
								System.out.print(" picas");
							break;
							
							case 3:
								System.out.print(" diamantes");
							break;
							
							case 4:
								System.out.print(" treboles");
							break;
							
						}
						
						System.out.println();
						
						//CalcularyMostrarGanadorRonda
						if(ganadorRonda == 1){ //Si ha ganado jugador...
							if((numeroCarta == 11 || numeroCarta == 12 || numeroCarta == 13 && palo == 1) || numeroCarta == 1 || palo == 3){
								System.out.println("Ha ganado el jugador, asi que sale el");
								vicPersona++;
							}else if(palo == 2 || (numeroCarta == 2 && palo == 4)){
								System.out.println("Ha ganado el PC, por tanto sigue el");
								ganadorRonda = 0; //Es decir, si la persona ha perdido la ronda la proxima comienza el PC.
								vicPC++;
							}else{
								 System.out.println("Ha habido un empate, sigue el vencedor de la ultima ronda ganada");
								 empate++;
							}
							
						}else{ //Sino, si ha ganado el PC
							if((numeroCarta == 11 || numeroCarta == 12 || numeroCarta == 13 && palo == 1) || numeroCarta == 1 || palo == 3){
								System.out.println("Ha ganado el PC, asi que sale el");
								vicPC++;
							}else if(palo == 2 || (numeroCarta == 2 && palo == 4)){
								System.out.println("Ha ganado la persona, por tanto sigue el");
								ganadorRonda = 1;
								vicPersona++; //Fallo, antes tenia vicPC, seria vicPersona.
							}else{
								 System.out.println("Ha habido un empate, sigue el vencedor de la ultima ronda ganada");
								 empate++;
							 }
						}
						
					}//Fin_para
				
				//MostrarResultadoGeneral
				System.out.println();
				System.out.println("Rondas ganadas por Persona: "+ vicPersona+ "\nRondas ganadas por PC: "+ vicPC+ "\nEmpates: "+empate);
				if(vicPC < vicPersona) System.out.println("Ha ganado la Persona");
				else if (vicPC > vicPersona) System.out.println("Ha ganado el PC");
				else System.out.println("Ha habido un empate, solucionarlo a puños");
				
				System.out.println();
				
				//ActualizarVariables
				ganadorRonda=1; vicPC=0;vicPersona=0;empate=0;
				
				break;//fin_caso 3
			}//fin_segun
			
			//PresentarMenu, leeryValidaropcionMenu
			do{
				System.out.println();
				System.out.println("1- Pintar Rombo");
				System.out.println("2- Numero Hambriento");
				System.out.println("3- Jugar Naipe Magico");
				System.out.println("4- Salir");
				System.out.println();
				opcionMenu = teclado.nextInt();
			}while(opcionMenu < 1 || opcionMenu > 4);
			
		}//fin_mientras
		
	}
}