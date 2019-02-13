public class TestSocio{
	public static void main(String[]args){
		//Constructor por defecto
		Socio s1 = new Socio();
		System.out.println("Socio 1: "+s1.toString());
		Socio s3 = new Socio();
		System.out.println("Socio 3: "+s3.toString());
		Socio s4 = new Socio();
		System.out.println("Socio 4: "+s4.toString());
		
		//Constructor con parametros.
		EnumDeporte deporte = EnumDeporte.TENIS;
		Socio s2 = new Socio("Pablo Prats", 12, 19, 'F', deporte);
		System.out.println(s2.toString());
		
		deporte = EnumDeporte.FUTBOL;
		Socio s5 = new Socio("Asun Apruebame", 4.0, 19, 'F', deporte);
		System.out.println(s5.toString());
		//Constructor de copia
		s1 = s2;
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		
		
        //Gets y sets
        System.out.println("Al hacer uso del metodo toString arriba (en el que para obtener los valores uso los metodos set y get de la clase) No veo necesario volver a probarlos");
        //Al hacer uso del metodo toString arriba (en el que para obtener los valores uso los metodos set de la clase)
        //No veo necesario volver a probarlos. 
        
        try{
			s1.setEdad(-1);
			//s1.setEdad(22);
        }catch(Excepciones error){
			System.out.println("");
		}
		try{
			s1.setCuota(-12);
			//s1.setCuota(12);
        }catch(Excepciones error){
			System.out.println("");
		}
		try{
			s1.setGenero('t');
			//s1.setGenero('M');
        }catch(Excepciones error){
			System.out.println("");
		}

        //hashCode
        System.out.println("hashCode: "+s1.hashCode());

        //equals
        System.out.println("Equals socio 1 con el 2: "+s1.equals(s2));
        System.out.println("Equals socio 1 con el 3: "+s1.equals(s3));

        //CompareTo
        System.out.println("compareTo socio 1 con el 2: "+s1.compareTo(s2));
        System.out.println("compareTo socio 1 con el 3: "+s1.compareTo(s3));

        //Clone
        System.out.println("Prueba clone: ");
        System.out.println("s1.toString() --> "+s1.toString());
        System.out.println("s3.toString() --> "+s3.toString());

        System.out.println("s3 = s1.clone() --> Realizamos la clonacion");
        s3 = s1.clone();
        System.out.println("s1.equals(s3) --> "+s1.equals(s3));
	}
}
