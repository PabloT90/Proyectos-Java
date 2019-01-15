package com.company.Objetos;
/*
Propiedades basicas: - Danio int, consultable y modificable.
                     - Sanacion int, consultable y modificable.
Propiedades derivadas: no hay (por el momento).
Propiedades añadidas: no hay.
Propiedades compartidas: no hay.
Restricciones: - El daño tiene que ser mayor o igual a 0.
               - La sanacion tiene que ser mayor o igual a 0.

Get/Set
int getDanio()
void setDanio(int danio)

int getSanacion()
void setSanacion(int sanacion)
*/
import com.company.Excepciones;
public class Habilidad implements Cloneable, Comparable<Habilidad>{
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
    public void setDanio(int danio) throws Excepciones{
        if(danio >= 0)
            this.danio = danio;
        else throw new Excepciones("Error en la sanacion");
    }

    public int getSanacion(){
        return sanacion;
    }
    public void setSanacion(int sanacion)throws Excepciones{
        if(sanacion >=0)
            this.sanacion = sanacion;
        else throw new Excepciones("Error en la sanacion");
    }

    @Override
    public String toString(){
        return "Danio: "+getDanio()+" Sanacion: "+getSanacion();
    }

    /*
    * Son iguales si el daño y la sanacion son iguales
    * */
    @Override
    public boolean equals(Object obj){
        boolean ret = false;

        if(this == obj){
            ret = true;
        }else{
            if(obj != null && obj instanceof Habilidad){
                Habilidad otra = (Habilidad) obj;

                if(this.getDanio() == otra.getDanio() &&
                this.getSanacion() == otra.getSanacion()){
                    ret = true;
                }
            }
        }
        return ret;
    }

    @Override
    public Habilidad clone(){
        Habilidad copia = null;

        try{
            copia = (Habilidad)super.clone();
        }catch(CloneNotSupportedException error){
            System.out.println("Error en la copia");
        }
        return copia;
    }

    @Override
    public int hashCode(){
        return this.getDanio()+this.getSanacion()+2;
    }

    /* Criterio de igualdad:
        si la sanacion y el daño del primero son mayores que el segundo devuelve 1
        Si son menores devuelve -1
        Si son iguales devuelve 0.
    * */
    public int compareTo(Habilidad otra){
        int ret = -1;

        if(this.getSanacion() > otra.getSanacion() && this.getDanio() > this.getDanio()) ret = 1;
        else if(this.getSanacion() == otra.getSanacion() && this.getDanio() == this.getDanio()) ret = 0;

        return ret;
    }

}