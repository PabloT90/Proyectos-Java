package com.company;
import com.company.Clases.Persona;

import java.util.Random;
import java.util.Scanner;
public class Utiliades {

    /* Esta funcion muestra si quiere ejecutar, lee y valida si quiere.
     * Entrada: ---
     * Precondiciones: ---
     * Salida: char ejecutar
     * Postcondiciones: asociado al nombre se envia el caracter elegido valido.
     * Cabecera:  public char LeerValidarEjecutar()
     * */
    public char LeerValidarEjecutar(){
        Scanner teclado = new Scanner(System.in);
        char ejecutar;

        do{
            System.out.println("Quieres ejecutar? s/n");
            ejecutar = Character.toLowerCase(teclado.next().charAt(0));
        }while(ejecutar != 's' && ejecutar != 'n');

        return ejecutar;
    }

    /* Esta funcion muestra un menu, lee y valida la opcion elegida.
     * Entrada: ---
     * Precondiciones: ---
     * Salida: int ejecutar
     * Postcondiciones: asociado al nombre se envia la opcion elegida
     * Cabecera: public int MostrarLeerValidarMenu()
     * */
    public int MostrarLeerValidarMenu(){
        Scanner teclado = new Scanner(System.in);
        int ejecutar;

        do{
            System.out.println("1- Ordenar por Numero de aspirante");
            System.out.println("2- Ordenar por numero de aciertos");
            System.out.println("3- Mostrar resultados generales");
            ejecutar = teclado.nextInt();
        }while(ejecutar < 1 || ejecutar > 3);

        return ejecutar;
    }


    /* Esta funcion genera un nombre compuesto por letras generadas aleatoriamente.
     * Entrada: ---
     * Precondiciones: ---
     * Salida: String cancion
     * Postcondiciones: asociado al nombre se envia el nombre de la cancion.
     * Cabecera: public static String PreguntaAleatoria()
     * */
   /*public String PreguntaAleatoria() {
        String pregunta = "";
        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            pregunta += (char)(rnd.nextInt(25) + 97);
        }
        pregunta = pregunta + "?";
        return pregunta;
    }*/

    /* Esta funcion ordena una lista de Personas segun el numero de aciertos.
     * Entrada: ---
     * Precondiciones: el array debe estar lleno.
     * Salida: ---
     * Postcondiciones: el array ordenado.
     * Cabecera: public void OrdenarLista(Persona[] lista)
     * */
    public void OrdenarLista(Persona[] lista){
        Persona aux;
        for(int i = 0; i < lista.length; i++) {
            for(int j = lista.length - 1; j > i; j--) {
                if(lista[j] != null && lista[j-1] != null && lista[j].CalcularNota() > lista[j-1].CalcularNota()) {
                    aux = lista[j];
                    lista[j] = lista[j-1];
                    lista[j-1] = aux;
                }
            }
        }
    }

    /* Esta funcion crea el perfil de la persona para la prueba.
     * Entrada: ---
     * Precondiciones: ---
     * Salida: Persona persona
     * Postcondiciones: asociado al nombre se manda la persona
     * Cabecera: public Persona CrearPerfilPersona()
     * */
    public Persona CrearPerfilPersona(){
        Scanner teclado = new Scanner(System.in);
        Persona persona;
        String nombre;
        int[] calificaciones;

        System.out.println("Cual es tu nombre?");
        nombre = teclado.nextLine();

        //Obtener Calificaciones
        calificaciones = ObtenerCalificaciones();

        persona = new Persona(nombre, calificaciones);
        return persona;
    }

    /* Esta funcion genera las calificaciones de un participante
     * Entrada: ---
     * Precondiciones: ---
     * Salida: int[] calificaciones
     * Postcondiciones: asociado al nombre se manda el array con las calificaciones.
     * Cabecera: public int[] ObtenerCalificaciones()
     * */
    public int[] ObtenerCalificaciones(){
        int[] calificaciones = new int[10];
        Random rnd = new Random();

        for(int i = 0; i < calificaciones.length; i++){
            calificaciones[i] = rnd.nextInt(2);
        }
        return calificaciones;
    }

    /* Esta funcion ordena una lista de personas segun su numero de aspirante
     * Entrada: Persona[] lista
     * Precondiciones: el array debe estar lleno.
     * Salida: ---
     * E/S: un array de canciones:
     * Postcondiciones: el array ordenado.
     * Cabecera: public void OrdenarListaxAspirante(Persona[] lista)
     * */
    public void OrdenarListaxAspirante(Persona[] lista){
        Persona aux;
        for(int i = 0; i < lista.length; i++) {
            for(int j = lista.length - 1; j > i; j--) {
                if(lista[j] != null && lista[j-1] != null && lista[j].compareTo(lista[j-1]) > 1) {
                    aux = lista[j];
                    lista[j] = lista[j-1];
                    lista[j-1] = aux;
                }
            }
        }
    }

    /* Descripcion: esta funcion nos dice si una persona ha sido admitida o no.
    * Entrada: Persona persona.
    * Precondiciones: la persona debe ser valida.
    * Salida: boolean ret.
    * Postcondiciones: asociado al nombre devuelve true en caso de ser admitida y false en caso contrario.
    * Cabecera: public boolean PersonaAdmitida(Persona persona).
    * */
    public boolean PersonaAdmitida(Persona persona){
        boolean ret = false;
        int [] aux = persona.getCalificaciones();

        if(aux[0] + aux[1] + aux[2] == 3 &&           //Tiene que acertar las 3.
          (aux[3] + aux[4] + aux[5] + aux[6] >= 2) && //Tiene que acertar al menos 2.
          (aux[7] + aux[8]+aux[9] >= 1)) {            //Tiene que acertar al menos 1.
            ret = true;
        }
        return ret;
    }

}