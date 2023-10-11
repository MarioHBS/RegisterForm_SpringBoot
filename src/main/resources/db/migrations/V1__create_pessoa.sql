CREATE TABLE pessoa (
    id varchar(36) NOT NULL PRIMARY KEY,
    nome_completo VARCHAR(60) NOT NULL,
    nascimento VARCHAR(10) NOT NULL,
    telefone VARCHAR(12) NULL,
    e_mail VARCHAR(45) NULL,
    cep VARCHAR(9) NULL,
    logradouro VARCHAR(45) NULL,
    numero VARCHAR(5) NULL,
    complemento VARCHAR(15) NULL,
    bairro VARCHAR(45) NULL,
    cidade VARCHAR(45) NULL,
    estado VARCHAR(15) NULL,
    UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE
)
COMMENT = 'pessoa com todos os dados';