package com.company.Tests;
import com.company.Objetos.Jugador;
import com.company.Excepciones;

public class TestJugador {
    public static void main(String[]args){
        //Constructor por defecto
        Jugador player1 = new Jugador();
        System.out.println("Por defecto: "+player1.toString());
        //Constructor con parametros
        Jugador player2 = new Jugador("Pablo",100,11,0,0);
        System.out.println("Con parametros: "+player2.toString());
        //Construtor de copia
        Jugador player3 = new Jugador(player2);
        System.out.println("De copia: "+player3.toString());
        //Gets y sets
        try {
            player1.setVida(10);
            //player1.setVida(-10); Debe dar error
        }catch(Excepciones error){
            System.out.println("Error en la vida");
        }
        System.out.println("Vida: "+player1.getVida());
        try{
            player1.setEdad(11);
            //player1.setEdad(-1); Debe dar error
        }catch(Excepciones error){
            System.out.println("Error en la edad");
        }
        System.out.println("Edad: "+player1.getEdad());

        player1.setNombre("Rafae");
        System.out.println("Nombre: "+player1.getNombre());

        try{
            player1.setHabilidadDanio(11);
            //player1.setHabilidadDanio(-12);
            //player1.setHabilidadDanio(100);
        }catch(Excepciones error){
            System.out.println("Error en el daño");
        }
        System.out.println("Danio: "+player1.getHabilidadDanio());

        try{
            player1.setHabilidadSanacion(11);
            //player1.setHabilidadSanacion(-12);
            //player1.setHabilidadSanacion(100);
        }catch(Excepciones error){
            System.out.println("Error en la sanacion");
        }
        System.out.println("Danio: "+player1.getHabilidadSanacion());

        player1.Atacar(player2,20);
        System.out.println("Vida del jugador 2: "+player2.getVida());

        player2.Sanar(15);
        System.out.println("Sanar, Vida Jugador 2: "+ player2.getVida());

        //hashCode
        System.out.println("hashCode: "+player1.hashCode());

        //equals
        System.out.println("Equals jugador 1 con el 2: "+player1.equals(player2));
        System.out.println("Equals jugador 1 con el 3: "+player1.equals(player3));

        //CompareTo
        System.out.println("compareTo jugador 1 con el 2: "+player1.compareTo(player2));
        System.out.println("compareTo jugador 1 con el 3: "+player1.compareTo(player3));

        //Clone
        System.out.println("Prueba clone: ");
        System.out.println("player1.toString() --> "+player1.toString());
        System.out.println("player3.toString() --> "+player3.toString());

        System.out.println("player3 = player1.clone() --> Realizamos la clonacion");
        player3 = player1.clone();
        System.out.println("player1.equals(player3) --> "+player1.equals(player3));
    }
}