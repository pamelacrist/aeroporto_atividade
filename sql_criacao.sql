-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `aeroporto` DEFAULT CHARACTER SET utf8 ;
USE `aeroporto` ;

-- -----------------------------------------------------
-- Table `aeroporto`.`pista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aeroporto`.`pista` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `numero` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aeroporto`.`companhia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aeroporto`.`companhia` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NULL,
  `cnpj` VARCHAR(14) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aeroporto`.`aviao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aeroporto`.`aviao` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `marca` VARCHAR(255) NULL,
  `modelo` VARCHAR(255) NULL,
  `prefixo` VARCHAR(3) NULL,
  `capacidade` INT NULL,
  `id_companhia` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`, `id_companhia`),
  INDEX `fk_aviao_companhia_idx` (`id_companhia` ASC) VISIBLE,
  CONSTRAINT `fk_aviao_companhia`
    FOREIGN KEY (`id_companhia`)
    REFERENCES `aeroporto`.`companhia` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aeroporto`.`jato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aeroporto`.`jato` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `marca` VARCHAR(255) NULL,
  `modelo` VARCHAR(255) NULL,
  `cor` VARCHAR(255) NULL,
  `velocidade` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aeroporto`.`helicoptero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aeroporto`.`helicoptero` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `marca` VARCHAR(255) NULL,
  `modelo` VARCHAR(255) NULL,
  `cor` VARCHAR(255) NULL,
  `capacidade` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aeroporto`.`voo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aeroporto`.`voo` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `numero` VARCHAR(255) NULL DEFAULT 'null',
  `data` VARCHAR(8) NULL,
  `hora` VARCHAR(4) NULL,
  `origem` VARCHAR(3) NULL,
  `destino` VARCHAR(3) NULL,
  `piloto` VARCHAR(255) NULL,
  `copiloto` VARCHAR(255) NULL,
  `observacao` VARCHAR(255) NULL,
  `aviao_id` INT UNSIGNED NOT NULL,
  `pista_id` INT UNSIGNED NOT NULL,
  `jato_id` INT UNSIGNED NOT NULL,
  `helicoptero_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`, `aviao_id`, `pista_id`, `jato_id`, `helicoptero_id`),
  INDEX `fk_voo_aviao1_idx` (`aviao_id` ASC) VISIBLE,
  INDEX `fk_voo_pista1_idx` (`pista_id` ASC) VISIBLE,
  INDEX `fk_voo_jato1_idx` (`jato_id` ASC) VISIBLE,
  INDEX `fk_voo_helicoptero1_idx` (`helicoptero_id` ASC) VISIBLE,
  CONSTRAINT `fk_voo_aviao1`
    FOREIGN KEY (`aviao_id`)
    REFERENCES `aeroporto`.`aviao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_voo_pista1`
    FOREIGN KEY (`pista_id`)
    REFERENCES `aeroporto`.`pista` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_voo_jato1`
    FOREIGN KEY (`jato_id`)
    REFERENCES `aeroporto`.`jato` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_voo_helicoptero1`
    FOREIGN KEY (`helicoptero_id`)
    REFERENCES `aeroporto`.`helicoptero` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aeroporto`.`hangar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aeroporto`.`hangar` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `local` VARCHAR(255) NULL,
  `aviao_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`, `aviao_id`),
  INDEX `fk_hangar_aviao1_idx` (`aviao_id` ASC) VISIBLE,
  CONSTRAINT `fk_hangar_aviao1`
    FOREIGN KEY (`aviao_id`)
    REFERENCES `aeroporto`.`aviao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
