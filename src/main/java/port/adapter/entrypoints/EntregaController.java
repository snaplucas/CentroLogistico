package port.adapter.entrypoints;

import application.dto.EntregaDto;
import application.dto.PassoDto;
import application.interfaces.IEntregaAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrega")
public class EntregaController {

    private final IEntregaAppService entregaAppService;

    @Autowired
    public EntregaController(IEntregaAppService entregaAppService) {
        this.entregaAppService = entregaAppService;
    }

    @PostMapping
    public ResponseEntity inserirEntrega(@RequestBody EntregaDto entregaDto) {
        entregaAppService.adicionarEntrega(entregaDto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/{entregaid}")
    public List<PassoDto> obterPassos(@PathVariable String entregaid) {
        return entregaAppService.obterPassos(entregaid);
    }
}
