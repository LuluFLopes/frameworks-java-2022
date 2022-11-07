package br.com.bluesoft.alucar.service;

import br.com.bluesoft.alucar.model.Carro;
import br.com.bluesoft.alucar.repository.CarroRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class CrudCarroService {

   private CarroRepository carroRepository;

    public CrudCarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }


    public void cadastrar (Carro carro) {
        carroRepository.save(carro);
    }

    public Optional<Carro> buscar(Long id) {
        Optional<Carro> op = carroRepository.findById(id);
        return op;
    }

    public List<Carro> listar(){
        Iterable<Carro> lista = carroRepository.findAll();
        List<Carro> listaCarros = StreamSupport.stream(lista.spliterator(), false).toList();
        return listaCarros;
    }

    public void atualizar (Carro carro) {
        carroRepository.save(carro);
    }

    public void excluir(Long id) {
        carroRepository.deleteById(id);
    }


}
