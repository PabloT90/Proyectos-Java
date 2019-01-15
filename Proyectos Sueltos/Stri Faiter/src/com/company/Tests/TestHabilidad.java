package com.company.Tests;
import com.company.Excepciones;
import com.company.Objetos.Habilidad;

public class TestHabilidad {
    public static void main(String[]args){
        //Constructor por defecto
        Habilidad skill = new Habilidad();
        System.out.println("Por defecto: "+skill.toString());
        //Constructor con parametros
        Habilidad skill2 = new Habilidad(12,2);
        System.out.println("Con parametros: "+skill2.toString());
        //Construtor de copia
        Habilidad skill3 = new Habilidad(skill2);
        System.out.println("De copia: "+skill3.toString());
        //Gets y sets
        try {
            skill.setDanio(10);
        }catch(Excepciones error){
            System.out.println("Error en el danio");
        }
        System.out.println("Danio skill: "+skill.getDanio());

        try{
            skill.setSanacion(11);
        }catch(Excepciones error){
            System.out.println("Error en la sanacion");
        }
        System.out.println("Sanacion skill: "+skill.getSanacion());

        //hashCode
        System.out.println("hashCode skill: "+skill.hashCode());

        //equals
        System.out.println("Equals skill 1 con la 2: "+skill.equals(skill2));
        System.out.println("Equals skill 1 con la 3: "+skill.equals(skill3));

        //CompareTo
        System.out.println("compareTo skill 1 con la 2: "+skill.compareTo(skill2));
        System.out.println("compareTo skill 1 con la 3: "+skill.compareTo(skill3));

        //Clone
        System.out.println("Prueba clone: ");
        System.out.println("skill.toString() --> "+skill.toString());
        System.out.println("skill3.toString() --> "+skill3.toString());

        System.out.println("skill3 = skill.clone() --> Realizamos la clonacion");
        skill3 = skill.clone();
        System.out.println("skill3.equals(skill3) --> "+skill.equals(skill3));
    }
}