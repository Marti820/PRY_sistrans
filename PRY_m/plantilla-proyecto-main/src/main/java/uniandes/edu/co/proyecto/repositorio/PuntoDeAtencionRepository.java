package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Direccion;
import uniandes.edu.co.proyecto.modelo.Oficina;
import uniandes.edu.co.proyecto.modelo.PuntoDeAtencion;

public interface PuntoDeAtencionRepository extends JpaRepository<PuntoDeAtencion,Integer> {
    @Query(value = "SELECT * FROM PUNTO_DE_ATENCION",nativeQuery = true )
    Collection<PuntoDeAtencion> getPuntosDeAtencion();

    @Query(value = "SELECT * FROM PUNTO_DE_ATENCION WHERE id= :id", nativeQuery = true )
    PuntoDeAtencion getPuntoDeAtencion(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PUNTO_DE_ATENCION (id, tipo, localizacion, oficina) VALUES(bancandes_sequence.nextval, :tipo, :localizacion, :oficina", nativeQuery = true )
    void insertarPuntoDeAtencion(@Param("tipo") String tipo, @Param("localizacion") String direccion, @Param("oficina") String oficina);


    @Modifying
    @Transactional
    @Query(value = "UPDATE PUNTO_DE_ATENCION SET tipo = :tipo, localizacion = :localizacion, oficina = :oficina WHERE id =:id", nativeQuery = true)
    void actualizarPuntoDeAtencion(@Param("id") int id,@Param("tipo") String tipo, @Param("localizacion") String localizacion, @Param("oficina") String oficina);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PUNTO_DE_ATENCION WHERE id =:id", nativeQuery = true)
    void eliminarPuntoDeAtencion(@Param("id") String id);}

