package com.company.Objetos;
/*
*  Propiedades basicas:
*       - zonaFumador: boolean consultable y modificable.
*       - numero: int consultable y modificable.
*       - ocupacion: bolean consultable y modificable.
*  Propiedades derivadas: no hay.
*  Propiedades añadidas:
*       - toString
*       - hashCode
*       - clone
*  Propiedades comunes: no hay.
*  Propiedades compartidas: ID
*  Restricciones:
*       - no hay
*
* Gets/Sets
* boolean getZonaFumador()
* void setZonaFumador(boolean fumador)
*
* int getNumero()
* void setNumero(int numero)
*
* boolean getOcupacion()
* void setOcupacion(boolean ocupacion)
* */
public class Asiento implements Cloneable{
    private boolean zonaFumador;
    private int numero;
    private boolean ocupacion;
    private int ID;

    private static int IDcontador = 0;
    //Constructor por defecto
    public Asiento(){
        ID = IDcontador;
        zonaFumador = false;
        numero = 1;
        ocupacion = false;
    }

    //Constructor con parametros
    public Asiento(boolean zonaFumador, int numero, boolean ocupacion){
        this.zonaFumador = zonaFumador;
        this.numero = numero;
        this.ocupacion = ocupacion;
        this.ID = IDcontador++;
    }

    //Construcctor de copia
    public Asiento(Asiento copia){
        this.zonaFumador = copia.getZonaFumador();
        this.numero = copia.getNumero();
        this.ocupacion = copia.getOcupacion();
    }

    //Gets Sets
    public boolean getZonaFumador(){
        return zonaFumador;
    }
    public void setZonaFumador(boolean zonaFumador){
        this.zonaFumador = zonaFumador;
    }

    public int getNumero(){
        return numero;
    }
    public void setNumero(int numero){
        this.numero = numero;
    }

    public boolean getOcupacion(){
        return ocupacion;
    }
    public void setOcupacion(boolean ocupacion){
        this.ocupacion = ocupacion;
    }

    public int getID(){
        return ID;
    }

    @Override
    public String toString(){
        return "Zona Fumador: "+this.getZonaFumador()+" Asiento: "+this.getNumero()+" Ocupado: "+this.getOcupacion() + " ID:" + this.getID();
    }

    @Override
    public int hashCode(){
        return this.getNumero()*2;
    }

    @Override
    public Asiento clone(){
        Asiento copia = null;

        try{
            copia = (Asiento)super.clone();
        }catch(CloneNotSupportedException error){
            System.out.println("Error en la copia");
        }
        return copia;
    }

}