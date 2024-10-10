package bancoDados;

import java.sql.Connection;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    private Connection conexao;  // Criando conexão

    public Connection abrirConexao() {
        String url = "jdbc:mysql://localhost:3308/SistemaFinanceiro";
        String user = "root";
        String password = "";

        return conexao;

    }

    public void fechandoConexao() {

        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
