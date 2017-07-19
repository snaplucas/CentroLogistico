package application.interfaces;

import application.dto.EntregaDto;
import application.dto.PassoDto;

import java.util.List;

public interface IEntregaAppService {

    void adicionarEntrega(EntregaDto entregaDto);

    List<PassoDto> obterPassos(String entregaId);
}
