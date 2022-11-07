package br.com.bluesoft.alucar.controller;

import br.com.bluesoft.alucar.dto.VendedorDto;
import br.com.bluesoft.alucar.dto.listas.ListaVendedorDto;
import br.com.bluesoft.alucar.form.VendedorForm;
import br.com.bluesoft.alucar.model.Vendedor;
import br.com.bluesoft.alucar.service.CrudVendedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendedores")
public class VendoresController {

    private CrudVendedorService crudVendedorService;

    public VendoresController(CrudVendedorService crudVendedorService) {
        this.crudVendedorService = crudVendedorService;
    }

    @GetMapping
    public List<ListaVendedorDto> listar() {

        List<Vendedor> listaVendedor = crudVendedorService.listar();
        return ListaVendedorDto.converter(listaVendedor);

    }

    @PostMapping
    public ResponseEntity<VendedorDto> cadastrar(@RequestBody VendedorForm form, UriComponentsBuilder uriBuilder) {

        Vendedor vendedor = form.converter(form);
        crudVendedorService.cadastrar(vendedor);
        URI uri = uriBuilder.path("/vendedores/{id}").buildAndExpand(vendedor.getId()).toUri();
        return ResponseEntity.created(uri).body(new VendedorDto(vendedor));

    }

    @PutMapping("/{id}")
    public ResponseEntity<ListaVendedorDto> atualizar(@PathVariable Long id, @RequestBody VendedorForm form) {

        Optional<Vendedor> op = crudVendedorService.buscar(id);
        if (op.isPresent()) {
            Vendedor vendedor = form.atualizar(op.get());
            crudVendedorService.atualizar(vendedor);
            return ResponseEntity.ok(new ListaVendedorDto(vendedor));
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable Long id){

        Optional<Vendedor> op = crudVendedorService.buscar(id);
        if (op.isPresent()) {
            crudVendedorService.excluir(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }

}
