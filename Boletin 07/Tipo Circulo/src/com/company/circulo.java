package com.company;

import java.util.Objects;

/*
Propiedades basicas: - centro Punto, consultable y modificable.
                     - radio double, consultable y modificable.

Propiedades derivadas: - perimetro double, consultable.
                       - area double, consultable.

Propiedades compartidas: pi, double consultable. Es una constante.

Propiedades añadidas: compareTo, clone, Equals, HashCode.  (aun no las voy a implementar)

Restricciones: el radio no puede ser negativo. Se encarga el programa principal.

getters y setters
int getRadio()
void setRadio(double radio)

int getPerimetro()
int getArea()
static final int getPI()

Patron Delegacion Punto
int getCentroCoorX()
void setCentroCoorX(int coorX)

int getCentroCoorY()
void setCentroCoorY(int coorY)

 */
public class circulo {
    //Aqui no se ponen las derivadas
    private double radio;
    private Punto centro = new Punto();
    private final static double pi = 3.14;

    //Constructores
    //Por defecto
    public circulo(){
        radio = 0;
        centro = new Punto();
    }

    //Con parametros
    public circulo(double radio, int coorX, int coorY){
        this.radio = radio;
        this.centro = new Punto(coorX, coorY);
    }

    //De copia
    public circulo(circulo circulo){
        this.radio = circulo.getRadio();
        this.centro = circulo.centro;
    }

    //Getters y setters
    public double getRadio(){
        return radio;
    }
    public void setRadio(double radio){
        this.radio = radio;
    }

    public double getPerimetro(){
        return 2*pi*radio;
    }

    public double getArea(){
        return radio*radio*pi;
    }

    public static double getPI(){
        return pi;
    }

    //Patron delegacion
    public int getCentroCoorX(){
        return centro.getCoorX();
    }
    public void setCentroCoorX(int coorX){
        centro.setCoorX(coorX);
    }

    public int getCentroCoorY(){
        return centro.getCoorY();
    }
    public void setCentroCoorY(int coorY){
        centro.setCoorX(coorY);
    }
}