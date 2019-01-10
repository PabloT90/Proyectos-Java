package com.company.Objetos;
/*
Propiedades basicas: - nombreHabilidad String, consultable y modificable.
                     - Daño int, consultable y modificable.
                     - Sanacion int, consultable y modificable.
Propiedades derivadas: no hay (por el momento).
Propiedades añadidas: no hay.
Propiedades compartidas: no hay.

Get/Set
String getNombreHabilidad()
void setNombreHabilidad(String nombre)

int getDano()
void setDano(int danio)

int getSanacion()
void setSanacion(int sanacion)
*/
public class Habilidad {
    private String nombreHabilidad;
    private int danio;
    private int sanacion;

    //Constructores
    //Por defecto
    public Habilidad(){
        nombreHabilidad = new String();
        danio = 0;
        sanacion = 0;
    }

    //Con parametros
    public Habilidad(String nombre,int danio, int sanacion){
        this.nombreHabilidad = nombre;
        this.danio = danio;
        this.sanacion = sanacion;
    }

    //De copia
    public Habilidad(Habilidad skill){
        this.nombreHabilidad = skill.getNombreHabilidad();
        this.danio = skill.getDanio();
        this.sanacion = skill.getSanacion();
    }

    //Get/set
    public String getNombreHabilidad(){
        return nombreHabilidad;
    }
    public void setNombreHabilidad(String nombre){
        this.nombreHabilidad = nombre;
    }

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
        this.danio = sanacion;
    }

    @Override
    public String toString(){
        return "Nombre de la habilidad: "+ getNombreHabilidad()+" Danio: "+getDanio()+" Sanacion: "+getSanacion();
    }

}