package bancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao implements AutoCloseable { // Implementa a interface AutoCloseable

    private Connection conexao;

    // Método para obter a conexão
    public Connection getConexao() {
        if (conexao == null) {
            try {
                conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sistemafinanceiro", "root", "101100");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro de conexão: " + e.getMessage());
            }
        }
        return conexao;
    }

    // Método que fecha a conexão
    @Override
    public void close() {
        if (conexao != null) {
            try {
                conexao.close();
                conexao = null; // Limpa a referência
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}
