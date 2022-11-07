package br.com.bluesoft.alucar.dto;

import br.com.bluesoft.alucar.model.Cliente;
import br.com.bluesoft.alucar.model.Endereco;

import java.math.BigInteger;

public class ClienteDto {

    private String nome;
    private BigInteger cpf;
    private String email;
    private BigInteger celular;
    private Endereco endereco;

    public ClienteDto(Cliente cliente) {
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.celular = cliente.getCelular();
        this.endereco = cliente.getEndereco();
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
