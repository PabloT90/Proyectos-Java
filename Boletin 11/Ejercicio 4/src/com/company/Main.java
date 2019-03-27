package com.company;

import java.io.*;
import java.util.Scanner;

/*
Enunciado: Realiza un programa para crear un fichero de texto que contenga las cadenas de caracteres suministradas desde
la línea de comandos, una en cada línea del fichero de texto.

Lo hare sin modular. Todo en el main, simplemente para practicar el manejo de ficheros.

CrearFichero
IntroducirDatos
CerrarFichero

 */
public class Main {
    public static void main(String[] args) {
        //CrearFichero
        BufferedWriter bw = null;
        Scanner teclado = new Scanner(System.in);

        try{
            bw = new BufferedWriter(new FileWriter("lecturasTeclado.txt", true)); //Asi me lo crea en la ruta principal de este proyecto.

            System.out.println("Escribe lo que quieras, se guardara en un archivo de texto.");
            bw.write(teclado.nextLine());
            bw.newLine(); //Para que al volver a abrirlo se escriba justo debajo.
            bw.flush();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                bw.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        //IntroducirDatos
        //CerrarFichero
    }
}