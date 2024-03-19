package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.PuntoDeAtencion;

public interface PuntoDeAtencionRepository extends JpaRepository<PuntoDeAtencion,Integer> {
    @Query(value = "SELECT * FROM PUNTO_DE_ATENCION", nativeQuery = true)
    Collection<PuntoDeAtencion> getPuntosDeAtencion();

    @Query(value = "SELECT * FROM PUNTO_DE_ATENCION WHERE ID = :id", nativeQuery = true)
    PuntoDeAtencion getPuntoDeAtencionById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PUNTO_DE_ATENCION (ID, TIPO, LOCALIZACION, OFICINA) " +
            "VALUES (PUNTO_ATENCION_ID.nextval, :tipo, :localizacion, :oficina)", nativeQuery = true)
    void insertPuntoDeAtencion(@Param("tipo") String tipo,
                               @Param("localizacion") int localizacion, @Param("oficina") String oficina);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PUNTO_DE_ATENCION SET TIPO = :tipo, LOCALIZACION = :localizacion, OFICINA = :oficina " +
            "WHERE ID = :id", nativeQuery = true)
    void updatePuntoDeAtencion(@Param("id") int id, @Param("tipo") String tipo,
                               @Param("localizacion") int localizacion, @Param("oficina") String oficina);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PUNTO_DE_ATENCION WHERE ID = :id", nativeQuery = true)
    void deletePuntoDeAtencion(@Param("id") int id);
}

