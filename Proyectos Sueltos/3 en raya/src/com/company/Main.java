package com.company;
/* Simula el juego de 3 en raya.
Entrada: entero posicionFicha
Salida: eco de los datos, ganador.
Restricciones: la posicion de la ficha debe ser valida(1-9) y estar en una posicion libre.

No lo quiero complicar mucho asi que empezara siempre la misma Figura, en este caso, X. Para cambiar el turno que lo hagan las personas.
PG
INICIO
    MostrarTablero
    repetir
        LeerValidarPosicionFichaX*
        EstablecerFichaX
        MostrarTablero
        Si numJugada != 8 && no ha ganado cruz
            LeerValidarPosicionFichaO*
            EstablecerFichaO
            MostrarTablero
        fin_si
        Actualizar NumJugada
        ComprobarLleno
    mientras no haya ganador && el tablero no este lleno
    MostrarGanador*

FIN
* */
import com.company.Objetos.*;
public class Main {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();

        int numJugada=0;
        int posX;
        int posO;

        ///MostrarTablero
        tablero.mostrarTablero();

        //repetir
        do {
            //LeerValidarPosicionFichaX
            posX = utilidades.PosFichaX(tablero);

            //EstablecerFichaX
            Gestora.ponerMarcaX(posX,tablero);

            //MostrarTablero
            tablero.mostrarTablero();

            if(numJugada != 8 && tablero.Ganador() != 2) {
                //LeerValidarPosicionFichaO
                posO = utilidades.PosFichaY(tablero);

                //EstablecerFichaO
                Gestora.ponerMarcaY(posO, tablero);

                //MostrarTablero
                tablero.mostrarTablero();
            }
            //ActualizarNumJugadas
            numJugada = numJugada+2; //Acumulo en 2 puesto que una ronda se compone de 2 jugadas.

            //ComprobarLleno
            if(tablero.TableroLleno()) System.out.println("Tablero lleno");

        }while(tablero.Ganador() != 1 && tablero.Ganador() != 2 && !tablero.TableroLleno());//mientras no haya ganador && el tablero no este lleno

        //MostrarGanador*
        Gestora.MostrarGanador(tablero.Ganador());
    }
}