package com.company;
/* Simula el juego de 3 en raya.
Entrada: entero posicionFicha
Salida: eco de los datos, ganador.
Restricciones: la posicion de la ficha debe ser valida y estar en una posicion libre.

No lo quiero complicar mucho asi que empezara siempre la misma Figura, en este caso, X. Para cambiar el turno que lo hagan las personas.
PG
INICIO
    MostrarTablero
    repetir
        LeerValidarPosicionFichaX
        EstablecerFichaX
        MostrarTablero
        LeerValidarPosicionFichaO
        EstablecerFichaO
        MostrarTablero
        ComprobarLleno
    mientras no haya ganador || queden posiciones libres.
    MostrarGanador

FIN
* */
import com.company.Objetos.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        Scanner teclado = new Scanner(System.in);

        int numJugada=0;
        int posX;
        int posO;

        ///MostrarTablero
        tablero.mostrarTablero();

        //repetir
        do {
            //LeerValidarPosicionFichaX
            do{
                System.out.println("Donde quieres colocar Cruz?");
                posX = teclado.nextInt();
            }while(posX < 1 || posX > 9 || !Gestora.CasillaOcupada(posX, tablero)); //Mientras la posicion no este entre 1 y 9 o la casilla no este ocupada

            //EstablecerFichaX
            Gestora.ponerMarcaX(posX,tablero);

            //MostrarTablero
            tablero.mostrarTablero();

            //LeerValidarPosicionFichaO
            if(numJugada != 8 && tablero.Ganador() != 2) {
                do {
                    System.out.println("Donde quieres colocar Cara?");
                    posO = teclado.nextInt();
                } while (posO < 1 || posO > 9 || !Gestora.CasillaOcupada(posO, tablero)); //Mientras la posicion no este entre 1 y 9 o la casilla no este ocupada

                //EstablecerFichaO
                Gestora.ponerMarcaY(posO, tablero);

                //MostrarTablero
                tablero.mostrarTablero();
            }
            //ActualizarNumJugadas
            numJugada = numJugada+2; //Acumulo en 2 puesto que una ronda se compone de 2 jugadas.

            //ComprobarLleno
            if(tablero.TableroLleno()) System.out.println("Tablero lleno");

        }while(tablero.Ganador() != 1 && tablero.Ganador() != 2 && !tablero.TableroLleno());//mientras no haya ganador o el tablero este lleno

        //MostrarGanador
        if(tablero.Ganador() == 1) System.out.println("Han ganado las Caras!");
        else if(tablero.Ganador() == 2) System.out.println("Han ganado las Cruces!");
        else System.out.println("Empate!!");

    }
}