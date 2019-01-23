package com.company.objetos;
/* Propiedades basicas: Casilla[][] tablero consultable y modificable.
   Propiedades derivadas: no hay.
   Propiedades compartidas: no hay.
   Propiedades añadidas:
        - MostrarTablero
        - MostrarTableroResuelto
        - GenerarMinas
        - ComprobarCasillaOcupada
        - GenerarNumeros
        - ComprobarSiEsBomba
        - ExpandirVacio
* */
import java.util.Random;
public class Tablero {
    private Casilla [][] tablero;

    //Constructor por defecto
    public Tablero (){
        tablero = new Casilla[8][8];
        for(int i=0; i < tablero.length; i++){
            for(int j=0; j < tablero[0].length; j++){ //Para evitar que los valores de las casillas valgan null.
                tablero[i][j] = new Casilla();        //Llamamos al constructor por defecto de Casilla
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

    //Gets y sets
    public Casilla[][] getTablero(){
        return tablero;
    }
    public void setTablero(Casilla[][] tablero){
        this.tablero = tablero;
    }

    //GenerarMinas
    public void GenerarMinas(){
        Random rnd = new Random();
        Casilla casilla;
        //GenerarValoresAleatorios
        int x,y;
       for(int mina=0; mina < 10; mina++) { //Generar 10 minas.
            do {
                x = rnd.nextInt();
                y = rnd.nextInt();
            }while (comprobarCasillaOcupada); //Comprueba que la casilla no esta ocupada por una mina.
           tablero[x][y] = casilla = new Casilla(' ','*',' ');
       }
    }

    public boolean CasillaOcupada(int posX, int posY){
        boolean ocupada = false;

        if(){

        }

        return ocupada;
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
}