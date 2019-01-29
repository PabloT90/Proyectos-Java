package com.company.Objetos;
/*
 *  Propiedades basicas:
        - asiento[] avion consutable y modificable.
 *  Propiedades derivadas: no hay.
 *  Propiedades añadidas:
        - MostrarAvion
        - clone
        - plazasFumadores
        - fumadoresLibres
        - plazasNoFumadores
        - NoFumadoresLibres
        - AsignarAsiento
        - AsientoOcupado
 *  Propiedades comunes: no hay.
 *  Restricciones:
        - La zona de fumadores va desde el 15 al 19
        - La zona de no fumadores va desde el 0 hasta el 14
 * Gets/Sets
   Asiento[] getAvion()
   void setAvion(Asiento[] avion)
 * */
public class Avion implements Cloneable{
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

    /** "Muestra todas las plazas del avion."
     * @author Pablo
     */
    public void MostrarAvion(){
        for(int i = 0; i < avion.length; i++){
            if(avion[i].getOcupacion())
                System.out.print("[1]"); //Si esta ocupado muestra 1.
            else
                System.out.print("[0]"); //Si no esta ocupado muestra 0.
        }
    }

    @Override
    public Avion clone(){
        Avion copia = null;

        try{
            copia = (Avion)super.clone();
        }catch(CloneNotSupportedException error){
            System.out.println("Error en la copia");
        }
        return copia;
    }

    /** "Muestra las plazas libres de la zona no fumadores."
     * @author Pablo
     */
    public void PlazasFumadores(){
        for(int i = 15; i < avion.length; i++){
            System.out.println("Plaza: "+i+" Ocupado: "+ avion[i].getOcupacion() );
        }
    }

    /** "Indica si algun asiento de la zona fumadores esta libre."
     * @author Pablo
     * @return "Devuelve un boolean. True en caso de haber alguno libre. False en caso contrario."
     */
    public boolean FumadoresLibres(){
        boolean disponible = false;
        for(int i = 15; i < avion.length; i++){
            if(!avion[i].getOcupacion()) //Si hay algun asiento libre devuelve true
                disponible = true;
        }
        return disponible;
    }

    /** "Muestra las plazas libres de la zona no fumadores."
     * @author Pablo
     */
    public void PlazasNoFumadores(){
        for(int i = 0; i < avion.length-5; i++){
            System.out.println("Plaza: "+i+ " Ocupado: "+ avion[i].getOcupacion() );
        }
    }

    /** "Indica si algun asiento de la zona no fumadores esta libre."
     * @author Pablo
     * @return "Devuelve un boolean. True en caso de haber alguno libre. False en caso contrario."
     */
    public boolean NoFumadoresLibres(){
        boolean disponible = false;
        for(int i = 0; i < avion.length-5; i++){
            if(!avion[i].getOcupacion()) //Si hay algun asiento libre devuelve true
                disponible = true;
        }
        return disponible;
    }

    /** "Asigna un asiento del avion."
     * @author Pablo
     * @param asiento "Indica el asiento del avion."
     */
    public void AsignarAsiento(int asiento){
        avion[asiento].setOcupacion(true);
    }

    /** "Indica si un asiento esta ocupado o no."
     * @author Pablo
     * @param asiento "Indica el asiento del avion."
     * @return "Devuelve un boolean. True en caso de esta ocupado. False en caso contrario."
     */
    public boolean AsientoOcupado(int asiento){
        boolean ocupado = false;
            if(avion[asiento].getOcupacion())
                ocupado = true;
        return ocupado;
    }
}