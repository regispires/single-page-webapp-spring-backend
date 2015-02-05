insert into instituicao (nome, sigla) values ('Universidade Federal do Ceará', 'UFC');
insert into instituicao (nome, sigla) values ('Universidade Federal do Piauí', 'UFPI');
insert into instituicao (nome, sigla) values ('Instituto Federal do Piauí', 'IFPI');
insert into instituicao (nome, sigla) values ('Instituto Federal do Ceará', 'IFCE');

insert into atividade (nome, qtdvagas) values ('Minicurso SPA', 20);
insert into atividade (nome, qtdvagas) values ('Minicurso jQuery', 21);
insert into atividade (nome, qtdvagas) values ('Minicurso SQL', 22);

insert into participante (datapagamento,email,nome,valorpago,instituicao_id) values ('2015-01-01', 'joao@gmail.com', 'joao', 10, 1);
insert into participante (datapagamento,email,nome,valorpago,instituicao_id) values ('2015-02-01', 'maria@gmail.com', 'maria', 20, 2);
insert into participante (datapagamento,email,nome,valorpago,instituicao_id) values ('2015-01-15', 'jose@gmail.com', 'José', 30, 2);

insert into fone (numero, operadora, participante_id) values ('85 3232-2233', 'Oi', 2);
insert into fone (numero, operadora, participante_id) values ('85 9191-2233', 'Tim', 2);
insert into fone (numero, operadora, participante_id) values ('85 9999-2233', 'Vivo', 1);

insert into participante_atividade values (1,2);
insert into participante_atividade values (2,1);
insert into participante_atividade values (2,2);
insert into participante_atividade values (3,1);
insert into participante_atividade values (3,3);
