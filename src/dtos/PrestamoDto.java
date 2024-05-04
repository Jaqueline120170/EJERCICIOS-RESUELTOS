package dtos;

import java.time.LocalDate;

public class PrestamoDto {

	
	long idPrestamo =  11111;
    long idClientePrestamo;
    long idLibro = 111111;
    int numPrestado = 11111;
    String estadoPrestamo = "aaaaa";

    LocalDate fchaPrestamo = LocalDate.now();
    LocalDate fchaEntrega = LocalDate.of(9999, 12, 31);
    LocalDate fchaEntregaEsperada = LocalDate.of(9999, 12, 31);
    
    
    
	public PrestamoDto() {
		super();
	}
	
	public PrestamoDto(long idPrestamo, long idClientePrestamo, long idLibro, int numPrestado, String estadoPrestamo,
			LocalDate fchaPrestamo, LocalDate fchaEntrega) {
		super();
		this.idPrestamo = idPrestamo;
		this.idClientePrestamo = idClientePrestamo;
		this.idLibro = idLibro;
		this.numPrestado = numPrestado;
		this.estadoPrestamo = estadoPrestamo;
		this.fchaPrestamo = fchaPrestamo;
		this.fchaEntrega = fchaEntrega;
		this.fchaEntregaEsperada = fchaEntregaEsperada;
	}
	
	public long getIdPrestamo() {
		return idPrestamo;
	}
	public void setIdPrestamo(long idPrestamo) {
		this.idPrestamo = idPrestamo;
	}
	public long getIdClientePrestamo() {
		return idClientePrestamo;
	}
	public void setIdClientePrestamo(long idClientePrestamo) {
		this.idClientePrestamo = idClientePrestamo;
	}
	public long getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(long idLibro) {
		this.idLibro = idLibro;
	}
	public int getNumPrestado() {
		return numPrestado;
	}
	public void setNumPrestado(int numPrestado) {
		this.numPrestado = numPrestado;
	}
	public String getEstadoPrestamo() {
		return estadoPrestamo;
	}
	public void setEstadoPrestamo(String estadoPrestamo) {
		this.estadoPrestamo = estadoPrestamo;
	}
	public LocalDate getFchaPrestamo() {
		return fchaPrestamo;
	}
	public void setFchaPrestamo(LocalDate fchaPrestamo) {
		this.fchaPrestamo = fchaPrestamo;
	}
	public LocalDate getFchaEntrega() {
		return fchaEntrega;
	}
	public void setFchaEntrega(LocalDate fchaEntrega) {
		this.fchaEntrega = fchaEntrega;
	}
	public LocalDate getFchaEntregaEsperada() {
		return fchaEntregaEsperada;
	}
	public void setFchaEntregaEsperada(LocalDate fchaEntregaEsperada) {
		this.fchaEntregaEsperada = fchaEntregaEsperada;
	}
    
    
    
	
    
    
    
}
