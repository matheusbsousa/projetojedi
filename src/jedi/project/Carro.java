package jedi.project;

public class Carro {

    Long id;
    String modelo;
    int ano;
    String placa;

    public Carro(Long id, String modelo, int ano, String placa) {
        this.id = id;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
    }

    @Override
    public String toString(){
        return     this.id + "-" + this.modelo + "-" + this.ano + "-" + this.placa;
    }

    public Carro() {
    }
}
