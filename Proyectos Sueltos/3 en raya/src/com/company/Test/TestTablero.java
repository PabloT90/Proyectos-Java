package com.company.Test;
import com.company.Objetos.Casilla;
import com.company.Objetos.Tablero;
public class TestTablero {
    public static void main(String[]args){
       Tablero tablero = new Tablero();

        //MostrarTablero
        System.out.println("Mostrar Tablero");
        tablero.mostrarTablero();
        System.out.println("---------------------------");

        System.out.println("Mostrar Tablero con Fichas");
        Casilla casilla3 = new Casilla(0);
        Casilla casilla = new Casilla(1);
        Casilla casilla2 = new Casilla(2);

        Casilla[][] casill = {
                {casilla,casilla2,casilla3},
                {casilla,casilla2,casilla},
                {casilla,casilla,casilla3}
        };
        Tablero tablerito = new Tablero(casill);
        tablerito.mostrarTablero();
        System.out.println("---------------------------");

        System.out.println("Modificar Casilla");
        tablero.ModificarCasilla(1,1,'X');
        System.out.println("Modificar Casilla");
        tablero.ModificarCasilla(2,1,'O');
        tablero.mostrarTablero();
        System.out.println("---------------------------");

        System.out.println("Comprobar Ocupacion. False en caso de no estar ocupada");
        System.out.println(tablero.ComprobarOcupacion(2,1)); //Esta ocupada
        System.out.println(tablero.ComprobarOcupacion(0,0)); //No esta ocupada
        System.out.println("---------------------------");

        System.out.println("Tablero Lleno");
        System.out.println(tablero.TableroLleno());
        System.out.println("---------------------------");

        System.out.println("Ganador");
        System.out.println(tablerito.Ganador()); //Para comprobar si hay ganador solo basta con modificar los valores de tablerito.
        System.out.println("---------------------------");

    }
}