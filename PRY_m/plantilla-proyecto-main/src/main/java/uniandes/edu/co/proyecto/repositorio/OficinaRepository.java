package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Oficina;


public interface OficinaRepository extends JpaRepository<Oficina,String> {
    @Query(value = "SELECT * FROM OFICINA", nativeQuery = true)
    Collection<Oficina> getOficinas();

    @Query(value = "SELECT * FROM OFICINA WHERE NOMBRE = :nombre", nativeQuery = true)
    Oficina getOficinaByNombre(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OFICINA (NOMBRE, DIRECCION, NUM_PUNTOS_ATENCION) VALUES(:nombre, :direccion, :numPuntosAtencion)", nativeQuery = true)
    void insertarOficina(@Param("nombre") String nombre, @Param("direccion") Long direccion, @Param("numPuntosAtencion") Integer numPuntosAtencion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE OFICINA SET DIRECCION = :direccion, NUM_PUNTOS_ATENCION = :numPuntosAtencion WHERE NOMBRE = :nombre", nativeQuery = true)
    void actualizarOficina(@Param("nombre") String nombre, @Param("direccion") Long direccion, @Param("numPuntosAtencion") Integer numPuntosAtencion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OFICINA WHERE NOMBRE = :nombre", nativeQuery = true)
    void eliminarOficina(@Param("nombre") String nombre);
  
}
