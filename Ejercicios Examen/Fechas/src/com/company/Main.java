package com.company;
/*El ejercicio consiste en: mostrar un menu que compare fechas o que las reste.
Entrada:
    - Entero: opcionMenu, dia1, dia2, mes1, mes2, anio1, anio2.
Salida: mensajes de comunicacion con el usuario, que fecha es mas reciente, resultado de restar 2 fechas.
Restricciones:

PG
INICIO
    MostrarMenu, leeryValidarOpcionMenu
    mientras opcionMenu != 0
        segun(opcionMenu)
            caso 1:
                LeerValidarFecha1
                LeerValidarFecha2
                CompararFechas*
                ImprimirResultadoFechas
            fin_caso1

            caso 2:
                LeerValidarFecha1
                LeerValidarFecha2
                RestarFechas*
                ImprimirResultadoFechasResta
            fin_caso2
        fin_segun
        MostrarMenu, leeryValidarOpcionMenu
    fin_mientras
FIN
* */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int opcionMenu;
        int anio1, anio2, mes1, mes2, dia1, dia2;
        int cantDias1=0, cantDias2=0;
        boolean diaAceptado=false;
        Scanner teclado = new Scanner(System.in);

        //MostrarMenu, leeryValidarOpcionMenu
        do{
            System.out.println("1- Comparar Fechas");
            System.out.println("2- Restar Fechas");
            System.out.println("0- Salir");
            System.out.println("-------------------");
            opcionMenu = teclado.nextInt();
        }while(opcionMenu < 1 || opcionMenu >2);

        while(opcionMenu != 0) { //mientras opcionMenu !=2
            switch(opcionMenu) { //segun(opcionMenu)
                case 1://caso 1:
                    //LeerValidarFecha1
                    do{
                        System.out.println("Dime el dia de la primera fecha");
                        dia1 = teclado.nextInt();

                        System.out.println("Dime el mes de la primera fecha");
                        mes1 = teclado.nextInt();

                        System.out.println("Dime el año de la primera fecha");
                        anio1 = teclado.nextInt();
                    }while(!Utilidades.ExisteFecha(dia1, mes1, anio1)); //Mientras no exista la fecha se sigue repitiendo.
                    System.out.println(Utilidades.cantidadDias(dia1,mes1,anio1));
                    //LeerValidarFecha2
                    do{
                        System.out.println("Dime el dia de la segunda fecha");
                        dia2 = teclado.nextInt();

                        System.out.println("Dime el mes de la segunda fecha");
                        mes2 = teclado.nextInt();

                        System.out.println("Dime el año de la segunda fecha");
                        anio2 = teclado.nextInt();
                    }while(!Utilidades.ExisteFecha(dia2, mes2, anio2));

                    //CompararFechas*
                    cantDias1 = Utilidades.cantidadDias(dia1,mes1,anio1);
                    cantDias2 = Utilidades.cantidadDias(dia2,mes2,anio2);
                    System.out.println("Primera fecha: "+cantDias1+" ---Segunda Fecha: "+cantDias2);
                    //ImprimirResultadoFechas
                    if(cantDias1 > cantDias2){
                        System.out.println("La fecha 1 es mas reciente que la 2º");
                    }else if(cantDias2 > cantDias1){
                        System.out.println("La fecha 2 es mas reciente que la 1º");
                    }else  System.out.println("Son iguales");
                    break;

                case 2: //caso 2:
                    //LeerValidarFecha1
                    do{
                        System.out.println("Dime el dia de la primera fecha");
                        dia1 = teclado.nextInt();

                        System.out.println("Dime el mes de la primera fecha");
                        mes1 = teclado.nextInt();

                        System.out.println("Dime el año de la primera fecha");
                        anio1 = teclado.nextInt();
                    }while(!Utilidades.ExisteFecha(dia1, mes1, anio1));
                    //LeerValidarFecha2
                    do{
                        System.out.println("Dime el dia de la segunda fecha");
                        dia2 = teclado.nextInt();

                        System.out.println("Dime el mes de la segunda fecha");
                        mes2 = teclado.nextInt();

                        System.out.println("Dime el año de la segunda fecha");
                        anio2 = teclado.nextInt();
                    }while(!Utilidades.ExisteFecha(dia2, mes2, anio2));

                    //RestarFechas*

                    //ImprimirResultadoFechasResta

                    break;
            }//fin_segun

            //MostrarMenu, leeryValidarOpcionMenu
            do {
                System.out.println("1- Comparar Fechas");
                System.out.println("2- Restar Fechas");
                System.out.println("0- Salir");
                System.out.println("-------------------");
                opcionMenu = teclado.nextInt();
            } while (opcionMenu < 1 || opcionMenu > 2);
        }//fin_mientras

    }
}