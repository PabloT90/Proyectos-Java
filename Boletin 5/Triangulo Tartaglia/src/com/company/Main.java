package com.company;
/* Descripcion: dada una altura pintara el triangulo de tartaglia/pascal.
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
	    int altura=0;
	    char ejecutar=' ';

	    do{
	        System.out.println("Quieres ejecutar?");
	        ejecutar = teclado.next().charAt(0);
        }while(ejecutar != 's' && ejecutar != 'n');

	    while(ejecutar != 'n'){
            do{
                System.out.println("Dime la altura del triangulo");
                altura = teclado.nextInt();
            }while(altura < 0);

            //PintarTriangulo
            Utilidad.TrianguloPascal(altura);

            do{
                System.out.println("Quieres ejecutar?");
                ejecutar = teclado.next().charAt(0);
            }while(ejecutar != 's' && ejecutar != 'n');
        }

    }
}