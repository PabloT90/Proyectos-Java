import java.util.Scanner;
public class OpFechasyFiguras{
	public static void main (String[]args){
		Scanner teclado = new Scanner(System.in);
		int opcionMenu, opcionSubMenu1, opcionSubMenu2, dia, mes, anio, altura;
		int diasFaltan;
		char base;
		
		do{
			//MostrarMenu, leeryValidarOpcionMenu
			do{
				System.out.println("1- Operaciones con Fechas");
				System.out.println("2- Pintar Figuras");
				System.out.println("0- Salir");
				System.out.println();
				opcionMenu = teclado.nextInt();
			}while(opcionMenu<0 || opcionMenu > 2);
			
			if(opcionMenu !=0){
				switch(opcionMenu){
					case 1:
						//OperacionesFechas
						do{
							//MostrarMenu, leeryValidarOpcionSubMenu1
							do{
								System.out.println("1- Dias que Faltan");
								System.out.println("2- Anterior Fecha Valida");
								System.out.println("3- Semana del anio");
								System.out.println("0- Volver atras");
								System.out.println("");
								opcionSubMenu1 = teclado.nextInt();
							}while(opcionSubMenu1 <0 || opcionSubMenu1 > 3);
							
							if(opcionSubMenu1 !=0){
								switch(opcionSubMenu1){
									case 1:
										//DiasQueFaltan
										
										//LeerValidarFecha
										do{
											System.out.println("Dime el anio");
											anio = teclado.nextInt();
											System.out.println("Dime el mes");
											mes = teclado.nextInt();
											System.out.println("Dime el dia");
											dia = teclado.nextInt();
										}while(!Utilidades.ValidarFecha(anio,mes,dia));
										//DiasFaltan*
										diasFaltan = Utilidades.diasQueFaltan(dia,mes,anio);
										//MostrarResultado  DiasFaltan
										System.out.println("Los dias que faltan son: "+diasFaltan);
									break;
									
									case 2:
										//AnteriorFechaValida
										
										//LeeryValidarFecha
										do{
											System.out.println("Dime el anio");
											anio = teclado.nextInt();
											System.out.println("Dime el mes");
											mes = teclado.nextInt();
											System.out.println("Dime el dia");
											dia = teclado.nextInt();
										}while(!Utilidades.ValidarFecha(anio,mes,dia));
										
										//PrevDate*
										Utilidades.PrevDate(dia,mes,anio);
									break;
									
									case 3:
										//SemanaAgno
										System.out.println("En construccion");
									break;
								}
							}
						}while(opcionSubMenu1 !=0);
					break;
					
					case 2:
						//PintarFiguras
						//OperacionesFechas
						do{
							//MostrarMenu, leeryValidarOpcionSubMenu1
							do{
								System.out.println("1- Pintar Piramide");
								System.out.println("2- Pintar Prisma");
								System.out.println("0- Volver atras");
								System.out.println("");
								opcionSubMenu2 = teclado.nextInt();
							}while(opcionSubMenu2 <0 || opcionSubMenu2 > 3);
							
							if(opcionSubMenu2 !=0){
								switch(opcionSubMenu2){
									case 1:
										//PintarPiramide
										
										//LeerCaracter
										System.out.println("Dime el caracter para la base de la piramide");
										base = teclado.next().charAt(0);
										//LeeryValidarAltura
										do{
											System.out.println("Dime la altura de la piramide");
											altura = teclado.nextInt();
										}while(altura < 2 || altura > 9);
										//PintarPiramide*
										Utilidades.PintarPiramide(base, altura);
									break;
									
									case 2:
										//PintarPrisma
										System.out.println("En construccion");
									break;
									
								}
							}
						}while(opcionSubMenu2 !=0);
					break;
				}
			}
			
			
		}while(opcionMenu != 0);
	}
}
