package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cuenta;

import java.util.Collection;

@Repository
public interface CuentasRepository extends JpaRepository<Cuenta, Integer> {

    @Query(value = "SELECT * FROM CUENTAS", nativeQuery = true)
    Collection<Cuenta> getCuentas();

    @Query(value = "SELECT * FROM CUENTAS WHERE ID = :id", nativeQuery = true)
    Cuenta getCuenta(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CUENTAS (ID, ESTADO, TIPO, DINERO) VALUES(:id, :estado, :tipo, :dinero)", nativeQuery = true)
    void insertarCuenta(@Param("id") Integer id, @Param("estado") String estado, @Param("tipo") String tipo, @Param("dinero") Double dinero);

    @Modifying
    @Transactional
    @Query(value = "UPDATE CUENTAS SET ESTADO = :estado, TIPO = :tipo, DINERO = :dinero WHERE ID = :id", nativeQuery = true)
    void actualizarCuenta(@Param("id") Integer id, @Param("estado") String estado, @Param("tipo") String tipo, @Param("dinero") Double dinero);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CUENTAS WHERE ID = :id", nativeQuery = true)
    void eliminarCuenta(@Param("id") Integer id);
}
