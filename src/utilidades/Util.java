package utilidades;

import java.util.List;

import controladores.Inicio;
import dtos.BibliotecaDto;
import dtos.ClienteDto;
import dtos.LibroDto;

public class Util {
	
	public static void mostrarListaBibliotecas()
    {
       
        for (BibliotecaDto biblioteca : Inicio.listaBibliotecas)
        {
            System.out.println(biblioteca.toString());
        }
    }
	public static void mostrarListaClientes()
    {
       
        for (ClienteDto cliente : Inicio.listaClientes)
        {
            System.out.println(cliente.toString());
        }
    }
	public static void mostrarListaLibros()
    {
       
        for (LibroDto libro : Inicio.listaLibros)
        {
            System.out.println(libro.toString());
        }
    }

	public static long calcularIdBiblioteca() {
		
		long nuevoId = 0;
		int tamanio = Inicio.listaBibliotecas.size();

		if (tamanio > 0)
		{

		    nuevoId = Inicio.listaBibliotecas.get(tamanio - 1).getIdBiblioteca()+1;

		}
		else
		{

		    nuevoId = 1;

		}

		return nuevoId;

		
	}
	
public static long calcularIdUsuario() {
		
		long nuevoId = 0;
		int tamanio = Inicio.listaClientes.size();

		if (tamanio > 0)
		{

		    nuevoId = Inicio.listaClientes.get(tamanio - 1).getIdCliente()+1;

		}
		else
		{

		    nuevoId = 1;

		}

		return nuevoId;

		
	}
public static long calcularIdLibro() {
	
	long nuevoId = 0;
	int tamanio = Inicio.listaLibros.size();

	if (tamanio > 0)
	{

	    nuevoId = Inicio.listaLibros.get(tamanio - 1).getIdLibro()+1;

	}
	else
	{

	    nuevoId = 1;

	}

	return nuevoId;

	
}

public static long calcularIdPrestamo() {
	
	long nuevoId = 0;
	int tamanio = Inicio.listaPrestamos.size();

	if (tamanio > 0)
	{

	    nuevoId = Inicio.listaPrestamos.get(tamanio - 1).getIdPrestamo()+1;

	}
	else
	{

	    nuevoId = 1;

	}

	return nuevoId;

	
}
}
