use sec_eagrobusiness;

insert into perfil(nome,ativo) values('ADMIN',true);
insert into perfil(nome,ativo) values('CLIENTE',true);
insert into perfil(nome,ativo) values('CLIENTE_ESPCIAL',true);

insert into recurso(nome)values('produto-api');

insert into recurso_perfil(idrecurso,idperfil)values(1,1);
insert into recurso_perfil(idrecurso,idperfil)values(1,3);

insert into usuario(nome,login,email,senha,ativo)values('Eduardo','eduusr','es_goncalves@msn.com','$2a$10$RkTVD0vVnTO9PcU2VbSOButxB3bavOmic/.cuhp4.0a9uml5Vg.bm',true);
insert into usuario(nome,login,email,senha,ativo)values('Eduardo Cliente Comum','cliente','es_goncalves_1@msn.com','$2a$10$RkTVD0vVnTO9PcU2VbSOButxB3bavOmic/.cuhp4.0a9uml5Vg.bm',true);
insert into usuario(nome,login,email,senha,ativo)values('Eduardo Cliente Especial','especial','es_goncalves_2@msn.com','$2a$10$RkTVD0vVnTO9PcU2VbSOButxB3bavOmic/.cuhp4.0a9uml5Vg.bm',true);

insert into usuario_perfil(idusuario,idperfil)values(1,1);
insert into usuario_perfil(idusuario,idperfil)values(1,3);
insert into usuario_perfil(idusuario,idperfil)values(2,2);
insert into usuario_perfil(idusuario,idperfil)values(3,3);





