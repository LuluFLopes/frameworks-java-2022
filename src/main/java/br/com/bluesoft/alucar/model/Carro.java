package br.com.bluesoft.alucar.model;

import br.com.bluesoft.alucar.form.CarroForm;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="carro_key")
    private Long id;
    @Column(nullable = false)
    private String placa;
    @Column(nullable = false)
    private String marca;
    @Column(nullable = false)
    private String modelo;
    @Column(nullable = false)
    private String cor;
    @Column(nullable = false)
    private Integer ano;
    @Column(nullable = false)
    private Integer quilometragem;
    @Column(nullable = false)
    private Double diaria;

    @OneToMany(mappedBy = "carro")
    private List<Aluguel> aluguel;

    public String getPlaca() {
        return placa;
    }

    public Carro(CarroForm form) {
        this.placa = form.getPlaca();
        this.marca = form.getMarca();
        this.modelo = form.getModelo();
        this.cor = form.getCor();
        this.ano = form.getAno();
        this.quilometragem = form.getQuilometragem();
        this.diaria = form.getDiaria();
    }

    public Carro() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Integer quilometragem) {
        this.quilometragem = quilometragem;
    }

    public Double getDiaria() {
        return diaria;
    }

    public void setDiaria(Double diaria) {
        this.diaria = diaria;
    }

    public List<Aluguel> getAluguel() {
        return aluguel;
    }

    public void setAluguel(List<Aluguel> aluguel) {
        this.aluguel = aluguel;
    }
}
