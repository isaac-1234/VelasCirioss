/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.velascirios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccesoDatos {
    
    // Obtener productos
    public static List<String> obtenerProductos() {
        List<String> productos = new ArrayList<>();
        String query = "SELECT nombre FROM productos";

        try (Connection conn = Datos.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                productos.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener productos: " + e.getMessage());
        }

        return productos;
    }

    // Insertar pedido
    public static boolean insertarPedido(String cliente) {
        String query = "INSERT INTO ordenes_compra (cliente) VALUES (?)";

        try (Connection conn = Datos.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, cliente);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar pedido: " + e.getMessage());
            return false;
        }
    }

    // Registrar devolución
    public static boolean registrarDevolucion(int ordenId, int productoId, int cantidad, String motivo) {
        String query = "INSERT INTO condiciones_entrega (orden_id, producto_id, cantidad, motivo) VALUES (?, ?, ?, ?)";

        try (Connection conn = Datos.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, ordenId);
            stmt.setInt(2, productoId);
            stmt.setInt(3, cantidad);
            stmt.setString(4, motivo);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al registrar devolución: " + e.getMessage());
            return false;
        }
    }
}
