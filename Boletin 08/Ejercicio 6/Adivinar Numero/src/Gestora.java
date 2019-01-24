public class Gestora {
    //Comprobar numero correcto
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

    //numeros en posicion correcta
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

    //Aciertos en posiciones desordenadas.
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