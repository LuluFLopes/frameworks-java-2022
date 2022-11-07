package br.com.bluesoft.alucar.model;

import br.com.bluesoft.alucar.form.AluguelForm;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="aluguel")
public class Aluguel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="aluguel_key")
    private Long id;
    @Column(nullable = false)
    private LocalDateTime dataAluguel;
    @Column(nullable = false)
    private LocalDateTime dataRetorno;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Cliente cliente;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Vendedor vendedor;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Carro carro;

    public Aluguel(AluguelForm form) {
       this.dataAluguel = form.getDataAluguel();
       this.dataRetorno = form.getDataRetorno();
       this.cliente = form.getCliente();
       this.vendedor = form.getVendedor();
       this.carro = form.getCarro();
    }

    public Aluguel() {
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
