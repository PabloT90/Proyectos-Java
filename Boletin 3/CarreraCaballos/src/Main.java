/*  Descripcion: simulacion de una carrera de caballos.
    Entradas: caracter
    Salidas: eco de los datos, caballo ganador
    Restricciones: el caracter solo puede ser 's' o 'n'

PG
INICIO
    LeerValidarEjecutar
    Mientras quiera ejecutar
        Para (i = 0; i <= distancia; i++)
            generarAleatorio
            avanceCaballos  //Desarrollar
            limpiarConsola*
            mostrarRecorrido
        fin_Para
        MostrarCaballoGanador
    fin_Mientras
FIN
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
            for (int i = 0; i <= distancia; i++) {
                //GenerarAleatorio
                aleatorio = random.nextInt(3) + 1;

                //AvanceCaballos
                // Funciona de la siguiente manera: en cada repeticion lanza un numero, depende del numero que salga avanza un caballo u otro.
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

            //LeerValidarEjecutar
            do {
                System.out.println("Quieres ejecutar?");
                ejecutar = Character.toLowerCase(teclado.next().charAt(0));
            } while (ejecutar != 's' && ejecutar != 'n');
        }

    }
}