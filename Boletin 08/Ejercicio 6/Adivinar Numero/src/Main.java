/*
* Juego: tener un numero de 4 cifras y tratar de adivinarlo en 12 pasos.
* si se acierta uno de los números de la combinación, el ordenador responderá con tantos números se acierten.
* Si, además de acertar un número, se acierta la posición que ocupa dentro de la serie, el ordenador responderá.
*
* Entrada: un numero entero.
* Salida: mensajes de comunicacion con el usuario. Eco de los resultados.
* Restricciones: el numero debe ser mayor que 1000 y menor que 9999.
*
* PG
* INICIO
*   GenerarEstablecerNumero
*   Repetir
*       LeerValidarNumero
*       ActualizarIntentos
*       MostrarResultados
*       ComprobarSiEsCorrecto
*   mientras no se acierte el numero y queden intentos.
*   MostrarGanador
* FIN
* */
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main (String[]args){
        int numero, intento=0, numAleatorio;
        int[] combinacion = new int[3];
        int[] numDicho = new int[3];
        Random rnd = new Random();
        Scanner teclado = new Scanner(System.in);
        Combinacion codigo = new Combinacion();

        //GenerarEstablecerNumero
        numAleatorio = rnd.nextInt(9999)+1000;
        combinacion = Gestora.ObtenerDigitos(numAleatorio);
        codigo.setCodigo(combinacion);

        do {//Repetir
            //LeerValidarNumero
            do{
                System.out.println("Dime un numero de 4 cifras mayor que 1000");
                numero = teclado.nextInt();
            }while(numero < 1000 || numero > 9999);
            numDicho = Gestora.ObtenerDigitos(numero);

            //ActualizarIntentos
            intento++;

            //MostrarResultados
            System.out.println("Numero de aciertos y posiciones correctas: "+Gestora.numerosPosicionCorrecta(combinacion,numDicho));
            Gestora.AciertosDesordenados(combinacion, numDicho);

            //ComprobarSiEsCorrecto
            if( Gestora.numerosPosicionCorrecta(combinacion,numDicho) == 4) codigo.setUnlocked(true);

        }while(!codigo.getUnlocked() && intento < 12);//mientras no se acierte el numero y queden intentos.

        //MostrarGanador
        if(codigo.getUnlocked())System.out.println("Has ganado");
            else System.out.println("La proxima sera dude!");
    }
}