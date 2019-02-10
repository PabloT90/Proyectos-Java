package com.company.Clases;

import com.company.Enum.Distrito;
import com.company.Excepciones.ExcPersona;
import com.company.Interfaces.IntEncuesta;
/*
 * Propiedades basicas:
 *   - ID int consultable.
 *   - Distrito EnumDistrito consultable y modificable.
 *   - Persona persona consultable y modificable.
 * Propiedades derivadas: no hay.
 * Propiedades compartidas:
 *   - IDautogenerado int.
 *   - FactorRelevancia double.
 * Propiedades Añadidas:
 * Restricciones: no hay.
 *
 * getters y setters
 * int getID()
 *
 * EnumDistrito getDistrito()
 * void setDistrito(EnumDistrito distrito)
 *
 * String getPersonaNombre()
 * void setPersonaNombre(String nombre)
 *
 * char getPersonaGenero()
 * void setPersonaGenero(char genero)
 *
 * int getPersonaSalario()
 * void setPersonaSalario(int salario)
 *
 * int getPersonaEdad()
 *
 * double getPersonaRelevancia()
 * */
public class Encuesta implements IntEncuesta,Cloneable, Comparable<Encuesta> {
    private int ID;
    private Distrito distrito;
    private Persona persona;

    private static int IDautogenerado=0;
    //Constructor por defecto
    public Encuesta(){
        ID =0;
        distrito = Distrito.DEFAULT;
        persona = new Persona();
    }
    //Constructor con parametros
    public Encuesta(Distrito distrito, String nombre, char genero, int salario){
        ID = IDautogenerado++;
        this.distrito = distrito;
        this.persona = new Persona(nombre, genero, salario);
    }
    //Constructor con parametros 2
    public Encuesta(Persona persona, Distrito distrito){
        ID = IDautogenerado++;
        this.persona = persona;
        this.distrito = distrito;
    }

    public int getID(){
        return ID;
    }

    public Distrito getDistrito(){
        return distrito;
    }
    public void setDistrito(Distrito distrito){
        this.distrito = distrito;
    }
    //Patron delegacion persona
    public String getPersonaNombre(){
        return persona.getNombre();
    }
    public void setPersonaNombre(String nombre){
        persona.setNombre(nombre);
    }

    public char getPersonaGenero(){
        return persona.getGenero();
    }
    public void setPersonaGenero(char genero){
        try {
            persona.setGenero(genero);
        }catch(ExcPersona error){
            System.out.println("No se ha establecido el genero");
        }
    }

    public int getPersonaSalario(){
        return persona.getSalario();
    }
    public void setPersonaSalario(int salario){
        try{
            persona.setSalario(salario);
        }catch(ExcPersona error){
            System.out.println("No se ha establecido el salario");
        }
    }

    public double getPersonaRelevancia(){
        return persona.getRelevancia();
    }

    public int getPersonaEdad(){
        return persona.getEdad();
    }

    @Override
    public String toString(){
        return "Distrito: "+getDistrito()+" Genero: "+getPersonaGenero()+" Salario: "+getPersonaSalario()+  " Nombre: "+ getPersonaNombre()+" ID: "+getID();
    }

    @Override
    public boolean equals(Object obj){
        boolean ret = false;
        if(this == obj)
            ret = true;
        else{
            if(obj != null && obj instanceof Encuesta){
                Encuesta otra = (Encuesta)obj;
                if(otra.getID() == this.getID()){
                    ret = true;
                }
            }
        }
        return ret;
    }

    @Override
    public Encuesta clone(){
        Encuesta copia = null;
        try{
            copia = (Encuesta)super.clone();
        }catch(CloneNotSupportedException error){
            System.out.println("Error en la clonacion.");
        }
        return copia;
    }
    public Encuesta deepClone(){
        Encuesta copia = null;
        try{
            copia = (Encuesta)super.clone();
            copia.persona = new Persona(this.persona);
        }catch(CloneNotSupportedException error){
            System.out.println("Error en la clonacion.");
        }
        return copia;
    }

    @Override
    public int hashCode(){
        return ID*3;
    }

    public int compareTo(Encuesta otra){
        int ret = 0;
        if(this.getID() > otra.getID())
            ret = 1;
        else if(this.getID() < otra.getID())
            ret = -1;
        return ret;
    }

}