package com.company;
/* PG
Entrada: opcionMenu.
Salida: eco de los datos, menu.
Restricciones: la opcion del menu debe estar entre 1 y 4.
INCICIO
    MostrarMenuLeeryValidar
    mientras opcionMenu != 4
        segun(opcionMenu)
            opcion 1:
                PintarColina
            opcion 2:
                NumeroMalvado
            opcion 3:
                CartaMagica
        fin_segun
        MostrarMenuLeeryValidar
    fin_mientras
FIN

Analisis PintarColina
Entrada: numeroAltura, caracterRelleno, caracterSuavizado, ejecutar.
Salida: pinta en pantalla.
Restricciones:
    - El numero tiene que ser impar entre 5 y 17
	- El caracter de relleno tiene que ser una letra mayuscula
	- Los caracteres de suavizado solo pueden ser d,b,n,A,J
	- Ejecutar debe ser 's' o 'n'.

PG PintarColina
INICIO
    LeerValidarEjecutar
    mientras quiera ejecutar
        LeerValidarNumero
        LeerValidarCaracterRelleno
        LeerValidarCaracterSuavizado
        ImprimiColina
        LeerValidarEjecutar
    fin_mientras
FIN

Analisis CartaMagica
El ordenador simulará un juego en el que hay que sacar una carta, segun las restricciones abajo descritas
decidiremos quien ha ganado la ronda. La primera jugada es del jugador. La primera vez saca el jugador, las siguientes
saca el que haya ganado la anterior y en caso de empate sacará el ultimo que haya ganado

Entrada: numeroPartidas, ejecutar.
Salida: eco de los datos, resultados.
Restricciones: - numeroPartidas debe estar entre 1 y 10.
               - ejecutar debe ser 's' o 'n'.
	- OROS: del 1 al 10 (figuras: 8, 9, 10)
	- BASTOS: del 11 al 20 (figuras: 18, 19, 20)
	- COPAS: del 21 al 30 (figuras: 28, 29, 30)
	- ESPADAS: del 31 al 40 (figuras: 38, 39, 40)

	Se gana si se saca una carta que:
		- Esté entre 8 y 11 o entre 21 y 40
	Se pierde si se saca una carta que:
		- Sea 22
	- Numero de jugadas máximo: 10

PG
INICIO
    LeerValidarEjecutar
    mientras quiera ejecutar
        LeerValidarNumeroPartidas
        para(int partida; partida <= numeroPartidas; partidas++)
            JugarCartaMagica //Analizado abajo
        fin_para
        MostrarResultadoGeneral
        ActualizarVariables
        LeerValidarEjecutar
    fin_mientras
FIN

PG JugarCartaMagica
INICIO
    MostrarJugadorSalida
    GenerarCarta
    EstablecerGanador
    si ganador es igual a Persona
        segun(ganador)
            caso 1:
                MostrarGanadorPersona
                ActualizarVictoriasPersona
                ActualizarNombreGanador
            caso 2:
                MostrarGanadorPC
                ActualizarVictoriasPC
                ActualizarNombreGanador
            caso 3:
                MostrarEmpate
                ActualizarEmpates
        fin_segun
    sino
        segun(ganador)
            caso 1:
                MostrarGanadorPC
                ActualizarVictoriasPC
                ActualizarNombreGanador
            caso 2:
                MostrarGanadorPersona
                ActualizarVictoriasPersona
                ActualizarNombreGanador
            caso 3:
                MostrarEmpate
                ActualizarEmpates
        fin_segun
    fin_si
FIN
*/
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        int opcionMenu,numeroPartidas, carta;
        int ganador, victoriasPersona = 0, victoriasPC =0, empate = 0;
        char ejecutar;
        String nombreGanador = "Persona";
        Scanner teclado = new Scanner(System.in);
        Random aleatorio = new Random();

        //MostrarMenuLeeryValidar
        do{
            System.out.println("1- Pintar Colina");
            System.out.println("2- Numero Malvado");
            System.out.println("3- Carta Magica");
            System.out.println("4- Salir");
            opcionMenu = teclado.nextInt();
        }while(opcionMenu < 1 || opcionMenu > 4);

        while(opcionMenu != 4) {//mientras opcionMenu != 4

            switch(opcionMenu) {//segun(opcionMenu)
                case 1://opcion 1:
                    //PintarColina
                    System.out.println("--En construccion--");
                    break;
                case 2://opcion 2:
                    //NumeroMalvado
                    System.out.println("--En construccion--");
                    break;
                //opcion 3:
                case 3:
                    //CartaMagica
                    //LeerValidarEjecutar
                    do{
                        System.out.println("Quieres ejecutar Carta Magica?");
                        ejecutar = Character.toLowerCase(teclado.next().charAt(0));
                    }while(ejecutar != 's' && ejecutar != 'n');

                    while(ejecutar != 'n') {//mientras quiera ejecutar
                        //LeerValidarNumeroPartidas
                        do{
                            System.out.println("Cuantas partidas quieres? Entre 1 y 10");
                            numeroPartidas = teclado.nextInt();
                        }while(numeroPartidas < 1 || numeroPartidas > 10);

                        for(int partida = 0; partida < numeroPartidas; partida++) {//mientras haya partidas
                            //JugarCartaMagica

                            //MostrarJugadorSalida
                            System.out.println("Sale: "+ nombreGanador);

                            //GenerarCarta
                            carta = aleatorio.nextInt(40)+1;
                            System.out.println("La carta ha salido: " + carta);

                            //EstablecerGanador
                            if(carta >= 8 && carta <= 11 || carta == 21 || carta >= 23 && carta <= 40) ganador = 1;
                            else if (carta == 22)  ganador = 2;
                            else ganador = 3;

                            if(nombreGanador.equals("Persona")) {
                                switch (ganador) {//segun(ganador)
                                    case 1://caso 1:
                                        //MostrarGanadorPersona
                                        System.out.println("Ha ganado la persona");

                                        //ActualizarVictoriasPersona
                                        victoriasPersona++;

                                        //ActualizarNombreGanador
                                        nombreGanador = "Persona";
                                        System.out.println("-------------------");
                                        break;
                                    case 2://caso 2:
                                        //MostrarGanadorPC
                                        System.out.println("Ha ganado el PC");

                                        //ActualizarVictoriasPC
                                        victoriasPC++;

                                        //ActualizarNombreGanador
                                        nombreGanador = "PC";
                                        System.out.println("-------------------");
                                        break;
                                    case 3://caso 3:
                                        //MostrarEmpate
                                        System.out.println("Ha habido un empate, el orden de tirada sera el mismo");
                                        System.out.println("-------------------");

                                        //ActualizarEmpates
                                        empate++;
                                        break;
                                }//fin_segun
                            }else{
                                switch (ganador) {//segun(ganador)
                                    case 1://caso 1:
                                        //MostrarGanadorPC
                                        System.out.println("Ha ganado el PC");

                                        //ActualizarVictoriasPC
                                        victoriasPC++;

                                        //ActualizarNombreGanador
                                        nombreGanador = "PC";
                                        System.out.println("-------------------");
                                        break;
                                    case 2://caso 2:
                                        //MostrarGanadorPersona
                                        System.out.println("Ha ganado la Persona");

                                        //ActualizarVictoriasPersona
                                        victoriasPersona++;

                                        //ActualizarNombreGanador
                                        nombreGanador = "Persona";
                                        System.out.println("-------------------");
                                        break;
                                    case 3://caso 3:
                                        //MostrarEmpate
                                        System.out.println("Ha habido un empate, el orden de tirada sera el mismo");
                                        System.out.println("-------------------");

                                        //ActualizarEmpates
                                        empate++;
                                        break;
                                }//fin_segun
                            }
                        }//fin_para

                        //MostrarResultadoGeneral
                        System.out.println("El resultado ha sido \n"+
                                " Victorias Persona: "+ victoriasPersona +
                                " \n Victorias PC: "+ victoriasPC+
                                " \n Empates: "+ empate);

                        //ActualizarVaribales
                        victoriasPC = 0; victoriasPersona = 0; empate = 0; nombreGanador = "Persona";

                        //LeerValidarEjecutar
                        do{
                            System.out.println("Quieres ejecutar Carta Magica?");
                            ejecutar = Character.toLowerCase(teclado.next().charAt(0));
                        }while(ejecutar != 's' && ejecutar != 'n');
                    }//fin_mientras
                    break;
            }//fin_segun

            //MostrarMenuLeerValidar
            do{
                System.out.println("1- Pintar Colina");
                System.out.println("2- Numero Malvado");
                System.out.println("3- Carta Magica");
                opcionMenu = teclado.nextInt();
            }while(opcionMenu < 1 || opcionMenu > 4);
        }//Fin_mientras

    }
}