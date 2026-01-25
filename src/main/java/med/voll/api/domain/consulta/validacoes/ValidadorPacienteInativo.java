package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidadorPacienteInativo {

    @Autowired
    private PacienteRepository pacienteRepository;

    public void validar(DadosAgendamentoConsulta dadosAgendamentoConsulta) {

        var pacienteEstaAtivo = pacienteRepository.findAtivoById(dadosAgendamentoConsulta.idPaciente());

        if(!pacienteEstaAtivo) {
            throw new RuntimeException("Paciente não está ativo no sistema!");
        }
    }

}
