package com.company;
public class Utilidades {
    /*PuntoPerteneceaCircunferencia
    Entrada: real coorX, real coorY.
    Salida: logico pertenece.
    E/S: no hay.
    Restricciones: no hay.
    Descripcion: determina si un punto pertenece a una circunferencia de radio preestablecido en 10 y centro en (0,0).
    ----------
    Entrada: real coorX, real coorY.
    Precondiciones: nada.
    Salida: logico pertenece.
    Postcondiciones: asociado al nombre se manda un logico. True si pertenece a la circunferencia, false en caso de que no.
    Cabecera: logico PuntoPerteneceaCircunferencia(real coorX, real coorY)
    * */
    public static boolean PuntoPerteneceaCircunferencia(double coorX, double coorY){
        final double distancia = 10; //Asi establezco que el radio del circulo es 10
        final double coorXinicial = 0; final double coorYInicial = 0;
        double distanciaPunto=0;
        boolean pertenece = false;

            distanciaPunto = Distancia2Puntos(coorX,coorXinicial,coorY,coorYInicial); //Lo resuelvo calculando la distancia entre el punto origen (0,0) y el punto dado.

            if(distanciaPunto == distancia || distanciaPunto >= 9.99){ //Lo he hecho asi porque al tratar con numeros reales la mayoria de las veces no da exactamente lo mismo que distancia.
                pertenece = true;
            }
        return pertenece;
    }

    /*Distancia2Puntos
    Entrada: real coorX1, real coorX2, real coorY1, real coorY2.
    Salida: real distancia.
    E/S: nada.
    Restricciones: no hay.
    Descripcion: calcula la distancia entre el punto (0,0) y uno dado.
    ----------
    Entrada: real coorX1, real coorX2, real coorY1, real coorY2.
    Precondiciones: nada.
    Salida: real distancia
    Postcondiciones: asociado al nombre se manda la distancia entre los puntos.
    Cabecera: real Distancia2Puntos(real coorX1, real coorX2, real coorY1, real coorY2)
    * */
    public static double Distancia2Puntos(double coorX2, double coorX1, double coorY2, double coorY1){
        double distancia=0;
        distancia = Math.sqrt(Math.pow(coorX2-coorX1,2)+Math.pow(coorY2-coorY1,2));
        return distancia;
    }

    /*CuadrantePunto
    Entrada: real coorX, real coorY.
    Salida: entero cuadrante.
    E/S: nada.
    Restricciones: ninguna.
    Descripcion: Nos dice en que cuandrante se encuentra un punto.
    ----------
    Entrada: real coorX, real coorY.
    Precondiciones: nada.
    Salida: entero cuadrante.
    Postcondiciones: asociado al nombre se manda en que cuadrante se encuentra el punto. Devuelve 0 si el punto se encuentra sobre un eje.
    Cabecera: entero CuadrantePunto(real coorX, real coorY)
    * */
    public static int CudrantePunto(double coorX, double coorY){
        int cuadrante=0;

        if(coorX > 0 && coorY > 0){
            cuadrante = 1;
        }else if(coorX < 0 && coorY > 0){
            cuadrante = 2;
        }else if(coorX <0 && coorY <0){
            cuadrante=3;
        }else if(coorX >0 && coorY <0){
            cuadrante = 4;
        }
        return cuadrante;
    }

    /*CalcularCoordenadasPolares
    Entrada: real coorX, real coorY.
    Salida: nada.
    E/S: nada.
    Restricciones: no hay.
    Descripcion: Dado un punto se calculan las coordenadas polares de este.
    ----------
    Interfaz Intermedia
    Entrada: real coorX, real coorY.
    Salida: entero grado, entero radio.
    Restricciones: nada.
    E/S: nada.

    Entrada: real coorX, real coorY.
    Precondiciones: nada.
    Salida: entero grado, entero radio.
    Postcondiciones: asociado al nombre se manda el grado y el radio.
    Cabecera: entero entero CalcularCoordenadasPolares(real coorX, real coorY)
    ----------
    Interfaz adaptada a java
    Entrada: real coorX, real coorY.
    Precondiciones: nada.
    Salida: nada, pinta en pantalla.
    Postcondiciones: nada.
    Cabecera: void CalcularCoordenadasPolares(double coorX, double coorY)
    * */
    public static void CalcularCoordenadasPolares(double coorX, double coorY){
        //Calcular Hipotenusa Puedo usar la funcionalidad creada antes, Distancia2Puntos
        final double coorXinicial = 0, coorYinicial=0;
        double hipotenusa, grados=0;
        int cuadrante=0;
        String palabra =" ";

        //CalcularHipotenusa (realmente es el radio)
        hipotenusa = Distancia2Puntos(coorX,coorXinicial,coorY,coorYinicial);
        System.out.println("El radio es: "+ hipotenusa);

        //ObtenerCuadrante
        cuadrante = CudrantePunto(coorX,coorY);

        //Calcular grados segun el cuadrante
        if(cuadrante==2){
            grados = Math.asin(coorY/hipotenusa);
            palabra = " +90º";
        }else if(cuadrante == 3){
            grados = Math.asin(coorY/hipotenusa);
            palabra = " +180º";
        }else if(cuadrante == 4){
            grados = Math.asin(coorY/hipotenusa);
            palabra = " +270º";
        }else if(cuadrante ==1){
            grados = Math.asin(coorY/hipotenusa);
            palabra = " es del primer cuadrante";
        }
        //Casos especiales, cuando el punto esta sobre algun eje.
        if(coorX==0 || coorY==0){
            if(coorX==0 && coorY>0){
                grados = 90;
            }else if(coorX==0 && coorY<0){
                grados= 270;
            }else if(coorY==0 && coorX>0){
                grados=0;
            }else if(coorY==0 && coorX<0){
                grados=180;
            }
        }
        //MostrarResultados
        System.out.println("Los grados son: "+ grados + palabra);
    }

}