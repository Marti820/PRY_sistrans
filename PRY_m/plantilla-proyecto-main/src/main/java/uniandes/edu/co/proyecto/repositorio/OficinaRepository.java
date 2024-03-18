package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Direccion;
import uniandes.edu.co.proyecto.modelo.Oficina;


public interface OficinaRepository extends JpaRepository<Oficina,String> {
    @Query(value = "SELECT * FROM oficina", nativeQuery = true )
    Collection<Oficina> getOficina();

    @Query(value = "SELECT * FROM oficina WHERE NOMBRE = :NOMBRE", nativeQuery = true )
    Oficina getOficina(@Param("NOMBRE") Integer NOMBRE);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO oficina (nombre, direccion, puntosAtencion) VALUES(:nombre, :direccion, :puntosAtencion)", nativeQuery = true )
    void insertarOficina(@Param("nombre") String nombre,@Param("direccion") int direccion, @Param("puntosAtencion") Integer puntosAtencion);


    @Modifying
    @Transactional
    @Query(value = "UPDATE oficina SET direccion = :direccion,  puntosAtencion= :puntosAtencion WHERE NOMBRE =:NOMBRE", nativeQuery = true)
    void actualizarOficina(@Param("NOMBRE") String NOMBRE, @Param("direccion") int direccion,  @Param("puntosAtencion") Integer puntosAtencion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM oficina WHERE NOMBRE =:NOMBRE", nativeQuery = true)
    void eliminarOficina(@Param("NOMBRE") Integer NOMBRE);
  
}
