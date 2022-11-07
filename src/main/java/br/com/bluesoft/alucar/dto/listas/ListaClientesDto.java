package br.com.bluesoft.alucar.dto.listas;

import br.com.bluesoft.alucar.model.Cliente;
import br.com.bluesoft.alucar.model.Endereco;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class ListaClientesDto {

    private Long id;
    private String nome;
    private BigInteger cpf;
    private String email;
    private BigInteger celular;
    private Endereco endereco;

    public ListaClientesDto(Cliente cliente) {
        this.id = cliente.getClienteKey();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.celular = cliente.getCelular();
        this.endereco = cliente.getEndereco();
    }

    public static List<ListaClientesDto> converter(List<Cliente> clientes) {
        return clientes.stream().map(ListaClientesDto::new).toList();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigInteger getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public BigInteger getCelular() {
        return celular;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
