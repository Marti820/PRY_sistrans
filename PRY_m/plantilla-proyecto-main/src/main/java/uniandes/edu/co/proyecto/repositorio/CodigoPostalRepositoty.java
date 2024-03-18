package uniandes.edu.co.proyecto.repositorio;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.CodigoPostal;



public interface CodigoPostalRepositoty extends JpaRepository<CodigoPostal,Integer> {
    @Query(value = "SELECT * FROM CODIGOS_POSTALES", nativeQuery = true)
    Collection<CodigoPostal> getCodigosPostales();

    @Query(value = "SELECT * FROM CODIGOS_POSTALES WHERE CODIGO = :codigo", nativeQuery = true)
    CodigoPostal getCodigoPostalByCodigo(@Param("codigo") int codigo);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CODIGOS_POSTALES (CODIGO, CIUDAD) VALUES (:codigo, :ciudad)", nativeQuery = true)
    void insertCodigoPostal(@Param("codigo") int codigo, @Param("ciudad") String ciudad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE CODIGOS_POSTALES SET CIUDAD = :ciudad WHERE CODIGO = :codigo", nativeQuery = true)
    void updateCodigoPostalCiudad(@Param("codigo") int codigo, @Param("ciudad") String ciudad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CODIGOS_POSTALES WHERE CODIGO = :codigo", nativeQuery = true)
    void deleteCodigoPostal(@Param("codigo") int codigo);


}