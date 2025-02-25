/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.velascirios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Datos {
    private static final String URL = "postgresql://postgres:AkUVKvfvREvkMkTpbIRivNHjsNIQCtHq@junction.proxy.rlwy.net:28819/railway";
    private static final String USUARIO = "postgres";
    private static final String PASSWORD = "AkUVKvfvREvkMkTpbIRivNHjsNIQCtHq";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USUARIO, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
            return null;
        }
    }
}
