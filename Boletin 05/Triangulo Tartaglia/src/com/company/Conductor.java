package com.company;

public class Conductor {
    public static void main (String[]args){
        //Probar TrainguloPascal
        System.out.println("Pruebas de TrianguloPascal");
        int altura=0; //Debe pintar solo 1 fila.
        Utilidad.TrianguloPascal(altura);

        altura=4;
        Utilidad.TrianguloPascal(altura);

        altura=7;
        Utilidad.TrianguloPascal(altura);

        altura=-3;
        Utilidad.TrianguloPascal(altura); //No debe mostrar nada.

        //Probar calcularFactorial
        System.out.println("Pruebas de CalcularFactorial");
        System.out.println(Utilidad.CalcularFactorial(8)); //Debe dar correcto.

        System.out.println(Utilidad.CalcularFactorial(-4)); //Deberia devolver 0.

        System.out.println(Utilidad.CalcularFactorial(0)); //Debe dar 1.

        //Probar CalcularBinomio
        System.out.println("Pruebas de CalcularBinomio");
        System.out.println(Utilidad.CalcularBinomio(1000,7,1));

        System.out.println(Utilidad.CalcularBinomio(5,3,2));

        System.out.println(Utilidad.CalcularBinomio(7,1,6));

        System.out.println(Utilidad.CalcularBinomio(1,1,0)); //Devolveria -2.

        System.out.println(Utilidad.CalcularBinomio(7,8,6)); //Devolveria -1.
    }
}
