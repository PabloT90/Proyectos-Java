package com.company.Objetos;
/*
Propiedades basicas:
    - tablero Casilla[][] consultable y modificable

Propiedades derivadas: no hay.
Propiedades añadidas:
    - las de object
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
public class Tablero {
    private Casilla[][] tablero;
    private Casilla cas;
    //Constructores
    //Por defecto
    public Tablero(){
        tablero = new Casilla[3][3];
        cas = new Casilla();
        for(int i = 0; i < tablero.length; i++){			//Para evitar que los valores de cada casilla valgan 'null'
            for(int j = 0; j < tablero[0].length; j++){	    //utilizamos el constructor por defecto de la clase Casilla
                tablero[i][j] = new Casilla();
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
        this.cas = tablero.cas;
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

    //Permite modificar una casilla del tablero.
    /**
     * @author Pablo
     * @param posX "Indica la posicion X del tablero. Empieza en 0."
     * @param posY "Indica la posicion Y del tablero. Empieza en 0."
     * @param marca "Indica si ha sido cara o cruz el turno."
     */
    public void ModificarCasilla(int posX, int posY, char marca){
        Casilla casilla;

        if(ComprobarOcupacion(posX,posY)){ //Si la casilla esta vacia.
            if(marca == 'X')
                tablero[posX][posY] = casilla = new Casilla(false,true,false);
            else
                tablero[posX][posY] = casilla = new Casilla(false,false,true);
        }
    }

    //True en caso de no estar ocupada. False en caso contrario
    public boolean ComprobarOcupacion(int posX, int posY){
        boolean ret= false;
        if(tablero[posX][posY].getVacia()) ret = true; //Si esta vacia devuelve true.
        return ret;
    }

    //Recorre el tablero en busca de alguna casilla vacia. Si encuentra 1
    public boolean TableroLleno(){
        boolean lleno = true;
        for(int i=0; i < tablero.length; i++){
            for(int j=0; j < tablero[i].length;j++){
                if(tablero[i][j].getVacia()) lleno = false; //Si encuentra alguna casilla vacia devuelve false.
            }
        }
        return lleno;
    }
    //Devuelve 1 si ha ganado cara y 2 si ha ganado cruz
    public int Ganador(){
        int ganador =0;
        if(tablero[0][0].getCara() && tablero[0][1].getCara() && tablero[0][2].getCara() ||  //Comprobar cada caso :(
            tablero[1][0].getCara() && tablero[1][1].getCara() && tablero[1][2].getCara() ||
                tablero[2][0].getCara() && tablero[2][1].getCara() && tablero[2][2].getCara() ||
                tablero[0][0].getCara() && tablero[1][1].getCara() && tablero[2][2].getCara() ||
                tablero[0][2].getCara() && tablero[1][1].getCara() && tablero[2][0].getCara())
            ganador = 1;
        else if(tablero[0][0].getCruz() && tablero[0][1].getCruz() && tablero[0][2].getCruz() ||
                tablero[1][0].getCruz() && tablero[1][1].getCruz() && tablero[1][2].getCruz() ||
                tablero[2][0].getCruz() && tablero[2][1].getCruz() && tablero[2][2].getCruz() ||
                tablero[0][0].getCruz() && tablero[1][1].getCruz() && tablero[2][2].getCruz() ||
                tablero[0][2].getCruz() && tablero[1][1].getCruz() && tablero[2][0].getCruz())
            ganador = 2;
        return ganador;
    }

}