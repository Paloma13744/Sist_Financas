package DAO;

import bancoDados.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import sistemafinancas.Dados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author paloma
 */
public class DadosDAO implements interfaceDAO<Dados> {

    private Conexao conexao;

    public DadosDAO(Conexao conexao) {
        this.conexao = conexao;
    }

    @Override
    public void inserir(Dados d) {
        String sql = "INSERT INTO DADOS (NOME, CLASSIFICACAO, VALOR, DATA, DATACADASTRO) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = this.conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, d.getNome());
            stmt.setString(2, d.getClassificacao());
            stmt.setDouble(3, d.getValor());
            stmt.setDate(4, java.sql.Date.valueOf(d.getData().toString()));
            stmt.setDate(5, java.sql.Date.valueOf(d.getDataCadastro().toString()));

            stmt.executeUpdate();
            System.out.println("Inserção realizada com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir dados: " + ex.getMessage(), ex);
        }
    }

    @Override
    public void atualizar(Dados d) {
        String sql = "UPDATE DADOS SET NOME = ?, CLASSIFICACAO = ?, VALOR = ?, DATA = ?, DATACADASTRO = ? WHERE ID = ?";

        try (Connection conn = this.conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, d.getNome());
            stmt.setString(2, d.getClassificacao());
            stmt.setDouble(3, d.getValor());
            stmt.setDate(4, java.sql.Date.valueOf(d.getData().toString()));
            stmt.setDate(5, java.sql.Date.valueOf(d.getDataCadastro().toString()));
            stmt.setInt(6, d.getId());

            stmt.executeUpdate();
            System.out.println("Atualização realizada com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar dados: " + ex.getMessage(), ex);
        }
    }

    @Override
    public void apagar(Dados d) {
        String sql = "DELETE FROM DADOS WHERE NOME = ?"; 

        try (Connection conn = this.conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, d.getNome()); 

            int rowsAffected = stmt.executeUpdate(); 

            if (rowsAffected > 0) {
                System.out.println("Exclusão realizada com sucesso!");
            } else {
                System.out.println("Nenhum produto encontrado com o nome: " + d.getNome());
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao apagar dados: " + ex.getMessage(), ex);
        }
    }

    @Override
    public ArrayList<Dados> consultar() {
        ArrayList<Dados> listar = new ArrayList<>();
        String sql = "SELECT * FROM DADOS ORDER BY ID";

        try (Connection conn = this.conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {
                Dados dados = new Dados();

                dados.setId(resultado.getInt("ID"));
                dados.setNome(resultado.getString("NOME"));
                dados.setClassificacao(resultado.getString("CLASSIFICACAO"));
                dados.setValor(resultado.getDouble("VALOR"));
                dados.setData(resultado.getDate("DATA").toLocalDate());
                dados.setDataCadastro(resultado.getDate("DATACADASTRO").toLocalDate());

                listar.add(dados);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao consultar dados: " + ex.getMessage(), ex);
        }

        return listar;
    }

}
