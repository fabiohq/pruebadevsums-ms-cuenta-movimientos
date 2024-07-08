package co.com.cuentamovimientos.excepciones;

import java.io.IOException;

public class LocalIOException extends IOException{

	private static final long serialVersionUID = 1L;
	private String codigo;
	private String clase;
	public LocalIOException(String codigo, String clase) {
		super();
		this.codigo = codigo;
		this.clase = clase;
	}
	public LocalIOException() {
		super();
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
