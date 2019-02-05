package com.company.Objetos;
/*
Propiedades basicas:
    - tablero Casilla[][] consultable.

Propiedades derivadas: no hay.
Propiedades añadidas:
    - clone
    - MostrarTablero
    - TableroLleno
    - ModificarCasilla
    - ComprobarOcupacion
    - Ganador
Propiedades comunes: no hay.

Casilla[][] getTablero()
*/
public class Tablero implements Cloneable{
    private Casilla[][] tablero;
    //Constructores
    //Por defecto
    public Tablero(){
        tablero = new Casilla[3][3];

        for(int i = 0; i < tablero.length; i++){			//Asi evito que los valores de cada casilla valgan null
            for(int j = 0; j < tablero[i].length; j++){
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

    //MostrarTablero
    public void mostrarTablero(){
        for(int i=0; i < getTablero().length;i++){
            for(int j=0; j < getTablero()[i].length;j++){
                if(tablero[i][j].getEstado() == 0){
                    System.out.print("|_|");
                }
                else if(tablero[i][j].getEstado() == 1){
                    System.out.print("|X|");
                }
                else if(tablero[i][j].getEstado() == 2){
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
                tablero[posX][posY] = casilla = new Casilla(1);
            else
                tablero[posX][posY] = casilla = new Casilla(2);
        }
    }

    /** "Comprueba si una casilla esta ocupada."
     * @param posX "Posicion X del tablero."
     * @param posY "Posicion Y del tablero"
     * @return "Boolean. True en caso de estar ocupada la casilla. False en caso de no estar ocupada."
     */
    public boolean ComprobarOcupacion(int posX, int posY){
        boolean ret= false;
        if(tablero[posX][posY].getEstado()==0) ret = true; //Si la casilla esta vacia devuelve true.
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
                if(tablero[i][j].getEstado()==0) lleno = false; //Si encuentra alguna casilla vacia devuelve false.
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
        if(tablero[0][0].getEstado()==2 && tablero[0][1].getEstado()==2 && tablero[0][2].getEstado()==2 ||  //Comprobar cada caso :(
                tablero[1][0].getEstado()==2 && tablero[1][1].getEstado()==2 && tablero[1][2].getEstado()==2 ||
                tablero[2][0].getEstado()==2 && tablero[2][1].getEstado()==2 && tablero[2][2].getEstado()==2 ||
                tablero[0][0].getEstado()==2 && tablero[1][1].getEstado()==2 && tablero[2][2].getEstado()==2 ||
                tablero[0][2].getEstado()==2 && tablero[1][1].getEstado()==2 && tablero[2][0].getEstado()==2 ||
                tablero[0][0].getEstado()==2 && tablero[1][0].getEstado()==2 && tablero[2][0].getEstado()==2 ||
                tablero[0][1].getEstado()==2 && tablero[1][1].getEstado()==2 && tablero[2][1].getEstado()==2 ||
                tablero[0][2].getEstado()==2 && tablero[1][2].getEstado()==2 && tablero[2][2].getEstado()==2)
            ganador = 1;
        else if(tablero[0][0].getEstado()==1 && tablero[0][1].getEstado()==1 && tablero[0][2].getEstado()==1 ||
                tablero[1][0].getEstado()==1 && tablero[1][1].getEstado()==1 && tablero[1][2].getEstado()==1 ||
                tablero[2][0].getEstado()==1 && tablero[2][1].getEstado()==1 && tablero[2][2].getEstado()==1 ||
                tablero[0][0].getEstado()==1 && tablero[1][1].getEstado()==1 && tablero[2][2].getEstado()==1 ||
                tablero[0][2].getEstado()==1 && tablero[1][1].getEstado()==1 && tablero[2][0].getEstado()==1 ||
                tablero[0][0].getEstado()==1 && tablero[1][0].getEstado()==1 && tablero[2][0].getEstado()==1 ||
                tablero[0][1].getEstado()==1 && tablero[1][1].getEstado()==1 && tablero[2][1].getEstado()==1 ||
                tablero[0][2].getEstado()==1 && tablero[1][2].getEstado()==1 && tablero[2][2].getEstado()==1)
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