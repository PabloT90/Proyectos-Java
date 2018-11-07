/*
Descripcion: simulacion de una carrera de caballos.
    Entradas: caracter, distancia.
    Salidas: eco de los datos, caballo ganador.
    Restricciones:
        - el caracter solo puede ser 's' o 'n'
        - la distancia debe ser mayor que 0

*************
PG_0
INICIO
    LeerValidarEjecutar
    Mientras quiera ejecutar
        LeerValidarDistanciaCarrera
        SimularCarreraCaballos
        MostrarCaballoGanador
        ActualizarVariables
        LeerValidarEjecutar
    fin_Mientras
FIN

PG_1 SimularCarreraCaballos
INICIO
    mientras ganador sea falso
        generarAleatorio
        avanceCaballos //Desarrollado abajo
        ComprobarLlegadaMeta
        limpiarConsola*
        mostrarRecorrido
    fin_mientras
FIN

PG _2 avanceCaballos
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
        VBC: centinela. Cualquier valor distinto de 's' o 'n'
        Inicializacion: Lectura anticipada antes de la primera iteracion.
        Actualizacion: Lectura final de teclado. Fisicamente al final del bucle.
        Condicion salida: respuesta == 's' || respuesta == 'n'
        Condicion entrada: respuesta != 's' && respuesta != 'n'
____________________________
    BBucle CarreraCaballos
        VCB: indicador.
        Inicializacion: Antes de la primera iteracion a false.
        Actualizacion: Lectura final, fisicamente al final del bucle.
        Condicion salida: llegadaMeta == true
        Condicion entrada: llegadaMeta != true
___________________________
    Bucle WHILE
        VCB: centinela. El centinela es 'n'
        Inicializacion: Lectura anticipada. Antes de la primera iteracion.
        Actualizacion: Lectura final por teclado. Fisicamente al final del bucle.
        Condicion salida: ejecutar == 'n'
        Condicion entrada: ejecutar != 'n'
*************
* */

import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args){
        //Declaraciones
        int aleatorio, cabA=0, cabB=0, cabC=0, distancia;
        boolean llegadaMeta = false;
        String caballoA = "A", caballoB = "B", caballoC = "C";
        char ejecutar;
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        //LeerValidarEjecutar
        do {
            System.out.println("Quieres ejecutar?");
            ejecutar = Character.toLowerCase(teclado.next().charAt(0));
        } while (ejecutar != 's' && ejecutar != 'n');

        while (ejecutar != 'n') { //Mientras quiera ejecutar
            //LeerValidarDistanciaCarrera
            do{
                System.out.println("Establece la distancia de la carrera");
                distancia = teclado.nextInt();
            }while(distancia < 0);

            //SimularCarreraCaballos
            while(!llegadaMeta) {
                //GenerarAleatorio
                aleatorio = random.nextInt(3) + 1;

                //AvanceCaballos    // Funciona de la siguiente manera: en cada repeticion lanza un numero, depende del numero que salga avanza un caballo u otro.
                if (aleatorio == 1) {
                    caballoA = " " + caballoA ;
                    cabA +=1;
                }else if (aleatorio == 2){
                    caballoB = " " + caballoB ;
                    cabB +=1;
                }else{
                    caballoC =  " " + caballoC ;
                    cabC +=1;
                }
                //EstablecerFinRecorrido
                if(cabA >= distancia || cabB >= distancia || cabC >= distancia) llegadaMeta = true;

                //LimpiarConsola
                Utilidades.limpiarConsola();

                //MostrarRecorrido
                System.out.println(caballoA);
                System.out.println(caballoB);
                System.out.println(caballoC);
            }//fin_mientras

            //MostrarCaballoGanador
            if(cabA > cabB && cabA >cabC){
                System.out.println("Ha ganado el caballo A!!");
            }else if(cabB > cabA && cabB >cabC){
                System.out.println("Ha ganado el caballo B!!");
            }else System.out.println("Ha ganado el C!!");

            //ActualizarVariables
             cabA=0; cabB=0; cabC=0;
             caballoA = "A"; caballoB = "B"; caballoC = "C";
             llegadaMeta = false;

            //LeerValidarEjecutar
            do {
                System.out.println("Quieres ejecutar?");
                ejecutar = Character.toLowerCase(teclado.next().charAt(0));
            } while (ejecutar != 's' && ejecutar != 'n');
        }

    }
}