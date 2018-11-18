import java.util.Scanner;
public class numeroTarot {
    public static void main(String[] args) {
        /*  LeeryValidarDatos
            CalcularSumaDiaMesAnio
            SepararNumero //Obtenido a partir de la suma de todos los digitos de la fecha
            MostrarNumeroTarot
         */
        //Hacerlo mediante casteos
        int anio=1, mes=1, dia=1;
        int aux1,aux2,aux3,aux4, numeroTarot;

        Scanner teclado = new Scanner(System.in);
        //LeeryValidarDatos
        do{
            System.out.println("Establece un anio");
            anio = teclado.nextInt();
        }while(anio < 1582);

        do{
            System.out.println("Establece un mes");
            mes = teclado.nextInt();
        }while(mes > 12 || mes < 0);

        if(anio%4 == 0 && anio%100 != 0 && mes == 2){
            do {
                System.out.println("Dime un dia entre 0 y 29");
                dia = teclado.nextInt();
            }while(dia > 29 || dia < 0);
        }else if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes==8 || mes== 10 || mes==12){
            do {
                System.out.println("Dime un dia entre 1 y 31");
                    dia = teclado.nextInt();
                }while(dia > 31 || dia < 0);
            }else if(mes==2){
            do {
                System.out.println("Dime un dia entre 1 y 28");
                dia = teclado.nextInt();
            }while(dia > 28 ||dia < 0);
        }else{
            do {
                System.out.println("Dime un dia entre 1 y 30");
                dia = teclado.nextInt();
            }while(dia > 30 ||dia < 0);
        }
        //CalcularSumaDiaMesAnio
        anio = mes+dia+anio;

        //SepararNumero
        aux1 = anio/1000;
        aux2 = anio % 1000; aux2 = aux2 / 100;
        aux3 = anio % 100; aux3 = aux3 / 10;
        aux4 = anio %10;
        numeroTarot = aux1+aux2+aux3+aux4;

        //MostrarResultado
        System.out.println("Tu numero del Tarot es: "+ numeroTarot);
    }
}