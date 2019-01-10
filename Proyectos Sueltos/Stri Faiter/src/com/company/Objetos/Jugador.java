package com.company.Objetos;
/*
Propiedades basicas: - Nombre: String, consultable y modificable.
                     - Vida: int, consultable y modificable.
                     - Edad: int, conultable y modificable.
                     - Destreza: Habilidad, consultable y modificable.
Propiedades derivadas: no hay.
Propiedades añadidas: nada.
Propiedades compartidas: nada.

Get/Set
String getNombre()
void setNombre(String nombre)

int getVida()
void setVida(int vida)

int getEdad()
void setEdad(int anios)

Patron delegacion Habilidad.
String getNombreHabilidad()
void setNombreHabilidad(String nombre)

int getHabilidadDanio()
void setHabilidadDano(int danio)

int getHabilidadSanacion()
void setHabilidadSanacion(int sanacion)
*/
public class Jugador {
    private String nombre = new String();
    private int edad;
    private int vida;
    private Habilidad destreza = new Habilidad();

    //Constructores
    //Por defecto
    public Jugador(){
        nombre = " ";
        vida = 100;
        edad = 0;
        destreza = new Habilidad();
    }

    //Con parametros
    public Jugador(String nombre, int vida,int edad, Habilidad destreza){
        this.nombre = nombre;
        this.vida = vida;
        this.edad = edad;
        this.destreza = new Habilidad(destreza);
    }

    //De copia
    public Jugador(Jugador player){
        this.nombre = player.getNombre();
        this.vida = player.getVida();
        this.edad = player.getEdad();
        this.destreza = player.destreza;
    }

    //Get/set
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getEdad(){
        return edad;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }

    public int getVida(){
        return vida;
    }
    public void setVida(int vida){
        this.vida = vida;
    }

    //Patron delegacion Habilidad
    public String getNombreHabilidad(){
        return destreza.getNombreHabilidad();
    }
    public void setNombreHabilidad(String nombre){
        destreza.setNombreHabilidad(nombre);
    }

    public int getHabilidadDanio() {
        return destreza.getDanio();
    }
    public void setHabilidadDanio(int danio) {
        destreza.setDanio(danio);
    }

    public int getHabilidadSanacion() {
        return destreza.getSanacion();
    }
    public void setHabilidadSanacion(int sanacion) {
        destreza.setSanacion(sanacion);
    }

    @Override
    public String toString(){
        return "Jugador: "+ getNombre()+" Edad: "+ getEdad();
    }
}