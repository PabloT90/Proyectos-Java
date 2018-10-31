/*Descripcion: simulara el juego de un trilero. Desde el principio el participante cuenta con un dinero base de 100 euros.
Entradas: respuesta, opcion cubilete, apuesta.
Salidas: mensajes al usuario, cubiletes, cubilete con la bolita.
Restricciones: la respuesta solo puede ser 's' o 'n'.
               la opcion del cubilete sera entre 1 y 3.
               no puede apostar mas de lo que tiene, ni puede ser negativa la apuesta.
***********************
PG
INICIO
    LeerValidarEjecutar
    mientras quiera ejecutar
        LeerValidarApuesta
        JugarTrilero
        MostrarGanador
        MostrarDineroTotal
        LeerValidarEjecutar
    fin_mientras
FIN

PG 2 MostrarGanador
INICIO
si numAleatorio == cubilete
    MostrarMensajeGanador
    ActualizarDineroTotal
sino
    MostrarMensajePerdedor
    ActualizarDineroTotal
FIN

PG JugarTrilero
INICIO
    GenerarNumeroAleatorio
    MostrarCubiletes
    LeerValidarOpcioncubilete
    MostrarCubileteDestapado
FIN

***********************
***********************
Estudio de Bucles

LeerValidarEjecutar
VCB: centinela.
Inicializacion: Lectura anticipada antes de la primera iteracion.
Actualizacion: Lectura final, fisicamente al final del bucle.
Condicion Salida: respuesta == 's' || respuesta == 'n'
____________________
Mientras quiera ejecutar
VCB: centinela.
Inicializacion: Lectura anticipada antes de la primera iteracion.
Actualizacion: Lectura final, fisicamente al final del bucle.
Condicion Salida: respuesta == 'n'
____________________
LeerValidarOpcionCubilete
VCB: centinela.
Inicializacion: Lectura anticipada antes de la primera iteracion.
Actualizacion: Lectura final, fisicamente al final del bucle.
Condicion Salida: cubilete >= 0 && cubilete =< 3
____________________
LeerValidarApuesta
VCB: centinela.
Inicializacion: Lectura anticipada antes de la primera iteracion.
Actualizacion: Lectura final, fisicamente al final del bucle.
Condicion salida: (apuesta >= 0 && dineroTotal >= apuesta)
*********************
* */
package com.company;
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        char respuesta;
        int cubilete, numAleatorio, apuesta, dineroTotal=100;
        Scanner teclado = new Scanner(System.in);
        Random aleatorio = new Random();

        //LeerValidarEjecutar
        do{
            System.out.println("Quieres ejecutar?");
            respuesta = Character.toLowerCase(teclado.next().charAt(0));
        }while(respuesta != 's' && respuesta != 'n');

        while(respuesta == 's') {//mientras quiera ejecutar
            //LeerValidadApuesta
            do{
                System.out.println("Tienes "+dineroTotal+", cuanto quieres apostar?");
                apuesta = teclado.nextInt();
            }while(apuesta < 0 || dineroTotal < apuesta); //Asi controlo cuando quiera volver a ejecutar que no mete una apuesta mayor del dinero disponible.

            //GenerarNumeroAleatorio
            numAleatorio = aleatorio.nextInt(3)+1;

            //MostrarCubiletes
            System.out.println("|----------|   |----------|   |----------|");
            System.out.println("|          |   |          |   |          |");
            System.out.println("|          |   |          |   |          |");
            System.out.println("|          |   |          |   |          |");
            System.out.println("|          |   |          |   |          |");

            //LeerValidarOpcioncubilete
            do{
                System.out.println("En que cubilete esta la bolita?");
                cubilete = teclado.nextInt();
            }while(cubilete < 1 || cubilete > 3);

            //MostrarCubileteDestapado
            if(numAleatorio == 1 ){
                System.out.println("|----------|");
                System.out.println("|          |   |----------|   |----------|");
                System.out.println("|          |   |          |   |          |");
                System.out.println("|          |   |          |   |          |");
                System.out.println("|          |   |          |   |          |");
                System.out.println("   ******      |          |   |          |");
                System.out.println("   ******      |          |   |          |");
            }else if(numAleatorio == 2){
                System.out.println("               |----------|");
                System.out.println("|----------|   |          |   |----------|");
                System.out.println("|          |   |          |   |          |");
                System.out.println("|          |   |          |   |          |");
                System.out.println("|          |   |          |   |          |");
                System.out.println("|          |      ******      |          |");
                System.out.println("|          |      ******      |          |");
            }else{
                System.out.println("                              |----------|");
                System.out.println("|----------|   |----------|   |          |");
                System.out.println("|          |   |          |   |          |");
                System.out.println("|          |   |          |   |          |");
                System.out.println("|          |   |          |   |          |");
                System.out.println("|          |   |          |      ******   ");
                System.out.println("|          |   |          |      ******   ");
            }

            //MostrarGanador
            if(numAleatorio == cubilete){
                System.out.println("Has ganado!!");
                dineroTotal = dineroTotal + apuesta;
            }else{
                System.out.println("Has perdido!!");
                dineroTotal = dineroTotal - apuesta;
            }

            //MostrarDineroTotal
            System.out.println("Tienes "+dineroTotal+" euros");

            //LeerValidarEjecutar
            do{
                System.out.println("Quieres ejecutar?");
                respuesta = Character.toLowerCase(teclado.next().charAt(0));
            }while(respuesta != 's' && respuesta != 'n');
        }//fin_mientras

    }
}