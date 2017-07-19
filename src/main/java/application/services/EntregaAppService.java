package application.services;

import application.dto.EntregaDto;
import application.dto.PassoDto;
import application.exceptions.EntregaException;
import application.interfaces.IEntregaAppService;
import domain.model.entities.Entrega;
import domain.model.entities.Passo;
import domain.model.interfaces.IEntregaService;

import java.util.List;
import java.util.stream.Collectors;

public class EntregaAppService implements IEntregaAppService {

    private final IEntregaService entregaService;

    public EntregaAppService(IEntregaService entregaService) {
        this.entregaService = entregaService;
    }

    @Override
    public void adicionarEntrega(EntregaDto entregaDto) {
        entregaService.adicionarEntrega(toDomainModel(entregaDto));
    }

    @Override
    public List<PassoDto> obterPassos(String entregaId) throws EntregaException {
        Entrega entrega = entregaService.obterEntrega(entregaId);
        if (entrega != null) {
            return entrega.definirPassos().stream().map(this::toDto).collect(Collectors.toList());
        }
        throw new EntregaException("Entrega não encotrada");
    }

    private Entrega toDomainModel(EntregaDto entregaDto) {
        Entrega entrega = new Entrega();
        entrega.setPacotes(entregaDto.getPacotes());
        entrega.setId(entregaDto.getId());
        entrega.setVeiculo(entregaDto.getVeiculo());
        return entrega;
    }

    private PassoDto toDto(Passo passo) {
        PassoDto passoDto = new PassoDto();
        passoDto.setDe(passo.getDe());
        passoDto.setPara(passo.getPara());
        passoDto.setPacoteId(passo.getPacoteId());
        return passoDto;
    }
}
