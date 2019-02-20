package com.company;
/*
* Entrada:
*   - String nombre.
*   - int Salario.
*   - char genero.
*   - char ejecutar
*   - int numEncuestas
*   - String distrito
* Salida:
*   - mensajes de comunicacion con el usuario.
*   - Resultados de la encuesta.
*   - Porcentajes por distrito.
* Restricciones:
*   - El genero debe ser 'h' o 'm'.
*   - El salario debe estar comprendido entre 1000 y 2000
*
* PG
* INICIO
*   LeerValidarEjecutar
*   mientras quiera ejecutar
*       LeerValidarNumeroEncuestas
*       para(int n =1; n < numEncuestas; n++)
*           RellenarDatosPersona
*           GenerarEncuesta
*           MostrarResultadosEncuesta
*       fin_para
*       MostrarResultadosPorcentajes
*       LeerValidarEjecutar
*   fin_mientras
* FIN
*
* PG N1 RellenarDatosPersona
* INICIO
*   LeerNombre
*   LeerValidarGenero
*   LeerValidarSalario
*   LeerValidarDistrito
* FIN
*
*/

import com.company.Clases.Encuesta;
import com.company.Clases.Persona;
import com.company.Enum.Distrito;
public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona();
        Encuesta encuesta;
        char ejecutar;
        int numEncuestas;
        int norte=0, sur=0, este=0, oeste=0;
        String distrito;
        Distrito distritoEnum=null;
        //LeerValidarEjecutar
        ejecutar = Utilidades.LeerValidarEjecutar();

        while(ejecutar == 's') {//mientras quiera ejecutar
            ////LeerValidarNumeroEncuestas
            numEncuestas = Utilidades.LeerValidarNumeroEncuestas();
            for(int n=0; n < numEncuestas; n++) {//para(int n =1; n < numEncuestas; n++)
                //RellenarDatosPersona
                //LeerNombre
                Utilidades.LeerNombre(persona);
                //LeerValidarGenero
                Utilidades.LeerValidarGenero(persona);
                //LeerValidarSalario
                Utilidades.LeerValidarSalario(persona);
                //LeerValidarDistrito
                distrito = Utilidades.LeerValidarDistrito();

                switch(distrito){
                    case "oeste": distritoEnum = Distrito.OESTE;
                        oeste++;
                        break;
                    case "este": distritoEnum = Distrito.ESTE;
                        este++;
                        break;
                    case "norte": distritoEnum = Distrito.NORTE;
                        norte++;
                        break;
                    case "sur": distritoEnum = Distrito.SUR;
                        sur++;
                        break;
                }
                //GenerarEncuesta
                encuesta = new Encuesta(persona, distritoEnum);
                //MostrarResultadosEncuesta
                System.out.println(encuesta.toString());
            }//fin_para
            //MostrarResultadosPorcentajes
            System.out.println();
            System.out.println("Porcentaje de encuestas:");
            System.out.println("Distrito Norte: "+(norte * 100 / numEncuestas)+"%.");
            System.out.println("Distrito Sur: "+(sur * 100 / numEncuestas)+"%.");
            System.out.println("Distrito Este: "+(este * 100 / numEncuestas)+"%.");
            System.out.println("Distrito Oeste: "+(oeste * 100 / numEncuestas)+"%.");
            System.out.println();
            //LeerValidarEjecutar
            ejecutar = Utilidades.LeerValidarEjecutar();
        }//fin_mientras

    }
}

/*
String mes, dia, annio;
Calendar c1 = Calendar.getInstance();
dia = Integer.toString(c1.get(Calendar.DATE));
mes = Integer.toString(c1.get(Calendar.MONTH)+1); //La funcion va desde 0 a 11.
annio = Integer.toString(c1.get(Calendar.YEAR));
System.out.println(dia+" "+mes+" "+" "+annio);
*/