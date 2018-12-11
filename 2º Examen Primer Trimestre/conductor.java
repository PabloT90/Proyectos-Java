public class conductor{
	public static void main(String[]args){
		System.out.println("ValidarFecha:");
		System.out.println(Utilidades.ValidarFecha(2000,2,29));
		System.out.println(Utilidades.ValidarFecha(2001,13,12));
		System.out.println(Utilidades.ValidarFecha(1581,12,12));
		System.out.println(Utilidades.ValidarFecha(2000,12,32));
		System.out.println(Utilidades.ValidarFecha(2018,12,11));
		
		System.out.println("EsBisiesto:");
		System.out.println(Utilidades.esBisiesto(2000));
		System.out.println(Utilidades.esBisiesto(2001));
		System.out.println(Utilidades.esBisiesto(2002));
		System.out.println(Utilidades.esBisiesto(2003));
		System.out.println(Utilidades.esBisiesto(2004));
		
		System.out.println("diasQueFaltan:"); //De este he hecho menos pruebas porque lo he probado con casos limite y que podrian dar error.
		System.out.println(Utilidades.diasQueFaltan(1,1,2000));
		System.out.println(Utilidades.diasQueFaltan(1,12,2000));
		System.out.println(Utilidades.diasQueFaltan(30,12,2002));
		
		System.out.println("PrevDate:");
		Utilidades.PrevDate(1,12,2000);
		Utilidades.PrevDate(2,12,2000);
		Utilidades.PrevDate(1,1,2000);
		Utilidades.PrevDate(15,12,2000);
		Utilidades.PrevDate(1,3,2000);
		
		System.out.println("PintarPiramide:");
		Utilidades.PintarPiramide('f',5);
		Utilidades.PintarPiramide('g',9);
		Utilidades.PintarPiramide('*',2);
		
		System.out.println("DiaMes:");
		System.out.println(Utilidades.DiaMes(2,2000));
		System.out.println(Utilidades.DiaMes(2,2001));
		System.out.println(Utilidades.DiaMes(12,2000));
		System.out.println(Utilidades.DiaMes(4,2000));
	}
}
