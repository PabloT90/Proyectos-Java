package com.company;

public class Utilidades {
    /*SumarDigitosNumero
    * Entrada: entero numero.
    * Salida: entero numero.
    * E/S: nada.
    * Precondiciones: el numero debe ser real.
    * ---------
    * Entrada: entero numero.
    * Precondiciones: debe ser real.
    * Salida: entero numero.
    * Postcondiciones: Asociado al nombre se manda la suma de los digitos del numero dado.
    * Cabecera: int SumarDigitosNumero(entero numero)
    * */
    public static int SumarDigitosNumero(int numero){
        int resultado=0;
        while(numero != 0){
            resultado = resultado + numero%10;
            numero = numero / 10;
        }
    return resultado;
    }
    /*SumarDigitosNumero
     * Entrada: nada. (Los tipos primitivos no se pasan por referencia)
     * Salida: nada.
     * E/S: entero numero.
     * Precondiciones: debe ser real
     * ---------
     * Entrada: entero numero.
     * Precondiciones: debe ser real.
     * Salida: entero numero.
     * Postcondiciones: Asociado al nombre se manda la suma de los digitos del numero dado.
     * Cabecera: int SumarDigitosNumero(entero numero)
     * */
    public static int NumeroInvertido(int numero){
        int cifra, inverso = 0;
        while(numero!=0) {
            cifra = numero % 10;
            inverso = (inverso * 10) + cifra;
            numero /= 10;
        }
    return inverso;

    }
}