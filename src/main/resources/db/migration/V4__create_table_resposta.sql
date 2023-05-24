CREATE TABLE resposta (
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    mensagem VARCHAR(255) NOT NULL,
    dataCriacao TIMESTAMP NOT NULL,
    solucao BOOLEAN NOT NULL,
    autor_id BIGINT NOT NULL,
    topico_id BIGINT NOT NULL,
    FOREIGN KEY (autor_id) REFERENCES usuario(id),
    FOREIGN KEY (topico_id) REFERENCES topico(id)
);