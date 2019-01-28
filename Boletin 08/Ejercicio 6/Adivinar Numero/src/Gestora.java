public class Gestora {
    /* Dado un numero nos devuelve los digitos que lo componen.
        Entrada: int numero
        Precondiciones: Por valor se pasa el numero de la combinacion.
        Salida: int[] digitos
        Postcondiciones:Asociado al nombre se devuelven los digitos que conforman el numero de la combinacion.
    */
    public static int[] ObtenerDigitos(int numero){
        int[] digitos;
        int uno,dos,tres,cuatro;

        uno = numero/1000;
        dos = (numero%1000)/100;
        tres = (numero%100)/10;
        cuatro = numero%10;
        digitos = new int[]{uno,dos,tres,cuatro};

        return digitos;
    }

    /* Comprueba cuantos numeros estan en su posicion correcta
       Entrada: int[] numeroCombinacion, int[] numeroDicho
       Precondiciones: no hay.
       Salida: int aciertos
       Postcondiciones: Se devuelve asociado al nombre el numero de aciertos de la combinacion.
   */
    public static int numerosPosicionCorrecta(int[] numeroCombinacion, int[]numeroDicho){
        int aciertos = 0;
        for(int i =0; i < numeroCombinacion.length; i++){
            //Compruebo cada posicion del array
            if(numeroCombinacion[i] == numeroDicho[i]){
                aciertos++;
            }
        }
        return aciertos;
    }

    /* Comprueba cuantos numeros has acertado, no importa el orden.
       Entrada: int[] numeroCombinacion, int[] numeroDicho
       Precondiciones: no hay.
       Salida: no hay.
       Postcondiciones: solo muestra en pantalla.
   */
    public static void AciertosDesordenados(int[] numeroCombinacion, int[]numeroDicho){
        int aciertos = 0;
        for(int i= 0; i < numeroDicho.length; i++){
            for(int j = 0; j< numeroCombinacion.length; j++){
                if(numeroDicho[i]== numeroCombinacion[j])
                    aciertos++;
            }
        }
        System.out.println("Aciertos Aleatorios: "+aciertos);
    }
}