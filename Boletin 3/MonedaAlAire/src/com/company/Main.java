/*Enunciado: Lanzar al aire dos monedas y contar cuantas veces salen 2 caras, 2 cruces y una cruz y una cara.
Entrada: caracter
Salida: numero de veces que sale cada cosa. Eco de los datos.
Restricciones: el caracter solo puede ser 's' o 'n'.

PG
INICIO
    LeerValidarEjecutar
    Mientras quiera ejecutar
        ObtenerValoresAleatorios
        SumarValoresAleatorios
        SumarContadoresCaraCruz
        MostrarResultados
        LeerValidarEjecutar
    fin_Mientras
FIN
* */

package com.company;
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        char respuesta=' ';
        int contador=0, contador2=0, contador3=0, sumaAleatorios=0;
        int moneda=0, moneda2=0;
        Scanner teclado = new Scanner(System.in);
        Random aleatorio = new Random();

       // LeerValidarEjecutar
        do{
            System.out.println("Quieres ejecutar?");
            respuesta = Character.toLowerCase(teclado.next().charAt(0));
        }while(respuesta !='s' && respuesta !='n');

        //Mientras quiera ejecutar
        while(respuesta == 's') {
            //ObtenerValoresAleatorios
            moneda = aleatorio.nextInt(2)+1;
            moneda2 = aleatorio.nextInt(2)+1;

            //SumarValoresAleatorios
            sumaAleatorios = moneda + moneda2;

            // SumarContadoresCaraCruz
            if(sumaAleatorios == 2){
                contador++;
            }else if(sumaAleatorios == 4){
                contador2++;
            }else
                contador3++;
            // MostrarResultados
            System.out.println("Los resultados han sido: " + contador + " 2 veces cara |" + contador2 + " 2 veces cruz |" + contador3 + " cara/cruz");
            //LeerValidarEjecutar
            do{
                System.out.println("Quieres ejecutar?");
                respuesta = Character.toLowerCase(teclado.next().charAt(0));
            }while(respuesta !='s' && respuesta !='n');
        } //fin_Mientras

    }
}