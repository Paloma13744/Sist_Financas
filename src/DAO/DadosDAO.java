package DAO;

import bancoDados.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import sistemafinancas.Dados;
import java.sql.PreparedStatement;
/**
 *
 * @author paloma
 */
public class DadosDAO {
    private Conexao conexao;

    public DadosDAO(Conexao conexao) {
        this.conexao = conexao;
    }

     // Método para cadastrar dados
    public void cadastrarDados(Dados dados) throws SQLException {
        String sql = "INSERT INTO DADOS (nome, classificacao, valor, data, dataCadastro) VALUES (?, ?, ?, ?, ?)";
        Connection conexao = null;

        try {
           // conexao = Conexao();
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, dados.getNome());
                ps.setString(2, dados.getClassificacao());
                ps.setDouble(3, dados.getValor());
                ps.setDate(4, new Date(dados.getData().getTime()));
                ps.setDate(5, new Date(dados.getDataCadastro().getTime()));

                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
         //   Conexao.fecharConexao(conexao);
        }
    }

    // Método para atualizar dados
    public void atualizarDados(Dados dados) throws SQLException {
        String sql = "UPDATE DADOS SET valor = ?, data = ?, dataCadastro = ? WHERE nome = ? AND classificacao = ?";
        Connection conexao = null;

        try {
           // conexao = Conexao.getConexao();
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setDouble(1, dados.getValor());
                ps.setDate(2, new Date(dados.getData().getTime()));
                ps.setDate(3, new Date(dados.getDataCadastro().getTime()));
                ps.setString(4, dados.getNome());
                ps.setString(5, dados.getClassificacao());

                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
         //   Conexao.fecharConexao(conexao);
        }
    }

    // Método para apagar dados
    public void apagarDados(String nome, String classificacao) throws SQLException {
        String sql = "DELETE FROM DADOS WHERE nome = ? AND classificacao = ?";
        Connection conexao = null;

        try {
          //  conexao = Conexao.getConexao();
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, nome);
                ps.setString(2, classificacao);

                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
          //  Conexao.fecharConexao(conexao);
        }
    }
}
