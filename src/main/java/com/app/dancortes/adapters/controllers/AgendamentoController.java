package com.app.dancortes.adapters.controllers;

import com.app.dancortes.adapters.controllers.dtos.request.CancelarAgendamentoRequest;
import com.app.dancortes.adapters.controllers.dtos.request.CriarAgendamentoRequest;
import com.app.dancortes.adapters.controllers.dtos.request.DisponibilidadeAgendamentoRequest;
import com.app.dancortes.adapters.controllers.dtos.response.CancelarAgendamentoResponse;
import com.app.dancortes.adapters.controllers.dtos.response.CriarAgendamentoResponse;
import com.app.dancortes.adapters.controllers.dtos.response.DisponibilidadeAgendamentoResponse;
import com.app.dancortes.domain.useCases.agendamento.AgendamentoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/agendamento")
public class AgendamentoController {

    @Autowired
    AgendamentoUseCase agendamentoUseCase;

    @PostMapping("/criar-agendamento")
    public ResponseEntity<CriarAgendamentoResponse> criarAgendamento(@RequestBody CriarAgendamentoRequest criarAgendamentoRequest){
        return agendamentoUseCase.criarAgendamento(criarAgendamentoRequest);
    }

    @PostMapping("/cancelar-agendamento")
    public ResponseEntity<CancelarAgendamentoResponse> cancelarAgendamento(@RequestBody CancelarAgendamentoRequest cancelarAgendamentoRequest){
        return agendamentoUseCase.cancelarAgendamento(cancelarAgendamentoRequest);
    }

    @GetMapping("/disponibilidade-agendamento")
    public ResponseEntity<DisponibilidadeAgendamentoResponse> disponibilidadeAgendamento(@RequestBody DisponibilidadeAgendamentoRequest disponibilidadeAgendamentoRequest){
        return agendamentoUseCase.disponibilidadeAgendamento(disponibilidadeAgendamentoRequest);
    }
}
