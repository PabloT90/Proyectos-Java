package com.company;
public class Main {
    public static void main(String[] args) {
        Racional uno = new Racional(7,2);
        Racional dos = new Racional(4,2);
        Racional resultado;

        resultado = funcionalidades.multiplicarRacionales(uno,dos);
        System.out.println(resultado);

        resultado = funcionalidades.dividirRacionales(uno,dos);
        System.out.println(resultado);
    }
}
