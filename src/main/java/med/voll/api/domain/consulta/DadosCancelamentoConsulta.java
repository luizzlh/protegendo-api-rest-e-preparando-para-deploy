package med.voll.api.domain.consulta;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DadosCancelamentoConsulta(@NotNull
                                        Long idMedico,
                                        @NotNull
                                        Long idPaciente,
                                        @NotNull
                                        LocalDateTime data) {
}
