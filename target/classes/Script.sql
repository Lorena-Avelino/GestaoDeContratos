/**
 * Author:  Lorena Avelino
 * Created: 2 de jun de 2023
 */

CREATE DATABASE freedb_GestaoDeContratos;

USE freedb_GestaoDeContratos;

CREATE TABLE cliente (
    id BIGINT NOT NULL AUTO_INCREMENT,
    cpf BIGINT NOT NULL,
    nome VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE contrato (
    id BIGINT NOT NULL AUTO_INCREMENT,
    redacao TEXT NOT NULL,
    ultimaAtualizacao DATE NOT NULL,
    id_cliente BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_cliente)
        REFERENCES cliente(id)
);
