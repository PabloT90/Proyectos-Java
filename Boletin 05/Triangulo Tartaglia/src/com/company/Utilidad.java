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
        //                                                                  |m|
        int numeroImprimir=0;
        int posicionN=0, posicionM=0, posicionNM=0;
        for(int contador1 =0; contador1<= altura;altura--) {
            aux2=altura;
            for (int coeficiente = 0; coeficiente <= altura; coeficiente++) {
                //Hacemos 3 llamadas a CalcularFactorial
                posicionN = CalcularFactorial(altura);
                posicionM = CalcularFactorial(aux2);
                posicionNM = CalcularFactorial(altura-aux2);

                //CalcularBinomio*
                numeroImprimir = CalcularBinomio(posicionN,posicionM,posicionNM); //A calcular Binomio le paso los 3 parametros recien obtenidos.

                //ImprimirNumeroCalculado
                System.out.print(numeroImprimir);

                aux2--; //Esto seria M. Aqui actualizamos el valor de M en cada iteracion.
            }
            System.out.println();
        }
    }
    /* Entrada: entero numero.
       Salida: entero factorial.
       Restricciones: nada.
       E/s: nada.
       Descripcion: calcula el factorial de un numero dado.
       --------
       Entrada: entero numero.
       Precondiciones: nada.
       Salida: entero factorial.
       PostCondiciones: asociado al nombre se manda el resultado de calcular el factorial. Devuelve 0 si el numero es menor que 0.
       Cabecera: entero CalcularFactorial(entero numero)
    * */
    public static int CalcularFactorial (int numero){
        int factorial =1;
        if(numero >=0) {
            while (numero != 0) {
                factorial = factorial * numero;
                numero--;
            }
        }else factorial = 0;
        return factorial;
    }

    /* Entrada: entero N, entero M, entero NmenosM.
       Salida: entero
       Restricciones: nada.
       E/s: nada.
       Descripcion: calcula binomio de Newton
       --------
       Entrada: entero N, entero M, entero NmenosM.
       Precondiciones:no hay.
       Salida: entero.
       PostCondiciones: asociado al nombre se manda el resultado del binomio de Newton obtenido. Si devuelve -1 significa que el coeficiente era mayor que la altura.
       Cabecera: entero CalcularBinomio(entero N, entero M, entero NmenosM)
    */
    public static int CalcularBinomio(int N, int M, int NmenosM){
       int resultado=0;
       if(M <= N) {
           //Calcular Binomio de Newton.
           resultado = N / (M * (NmenosM));
       }else resultado = -1; //Si devuelve menos 1 es que el coeficiente era mayor que la altura.
        return resultado;
    }

}