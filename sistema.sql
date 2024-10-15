use sistemafinanceiro;

SELECT * FROM dados;

CREATE TABLE dados (
    nome VARCHAR(100) NOT NULL,        
    classificacao VARCHAR(50) NOT NULL, 
    valor DECIMAL(10, 2) NOT NULL,     
    data DATE NOT NULL,             
    dataCadastro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP 
    );


DELETE FROM dados WHERE id = 1;
