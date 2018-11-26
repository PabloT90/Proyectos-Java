package com.company;

public class Utilidades {
    /* ExisteFecha
    Nec: entero dia, entero mes, entero anio
    Dev: logico existe
    Nec/Dev: nada.
    Requisitos: nada.
    Descripcion: comprueba que una fecha exista/sea correcta

    Interfaz
    Precondiciones: nada.
    Entrada: entero dia, entero mes, entero anio.
    Salida: logico existe.
    Postcondiciones: asociado al nombre se envia un logico, true en caso de que sea valida la fecha y false en caso contrario
    Cabecera: boolean ExisteFecha(int dia, int mes, int anio)
    * */
    public static boolean ExisteFecha(int dia, int mes, int anio){
        boolean existe=false;
        if(anio >= 1582 && mes >= 1 && mes <= 12 && dia >= 1){
            switch(mes) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    if (dia <= 31)
                        existe = true;
                break;

                case 2:
                    if (dia <= (28 + (esBisiesto(anio) ? 1 : 0)))
                        existe = true;
                break;

                default:
                    if (dia <= 30)
                        existe = true;
                break;

            }
        }
        return true;
    }

    /* esBisiesto
    Nec: entero anio
    Dev: logico isBisiesto
    Nec/Dev: nada.
    Requisitos: nada.

    Interfaz
    Precondiciones: nada.
    Entrada: entero anio.
    Salida: logico isBisiesto
    Postcondiciones: asociado al nombre se manda si es bisiesto o no. True en caso de serlo, false en caso contrario.
    Cabecera: public static boolean esBisiesto(int anio)
    * */
    public static boolean esBisiesto(int anio){
        boolean isBisiesto=false;

        if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) isBisiesto = true;

        return isBisiesto;
    }

    /* esBisiesto
    Nec: entero anio
    Dev: logico isBisiesto
    Nec/Dev: nada.
    Requisitos: nada.

    Interfaz
    Precondiciones:
    Entrada:
    Salida:
    Postcondiciones:
    Cabecera:
    * */
}
