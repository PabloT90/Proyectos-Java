package com.company;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        int regalo;
        char respuesta;
        char pista;
        char letra;
        boolean ganador = false;
        int intento = 1;
        String[] pista13 = {"La palabra es una palabra inglesa", "Es algo que te hace mucha falta para poder responder", "Es algo tecnologico"};
        int contadorpista = 0;
        Scanner teclado = new Scanner (System.in);
        //LeeryValidarRespuesta
        do {
            System.out.println("Desea ejecutar?");
            respuesta = Character.toLowerCase(teclado.next().charAt(0));
        }
        while(respuesta != 's' && respuesta != 'n');

        //MientrasRespuestaSeaSi
        while(respuesta == 's') {
            //Juego
            do {
                System.out.println("Elija su regalo");
                System.out.println("1.");
                System.out.println("2.");
                System.out.println("3.");
                regalo = teclado.nextInt();
            }
            while(regalo < 0 || regalo > 4);
            switch(regalo) {
                case 1:
                    String num1 = "smartwatch";
                    char[] primero = num1.toCharArray();
                    char[] primeroGuion = new char[primero.length];
                    for(int i = 0; i < primero.length; i++) {
                        primeroGuion[i] = '_';
                    }
                    ganador = false;
                    while(ganador == false) {
                        System.out.println("Adivina la palabra (tiene 10 letras)");
                        letra = teclado.next().charAt(0);

                        for(int i = 0; i < primero.length; i++) {
                            if(primero[i]== letra) {
                                primeroGuion [i] = letra;
                            }
                        }

                        if(Arrays.equals(primero, primeroGuion)) {
                            ganador = true;
                        }
                        System.out.println(primeroGuion);
                    }
                    break;

                case 2:
                    num1 = "taza";
                    primero = num1.toCharArray();
                    primeroGuion = new char[primero.length];
                    for(int i = 0; i < primero.length; i++) {
                        primeroGuion[i] = '_';
                    }

                    while(ganador == false) {
                        System.out.println("Adivina la palabra (tiene 4 letras)");
                        letra = teclado.next().charAt(0);

                        for(int i = 0; i < primero.length; i++) {
                            if(primero[i]== letra) {
                                primeroGuion [i] = letra;
                            }
                        }

                        if(Arrays.equals(primero, primeroGuion)) {
                            ganador = true;
                        }
                        System.out.println(primeroGuion);
                    }
                    break;

                case 3:
                    num1 = "slime";
                    primero = num1.toCharArray();
                    primeroGuion = new char[primero.length];
                    for(int i = 0; i < primero.length; i++) {
                        primeroGuion[i] = '_';
                    }

                    while(ganador == false) {
                        System.out.println("Adivina la palabra (tiene 5 letras)");
                        letra = teclado.next().charAt(0);

                        for(int i = 0; i < primero.length; i++) {
                            if(primero[i]== letra) {
                                primeroGuion [i] = letra;
                            }

                        }

                        if(Arrays.equals(primero, primeroGuion)) {
                            ganador = true;
                        }
                        System.out.println(primeroGuion);
                    }
                    break;
            }

            //LeeryValidarRespuesta
            do {
                System.out.println("Desea ejecutar?");
                respuesta = Character.toLowerCase(teclado.next().charAt(0));
            }
            while(respuesta != 's' && respuesta != 'n');
        } //FinMientras

    }
}