package com.company.Clases;
import com.company.Excepciones.ExcPersona;
import com.company.Interfaces.IntPersona;
/*
* Propiedades basicas:
*   - Nombre String consultable y modificable.
*   - Genero char consultable y modificable.
*   - Salario int consultable y modificable
* Propiedades derivadas:
*   - Edad int consultable. (Tiene que ser con la clase Fecha pero no la hare.)
*   - relevancia double consultable.
* Propiedades compartidas:
*   - FactorRelevancia double.
* Propiedades Añadidas: no hay.
*
* Restricciones:
*   - FactorRelevancia debe ser 0.15
*   - El salario va entre 1000 y 2000.
*   - El genero debe ser 'h' o 'm'
*
* getter y setter
* String getNombre()
* void setNombre(String nombre)
*
* char getGenero()
* void setGenero(char genero)
*
* int getSalario()
* void setSalario(int salario)
*
* int getEdad()
* void setEdad(int edad) //Lo he hecho asi porque no voy a añadir la clase fecha, en caso de querer hacerlo debemos hacer aqui un metodo que llame a otro para calcular la edad.
*
* double getRelevancia()
* void setRelevancia(double relevancia)
* */
public class Persona implements IntPersona, Cloneable, Comparable<Persona>{
    private String nombre;
    private char genero;
    private int salario;

    private static double FactorRelevancia=0.15;

    //Constructor por defecto
    public Persona(){
        nombre = "Pablo";
        genero = 'H';
        salario = 1000;
    }
    //Constructor con parametros
    public Persona(String nombre, char genero, int salario){
        this.nombre = nombre;
        this.genero = genero;
        this.salario = salario;
    }
    //Constructor de copia
    public Persona(Persona copia){
        this.genero = copia.getGenero();
        this.nombre = copia.getNombre();
        this.salario = copia.getSalario();
    }

    //getters y setters
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public char getGenero(){
        return genero;
    }
    public void setGenero(char genero)throws ExcPersona{
        if(genero =='h' || genero == 'm')
            this.genero = genero;
        else
            throw new ExcPersona("Error al establecer el genero");
    }

    public int getSalario(){
        return salario;
    }
    public void setSalario(int salario)throws ExcPersona{
        if(salario >= 1000 && salario <= 2000)
        this.salario = salario;
        else
            throw new ExcPersona("Error al establecer el salario");
    }

    public int getEdad(){
        return 1;
    }

    public double getRelevancia(){
        return salario*FactorRelevancia;
    }

    @Override
    public String toString(){ //Aqui van las basicas y las derivadas, incluso las del patron delegacion.
        return "Nombre: "+getNombre()+" Genero: "+getGenero()+" Salario: "+getSalario()+" Relevancia:"+getRelevancia()+" Edad: "+getEdad();
    }
    @Override
    public boolean equals(Object obj){
        boolean ret = false;
        if(this == obj)
            ret = true;
        else{
            if(obj != null && obj instanceof Persona){
                Persona otro = (Persona)obj;
                if(this.getSalario() == otro.getSalario()){
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
            System.out.println("Error en la copia");
        }
        return copia;
    }

    @Override
    public int hashCode(){
        return salario*3;
    }

    public int compareTo(Persona otra){
        int ret = 0;
        if(this.getSalario() > otra.getSalario()){
            ret = 1;
        }else if(this.getSalario() < otra.getSalario()){
            ret = -1;
        }
        return ret;
    }

}