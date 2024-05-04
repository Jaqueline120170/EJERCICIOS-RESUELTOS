package dtos;

import java.time.LocalDate;

public class ClienteDto {

	long idBibliotecaCliente;
	long idCliente;
	String nombre ;
	String apellido1;
	String apellido2;
	String nombreCompletoCliente;
	LocalDate fechaNac = LocalDate.now();
	int numeroDni=11111;
	char letraDni = 'a';
	String dniCompleto;
	String emailCliente = "aaaaa";
	boolean estadoSuspencion= false;
	LocalDate inicioSuspencion;
	LocalDate finSuspencion;
	
	
	
	public ClienteDto(long idCliente, long idBibliotecaCliente, String nombreCompletoCliente, 
            LocalDate fechaNac, int numeroDni, char letraDni, String emailCliente)
        {
            this.idCliente = idCliente;
            this.idBibliotecaCliente = idBibliotecaCliente;
            this.nombreCompletoCliente = nombreCompletoCliente;
            this.fechaNac = fechaNac;
            this.numeroDni = numeroDni;
            this.letraDni = letraDni;
            this.dniCompleto = numeroDni + String.valueOf(letraDni);// Convertir letraDni a String para concatenar
            this.emailCliente = emailCliente;
            String[] arregloNombre = nombreCompletoCliente.split(" ");
            this.nombre = arregloNombre[0];
            this.apellido1= arregloNombre[1];
            this.apellido2 = arregloNombre[2];
        }
	

	public ClienteDto(long idCliente, String nombreCompletoCliente, LocalDate fechaNac, int numeroDni, char letraDni,
			String emailCliente) {
		super();
		this.idCliente = idCliente;
		this.nombreCompletoCliente = nombreCompletoCliente;
		this.fechaNac = fechaNac;
		this.numeroDni = numeroDni;
		this.letraDni = letraDni;
		this.emailCliente = emailCliente;
		
	}


	public long getIdBibliotecaCliente() {
		return idBibliotecaCliente;
	}

	public void setIdBibliotecaCliente(long idBibliotecaCliente) {
		this.idBibliotecaCliente = idBibliotecaCliente;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getNombreCompletoCliente() {
		return nombreCompletoCliente;
	}

	public void setNombreCompletoCliente(String nombreCompletoCliente) {
		this.nombreCompletoCliente = nombreCompletoCliente;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public int getNumeroDni() {
		return numeroDni;
	}

	public void setNumeroDni(int numeroDni) {
		this.numeroDni = numeroDni;
	}

	public char getLetraDni() {
		return letraDni;
	}

	public void setLetraDni(char letraDni) {
		this.letraDni = letraDni;
	}

	public String getDniCompleto() {
		return dniCompleto;
	}

	public void setDniCompleto(String dniCompleto) {
		this.dniCompleto = dniCompleto;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public boolean isEstadoSuspencion() {
		return estadoSuspencion;
	}

	public void setEstadoSuspencion(boolean estadoSuspencion) {
		this.estadoSuspencion = estadoSuspencion;
	}

	public LocalDate getInicioSuspencion() {
		return inicioSuspencion;
	}

	public void setInicioSuspencion(LocalDate inicioSuspencion) {
		this.inicioSuspencion = inicioSuspencion;
	}

	public LocalDate getFinSuspencion() {
		return finSuspencion;
	}

	public void setFinSuspencion(LocalDate finSuspencion) {
		this.finSuspencion = finSuspencion;
	}
	
	
	public String ToString() {
        String cliente = ("id Biblioteca:" +
        		this.idBibliotecaCliente + "nombre completo : " + this.nombreCompletoCliente + "fecha nacimiento :" + this.fechaNac +
        		"dni: " +  this.dniCompleto +" correo: " + this.emailCliente);
        return cliente ;
    }
	
	
	
	
}
