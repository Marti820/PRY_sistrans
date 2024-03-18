package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Ciudad;




public interface CiudadRepository extends JpaRepository<Ciudad,String> {
    @Query(value = "SELECT * FROM CIUDADES", nativeQuery = true)
    Collection<Ciudad> getCiudades();

    @Query(value = "SELECT * FROM CIUDADES WHERE CIUDAD = :ciudad", nativeQuery = true)
    Ciudad getCiudad(@Param("ciudad") String ciudad);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CIUDADES (CIUDAD, DEPARTAMENTO) VALUES(:ciudad, :departamento)", nativeQuery = true)
    void insertarCiudad(@Param("ciudad") String ciudad, @Param("departamento") String departamento);

    @Modifying
    @Transactional
    @Query(value = "UPDATE CIUDADES SET DEPARTAMENTO = :departamento WHERE CIUDAD = :ciudad", nativeQuery = true)
    void actualizarDepartamentoCiudad(@Param("ciudad") String ciudad, @Param("departamento") String departamento);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CIUDADES WHERE CIUDAD = :ciudad", nativeQuery = true)
    void eliminarCiudad(@Param("ciudad") String ciudad);
  
}
