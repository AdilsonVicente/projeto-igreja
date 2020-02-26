create table igreja (
	id bigint(20) primary key auto_increment,
	nome varchar(50) not null,
	data_cadastro datetime,
	cep varchar(10) not null,
	cidade varchar(40) not null,
	logradouro varchar(40),
	bairro varchar(40),
	estado varchar(15)
) engine=InnoDB default charset=utf8;
