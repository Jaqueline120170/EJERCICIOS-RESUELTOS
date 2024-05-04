package utilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

import controladores.Inicio;
import dtos.BibliotecaDto;
import dtos.ClienteDto;
import dtos.LibroDto;
import dtos.PrestamoDto;

public class GestorFicheros {
	
	public static void accesoAFicheros(String rutaFicheroGeneral) {
        File archivo = new File(rutaFicheroGeneral);
        if (archivo.exists()) {
            try {
                String[] contenidoFichero = Files.readAllLines(Paths.get(rutaFicheroGeneral)).toArray(new String[0]);

                for (String fichero : contenidoFichero) {
                    String[] lineasContenido = fichero.split(";");
                    BibliotecaDto biblioteca1 = new BibliotecaDto(Long.parseLong(lineasContenido[0]), lineasContenido[1], lineasContenido[2]);
                    Inicio.listaBibliotecas.add(biblioteca1);
                }

                System.out.println("Lista de bibliotecas habilitadas");
                for (String line : contenidoFichero) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("No existen bibliotecas habilitadas");
        }
}
	
	public static void guardarCliente(String ficheroClientes) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(ficheroClientes));
            String[] contenidoFicheroClientes = Files.readAllLines(Paths.get(ficheroClientes)).toArray(new String[0]);
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partesDeLaLinea = linea.split(";");
                ClienteDto cliente = new ClienteDto(Long.parseLong(partesDeLaLinea[0]), partesDeLaLinea[1],
                        LocalDate.parse(partesDeLaLinea[2]), Integer.parseInt(partesDeLaLinea[3]),
                        partesDeLaLinea[4].charAt(0), partesDeLaLinea[5]);
              Inicio.listaClientes.add(cliente);
            }
            System.out.println("Lista de clientes dados de alta");
            for (String line : contenidoFicheroClientes) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
	
	public static void guardarLibro(String ficheroLibros) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(ficheroLibros));
            String[] contenidoFicheroClientes = Files.readAllLines(Paths.get(ficheroLibros)).toArray(new String[0]);
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partesDeLaLinea = linea.split(";");
                
                LibroDto libro = new LibroDto(Long.parseLong (partesDeLaLinea[0]),
                        Long.parseLong(partesDeLaLinea[1]),partesDeLaLinea[2], partesDeLaLinea[3],
                        partesDeLaLinea[4],Integer.parseInt( partesDeLaLinea[5]), Integer.parseInt(partesDeLaLinea[6]),
                        Integer.parseInt(partesDeLaLinea[7]));
              Inicio.listaLibros.add(libro);
            }
            System.out.println("Lista de libros dados de alta");
            for (String line : contenidoFicheroClientes) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
	
	
	public static void guardarPrestamo(String ficheroPrestamos) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(ficheroPrestamos));
            String[] contenidoFicheroClientes = Files.readAllLines(Paths.get(ficheroPrestamos)).toArray(new String[0]);
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partesDeLaLinea = linea.split(";");
                
                PrestamoDto prestamo = new PrestamoDto(Long.parseLong(partesDeLaLinea[0]),
                        Long.parseLong(partesDeLaLinea[1]),Long.parseLong(partesDeLaLinea[2]),
                        Integer.parseInt(partesDeLaLinea[3]),partesDeLaLinea[4],LocalDate.parse(partesDeLaLinea[5]),
                        LocalDate.parse(partesDeLaLinea[6]));
              Inicio.listaPrestamos.add(prestamo);
            }
            System.out.println("Lista de prestamos dados de alta");
            for (String line : contenidoFicheroClientes) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
/*
 *  public static void accesoAFicheros(String rutaFicheroGeneral) {
        try {
            FileReader fr = new FileReader(rutaFicheroGeneral);
            BufferedReader br = new BufferedReader(fr);

            List<BibliotecaDto> listaBibliotecas = new ArrayList<>();

            String linea;
            System.out.println("Lista de bibliotecas habilitadas:");
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                BibliotecaDto biblioteca = new BibliotecaDto(Long.parseLong(partes[0]), partes[1], partes[2]);
                listaBibliotecas.add(biblioteca);
                System.out.println(linea);
            }

            if (listaBibliotecas.isEmpty()) {
                System.out.println("No existen bibliotecas habilitadas");
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    */
