package com.company.Enums;

public enum EnumJugador {
    PABLO("Pablo",20), NESDE("Nesde",26), YERAY("Yeray",11), RAFAEL("Rafael",24);

    private String nombre;
    private int edad;

    private EnumJugador(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }
     public String getNombre(){
        return nombre;
     }
     public int getEdad(){
        return edad;
     }

}