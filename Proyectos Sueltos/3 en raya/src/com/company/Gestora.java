package com.company;
import com.company.Objetos.*;
public class Gestora {
    /*
    * Entrada: entero posMarca, Tablero tablero
    * Precondiciones: la posicion de la casilla debe ser valida.
    * Salida: boolean ret.
    * Postcondiciones: asociado al nombre devuelve true en caso de estar ocupada y false en caso contrario.
    * */
    public static boolean CasillaOcupada(int posMarca,Tablero tablero) {
        boolean ret = false;
        int posX = 0, posY = 0;
        switch (posMarca) {
            case 1:
                posX = posY = 0;
                ret = tablero.ComprobarOcupacion(posX, posY);
                break;
            case 2:
                posX = 0;posY = 1;
                ret = tablero.ComprobarOcupacion(posX, posY);
                break;
            case 3:
                posX = 0;posY = 2;
                ret = tablero.ComprobarOcupacion(posX, posY);
                break;
            case 4:
                posX = 1;posY = 0;
                ret = tablero.ComprobarOcupacion(posX, posY);
                break;
            case 5:
                posX = posY = 1;
                ret = tablero.ComprobarOcupacion(posX, posY);
                break;
            case 6:
                posX = 1;posY = 2;
                ret = tablero.ComprobarOcupacion(posX, posY);
                break;
            case 7:
                posX = 2;posY = 0;
                ret = tablero.ComprobarOcupacion(posX, posY);
                break;
            case 8:
                posX = 2;posY = 1;
                ret = tablero.ComprobarOcupacion(posX, posY);
                break;
            case 9:
                posX = posY = 2;
                ret = tablero.ComprobarOcupacion(posX, posY);
                break;
        }
        return ret;
    }

    /* Pone la marca X en el tablero
     * Entrada: entero posMarca, Tablero tablero
     * Precondiciones: la posicion de la casilla debe ser valida.
     * Salida: no hay.
     * Postcondiciones: no hay, solo muestra en pantalla.
     * */
    public static void ponerMarcaX(int posMarca, Tablero tablero){
        int posX=0,posY=0;
        switch(posMarca){
            case 1:
                posX = posY = 0;
                tablero.ModificarCasilla(posX,posY,'X'); break;
            case 2:
                posX =0; posY = 1;
                tablero.ModificarCasilla(posX,posY,'X');break;
            case 3:
                posX =0; posY = 2;
                tablero.ModificarCasilla(posX,posY,'X');break;
            case 4:
                posX = 1; posY = 0;
                tablero.ModificarCasilla(posX,posY,'X');break;
            case 5:
                posX = posY = 1;
                tablero.ModificarCasilla(posX,posY,'X');break;
            case 6:
                posX =1; posY = 2;
                tablero.ModificarCasilla(posX,posY,'X');break;
            case 7:
                posX =2; posY = 0;
                tablero.ModificarCasilla(posX,posY,'X');break;
            case 8:
                posX =2; posY = 1;
                tablero.ModificarCasilla(posX,posY,'X');break;
            case 9:
                posX = posY = 2;
                tablero.ModificarCasilla(posX,posY,'X');break;
        }
    }

    /* Pone la marca O en el tablero
     * Entrada: entero posMarca, Tablero tablero
     * Precondiciones: la posicion de la casilla debe ser valida.
     * Salida: no hay.
     * Postcondiciones: no hay, solo muestra en pantalla.
     * */
    public static void ponerMarcaY(int posMarca, Tablero tablero){
        int posX=0,posY=0;
        switch(posMarca){
            case 1:
                posX = posY = 0;
                tablero.ModificarCasilla(posX,posY,'O'); break;
            case 2:
                posX =0; posY = 1;
                tablero.ModificarCasilla(posX,posY,'O');break;
            case 3:
                posX =0; posY = 2;
                tablero.ModificarCasilla(posX,posY,'O');break;
            case 4:
                posX = 1; posY = 0;
                tablero.ModificarCasilla(posX,posY,'O');break;
            case 5:
                posX = posY = 1;
                tablero.ModificarCasilla(posX,posY,'O');break;
            case 6:
                posX =1; posY = 2;
                tablero.ModificarCasilla(posX,posY,'O');break;
            case 7:
                posX =2; posY = 0;
                tablero.ModificarCasilla(posX,posY,'O');break;
            case 8:
                posX =2; posY = 1;
                tablero.ModificarCasilla(posX,posY,'O');break;
            case 9:
                posX = posY = 2;
                tablero.ModificarCasilla(posX,posY,'O');break;
        }
    }

}