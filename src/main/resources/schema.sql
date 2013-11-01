drop database if exists pepper;
create database if not exists pepper;
use pepper;

create table if not exists drugs (
  name varchar(255) not null,
  formula varchar(255) not null,
  weight decimal(10,1) unsigned,
  atc varchar(255),
  unii varchar(255),
  imageName varchar(255)
) engine=InnoDB, character set utf8;

insert into drugs (name, formula, weight, atc, unii, imageName)
  values ("aspirin", "C9H8O4", 180.2, "A01AD05 B01AC06, N02BA01", "R16CO5Y76E",
    "aspirin");
insert into drugs (name, formula, weight, atc, unii, imageName)
  values ("paracetamol", "C8H9NO2", 151.1, "N02BE01", "362O9ITL9D",
    "paracetamol");
insert into drugs (name, formula, weight, atc, unii, imageName)
  values ("benzylpenicillin", "C16H18N2O4S", 334.4, "J01CE01 S01AA14 QJ51CE01",
    "Q42T66VG0C", "benzylpenicillin");
