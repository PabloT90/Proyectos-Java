package com.company.Objetos;
import com.company.Interface.intCancion;
/*
* Propiedades basicas:
*   - String nombre consultable y modificable.
*   - int numVotos consultable y modificable.
* Propiedades derivadas: no hay.
* Propiedades añadidas: no hay.
* Propiedades compartidas: no hay.
*
* get/set
* String getNombre()
* void setNombre(String nombre)
*
* int getNumVotos()
* void setNumVotos(int votos)
* */
public class Cancion implements Comparable<Cancion>, Cloneable, intCancion {
    private String nombre;
    private int numVotos;

    //Constructor por defecto
    public Cancion(){
        nombre = new String();
        numVotos = 0;
    }
    //Constructor con parametros
    public Cancion(String nombre, int numVotos){
        this.nombre = nombre;
        this.numVotos = numVotos;
    }
    //Constructor de copia
    public Cancion(Cancion otro){
        this.nombre = otro.getNombre();
        this.numVotos = otro.getNumVotos();
    }

    //GETTERS AND SETTERS
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumVotos() {
        return numVotos;
    }
    public void setNumVotos(int numVotos) {
        this.numVotos = numVotos;
    }

    @Override
    public int hashCode() {
        return nombre.hashCode() *numVotos;
    }

    @Override
    public boolean equals(Object obj) {
        boolean ret = false;
        if(this == obj)
            ret = true;
        else if(obj != null && obj instanceof Cancion){
            Cancion otro = (Cancion)obj;
            if(this.getNumVotos() == otro.getNumVotos()){
                ret = true;
            }
        }
        return ret;
    }

    @Override
    protected Cancion clone(){
        Cancion copia = null;
        try{
            copia = (Cancion)super.clone();
        }catch(CloneNotSupportedException error){
            System.out.println("Error en la copia");
        }
        return copia;
    }

    @Override
    public String toString() {
        return "Nombre: "+ getNombre()+" Votos: "+ getNumVotos();
    }

    /*Criterio de comparacion:
     * Devuelve 0 si el numero de votos es igual.
     * Devuelve 1 si el numero de votos es mayor que el del 2.
     * Devuelve -1 si el numero de votos en menor que el del 2.
     * */
    public int compareTo(Cancion otro){
        int ret = -1;

        if(this.getNumVotos() > otro.getNumVotos()){
            ret = 1;
        }else if(this.getNumVotos() == otro.getNumVotos()){
            ret = 0;
        }
        return ret;
    }
}