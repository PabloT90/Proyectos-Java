package com.company.Clases;

import java.io.*;
import java.util.*;

public class Gestora {

    private static ArrayList<Jugador> jugadoresPartida = new ArrayList<>(); //Creo que asi se me simplifica todo bastante
    /**
     * Enfrenta a 2 oponentes.
     * @param lista Lista con todos los jugadores.
     */
    public static void enfrentarOponentes(){
        Random rd = new Random();
        Jugador jugador1 = null, jugador2 = null;
        int ID1, ID2;
        int posVictoria1 = 0, posVictoria2 = 0; //Posibilidad de victoria de cada uno de los 2 oponentes

        //Generar 2 numeros aleatorios que no sean el mismo entre 0 y 20.
        do {
            ID1 = rd.nextInt(jugadoresPartida.size()); //Posicion que ocupa un jugador en la lista.
            ID2 = rd.nextInt(jugadoresPartida.size());
        }while(ID1 == ID2); //Asi me aseguro que se generan numero diferentes.

        //Obtener los 2 jugadores.
        jugador1 = jugadoresPartida.get(ID1);
        jugador2 = jugadoresPartida.get(ID2);

        //Para decidir un enfrentamiento lo hare mediante un numero aleatorio entre 0 y 10 y le sumare la letalidad del jugador, el que obtenga el valor mas alto gana.
        do {
            posVictoria1 = rd.nextInt(jugadoresPartida.size()); //Posicion que ocupa un jugador en la lista.
            posVictoria2 = rd.nextInt(jugadoresPartida.size());

            //Le sumo el valor de letalidad de cada uno.
            posVictoria1 += jugador1.getLetalidad();
            posVictoria2 += jugador2.getLetalidad();
        }while(posVictoria2 == posVictoria1); //Asi me aseguro que se generan numero diferentes.

        //Incrementar letalidad al ganador
        if(posVictoria1 > posVictoria2)
            incrementarLetalidad(jugador1);
        else
            incrementarLetalidad(jugador2);
    }

    //No se si esto funcionara asi xd
    public static void incrementarLetalidad(Jugador jugador){
        jugador.setLetalidad(jugador.getLetalidad()+1);
        System.out.println("Letalidad incrementada al conseguir una Kill.");
    }

    /**
     * Muestra los participantes que van a jugar la partida.
     * @param listaJugadores Jugadores que la van a jugar
     */
    public static void mostrarParticipantes(ArrayList<Integer> lista) {
        int i = 0;
        Jugador player = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ArrayList listaJugadores = new ArrayList();

        try {
            fis = new FileInputStream("listaJugadores.dat");
            ois = new ObjectInputStream(fis);

            player = (Jugador) ois.readObject();
            while (i < lista.size()) {//mientras haya numeros en la lista
                if (player.getID() == lista.get(i)) { //Si los ID coinciden se inserta el jugador.
                    System.out.println(player.toStringBonito());
                    i++; //Incrementamos el valor de i para recorrer el array.
                } else {
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
    * Esta funcion solo llama a otras funciones y ordena una lista de manera ascendente.
    * @return lista ordenada de los jugadores de manera ascendente segun su ID.
    * */
    public static ArrayList<Integer> establecerJugadores(){
        ArrayList lista;
        lista = obtenerParticipantes();
        Collections.sort(lista); //Ordenamos el array para que al buscar a los oponentes en el fichero sea mas rapido y facil.
        jugadoresPartida = insertarJugadores(lista);

        return lista;
    }

    /**
    * Esta funcion obtiene el ID de 20 jugadores de los 40 disponibles. Se hace de forma aleatoria.
    * @return ArrayList con 20 ID aleatorios de los jugadores.
    * */
    public static ArrayList<Integer> obtenerParticipantes(){
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
     * Esta funcion inserta una lista de participantes en el array de jugadores
     * @param lista Contiene el ID de los participantes
     */
    public static ArrayList<Jugador> insertarJugadores(ArrayList<Integer> lista) {
        int i=0;
        Jugador player = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ArrayList listaJugadores = new ArrayList();

        try {
            fis = new FileInputStream("listaJugadores.dat");
            ois = new ObjectInputStream(fis);

            player = (Jugador) ois.readObject();
            while (i < lista.size()) {//mientras haya numeros en la lista
                if (player.getID() == (int)lista.get(i)) { //Si los ID coinciden se inserta el jugador.
                    listaJugadores.add(player);
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
        return listaJugadores;
    }

    /**
     * Inserta jugadores en el fichero Jugadores.dat
     * @param menu Menú que queremos insertar.
     */
    public static void rellenarLista(){
        Jugador j0 = new Jugador(0, "Junkrat", 0, 0);
        Jugador j1 = new Jugador(1, "Pablo Prats", 0, 0);
        Jugador j2 = new Jugador(2, "Jesus de Ubrique", 0, 0);
        Jugador j3 = new Jugador(3, "Ana Obregon", 0, 0);
        Jugador j4 = new Jugador(4, "Ibai Llanos", 0, 0);
        Jugador j5 = new Jugador(5, "AuronPlay", 0, 0);
        Jugador j6 = new Jugador(6, "Wismichu", 0, 0);
        Jugador j7 = new Jugador(7, "Alexelcapo", 0, 0);
        Jugador j8 = new Jugador(8, "Belen Esteban", 0, 0);
        Jugador j9 = new Jugador(9, "Asen Rise", 0, 0);
        Jugador j10 = new Jugador(10, "Garou", 0, 0);
        Jugador j11 = new Jugador(11, "Saitama", 0, 0);
        Jugador j12 = new Jugador(12, "Yuno", 0, 0);
        Jugador j13 = new Jugador(13, "Asta", 0, 0);
        Jugador j14 = new Jugador(14, "Ichigo", 0, 0);
        Jugador j15 = new Jugador(15, "Bang", 0, 0);
        Jugador j16 = new Jugador(16, "Tatsumaki", 0, 0);
        Jugador j17 = new Jugador(17, "Silver Fang", 0, 0);
        Jugador j18 = new Jugador(18, "Ash", 0, 0);
        Jugador j19 = new Jugador(19, "Dr Stone", 0, 0);
        Jugador j20 = new Jugador(20, "Genos", 0, 0);
        Jugador j21 = new Jugador(21, "Jiraya", 0, 0);
        Jugador j22 = new Jugador(22, "Sasuke", 0, 0);
        Jugador j23 = new Jugador(23, "Naruto", 0, 0);
        Jugador j24 = new Jugador(24, "Deidara", 0, 0);
        Jugador j25 = new Jugador(25, "Tsunade", 0, 0);
        Jugador j26 = new Jugador(26, "Sakura", 0, 0);
        Jugador j27 = new Jugador(27, "Itachi", 0, 0);
        Jugador j28 = new Jugador(28, "Konohamaru", 0, 0);
        Jugador j29 = new Jugador(29, "Orochimaru", 0, 0);
        Jugador j30 = new Jugador(30, "Kaido", 0, 0);
        Jugador j31 = new Jugador(31, "Nami", 0, 0);
        Jugador j32 = new Jugador(32, "Brook", 0, 0);
        Jugador j33 = new Jugador(33, "Franky", 0, 0);
        Jugador j34 = new Jugador(34, "Big Mom", 0, 0);
        Jugador j35 = new Jugador(35, "Ron Lucci", 0, 0);
        Jugador j36 = new Jugador(36, "Blueno", 0, 0);
        Jugador j37 = new Jugador(37, "Batman", 0, 0);
        Jugador j38 = new Jugador(38, "Superman", 0, 0);
        Jugador j39 = new Jugador(39, "Roadhog", 0, 0);

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

        if(!listaJugadores.isFile()){
            crearFichero("listaJugadores.dat");
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
