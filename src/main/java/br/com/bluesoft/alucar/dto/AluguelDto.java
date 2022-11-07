package br.com.bluesoft.alucar.dto;

import br.com.bluesoft.alucar.model.Aluguel;
import br.com.bluesoft.alucar.model.Carro;
import br.com.bluesoft.alucar.model.Cliente;
import br.com.bluesoft.alucar.model.Vendedor;

import java.time.LocalDateTime;

public class AluguelDto {

    private LocalDateTime dataAluguel;
    private LocalDateTime dataRetorno;
    private Cliente cliente;
    private Vendedor vendedor;
    private Carro carro;

    public AluguelDto(Aluguel aluguel) {
        this.dataAluguel = aluguel.getDataAluguel();
        this.dataRetorno = aluguel.getDataRetorno();
        this.cliente = aluguel.getCliente();
        this.vendedor = aluguel.getVendedor();
        this.carro = aluguel.getCarro();
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
