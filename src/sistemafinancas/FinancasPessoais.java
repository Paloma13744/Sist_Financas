
package sistemafinancas;

import java.util.Date;

/**
 *
 * @author paloma
 */
public class FinancasPessoais {
    private String nome;
    private  String classificacao ;
    private double valor;
    private Date data;
    private Date dataCadastro;

    public FinancasPessoais(String nome, String classificacao, double valor, Date data, Date dataCadastro) {
        this.nome = nome;
        this.classificacao = classificacao;
        this.valor = valor;
        this.data = data;
        this.dataCadastro = dataCadastro;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    
    
    
    
}
