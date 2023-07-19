package main;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import constructores.ClienteAbstractBuilder;
import constructores.ClienteBuilder;
import directores.DirectorCliente;
import objetos.Cliente;
import objetos.Nave;

public class Main {

        public static void main(String[] args) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Crear el Builder del cliente
            ClienteAbstractBuilder clienteBuilder = new ClienteBuilder();

            // Crear el Director del cliente
            DirectorCliente directorCliente = new DirectorCliente();
            directorCliente.setBuilder(clienteBuilder);

            try {
                // Ingresar información del cliente
                System.out.println("Ingrese los datos del cliente:");
                System.out.print("Número telefónico: ");
                String numeroTelefonico = reader.readLine();
                System.out.print("Nombre: ");
                String nombre = reader.readLine();
                System.out.print("Apellido 1: ");
                String apellido1 = reader.readLine();
                System.out.print("Apellido 2: ");
                String apellido2 = reader.readLine();

                // Configurar el Builder con la información del cliente
                clienteBuilder.agregarNumeroTelefonico(numeroTelefonico);
                clienteBuilder.agregarNombre(nombre);
                clienteBuilder.agregarApellido1(apellido1);
                clienteBuilder.agregarApellido2(apellido2);

                // Agregar lista de naves
                System.out.println("Ingrese la información de las naves (Ingrese '0' para dejar de agregar naves):");
                agregarNaves(clienteBuilder, reader);

                // Obtener el objeto Cliente construido
                Cliente cliente = clienteBuilder.getCliente();

                // Mostrar los datos ingresados
                System.out.println("Datos del cliente:");
                System.out.println("Número telefónico: " + cliente.getNumeroTelefonico());
                System.out.println("Nombre: " + cliente.getNombre());
                System.out.println("Apellido 1: " + cliente.getApellido1());
                System.out.println("Apellido 2: " + cliente.getApellido2());
                System.out.println("Lista de naves: " + cliente.getListaNaves());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static void agregarNaves(ClienteAbstractBuilder clienteBuilder, BufferedReader reader) throws IOException {
            while (true) {
                System.out.print("Categoría: ");
                String categoria = reader.readLine();
                if (categoria.equals("0")) {
                    break;
                }
                System.out.print("Marca: ");
                String marca = reader.readLine();
                System.out.print("Modelo: ");
                String modelo = reader.readLine();
                System.out.print("Año: ");
                int anio = Integer.parseInt(reader.readLine());
                System.out.print("Código de identificación: ");
                String codigoIdentificacion = reader.readLine();
                System.out.print("Color: ");
                String color = reader.readLine();

                // Crear la nave y agregarla al Builder del cliente
                Nave nave = new Nave(categoria, marca, modelo, anio, codigoIdentificacion, color);
                clienteBuilder.agregarListaNaves(nave);
            }
        }
    }
