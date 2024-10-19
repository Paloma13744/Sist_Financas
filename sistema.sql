use sistemafinanceiro;

SELECT * FROM dados;

CREATE TABLE dados (
    id INT AUTO_INCREMENT PRIMARY KEY,  
    nome VARCHAR(100) NOT NULL,        
    classificacao VARCHAR(50) NOT NULL, 
    valor DECIMAL(10, 2) NOT NULL,     
    data DATE NOT NULL,             
    dataCadastro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP 
    );

SHOW TABLES;

DELETE FROM dados WHERE id = 38;


