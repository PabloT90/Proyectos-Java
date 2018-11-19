package com.company;
public class Utilidad {
    //Esta funcionalidad hace uso del binomio de Newton |n| (a+b)^n
    //                                                  |m|
    //'n' seria la altura y 'm' un coeficiente binomial. Para mas info consultar en el papel o google xD

    /* Entrada: entero altura.
       Salida:nada.
       Restricciones: la altura debe ser mayor de 0.
       E/s: nada.
       Descripcion: pinta un triangulo de Pascal
       --------
       Entrada: entero altura.
       Precondiciones: la altura debe ser mayor que 0.
       Salida: nada.
       PostCondiciones: no hay, solo pinta en pantalla.
       Cabecera: nada TrianguloPascal(entero altura)
    * */
    public static void TrianguloPascal(int altura){
        int aux2; // porque al comenzar tiene que tener lo mismo que altura |n|
        //                                                                  |n|
        for(int contador1 =0; contador1<= altura;altura--) {
            aux2=altura;
            for (int coeficiente = 0; coeficiente <= altura; coeficiente++) {
                //System.out.print(Resguardo.OperacionesFactorial(altura, aux2));
                System.out.print(OperacionesFactorial(altura, aux2));
                aux2--;
            }
            System.out.println();
        }
    }

    /* Entrada: entero altura, entero coeficiente.
       Salida: entero
       Restricciones: nada.
       E/s: nada.
       Descripcion: calcula los factoriales necesarios para aplicar el binomio de Newton
       --------
       Entrada: entero altura, entero contador.
       Precondiciones:no hay.
       Salida: entero.
       PostCondiciones: asociado al nombre se manda el resultado del binomio de Newton obtenido. Si devuelve -1 significa que el coeficiente era mayor que la altura.
       Cabecera: entero OperacionesFactorial(entero altura, entero contador)
    */
    /* PG
     * CalcularFactorialNumerador
     * CalcularFactorialDenominador
     * CalcularFactorialParentesis
     * CalcularResultadoBinomio
     */

    public static int OperacionesFactorial(int altura, int coeficiente){
       int factorialNumerador = 1,factorialDenominador = 1,factorialParentesis=1;
       int parentesis =altura-coeficiente; //Para poder aplicar la formula, es decir, calcular el factorial del parentesis de la formula.
       int resultado=0;
       if(coeficiente <= altura) {
           //CalcularFactorialNumerador
           while (altura != 0) {
               factorialNumerador = factorialNumerador * altura;
               altura--;
           }
           //CalcularFactorialDenominador
           while (coeficiente != 0) {
               factorialDenominador = factorialDenominador * coeficiente;
               coeficiente--;
           }

           //CalcularFactorialParentesis
           while (parentesis != 0) {
               factorialParentesis = factorialParentesis * parentesis;
               parentesis--;
           }

           //CalcularResultadoBinomio //Formula aplicada: n! / m!(n-m)!
           resultado = factorialNumerador / (factorialDenominador * (factorialParentesis));
       }else resultado = -1; //Si devuelve menos 1 es que el coeficiente era mayor que la altura.
        return resultado;
    }

}