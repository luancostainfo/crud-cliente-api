set foreign_key_checks = 0;
truncate endereco;
truncate telefone;
truncate email;
truncate cliente;
truncate usuario_permissao;
truncate usuario;
truncate permissao;

insert into cliente (nome, cpf)
values ('Luan', '05256556118');

insert into endereco (cliente_id, cep, logradouro, bairro, cidade, uf, complemento)
values (1, '72345205', 'QR 223 Conjunto 05 Casa 16', 'Samambaia Norte', 'Brasília', 'DF',
        'Próximo a padaria Big Massas');

insert into email (cliente_id, endereco_email)
values (1, 'luan1@gmail.com'),
       (1, 'luan2@gmail.com');

insert into telefone (cliente_id, numero_telefone, tipo_telefone)
values (1, '61982429636', 'CELULAR'),
       (1, '6133595684', 'RESIDENCIAL'),
       (1, '6133595487', 'COMERCIAL');

# --

insert into cliente (nome, cpf)
values ('Alen', '41702379191');

insert into endereco (cliente_id, cep, logradouro, bairro, cidade, uf, complemento)
values (2, '72345300', 'Logradouro do Paranoá', 'Liberdade', 'São Paulo', 'SP',
        'Complemento Legal');

insert into email (cliente_id, endereco_email)
values (2, 'alen1@gmail.com'),
       (2, 'alen2@gmail.com');

insert into telefone (cliente_id, numero_telefone, tipo_telefone)
values (2, '61982429636', 'CELULAR'),
       (2, '61985414798', 'CELULAR');

INSERT INTO usuario (id, nome, email, senha)
values (1, 'Aministrador', 'admin', '$2a$12$vTA5fjALuY1CndIcrLyq2OUoTSyrU860RX3OzQno.gHMCa22xDlW6');
INSERT INTO usuario (id, nome, email, senha)
values (2, 'Comum', 'comum', '$2a$12$vTA5fjALuY1CndIcrLyq2OUoTSyrU860RX3OzQno.gHMCa22xDlW6');

INSERT INTO permissao (id, nome)
values (1, 'ROLE_CADASTRAR_CLIENTE');
INSERT INTO permissao (id, nome)
values (2, 'ROLE_ALTERAR_CLIENTE');
INSERT INTO permissao (id, nome)
values (3, 'ROLE_VISUALIZAR_CLIENTE');
INSERT INTO permissao (id, nome)
values (4, 'ROLE_EXCLUIR_CLIENTE');

-- admin
INSERT INTO usuario_permissao (usuario_id, permissao_id)
values (1, 1);
INSERT INTO usuario_permissao (usuario_id, permissao_id)
values (1, 2);
INSERT INTO usuario_permissao (usuario_id, permissao_id)
values (1, 3);
INSERT INTO usuario_permissao (usuario_id, permissao_id)
values (1, 4);

-- comum
INSERT INTO usuario_permissao (usuario_id, permissao_id)
values (2, 3);


set foreign_key_checks = 1;