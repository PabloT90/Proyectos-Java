package com.company.Clases;

import java.io.*;
import java.util.*;

public class Gestora {

    private static ArrayList<Jugador> jugadoresPartida = new ArrayList<>(); //Creo que asi se me simplifica todo bastante
    private static ArrayList<Jugador> copiaJugadores = new ArrayList<>(); //Aqui guardo una copia de los jugadores para luego mostrar las muertes de cada jugador.

    /**
     * Cuenta las kills que se ha hecho un participante en la partida.
     * @param ID ID del participante al que queremos consultar su rendimiento en la partida.
     * @return El numero de kills.
     */
    public static int killsParticipante(int ID){
        String IDJugador = String.valueOf(ID);
        int kills = 0;

        //Leer la copia de los jugadores e imprimir los que en su nombre tengan el ID recibido como parametro
        for(int i = 0; i < copiaJugadores.size(); i++){
            if(copiaJugadores.get(i).getNombre().equals(IDJugador)){
                kills++;
            }
        }
        return kills;
    }

    /**
     * Cambia el nombre del jugador2 al ID del jugador que lo ha matado
     * @param j1 Jugador 1
     * @param j2 Jugador 2
     */
    public static void registrarKill(Jugador j1, Jugador j2){
        String nombre = String.valueOf(j1.getID());
        j2.setNombre(nombre);
    }

    /**
     * Comprueba si un jugador ha participado en la partida.
     * @param ID ID del jugador.
     * @param lista Lista de los participantes.
     * @return True si ha participado, false en caso contrario.
     */
    public static boolean haParticipado(int ID, ArrayList<Integer> lista){
        boolean participado = false;

        if(lista.contains(ID)){
            participado = true;
        }

        return participado;
    }

    /**
     * Muestra los jugadores que quedan.
     * @return cantidad de jugadores restantes
     */
    public static int jugadoresRestantes(){
        return jugadoresPartida.size();
    }

    /**
     * Muestra al ganador de la partida.
     */
    public static void mostrarGanador(){
        Jugador jugador = new Jugador();
        jugador = jugadoresPartida.get(0); //El ganador de la partida sera el que una vez acabado el bucle de los enfrentamientos quede en el array, pues se van eliminando de este conforme van perdiendo.
        System.out.println("  ****************************************************");
        System.out.println("*** El ganador ha sido: "+jugador.getNombre()+"  con una tasa de letalidad de " + jugador.getLetalidad()+" ***");
        System.out.println("  ****************************************************");
    }

    /**
     * Enfrenta a 2 oponentes.
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
            posVictoria1 = rd.nextInt(10);
            posVictoria2 = rd.nextInt(10);

            //Le sumo el valor de letalidad de cada uno.
            posVictoria1 += jugador1.getLetalidad();
            posVictoria2 += jugador2.getLetalidad();
        }while(posVictoria2 == posVictoria1); //Asi me aseguro que se generan numero diferentes.

        //Incrementar letalidad al ganador
        if(posVictoria1 > posVictoria2) {
            System.out.println("------------------------------");
            System.out.println("El jugador "+ jugador1.getNombre()+ " ha matado a "+ jugador2.getNombre()+".");
            incrementarLetalidad(jugador1);
            //Elimino al jugador del array.
            jugadoresPartida.remove(jugador2);

            //registrarKill
            registrarKill(jugador1, jugador2);
        }else{
            System.out.println("------------------------------");
            System.out.println("El jugador "+ jugador2.getNombre()+ " ha matado a "+ jugador1.getNombre()+".");
            incrementarLetalidad(jugador2);
            //Elimino al jugador del array.
            jugadoresPartida.remove(jugador1);

            //registrarKill
            registrarKill(jugador2, jugador1);
        }
    }

    /**
     * Incrementa la letalidad de un jugador 1 punto.
     * @param jugador Jugador al que aumentar su letalidad.
     */
    public static void incrementarLetalidad(Jugador jugador){
        jugador.setLetalidad(jugador.getLetalidad()+1);
        System.out.println("Letalidad incrementada al conseguir una Kill.");
    }

    /**
     * Muestra los participantes que van a jugar la partida.
     * @param lista Lista con los ID de los participantes. La lista debe estar ordenada de menor a mayor.
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
        copiaJugadores = (ArrayList<Jugador>) jugadoresPartida.clone(); //Copio los jugadores de la partida.

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
     * @return Array con todos los jugadores de la partida.
     */
    public static ArrayList<Jugador> insertarJugadores(ArrayList<Integer> lista) {
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
     * @return True en caso de crear el fichero. False en caso en que ya este creado el fichero.
     */
    public static boolean ajustesEncabezamiento(){
        boolean ret = false;
        File listaJugadores = new File("listaJugadores.dat");

        if(!listaJugadores.isFile()){
            crearFichero("listaJugadores.dat");
            ret = true;
        }

        return ret;
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
