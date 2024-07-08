package co.com.cuentamovimientos.cuenta.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import co.com.cuentamovimientos.movimiento.entity.EntityReporteMovimientos;

@Entity
@Table(name = "cuenta")
public class EntityCuenta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1419147504434371435L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idcuenta")
	private Long idcuenta;
	@Column(name = "idcliente")
	private Long idcliente;
	@Column(name = "numerocuenta")
	private String numerocuenta;
	@Column(name = "tipocuenta")
	private String tipocuenta;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "saldoinicial")
	private BigDecimal saldoinicial;
	@Column(name = "estado")
	private Boolean estado;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentaIdcuenta")
	private Collection<EntityReporteMovimientos> reportemovimientosCollection;

	public EntityCuenta() {
    }

	public EntityCuenta(Long idcuenta) {
        this.idcuenta = idcuenta;
    }

	public Long getIdcuenta() {
		return idcuenta;
	}

	public void setIdcuenta(Long idcuenta) {
		this.idcuenta = idcuenta;
	}

	public Long getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}

	public String getNumerocuenta() {
		return numerocuenta;
	}

	public void setNumerocuenta(String numerocuenta) {
		this.numerocuenta = numerocuenta;
	}

	public String getTipocuenta() {
		return tipocuenta;
	}

	public void setTipocuenta(String tipocuenta) {
		this.tipocuenta = tipocuenta;
	}

	public BigDecimal getSaldoinicial() {
		return saldoinicial;
	}

	public void setSaldoinicial(BigDecimal saldoinicial) {
		this.saldoinicial = saldoinicial;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Collection<EntityReporteMovimientos> getReportemovimientosCollection() {
		return reportemovimientosCollection;
	}

	public void setReportemovimientosCollection(Collection<EntityReporteMovimientos> reportemovimientosCollection) {
		this.reportemovimientosCollection = reportemovimientosCollection;
	}

	@Override
	public String toString() {
		return "co.com.devsu.entity.Cuenta[ idcuenta=" + idcuenta + " ]";
	}

}
