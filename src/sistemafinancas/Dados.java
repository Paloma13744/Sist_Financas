package sistemafinancas;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author paloma
 */
public class Dados {

    private int id;
    private String nome;
    private String classificacao;
    private double valor;
    private LocalDate data;
    private LocalDate dataCadastro;

    public Dados(int id, String nome, String classificacao, double valor, LocalDate data, LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.classificacao = classificacao;
        this.valor = valor;
        this.data = data;
        this.dataCadastro = dataCadastro;
    }

  
    public Dados() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

 

}
