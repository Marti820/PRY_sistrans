package uniandes.edu.co.proyecto.repositorio;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Persona;


public interface PersonaRepositoty extends JpaRepository<Persona, Integer> {
    @Query (value = "SELECT * FROM persona", nativeQuery = true)
    Collection<Persona> darPersonas();
    
    @Query (value = "SELECT * FROM persona WHERE numero_Documento = :numero_Documento", nativeQuery = true)
    Persona darPersona(@Param("numero_Documento") int numero_Documento);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO persona (numero_Documento) VALUES(:numero_Documento)", nativeQuery = true)
    void insertarPersona(@Param("numero_Documento") int numero_Documento);
    /* 
    @Modifying
    @Transactional
    @Query(value = "UPDATE persona SET numeroDocumento = :numeroDocumento WHERE id =:id", nativeQuery = true)
    void actualizarPersona(@Param("id")int id,@Param("numeroDocumento") String numeroDocumento);*/
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM persona WHERE numero_Documento =:numero_Documento", nativeQuery = true)
    void eliminarPersona(@Param("numero_Documento") int id);
  
}

