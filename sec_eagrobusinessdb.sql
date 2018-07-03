-- cria o banco de dados e o usuario da aplicação
-- DROP USER 'usrdbeagro'@'localhost';
-- DROP DATABASE sec_eagrobusiness;
CREATE  DATABASE sec_eagrobusiness;

CREATE USER 'usrdbeagro'@'localhost' IDENTIFIED BY 'eagro2business';
GRANT ALL PRIVILEGES ON sec_eagrobusiness.* TO 'usrdbeagro'@'localhost';

-- acessa o banco de dados recem criado
use sec_eagrobusiness;

create table perfil(
	id int auto_increment primary key,
	nome varchar(100),
    ativo boolean

);

create table usuario(
	id int auto_increment primary key,
	nome varchar(100),
	login varchar(100),
	email varchar(100),
	senha varchar(200),
    ativo boolean
    
);

create table recurso(
	id int auto_increment primary key,
	nome varchar(100)

);

create table usuario_perfil(
	id int auto_increment primary key,
    idusuario int references usuario(id),
    idperfil int references perfil(id)
    
);
create table recurso_perfil(
	id int auto_increment primary key,
	idrecurso int references recurso(id),
    idperfil int references perfil(id)
);



