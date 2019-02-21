package com.company;
import com.company.Objetos.Cancion;
import java.util.Random;
public class Gestora {

    /* Esta funcion genera una lista de 10 canciones de nombres aleatorios
     * Entrada: ---
     * Precondiciones: ---
     * Salida: Cancion[]
     * Postcondiciones: asociado al nombre se envia un array de canciones.
     * Cabecera: public static Cancion[] GenerarCanciones()
     * */
    public static Cancion[] GenerarCanciones(){
        Cancion[] lista = new Cancion[10];
        String nombre;
        for(int i = 0; i < lista.length ; i++){
            //Genero los parametros aleatorios
            nombre = PalabraAleatoria();
            //En cada iteracion genero una cancion
            lista[i] = new Cancion(nombre,0);
        }
        return lista;
    }

    /* Esta funcion genera un nombre compuesto por letras generadas aleatoriamente.
     * Entrada: ---
     * Precondiciones: ---
     * Salida: String cancion
     * Postcondiciones: asociado al nombre se envia el nombre de la cancion.
     * Cabecera: public static String PalabraAleatoria()
     * */
    public static String PalabraAleatoria() {
        String cancion = "";
        Random rnd = new Random();

        for (int i = 0; i < 7; i++) {
                cancion += (char)(rnd.nextInt(25) + 97);
        }
        return cancion;
    }

    /* Esta funcion muestra en pantalla la lista de canciones.
     * Entrada: Cancion[] lista
     * Precondiciones: el array debe estar lleno.
     * Salida: ---
     * Postcondiciones: no hay. Solo muestra en pantalla.
     * Cabecera: public static void MostrarListaCanciones(Cancion[] lista)
     * */
    public static void MostrarListaCanciones(Cancion[] lista){
        for(int i = 0; i < lista.length; i++){
            System.out.println(lista[i]);
        }
    }

    /* Esta funcion ordena una lista de canciones segun: de mayor votacion a menor.
    * Entrada: ---
    * Precondiciones: el array debe estar lleno.
    * Salida: ---
    *  E/S: un array de canciones:
    * Postcondiciones: el array ordenado.
    * Cabecera: public static void OrdenarLista(Cancion[] lista)
    * */
    public static void OrdenarLista(Cancion[] lista){
        Cancion aux;
        for(int i = 0; i < lista.length; i++) {
            for(int j = lista.length - 1; j > i; j--) {
                if(lista[j].compareTo(lista[j-1]) == 1) {
                    aux = lista[j];
                    lista[j] = lista[j-1];
                    lista[j-1] = aux;
                }
            }
        }
    }

}