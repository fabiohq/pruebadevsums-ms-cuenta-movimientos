package co.com.cuentamovimientos.movimiento.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.cuentamovimientos.movimiento.entity.EntityReporteMovimientos;
import co.com.cuentamovimientos.movimiento.modelo.ReporteMovimientosDTO;

@Repository
public interface IRepositoryReporteMovimientos extends JpaRepository<EntityReporteMovimientos, Long> {

	@Query(value = "select m.fecha, cl.nombre as cliente, cu.numerocuenta, cu.tipocuenta, rm.saldoinicial, cu.estado, m.tipomovimiento, rm.saldodisponible " +
            "from cliente cl " +
            "inner join cuenta cu on cl.idcliente = cu.idcliente " +
            "inner join reportemovimientos rm on cu.idcuenta = rm.cuenta_idcuenta " +
            "inner join movimiento m on rm.movimientos_idmovimientos = m.idmovimientos " +
            "WHERE cl.identificacion = :identificacion and m.fecha BETWEEN :fechaInicio AND :fechaFin",
            nativeQuery = true)
	List<Object[]> findReportesByIdentificacionAndFechas(@Param("identificacion") String identificacion,
			@Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFin") LocalDate fechaFin);
}
