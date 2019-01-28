package com.company;
/*
* Entrada:char reservar, int asiento, char fumador
* Salida: mensajes de comunicacion con el usuario. Las reservas disponibles y las que no segun si es fumador o no.
* Restricciones:
*   - Los asientos 1 al 14 estan reservados para no fumadores. El resto para los que no fumen (15-19).
*   - reservar debe ser 's' o 'n'.
*   - fumador debe ser 's' o 'n'.
* PG
* INICIO
* LeerValidarResevarAsiento
* mientras quiera reservar
*   LeerValidarFumador
*   si es fumador && hay asientos libres de fumadores
*       MostrarAsientosDisponiblesFumador
*       ReservarAsignarAsiento
*   sino
*       MostrarAsientosDisponiblesNoFumador
*       ReservarAsignarAsiento
*   fin_si
*   MostrarReservaCompletada
*   LeerValidarReservarAsiento
* fin_mientras
* FIN
*
* */
import java.util.Scanner;
import com.company.Objetos.*;
public class Main {
    public static void main(String[] args) {
        char reservar,fumador;
        int asiento;
        Scanner teclado = new Scanner(System.in);
        Avion avion = new Avion();

        //LeerValidarResevarAsiento
        do{
            System.out.println("Quieres reservar asiento?");
            reservar = teclado.next().charAt(0);
        }while(reservar !='s' && reservar != 'n');

        while(reservar == 's') {//mientras quiera reservar
            //LeerValidarFumador
            do{
                System.out.println("Eres fumador?");
                fumador = teclado.next().charAt(0);
            }while(fumador !='s' && fumador != 'n');

            if(fumador == 's' && avion.FumadoresLibres()) {//si es fumador && hay asientos libres de fumadores
                //MostrarAsientosDisponiblesFumador
                avion.PlazasFumadores();

                //ReservarAsignarAsiento
                do {
                    System.out.println("Que asiento quieres reservar? Para fumadores del 15 al 19");
                    asiento = teclado.nextInt();
                }while(asiento < 15 || asiento > 19 || avion.AsientoOcupado(asiento));
                avion.AsignarAsiento(asiento);

            }else {//sino

                if(!avion.FumadoresLibres()) System.out.println("No hay plazas para fumadores, te jodes y no fumas.");
                //MostrarAsientosDisponiblesNoFumador
                avion.PlazasNoFumadores();

                //ReservarAsignarAsiento
                do {
                    System.out.println("Que asiento quieres reservar? Para No fumadores del 0 al 14");
                    asiento = teclado.nextInt();
                }while(asiento < 0 || asiento > 14 || avion.AsientoOcupado(asiento));
                avion.AsignarAsiento(asiento);
            }//fin_si

            ///MostrarReservaCompletada
            System.out.println("Reserva Completada.");

            //LeerValidarReservarAsiento
            do{
                System.out.println("Quieres reservar asiento?");
                reservar = teclado.next().charAt(0);
            }while(reservar !='s' && reservar != 'n');
        }//Fin_mientras
    }
}