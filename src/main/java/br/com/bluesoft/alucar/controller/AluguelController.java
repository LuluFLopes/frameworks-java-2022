package br.com.bluesoft.alucar.controller;

import br.com.bluesoft.alucar.dto.AluguelDto;
import br.com.bluesoft.alucar.dto.listas.ListaAluguelDto;
import br.com.bluesoft.alucar.form.AluguelForm;
import br.com.bluesoft.alucar.model.Aluguel;
import br.com.bluesoft.alucar.service.CrudAluguelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    private CrudAluguelService crudAluguelService;

    public AluguelController(CrudAluguelService crudAluguelService) {
        this.crudAluguelService = crudAluguelService;
    }

    @GetMapping
    public List<ListaAluguelDto> listar() {
        List<Aluguel> listaAluguel = crudAluguelService.listar();
        return ListaAluguelDto.converter(listaAluguel);
    }

    @PostMapping
    public ResponseEntity<AluguelDto> cadastrar(@RequestBody AluguelForm form, UriComponentsBuilder uriBuilder) {
        Aluguel aluguel = form.converter(form);
        crudAluguelService.cadastrar(aluguel);
        URI uri = uriBuilder.path("/alugueis/{id}").buildAndExpand(aluguel.getId()).toUri();
        return ResponseEntity.created(uri).body(new AluguelDto(aluguel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListaAluguelDto> atualizar(@PathVariable Long id, @RequestBody AluguelForm form){
        Optional<Aluguel> op = crudAluguelService.buscar(id);
        if (op.isPresent()) {
            Aluguel aluguel = form.atualizar(op.get());
            crudAluguelService.atualizar(aluguel);
            return ResponseEntity.ok(new ListaAluguelDto(aluguel));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable Long id){
        Optional<Aluguel> op = crudAluguelService.buscar(id);
        if (op.isPresent()) {
            crudAluguelService.excluir(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
