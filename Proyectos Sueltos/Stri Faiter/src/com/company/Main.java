package com.company;
/* Entrada: nombre de los 2 jugadores. Edad de los jugadores.
   Salida: eco de los datos, quien ha ganado.
   Restricciones: nada. (Tiene, pero no las pongo porque quiero centrarme en lo importante)

PG
INICIO
    LeerEstablecerNombreJugadores
    LeerEstablecerEdadJugadores
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
import com.company.Objetos.*;
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random rnd = new Random();

        //Jugadores
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        String Nombreplayer1, Nombreplayer2;
        int turno;
        int edad1, edad2;
        int elegirAtaque;

        //LeerEstablecerNombreJugadores
        System.out.println("Nombre del primer jugador");
        Nombreplayer1 = teclado.nextLine();
        jugador1.setNombre(Nombreplayer1);
        System.out.println("Nombre del segundo jugador");
        Nombreplayer2 = teclado.nextLine();
        jugador2.setNombre(Nombreplayer2);

        //LeerEstablecerEdadJugadores
        System.out.println("Edad del primer jugador");
        edad1 = teclado.nextInt();
        jugador1.setEdad(edad1);
        System.out.println("Edad del segundo jugador");
        edad2 = teclado.nextInt();
        jugador2.setEdad(edad2);

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