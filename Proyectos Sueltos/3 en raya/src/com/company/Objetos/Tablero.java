package com.company.Objetos;
/*
Propiedades basicas:
    - tablero Casilla[][] consultable y modificable

Propiedades derivadas: no hay.
Propiedades añadidas:
    - clone
    - MostrarTablero
    - TableroLleno
    - ModificarCasilla
    - ComprobarOcupacion
    - Ganador
Propiedades comunes: no hay.

Patron delegacion Casilla
boolean getCasillaVacia()
void setCasillaVacia(boolean vacia)

boolean getCasillaCara()
void setCasillaCara(boolean Cara)

boolean getCasillaCruz()
void setCasillaCruz(boolean cruz)

*/
public class Tablero implements Cloneable{
    private Casilla[][] tablero;
    //Constructores
    //Por defecto
    public Tablero(){
        tablero = new Casilla[3][3];

        for(int i = 0; i < tablero.length; i++){			//Asi evito que los valores de cada casilla valgan null
            for(int j = 0; j < tablero[0].length; j++){
                tablero[i][j] = new Casilla();              //utilizo el constructor por defecto de la clase Casilla
            }
        }
    }

    //Con parametros
    public Tablero(Casilla[][] tablero){
        this.tablero = tablero;
    }

    //De copia
    public Tablero(Tablero tablero){
        this.tablero = tablero.getTablero();
    }

    //Gets/Sets
    public Casilla[][] getTablero(){
        return tablero;
    }
    public void setTablero(Casilla[][] tablero){
        this.tablero = tablero;
    }

    //MostrarTablero
    public void mostrarTablero(){
        for(int i=0; i < getTablero().length;i++){
            for(int j=0; j < getTablero()[i].length;j++){
                if(tablero[i][j].getVacia()){
                    System.out.print("|_|");
                }
                if(tablero[i][j].getCruz()){
                    System.out.print("|X|");
                }
                if(tablero[i][j].getCara()){
                    System.out.print("|O|");
                }
            }
            System.out.println();
        }
    }


    /** "Permite modificar una casilla del tablero."
     * @author Pablo
     * @param posX "Indica la posicion X del tablero. Empieza en 0."
     * @param posY "Indica la posicion Y del tablero. Empieza en 0."
     * @param marca "Indica si ha sido cara o cruz el turno."
     */
    public void ModificarCasilla(int posX, int posY, char marca){
        Casilla casilla;

        if(ComprobarOcupacion(posX,posY)){ //Compruebo que la casilla este vacia.
            if(marca == 'X')
                tablero[posX][posY] = casilla = new Casilla(false,true,false);
            else
                tablero[posX][posY] = casilla = new Casilla(false,false,true);
        }
    }

    /** "Comprueba si una casilla esta ocupada."
     * @param posX "Posicion X del tablero."
     * @param posY "Posicion Y del tablero"
     * @return "Boolean. True en caso de estar ocupada la casilla. False en caso de no estar ocupada."
     */
    public boolean ComprobarOcupacion(int posX, int posY){
        boolean ret= false;
        if(tablero[posX][posY].getVacia()) ret = true; //Si la casilla esta vacia devuelve true.
        return ret;
    }

    /** "Recorre el tablero en busca de alguna casilla vacia."
     * @author "Pablo"
     * @return "Devuelve un boolean. True en caso de no haber casillas vacias. False en caso contrario."
     */
    public boolean TableroLleno(){
        boolean lleno = true;
        for(int i=0; i < tablero.length; i++){
            for(int j=0; j < tablero[i].length;j++){
                if(tablero[i][j].getVacia()) lleno = false; //Si encuentra alguna casilla vacia devuelve false.
            }
        }
        return lleno;
    }

    /** "Comprueba si ha ganado cara o cruz"
     * @author "Pablo"
     * @return "Devuelve un entero. 1 en caso de ganar Cara, 2 en caso de ganar Cruz, 0 en otro caso."
     */
    public int Ganador(){
        int ganador =0;
        if(tablero[0][0].getCara() && tablero[0][1].getCara() && tablero[0][2].getCara() ||  //Comprobar cada caso :(
                tablero[1][0].getCara() && tablero[1][1].getCara() && tablero[1][2].getCara() ||
                tablero[2][0].getCara() && tablero[2][1].getCara() && tablero[2][2].getCara() ||
                tablero[0][0].getCara() && tablero[1][1].getCara() && tablero[2][2].getCara() ||
                tablero[0][2].getCara() && tablero[1][1].getCara() && tablero[2][0].getCara() ||
                tablero[0][0].getCara() && tablero[1][0].getCara() && tablero[2][0].getCara() ||
                tablero[0][1].getCara() && tablero[1][1].getCara() && tablero[2][1].getCara() ||
                tablero[0][2].getCara() && tablero[1][2].getCara() && tablero[2][2].getCara())
            ganador = 1;
        else if(tablero[0][0].getCruz() && tablero[0][1].getCruz() && tablero[0][2].getCruz() ||
                tablero[1][0].getCruz() && tablero[1][1].getCruz() && tablero[1][2].getCruz() ||
                tablero[2][0].getCruz() && tablero[2][1].getCruz() && tablero[2][2].getCruz() ||
                tablero[0][0].getCruz() && tablero[1][1].getCruz() && tablero[2][2].getCruz() ||
                tablero[0][2].getCruz() && tablero[1][1].getCruz() && tablero[2][0].getCruz() ||
                tablero[0][0].getCruz() && tablero[1][0].getCruz() && tablero[2][0].getCruz() ||
                tablero[0][1].getCruz() && tablero[1][1].getCruz() && tablero[2][1].getCruz() ||
                tablero[0][2].getCruz() && tablero[1][2].getCruz() && tablero[2][2].getCruz())
            ganador = 2;
        return ganador;
    }

    @Override
    public Tablero clone(){
        Tablero copia = null;
        try{
            copia = (Tablero)super.clone();
        }catch(CloneNotSupportedException error){
            System.out.println("Error al clonar");
        }
        return copia;
    }

}