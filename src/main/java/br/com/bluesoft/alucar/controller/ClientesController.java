package br.com.bluesoft.alucar.controller;

import br.com.bluesoft.alucar.dto.ClienteDto;
import br.com.bluesoft.alucar.dto.listas.ListaClientesDto;
import br.com.bluesoft.alucar.form.ClienteForm;
import br.com.bluesoft.alucar.model.Cliente;
import br.com.bluesoft.alucar.service.CrudClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    private CrudClienteService crudClienteService;

    public ClientesController(CrudClienteService crudClienteService) {
        this.crudClienteService = crudClienteService;
    }

    @GetMapping
    public List<ListaClientesDto> listar() {

        List<Cliente> listaCliente = crudClienteService.listar();
        return ListaClientesDto.converter(listaCliente);

    }

    @PostMapping
    public ResponseEntity<ClienteDto> cadastrar(@RequestBody ClienteForm form, UriComponentsBuilder uriBuilder) {

        Cliente cliente = form.converter(form);
        crudClienteService.cadastrar(cliente);
        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getClienteKey()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDto(cliente));

    }

    @PutMapping("/{id}")
    public ResponseEntity<ListaClientesDto> atualizar(@PathVariable Long id, @RequestBody ClienteForm form) {

        Optional<Cliente> op = crudClienteService.buscar(id);
        if (op.isPresent()) {
            Cliente cliente = form.atualizar(op.get());
            crudClienteService.atualizar(cliente);
            return ResponseEntity.ok(new ListaClientesDto(cliente));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable Long id) {

        Optional<Cliente> op = crudClienteService.buscar(id);
        if (op.isPresent()) {
            crudClienteService.excluir(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
