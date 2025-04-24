CREATE DATABASE contestoque;

USE contestoque;

CREATE TABLE produto (
    cod INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10,2) NOT NULL
);

select * from produto;

-- drop database contestoque;

