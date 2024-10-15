package sistemafinancas;

import bancoDados.Conexao;
import java.sql.Connection; // Import correto
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        Conexao c = new Conexao();
        Connection conexao = null;

        // Não é necessário fazer casting, pois o método já retorna Connection
        conexao = c.getConexao();
        if (conexao != null) {
            System.out.println("Conectado com sucesso!");
        } else {
            System.out.println("Falha na conexão.");
        }
        if (conexao != null) {
            try {
                conexao.close(); // Fecha a conexão
                System.out.println("Conexão fechada.");
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}
