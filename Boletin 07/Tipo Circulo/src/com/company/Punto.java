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
    private int coorX;
    private int coorY;

    //CONSTRUCTORES
    //Por defecto
    public Punto(){
        coorX=0;
        coorY=0;
    }

    //Con parametros
    public Punto(int coorX, int coorY){
        this.coorX = coorX;
        this.coorY = coorY;
    }

    //De copia
    public Punto(Punto punto){
        this.coorX = punto.getCoorX();
        this.coorY = punto.getCoorY();
    }

    //Getters y setters
    public int getCoorX(){
        return coorX;
    }
    public void setCoorX(int coorX){
        this.coorX = coorX;
    }

    public int getCoorY(){
        return coorY;
    }
    public void setCoorY(int coorY){
        this.coorY = coorY;
    }

    //ToString
    @Override
    public String toString(){
        return "Coordenada X: "+getCoorX()+" Coordenada Y "+getCoorY();
    }
}