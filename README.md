

# Sistema Financeiro com Swing  💰

![image](https://github.com/user-attachments/assets/b0bbdb38-4de9-489f-8df1-c9bc6948d4da)


Este projeto é um sistema de cadastro desenvolvido em Java utilizando a biblioteca Swing para a interface gráfica. O sistema permite cadastrar, atualizar, apagar e salvar informações relacionadas a despesas e recebimentos pessoais.

## Funcionalidades

- **Cadastro de Dados**: Permite ao usuário cadastrar informações pessoais.
- **Atualização de Dados**: Possibilita a atualização das informações já cadastradas.
- **Exclusão de Dados**: Permite ao usuário apagar dados cadastrados.
- **Listagem de Dados**: Mostra todos os dados cadastrados para fácil visualização.

## Estrutura do Projeto

O projeto é composto pelas seguintes classes principais:

- **`CadastroForm`**: Classe responsável pela interface gráfica do sistema. Utiliza componentes Swing para capturar e exibir dados ao usuário.
- **`Dados`**: Classe que contém a estrutura dos dados a serem armazenados, como nome, valor e tipo de despesa ou recebimento.
- **`Dao`**: Classe responsável pela manipulação dos dados no banco de dados. Inclui métodos para criar, ler, atualizar e excluir registros (CRUD).
- **`Main`**: Classe principal que inicia o aplicativo e conecta todas as partes do sistema.

## Requisitos

- Java JDK 8 ou superior
- IDE de sua escolha (por exemplo, IntelliJ IDEA, Eclipse, NetBeans)
- Banco de dados configurado (MySQL, SQLite, etc.)

## Como Executar o Projeto

1. **Clone o Repositório**:
   ```bash
   git clone https://github.com/Paloma13744/Sist_Financas.git
