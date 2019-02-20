package com.company.Interfaces;

import com.company.Excepciones.ExcPersona;

public interface IntPersona {
    //aqui se ponen las propiedades basicas y las derivadas
    String getNombre();
    void setNombre(String nombre);

    char getGenero();
    void setGenero(char genero)throws ExcPersona;

    int getSalario();
    void setSalario(int salario) throws ExcPersona;

    //edad y relevancia
    int getEdad();

    double getRelevancia();
}
