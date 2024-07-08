package co.com.cuentamovimientos.excepciones;

import org.springframework.http.HttpStatus;

public class LocalMessage {

	private String codigoError;
	private HttpStatus estadoHttp;
	private String mensageError;
	
	public String getCodigoError() {
		return codigoError;
	}
	public void setCodigoError(String codigoError) {
		this.codigoError = codigoError;
	}
	public HttpStatus getEstadoHttp() {
		return estadoHttp;
	}
	public void setEstadoHttp(HttpStatus estadoHttp) {
		this.estadoHttp = estadoHttp;
	}
	public String getMensageError() {
		return mensageError;
	}
	public void setMensageError(String mensageError) {
		this.mensageError = mensageError;
	}
	@Override
	public String toString() {
		return "LocalMessage [codigoError=" + codigoError + ", estadoHttp=" + estadoHttp + ", mensageError="
				+ mensageError + "]";
	}
	
}
