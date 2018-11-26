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
        return existe;
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

    /* CantidadDiasFecha
    Nec: entero: dia, mes, anio
    Dev: entero cantidadDias
    Nec/Dev: nada.
    Requisitos: nada.

    Interfaz
    Precondiciones: nada.
    Entrada: entero dia, mes, anio
    Salida: entero cantidadDias.
    Postcondiciones: asociado al nombre se manda la cantidad de dia que posee una fecha.
    Cabecera: int cantidadDias(int dia, int mes, int anio)
    * */
    public static int cantidadDias(int dia, int mes, int anio){
        int aniosBisiestos=0;
        int cantidadDias=0;
        //Primero le sumo todos los años-1
        cantidadDias=(anio-1583)*365;
        //Le sumo los dias del año en curso
        cantidadDias= cantidadDias+diasAnioCurso(dia,mes,anio);
        //Le sumo los años bisiesto restantes
        cantidadDias = cantidadDias+CalcularAniosBisiestosTotales(dia,mes,anio);

        return cantidadDias;
    }

    //Calcula los años bisiesto que ha habido en una fecha dada hasta 1582
    public static int CalcularAniosBisiestosTotales(int dia, int mes, int anio){
        int aniosBisiestos=0;
        int contadorAnios=0;
         if(mes>=2)
             contadorAnios = anio-1;
         else contadorAnios = anio;

            for(; contadorAnios >= 1582;contadorAnios--){
                if(esBisiesto(contadorAnios)){
                    aniosBisiestos++;
                }
        }
        return aniosBisiestos;
    }

    //Calcula los dias del año en curso
    public static int diasAnioCurso(int dia, int mes,int anio){
        int resultado = 0, acumulador=0, mesAux= mes-1;

        while(mesAux >=1){
            acumulador = acumulador+ diasPosibles(dia,mesAux,anio);
            mesAux--;
        }
        resultado = dia+acumulador;
        return resultado;
    }

    //Dice los posibles dias segun el mes y el año.
    public static int diasPosibles(int dia, int mes, int anio){
        int resultado=0;
        switch(dia){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                resultado = 31;
                break;

            case 2:
                if(!esBisiesto(anio)) resultado = 28;
                else resultado = 29;
                break;

            default:
                resultado = 30;
                break;
        }
        return resultado;
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
