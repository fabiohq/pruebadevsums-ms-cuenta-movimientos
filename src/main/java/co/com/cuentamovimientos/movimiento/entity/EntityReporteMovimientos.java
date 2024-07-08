package co.com.cuentamovimientos.movimiento.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import co.com.cuentamovimientos.cuenta.entity.EntityCuenta;

@Entity
@Table(name = "reportemovimientos")
public class EntityReporteMovimientos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6794131944758219960L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idreportemovimientos")
	private Long idreportemovimientos;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "saldoinicial")
	private BigDecimal saldoinicial;
	@Column(name = "saldodisponible")
	private BigDecimal saldodisponible;
	@JoinColumn(name = "cuenta_idcuenta", referencedColumnName = "idcuenta")
	@ManyToOne(optional = false)
	private EntityCuenta cuentaIdcuenta;
	@JoinColumn(name = "movimientos_idmovimientos", referencedColumnName = "idmovimientos")
	@ManyToOne(optional = false)
	private EntityMovimiento movimientosIdmovimientos;

	public EntityReporteMovimientos() {
	    }

	public EntityReporteMovimientos(Long idreportemovimientos) {
	        this.idreportemovimientos = idreportemovimientos;
	    }

	public Long getIdreportemovimientos() {
		return idreportemovimientos;
	}

	public void setIdreportemovimientos(Long idreportemovimientos) {
		this.idreportemovimientos = idreportemovimientos;
	}

	public BigDecimal getSaldoinicial() {
		return saldoinicial;
	}

	public void setSaldoinicial(BigDecimal saldoinicial) {
		this.saldoinicial = saldoinicial;
	}

	public BigDecimal getSaldodisponible() {
		return saldodisponible;
	}

	public void setSaldodisponible(BigDecimal saldodisponible) {
		this.saldodisponible = saldodisponible;
	}

	public EntityCuenta getCuentaIdcuenta() {
		return cuentaIdcuenta;
	}

	public void setCuentaIdcuenta(EntityCuenta cuentaIdcuenta) {
		this.cuentaIdcuenta = cuentaIdcuenta;
	}

	public EntityMovimiento getMovimientosIdmovimientos() {
		return movimientosIdmovimientos;
	}

	public void setMovimientosIdmovimientos(EntityMovimiento movimientosIdmovimientos) {
		this.movimientosIdmovimientos = movimientosIdmovimientos;
	}

	@Override
	public String toString() {
		return "co.com.devsu.entity.Reportemovimientos[ idreportemovimientos=" + idreportemovimientos + " ]";
	}
}
