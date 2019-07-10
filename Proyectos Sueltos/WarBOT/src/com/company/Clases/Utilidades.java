package com.company.Clases;

import java.util.Scanner;

public class Utilidades {
    public static int leerValidarOpcionMenu1(){
        Scanner teclado = new Scanner(System.in);
        int opcion;

        do{
            MostrarMenu1();
            opcion = teclado.nextInt();
        }while(opcion < 1 || opcion > 3);

        return opcion;
    }

    public static void MostrarMenu1(){
        System.out.println("1) Comenzar Juego.");
        System.out.println("2) Regalas y funcionamiento.");
        System.out.println("3) Salir.");
    }

    public static void reglasYFuncionamiento(){
        System.out.println("|                                                       Funcionamiento del juego:                                                                    |" +
                "\n| De los 50 personajes que existen en el juego se eligen 20 de forma aleatoria para que peleen.                                                      |" +
                "\n| Cada 10 segundos se producira un unico enfrentamiento entre 2 jugadores cuya victoria es decida mediante un valor de letalidad y el azar.          |" +
                "\n| Cuanta mas letalidad poseas mayores seran tu oportunidades de conseguir la victoria. Aunque no te la garantiza.                                    |" +
                "\n| Este valor se puede aumentar a medida que consigues kills.                                                                                         |" +
                "\n| El juego termina cuando solo queda 1 jugador en pie. Al final se podra consultar el historial de muertes de cualquier personaje.                   |" +
                "\n| ---------------------------------------------------------------------------------------------------------------------------------------------------|");
    }

    public static void MostrarMenu2(){
        System.out.println("1) Consultar Kills de un jugador.");
        System.out.println("2) Volver Atras.");
    }

    public static int leerValidarOpcionMenu2(){
        Scanner teclado = new Scanner(System.in);
        int opcion;

        do{
            MostrarMenu2();
            opcion = teclado.nextInt();
        }while(opcion < 1 || opcion > 3);

        return opcion;
    }
}
