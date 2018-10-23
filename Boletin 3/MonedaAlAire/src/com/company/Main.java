/*Enunciado: Lanzar al aire dos monedas y contar cuantas veces salen 2 caras, 2 cruces y una cruz y una cara.
Entrada: caracter, numero de tiradas.
Salida: numero de veces que sale cada cosa. Eco de los datos.
Restricciones: el caracter solo puede ser 's' o 'n'.
               el numero de tiradas debe ser mayor que 0

PG
INICIO
    LeerValidarEjecutar
    Mientras quiera ejecutar
        LeerValidarTiradas
        Para (i=0, i < tiradas, i++)   //Duda sobre si todo este bucle deberia ser un modulo
            ObtenerValoresAleatorios
            SumarValoresAleatorios
            SumarContadoresCaraCruz
        fin_Para
        MostrarResultados
        ActualizarContadoresCaraCruz
        LeerValidarEjecutar
    fin_Mientras
FIN
* */

package com.company;
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        char respuesta;
        int contador=0, contador2=0, contador3=0, sumaAleatorios, tiradas;
        int moneda, moneda2;
        Scanner teclado = new Scanner(System.in);
        Random aleatorio = new Random();

       // LeerValidarEjecutar
        do{
            System.out.println("Quieres ejecutar?");
            respuesta = Character.toLowerCase(teclado.next().charAt(0));
        }while(respuesta !='s' && respuesta !='n');

        while(respuesta == 's') { //Mientras quiera ejecutar
            //LeerValidarTiradas
            do{
                System.out.println("Cuantas veces quieres que se tiren las monedas");
                tiradas = teclado.nextInt();
            }while(tiradas < 0);

            for(int i=0; i < tiradas;i++) {
                //ObtenerValoresAleatorios
                moneda = aleatorio.nextInt(2) + 1;
                moneda2 = aleatorio.nextInt(2) + 1;

                //SumarValoresAleatorios
                sumaAleatorios = moneda + moneda2;

                // SumarContadoresCaraCruz
                if (sumaAleatorios == 2) {
                    contador++;
                } else if (sumaAleatorios == 4) {
                    contador2++;
                } else
                    contador3++;
            }//fin_Para

            //MostrarResultados
            System.out.println("El resultado ha sido: " + contador + " doble cara |" + contador2 + " doble cruz |" + contador3 + " cara/cruz");

            //ActualizarContadoresCaraCruz
            contador = 0; contador2 = 0; contador3 = 0;

            //LeerValidarEjecutar
            do{
                System.out.println("Quieres ejecutar?");
                respuesta = Character.toLowerCase(teclado.next().charAt(0));
            }while(respuesta !='s' && respuesta !='n');
        } //fin_Mientras

    }
}