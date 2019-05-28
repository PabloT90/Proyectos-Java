package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection conexion;
        Statement sentencia;
        ResultSet resultado;
        String consulta = "SELECT ID, Palabra FROM Palabras";
        Utilidades conexiones = new Utilidades();

        conexion = conexiones.iniciarConexion();
        sentencia = conexiones.crearSentencia(conexion);
        resultado = conexiones.usarSentencia(sentencia, consulta);

        try {
            while (resultado.next()) {
                System.out.println("ID: " + resultado.getShort("ID") + ", Palabra: " + resultado.getString("Palabra"));
            }
        }catch(SQLException err) {
            err.printStackTrace();
        }finally {
            conexiones.cerrarTodo(sentencia,resultado,conexion);
        }

    }
}