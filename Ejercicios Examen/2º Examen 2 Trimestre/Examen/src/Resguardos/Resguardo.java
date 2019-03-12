package Resguardos;
import java.util.Scanner;

import Clases.Fecha;
import Clases.ImplFicha;
import Enums.EnumActividad;
public class Resguardo {
	 /* Esta funcion muestra si quiere añadir, lee y valida si quiere.
     * Entrada: ---
     * Precondiciones: ---
     * Salida: char ejecutar
     * Postcondiciones: asociado al nombre se envia el caracter elegido valido.
     * Cabecera:  public char LeerValidarAnadirFicha()()
     * */
    public char LeerValidarAnadirFicha(){
        char anadir = 's';
        	System.out.println("En resguardo");
        return anadir;
    }
    
    /* Esta funcion crea el perfil de la ficha
     * Entrada: ---
     * Precondiciones: ---
     * Salida: ImplFicha ficha
     * Postcondiciones: asociado al nombre se manda la ficha
     * Cabecera: public ImplFicha CrearFicha()
     * */
    public ImplFicha CrearFicha(){
       ImplFicha ficha = new ImplFicha();
       System.out.println("En resguardo");
       return ficha;
    }
    
    /* Esta funcion lee y valida la duracion.
     * Entrada: ---
     * Precondiciones: ---
     * Salida: int duracion
     * Postcondiciones: asociado al nombre se envia la duracion.
     * Cabecera:  public int LeerValidarDuracion()
     * */
    public int LeerValidarDuracion(){
        int duracion =0;
        System.out.println("En resguardo");
        return duracion;
    }
    
    
    /* Esta funcion muestra un menu, lee y valida la opcion elegida.
     * Entrada: ---
     * Precondiciones: ---
     * Salida: int opMenu
     * Postcondiciones: asociado al nombre se envia la opcion elegida
     * Cabecera: public int MostrarLeerValidarMenu()
     * */
    public int MostrarLeerValidarMenu(){
        int opMenu = 1;
        System.out.println("En resguardo");
        return opMenu;
    }
    
    /* Esta funcion muestra las fichas que tienen el mismo nivel de actividad.
     * Entrada: ImplFicha[] lista, String actividad.
     * Precondiciones: el array no puede estar vacio.
     * Salida: nada.
     * Postcondiciones: nada, solo muestra en pantalla.
     * Cabecera: public void MostrarMismoNivelActividad(ImplFicha[] lista)
     * */
    public void MismoNivelActividad(String actividad, ImplFicha[] lista){
       System.out.println("En construccion");
    }
    
    
    /* Esta funcion calcula los socios que han realizado una actividad en particular.
     * Entrada: String actividad, ImplFicha lista
     * Precondiciones: actividad solo puede ser Alto, Medio, Bajo. La lista no puede estar vacia.
     * Salida: nada.
     * Postcondiciones: nada, solo muestra en pantalla.
     * Cabecera: public void MostrarActividadParticular(String actividad, ImplFicha[] lista)
     * */
    public void MostrarActividadParticular(String actividad, ImplFicha[] lista){
      System.out.println("En construccion");
    }
    
    
    /* Esta funcion lee y valida la actividad.
     * Entrada: ---
     * Precondiciones: ---
     * Salida: String actividad
     * Postcondiciones: asociado al nombre se envia la actividad elegida
     * Cabecera: public String LeerValidarActividad()
     * */
    public String LeerValidarActividad(){
        return "En construccion";
    }
}