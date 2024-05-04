package servicios;

import java.util.List;

import dtos.BibliotecaDto;

public interface OperativaInterfaz {
	
	public void crearBiblioteca();
	public void altaCliente() ;
	public void darAltaLibro();
	public void darAltaPrestamo();
	public void DevolucionLibro();
}
