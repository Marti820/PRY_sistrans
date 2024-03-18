package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Prestamo;

import java.util.Collection;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {

    @Query(value = "SELECT * FROM PRESTAMO", nativeQuery = true)
    Collection<Prestamo> getPrestamos();

    @Query(value = "SELECT * FROM PRESTAMO WHERE id = :id", nativeQuery = true)
    Prestamo getPrestamo(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PRESTAMO (ID, ESTADO, TIPO, INTERES, CUOTAS, VALOR_CUOTA, MONTO, DIA_CORTE, SALDO_PENDIENTE) " +
            "VALUES(:id, :estado, :tipo, :interes, :cuotas, :valorCuota, :monto, :diaCorte, :saldoPendiente)", nativeQuery = true)
    void insertarPrestamo(@Param("id") Integer id, @Param("estado") String estado, @Param("tipo") String tipo,
                          @Param("interes") Double interes, @Param("cuotas") Integer cuotas,
                          @Param("valorCuota") Double valorCuota, @Param("monto") Integer monto,
                          @Param("diaCorte") Integer diaCorte, @Param("saldoPendiente") Integer saldoPendiente);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PRESTAMO SET ESTADO = :estado, TIPO = s:tipo ,INTERES = :interes, CUOTAS = :cuotas, " +
            "VALOR_CUOTA = :valorCuota, MONTO = :monto, DIA_CORTE = :diaCorte, SALDO_PENDIENTE = :saldoPendiente " +
            "WHERE ID = :id", nativeQuery = true)
    void actualizarPrestamo(@Param("id") Integer id, @Param("estado") String estado, @Param("tipo") String tipo,
                            @Param("interes") Double interes, @Param("cuotas") Integer cuotas,
                            @Param("valorCuota") Double valorCuota, @Param("monto") Integer monto,
                            @Param("diaCorte") Integer diaCorte, @Param("saldoPendiente") Integer saldoPendiente);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PRESTAMO WHERE ID = :id", nativeQuery = true)
    void eliminarPrestamo(@Param("id") Integer id);
}
