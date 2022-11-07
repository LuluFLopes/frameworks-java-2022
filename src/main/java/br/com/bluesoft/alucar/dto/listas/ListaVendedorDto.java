package br.com.bluesoft.alucar.dto.listas;

import br.com.bluesoft.alucar.model.ContaCorrente;
import br.com.bluesoft.alucar.model.Vendedor;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ListaVendedorDto {

    private Long id;
    private BigInteger cpf;
    private LocalDateTime dataAdmissao;
    private ContaCorrente cc;

    public ListaVendedorDto(Vendedor vendedor) {
        this.id = vendedor.getId();
        this.cpf = vendedor.getCpf();
        this.dataAdmissao = vendedor.getDataAdmissao();
        this.cc = vendedor.getCc();
    }

    public static List<ListaVendedorDto> converter(List<Vendedor> vendedores) {
        return vendedores.stream().map(ListaVendedorDto::new).toList();
    }

    public Long getId() {
        return id;
    }

    public BigInteger getCpf() {
        return cpf;
    }

    public LocalDateTime getDataAdmissao() {
        return dataAdmissao;
    }

    public ContaCorrente getCc() {
        return cc;
    }
}
