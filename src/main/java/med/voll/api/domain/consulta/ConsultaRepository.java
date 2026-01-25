package med.voll.api.domain.consulta;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    boolean existsByPacienteIdAndDataBetween(Long pacienteId, LocalDateTime primeiroHorario, LocalDateTime segundoHorario);

    boolean existsByMedicoIdAndData(Long idMedico, LocalDateTime data);

    @Query("SELECT C.id FROM Consulta C WHERE C.medico.id = :idMedico AND C.paciente.id = :idPaciente AND C.data = :dataConsulta")
    Long consultarIdConsulta(@NotNull Long idMedico, @NotNull Long idPaciente, @NotNull LocalDateTime dataConsulta);

    Boolean existsByMedicoIdAndPacienteIdAndData(Long idMedico, Long idPaciente, LocalDateTime dataConsulta);
}
