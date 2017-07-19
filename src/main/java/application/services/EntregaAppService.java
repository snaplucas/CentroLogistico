package application.services;

import application.dto.EntregaDto;
import application.interfaces.IEntregaAppService;
import domain.model.entities.Entrega;
import domain.model.interfaces.IEntregaService;

public class EntregaAppService implements IEntregaAppService {

    private final IEntregaService entregaService;

    public EntregaAppService(IEntregaService entregaService) {
        this.entregaService = entregaService;
    }

    @Override
    public void adicionarEntrega(EntregaDto entregaDto) {
        entregaService.adicionarEntrega(toDomainModel(entregaDto));
    }

    private Entrega toDomainModel(EntregaDto entregaDto) {
        Entrega entrega = new Entrega();
        entrega.setPacotes(entregaDto.getPacotes());
        entrega.setId(entregaDto.getId());
        entrega.setVeiculo(entregaDto.getVeiculo());
        return entrega;
    }
}
