create database provakiver;
use provakiver;
create table movimentacao(
descricao varchar(100),
valor double not null,
tipo varchar(10),
data varchar(50),
CaixaId int

);


create table caixa(
idCaixa int primary key auto_increment,
descricao varchar(100),
saldoIncial double not null
);
