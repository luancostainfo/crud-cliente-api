create table cliente
(
    id   bigint       not null auto_increment,
    cpf  varchar(11)  not null,
    nome varchar(100) not null,
    primary key (id)
) engine = InnoDB
  default charset = utf8mb4;

create table email
(
    id             bigint       not null auto_increment,
    endereco_email varchar(100) not null,
    cliente_id     bigint       not null,
    primary key (id)
) engine = InnoDB
  default charset = utf8mb4;

create table endereco
(
    id          bigint       not null auto_increment,
    bairro      varchar(255) not null,
    cep         varchar(8)   not null,
    cidade      varchar(255) not null,
    logradouro  varchar(255) not null,
    uf          varchar(2)   not null,
    complemento varchar(255),
    cliente_id  bigint       not null,
    primary key (id)
) engine = InnoDB
  default charset = utf8mb4;

create table telefone
(
    id              bigint       not null auto_increment,
    numero_telefone varchar(11)  not null,
    tipo_telefone   varchar(100) not null,
    cliente_id      bigint       not null,
    primary key (id)
) engine = InnoDB
  default charset = utf8mb4;

alter table email
    add constraint fk_email_cliente foreign key (cliente_id) references cliente (id);

alter table endereco
    add constraint fk_endereco_cliente foreign key (cliente_id) references cliente (id);

alter table telefone
    add constraint fk_telefone_cliente foreign key (cliente_id) references cliente (id);
