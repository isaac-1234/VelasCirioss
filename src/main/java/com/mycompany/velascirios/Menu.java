/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.velascirios;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void mostrarMenu() {
        while (true) {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Ver productos");
            System.out.println("2. Realizar un pedido");
            System.out.println("3. Registrar devolución");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    listarProductos();
                    break;
                case 2:
                    realizarPedido();
                    break;
                case 3:
                    registrarDevolucion();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void listarProductos() {
        List<String> productos = AccesoDatos.obtenerProductos();
        System.out.println("\n=== Lista de Productos ===");
        productos.forEach(System.out::println);
    }

    private static void realizarPedido() {
        System.out.print("Ingrese el nombre del cliente: ");
        String cliente = scanner.nextLine();
        
        if (AccesoDatos.insertarPedido(cliente)) {
            System.out.println("Pedido realizado con éxito.");
        } else {
            System.out.println("Error al realizar el pedido.");
        }
    }

    private static void registrarDevolucion() {
        System.out.print("ID del pedido: ");
        int ordenId = scanner.nextInt();
        System.out.print("ID del producto: ");
        int productoId = scanner.nextInt();
        System.out.print("Cantidad a devolver: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Motivo de devolución: ");
        String motivo = scanner.nextLine();

        if (AccesoDatos.registrarDevolucion(ordenId, productoId, cantidad, motivo)) {
            System.out.println("Devolución registrada correctamente.");
        } else {
            System.out.println("Error al registrar la devolución.");
        }
    }
}
