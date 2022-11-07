package br.com.bluesoft.alucar.controller;

import br.com.bluesoft.alucar.dto.CarroDto;
import br.com.bluesoft.alucar.dto.listas.ListaCarroDto;
import br.com.bluesoft.alucar.form.CarroForm;
import br.com.bluesoft.alucar.model.Carro;
import br.com.bluesoft.alucar.service.CrudCarroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carros")
public class CarrosController {

    private CrudCarroService crudCarroService;

    public CarrosController(CrudCarroService crudCarroService) {
        this.crudCarroService = crudCarroService;
    }

    @GetMapping
    public List<ListaCarroDto> listar(){
        List<Carro> listaCarro = crudCarroService.listar();
        return ListaCarroDto.converter(listaCarro);
    }

    @PostMapping
    public ResponseEntity<CarroDto> cadastrar(@RequestBody CarroForm form, UriComponentsBuilder uriBuilder) {

        Carro carro = form.converter(form);
        crudCarroService.cadastrar(carro);
        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(carro.getId()).toUri();
        return ResponseEntity.created(uri).body(new CarroDto(carro));

    }

    @PutMapping("/{id}")
    public ResponseEntity<ListaCarroDto> atualizar(@PathVariable Long id, @RequestBody CarroForm form) {

        Optional<Carro> op = crudCarroService.buscar(id);
        if (op.isPresent()) {
            Carro carro = form.atualizar(op.get());
            crudCarroService.atualizar(carro);
            return ResponseEntity.ok(new ListaCarroDto(carro));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable Long id){

        Optional<Carro> op = crudCarroService.buscar(id);
        if (op.isPresent()) {
            crudCarroService.excluir(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }

}
