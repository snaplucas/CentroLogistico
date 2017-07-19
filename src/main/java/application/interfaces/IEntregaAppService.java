package application.interfaces;

import application.dto.EntregaDto;
import application.dto.PassoDto;
import application.exceptions.EntregaException;

import java.util.List;

public interface IEntregaAppService {

    void adicionarEntrega(EntregaDto entregaDto);

    List<PassoDto> obterPassos(String entregaId) throws EntregaException;
}
