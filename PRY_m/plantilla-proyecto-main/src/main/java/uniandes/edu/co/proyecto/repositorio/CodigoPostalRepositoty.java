package uniandes.edu.co.proyecto.repositorio;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Ciudad;
import uniandes.edu.co.proyecto.modelo.CodigoPostal;



public interface CodigoPostalRepositoty extends JpaRepository<CodigoPostal,Integer> {
    @Query(value = "SELECT * FROM CODIGOS_POSTALES", nativeQuery = true )
    Collection<CodigoPostal> getCodigoPostal();

    @Query(value = "SELECT * FROM CODIGOS_POSTALES WHERE id = :id", nativeQuery = true )
    CodigoPostal getCodigoPostal(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CODIGOS_POSTALES (id, codigo, ciudad) VALUES(CODIGO_POSTAL_ID.nextval,:codigo, :ciudad)", nativeQuery = true )
    void insertarCodigoPostal(@Param("codigo") Integer codigo,@Param("ciudad") String ciudad);


    @Modifying
    @Transactional
    @Query(value = "UPDATE CODIGOS_POSTALES SET codigo = :codigo, ciudad = :ciudad WHERE id =:id", nativeQuery = true)
    void actualizarCodigoPostal(@Param("id") Integer id,@Param("codigo") Integer codigo,@Param("ciudad") String ciudad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CODIGOS_POSTALES WHERE id =:id", nativeQuery = true)
    void eliminarCodigoPostal(@Param("id") Integer id);
  
}