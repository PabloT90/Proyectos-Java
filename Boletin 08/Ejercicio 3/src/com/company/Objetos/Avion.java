package com.company.Objetos;
/*
 *  Propiedades basicas:
 *       - asiento[] avion consutable y modificable.
 *  Propiedades derivadas: no hay.
 *  Propiedades añadidas:
 *      - MostrarAvion
 *  Propiedades comunes: no hay.
 *  Restricciones:
 *
 * Gets/Sets
 * Asiento[] getAvion()
 * void setAvion(Asiento[] avion)
 * */
public class Avion {
    private Asiento[] avion;

    //Constructor por defecto
    public Avion(){
        avion = new Asiento[20];

        for(int i = 0; i < avion.length; i++){
            //Llamo al constructor por defecto de Asiento para que no tengan el valor null
            avion[i] = new Asiento();
        }
    }
    //constructor con parametros
    public Avion(Asiento[] avion){
        this.avion = avion;
    }
    //Constructor de copia
    public Avion(Avion copia){
        this.avion = copia.getAvion();
    }

    //Get y set
    public Asiento[] getAvion(){
        return avion;
    }
    public void setAvion(Asiento[] avion){
        this.avion = avion;
    }

    public void MostrarAvion(){
        for(int i = 0; i < avion.length; i++){
            if(avion[i].getOcupacion())
                System.out.println("[1]"); //Si esta ocupado muestra 1.
            else
                System.out.println("[0]"); //Si no esta ocupado muestra 0.
        }
    }



}