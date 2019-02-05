package com.company;
import java.util.Scanner;
import com.company.Objetos.Tablero;
public class utilidades {

    /* Lee y valida la posicion de la casilla que quiera seleccionar.
    * Entrada: Tablero tablero
    * Precondiciones: no hay.
    * Salida: int posX
    * Postcondiciones: asociado al nombre devuelve la posicion de la casilla.
    * Cabecera: int PosFichaX(Tablero tablero)
    * */
    public static int PosFichaX(Tablero tablero){
        Scanner teclado = new Scanner(System.in);
        int posX;
        do{
            System.out.println("Donde quieres colocar Cruz?");
            posX = teclado.nextInt();
        }while(posX < 1 || posX > 9 || !Gestora.CasillaOcupada(posX, tablero)); //Mientras la posicion no este entre 1 y 9 o la casilla no este ocupada
        return posX;
    }

    //Lo mismo que arriba, donde haya X cambiar por Y.
    public static int PosFichaY(Tablero tablero){
        Scanner teclado = new Scanner(System.in);
        int posY;
        do{
            System.out.println("Donde quieres colocar Cara?");
            posY = teclado.nextInt();
        }while(posY < 1 || posY > 9 || !Gestora.CasillaOcupada(posY, tablero)); //Mientras la posicion no este entre 1 y 9 o la casilla no este ocupada
        return posY;
    }
}
