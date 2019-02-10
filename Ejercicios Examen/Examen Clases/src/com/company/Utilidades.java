package com.company;
import com.company.Clases.Persona;
import com.company.Enum.Distrito;
import com.company.Excepciones.ExcPersona;

import java.util.Scanner;
public class Utilidades {
    public static String LeerNombre(Persona persona){
        String nombre="";
        Scanner teclado = new Scanner(System.in);
        System.out.println("Dime tu nombre:");
        nombre = teclado.nextLine();
        persona.setNombre(nombre);
        return nombre;
    }

    public static char LeerValidarEjecutar(){
        char ejecutar=' ';
        Scanner teclado = new Scanner(System.in);
        do{
            System.out.println("Quieres ejecutar? s/n");
            ejecutar = Character.toLowerCase(teclado.next().charAt(0));
        }while(ejecutar != 's' && ejecutar != 'n');

        return ejecutar;
    }

    public static int LeerValidarNumeroEncuestas(){
        int numEncuestas;
        Scanner teclado = new Scanner(System.in);
        do{
            System.out.println("Cuantas encuestas quieres hacer?");
            numEncuestas = teclado.nextInt();
        }while(numEncuestas < 1 || numEncuestas > 10);

        return numEncuestas;
    }

    public static void LeerValidarGenero(Persona persona){
        char genero=' ';
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("Dime tu genero:");
            genero = teclado.next().charAt(0);
        }while(genero != 'h' && genero != 'm');
        try {
            persona.setGenero(genero);
        }catch(ExcPersona error){
            System.out.println("Error al establecer el genero");
        }
    }

    public static void LeerValidarSalario(Persona persona) {
        int salario = 0;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("Dime tu salario:");
            salario = teclado.nextInt();
        } while (salario < 1000 || salario > 2000);
        try {
            persona.setSalario(salario);
        } catch (ExcPersona error) {
            System.out.println("Error al establecer el salario");
        }
    }

    public static String LeerValidarDistrito(){
        Scanner teclado = new Scanner(System.in);
        String distrito = " ";

        do{
            System.out.println("Indica el distrito (Norte, Sur, Este u Oeste.)");
            distrito = teclado.nextLine();
        }while((!distrito.equals("norte")) && (!distrito.equals("sur")) &&
                (!distrito.equals("este")) && (!distrito.equals("oeste")));

        return distrito;
    }
}