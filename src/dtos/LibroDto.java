package dtos;

public class LibroDto {

	   ///Propiedades del obejeto librosDto
    long idLibro;
    long idBiblioteca;
    long idCliente;
    String tituloLibro = "aaaaa";
    String subtituloLibro = "aaaaa";
    String autorLibro = "aaaaa";
    int codigoISBN = 11111;
    int numeroEdicion = 11111;
    int stockLibros= 11111;
    int stockPrestamo = 11111;
    
    public LibroDto() {
		super();
	}
    
    
	
	public LibroDto(long idLibro, long idBiblioteca,String tituloLibro, String subtituloLibro,
			String autorLibro, int codigoISBN, int numeroEdicion, int stockLibros) {
		super();
		this.idLibro = idLibro;
		this.idBiblioteca = idBiblioteca;
		this.idCliente = idCliente;
		this.tituloLibro = tituloLibro;
		this.subtituloLibro = subtituloLibro;
		this.autorLibro = autorLibro;
		this.codigoISBN = codigoISBN;
		this.numeroEdicion = numeroEdicion;
		this.stockLibros = stockLibros;
	}



	public LibroDto(long idLibro, long idBiblioteca, long idCliente, String tituloLibro, String subtituloLibro,
			String autorLibro, int codigoISBN, int numeroEdicion, int stockLibros, int stockPrestamo) {
		super();
		this.idLibro = idLibro;
		this.idBiblioteca = idBiblioteca;
		this.idCliente = idCliente;
		this.tituloLibro = tituloLibro;
		this.subtituloLibro = subtituloLibro;
		this.autorLibro = autorLibro;
		this.codigoISBN = codigoISBN;
		this.numeroEdicion = numeroEdicion;
		this.stockLibros = stockLibros;
		this.stockPrestamo = stockPrestamo;
	}




	public long getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(long idLibro) {
		this.idLibro = idLibro;
	}
	public long getIdBiblioteca() {
		return idBiblioteca;
	}
	public void setIdBiblioteca(long idBiblioteca) {
		this.idBiblioteca = idBiblioteca;
	}
	public long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	public String getTituloLibro() {
		return tituloLibro;
	}
	public void setTituloLibro(String tituloLibro) {
		this.tituloLibro = tituloLibro;
	}
	public String getSubtituloLibro() {
		return subtituloLibro;
	}
	public void setSubtituloLibro(String subtituloLibro) {
		this.subtituloLibro = subtituloLibro;
	}
	public String getAutorLibro() {
		return autorLibro;
	}
	public void setAutorLibro(String autorLibro) {
		this.autorLibro = autorLibro;
	}
	public int getCodigoISBN() {
		return codigoISBN;
	}
	public void setCodigoISBN(int codigoISBN) {
		this.codigoISBN = codigoISBN;
	}
	public int getNumeroEdicion() {
		return numeroEdicion;
	}
	public void setNumeroEdicion(int numeroEdicion) {
		this.numeroEdicion = numeroEdicion;
	}
	public int getStockLibros() {
		return stockLibros;
	}
	public void setStockLibros(int stockLibros) {
		this.stockLibros = stockLibros;
	} 
	public int getStockPrestamo() {
		return stockPrestamo;
	}
	public void setStockPrestamo(int stockPrestamo) {
		this.stockPrestamo = stockPrestamo;
	}
    
    public String ToString() {
    
    	  String Libro = ("id: " + this.idLibro + "Titulo: " + this.tituloLibro +
    			   "Disponibilidad :" + this.stockLibros + this.stockPrestamo);
          return Libro;
    }
    
    
}
