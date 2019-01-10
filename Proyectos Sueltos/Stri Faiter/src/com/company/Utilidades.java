package com.company;
public class Utilidades {
    /* Descripcion: proporciona los ataques de cada jugador.
    Entrada: int muestraAtaques.
    Precondiciones: no hay.
    Salida: nada.
    PostCondiciones: no hay, solo pinta en pantalla.
    Cabecera: public static void pintarHabiliades(int muestraAtaques)
    * */
    public static void pintarHabiliades(int muestraAtaques){
        if(muestraAtaques % 2 ==0) {
            System.out.println("-------------");
            System.out.println("Turno del jugador 1");
            System.out.println("-------------");
            //Ataques
            System.out.println("Ataques disponibles:");
            System.out.println("1) Mina de contusion   Daño: 10");
            System.out.println("2) Tormenta de Flechas  Daño: 20");
            System.out.println("3) Resurreccion   Sanacion: 15");
            System.out.println("4) Torbellino  Daño: 35");
        }else{
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
}