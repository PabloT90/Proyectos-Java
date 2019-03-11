package com.company.Tests;
import com.company.Clases.Persona;
public class TestPersona {
    public static void main(String[] args) {
        //Constructor por defecto
        Persona p1 = new Persona();
        System.out.println("Socio 1: " + p1.toString());
        Persona p2 = new Persona();
        System.out.println("Socio 3: " + p2.toString());
        Persona p3 = new Persona();
        System.out.println("Socio 4: " + p3.toString());

        //Constructor con parametros.
        int[] calificaciones = {1,1,1,1,1,1,1,1,1,1};
        Persona p4 = new Persona("Pablo", calificaciones);
        System.out.println(p4.toString());

        int[] calificaciones2 = {1,1,0,1,1,0,1,1,0,1};
        Persona p5 = new Persona("Pablo", calificaciones2);
        System.out.println(p5.toString());

        //Constructor de copia
        p1 = p3;
        System.out.println(p1.toString());
        System.out.println(p3.toString());


        //Gets y sets
        System.out.println("Al hacer uso del metodo toString arriba (en el que para obtener los valores uso los metodos set y get de la clase) No veo necesario volver a probarlos");
        //Al hacer uso del metodo toString arriba (en el que para obtener los valores uso los metodos set de la clase)
        //No veo necesario volver a probarlos.

        //hashCode
        System.out.println("hashCode: " + p2.hashCode());

        //equals
        System.out.println("Equals socio 1 con el 2: " + p1.equals(p4));
        System.out.println("Equals socio 1 con el 3: " + p1.equals(p3));

        //CompareTo
        System.out.println("compareTo socio 1 con el 2: " + p1.compareTo(p4));
        System.out.println("compareTo socio 1 con el 3: " + p1.compareTo(p3));

        //Clone
        System.out.println("Prueba clone: ");
        System.out.println("s1.toString() --> " + p1.toString());
        System.out.println("s3.toString() --> " + p3.toString());

        System.out.println("s3 = s1.clone() --> Realizamos la clonacion");
        p3 = p1.clone();
        System.out.println("s1.equals(s3) --> " + p1.equals(p3));

        //CalcularNota
        System.out.println("Calcular Nota:");
        System.out.println("Nota p4: " + p4.CalcularNota() + "  |  Nota p5: " + p5.CalcularNota());
    }
}