CREATE TABLE pastoral (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	cep varchar(10) not null,
	cidade varchar(40) not null,
	logradouro varchar(40),
	bairro varchar(40),
	estado varchar(15),
	igreja_id bigint(20) not null,
	FOREIGN KEY (igreja_id) REFERENCES igreja(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;