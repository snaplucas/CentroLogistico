package application.services;

import application.interfaces.IEntregaAppService;
import domain.model.interfaces.IEntregaService;

public class EntregaService implements IEntregaAppService {

    private final IEntregaService entregaService;

    public EntregaService(IEntregaService entregaService) {
        this.entregaService = entregaService;
    }
}
