package com.company;
/* Descripcion: se presenta un menu cuyas opciones tratan sobre coordenadas y angulos.
   Entrada: entero coorX, entero coorY
   Salida: logico pertenece, entero cuadrante, mensajes de comunicacion con el usuario, resultado coordenadas polares.
   Restricciones: ninguna.

PG
INICIO
    PresentarMenu, leeryValidarOpcionMenu
    mientras opcionMenu != 4
        segun(opcionMenu)
            caso 1:
                PuntoPerteneceaCircunferencia*
            fin_caso 1

            caso 2:
                CuadrantePunto*
            fin_caso 2

            caso 3:
                CalcularCoordenadasPolares*
            fin_caso 3
        fin_segun
        PresentarMenu, leeryValidarOpcionMenu
    fin_mientras
FIN
* */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int opcionMenu =0;
        //PresentarMenu, leeryValidarOpcionMenu
        do{
            System.out.println("1- Pertenece a la recta?");
            System.out.println("2- A que cuadrante pertenece?");
            System.out.println("3- Calcular coordenadas polares");
            System.out.println("4- Salir");
            opcionMenu = teclado.nextInt();
        }while(opcionMenu< 1 || opcionMenu > 4);

        while(opcionMeni != 4) {//mientras opcionMenu != 4
            switch(opcionMenu) {//segun(opcionMenu)
                case 1://caso 1:
                    //PuntoPerteneceaCircunferencia*
                break;//fin_caso 1

                case 2://caso 2:
                    //CuadrantePunto*
                break;//fin_caso 2

                case 3://caso 3:
                    //CalcularCoordenadasPolares*
                break;//fin_caso 3
            }//fin_segun
            //PresentarMenu, leeryValidarOpcionMenu
            do{
                System.out.println("1- Pertenece a la recta?");
                System.out.println("2- A que cuadrante pertenece?");
                System.out.println("3- Calcular coordenadas polares");
                System.out.println("4- Salir");
                opcionMenu = teclado.nextInt();
            }while(opcionMenu< 1 || opcionMenu > 4);
        }// fin_mientras

    }
}