package com.company;
import com.company.Clases.Persona;
/*
* Entradas:
*   - Persona persona. //Realmente solo lee el nombre la persona, las respuestas a las preguntas se hacen automaticas.
*   - int opcionMenu.
* Salidas:
*   - Mensajes de comunicacion con el usuario.
*   - Los datos ordenados segun la opcion elegida.
* Restricciones:
*   - La opcion del menu debe estar entre 1 y 3.
*
*  //Todo el proceso se va a hacer de forma automatica. Excepto cuando se tenga que usar alguna opcion de menu.
* PG
* INICIO
   mientras quiera ejecutar
       CrearPerfilPersona
       ComprobarAdmision
   fin_mientras
   MostrarLeerValidarMenuOpciones //Para simplificar el ejercicio no voy a añadir que se pueda volver atras al elegir una opcion del menu.
   segun(opcionMenu)
       opcion 1: OrdenarxNumeroAspirante
       opcion 2: OrdenarxPuntuacion
       opcion 3: MostrarInfoGeneral
   fin_segun
 FIN
**/
public class Main {
    public static void main(String[] args) {
        Utiliades util = new Utiliades();
        Persona persona;
        Persona[] listado = new Persona[50]; //Esto es el numero de solicitudes. No quiere decir que finalmente se presenten 50 participantes
        int contAux=0;

        int [] aryys = new int[3];
        aryys[0] = 1;
        while(util.LeerValidarEjecutar() == 's') {//mientras quiera ejecutar
            //CrearPerfilPersona
            persona = util.CrearPerfilPersona();

            //ComprobarAdmision
            if (util.PersonaAdmitida(persona)) { //Si la persona no obtiene el visto bueno en sus calificaciones no se tendra en cuenta
                listado[contAux] = persona; //Esto me servira para ordenar el array de personas.
                contAux++;
            }else{
                System.out.println("No ha pasado la prueba, lo sentimos.");
            }
        }//fin_mientras

        switch(util.MostrarLeerValidarMenu()) {//segun(opcionMenu)
            case 1: //opcion 1: OrdenarxNumeroAspirante
                util.OrdenarListaxAspirante(listado);

                //Esto deberia ser el modulo: MostrarListaSegunAspirante
                for(int i = 0; i < listado.length; i++){
                    System.out.println(listado[i]);
                }
                break;
            case 2: //opcion 2: OrdenarxPuntuacion
                    util.OrdenarLista(listado);
                    //Esto deberia ser el modulo: MostrarListaOrdenada
                    for(int i = 0; i < listado.length; i++){
                        System.out.println(listado[i]);
                    }
                break;
            case 3: //opcion 3: MostrarInfoGeneral
                    System.out.println("En construccion.");
                break;
        }//fin_segun
    }
}