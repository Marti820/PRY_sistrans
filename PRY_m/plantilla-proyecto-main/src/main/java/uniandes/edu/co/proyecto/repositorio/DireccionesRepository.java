package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Direccion;



public interface DireccionesRepository extends JpaRepository<Direccion,Integer> {
    
    @Query(value = "SELECT * FROM DIRECCIONES", nativeQuery = true)
    Collection<Direccion> getDirecciones();

    @Query(value = "SELECT * FROM DIRECCIONES WHERE ID = :id", nativeQuery = true)
    Direccion getDireccionById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO DIRECCIONES (ID, DIRECCION, CODIGO_POSTAL) VALUES(DIRECCIONES_ID.nextval, :direccion, :codigoPostal)", nativeQuery = true)
    void insertarDireccion(@Param("direccion") String direccion, @Param("codigoPostal") Integer codigoPostal);

    @Modifying
    @Transactional
    @Query(value = "UPDATE DIRECCIONES SET DIRECCION = :direccion, CODIGO_POSTAL = :codigoPostal WHERE ID = :id", nativeQuery = true)
    void actualizarDireccion(@Param("id") Long id, @Param("direccion") String direccion, @Param("codigoPostal") Integer codigoPostal);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM DIRECCIONES WHERE ID = :id", nativeQuery = true)
    void eliminarDireccion(@Param("id") Long id);
}
  


