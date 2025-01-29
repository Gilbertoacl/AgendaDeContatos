CREATE TABLE pessoas (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(20) NOT NULL,
    sobrenome VARCHAR(50) NOT NULL,
    data_nascimento DATE NOT NULL,
    cep VARCHAR(9) NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    complemento VARCHAR(100),
    bairro VARCHAR(30) NOT NULL,
    cidade VARCHAR(30) NOT NULL,
    uf VARCHAR(2) NOT NULL,
    numero VARCHAR(9),
    telefone VARCHAR(20),
    email VARCHAR(50),
    instagram VARCHAR(50),
    facebook VARCHAR(50),
    twitterX VARCHAR(50)
);
