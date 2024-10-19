package controller;

import DAO.DadosDAO;
import model.Dados;

import java.time.LocalDate;
import java.util.ArrayList;

public class CadastroController {

    private DadosDAO dadosDAO;

    public CadastroController(DadosDAO dadosDAO) {
        this.dadosDAO = dadosDAO;
    }

    public void addDados(int id, String nome, String classificacao, double valor, LocalDate data, LocalDate dataCadastro) {
        Dados dados = new Dados(0, nome, classificacao, valor, data, dataCadastro);
        dadosDAO.inserir(dados);
    }

    public void listDados() {
        ArrayList<Dados> dadosList = dadosDAO.consultar();
        if (dadosList.isEmpty()) {
            System.out.println("Nenhum dado cadastrado.");
        } else {
            dadosList.forEach(System.out::println);
        }
    }

    public void removeDados(String nomeProduto) {
        Dados dados = new Dados();
        dados.setNome(nomeProduto);
        dadosDAO.apagar(dados);
    }

    public Dados getDadosById(int id) {
        ArrayList<Dados> dadosList = dadosDAO.consultar();
        for (Dados dados : dadosList) {
            if (dados.getId() == id) {
                return dados;
            }
        }
        return null;
    }
}
