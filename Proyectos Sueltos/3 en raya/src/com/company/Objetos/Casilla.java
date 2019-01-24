package com.company.Objetos;
/*
Propiedades basicas:
    - vacia boolean consultable y modificable.
    - cara boolean consultable y modificable.
    - cruz boolean consultable y modificable.
Propiedades derivadas: no hay.
Propiedades añadidas:
    - clone
    - equals
Propiedades comunes: no hay.
Restricciones: no hay.

Gets/sets
boolean getVacia()
void setVacia(boolean vacia)

boolean getCara()
void setCara(boolean cara)

boolean getCruz()
void setCruz(boolean cruz)
*/
public class Casilla implements Cloneable{
    private boolean vacia;
    private boolean cara;
    private boolean cruz;

    //Constructores
    //Por defecto
    public Casilla(){
        vacia = true;
        cruz = false;
        cara = false;
    }
    //Con parametros
    public Casilla(boolean vacia, boolean cruz, boolean cara){
        this.vacia = vacia;
        this.cruz = cruz;
        this.cara = cara;
    }
    //De copia
    public Casilla(Casilla casilla){
        this.vacia = casilla.getVacia();
        this.cara = casilla.getCara();
        this.cruz = casilla.getCruz();
    }

    //Gets/sets
    public boolean getVacia(){
        return vacia;
    }
    public void setVacia(boolean vacia){
        this.vacia = vacia;
    }

    public boolean getCara(){
        return cara;
    }
    public void setCara(boolean cara){
        this.cara = cara;
    }

    public boolean getCruz(){
        return cruz;
    }
    public void setCruz(boolean cruz){
        this.cruz = cruz;
    }

    @Override
    public String toString(){
        return "Vacia: "+getVacia()+" Cara: "+getCara()+" Cruz: "+getCruz();
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

                if(this.getVacia() == otra.getVacia() &&
                    this.getCara() == otra.getCara() &&
                    this.getCruz() == otra.getCruz()){
                        ret = true;
                }
            }
        }
        return ret;
    }

}