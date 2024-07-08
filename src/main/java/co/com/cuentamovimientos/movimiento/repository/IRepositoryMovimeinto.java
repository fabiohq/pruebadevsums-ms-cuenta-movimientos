package co.com.cuentamovimientos.movimiento.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.cuentamovimientos.cuenta.entity.EntityCuenta;
import co.com.cuentamovimientos.movimiento.entity.EntityMovimiento;

@Repository
public interface IRepositoryMovimeinto extends JpaRepository<EntityMovimiento, Long> {

	@Query(value = "select m.* from cuenta cu "
			+ "inner join reportemovimientos rm on cu.idcuenta = rm.cuenta_idcuenta "
			+ "inner join movimiento m on rm.movimientos_idmovimientos = m.idmovimientos "
			+ "where cu.idcuenta = :idCuenta " + "order by m.fecha desc limit 1", nativeQuery = true)
	Optional<EntityMovimiento> findLatestMovimientoByCuentaId(@Param("idCuenta") Long idCuenta);
}
