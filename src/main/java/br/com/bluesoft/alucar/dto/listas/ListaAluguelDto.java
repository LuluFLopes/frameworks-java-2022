package br.com.bluesoft.alucar.dto.listas;

import br.com.bluesoft.alucar.model.Aluguel;
import br.com.bluesoft.alucar.model.Carro;
import br.com.bluesoft.alucar.model.Cliente;
import br.com.bluesoft.alucar.model.Vendedor;

import java.time.LocalDateTime;
import java.util.List;

public class ListaAluguelDto {

    private Long id;
    private LocalDateTime dataAluguel;
    private LocalDateTime dataRetorno;
    private Cliente cliente;
    private Vendedor vendedor;
    private Carro carro;

    public ListaAluguelDto(Aluguel aluguel) {
        this.id = aluguel.getId();
        this.dataAluguel = aluguel.getDataAluguel();
        this.dataRetorno = aluguel.getDataRetorno();
        this.cliente = aluguel.getCliente();
        this.vendedor = aluguel.getVendedor();
        this.carro = aluguel.getCarro();
    }

    public static List<ListaAluguelDto> converter(List<Aluguel> alugueis) {
        return alugueis.stream().map(ListaAluguelDto::new).toList();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataAluguel() {
        return dataAluguel;
    }

    public LocalDateTime getDataRetorno() {
        return dataRetorno;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public Carro getCarro() {
        return carro;
    }
}
