/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     08/03/2015 04:48:41 p. m.                    */
/*==============================================================*/
drop database if exists Nutrilite;
create database Nutrilite;

use Nutrilite;

drop table if exists NL_PAQUETECOMPLEMENTO;

drop table if exists NL_COMPLEMENTO;

drop table if exists NL_PAQUETE;

drop table if exists NL_ALIMENTOS;

drop table if exists NL_TIPOALIMENTO;

drop table if exists NL_MACRONUTRIENTES;

drop table if exists NL_DIETA;

drop table if exists NL_MEDIDAS;

drop table if exists NL_CLIENTE;

drop table if exists NL_SOCIO;

drop table if exists NL_ESTADO;

drop table if exists NL_PAIS;

/*==============================================================*/
/* Table: NL_ALIMENTOS                                          */
/*==============================================================*/
create table NL_ALIMENTOS
(
   ID_ALIMENTO          int auto_increment,
   NOMBRE               varchar(50) not null,
   PORCION              double not null,
   MEDIDA 				varchar(15),
   CALORIAS             double not null,
   ID_TIPOALIMENTO      int not null,
   primary key (ID_ALIMENTO)
);

/*==============================================================*/
/* Table: NL_CLIENTE                                            */
/*==============================================================*/
create table NL_CLIENTE
(
   ID_CLIENTE           int not null,
   NOMBRE               varchar(50) not null,
   APELLIDO_PATERNO     varchar(50) not null,
   APELLIDO_MATERNO     varchar(50),
   NOMBRE_COMPLETO		varchar(70) not null,
   FECHA_NACIMIENTO     varchar(10) not null,
   DIRECCION            varchar(70) not null,
   SEXO                 varchar(1) not null,
   TELEFONO             varchar(20),
   CORREO               varchar(35) not null,
   ID_ESTADO            int not null,
   ID_SOCIO             int not null,
   primary key (ID_CLIENTE)
);

/*==============================================================*/
/* Table: NL_COMPLEMENTO                                        */
/*==============================================================*/
create table NL_COMPLEMENTO
(
   ID_COMPLEMENTO       int auto_increment,
   NOMBRE               varchar(100) not null,
   DESCRIPCION          varchar(300) not null,
   primary key (ID_COMPLEMENTO)
);

/*==============================================================*/
/* Table: NL_DIETA                                              */
/*==============================================================*/
create table NL_DIETA
(
   ID_DIETA             int auto_increment,
   ARCHIVO_PDF          varchar(50) not null,
   FECHA_CREACION       varchar(10) not null,
   ID_CLIENTE           int not null,
   primary key (ID_DIETA)
);

/*==============================================================*/
/* Table: NL_ESTADO                                             */
/*==============================================================*/
create table NL_ESTADO
(
   ID_ESTADO            int auto_increment,
   NOMBRE               varchar(50) not null,
   ID_PAIS              int not null,
   primary key (ID_ESTADO)
);

/*==============================================================*/
/* Table: NL_MACRONUTRIENTES                                    */
/*==============================================================*/
create table NL_MACRONUTRIENTES
(
   ID_MACRONUTRIENTES   int auto_increment,
   NOMBRE               varchar(50) not null,
   primary key (ID_MACRONUTRIENTES)
);

/*==============================================================*/
/* Table: NL_MEDIDAS                                            */
/*==============================================================*/
create table NL_MEDIDAS
(
   ID_MEDIDA            int auto_increment,
   CINTURA              double,
   MUNECA               double,
   PECHO                double,
   CADERA               double,
   FECHA                varchar(10) not null,
   CUELLO				double,
   PESO                 double not null,
   ALTURA               double not null,
   ID_CLIENTE           int not null,
   primary key (ID_MEDIDA)
);

/*==============================================================*/
/* Table: NL_PAIS                                               */
/*==============================================================*/
create table NL_PAIS
(
   ID_PAIS              int auto_increment,
   NOMBRE               varchar(50) not null,
   primary key (ID_PAIS)
);

/*==============================================================*/
/* Table: NL_PAQUETE                                            */
/*==============================================================*/
create table NL_PAQUETE
(
   ID_PAQUETE           int auto_increment,
   NOMBRE               varchar(100) not null,
   DESCRIPCION          varchar(300) not null,
   primary key (ID_PAQUETE)
);

/*==============================================================*/
/* Table: NL_PAQUETECOMPLEMENTO                                 */
/*==============================================================*/
create table NL_PAQUETECOMPLEMENTO
(
   ID_PAQUETECOMPLEMENTO int auto_increment,
   ID_PAQUETE           int not null,
   ID_COMPLEMENTO       int not null,
   primary key (ID_PAQUETECOMPLEMENTO)
);

/*==============================================================*/
/* Table: NL_SOCIO                                              */
/*==============================================================*/
create table NL_SOCIO
(
   ID_SOCIO             int not null,
   NOMBRE               varchar(50),
   APELLIDO_PATERNO     varchar(50),
   APELLIDO_MATERNO     varchar(50),
   NOMBRE_COMPLETO		varchar(70),
   SEXO                 varchar(1),
   FECHA_NACIMIENTO     varchar(10),
   TELEFONO             varchar(20),
   DIRECCION            varchar(70),
   CORREO               varchar(35),
   PASSWORD             varchar(16),
   ESTADO 				boolean,
   ID_ESTADO            int,
   primary key (ID_SOCIO)
);

/*==============================================================*/
/* Table: NL_TIPOALIMENTO                                       */
/*==============================================================*/
create table NL_TIPOALIMENTO
(
   ID_TIPOALIMENTO      int auto_increment,
   NOMBRE               varchar(20) not null,
   ID_MACRONUTRIENTES   int not null,
   primary key (ID_TIPOALIMENTO)
);


/*==============================================================*/
/* REFERENCIAS                                                  */
/*==============================================================*/

ALTER TABLE NL_ALIMENTOS
ADD FOREIGN KEY(ID_TIPOALIMENTO) REFERENCES NL_TIPOALIMENTO(ID_TIPOALIMENTO);

ALTER TABLE NL_CLIENTE
ADD FOREIGN KEY(ID_ESTADO) REFERENCES NL_ESTADO(ID_ESTADO);

ALTER TABLE NL_CLIENTE
ADD FOREIGN KEY(ID_SOCIO) REFERENCES NL_SOCIO(ID_SOCIO);

ALTER TABLE NL_DIETA
ADD FOREIGN KEY(ID_CLIENTE) REFERENCES NL_CLIENTE(ID_CLIENTE);

ALTER TABLE NL_ESTADO
ADD FOREIGN KEY(ID_PAIS) REFERENCES NL_PAIS(ID_PAIS);

ALTER TABLE NL_MEDIDAS
ADD FOREIGN KEY(ID_CLIENTE) REFERENCES NL_CLIENTE(ID_CLIENTE);

ALTER TABLE NL_PAQUETECOMPLEMENTO
ADD FOREIGN KEY(ID_PAQUETE) REFERENCES NL_PAQUETE(ID_PAQUETE);

ALTER TABLE NL_PAQUETECOMPLEMENTO
ADD FOREIGN KEY(ID_COMPLEMENTO) REFERENCES NL_COMPLEMENTO(ID_COMPLEMENTO);

ALTER TABLE NL_SOCIO
ADD FOREIGN KEY(ID_ESTADO) REFERENCES NL_ESTADO(ID_ESTADO);

ALTER TABLE NL_TIPOALIMENTO
ADD FOREIGN KEY(ID_MACRONUTRIENTES) REFERENCES NL_MACRONUTRIENTES(ID_MACRONUTRIENTES);


