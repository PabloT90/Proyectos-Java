/* ************
Descripcion: simulacion de una carrera de caballos.
    Entradas: caracter
    Salidas: eco de los datos, caballo ganador
    Restricciones: el caracter solo puede ser 's' o 'n'
*************
PG
INICIO
    LeerValidarEjecutar
    Mientras quiera ejecutar
        Para (contador = 0; contador <= distancia; contador++)
            generarAleatorio
            avanceCaballos  //Desarrollado abajo
            limpiarConsola*
            mostrarRecorrido
        fin_Para
        MostrarCaballoGanador
        ActualizarVariables
        LeerValidarEjecutar
    fin_Mientras
FIN

avanceCaballos
   INICIO
       si(aleatorio == 1)
            avanzaCaballoA
            actualizarContadorCabA
       sino
         si(aleatorio == 2)
            avanzaCaballoB
            actualizarContadorCabB
       sino
            avanzaCaballoC
            actualizarContadorCabC
         fin_si
       fin_si
   FIN
*************

*************
Estudio Bucles
___________________________
    LeerValidarEjecutar
        VBC: centinela.
        Inicializacion: Lectura anticipada antes de la primera iteracion.
        Actualizacion: Lectura final de teclado. Fisicamente al final del bucle.
        Condicion salida: respuesta == 's' || respuesta == 'n'
____________________________
    Bucle FOR
        VCB: contador
        Inicializacion: Antes de la primera iteracion a 0
        Actualizacion: Fisicamente al final del bucle incrementando el valor del contador en 1.
        Condicion salida: contador > distancia
___________________________
    Bucle WHILE
        VCB: centinela
        Inicializacion: Lectura anticipada. Antes de la primera iteracion.
        Actualizacion: Lectura final por teclado. Fisicamente al final del bucle.
        Condicion salida: ejecutar =! 's'
*************
* */

import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args){
        //Declaraciones
        int aleatorio, cabA=0, cabB=0, cabC=0, distancia=29;
        String caballoA = "A", caballoB = "B", caballoC = "C";
        char ejecutar;
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        //LeerValidarEjecutar
        do {
            System.out.println("Quieres ejecutar?");
            ejecutar = Character.toLowerCase(teclado.next().charAt(0));
        } while (ejecutar != 's' && ejecutar != 'n');

        while (ejecutar == 's') { //Mientras quiera ejecutar
            for (int contador = 0; contador <= distancia; contador++) {
                //GenerarAleatorio
                aleatorio = random.nextInt(3) + 1;

                //AvanceCaballos    // Funciona de la siguiente manera: en cada repeticion lanza un numero, depende del numero que salga avanza un caballo u otro.
                if (aleatorio == 1) {
                    caballoA = "a" + caballoA ;
                    cabA +=1;
                }else if (aleatorio == 2){
                    caballoB = "b" + caballoB ;
                    cabB +=1;
                }else{
                    caballoC =  "c" + caballoC ;
                    cabC +=1;
                }

                //LimpiarConsola
                Utilidades.limpiarConsola();

                //MostrarRecorrido
                System.out.println(caballoA);
                System.out.println(caballoB);
                System.out.println(caballoC);
            }

            //MostrarCaballoGanador
            if(cabA > cabB && cabA >cabC){
                System.out.println("Ha ganado el caballo A!!");
            }else if(cabB > cabA && cabB >cabC){
                System.out.println("Ha ganado el caballo B!!");
            }else System.out.println("Ha ganado el caballo C!!");

            //ActualizarVariables
             cabA=0; cabB=0; cabC=0;
             caballoA = "A"; caballoB = "B"; caballoC = "C";

            //LeerValidarEjecutar
            do {
                System.out.println("Quieres ejecutar?");
                ejecutar = Character.toLowerCase(teclado.next().charAt(0));
            } while (ejecutar != 's' && ejecutar != 'n');
        }

    }
}