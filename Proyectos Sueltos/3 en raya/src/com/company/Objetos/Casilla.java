package com.company.Objetos;
/*
Propiedades basicas:
    - estado int consultable y modificable.
Propiedades derivadas: no hay.
Propiedades añadidas:
    - clone
    - equals
Propiedades comunes: no hay.
Restricciones: no hay.

Gets/sets
boolean getEstado()
void setEstado(int estado)
*/
public class Casilla implements Cloneable{
    private int estado;

    //Constructores
    //Por defecto
    public Casilla(){
        estado = 0; //0 es vacio
    }
    //Con parametros
    public Casilla(int estado){
        this.estado = estado;
    }
    //De copia
    public Casilla(Casilla casilla){
        this.estado = casilla.getEstado();
    }

    //Gets/sets
    public int getEstado(){
        return estado;
    }
    public void setEstado(int estado){
        this.estado = estado;
    }

    @Override
    public String toString(){
        return "Estado: "+getEstado();
    }

    @Override
    public Casilla clone(){
        Casilla copia = null;
        try{
            copia = (Casilla)super.clone();
        }catch(CloneNotSupportedException error){
            System.out.println("Error al clonar");
        }
        return copia;
    }

    //Dos casillas son iguales si sus atributos son iguales.
    @Override
    public boolean equals(Object obj){
        boolean ret = false;

        if(this == obj){
            ret = true;
        }else{
            if(obj != null && obj instanceof Casilla){
                Casilla otra = (Casilla)obj;

                if(this.estado == otra.estado){
                        ret = true;
                }
            }
        }
        return ret;
    }

}