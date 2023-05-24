CREATE TABLE curso(
    id BIGINT PRIMARY KEY NOT NULL,
    nome VARCHAR(50) NOT NULL,
    categoria VARCHAR(50) NOT NULL
);

INSERT INTO curso VALUES (1, 'Kotlin', 'Programação');