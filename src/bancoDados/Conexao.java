// Classe de conexão

package bancoDados;

import DAO.interfaceDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;


public class Conexao {

    private String servidor;
    private String banco;
    private String usuario;
    private String senha;
    private Connection conexao;

    public Conexao(String servidor, String banco, String usuario, String senha) {
        this.servidor = "127.0.0.1";
        this.banco = "sistemafinanceiro";
        this.usuario = "root";
        this.senha = "";
    }

    public boolean conectar() {
        try {
            this.conexao = DriverManager.getConnection("jdbc:mysql://" + this.servidor + "/", this.banco, this.senha);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConexao() {
        return conexao;
    }
    

   

}

