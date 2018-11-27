package com.company;

public class Pruebas {
    public static void main(String[]args){
        System.out.println(Utilidades.compararFechas(1,1,1999,1,2,1999));
        System.out.println(Utilidades.compararFechas(2,1,1999,1,1,1999));
        System.out.println(Utilidades.compararFechas(1,1,2000,1,2,1999));
        System.out.println(Utilidades.compararFechas(1,1,1999,2,2,1999));
        System.out.println(Utilidades.compararFechas(1,1,1999,1,2,1999));
        System.out.println(Utilidades.compararFechas(15,6,1999,12,2,2003));
        System.out.println(Utilidades.compararFechas(15,2,1999,15,2,1999));
    }
}
