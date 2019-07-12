package com.company.Clases;

import java.io.Serializable;

/*
* Propiedades basicas:
*   - ID: int consultable.
*   - letalidad: int consultable y modificable (mientras mayor sea este valor mayor serán sus posibilidades de matar a su adversario.)
*   - nombre: String consultable.
*   - victorias: int consultable y modificable.
* Propiedades derivadas: no hay.
* Propiedades compartidas: no hay.
* Metodos añadidos: aun no.
*
**/
public class Jugador implements Serializable {
    private int ID;
    private String nombre;
    private int letalidad;
    private int victorias;

    //Constructores:
    //Por defecto
    public Jugador(){
        ID = 0;
        nombre = "No name";
        letalidad = 0;
        victorias = 0;
    }

    //Con parametros
    public Jugador(int ID, String nombre, int letalidad, int victorias){
        this.ID = ID;
        this.nombre = nombre;
        this.letalidad = letalidad;
        this.victorias = victorias;
    }

    //De copia
    public Jugador(Jugador jugador){
        this.ID = jugador.getID();
        this.nombre = jugador.getNombre();
        this.letalidad = jugador.getLetalidad();
        this.victorias = jugador.getVictorias();
    }

    //Getters and setters
    public int getID(){
        return ID;
    }

    public String getNombre(){
        return nombre;
    }

    public int getLetalidad(){
        return letalidad;
    }
    public void setLetalidad(int letalidad){
        this.letalidad = letalidad;
    }

    public int getVictorias(){
        return victorias;
    }
    public void setEstado(boolean estado){
        this.victorias = victorias;
    }

    @Override
    public String toString(){
        return ID+','+nombre+','+letalidad+','+victorias;
    }

    public String toStringBonito(){
        return "ID: "+ID+"  |Nombre: "+nombre+"  |Letalidad: "+letalidad+ "  |Victorias: "+victorias;
    }

    //HashCode en funcion del nombre y su ID.
    @Override
    public int hashCode(){
        return nombre.hashCode()+ID;
    }

    //No añado el compareTo ni el equals porque no me hacen falta.
}
