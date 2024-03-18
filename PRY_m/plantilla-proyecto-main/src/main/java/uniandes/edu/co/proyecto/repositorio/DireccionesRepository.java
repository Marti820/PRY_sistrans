package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.CodigoPostal;
import uniandes.edu.co.proyecto.modelo.Direccion;



public interface DireccionesRepository extends JpaRepository<Direccion,Integer> {
    @Query(value = "SELECT * FROM direcciones", nativeQuery = true )
    Collection<Direccion> getDirecciones();

    @Query(value = "SELECT * FROM direcciones WHERE id = :id", nativeQuery = true )
    Direccion getDireccion(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO direcciones (id, direccion, codigoPostal) VALUES(DIRECCIONES_ID.nextval,:direccion, :codigoPostal)", nativeQuery = true )
    void insertarDireccion(@Param("direccion") String direccion,@Param("codigoPostal") int codigoPostal);


    @Modifying
    @Transactional
    @Query(value = "UPDATE direcciones SET direccion = :direccion, codigoPostal = :codigoPostal  WHERE id =:id", nativeQuery = true)
    void actualizarDireccion(@Param("id") Integer id, @Param("direccion") String direccion, @Param("codigoPostal") int codigoPostal);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM direcciones WHERE id =:id", nativeQuery = true)
    void eliminarDireccion(@Param("id") Integer id);
  
}

