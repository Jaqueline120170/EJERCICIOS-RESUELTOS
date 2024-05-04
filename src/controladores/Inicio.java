package controladores;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import dtos.BibliotecaDto;
import java.util.List;
import java.util.Scanner;
import dtos.ClienteDto;
import dtos.LibroDto;
import dtos.PrestamoDto;
import dtos.BibliotecaDto;
import servicios.MenuImplementacion;
import servicios.MenuInterfaz;
import servicios.OperativaInterfaz;
import servicios.OperativaImplementacion;

public abstract class Inicio {

	//Listas estaticas para poder llamarlas desde cualquier parte del codigo cuando se deban implementar
	//otras funcionalidades.
	public static List<BibliotecaDto> listaBibliotecas = new ArrayList <BibliotecaDto>();
	public static List<ClienteDto> listaClientes = new ArrayList<ClienteDto>();
	public static List<LibroDto> listaLibros = new ArrayList<LibroDto>();
	public static List<PrestamoDto> listaPrestamos = new ArrayList<PrestamoDto>();
	
	
	//Método principal de la aplicación
	public static void main(String[] args) {
		
				//Constructores de clases e interfaces
				MenuInterfaz mi = new MenuImplementacion();
				OperativaInterfaz oi = new OperativaImplementacion();
				Scanner sc = new Scanner(System.in);
				
		try {
			
				//Variables de flujo
				int opcion;
				boolean cerrarMenu=false;
				
				//Creacion de ficheros
				String rutaArchivo ="C:\\Users\\Usuario\\eclipse-workspace\\ejercicioGlobal\\ficheroGeneral.txt";
				String rutaFicheroClientes = "C:\\Users\\Usuario\\eclipse-workspace\\ejercicioGlobal\\ficheroClientes.txt";
				String rutaFicheroLibros = "C:\\Users\\Usuario\\eclipse-workspace\\ejercicioGlobal\\ficheroLibros.txt";
				String rutaFicheroPrestamos = "C:\\Users\\Usuario\\eclipse-workspace\\ejercicioGlobal\\ficheroPrestamos.txt";
				
				//Métodos estaticos que muestran el estado actual d elos ficheros al momento de abrir app y contenido
				utilidades.GestorFicheros.accesoAFicheros(rutaArchivo);
				utilidades.GestorFicheros.guardarCliente(rutaFicheroClientes);
				utilidades.GestorFicheros.guardarLibro(rutaFicheroLibros);
				
				while(!cerrarMenu) {
					
					opcion= mi.mostrarMenuYSeleccion();
					switch(opcion) {
					case 0:
						try(BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
				            for (BibliotecaDto biblioteca : listaBibliotecas) {
				                if (biblioteca.getIdBiblioteca() != 0) {
				                    bw.write(biblioteca.getIdBiblioteca() + ";" + biblioteca.getNombreBiblioteca()
				                            + ";" + biblioteca.getDomicilioBiblioteca());
				                    bw.newLine();
				                }
				            }
						}catch (Exception e) {
                            System.out.println("Error al escribir en el archivo: " + e.getMessage());
                        }
						
						
						try(BufferedWriter bw = new BufferedWriter(new FileWriter(rutaFicheroClientes))) {
				            for (ClienteDto cliente : listaClientes) {
				                if (cliente.getIdCliente() != 0) {
				                    bw.write(cliente.getIdCliente() + ";" + cliente.getNombreCompletoCliente()
				                            + ";" + cliente.getFechaNac()+ ";" + cliente.getNumeroDni() +";" + cliente.getLetraDni() 
				                            + ";" + cliente.getEmailCliente());
				                    bw.newLine();
				                }
				            }
						}catch (Exception e) {
                            System.out.println("Error al escribir en el archivo: " + e.getMessage());
                        }
						
						try(BufferedWriter bw = new BufferedWriter(new FileWriter(rutaFicheroLibros))) {
				            for (LibroDto libro : listaLibros) {
				                if (libro.getIdLibro() != 0) {
				                    bw.write(libro.getIdLibro() + ";" + libro.getIdBiblioteca()
				                            + ";" + libro.getTituloLibro()+ ";" + libro.getSubtituloLibro()
				                            +";" + libro.getAutorLibro()
				                            + ";" + libro.getCodigoISBN() + ";" + libro.getNumeroEdicion() + ";" 
				                            + libro.getStockLibros());
				                    bw.newLine();
				                }
				            }
						}catch (Exception e) {
                            System.out.println("Error al escribir en el archivo: " + e.getMessage());
                        }
						

						try(BufferedWriter bw = new BufferedWriter(new FileWriter(rutaFicheroPrestamos))) {
				            for (PrestamoDto prestamo : listaPrestamos) {
				                if (prestamo.getIdPrestamo() != 0) {
				                    bw.write(prestamo.getIdPrestamo()+ ";" + prestamo.getIdClientePrestamo()
				                    + ";" + prestamo.getIdLibro()+ ";" + prestamo.getNumPrestado()+ ";" 
				                    + prestamo.getFchaPrestamo()+ ";" + prestamo.getFchaEntrega());
				                    bw.newLine();
				                }
				            }
						}catch (Exception e) {
                            System.out.println("Error al escribir en el archivo: " + e.getMessage());
                        }
						
						cerrarMenu=true;
						break;
					case 1:
						oi.crearBiblioteca();
						break;
					case 2:
						mi.seleccionGestionBiblioteca();
						break;
					default: 
						System.out.println("Introduzca una opcion valida");
						break;
					}
				}
		}
		catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        } finally {
            sc.close(); // Cerrar Scanner al finalizar
        }
	}
	
	
}
