// Classe de conexão
package bancoDados;

import DAO.interfaceDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Conexao {

    private Connection conexao;


    public Connection getConexao() {
        if (conexao == null) {
            try {
                conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sistemafinanceiro", "root","101100");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro de conexão: " + e.getMessage());
            }
        }
        return conexao;
    }

    public void fecharConexao() {
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
