package com.company;
import java.sql.*;

public class Utilidades {
    /*
    Interfaz
    Nombre: iniciarConexion
    Comentario: Este subprograma inicia la conexion con la base de datos
    Cabecera: public Connection iniciarConexion()
    Precondiciones: No hay
    Entrada: No hay
    Salida: - Connection conexion //El objeto para usar la conexion
    E/S: No hay
    Postcondiciones: Iniciaria la conexion con la base de datos
     */
    public Connection iniciarConexion() {
        String sourceURL = "jdbc:sqlserver://localhost:1433";
        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection(sourceURL, "pablete", "qq");
        }catch (SQLException err) {
            err.printStackTrace();
        }
        return conexion;
    }

    /*
    Interfaz
    Nombre: crearSentencia
    Comentario: Este subprograma crea la sentencia para usarla en cualquier instruccion de sql
    Cabecera: public Statement crearSentencia(Connection conexion)
    Precondiciones: No hay
    Entrada: - Connection conexion //Es el objeto que tiene la conexion
    Salida: - Statement sentencia //El objeto para usar cualquier sentencia de sql
    E/S: No hay
    Postcondiciones: Asociado al nombre, crearia la sentencia para realizar cualquier instruccion de sql
    */
    public Statement crearSentencia(Connection conexion) {
        Statement sentencia = null;
        try {
            sentencia = conexion.createStatement();
        }catch (SQLException err) {
            err.printStackTrace();
        }
        return sentencia;
    }

    /*
    Interfaz
    Nombre: usarSentencia
    Comentario: Este subprograma usa la sentencia y la ejecuta
    Cabecera: public ResultSet usarSentencia(Statement sentencia, String consulta)
    Precondiciones: No hay
    Entrada:  - Statement sentencia //El objeto para usar cualquier sentencia de sql
              - String consulta //Un String con la consulta
    Salida: - ResultSet //El resultado de la consulta
    E/S: No hay
    Postcondiciones: Asociado al nombre, El resultado de la consulta
    */
    public ResultSet usarSentencia(Statement sentencia, String consulta) {
        ResultSet resultado = null;

        try{
            resultado = sentencia.executeQuery(consulta);
        }catch (SQLException err) {
            err.printStackTrace();
        }
        return resultado;
    }


    /*
    Interfaz
    Nombre: cerrarTodo
    Comentario: Este subprograma cierra todos los flujos abiertos
    Cabecera: public void cerrarTodo(Statement sentencia, ResultSet resultado, Connection conexion)
    Precondiciones: No hay
    Entrada:  - Statement sentencia //El objeto para usar cualquier sentencia de sql
              - ResultSet //El resultado de la consulta
              - Connection conexion //El objeto para usar la conexion
    Salida: No hay
    E/S: No hay
    Postcondiciones: Solo cierra el flujo de todo lo que teniamos abiertos con anterioridad
    */
    public void cerrarTodo(Statement sentencia, ResultSet resultado, Connection conexion) {
        try {
            sentencia.close();
            resultado.close();
            conexion.close();
        }catch (SQLException err) {
            err.printStackTrace();
        }
    }
}