package com.company;
import java.util.Scanner;
/* PG
INCICIO
    LeerValidarEjecutar
    mientras quiera ejecutar
        MostrarMenu
        LeeryValidarMenu
        segun(opcionMenu)
            opcion 1:
                PintarColina
            opcion 2:
                NumeroMalvado
            opcion 3:
                CartaMagica
        fin_segun
        LeerValidarEjecutar
    fin_mientras
FIN

Analisis PintarColina
Entrada: numeroAltura, caracterRelleno, caracterSuavizado.
Salida: pinta en pantalla.
Restricciones:
    - El numero tiene que ser impar entre 5 y 17
	- El caracter de relleno tiene que ser una letra mayuscula
	- Los caracteres de suavizado solo pueden ser d,b,n,A,J

PG PintarColina
INICIO
    LeerValidarEjecutar
    mientras quiera ejecutar
        LeerValidarNumero
        LeerValidarCaracterRelleno
        LeerValidarCaracterSuavizado
        ImprimiColina
        LeerValidarEjecutar
    fin_mientras
FIN

Analisis CartaMagica
El ordenador simulará un juego en el que hay que sacar una carta, segun las restricciones abajo descritas
decidiremos quien ha ganado la ronda. La primera jugada es del jugador. La primera vez saca el jugador, las siguientes
saca el que haya ganado la anterior y en caso de empate sacará el ultimo que haya ganado

La probabilidad de que gane el primer jugador es del 35 %
La probabilidad de que gane el segundo jugador es del 2'5 %
La probabilidad de empate es del 62'5 %

Entrada: numeroPartidas, ejecutar.
Salida: eco de los datos, resultados.
Restricciones: Asignaremos un numero a cada carta de la baraja española, sin 8 ni 9
	- OROS: del 1 al 10 (figuras: 8, 9, 10)
	- BASTOS: del 11 al 20 (figuras: 18, 19, 20)
	- COPAS: del 21 al 30 (figuras: 28, 29, 30)
	- ESPADAS: del 31 al 40 (figuras: 38, 39, 40)

	Se gana si se saca una carta que:
		- Esté entre 8 y 11 o entre 21 y 40
	Se pierde si se saca una carta que:
		- Sea 22
	- Numero de jugadas máximo: 10

PG
INICIO
    LeerValidarEjecutar
    mientras quiera ejecutar
        LeerValidarNumeroPartidas
        mientras haya partidas
            JugarCartaMagica //Analizado abajo
            ActualizarContadorPartidas
        fin_mientras
        MostrarResultadoGeneral
        LeerValidarEjecutar
    fin_mientras
FIN

PG JugarCartaMagica
INICIO
    GenerarCarta
    EstablecerGanador
    segun(ganador)
        caso 1:
            MostrarGanadorPersona
            ActualizarVictoriasPersona
            ActualizarNombreGanador
        caso 2:
            MostrarGanadorPC
            ActualizarVictoriasPC
            ActualizarNombreGanador //Tendremos un variable de tipo String a la que le cambiaremos su valor.
        caso 3:
            MostrarEmpate
FIN
*/
public class Main {
    public static void main(String[] args) {

    }
}