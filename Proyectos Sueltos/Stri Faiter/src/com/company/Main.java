package com.company;
/* Entrada: nombre de los 2 jugadores. Edad de los jugadores.
   Salida: eco de los datos, victoria.
   Restricciones: nada.

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
    MostrarQuienInicia
    mientras jugador1.getVida() > 0 || jugador2.getVida() > 0
        si (aleatorio % 2 == 0)
            MostrarQuienSale
            MostrarAtaques
            ElegirAtaque
            RealizarAtaque
        sino
            MostrarQuienSale
            MostrarAtaques
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

        //Ataques Jugador

        //Cambiar todo esto, hacerlo de otra forma.
        Habilidad ataque1 = new Habilidad("Mina de contusion",10,0);
        Habilidad ataque2 = new Habilidad("Tormenta de Flechas",20,0);
        Habilidad ataque3 = new Habilidad("Resurreccion",0,15);
        Habilidad ataque4 = new Habilidad("Torbellino",35,0);
        //Ataques otro Jugador
        Habilidad ataque5 = new Habilidad("Robo de vida",10,10);
        Habilidad ataque6 = new Habilidad("Cohete Valkyria",20,0);
        Habilidad ataque7 = new Habilidad("Placaje",10,0);
        Habilidad ataque8 = new Habilidad("Destruccion",20,0);

        String Nombreplayer1=" ", Nombreplayer2=" ";
        int aleatorio=0;
        int edad1=0, edad2=0;
        int elegirAtaque=0;

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
        //GenerarNumeroAleatorio
        aleatorio = rnd.nextInt(2)+1;

        //MostrarQuienInicia
        if (aleatorio ==1) System.out.println("Empieza: "+ jugador1.getNombre());
            else System.out.println("Empieza: "+ jugador2.getNombre());

        while(jugador1.getVida() > 0 || jugador2.getVida() > 0) {//mientras jugador1.getVida() > 0 || jugador2.getVida() > 0
            if(aleatorio % 2 == 0) {//Si aleatorio % 2 == 0
                //MostrarQuienSale
                System.out.println("-------------");
                System.out.println("Va el jugador 1");
                System.out.println("-------------");
                //MostrarAtaques
                System.out.println("Ataques disponibles:");
                System.out.println(ataque1);
                System.out.println(ataque2);
                System.out.println(ataque3);
                System.out.println(ataque4);

                //ElegirAtaque
                System.out.print("Elijo: ");
                elegirAtaque = teclado.nextInt();

                //realizarAtaque
                if(elegirAtaque==1) jugador2.setVida(jugador2.getVida()-jugador1.getHabilidadDanio());
                    else if(elegirAtaque==2) jugador2.setVida(jugador2.getVida()-ataque2.getDanio());
                        else if(elegirAtaque==3) jugador1.setVida(jugador2.getVida()+ataque3.getSanacion());
                            else jugador2.setVida(jugador2.getVida()-ataque4.getDanio());
            }else {//sino
                //MostrarQuienSale
                System.out.println("-------------");
                System.out.println("Va el jugador 2");
                System.out.println("-------------");
                //MostrarAtaques
                System.out.println("Ataques disponibles:");
                System.out.println(ataque5);
                System.out.println(ataque6);
                System.out.println(ataque7);
                System.out.println(ataque8);

                //ElergirAtaque
                System.out.print("Elijo: ");
                elegirAtaque = teclado.nextInt();
                //RealizarAtaque
                if(elegirAtaque==1) {
                    jugador1.setVida(jugador1.getVida()-ataque5.getDanio());
                    jugador2.setVida(jugador2.getVida()+ataque5.getSanacion());
                }
                else if(elegirAtaque==2) jugador1.setVida(jugador1.getVida()-ataque6.getDanio());
                    else if(elegirAtaque==3) jugador2.setVida(jugador1.getVida()+ataque7.getSanacion());
                        else jugador1.setVida(jugador1.getVida()-ataque8.getDanio());

            }
            //MostrarResultadoRonda
            System.out.println("Asi estan las cosas:");
            System.out.println("Vida del jugador 1: "+jugador1.getVida());
            System.out.println("Vida del jugador 2: "+jugador2.getVida());

            //cambiarTurno
            aleatorio++; //Con esto soluciono de forma muy rapida el cambiar el turno. En los IF tengo el modulo de la division por lo que ira alternando.
        }//fin_mientras

        //MostrarGanador
        if(jugador1.getVida() <= 0) System.out.println("Ha ganado el jugador 1");
        else System.out.println("Ha ganado el jugador 2");
    }
}