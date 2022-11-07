package br.com.bluesoft.alucar.service;

import br.com.bluesoft.alucar.model.Cliente;
import br.com.bluesoft.alucar.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class CrudClienteService {

    private ClienteRepository clienteRepository;

    public CrudClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    public void cadastrar (Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public Optional<Cliente> buscar(Long id) {
        Optional<Cliente> op = clienteRepository.findById(id);
        return op;
    }

    public List<Cliente> listar() {
        Iterable<Cliente> lista = clienteRepository.findAll();
        List<Cliente> listaClientes = StreamSupport.stream(lista.spliterator(), false).toList();
        return listaClientes;
    }

    public void atualizar (Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }
}
