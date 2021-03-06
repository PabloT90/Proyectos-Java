package com.company;
/* Descripcion: dada una altura pintara el triangulo de tartaglia/pascal.

Entrada: caracter ejecutar, entero altura.
Salida: mensajes de comunicacion con el usuario, piramide de Pascal/Tartaglia.
Restricciones: ejecutar debe ser 's' o 'n'.
               altura debe ser mayor o igual que 0.
* PG
* LeerValidarEjecutar
* Mietras quiera ejecutar
*   LeerValidarAlturaTriangulo
*   PintarTriangulo*
*   LeerValidarEjecutar
* fin_mientras
* */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
	    Scanner teclado = new Scanner(System.in);
	    int altura;
	    char ejecutar;

        //LeerValidarEjecutar
	    do{
	        System.out.println("Quieres ejecutar?");
	        ejecutar = teclado.next().charAt(0);
        }while(ejecutar != 's' && ejecutar != 'n');

	    while(ejecutar != 'n'){//mientras quiera ejecutar
	        //LeerValidarEjecutar
            do{
                System.out.println("Dime la altura del triangulo.");
                altura = teclado.nextInt();
            }while(altura < 0);

            //PintarTriangulo*
            //Resguardo.TrianguloPascal(altura);
            Utilidad.TrianguloPascal(altura);

            //LeerValidarEjecutar
            do{
                System.out.println("Quieres ejecutar?");
                ejecutar = teclado.next().charAt(0);
            }while(ejecutar != 's' && ejecutar != 'n');
        }//Fin_mientras

    }
}