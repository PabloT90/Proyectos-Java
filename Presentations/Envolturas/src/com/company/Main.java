package com.company;
public class Main {
    public static void main(String[] args) {
        //Integer nombreVariable = new Integer(valor)
	    Integer numero = new Integer(2);
	    Integer numero2 = new Integer(5);

	    //compareTo
		System.out.println("CompareTo");
	    System.out.println(numero.compareTo(numero2)); //compareTo devuelve 0 si son iguales. >0 si la primera es mayor y <0 si la primera es menor

		System.out.println("toOctalString");
		int numero3=56;
    	System.out.println(Integer.toOctalString(numero3));

		System.out.println("parseInt");//convertir a entero
    	String cadena="15";
    	System.out.println(cadena+2);//Debe salir 152
    	int suma=Integer.parseInt(cadena);//Realiza la conversion de una cadena a un entero
    	System.out.println(suma+2); //Debe  salir 17

		System.out.println("valueOf");//convertir a cadena
		int numero4=5;
		String.valueOf(numero4);
		System.out.println(numero4+cadena);

    }
}
