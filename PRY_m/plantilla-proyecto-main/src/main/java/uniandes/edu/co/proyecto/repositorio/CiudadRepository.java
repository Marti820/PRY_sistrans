package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Ciudad;




public interface CiudadRepository extends JpaRepository<Ciudad,String> {
    @Query(value = "SELECT * FROM ciudades",nativeQuery = true)
    Collection<Ciudad> getCiudades();

    @Query(value = "SELECT * FROM ciudades WHERE ciudad = :ciudad", nativeQuery = true )
    Ciudad getCiudad(@Param("ciudad") String ciudadString);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ciudades (ciudad,departamento) VALUES(:ciudad, :departamento)", nativeQuery = true )
    void insertarCiudad(@Param("ciudad") String ciudad, @Param("departamento") String departamento);


    @Modifying
    @Transactional
    @Query(value = "UPDATE ciudades SET departamento = :departamento WHERE ciudad =:ciudad", nativeQuery = true)
    void actualizarCiudad(@Param("ciudad") String ciudad, @Param("departamento") String departamento);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ciudades WHERE ciudad =:ciudad", nativeQuery = true)
    void eliminarCiudad(@Param("ciudad") Integer ciudad);
  
}
