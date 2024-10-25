package DAO;

import bancoDados.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import model.Dados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
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
    public void apagar(Dados d) {
        String sql = "DELETE FROM dados WHERE id = ?";

        try (Connection conn = this.conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, d.getId()); // Usa o ID para a exclusão
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Exclusão realizada com sucesso!");
            } else {
                System.out.println("Nenhum registro encontrado com o ID: " + d.getId());
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

    public boolean existeRegistro(String nome, String classificacao, double valor, LocalDate data, LocalDate dataCadastro) {
        String sql = "SELECT COUNT(*) FROM sua_tabela WHERE nome = ? AND classificacao = ? AND valor = ? AND data = ? AND dataCadastro = ?";
        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, classificacao);
            stmt.setDouble(3, valor);
            stmt.setDate(4, java.sql.Date.valueOf(data));
            stmt.setDate(5, java.sql.Date.valueOf(dataCadastro));

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Retorna true se houver registros
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false; // Retorna false se não houver registros
    }

    @Override
    public void atualizar(Dados ob) {
        String sql = "UPDATE DADOS SET NOME = ?, CLASSIFICACAO = ?, VALOR = ?, DATA = ?, DATACADASTRO = ? WHERE ID = ?";

        try (Connection conn = this.conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ob.getNome()); 
            stmt.setString(2, ob.getClassificacao()); 
            stmt.setDouble(3, ob.getValor()); 
            stmt.setDate(4, java.sql.Date.valueOf(ob.getData())); 
            stmt.setDate(5, java.sql.Date.valueOf(ob.getDataCadastro())); 
            stmt.setInt(6, ob.getId()); 

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Atualização realizada com sucesso!");
            } else {
                System.out.println("Nenhum registro encontrado com o ID: " + ob.getId());
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar dados: " + ex.getMessage(), ex);
        }
    }

}
