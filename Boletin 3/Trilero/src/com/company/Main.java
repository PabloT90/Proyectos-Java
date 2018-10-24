/*Descripcion: simulara el juego de un trilero.
Entradas: respuesta, opcion cubilete.
Salidas: mensajes al usuario, cubiletes, cubilete con la bolita.
Restricciones: la respuesta solo puede ser 's' o 'n'.
               la opcion del cubilete sera entre 1 y 3.
***********************
PG
INICIO
    LeerValidarEjecutar
    mientras quiera ejecutar
        GenerarNumeroAleatorio
        MostrarCubiletes
        LeerValidarOpcioncubilete
        MostrarCubileteDestapado
        MostrarGanador
        LeerValidarEjecutar
    fin_mientras
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
VCB: centinela
Inicializacion: Lectura anticipada antes de la primera iteracion.
Actualizacion: Lectura final, fisicamente al final del bucle.
Condicion Salida: cubilete >= 0 && cubilete =< 3
*********************
* */
package com.company;
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        char respuesta;
        int cubilete = 0, numAleatorio=0;
        Scanner teclado = new Scanner(System.in);
        Random aleatorio = new Random();

        //LeerValidarEjecutar
        do{
            System.out.println("Quieres ejecutar?");
            respuesta = Character.toLowerCase(teclado.next().charAt(0));
        }while(respuesta != 's' && respuesta != 'n');

        while(respuesta == 's') {//mientras quiera ejecutar
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
            }else System.out.println("Has perdido!!");
           
            //LeerValidarEjecutar
            do{
                System.out.println("Quieres ejecutar?");
                respuesta = Character.toLowerCase(teclado.next().charAt(0));
            }while(respuesta != 's' && respuesta != 'n');
        }//fin_mientras

    }
}