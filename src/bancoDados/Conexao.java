package bancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao implements AutoCloseable {
    private Connection conexao;

    public Connection getConexao() {
        try {
            // Se a conexão estiver fechada, abra uma nova
            if (conexao == null || conexao.isClosed()) {
                conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sistemafinanceiro", "root", "101100");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão: " + e.getMessage());
        }
        return conexao;
    }

    @Override
    public void close() {
        if (conexao != null) {
            try {
                conexao.close();
                conexao = null; // Limpa a referência após fechar
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}
