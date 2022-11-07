package br.com.bluesoft.alucar.dto.listas;

import br.com.bluesoft.alucar.model.Carro;

import java.util.List;

public class ListaCarroDto {

    private Long id;
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private Integer ano;
    private Integer quilometragem;
    private Double diaria;

    public ListaCarroDto(Carro carro) {
        this.id = carro.getId();
        this.placa = carro.getPlaca();
        this.marca = carro.getMarca();
        this.modelo = carro.getModelo();
        this.cor = carro.getCor();
        this.ano = carro.getAno();
        this.quilometragem = carro.getQuilometragem();
        this.diaria = carro.getDiaria();
    }

    public static List<ListaCarroDto> converter(List<Carro> carros) {
        return carros.stream().map(ListaCarroDto::new).toList();
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public Integer getAno() {
        return ano;
    }

    public Integer getQuilometragem() {
        return quilometragem;
    }

    public Double getDiaria() {
        return diaria;
    }
}
