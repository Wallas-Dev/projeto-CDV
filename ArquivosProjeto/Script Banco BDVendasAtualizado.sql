CREATE DATABASE CDVENDAS;

CREATE USER 'woquitoncdv'@'%' IDENTIFIED BY '123';

GRANT ALL ON *.* TO 'woquitoncdv'@'%' WITH GRANT OPTION;

flush privileges;

USE CDVENDAS;

/***** TABELA CLIENTES *****/
CREATE TABLE tb_clientes (
  id int auto_increment primary key,
  nome varchar(100),
  rg varchar (30),
  cpf varchar (20),
  email varchar(200),
  telefone varchar(30),
  celular varchar(30),
  cep varchar(100),
  endereco varchar (255),
  numero int,
  complemento varchar (200),
  bairro varchar (100),
  cidade varchar (100),
  estado varchar (2)
);
/*****************/

/***** TABELA FORNECEDORES *****/
CREATE TABLE tb_fornecedores (
  id int auto_increment primary key,
  nome varchar(100),
  cnpj varchar (100),
  email varchar(200),
  telefone varchar(30),
  celular varchar(30),
  cep varchar(100),
  endereco varchar (255),
  numero int,
  complemento varchar (200),
  bairro varchar (100),
  cidade varchar (100),
  estado varchar (2)
);
/*****************/

/***** TABELA FUNCIONARIOS *****/
CREATE TABLE tb_funcionarios (
  id int auto_increment primary key,
  nome varchar(100),
  rg varchar (30),
  cpf varchar (20),
  email varchar(200),
  senha varchar(10),
  cargo varchar(100),
  nivel_acesso varchar(50),
  telefone varchar(30),
  celular varchar(30),
  cep varchar(100),
  endereco varchar (255),
  numero int,
  complemento varchar (200),
  bairro varchar (100),
  cidade varchar (100),
  estado varchar (2)
);
/*****************/


/***** TABELA PRODUTOS *****/
CREATE TABLE tb_produtos (
  id int auto_increment primary key,
  descricao varchar(100),
  valor_bruto decimal(10,2),
  preco decimal (10,2),
  qtd_estoque int,
  for_id int,

  FOREIGN KEY (for_id) REFERENCES tb_fornecedores(id)
);
/*****************/

/***** TABELA VENDAS *****/
CREATE TABLE tb_vendas (
  id int auto_increment primary key,
  cliente_id int,
  data_venda datetime,
  total_venda decimal (10,2),
  observacoes text,

  FOREIGN KEY (cliente_id) REFERENCES tb_clientes(id)
);
/*****************/

/***** TABELA ITENS_VENDAS *****/
CREATE TABLE tb_itensvendas (
  id int auto_increment primary key,
  venda_id int,
  produto_id int,
  qtd int,
  subtotal decimal (10,2),

  FOREIGN KEY (venda_id) REFERENCES tb_vendas(id),
  FOREIGN KEY (produto_id) REFERENCES tb_produtos(id)
);
/*****************/

/***** TABELA ADIÇÃO_DE_ESTOQUE *****/
CREATE TABLE tb_adicao_estoque (
	id int auto_increment primary key,
    produto_id int,
    qtd_add int,
    data_add datetime,
    subtotal decimal (10,2),
     
	FOREIGN KEY (produto_id) REFERENCES tb_produtos(id)
);

INSERT INTO tb_clientes(nome, rg, cpf, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado)
VALUES('Wallas Almeida', '05.485.875-55', '082.616.425-00', 'wallas022@gmail.com', '(77) 4002-8922', '(77) 9 8836-8761',
 '46225-000', 'Rua Manoel Candido Silveira', 19, 'Casa', 'Bairro São José', 'Ibitira', 'BA');
 
INSERT INTO tb_fornecedores(nome, cnpj, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado)
VALUES('POLO', '54. 856. 740/0001-45', 'polo022@gmail.com', '(77) 4562-8922', '(77) 9 9846-8567',
 '49874-000', 'Rua São Paulo', 19, 'Casa', 'Bairro São José', 'São Paulo', 'SP');
 
INSERT INTO tb_fornecedores(nome, cnpj, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado)
VALUES('LACOSTE', '57. 853. 750/0001-48', 'lacoste@gmail.com', '(77) 4752-8722', '(77) 9 9946-4557',
 '49874-850', 'Rua São Paulo', 19, 'Casa', 'Bairro São José', 'São Paulo', 'SP');

INSERT INTO tb_funcionarios(nome, rg, cpf, email, senha, cargo, nivel_acesso, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado)
VALUES('Woquiton', '02.445.854-45', '982.752.425-10', 'woquiton@gmail.com', '123456', 'Dono', 'Administrador', '(77) 3411-2082', '(77) 9 9836-7751',
 '46225-000', 'Rua Centro', 19, 'Casa', 'Bairro Guanambi', 'Guanambi', 'BA');
 
INSERT INTO tb_funcionarios(nome, rg, cpf, email, senha, cargo, nivel_acesso, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado)
VALUES('John Lennon', '02.447.855-49', '882.762.422-10', 'john@gmail.com', '123456', 'Secretario', 'Gerente', '(77) 3611-7052', '(77) 9 9832-7451',
 '46225-000', 'Rua Manoel Candido Silveira', 19, 'Casa', 'Bairro São José', 'Ibitira', 'BA');
 
INSERT INTO tb_produtos(descricao, valor_bruto, preco, qtd_estoque, for_id)
VALUES('Camiseta Gola Polo GG', 45.50, 79.99, 100, 1);

INSERT INTO tb_produtos(descricao, valor_bruto, preco, qtd_estoque, for_id)
VALUES('Calça Jeans Num 42', 60.00, 100.00, 100, 2);