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
        si (aleatorio % 2 == 0)
            MostrarQuienSaleyAtaques*
            ElegirAtaque
            RealizarAtaque
        sino
            MostrarQuienSaleyAtaques*
            ElegirAtaque
            RealizarAtaque
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
        int aleatorio;
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
        System.out.println(jugador1.toString());
        System.out.println(jugador2.toString());

        //JugarStreetFighter
        //GenerarSalidaAleatoria
        aleatorio = rnd.nextInt(2)+1;

        while(jugador1.getVida() > 0 && jugador2.getVida() > 0) {//mientras jugador1.getVida() > 0 && jugador2.getVida() > 0
            if(aleatorio % 2 == 0) {//Si aleatorio % 2 == 0
                //MostrarQuienSaleyAtaques
                Utilidades.pintarHabiliades(aleatorio);

                //ElegirAtaque
                System.out.print("Elijo: ");
                elegirAtaque = teclado.nextInt();

                //realizarAtaque
                if(elegirAtaque==1){   //Mina de contusion
                    jugador1.setHabilidadDanio(10);
                    jugador2.setVida(jugador2.getVida()-jugador1.getHabilidadDanio());
                }else if(elegirAtaque==2){   //Tormenta de flechas
                    jugador1.setHabilidadDanio(20);
                    jugador2.setVida(jugador2.getVida()-jugador1.getHabilidadDanio());
                }else if(elegirAtaque==3) {   //Resurreccion
                    jugador1.setHabilidadSanacion(15);
                    jugador1.setVida(jugador1.getVida()+jugador1.getHabilidadSanacion());
                }else {   //Torbellino
                    jugador1.setHabilidadDanio(35);
                    jugador2.setVida(jugador2.getVida()-jugador1.getHabilidadDanio());
                }
            }else{//sino
                //MostrarQuienSaleyAtaques
                Utilidades.pintarHabiliades(aleatorio);
                System.out.println("Esto es del jugador 2");

                //ElergirAtaque
                System.out.print("Elijo: ");
                elegirAtaque = teclado.nextInt();

                //RealizarAtaque
                if(elegirAtaque==1) {    //Robo de vida
                    jugador2.setHabilidadDanio(10);
                    jugador2.setHabilidadSanacion(10);
                    jugador1.setVida(jugador1.getVida()-jugador2.getHabilidadDanio());
                    jugador2.setVida(jugador2.getVida()+jugador2.getHabilidadSanacion());
                }else if(elegirAtaque==2){    //Cohete Valkyria
                    jugador2.setHabilidadDanio(25);
                    jugador1.setVida(jugador1.getVida()-jugador2.getHabilidadDanio());
                }else if(elegirAtaque==3){    //Placaje
                    jugador2.setHabilidadDanio(20);
                    jugador1.setVida(jugador1.getVida()-jugador2.getHabilidadDanio());
                }else {    //Destruccion
                    jugador2.setHabilidadDanio(15);
                    jugador1.setVida(jugador1.getVida()-jugador2.getHabilidadDanio());
                }

            }
            //MostrarResultadoRonda
            System.out.println("Asi estan las cosas:");
            System.out.println("Vida del jugador 1: "+jugador1.getVida());
            System.out.println("Vida del jugador 2: "+jugador2.getVida());

            //cambiarTurno
            aleatorio++;
        }//fin_mientras

        //MostrarGanador
        if(jugador1.getVida() <= 0) System.out.println("Ha ganado el jugador 1");
        else System.out.println("Ha ganado el jugador 2");
    }
}