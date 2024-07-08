package co.com.cuentamovimientos.movimiento.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "movimiento")
public class EntityMovimiento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5410026756675358921L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmovimientos")
    private Long idmovimientos;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "tipomovimiento")
    private String tipomovimiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "saldo")
    private BigDecimal saldo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movimientosIdmovimientos")
    private Collection<EntityReporteMovimientos> reportemovimientosCollection;

    public EntityMovimiento() {
    }

    public EntityMovimiento(Long idmovimientos) {
        this.idmovimientos = idmovimientos;
    }

    public Long getIdmovimientos() {
        return idmovimientos;
    }

    public void setIdmovimientos(Long idmovimientos) {
        this.idmovimientos = idmovimientos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipomovimiento() {
        return tipomovimiento;
    }

    public void setTipomovimiento(String tipomovimiento) {
        this.tipomovimiento = tipomovimiento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Collection<EntityReporteMovimientos> getReportemovimientosCollection() {
        return reportemovimientosCollection;
    }

    public void setReportemovimientosCollection(Collection<EntityReporteMovimientos> reportemovimientosCollection) {
        this.reportemovimientosCollection = reportemovimientosCollection;
    }


    @Override
    public String toString() {
        return "co.com.devsu.entity.Movimiento[ idmovimientos=" + idmovimientos + " ]";
    }
    
}
