package com.company.Interfaces;

import com.company.Excepciones.ExcPersona;

public interface IntPersona {
    //aqui se ponen las propiedades basicas y las derivadas
    public String getNombre();
    public void setNombre(String nombre);

    public char getGenero();
    public void setGenero(char genero)throws ExcPersona;

    public int getSalario();
    public void setSalario(int salario) throws ExcPersona;

    //edad y relevancia
    public int getEdad();

    public double getRelevancia();
}
