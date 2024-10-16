package DAO;

import java.util.ArrayList;

/**
 *
 * @author paloma
 */
public interface interfaceDAO<Objeto> {

    public void inserir(Objeto ob);

   // public void atualizar(Objeto ob);

    public void apagar(Objeto ob);
    
    public ArrayList<Objeto> consultar();
}
