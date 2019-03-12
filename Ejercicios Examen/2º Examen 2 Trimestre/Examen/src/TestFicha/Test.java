package TestFicha;
import Clases.*;
import Enums.EnumActividad;
import Excepciones.excepciones;
public class Test {
	public static void main(String[] args) throws excepciones {
        //Constructor por defecto
        ImplFicha p1 = new ImplFicha();
        System.out.println("Socio 1: " + p1.toString());
        ImplFicha p2 = new ImplFicha();
        System.out.println("Socio 3: " + p2.toString());
        ImplFicha p3 = new ImplFicha();
        System.out.println("Socio 4: " + p3.toString());

        //Constructor con parametros.
        EnumActividad act = EnumActividad.ALTO;
        Fecha fecha = new Fecha();
        ImplFicha p4 = new ImplFicha( "Pablo",  act,  5, 3 , fecha);
        System.out.println(p4.toString());

        ImplFicha p5 = new ImplFicha("Pablo",  act,  4, 7 , fecha);
        System.out.println(p5.toString());

        //Constructor de copia
        p1 = p3;
        System.out.println(p1.toString());
        System.out.println(p3.toString());


        //Gets y sets
        System.out.println("Al hacer uso del metodo toString arriba (en el que para obtener los valores uso los metodos set y get de la clase) No veo necesario volver a probarlos");
        //Al hacer uso del metodo toString arriba (en el que para obtener los valores uso los metodos set de la clase)
        //No veo necesario volver a probarlos.

        //hashCode
        System.out.println("hashCode: " + p2.hashCode());

        //equals
        System.out.println("Equals socio 1 con el 2: " + p1.equals(p4));
        System.out.println("Equals socio 1 con el 3: " + p1.equals(p3));

        //CompareTo
        System.out.println("compareTo socio 1 con el 2: " + p1.compareTo(p4));
        System.out.println("compareTo socio 1 con el 3: " + p1.compareTo(p3));

        //Clone
        System.out.println("Prueba clone: ");
        System.out.println("s1.toString() --> " + p1.toString());
        System.out.println("s3.toString() --> " + p3.toString());

        System.out.println("s3 = s1.clone() --> Realizamos la clonacion");
        p3 = p1.clone();
        System.out.println("s1.equals(s3) --> " + p1.equals(p3));

        //CaloriasQuemadas
        System.out.println("Calcular Nota:");
        System.out.println(p3.CaloriasQuemadas(30)+ "calorias quemadas");
        
        //Prueba del ENUM
        System.out.println(act.name());
	}
}
