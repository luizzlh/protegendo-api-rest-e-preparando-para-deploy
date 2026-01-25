package med.voll.api.domain.medico;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico, Long> {


    Page<Medico> findAllByAtivoTrue(Pageable pagina);

    @Query("""
            SELECT M 
            FROM Medico M
            WHERE M.ativo = TRUE
            AND M.ESPECIALIDADE = :especialidade
            AND M.id NOT IN(
                        SELECT C.medico.id FROM Consulta C
                        WHERE C.data = :data
                        )
            ORDER BY RAND()
            LIMIT 1
                """)
    Medico escolherMedicoAleatorioLivreNaData(Especialidade especialidade, @NotNull @Future LocalDateTime data);

    @Query("SELECT M.ativo FROM Medico M WHERE id = :idMedico")
    Boolean findAtivoById(Long idMedico);
}