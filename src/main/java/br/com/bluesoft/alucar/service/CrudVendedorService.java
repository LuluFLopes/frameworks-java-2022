package br.com.bluesoft.alucar.service;

import br.com.bluesoft.alucar.model.Vendedor;
import br.com.bluesoft.alucar.repository.VendedorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class CrudVendedorService {

    private VendedorRepository vendedorRepository;

    public CrudVendedorService(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    public void cadastrar (Vendedor vendedor) {
        vendedorRepository.save(vendedor);
    }

    public Optional<Vendedor> buscar(Long id) {
        Optional<Vendedor> op = vendedorRepository.findById(id);
        return op;
    }

    public List<Vendedor> listar() {

        Iterable<Vendedor> lista = vendedorRepository.findAll();
        List<Vendedor> listaVendedor = StreamSupport.stream(lista.spliterator(), false).toList();

        return listaVendedor;

    }

    public void atualizar (Vendedor vendedor) {
        vendedorRepository.save(vendedor);
    }

    public void excluir(Long id) {
        vendedorRepository.deleteById(id);
    }

}
