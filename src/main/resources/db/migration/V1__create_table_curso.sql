CREATE TABLE curso(
    id BIGINT PRIMARY KEY NOT NULL,
    nome VARCHAR(50) NOT NULL,
    categoria VARCHAR(50) NOT NULL
);

INSERT INTO curso VALUES (1, 'Kotlin', 'Programação');
INSERT INTO curso VALUES (2, 'HTML', 'Front-end');
INSERT INTO curso VALUES (3, 'React', 'Front-end');
INSERT INTO curso VALUES (4, 'C#', 'Back-End');