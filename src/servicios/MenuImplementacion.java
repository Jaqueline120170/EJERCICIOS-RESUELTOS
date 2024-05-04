package servicios;

import java.util.Scanner;

public class MenuImplementacion implements MenuInterfaz {

	Scanner sc = new Scanner (System.in);
	OperativaInterfaz oi = new OperativaImplementacion();
	public int mostrarMenuYSeleccion() {
		
		System.out.println("0. Cerrar menu");
		System.out.println("1. Dar alta biblioteca");
		System.out.println("2. Acceso gestion bibliotecas");
		System.out.println("Seleccione una opcion");
		int seleccionUsuario= sc.nextInt();
		return seleccionUsuario;
	}
	public void seleccionGestionBiblioteca() {
		
		int opcion = menuGestionBiblioteca();
		switch(opcion) {
		case 0 :
			break;
		case 1:
			oi.altaCliente();
			break;
		case 2:
			oi.darAltaLibro();
			break;
		case 3:
			oi.darAltaPrestamo();
			break;
		case 4:
			oi.DevolucionLibro();
		default:
			System.out.println("Introduzca una opcion valida");
			
		}
	}
	private int menuGestionBiblioteca() {
		int seleccionGestion;
		System.out.println("0. Volver al inicio");
		System.out.println("1. Dar alta cliente");
		System.out.println("2. Dar alta libro");
		System.out.println("3. Gestionar un prestamo");
		System.out.println("4. Realizar una devolucion");
		System.out.println("Seleccione una opcion");
		seleccionGestion=sc.nextInt();
		return seleccionGestion;
	}
}
