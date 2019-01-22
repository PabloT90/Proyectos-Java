package com.company.Test;
import com.company.Objetos.Casilla;
import com.company.Objetos.Tablero;
public class TestTablero {
    public static void main(String[]args){
        Tablero tablero = new Tablero();

        tablero.mostrarTablero();

        Casilla casilla3 = new Casilla(true,false,false);
        Casilla casilla = new Casilla(false,true,false);
        Casilla casilla2 = new Casilla(false,false,true);

        Casilla[][] casill = {
                {casilla,casilla2,casilla3},
                {casilla,casilla2,casilla},
                {casilla,casilla,casilla3}
        };
        Tablero tablerito = new Tablero(casill);
        tablerito.mostrarTablero();
    }
}