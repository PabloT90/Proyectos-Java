package com.company;
//Enunciado: hacer un programa que imprima, cuente y sume los multiplos de 3 que hay entre 1 y un numero leido por teclado
/* Entrada: respuesta, numero.
   Salida: resultado de la suma y multiplos de 3
   Restricciones: respuesta solo puede ser 'S' o 'N'.
                  El numero debe ser entero positivo distinto de 0.

   PG
   INICIO
        LeerValidarEjecutar
        Mientras respuesta sea 'S'
            LeerValidarNumero
            HallarMultiplo
            MostrarSumaTotal
            LeerValidarEjecutar
        fin_Mientras
   FIN

   Nombre modulo: HallarMultiplo
     INCIO
            Mientras numero > 1
                si numero es divisible entre 3
                    PintarEnPantallaNumero
                    SumarNumero
                fin_si
                Actualizar contador
            fin_mientras
       FIN

Estudio de Bucles:
    LeerValidarEjecutar
        VCB: centinela
        Inicializacion: por lectura anticipada antes de la primera iteracion.
        Actualizacion: por lectura final, fisicamente al final de cada iteracion.
        Condicion de Salida: respuesta == 's' || respuesta == 'n'

     LeerValidarNumero
        VBC: centinela
        Inicializacion: por lectura anticipada antes de la primera iteracion.
        Actualizacion: por lectura final, fisicamente al final de cada iteracion
        Condicion de Salida: numero >= 1

     HallarMultiplos
        VCB: contador
        Inicializacion: por lectura anticipada, antes de la primera iteracion
        Actualizacion: fisicamente al final del bucle.
        Condicion de Salida: numero <= 1
*/

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int numero=0, total=0;
        char respuesta=' ';
        Scanner teclado = new Scanner(System.in);

        //LeerValidarEjecutar
        do{
            System.out.println("Quiere ejecutar?");
            respuesta = Character.toLowerCase(teclado.next().charAt(0));
        }while(respuesta !='s' && respuesta !='n');

        while(respuesta == 's'){
            //LeerValidarNumero
            do{
                System.out.println("Dime un numero");
                numero = teclado.nextInt();
            }while(numero < 1);

            //HallarMultiplos
            while(numero > 1){
                if(numero % 3 == 0){
                    System.out.println("Multiplo: " + numero);
                    total = total+numero;
                }
                numero--; //Actualizar contador
            }

            //MostrarSumaTotal
            System.out.println("La suma total es: " + total);
//hola
            //LeerValidarEjecutar
            do{
                System.out.println("Quiere ejecutar?");
                respuesta = Character.toLowerCase(teclado.next().charAt(0));
            }while(respuesta !='s' && respuesta !='n');
        }

    }
}