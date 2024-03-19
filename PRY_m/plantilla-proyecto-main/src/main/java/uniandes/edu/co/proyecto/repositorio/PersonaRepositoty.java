package uniandes.edu.co.proyecto.repositorio;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Persona;


public interface PersonaRepositoty extends JpaRepository<Persona, Integer> {
    @Query(value = "SELECT * FROM PERSONA", nativeQuery = true)
    Collection<Persona> getPersonas();

    @Query(value = "SELECT * FROM PERSONA WHERE NUMERO_DOCUMENTO = :numeroDocumento", nativeQuery = true)
    Persona getPersonaByNumeroDocumento(@Param("numeroDocumento") Long numeroDocumento);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PERSONA (NUMERO_DOCUMENTO) VALUES (:numeroDocumento)", nativeQuery = true)
    void insertarPersona(@Param("numeroDocumento") Long numeroDocumento);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PERSONA WHERE NUMERO_DOCUMENTO = :numeroDocumento", nativeQuery = true)
    void eliminarPersona(@Param("numeroDocumento") Long numeroDocumento);
  
}

