package bancoDados;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    private Connection conexao;  // Criando conexão

    public Connection abrirConexao() {
        String url = "jdbc:mysql://localhost:3308/SistemaFinanceiro?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = ""; // Coloque a senha correta se houver
        
        try {
            // Estabelecendo a conexão
            conexao = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            e.printStackTrace();
        }

        return conexao;
    }

    public void fechandoConexao() {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("Conexão fechada com sucesso!");
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

