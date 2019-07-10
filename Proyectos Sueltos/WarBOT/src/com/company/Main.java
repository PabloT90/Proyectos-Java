package com.company;

import com.company.Clases.Gestora;
import com.company.Clases.Utilidades;

import java.util.Scanner;

/*
* Informacion sobre el juego:
* DAMWarBOT se trata de un juego de guerra todos contra todos. Dispone de una lista de 50 participantes de los cuales en cada partida se seleccionan 20.
* Cada 10 segundos se producirá un combate aleatorio entre 2 oponentes. Este se decidira teniendo en cuenta el factor Letalidad de los personajes(el cual se puede incrementar mientras mas kills consiga.) y algo de azar.
* Un jugador con un nivel de letalidad mayor tendra ventaja, aunque no quiere decir que tenga asegurada la victoria.
* Al final solo puede quedar un jugador que será el ganador.
* Cada vez que un jugador consiga una kill sera mostrada en pantalla junto al nombre del oponente caido.
* Una vez finalidad la partida se podra consultar el historial de kills de un jugador concreto.
* */
/* Entrada:
    - char ejecutar
    - int opcionMenu1
    - int opcionMenu2
 * Salida:
    - Mensajes de comunicacion con el usuario.
    - Mensajes de las muertes que se van produciendo a lo largo de la partida.
    - Nombre de las personas que ha matado una seleccionada.
    - Nombre del ganador.
    - Diversos menus.
 * Restricciones:
    - opcionMenu1 debe estar entre 1 y 3.
    - ejecutar debe ser 's' o 'n'.
    - opcionMenu2 debe estar entre 1 y 2
PG N0
INICIO
repetir
    MostrarMenu, leer y ValidarOpcionMenu1*
    segun(opcionMenu1)
        caso 1
            ComenzarJuego
        caso 2
            FuncionamientoYReglas.
    fin_segun
mientras ejecutar != 3
FIN

PG N1 ComenzarJuego
INICIO
    EstablecerParticipantes*
    MostrarListaParticipantes*
    DesarrollarPartida
    MostrarGanador*
    MostrarMenu2, leeryValidarOpcionMenu2*
    mientras opcionMenu2 != 2
        segun (opcionMenu2)
            caso 1:
                MostrarListaParticipantes*
                SeleccionarParticipante.
                KillsParticipante* //Muestra las kills que se ha hecho un participante seleccionado en la partida.
        fin_segun
    fin_mientras
FIN

PG N2 DesarrollarPartida
INICIO
repetir
    enfrentarOpenentes*
    mensajeEliminacion* //Mesanje que se muestra cuando se consigue una kill
    incrementarLetalidad* //La persona que consigue la kill ve incrementada su letalidad
    esperar10segundos*
mientras queden jugadores mas de 2 jugadores
FIN
 *  */
public class Main {
    public static void main(String[] args) {
        int opcionMenu1;
        int opcionMenu2;
        Scanner teclado = new Scanner(System.in);

        //Borrar luego:
        Gestora.ajustesEncabezamiento();
        //Rellenar la lista de jugadores totales
        Gestora.rellenarLista();


        do {//repetir
            //MostrarMenu, leer y ValidarOpcionMenu1*
            opcionMenu1 = Utilidades.leerValidarOpcionMenu1();

            switch(opcionMenu1) {//segun(opcionMenu1)
                case 1: //caso 1
                    //EstablecerParticipantes*
                    Gestora.establecerJugadores();
                    //MostrarListaParticipantes*
                    Gestora.mostrarParticipantes();

                    //repetir
                        //enfrentarOpenentes*
                        //mensajeEliminacion* //Mesanje que se muestra cuando se consigue una kill
                        //incrementarLetalidad* //La persona que consigue la kill ve incrementada su letalidad
                        //esperar10segundos*
                    //mientras queden jugadores mas de 2 jugadores

                    //MostrarGanador*

                    //MostrarMenu2, leeryValidarOpcionMenu2*
                    opcionMenu2 = Utilidades.leerValidarOpcionMenu2();

                    while(opcionMenu2 != 2){//mientras opcionMenu2 != 2
                        switch(opcionMenu2) {//segun (opcionMenu2)
                            case 1: //caso 1:
                                //MostrarListaParticipantes*
                                Gestora.mostrarParticipantes();
                                //seleccionarParticipante*
                                //KillsParticipante* //Muestra las kills que se ha hecho un jugador seleccionado en la partida.
                                break;
                        }//fin_segun
                    }//fin_mientras
                    break;
                case 2: //caso 2
                    //FuncionamientoYReglas*
                    Utilidades.reglasYFuncionamiento();
                    break;
            }//fin_segun
        }while(opcionMenu1 != 3);//mientras ejecutar != 3

    }
}
