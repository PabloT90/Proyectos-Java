package com.company;
/*
Resumen: Se muestra una lista con 10 canciones, el usuario solo puede votar a 5 de ellas. Al final da la opcion de mostrar los votos totales.
El nombre de las canciones se genera de forma aleatoria.

* Entradas:
*   - int numCancion
*   - char volverVotar
* Salidas:
*   - mensajes de comunicacion con el usuario.
*   - lista con todas las canciones disponibles para votar.
*   - resultado de las votaciones.
* Restricciones:
*   - numCancion debe estar entre 0 y 9.
*   - volverVotar debe ser 's' o 'n'
*
* PG
* INICIO
    ObtenerListaCanciones
    mientras quiera votar
        MostrarListaCanciones
        para(int cont=0; cont < 5; cont++)
            votarCancion
        fin_para
        RegistrarVoto
        LeerValidarVolverVotar
    fin_mientras
    mostrarResultadoVotaciones
* FIN
*
* */
import com.company.Objetos.Cancion;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int numVoto;
        char volverVotar='s';
        Cancion[] lista; //Para la lista de canciones

        //ObtenerListaCanciones
        lista = Gestora.GenerarCanciones();

        while(volverVotar == 's') {//mientras quiera votar
            //MostrarListaCanciones
            Gestora.MostrarListaCanciones(lista);

            for(int cont=0; cont < 5; cont++) {//para(int cont=0; cont < 5; cont++)
                //votarCancion
                do{
                    System.out.println("A que cancion quieres votar? Siguen un orden natural.");
                    numVoto = teclado.nextInt();
                }while(numVoto < 0 || numVoto > 9);

                //RegistrarVoto
                lista[numVoto].setNumVotos(lista[numVoto].getNumVotos()+1);
                System.out.println("Voto añadido.");
            }//fin_para

            //LeerValidarVolverVotar
            do{
                System.out.println("Quieres ejecutar? s/n");
                volverVotar = teclado.next().charAt(0);
            }while(volverVotar  != 's' && volverVotar != 'n');
        }//fin_mientras

        //mostrarResultadoVotaciones
        Gestora.OrdenarLista(lista);
        Gestora.MostrarListaCanciones(lista);
    }
}