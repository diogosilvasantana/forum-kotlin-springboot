CREATE TABLE usuario(
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL
);

INSERT INTO usuario VALUES (1, 'Diogo Silva', 'diogosilvaoficial@gmail.com');