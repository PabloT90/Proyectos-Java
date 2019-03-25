package com.company;
import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try {
            //FileWriter fw = new FileWriter("C:\\Users\\elmal\\Desktop\\ejemplos\\precentasion.txt");
            //FileReader fr = new FileReader("C:\\Users\\elmal\\Desktop\\ejemplos\\precentasion.txt");
            //BufferedReader br = new BufferedReader(fr);
            //BufferedWriter bw = new BufferedWriter(fw);
            Scanner teclado = new Scanner(System.in);

            //Forma abreviada
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\elmal\\Desktop\\ejemplos\\precentasion.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\elmal\\Desktop\\ejemplos\\precentasion.txt", true)); //Asi no sobreescribe lo que ya hay escrito
            //BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\elmal\\Desktop\\ejemplos\\precentasion.txt")); //Asi sobreescribe lo que haya escrito

            //Primero vamos a escribir lo que sea
            System.out.println("Escribe lo que quieras: ");
            bw.write(teclado.nextLine());
            bw.newLine(); //Añade una nueva linea con un separador de linea, en este caso con un ENTER
            bw.write("Esto es una prueba");
            bw.newLine();
            bw.flush();
            bw.close();

            //Este lee cada linea del fichero.
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }

            //Este lee cada caracter del fichero
            int i;
            while((i=br.read())!=-1){
                System.out.print((char)i);
            }

            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}