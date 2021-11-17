CREATE DATABASE biblioteca;
USE biblioteca;

CREATE TABLE editora(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL
	
) ENGINE=InnoDB;

CREATE TABLE livro(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	titulo VARCHAR(300) NOT NULL,
	preco DOUBLE,
	lancamento DATE,
	
	editora_id INT,
	CONSTRAINT fk_Editora FOREIGN KEY (editora_id) REFERENCES Editora (id)
		
) ENGINE=InnoDB;

INSERT INTO editora (nome) VALUES 
("Saraiva"),
("Objetiva");

INSERT INTO livro (titulo, preco, lancamento, editora_id) VALUES 
("Teste 1", 12.4, "2021-02-12", 1),
("Teste 2", 32.6, "2020-04-08", 2);
