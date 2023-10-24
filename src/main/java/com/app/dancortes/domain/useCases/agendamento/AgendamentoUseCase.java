package com.app.dancortes.domain.useCases.agendamento;

import com.app.dancortes.adapters.controllers.dtos.request.CancelarAgendamentoRequest;
import com.app.dancortes.adapters.controllers.dtos.request.CriarAgendamentoRequest;
import com.app.dancortes.adapters.controllers.dtos.request.DisponibilidadeAgendamentoRequest;
import com.app.dancortes.adapters.controllers.dtos.response.CancelarAgendamentoResponse;
import com.app.dancortes.adapters.controllers.dtos.response.CriarAgendamentoResponse;
import com.app.dancortes.adapters.controllers.dtos.response.DisponibilidadeAgendamentoResponse;
import org.springframework.http.ResponseEntity;

public interface AgendamentoUseCase {
    ResponseEntity<CriarAgendamentoResponse> criarAgendamento(CriarAgendamentoRequest criarAgendamentoRequest);
    ResponseEntity<CancelarAgendamentoResponse> cancelarAgendamento(CancelarAgendamentoRequest cancelarAgendamentoRequest);
    ResponseEntity<DisponibilidadeAgendamentoResponse> disponibilidadeAgendamento(DisponibilidadeAgendamentoRequest disponibilidadeAgendamentoRequest);
}
