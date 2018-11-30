package com.company;
/* Division por restas sucesivas de modo recursivo.
* Entrada: entero numerador, entero denominador.
* Salida: entero resultadoDivision, mensajes de comunicacion con el usuario.
* Restricciones: - el numerador no puede ser negativo.
*                - el denominador no puede ser negativo ni 0.
*
* PG
* INICIO
*   leeryValidarNumerador
*   leeryValidarDenominador
*   DividirRestasSucesivas*
*   MostrarResultadoDivision
*   PotenciaRecursiva*
*   MostrarResultadoPotencia
* FIN
* */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int numerador=0, denominador=0, resultadoDivision=0, resultadoPotencia=0;
        Scanner teclado = new Scanner(System.in);

        //leeryValidarNumerador
        do{
           System.out.println("Dime el numerador, mayor o igual que 0");
           numerador = teclado.nextInt();
        }while(numerador <0);

        //leeryValidarDenominador
        do{
            System.out.println("Dime el denominador, mayor que 0");
            denominador = teclado.nextInt();
        }while(denominador <= 0);

        //DividirRestasSucesivas*
        resultadoDivision = DividirRestasSucesivas(numerador,denominador);

        //MostrarResultado division
        System.out.println("El resultado es: "+ resultadoDivision);

        //PotenciaRecursiva*
        resultadoPotencia = PotenciaRecursiva(numerador, denominador);

        //MostrarResultadoPotencia
        System.out.println("El resultado es: "+ resultadoPotencia);
    }

    /*DividirRestasSucesivas
        Nec: entero numerador, entero denominador.
        Dev: entero resultado.
        Nec/Dev: nada.
        Restricciones: numerador debe ser mayor o igual que 0. Denominador debe ser mayor que 0.
        Descripcion: calucla el resultado de una division mediante restas sucesvias. De forma recursiva.

        Entrada: entero numerador, entero denominador
        Precondiciones: numerador debe ser mayor o igual que 0. Denominador debe ser mayor que 0.
        Salida: entero resultadoResta.
        Postcondiciones: asociado al nombre se manda el resultado de la division por restas sucesivas.
        Interfaz: public static int DividirRestasSucesivas(int numerador, int denominador)
    */
    public static int DividirRestasSucesivas(int numerador, int denominador){
        int resultado=0;

        if(denominador > numerador) {
            resultado=0;
        }else {
            resultado =  DividirRestasSucesivas(numerador-denominador, denominador) + 1;
        }
        return resultado;
    }
    /*DividirRestasSucesivas
        Nec: entero base, entero exponente.
        Dev: entero resultadoPotencia.
        Nec/Dev: nada.
        Restricciones: exponente no puede ser negativo (daria recursividad infinita).
        Descripcion: calucla el resultado de una potencia de forma recursiva.

        Entrada: entero base, entero exponente.
        Precondiciones: exponente no puede ser negativo (daria recursividad infinita).
        Salida: entero resultadoPotencia.
        Postcondiciones: asociado al nombre se manda el resultado de la potencia.
        Interfaz: public static int PotenciaRecursiva(int base, int exponente)
    */
    public static int PotenciaRecursiva(int base, int exponente){
        int resultado=0;

        if(exponente == 0) {
            resultado=1;
        }else {
            resultado =  PotenciaRecursiva(base,exponente-1)*base;
        }
        return resultado;
    }

}