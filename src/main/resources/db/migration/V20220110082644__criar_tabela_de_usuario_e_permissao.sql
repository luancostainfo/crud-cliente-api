create table usuario
(
    id    bigint(20) primary key,
    nome  varchar(255) not null,
    email varchar(255) not null,
    senha varchar(255) not null
) engine = InnoDB
  default charset = utf8mb4;

create table permissao
(
    id   bigint(20) primary key,
    nome varchar(255) not null
) engine = InnoDB
  default charset = utf8mb4;

create table usuario_permissao
(
    usuario_id   bigint(20) not null,
    permissao_id bigint(20) not null,
    primary key (usuario_id, permissao_id),
    foreign key (usuario_id) references usuario (id),
    foreign key (permissao_id) references permissao (id)
) engine = InnoDB
  default charset = utf8mb4;