public class Utilidades{
	
		/* ValidarFecha
		 * Nec: entero anio, entero mes, entero dia.
		 * Dev: logico valido.
		 * Nec/Dev: nada.
		 * Restricciones: no hay.
		 * 
		 * Estudio Java
		 * Comentario: verifica si una fecha es correcta o no. 
		 * Precondiciones: no hay.
		 * Entrada: int anio, int mes, int dia. Se pasan por valor.
		 * Salida: boolean valido.
		 * Postcondiciones: asociado al nombre se manda un boolean. true en caso de ser valida, false en caso contrario
		 * Cabecera: boolean ValidarFecha(int anio, int mes, int dia)
		 * 
		 * */
		/*public static boolean ValidarFecha(int anio, int mes, int dia){
			System.out.println("En resguardo");
			return true;
		}*/
		
		public static boolean ValidarFecha(int anio, int mes, int dia){
			boolean valido = false;
			
			if(anio >= 1582 && mes >= 1 && mes <= 12 && dia >= 1){
				switch(mes) {
					case 1: case 3: case 5: case 7: case 8: case 10: case 12:
						if (dia <= 31)
							valido = true;
					break;

					case 2:
						if (dia <= (28 + (esBisiesto(anio) ? 1 : 0)))
							valido = true;
					break;

					default:
						if (dia <= 30)
							valido = true;
					break;
				}
			}
        return valido;
		}
			
			 
	/* esBisiesto
		Nec: entero anio
		Dev: logico isBisiesto
		Nec/Dev: nada.
		Requisitos: el anio debe ser mayor que 1582.

		Interfaz
		Comentario: verifica si un anio es bisiesto o no.
		Precondiciones: el anio debe ser mayor que 1582..
		Entrada: entero anio. Se pasa por valor
		Salida: logico isBisiesto
		Postcondiciones: asociado al nombre se manda si es bisiesto o no. True en caso de serlo, false en caso contrario.
		Cabecera: boolean esBisiesto(int anio)
		* */
		/*public static boolean esBisiesto(int anio){
			System.out.println("En resguardo");
			return true;
		}*/
		
		public static boolean esBisiesto(int anio){
			boolean isBisiesto=false;

			if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) 
				isBisiesto = true;

			return isBisiesto;
		}
		 
		 /* PrevDate
		  Nec: nada.
		  Dev: nada.
		  Nec/Dev: una fecha (entero day, entero month, entero year) se pasan por referencia. No podemos asi que al estudiar la interfaz java lo haremos por valor
		  Restricciones: la fecha debe ser valida.
		  
		  Estudio Java
		  Comentario: dada un fecha nos da la inmediatamente anterior valida.
		  Precondiciones: la fecha debe ser valida.
		  Entrada: entero year, entero month, entero day. Se pasan por valor.
		  Salida: nada.
		  Postcondiciones: nada, solo pinta en pantalla.
		  Cabecera: void PrevDate(int day, int month, int year)
		 * */
		 /*public static void PrevDate(int day, int month, int year){
			 System.out.println("En construccion");
		 }*/
		 public static void PrevDate(int day, int month, int year){
			 int mesCopia= month,anioCopia= year-1;
			 if(day<=1){
				 month--;
				 day=DiaMes(month,year);
			 }else if(day>1)
				day--;
			  else if(month<=1){
				 year--; 
				 month=12;
			 }else if(month >1) 
				month--;
			if(day<=1 && mesCopia<=1){
				year= anioCopia;
				month=12;
				day= 31;
			}
				System.out.println("La fecha anterior es: "+day+"/"+month+"/"+year);
		 }
		 
		 
		  /* diasQueFaltan
		  Nec: entero anio, entero mes, entero dia
		  Dev: entero diasFaltantes
		  Nec/Dev: nada.
		  Restricciones: la fecha debe ser valida
		  
		  Estudio Java
		  Comentario: dada una fecha nos calcula la cantidad de dias que quedan para el 31 de diciembre del año dado.
		  Precondiciones: la fecha debe ser valida.
		  Entrada: int anio, int mes, int dia. Se pasan por valor.
		  Salida: int diasFaltantes.
		  Postcondiciones: asociado al nombre se manda la cantidad de dias que faltan.
		  Cabecera: int diasQueFaltan(int dia, int mes, int anio)
		 * */
		 /*public static int diasQueFaltan(int dia, int mes, int anio){
			 System.out.println("En construccion");
			 return 1;
		 }*/
		 public static int diasQueFaltan(int dia, int mes, int anio){
		int diasFaltantes = 0;
        while(mes != 12 || dia != 31){
            switch(mes){
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    if(dia < 31){
                        dia++;
                    }else{
                        dia = 1;
                        mes++;
                    }
                    break;

                case 2:
                    if(esBisiesto(anio)){
                        if(dia < 29){
                            dia++;
                        }else{
                            dia = 1;
                            mes++;
                        }
                    }else{
                        if(dia < 28){
                            dia++;
                        }else{
                            dia = 1;
                            mes++;
                        }
                    }
                    break;

                case 4: case 6: case 9: case 11:
                    if(dia < 30){
                        dia++;
                    }else{
                        dia = 1;
                        mes++;
                    }
                    break;
            }
            diasFaltantes++;
        }
        return diasFaltantes;
    }
		 
		 
		 /* PintarPiramide
		  Nec: caracter base,  entero altura.
		  Dev: nada.
		  Nec/Dev: nada.
		  Restricciones: la altura debe estar entre 2 y 9, el caracter debe ser imprimible.
		  
		  Estudio Java
		  Comentario: pinta una piramide de una altura dada sobre una base de un caracter dado.
		  Precondiciones: la altura debe estar entre 2 y 9, el caracter debe ser imprimible.
		  Entrada: caracter base, entero altura.
		  Salida: nada.
		  Postcondiciones: nada, solo pinta en pantalla.
		  Cabecera: void PintarPiramide (char base, int altura)
		 * */
		 /*public static void PintarPiramide (char base, int altura){
			 System.put.println("En resguardo");
		 }*/
		 public static void PintarPiramide (char base, int altura){
			 System.out.println("Aqui deberia aparecer una piramide de altura: "+altura+ " y de base: " + base);
		 }
		 
		 /* DiaMes
		  Nec: entero mes, entero anio
		  Dev: entero diasDelMes
		  Nec/Dev: nada.
		  Restricciones:  el mes y el anio deben ser correctos
		  
		  Estudio Java
		  Comentario: simplemente nos dice la cantidad de dias que tiene un mes.
		  Precondiciones: el mes y el anio deben ser correctos
		  Entrada: entero mes, entero anio
		  Salida: entero diasDelMes
		  Postcondiciones: asociado al nombre se manda la cantidad de dias que tiene un mes.
		  Cabecera: int DiaMes(int mes,int anio)
		 * */
		 /*public static int DiaMes(int mes,int anio){
			 System.out.println("En construccion");
			 return 1;
		 }*/
		 
		 public static int DiaMes(int mes,int anio){
			 int diasDelMes=0;
			 switch(mes){
				 case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				 diasDelMes=31;
				 break;
				 
				 case 2:
                    if(esBisiesto(anio)){
                       diasDelMes = 29;
                    }else diasDelMes =28;
                    break;
                    
                 case 4: case 6: case 9: case 11:
					diasDelMes=30;
                 break;
			 }
			 return diasDelMes;
		 }
	
}
