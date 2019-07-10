package com.company.Clases;

import java.io.Serializable;

/*
* Propiedades basicas:
*   - ID: int consultable.
*   - letalidad: int consultable y modificable (mientras mayor sea este valor mayor serán sus posibilidades de matar a su adversario.)
*   - nombre: String consultable.
*   - estado: boolean consultable y modificable (true = vivo | false = muerto)
* Propiedades derivadas: no hay.
* Propiedades compartidas: no hay.
* Metodos añadidos: aun no.
*
**/
public class Jugador implements Serializable {
    private int ID;
    private String nombre;
    private int letalidad;
    private boolean estado;

    //Constructores:
    //Por defecto
    public Jugador(){
        ID = 0;
        nombre = "No name";
        letalidad = 0;
        estado = true;
    }

    //Con parametros
    public Jugador(int ID, String nombre, int letalidad, boolean estado){
        this.ID = ID;
        this.nombre = nombre;
        this.letalidad = letalidad;
        this.estado = estado;
    }

    //De copia
    public Jugador(Jugador jugador){
        this.ID = jugador.getID();
        this.nombre = jugador.getNombre();
        this.letalidad = jugador.getLetalidad();
        this.estado = jugador.getEstado();
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

    public boolean getEstado(){
        return estado;
    }
    public void setEstado(boolean estado){
        this.estado = estado;
    }

    @Override
    public String toString(){
        return ID+','+nombre+','+letalidad+','+estado;
    }

    public String toStringBonito(){
        return "ID: "+ID+"  |Nombre: "+nombre+"  |Letalidad: "+letalidad;
    }

    //HashCode en funcion del nombre y su ID.
    @Override
    public int hashCode(){
        return nombre.hashCode()+ID;
    }

    //No añado el compareTo ni el equals porque no me hacen falta.
}
