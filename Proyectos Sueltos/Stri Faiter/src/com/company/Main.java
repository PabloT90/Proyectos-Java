package com.company;
/* Entrada: nombre de los 2 jugadores. Edad de los jugadores.
   Salida: eco de los datos, quien ha ganado.
   Restricciones: La seleccion de jugadores solo admite numeros entre 1 y 4.

PG
INICIO
  LeerValidarSeleccionarJugador
    MostrarDatosJugadores
    JugarStreetFighter
    MostrarGanador
FIN

PG_1 JugarStreetFighter
INICIO
    GenerarSalidaAleatoria
    mientras jugador1.getVida() > 0 && jugador2.getVida() > 0
        si (turno % 2 == 0)
            MostrarQuienSaleyAtaques*
            ElegirAtaque
            RealizarAtaque*
        sino
            MostrarQuienSaleyAtaques*
            ElegirAtaque
            RealizarAtaque*
        fin_si
        MostrarResultadoRonda
        cambiarTurno
    fin_mientras
FIN
* */
import java.util.Scanner;
import java.util.Random;

import com.company.Enums.EnumJugador;
import com.company.Objetos.*;
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random rnd = new Random();

        //Jugadores
        Jugador jugador1;
        Jugador jugador2;

        //Enum
        EnumJugador pablo = EnumJugador.PABLO;
        EnumJugador yeray = EnumJugador.YERAY;
        EnumJugador rafa = EnumJugador.RAFAEL;
        EnumJugador nesde = EnumJugador.NESDE;

        String Nombreplayer1, Nombreplayer2;
        int turno;
        int edad1, edad2;
        int elegirAtaque;

        int selectJugador,selectJugador2;

       //LeerValidarSeleccionarJugador
        do{
            Utilidades.MostrarOponentes();
            selectJugador = teclado.nextInt();
            System.out.println("Elige oponente:");
            Utilidades.MostrarOponentes();
            selectJugador2 = teclado.nextInt();
        }while((selectJugador < '1' || selectJugador > 4) && (selectJugador2 < 1 || selectJugador2 > 4));


        switch(selectJugador){
            case 1: jugador1 = new Jugador(nesde.getNombre(),100,nesde.getEdad(),0,0);
                break;
            case 2: jugador1 = new Jugador(pablo.getNombre(),100,pablo.getEdad(),0,0);
                break;
            case 3: jugador1 = new Jugador(rafa.getNombre(),100,rafa.getEdad(),0,0);
                break;
            case 4: jugador1 = new Jugador(yeray.getNombre(),100, yeray.getEdad(),0,0);
                break;
            default: jugador1 = new Jugador();
                break;
        }

        switch(selectJugador2){
            case 1: jugador2 = new Jugador(nesde.getNombre(),100,nesde.getEdad(),0,0);
                break;
            case 2: jugador2 = new Jugador(pablo.getNombre(),100,pablo.getEdad(),0,0);
                break;
            case 3: jugador2 = new Jugador(rafa.getNombre(),100,rafa.getEdad(),0,0);
                break;
            case 4: jugador2 = new Jugador(yeray.getNombre(),100, yeray.getEdad(),0,0);
                break;
                default: jugador2 = new Jugador();
                    break;
        }

        //MostrarDatosJugadores
        System.out.println("Hola");
        System.out.println("Nombre: "+jugador1.getNombre()+" Edad: "+ jugador1.getEdad());
        System.out.println("Nombre: "+jugador2.getNombre()+" Edad: "+ jugador2.getEdad());

        //JugarStreetFighter
        //GenerarSalidaAleatoria
        turno = rnd.nextInt(2)+1;

        while(jugador1.getVida() > 0 && jugador2.getVida() > 0) {//mientras jugador1.getVida() > 0 && jugador2.getVida() > 0
            if(turno % 2 == 0) {//Si turno % 2 == 0
                //MostrarQuienSaleyAtaques*
                Utilidades.pintarHabiliades(turno);

                //ElegirAtaque
                System.out.print("Elijo: ");
                elegirAtaque = teclado.nextInt();

                //realizarAtaque*
                Utilidades.realizarAtaque(elegirAtaque,jugador1, jugador2);

            }else{//sino  //Jugador2
                //MostrarQuienSaleyAtaques*
                Utilidades.pintarHabiliades(turno);

                //ElergirAtaque
                System.out.print("Elijo: ");
                elegirAtaque = teclado.nextInt();

                //RealizarAtaque*
                 Utilidades.realizarAtaque2(elegirAtaque,jugador1, jugador2);
            }
            //MostrarResultadoRonda
            System.out.println("Asi estan las cosas:");
            System.out.println("Vida del jugador 1: "+jugador1.getVida());
            System.out.println("Vida del jugador 2: "+jugador2.getVida());

            //cambiarTurno
            turno++;
        }//fin_mientras

        //MostrarGanador
        if(jugador1.getVida() <= 0) System.out.println("Ha ganado el jugador 1");
        else System.out.println("Ha ganado el jugador 2");
    }
}