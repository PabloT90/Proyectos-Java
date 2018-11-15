package com.company;
/* Descripcion: Realizar un programa que mediante menú nos permita sumar los dígitos de un número, o bien devolverlo invertido.
* Entrada: entero opcionMenu, entero numero.
* Salida: mensajes de comunicacion con el usuario, el numero invertido, la suma de los digitos de un numero.
* Restricciones: ninguna.
*
* PG
* INICIO
*   MostrarMenu, leeryValidarOpcionMenu
*   mientras opcionMenu != 3
*       segun(opcionMenu)
*           caso 1:
*               LeerNumero
*               SumarDigitosNumero*
*               MostrarResultadoSumaDigitos
*           fin_caso 1
*
*           caso 2:
*               LeerNumero
*               NumeroInvertido*
*               MostrarResultadoNumeroInvertido
*           fin_c-aso 2
*       fin_segun
*       MostrarMenu, leeryValidarOpcionMenu
*   fin_mientras
* FIN
* */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int opcionMenu=0,numero=0, sumaDigitos=0, numeroInvertido=0;
        Scanner teclado = new Scanner(System.in);

        //MostrarMenu, leeryValidarOpcionMenu
        do{
            System.out.println("1- Sumar Digitos de un numero");
            System.out.println("2- Imprimir numero invertido");
            System.out.println("3- Salir");
            System.out.println("---------");
            opcionMenu = teclado.nextInt();
        }while(opcionMenu < 1 || opcionMenu > 3);

        while(opcionMenu != 3) {//mientras opcionMenu != 3
            switch(opcionMenu) { //segun(OpcionMenu)
                case 1:
                    //LeerNumero
                    System.out.println("Dime un numero:");
                    numero = teclado.nextInt();

                    //SumarDigitosNumero*
                    sumaDigitos = Utilidades.SumarDigitosNumero(numero);

                    //MostrarResultadoSumaDigitos
                    System.out.println("El la suma de los digitos del numero: " + numero + " es: "+ sumaDigitos);
                    break;

                case 2:
                    //LeerNumero
                    System.out.println("Dame un numero");
                    numero = teclado.nextInt();

                    //NumeroInvertido*
                    numeroInvertido = Utilidades.NumeroInvertido(numero);

                    //MostrarResultadoNumeroInvertido
                    System.out.println("El numero invertido de " + numero + " es: "+ numeroInvertido);
                    break;
            }

            //MostrarMenu, leeryValidarOpcionMenu
            do{
                System.out.println("1- Sumar Digitos de un numero");
                System.out.println("2- Imprimir numero invertido");
                System.out.println("3- Salir");
                System.out.println("---------");
                opcionMenu = teclado.nextInt();
            }while(opcionMenu < 1 || opcionMenu > 3);

        }//fin_mientras

    }
}