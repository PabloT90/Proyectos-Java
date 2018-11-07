package com.company;
import java.util.Scanner;
import java.util.Random;
/*Nombre: ExamenMoneda
 * Descripción: Este programa implementa un menu con diferentes opciones:
 * 	1º opción --> Pintar Esfera (Solo validamos los datos de entrada, lo demás queda en construcción)
 * 	2º opción --> Numero Odioso (Este se deja completamente en construcción)
 * 	3º opción --> Moneda Mágica (Se detalla más abajo)
 * 	4º opción --> Finalizar el programa
 *
 * 	Moneda Mágica: En cada ronda el jugador o la máquina lanza tres monedas
 * 	si sale tres veces cara o cruz gana el jugador en caso contrario
 * 	gana la maquina. El modulo pide un número de rondas y al final muestra
 * 	el resultado de la partida.
 *
 * 	Entrada:
 * 		-int opcion
 * 		-int numeroImpar (PintarEsfera)
 * 		-char caracterRelleno (PintarEsfera)
 * 		-char caracterSuavizado1 (PintarEsfera)
 * 		-char caracterSuavizado2 (PintarEsfera)
 * 		-char lanzarMonedas (MonedaMágica)
 * 		-int rondas (MonedaMágica)
 *
 * 	Salida:
 * 		-Mensajes de comunicación con el usuario.
 * 	    - Resultado de la competicion.
 *
 * 	Restricciones:
 * 		-opcion >= 1 y opcion <= 4
 * 		-numeroImpar >= 3 y numeroImpar <= 15 && numeroImpar % 2 != 0
 * 		-caracterRelleno >= 'A' y caracterRelleno <= 'Z' || caracterRelleno == 'Ñ'
 * 		-caracterSuavizado1 == 'd' || caracterSuavizado1 == 'b' ||
 * 		 caracterSuavizado1 == 'n' || caracterSuavizado1 == 'V' ||
 * 		 caracterSuavizado1 == 'P'
 * 		-caracterSuavizado2 == 'd' || caracterSuavizado2 == 'b' ||
 * 		 caracterSuavizado2 == 'n' || caracterSuavizado2 == 'V' ||
 * 		 caracterSuavizado2 == 'P'
 * 		-lanzarMonedas == 'x'
 * 		-rondas > 0
 *
 * 	PG
 * 	INICIO
 * 	    PresentarMenu, LeerYvalidarOpcionmenu
 * 	    mientras(opcionmenu != 4)
 * 	        segun(opcionmenu)
 * 	            caso 1:
 * 	                PintarEsfera
 * 	            caso 2:
 * 	                NumeroOdioso
 * 	            caso 3:
 * 	                MonedaMagica
 * 	        fin_segun
 * 	        ActualizarVariables
 * 	        PresentarMenu, LeeryValidarOpcionmenu
 * 	    fin_mientras
 * 	FIN
 *
 * 	Solo detallare MonedaMagica, los demas son muy simples y no me interesan.
 *
 * 	PG_1 MonedaMagica
 * 	INICIO
 * 	    LeerValidarNumeroPartidas
 * 	    para(partida; partida < numeroPartidas; partida++)
 * 	        JugarMonedaMagica
 * 	        MostrarResultadoRonda
 * 	    fin_para
 * 	    MostrarResultadoGeneral
 * 	FIN
 *
 * 	PG_2 JugarMonedaMagica
 * 	INICIO
 * 	    GenerarMonedasAleatorias
 * 	    SumarValorMonedas //Lo que hace es: establezco que cara vale 1 y que cruz vale 2. Asi sumando puedo saber que ha salido y obtener un ganador.
 * 	    ComprobarGanador
 * 	FIN
 */
public class Main {
    public static void main(String[] args) {
        int opcionMenu, numeroPartidas;
        int moneda1, moneda2, moneda3, valorMonedas, vicPC=0, vicPersona=0;
        String ganador;
        Scanner teclado = new Scanner(System.in);
        Random rdn = new Random();
        //PresentarMenu, LeerYvalidarOpcion
        do{
            System.out.println("1- Pintar Esfera");
            System.out.println("2- Numero Odioso");
            System.out.println("3- Numero Magico");
            System.out.println("4- Salir");
            opcionMenu = teclado.nextInt();
        }while(opcionMenu < 0 || opcionMenu > 4);

        /* Estudio del bucle
        * VCB: centinela (4)
        * Inicializacion: Lectura anticipada, antes de la primera iteracion.
        * Actualizacion: Lectura final, fisicamente al final del bucle.
        * Condicion entrada: opcionMenu == 1 || opcionMenu == 2 || opcionMenu == 1
        * Condicion salida: opcionMenu == 4
        * */
        while(opcionMenu != 4) { //mientras(opcionMenu != 4)
            switch(opcionMenu) { //segun(opcionMenu)
                case 1: //caso 1:
                    //PintarEsfera
                    System.out.println("--- En construccion ---");
                    break;
                case 2: //caso 2:
                    //NumeroOdioso
                    System.out.println("--- En construccion ---");
                    break;
                case 3: //caso 3:
                    //MonedaMagica
                    //LeerValidarNumeroPartidas
                    do{
                        System.out.println("Cuantas partidas quieres? No negativas, claro");
                        numeroPartidas = teclado.nextInt();
                    }while(numeroPartidas < 0);

                    /* Estudio del bucle
                    * VCB: contador.
                    * Inicializacion: antes de la primera iteracion a 0.
                    * Actualizacion: fisicamente al final del bucle.
                    * Condicion entrada: partida >= numeroPartidas
                    * Condicion Salida: partida < numeroPartidas
                    * */
                    for(int partida = 0; partida < numeroPartidas; partida++) {//para(partida; partida < numeroPartidas; partida++)
                        //JugarMonedaMagica
                        //GenerarMonedasAleatorias
                        moneda1 = rdn.nextInt(2)+1;
                        moneda2 = rdn.nextInt(2)+1;
                        moneda3 = rdn.nextInt(2)+1;

                        //SumarValorMonedas
                        valorMonedas = moneda1+moneda2+moneda3;

                        //ComprobarGanador
                        if(valorMonedas == 3 || valorMonedas == 6){
                            System.out.println("En las 3 monedas ha salido el mismo resultado!!");
                            ganador = "Persona";
                            vicPersona++;
                        }else
                            ganador = "PC";
                            vicPC++;
                            System.out.println("En las monedas no ha coincidido el resultado");
                        //MostrarResultadoRonda
                        System.out.println("El ganador de la ronda ha sido: "+ ganador);
                    }//fin_para

                    // MostrarResultadoGeneral
                    System.out.println("El resultado general ha sido de "+ vicPC + " victorias del PC y " + vicPersona + " victorias de la Persona.");

                    break;
            }//fin_segun

            //ActualizarVariables
            vicPC = 0; vicPersona = 0;
            //PresentarMenu, leeryValidarOpcionmenu
            do{
                System.out.println("1- Pintar Esfera");
                System.out.println("2- Numero Odioso");
                System.out.println("3- Numero Magico");
                System.out.println("4- Salir");
                opcionMenu = teclado.nextInt();
            }while(opcionMenu < 0 || opcionMenu > 4);
        }//fin_mientras

    }
}