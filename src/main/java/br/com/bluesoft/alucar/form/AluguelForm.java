package br.com.bluesoft.alucar.form;

import br.com.bluesoft.alucar.model.Aluguel;
import br.com.bluesoft.alucar.model.Carro;
import br.com.bluesoft.alucar.model.Cliente;
import br.com.bluesoft.alucar.model.Vendedor;

import java.time.LocalDateTime;

public class AluguelForm {

    private Long id;
    private LocalDateTime dataAluguel;
    private LocalDateTime dataRetorno;
    private Cliente cliente;
    private Vendedor vendedor;
    private Carro carro;

    public Aluguel converter(AluguelForm form){
        return new Aluguel(form);
    }

    public Aluguel atualizar(Aluguel aluguel){
        aluguel.setId(getId());
        aluguel.setDataAluguel(getDataAluguel());
        aluguel.setDataRetorno(getDataRetorno());
        aluguel.setCliente(getCliente());
        aluguel.setVendedor(getVendedor());
        aluguel.setCarro(getCarro());
        return aluguel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(LocalDateTime dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public LocalDateTime getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(LocalDateTime dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
