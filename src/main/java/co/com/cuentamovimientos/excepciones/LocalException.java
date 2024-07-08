package co.com.cuentamovimientos.excepciones;

public class LocalException extends Exception{
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String clase;
	private Throwable causa;
	public LocalException(String codigo, String clase,Throwable causa) {
		super();
		this.codigo = codigo;
		this.clase = clase;
		this.causa=causa;
	}
	
	public LocalException() {
        super();
    }

    public LocalException(String message) {
        super(message);
    }

    public LocalException(String message, Throwable cause) {
        super(message, cause);
    }

    public LocalException(Throwable cause) {
        super(cause);
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

	public Throwable getCausa() {
		return causa;
	}

	public void setCausa(Throwable causa) {
		this.causa = causa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
