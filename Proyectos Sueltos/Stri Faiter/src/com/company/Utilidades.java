package com.company;
import com.company.Objetos.Jugador;
public class Utilidades {
    /* Descripcion: proporciona los ataques de cada jugador.
    Entrada: int muestraAtaques.
    Precondiciones: no hay.
    Salida: nada.
    PostCondiciones: no hay, solo pinta en pantalla.
    Cabecera: public static void pintarHabiliades(int muestraAtaques)
    * */
    public static void pintarHabiliades(int turno) {
        if (turno % 2 == 0) {
            System.out.println("-------------");
            System.out.println("Turno del jugador 1");
            System.out.println("-------------");
            //Ataques
            System.out.println("Ataques disponibles:");
            System.out.println("1) Mina de contusion   Daño: 10");
            System.out.println("2) Tormenta de Flechas  Daño: 20");
            System.out.println("3) Resurreccion   Sanacion: 15");
            System.out.println("4) Torbellino  Daño: 35");
        } else {
            System.out.println("-------------");
            System.out.println("Turno del jugador 2");
            System.out.println("-------------");
            //Ataques
            System.out.println("Ataques disponibles:");
            System.out.println("1) Robo de vida Daño: 10 Sanacion: 10");
            System.out.println("2) Cohete Valkyria  Daño: 25");
            System.out.println("3) Placaje   Daño: 20");
            System.out.println("4) Destruccion  Daño: 15");
        }
    }

    /* Descripcion: se encarga se realizar el ataque elegido previamente.
    Entrada: int numAtaque, Jugador player1, Jugador player2.
    Precondiciones: por valor se pasa el numero del ataque elegido y 2 jugadores por direccionamiento.
    Salida: nada.
    PostCondiciones: nada, modifica el estado de los jugadores.
    Cabecera: void realizarAtaque(int numAtaque, Jugador player1, Jugador player2)
    * */
    public static void realizarAtaque(int numAtaque,Jugador player1, Jugador player2){
        switch(numAtaque){
            case 1: player1.Atacar(player2,10); //Mina de contusion
                break;
            case 2: player1.Atacar(player2,20); //Tormenta de flechas
                break;
            case 3: player1.Sanar(15); //Resurreccion
                break;
            case 4: player1.Atacar(player2,35); //Torbellino
                break;
        }
    }

    public static void realizarAtaque2(int numAtaque,Jugador player1, Jugador player2){
        switch(numAtaque){
            case 1:  //Robo de vida
                player2.Atacar(player1,10);
                player2.Sanar(10);
                break;
            case 2: player2.Atacar(player1,25); //Cohete Valkyria
                break;
            case 3: player2.Atacar(player1,20); //Placaje
                break;
            case 4: player2.Atacar(player1,15); //Destruccion
                break;
        }
    }

}