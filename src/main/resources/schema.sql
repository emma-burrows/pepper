drop database if exists pepper;
create database if not exists pepper;
use pepper;

create table if not exists drugs (
  name varchar(255) not null,
  formula varchar(255) not null,
  weight decimal(10,1) unsigned,
  cas varchar(255),
  atc varchar(255),
  unii varchar(255),
  imageName varchar(255)
) engine=InnoDB, character set utf8;

insert into drugs (name, formula, weight, cas, atc, unii, imageName)
  values ("aspirin", "C9H8O4", 180.2, "50-78-2","A01AD05 B01AC06, N02BA01",
    "R16CO5Y76E", "aspirin");
insert into drugs (name, formula, weight, cas, atc, unii, imageName)
  values ("paracetamol", "C8H9NO2", 151.1, "103-90-2", "N02BE01", "362O9ITL9D",
    "paracetamol");
insert into drugs (name, formula, weight, cas, atc, unii, imageName)
  values ("benzylpenicillin", "C16H18N2O4S", 334.4, "61-33-6",
    "J01CE01 S01AA14 QJ51CE01", "Q42T66VG0C", "benzylpenicillin");
insert into drugs (name, formula, weight, cas, atc, unii, imageName)
  values ("hydrochlorothiazide", "C7H8ClN3O4S2", 297.7, "58-93-5", "C03AA03",
    "0J48LPH2TH", "hydrochlorothiazide");
insert into drugs (name, formula, weight, cas, atc, unii, imageName)
  values ("metformin", "C4H11N5", 129.2, "657-24-9", "A10BA02", "9100L32L2N",
    "metformin");
insert into drugs (name, formula, weight, cas, atc, unii, imageName)
  values ("amoxicillin", "C16H19N3O5S", 365.4, "26787-78-0", "J01CA04 QG51AA03",
    "9EM05410Q9", "amoxicillin");
insert into drugs (name, formula, weight, cas, atc, unii, imageName)
  values ("levothyroxine", "C15H11I4NO4", 776.9, "51-48-9", "H03AA01",
    "Q51BO43MG4", "levothyroxine");
insert into drugs (name, formula, weight, cas, atc, unii, imageName)
  values ("hydrocodone", "C18H21NO3", 299.4, "125-29-1", "R05DA03",
    "6YKS4Y3WQ7", "hydrocodone");
insert into drugs (name, formula, weight, cas, atc, unii, imageName)
  values ("lisinopril", "C21H31N3O5", 405.5, "83915-83-7", "C09AA03",
    "7Q3P4BS2FD", "lisinopril");
insert into drugs (name, formula, weight, cas, atc, unii, imageName)
  values ("warfarin", "C19H16O4", 308.3, "81-81-2", "B01AA03", "5Q7ZVV76EI",
    "warfarin");
