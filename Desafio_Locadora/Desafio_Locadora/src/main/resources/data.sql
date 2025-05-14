-- Inserir fabricantes
INSERT INTO fabricante (nome) VALUES ('Toyota');
INSERT INTO fabricante (nome) VALUES ('Honda');

-- Inserir modelos de carro
INSERT INTO modelo_carro (descricao, categoria, fabricante_id_fabricante) VALUES ('Corolla', 'SEDAN_MEDIO', 1);
INSERT INTO modelo_carro (descricao, categoria, fabricante_id_fabricante) VALUES ('Civic', 'SEDAN_MEDIO', 2);
INSERT INTO modelo_carro (descricao, categoria, fabricante_id_fabricante) VALUES ('Fortuner', 'UTILITARIO_COMERCIAL', 1);

-- Inserir acessórios de carros
INSERT INTO acessorio_carro (descricao) VALUES ('Ar-condicionado');
INSERT INTO acessorio_carro (descricao) VALUES ('Direção Hidráulica');
INSERT INTO acessorio_carro (descricao) VALUES ('Multimídia');
INSERT INTO acessorio_carro (descricao) VALUES ('Teto Solar');

-- Inserir carros
INSERT INTO carros (placa, chassi, cor, valor_diaria, reservado, modelo_carro_id_modelo_carro)
VALUES ('ABC1234', '9BWZZZ377VT004251', 'Prata', 150.00, FALSE, 1);
INSERT INTO carros (placa, chassi, cor, valor_diaria, reservado, modelo_carro_id_modelo_carro)
VALUES ('DEF5678', '9BWZZZ377VT004252', 'Preto', 180.00, TRUE, 2);
INSERT INTO carros (placa, chassi, cor, valor_diaria, reservado, modelo_carro_id_modelo_carro)
VALUES ('GHI9012', '9BWZZZ377VT004253', 'Azul', 200.00, FALSE, 3);

-- Inserir relação entre carros e acessórios
INSERT INTO carro_acessorio (id_carros, id_acessorio_carro) VALUES (1, 1), (1, 2);
INSERT INTO carro_acessorio (id_carros, id_acessorio_carro) VALUES (2, 3), (2, 4);
INSERT INTO carro_acessorio (id_carros, id_acessorio_carro) VALUES (3, 2), (3, 3);

-- Inserir apólices de seguro
INSERT INTO apolice_seguro (valor_franquia, protecao_terceiro, protecao_causas_naturais, protecao_roubo)
VALUES (1000.00, TRUE, TRUE, TRUE);
INSERT INTO apolice_seguro (valor_franquia, protecao_terceiro, protecao_causas_naturais, protecao_roubo)
VALUES (1500.00, TRUE, FALSE, TRUE);

-- Inserir funcionários
INSERT INTO funcionario (nome, data_nascimento, cpf, sexo, email, matricula)
VALUES ('Carlos Silva', '1985-07-15', '12345678901', 'MASCULINO', 'carlos@empresa.com', 'FUNC001');
INSERT INTO funcionario (nome, data_nascimento, cpf, sexo, email, matricula)
VALUES ('Ana Souza', '1992-08-20', '23456789012', 'FEMININO', 'ana@empresa.com', 'FUNC002');

-- Inserir motoristas
INSERT INTO motorista (nome, data_nascimento, cpf, sexo, email, numero_cnh)
VALUES ('Maria Souza', '1990-02-20', '98765432100', 'FEMININO', 'maria@gmail.com', 'CNH12345678');
INSERT INTO motorista (nome, data_nascimento, cpf, sexo, email, numero_cnh)
VALUES ('João Oliveira', '1980-06-10', '87654321009', 'MASCULINO', 'joao@gmail.com', 'CNH87654321');

-- Inserir aluguel de veículos
INSERT INTO aluguel (data_pedido, data_entrega, data_devolucao, valor_total, apolice_seguro_id_apolice_seguro, motorista_id, veiculo_id_carros)
VALUES (CURRENT_DATE, CURRENT_DATE + INTERVAL 2 DAY, CURRENT_DATE + INTERVAL 5 DAY, 450.00, 1, 1, 1);
INSERT INTO aluguel (data_pedido, data_entrega, data_devolucao, valor_total, apolice_seguro_id_apolice_seguro, motorista_id, veiculo_id_carros)
VALUES (CURRENT_DATE, CURRENT_DATE + INTERVAL 1 DAY, CURRENT_DATE + INTERVAL 3 DAY, 600.00, 2, 2, 2);
