package com.company;
public class Main {
    public static void main(String[] args) {
        Racional uno = new Racional(7,2);
        Racional dos = new Racional(4,2);

        uno = uno.dividirRacionales(dos);
        System.out.println(uno);
        //System.out.println(dos);
    }
}