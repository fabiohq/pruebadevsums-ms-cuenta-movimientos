package co.com.cuentamovimientos.cuenta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.cuentamovimientos.cuenta.entity.EntityCuenta;

@Repository
public interface IRepositoryCuenta extends JpaRepository<EntityCuenta, Long>{

	Optional<EntityCuenta> findByNumerocuenta(String numeroCuenta);
}
