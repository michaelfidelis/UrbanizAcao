create database urbanizacao;
create table localizacao (
	codigo bigint not null auto_increment, 
	bairro varchar(255) not null, 
	complemento varchar(255), 
	latitude double precision not null, 
	logradouro varchar(255) not null, 
	longitude double precision not null, 
	numero bigint, 
	estado varchar(2) not null,
	cidade varchar(100) not null,
	pontoReferencia varchar(255), 
	primary key (codigo));
	
create table tipodenuncia (
	codigo bigint not null auto_increment, 
	descricao varchar(255) not null, 
	primary key (codigo));
	
create table denuncia (
	codigo bigint not null auto_increment,
	delator varchar(200),
	data datetime not null, 
	descricao varchar(255), 
	tipodenuncia_fk bigint not null,
	localizacao_fk bigint not null,
	PRIMARY KEY (codigo),
	FOREIGN KEY (tipodenuncia_fk) REFERENCES tipodenuncia(codigo),
	FOREIGN KEY (localizacao_fk) REFERENCES localizacao(codigo));

create table tratativa (
	codigo bigint not null auto_increment,
	responsavel varchar(200) not null,
	data datetime not null, 
	descricao varchar(255) not null, 
	denuncia_fk bigint not null,
	PRIMARY KEY (codigo),
	FOREIGN KEY (denuncia_fk) REFERENCES denuncia(codigo));
