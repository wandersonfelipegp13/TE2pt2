# Hibernate: entidade com relacionamentos

## Banco de Dados

```sql

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

```

## Diagrama de classes

![Diagrama de classes](https://raw.githubusercontent.com/wandersonfelipegp13/TE2pt2/master/src/main/java/edu/te2/m3/e3/hibernate/biblioteca/Diagrama%20de%20classes.png)