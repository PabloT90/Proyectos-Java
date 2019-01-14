package com.company.Objetos;
/*
Propiedades basicas: - Nombre: String, consultable y modificable.
                     - Vida: int, consultable y modificable.
                     - Edad: int, conultable y modificable.
                     - Destreza: Habilidad, consultable y modificable.
Propiedades derivadas: no hay.
Propiedades añadidas: atacar, sanar.
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
public class Jugador implements Cloneable{
    private String nombre;
    private int edad;
    private int vida;
    private Habilidad destreza;

    //Constructores
    //Por defecto
    public Jugador(){
        nombre = new String();
        vida = 100;
        edad = 0;
        destreza = new Habilidad();
    }

    //Con parametros
    public Jugador(String nombre, int vida,int edad, int danio, int sanacion){
        this.nombre = nombre;
        this.vida = vida;
        this.edad = edad;
        this.destreza = new Habilidad(danio,sanacion);
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

    public void Atacar(Jugador jugador,int danio){
        jugador.setVida(jugador.getVida()-danio);
    }

    public void Sanar(Jugador jugador, int sanacion){
        jugador.setVida(jugador.getVida()+sanacion);
    }

    @Override
    public String toString(){
        return "Jugador: "+ getNombre()+" Edad: "+ getEdad() + " Habilidad: "+destreza;
    }

    @Override
    public int hashCode(){
        return getEdad()*3+getVida()+getHabilidadDanio()*2;
    }

    /*
    * Criterio de igualdad: son iguales si la vida, el nombre y la edad son iguales.*/
    @Override
    public boolean equals(Object obj){
        boolean ret = false;

        if(this == obj) {
            ret = true;
        }else{
            if(obj != null && obj instanceof Jugador){
                Jugador otro = (Jugador) obj;

                if(this.getNombre() == otro.getNombre() &&
                this.getVida() == otro.getVida() &&
                this.getEdad() == otro.getEdad()){
                    ret = true;
                }
            }
        }
        return ret;
    }

    @Override
    public Jugador clone(){ //Copia superficial
        Jugador copia = null;

        try{
            copia = (Jugador)super.clone();
            //copia.destreza = new Habilidad(this.destreza); Con esto seria en profundidad.
        }catch(CloneNotSupportedException error){
            System.out.println("Error en la copia");
        }
        return copia;
    }

    /*Criterio de comparacion:
    * Devuelve 0 si la vida y la edad son iguales
    * Devuelve 1 si la edad y vida del primero son mayores que el 2
    * Devuelve -1 si la edad y vida del segundo es mayor que el 1
    * */
    public int compareTo(Jugador otro){
        int ret = -1;

        if(this.getEdad() > otro.getEdad() &&
        this.getVida() > otro.getVida() ){
            ret = 1;
        }else if(this.getEdad() == otro.getEdad() &&
        this.getVida() == otro.getVida()){
            ret = 0;
        }

        return ret;
    }


}