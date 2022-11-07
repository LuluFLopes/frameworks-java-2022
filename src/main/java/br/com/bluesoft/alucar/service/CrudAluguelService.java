package br.com.bluesoft.alucar.service;

import br.com.bluesoft.alucar.model.Aluguel;
import br.com.bluesoft.alucar.repository.AluguelRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class CrudAluguelService {

    private AluguelRepository aluguelRepository;

    public CrudAluguelService(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    public void cadastrar (Aluguel aluguel) {
        aluguelRepository.save(aluguel);
    }

    public Optional<Aluguel> buscar(Long id) {
       Optional<Aluguel> op = aluguelRepository.findById(id);
       return op;
    }

    public List<Aluguel> listar(){
        Iterable<Aluguel> lista = aluguelRepository.findAll();
        List<Aluguel> listaAlugueis = StreamSupport.stream(lista.spliterator(), false).toList();
        return listaAlugueis;
    }

    public void atualizar (Aluguel aluguel) {
        aluguelRepository.save(aluguel);
    }

    public void excluir(Long id) {
        aluguelRepository.deleteById(id);
    }

}
