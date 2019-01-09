package com.company;
/*
* Propiedades basicas: - coorX int, consultable y modificable.
*                      - coorY int, consultable y modificable.
* Propiedades derivadas: nada.
* Propiedades añadidas: nada.
* Propiedades compartidas: nada.
* Restricciones: no hay.
* get y set
*
* int getCoorX()
* void setCoorX(int coorX)
*
* int getCoorY()
* int setCoorY(int coorY)
* */
public class Punto {
    private double coorX;
    private double coorY;

    //CONSTRUCTORES
    //Por defecto
    public Punto(){
        coorX=0;
        coorY=0;
    }
}
