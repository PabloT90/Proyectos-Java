package com.company.Objetos;
/*
Propiedades basicas: - Danio int, consultable y modificable.
                     - Sanacion int, consultable y modificable.
Propiedades derivadas: no hay (por el momento).
Propiedades añadidas: no hay.
Propiedades compartidas: no hay.

Get/Set
int getDanio()
void setDanio(int danio)

int getSanacion()
void setSanacion(int sanacion)
*/
public class Habilidad {
    private int danio;
    private int sanacion;

    //Constructores
    //Por defecto
    public Habilidad(){
        danio = 0;
        sanacion = 0;
    }

    //Con parametros
    public Habilidad(int danio, int sanacion){
        this.danio = danio;
        this.sanacion = sanacion;
    }

    //De copia
    public Habilidad(Habilidad skill){
        this.danio = skill.getDanio();
        this.sanacion = skill.getSanacion();
    }

    //Get/set
    public int getDanio(){
        return danio;
    }
    public void setDanio(int danio){
        this.danio = danio;
    }

    public int getSanacion(){
        return sanacion;
    }
    public void setSanacion(int sanacion){
        this.sanacion = sanacion;
    }

    @Override
    public String toString(){
        return "Danio: "+getDanio()+" Sanacion: "+getSanacion();
    }

}