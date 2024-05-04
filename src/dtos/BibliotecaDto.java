package dtos;

public class BibliotecaDto {

	long idBiblioteca;
	String nombreBiblioteca;
	String domicilioBiblioteca;
	
	
	public BibliotecaDto() {
		super();
	}
	public BibliotecaDto(long idBiblioteca, String nombreBiblioteca,String domicilioBiblioteca) {
		super();
		this.idBiblioteca = idBiblioteca;
		this.nombreBiblioteca = nombreBiblioteca;
		this.domicilioBiblioteca= domicilioBiblioteca;
	}
	
	
	
	public long getIdBiblioteca() {
		return idBiblioteca;
	}
	public void setIdBiblioteca(long idBiblioteca) {
		this.idBiblioteca = idBiblioteca;
	}
	public String getNombreBiblioteca() {
		return nombreBiblioteca;
	}
	public void setNombreBiblioteca(String nombreBiblioteca) {
		this.nombreBiblioteca = nombreBiblioteca;
	}
	public String getDomicilioBiblioteca() {
		return domicilioBiblioteca;
	}
	public void setDomicilioBiblioteca(String domicilioBiblioteca) {
		this.domicilioBiblioteca = domicilioBiblioteca;
	}
	@Override
	public String toString() {
		String bibliotecaString = "ID: " + this.idBiblioteca + " Nombre Biblioteca: " + this.nombreBiblioteca;
		return bibliotecaString;
	}
	
	
}
