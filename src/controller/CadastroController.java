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
        Dados dados = new Dados(id, nome, classificacao, valor, data, dataCadastro);
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

    public void removeDados(int id) {
        Dados dados = new Dados();
        dados.setId(id);
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

    public void updateDados(int id, String nome, String classificacao, double valor, LocalDate data, LocalDate dataCadastro) {
        Dados dadosExistentes = getDadosById(id);

        if (dadosExistentes != null) {
            // Atualiza os dados com as novas informações
            dadosExistentes.setNome(nome);
            dadosExistentes.setClassificacao(classificacao);
            dadosExistentes.setValor(valor);
            dadosExistentes.setData(data);
            dadosExistentes.setDataCadastro(dataCadastro);

            // Chama o método de atualização no DAO
            dadosDAO.atualizar(dadosExistentes);
        } else {
            System.out.println("Nenhum dado encontrado com o ID: " + id);
        }
    }

    
}
