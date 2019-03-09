package com.company.Clases;
import com.company.Interface.IntPersona;
import java.util.Arrays;
/*
* Propiedades basicas:
*   - Nombre String, consultable.
*   - Calificaciones int[], consultable.
*
* Propiedades derivadas: no hay.
*
* Propiedades compartidas:
*   - ID int, sonsultable.
*
* Restricciones: no hay.
*
* metodos añadidos:
*   - CalcularNota
*
* getters y setters
* String getNombre()
*
* int[] getCalificaciones()
*
* int getID()
*
* */
public class Persona implements Cloneable, Comparable<Persona>, IntPersona {
    private String nombre;
    private int[] calificaciones;
    private int ID;

    private static int contadorID=1000;

    //Constructor por defecto
    public Persona(){
        nombre = new String();
        calificaciones = new int[10];
        ID = contadorID++;
    }
    //Con parametros
    public Persona(String nombre, int[] calificaciones){
        this.nombre = nombre;
        this.calificaciones = calificaciones;
        this.ID = contadorID++;
    }
    //De copia
    public Persona(Persona copia){
        this.nombre = copia.getNombre();
        this.calificaciones = copia.getCalificaciones();
        this.ID = copia.getID();
    }

    //get and set
    public String getNombre() {
        return nombre;
    }

    public int[] getCalificaciones() {
        return calificaciones;
    }

    public int getID() {
        return ID;
    }

    @Override
    public int hashCode() {
        return nombre.hashCode()+this.getID();
    }

    //Criterio de igualdad: 2 objetos son iguales si sus ID son iguales.
    @Override
    public boolean equals(Object obj) {
        boolean ret = false;

        if(this == obj){
            ret = true;
        }else{
            if(this != null && obj instanceof Persona){
                Persona otro = (Persona)obj;
                if(this.getID() == otro.getID()){
                    ret = true;
                }
            }
        }

        return ret;
    }

    @Override
    public Persona clone(){
        Persona copia = null;

        try{
            copia = (Persona)super.clone();
        }catch(CloneNotSupportedException error){
            System.out.println("Clonacion no realizada");
        }

        return copia;
    }

    /*
    * Criterio de comparacion:
    * - Devuelve 0 si 2 objetos tienen el mismo ID.
    * - Devuelve 1 si el objeto recibido por parametro tiene menor ID.
    * - Devuelve -1 si el objeto recibido por parametro tiene mayor ID.
    * */
    public int compareTo(Persona otro){
        int ret = 0;

        if(this.getID() < otro.getID()){
            ret = 1;
        }
        else if(this.getID() > otro.getID()){
            ret = -1;
        }

        return ret;
    }

    @Override
    public String toString() {
        return "Nombre: "+getNombre()+ " |  | ID: "+ getID()+ " |  |Calificaciones: "+ CalcularNota();//Arrays.toString(calificaciones);
    }

    public int CalcularNota(){
        int ret = 0;

        for(int i =0; i < calificaciones.length; i++){
            if(calificaciones[i] == 1)
                ret++;
        }

        return ret;
    }
}