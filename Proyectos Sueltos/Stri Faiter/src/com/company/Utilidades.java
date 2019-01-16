package com.company;
import com.company.Objetos.Jugador;
public class Utilidades {
    /**
     * @author "Pablo Prats"
     * @version "1.0"
     * @param turno "Establece que cuarteto de habilidades se va a mostrar. Se pasa por valor."
     */
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

    /**
     * @author "Pablo Prats"
     * @version "1.0"
     * @param turno "Establece que cuarteto de personajes disponibles."
     */
    public static void MostrarOponentes(){
        System.out.println("Con quien quieres jugar?");
        System.out.println("1) Nesde");
        System.out.println("2) Pablo");
        System.out.println("3) Rafa");
        System.out.println("4) Yeray");
    }

    /**
     * @author "Pablo Prats"
     * @version "v1.0"
     * @param numAtaque "El numero del ataque deseado. Entre 1 y 4. Se pasa por valor."
     * @param player1 "Quien realiza la accion. Se pasa por direccionamiento."
     * @param player2 "A quien se le aplica la accion. Se pasa por direccionamiento."
     */
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

    /**
     * @author "Pablo Prats"
     * @version "v1.0"
     * @param numAtaque "Numero del ataque deseado. Entre 1 y 4. Se pasa por valor."
     * @param player1 "Quien realiza la accion. Se pasa por direccionamiento."
     * @param player2 "A quien se le aplica la accion. Se pasa por direccionamiento."
     */
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