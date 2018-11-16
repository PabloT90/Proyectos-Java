package com.company;

public class Conductor {
    public static void main (String[]args){
        System.out.println("Pintar Triangulo");
        int altura = 0; //Debe mostrar solo una fila
        Utilidad.TrianguloPascal(altura);

        altura = 10;
        Utilidad.TrianguloPascal(altura);

        altura = -3; //No debe hacer nada
        Utilidad.TrianguloPascal(altura);

        altura = 7;
        Utilidad.TrianguloPascal(altura);

        System.out.println("Operaciones factorial");

        int coeficiente = 1; altura = 1;
        int resultado;
        resultado = Utilidad.OperacionesFactorial(altura,coeficiente);
        System.out.println("Prueba1: "+resultado);

        coeficiente = 0; altura = 0;
        resultado = Utilidad.OperacionesFactorial(altura,coeficiente);
        System.out.println("Prueba2: "+resultado);

        coeficiente = 4; altura = 3; //Debe fallar porque coeficiente > altura. Devuelve -1
        resultado = Utilidad.OperacionesFactorial(altura,coeficiente);
        System.out.println("Prueba3: "+resultado);

        coeficiente = 3; altura = 6;
        resultado = Utilidad.OperacionesFactorial(altura,coeficiente);
        System.out.println("Prueba4: "+resultado);
    }
}
