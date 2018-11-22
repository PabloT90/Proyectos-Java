package com.company;
/* Descripcion: se presenta un menu cuyas opciones tratan sobre coordenadas y angulos.
   Entrada: real coorX, real coorY
   Salida: cuadrante al que pertenecen las coordenadas,si el punto pertenece a una circunferencia de radio 10, mensajes de comunicacion con el usuario, resultado coordenadas polares.
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
import javax.swing.text.Utilities;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int opcionMenu =0, cuadrante=0;
        double coorX=0, coorY=0;
        boolean resultadoCaso1=true;
        Scanner teclado = new Scanner(System.in);
        //PresentarMenu, leeryValidarOpcionMenu
        do{
            System.out.println("1- Pertenece a la recta?");
            System.out.println("2- A que cuadrante pertenece?");
            System.out.println("3- Calcular coordenadas polares");
            System.out.println("4- Salir");
            opcionMenu = teclado.nextInt();
        }while(opcionMenu < 1 || opcionMenu > 4);

        while(opcionMenu != 4) {//mientras opcionMenu != 4
            switch(opcionMenu) {//segun(opcionMenu)
                case 1://caso 1:
                    //PuntoPerteneceaCircunferencia*
                    //LeerCoordenadas
                    System.out.println("Dime la coordenada X");
                    coorX = teclado.nextDouble();
                    System.out.println("Dime la coordenada Y");
                    coorY = teclado.nextDouble();
                    //PerteneceACircunferencia*
                     resultadoCaso1 = Utilidades.PuntoPerteneceaCircunferencia(coorX,coorY);
                     //MostrarResultadoPertenceaCircunferencia
                     System.out.println("El resultado es: "+resultadoCaso1);
                break;//fin_caso 1

                case 2://caso 2:
                    //CuadrantePunto*
                    //LeerCoordenadas
                    System.out.println("Dime la coordenada X");
                    coorX = teclado.nextDouble();
                    System.out.println("Dime la coordenada Y");
                    coorY = teclado.nextDouble();

                    cuadrante = Utilidades.CudrantePunto(coorX, coorY);
                    System.out.println("El punto pertenece al: "+cuadrante +"º cuadrante.");
                break;//fin_caso 2

                case 3://caso 3:
                    //CalcularCoordenadasPolares*
                    //LeerCoordenadas
                    System.out.println("Dime la coordenada X");
                    coorX = teclado.nextDouble();
                    System.out.println("Dime la coordenada Y");
                    coorY = teclado.nextDouble();

                    Utilidades.CalcularCoordenadasPolares(coorX,coorY);
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