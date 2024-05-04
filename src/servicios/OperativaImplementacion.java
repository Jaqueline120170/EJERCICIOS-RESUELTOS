package servicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import controladores.Inicio;
import dtos.BibliotecaDto;
import dtos.ClienteDto;
import dtos.LibroDto;
import dtos.PrestamoDto;


public class OperativaImplementacion implements OperativaInterfaz {
	
	Scanner sc = new Scanner(System.in);
	
	public void crearBiblioteca(){
		
		System.out.println("CREAR BIBLIOTECA");
		System.out.println("-------------------");
		long id =utilidades.Util.calcularIdBiblioteca();
		System.out.println("Introduzca el nombre de la biblioteca");
		String nombre = sc.next();
		System.out.println("Introduzca el domicilio de la biblioteca");
		String domicilio = sc.next();
		BibliotecaDto biblioteca = new BibliotecaDto(id, nombre, domicilio);
		Inicio.listaBibliotecas.add(biblioteca);
		
	}
	
	public void altaCliente() {
        try {
            utilidades.Util.mostrarListaBibliotecas();
            System.out.println("ALTA CLIENTE");
            System.out.println("-----------------");
           
            System.out.println("Ingrese id de la biblioteca para crear un usuario");
           
            long idBibliotecaRegistroCliente = sc.nextLong();sc.nextLine();
            boolean bibliotecaEncontrada = false;
            
            for (BibliotecaDto buscarID : Inicio.listaBibliotecas) {
                if (buscarID.getIdBiblioteca() == idBibliotecaRegistroCliente) {
                    bibliotecaEncontrada = true;
                    long idCliente = utilidades.Util.calcularIdUsuario();
                    System.out.println("Ingrese nombre completo separado por espacios");
                    String nombreCompleto = sc.nextLine();
                    System.out.println("Ingrese fecha de nacimiento (yyyy/mm/dd)");
                    String fechaString = sc.next();
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                    LocalDate fechaReal = LocalDate.parse(fechaString, formato);
                    System.out.println("Ingrese los numeros del DNI (8 digitos)");
                    int dniClienteRegistro = sc.nextInt();
                    System.out.println("Ingrese la letra del DNI (ej: z)");
                    char letraCliente = sc.next().toUpperCase().charAt(0);
                    var dniCl = verificarDni(dniClienteRegistro, letraCliente);
                    System.out.println("Ingrese un correo");
                    String correoCliente = sc.next();
                    
                    ClienteDto cli = new ClienteDto(idCliente, idBibliotecaRegistroCliente,
                            nombreCompleto, fechaReal, dniClienteRegistro, letraCliente, correoCliente);
                    Inicio.listaClientes.add(cli);
                    
                    System.out.println("Su usuario se ha creado con éxito");
                    break;
                }
            }
            if (!bibliotecaEncontrada) {
                System.out.println("La biblioteca no existe, verifiquelo y vuelva a intentar");
            }
            //Util.guardarIdDictionary();
        } catch (Exception e) {
            throw e;
        }
		
	}
	
	public void darAltaLibro() {
		try {
			utilidades.Util.mostrarListaBibliotecas();
		
	        System.out.println("ALTA LIBRO");
	        System.out.println("-----------------");  
            System.out.println("Ingrese id de la biblioteca en la que desea dar alta el libro");
            long idBibliotecaRegistroLibro = sc.nextLong();sc.nextLine();
            boolean bibliotecaEncontrada = false;
            
            for (BibliotecaDto buscarID : Inicio.listaBibliotecas) {
                if (buscarID.getIdBiblioteca() == idBibliotecaRegistroLibro) {
                   bibliotecaEncontrada = true;
                   long idLib =  utilidades.Util.calcularIdLibro();
                   System.out.println("Introduzca el titulo del libro");
                   String titulo= sc.next();
                   System.out.println("Introduzca el subtitulo del libro");
                   String subtitulo = sc.next();
                   System.out.println("Introduzca el nombre del autor del libro");
                   String nombreAu=sc.next();
                   System.out.println("Introduzca el codigo ISBN del libro ");
                   int isbn = sc.nextInt();
                   boolean codigo = verificarDuplicado(isbn);
                   System.out.println("Introduzca el numero de edicion del libro");
                   int edicion = sc.nextInt();
                   System.out.println("Introduzca el stock del libro");
                   int stock = sc.nextInt();
                   
                   LibroDto lib = new LibroDto (idLib, idBibliotecaRegistroLibro,titulo, subtitulo,nombreAu, isbn, edicion, stock);
                   Inicio.listaLibros.add(lib);
                   
                   System.out.println("El libro se ha agregado con éxito");
                   break;
                }
            }
            if (!bibliotecaEncontrada) {
                System.out.println("La biblioteca no existe, verifiquelo y vuelva a intentar");
            }
            
		}catch (Exception e) {
            throw e;
        }
	}
	private boolean verificarDuplicado(int isbn)
    {
        try
        {
            for (LibroDto libro :Inicio.listaLibros)
            {
                if (libro.getCodigoISBN()==(isbn))
                {
                   System.out.println("Se han hallado codigos ISBN duplicados, el libro ya existe");
                    return true;
                }
            }
            return false;
        }
        catch (Exception e) {
            throw e;
        }
    }
	
	public void darAltaPrestamo() {
		
	try {
		utilidades.Util.mostrarListaBibliotecas();
		 System.out.println("ALTA PRESTAMO");
	        System.out.println("-----------------");  
         System.out.println("Ingrese id de la biblioteca en la que desea dar alta el libro");
         long idBibliotecaRegistroPrestamo = sc.nextLong();sc.nextLine();
		
         utilidades.Util.mostrarListaClientes();
         System.out.println("Ingrese el id del usuario para solicitar el prestamo");
         long idU= sc.nextLong();
         
         utilidades.Util.calcularIdLibro();
         System.out.println("Introduzca el id del libro que desea pedir prestado");
         long idLib = sc.nextLong();
         
         System.out.println("Introduzca la cantidad de ejemplares que desea pedir prestados");
         int cantLibros= sc.nextInt();
         
         boolean clienteEncontrado = false;
         boolean libroEncontrado = false;
         boolean stockDisponible = false;
         
         if (Inicio.listaClientes.size() > 0)
         {
             for(ClienteDto cliente : Inicio.listaClientes)
             {

                 if (cliente.getIdBibliotecaCliente()== (idBibliotecaRegistroPrestamo) && cliente.getIdCliente()== (idU))
                 {
                     clienteEncontrado = true;
                     break;
                 }
             }
             if (!clienteEncontrado)
             {
                 System.out.println("El cliente no pertenece a la biblioteca");
             }
             else
             {
                 for(LibroDto lib : Inicio.listaLibros)
                 {

                     if (lib.getIdLibro()== (idLib) && lib.getIdBiblioteca()==(idBibliotecaRegistroPrestamo))
                     {
                         libroEncontrado = true;

                         if (lib.getStockPrestamo() >= cantLibros)
                         {
                             stockDisponible = true;

                             lib.setStockPrestamo(lib.getStockPrestamo() - cantLibros);

                             long idBibliotecaPrestamo = idBibliotecaRegistroPrestamo;
                             long idPres = utilidades.Util.calcularIdPrestamo();
                             long idUsuario = idU;
                             long idLibroPrestamo = idLib;
                             int numPrestadoCliente = cantLibros;
                             LocalDate fechaInstante = LocalDate.now();
                             String estado = "en proceso";
                             LocalDate fechaEntregaEsperada = fechaInstante.plusDays(8);
                             

                             PrestamoDto prestamo = new PrestamoDto(idPres, idUsuario, idLibroPrestamo,numPrestadoCliente,estado, fechaInstante, fechaEntregaEsperada) ;
                             Inicio.listaPrestamos.add(prestamo);

                             System.out.println("Prestamo con exito");
                             //Utilidades.Utils.GuardarIdDictionary();
                             break;
                         }
                         else
                         {
                             System.out.println("No hay libros disponibles");
                         }
                         
	}
}
             }
             if (!libroEncontrado)
             {
               System.out.println("El libro no se encuentra en la biblioteca");
             }
             if (!stockDisponible)
             {
                 System.out.println("No hay stock disponible de ese libro");

             }
         }
         
     }
	catch (Exception e) {
        throw e;
    }
}
	 public void DevolucionLibro()
     {
    	    try {
    	        utilidades.Util.mostrarListaClientes();
    	        System.out.println("Ingrese su id");
    	        long idUs = sc.nextLong();

    	        System.out.println("Ingrese el id del libro devuelto:");
    	        long idLibroDevolucion = sc.nextLong();
    	        LocalDate fechaDevolucion = LocalDate.now();

    	        boolean prestamoEncontrado = false;

    	        for (PrestamoDto prestamo : Inicio.listaPrestamos) {
    	            if (prestamo.getIdLibro() == idLibroDevolucion && prestamo.getEstadoPrestamo().equals("en proceso") && prestamo.getIdClientePrestamo() == idUs) {
    	                prestamoEncontrado = true;

    	                if (fechaDevolucion.isBefore(prestamo.getFchaEntregaEsperada()) || fechaDevolucion.isEqual(prestamo.getFchaEntregaEsperada())) {
    	                    prestamo.setEstadoPrestamo("entregado");
    	                } else {
    	                    prestamo.setEstadoPrestamo("entregado con retraso");
    	                    //suspenderCliente(prestamo.getIdClientePrestamo());
    	                }

    	                System.out.println("Libro devuelto con éxito.");

    	                return;
    	            }
    	        }

    	        if (!prestamoEncontrado) {
    	            System.out.println("No se encontró ningún préstamo en proceso para el libro especificado.");
    	        }

    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }
     }
	 private int verificarDni(int dniCliente, char letraCliente) {
		    try {
		        int dniVerificar = -1;

		        int[] resto = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22};
		        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

		        int divisor = 23;
		        int operacion = dniCliente % divisor;

		        int posicionResto = resto[operacion];

		        if (letraCliente == letras[posicionResto]) {
		            System.out.println("DNI válido");
		            dniVerificar = dniCliente; // Asigna el DNI verificado a la variable de retorno
		        } else {
		            System.out.println("La letra ingresada no coincide con la letra calculada.");
		        }
		        return dniVerificar;
		    } catch (Exception e) {
		        throw e;
		    }
	 }
}

         
		
	
	
	

