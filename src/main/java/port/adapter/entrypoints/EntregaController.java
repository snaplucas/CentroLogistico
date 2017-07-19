package port.adapter.entrypoints;

import application.dto.EntregaDto;
import application.dto.PassoDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/entrega")
public class EntregaController {

    @PostMapping
    public ResponseEntity inserirEntrega(EntregaDto entregaDto) {
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/{entregaId}/passo")
    public List<PassoDto> obterPassos(@PathVariable("id") String id) {
        return new ArrayList<>();
    }
}
