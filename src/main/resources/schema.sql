drop database if exists pepper;
create database if not exists pepper;
use pepper;

create table if not exists drugs (
  name varchar(255) not null,
  formula varchar(255) not null,
  weight decimal(10,1) unsigned,
  imageName varchar(255)
) engine=InnoDB, character set utf8;

insert into drugs (name, formula, weight, imageName)
  values ("aspirin", "C9H8O4", 180.2, "aspirin");
insert into drugs (name, formula, weight, imageName)
  values ("paracetamol", "C8H9NO2", 151.1, "paracetamol");
insert into drugs (name, formula, weight, imageName)
  values ("penicillin", "R-C9H11N2O4S", 243.0, "penicillin");
