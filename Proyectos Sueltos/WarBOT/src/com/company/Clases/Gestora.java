package com.company.Clases;

import java.io.*;
import java.util.*;

public class Gestora {
    /**
     * Lee el fichero participantes.dat para mostrar los datos en el.
     */
    public static void mostrarParticipantes(){
        Jugador j1 = null;
        FileInputStream fis1 = null;
        ObjectInputStream ois1 = null;

        try {
            fis1 = new FileInputStream("participantes.dat");
            ois1 = new ObjectInputStream(fis1);

            while (true) {//Mientras no haya ningún fin de fichero
                j1 = (Jugador) ois1.readObject();
                System.out.println(j1.toStringBonito());
            }
        }catch (EOFException error){
        }catch (IOException error2){
            error2.printStackTrace();
        }catch (ClassNotFoundException error3){
            error3.printStackTrace();
        }finally {
            try{
                ois1.close();
                fis1.close();
            }catch (IOException error){
                error.printStackTrace();
            }
        }
    }

    /**
    * Esta funcion solo llama a otras funciones y ordena una lista de manera ascendente.
    * @return lista ordenada de los jugadores de manera ascendente segun su ID.
    * */
    public static ArrayList establecerJugadores(){
        ArrayList lista;
        lista = obtenerParticipantes();
        Collections.sort(lista); //Ordenamos el array para que al buscar a los oponentes en el fichero sea mas rapido y facil.
        insertarJugadores(lista);

        return lista;
    }

    /**
    * Esta funcion obtiene el ID de 20 jugadores de los 40 disponibles. Se hace de forma aleatoria.
    * @return ArrayList con 20 ID aleatorios de los jugadores.
    * */
    public static ArrayList obtenerParticipantes(){
        int pos;
        int nID = 41;
        ArrayList<Integer> sID = new ArrayList<>();

        for (int i = 0; i < nID ; i++) {
            if(sID.size() < 20) {
                pos = (int) Math.floor(Math.random() * nID);
                while (sID.contains(pos)) {
                    pos = (int) Math.floor(Math.random() * nID);
                }
                sID.add(pos);
            }
        }
        return sID;
    }

    /**
     * Esta funcion inserta una lista de participantes en el fichero participantes.dat
     * @param lista Contiene el ID de los participantes
     */
    public static void insertarJugadores(ArrayList lista) {
        int i=0;
        Jugador player = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("listaJugadores.dat");
            ois = new ObjectInputStream(fis);

            player = (Jugador) ois.readObject();
            while (i < lista.size()) {//mientras haya numeros en la lista
                if (player.getID() == (int)lista.get(i)) { //Si los ID coinciden se inserta el jugador.
                    insertarParticipante(player);
                    i++; //Incrementamos el valor de i para recorrer el array.
                }else{
                    player = (Jugador) ois.readObject();
                }
            }
        } catch (EOFException error4) {
        } catch (IOException error2) {
            error2.printStackTrace();
        } catch (ClassNotFoundException error3) {
            error3.printStackTrace();
        } finally {
            try {
                ois.close();
                fis.close();
            } catch (IOException error) {
                error.printStackTrace();
            }
        }
    }

    /**
     * Inserta jugadores en el fichero participantes.dat
     * @param j1 Participante que queremos insertar.
     */
    public static void insertarParticipante(Jugador j1){
        MyObjectOutputStream moos = null;
        FileOutputStream fos = null;
        File fichero = new File("participantes.dat");

        try{
            fos = new FileOutputStream(fichero, true);
            moos = new MyObjectOutputStream(fos);
            moos.writeObject(j1);//Insertamos al participante en el fichero
        } catch(IOException error){
            error.printStackTrace();
        }finally {
            try {
                moos.close();
                fos.close();
            }catch (IOException error){
                error.printStackTrace();
            }
        }
    }

    /**
     * Inserta jugadores en el fichero Jugadores.dat
     * @param menu Menú que queremos insertar.
     */
    public static void rellenarLista(){
        Jugador j0 = new Jugador(0, "Junkrat", 0, true);
        Jugador j1 = new Jugador(1, "Pablo Prats", 0, true);
        Jugador j2 = new Jugador(2, "Jesus de Ubrique", 0, true);
        Jugador j3 = new Jugador(3, "Ana Obregon", 0, true);
        Jugador j4 = new Jugador(4, "Ibai Llanos", 0, true);
        Jugador j5 = new Jugador(5, "AuronPlay", 0, true);
        Jugador j6 = new Jugador(6, "Wismichu", 0, true);
        Jugador j7 = new Jugador(7, "Alexelcapo", 0, true);
        Jugador j8 = new Jugador(8, "Belen Esteban", 0, true);
        Jugador j9 = new Jugador(9, "Asen Rise", 0, true);
        Jugador j10 = new Jugador(10, "Garou", 0, true);
        Jugador j11 = new Jugador(11, "Saitama", 0, true);
        Jugador j12 = new Jugador(12, "Yuno", 0, true);
        Jugador j13 = new Jugador(13, "Asta", 0, true);
        Jugador j14 = new Jugador(14, "Ichigo", 0, true);
        Jugador j15 = new Jugador(15, "Bang", 0, true);
        Jugador j16 = new Jugador(16, "Tatsumaki", 0, true);
        Jugador j17 = new Jugador(17, "Silver Fang", 0, true);
        Jugador j18 = new Jugador(18, "Ash", 0, true);
        Jugador j19 = new Jugador(19, "Dr Stone", 0, true);
        Jugador j20 = new Jugador(20, "Genos", 0, true);
        Jugador j21 = new Jugador(21, "Jiraya", 0, true);
        Jugador j22 = new Jugador(22, "Sasuke", 0, true);
        Jugador j23 = new Jugador(23, "Naruto", 0, true);
        Jugador j24 = new Jugador(24, "Deidara", 0, true);
        Jugador j25 = new Jugador(25, "Tsunade", 0, true);
        Jugador j26 = new Jugador(26, "Sakura", 0, true);
        Jugador j27 = new Jugador(27, "Itachi", 0, true);
        Jugador j28 = new Jugador(28, "Konohamaru", 0, true);
        Jugador j29 = new Jugador(29, "Orochimaru", 0, true);
        Jugador j30 = new Jugador(30, "Kaido", 0, true);
        Jugador j31 = new Jugador(31, "Nami", 0, true);
        Jugador j32 = new Jugador(32, "Brook", 0, true);
        Jugador j33 = new Jugador(33, "Franky", 0, true);
        Jugador j34 = new Jugador(34, "Big Mom", 0, true);
        Jugador j35 = new Jugador(35, "Ron Lucci", 0, true);
        Jugador j36 = new Jugador(36, "Blueno", 0, true);
        Jugador j37 = new Jugador(37, "Batman", 0, true);
        Jugador j38 = new Jugador(38, "Superman", 0, true);
        Jugador j39 = new Jugador(39, "Roadhog", 0, true);

        MyObjectOutputStream moos = null;
        FileOutputStream fos = null;
        File fichero = new File("listaJugadores.dat");

        try{
            fos = new FileOutputStream(fichero, true);
            moos = new MyObjectOutputStream(fos);
            moos.writeObject(j0);
            moos.writeObject(j1);//Insertamos al jugador en el fichero
            moos.writeObject(j2);
            moos.writeObject(j3);
            moos.writeObject(j4);
            moos.writeObject(j5);
            moos.writeObject(j6);
            moos.writeObject(j7);
            moos.writeObject(j8);
            moos.writeObject(j9);
            moos.writeObject(j10);

            moos.writeObject(j11);
            moos.writeObject(j12);
            moos.writeObject(j13);
            moos.writeObject(j14);
            moos.writeObject(j15);
            moos.writeObject(j16);
            moos.writeObject(j17);
            moos.writeObject(j18);
            moos.writeObject(j19);
            moos.writeObject(j20);

            moos.writeObject(j21);
            moos.writeObject(j22);
            moos.writeObject(j23);
            moos.writeObject(j24);
            moos.writeObject(j25);
            moos.writeObject(j26);
            moos.writeObject(j27);
            moos.writeObject(j28);
            moos.writeObject(j29);
            moos.writeObject(j30);

            moos.writeObject(j31);
            moos.writeObject(j32);
            moos.writeObject(j33);
            moos.writeObject(j34);
            moos.writeObject(j35);
            moos.writeObject(j36);
            moos.writeObject(j37);
            moos.writeObject(j38);
            moos.writeObject(j39);
        } catch(IOException error){
            error.printStackTrace();
        }finally {
            try {
                moos.close();
                fos.close();
            }catch (IOException error){
                error.printStackTrace();
            }
        }
    }

    /**
     * Esta función crear los ficheros maestro y de movimiento con una cabecera válida para trabajar
     * con la clase ObjectStream, en caso de no existir.
     */
    public static void ajustesEncabezamiento(){
        File listaJugadores = new File("listaJugadores.dat");
        File participantes = new File("participantes.dat");

        if(!listaJugadores.isFile()){
            crearFichero("listaJugadores.dat");
        }
        if(!participantes.isFile()){
            crearFichero("participantes.dat");
        }
    }

    /**
     * Crea un fichero con una cabecera válida para evitar errores de lectura de la clase la clase ObjectInputStream.
     * @param direccion Path del fichero.
     */
    public static void crearFichero(String direccion){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try{
            fos = new FileOutputStream(direccion);
            oos = new ObjectOutputStream(fos);
        }catch(FileNotFoundException error){
            error.printStackTrace();
        }catch(IOException error2){
            error2.printStackTrace();
        }finally{
            try {
                fos.close();
                oos.close();
            }catch(IOException error3){
                error3.printStackTrace();
            }
        }
    }

}
