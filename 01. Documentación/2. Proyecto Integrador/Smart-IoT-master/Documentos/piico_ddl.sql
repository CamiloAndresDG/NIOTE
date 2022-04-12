-- MySQL Workbench Synchronization
-- Generated: 2019-09-12 11:14
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: sevin

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `ingusbbo_piico` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`usuario` (
  `username` VARCHAR(45) NOT NULL,
  `nombres` VARCHAR(60) NOT NULL,
  `apellidos` VARCHAR(60) NOT NULL,
  `pass` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`reportes` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `fecha` DATETIME NOT NULL,
  `tipo` VARCHAR(50) NOT NULL,
  `data` LONGTEXT NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_reportes_usuario_idx` (`usuario` ASC),
  CONSTRAINT `fk_reportes_usuario`
    FOREIGN KEY (`usuario`)
    REFERENCES `ingusbbo_piico`.`usuario` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`red` (
  `id` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(80) NOT NULL,
  `proyecto` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_red_proyecto_idx` (`proyecto` ASC),
  CONSTRAINT `fk_red_proyecto`
    FOREIGN KEY (`proyecto`)
    REFERENCES `ingusbbo_piico`.`proyecto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`nodo` (
  `id` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(80) NOT NULL,
  `estado` TINYINT(4) NOT NULL,
  `protocolo_comunicacion` VARCHAR(45) NOT NULL,
  `puerta_de_enlace` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_nodo_puerta_de_enlace_idx` (`puerta_de_enlace` ASC),
  CONSTRAINT `fk_nodo_puerta_de_enlace`
    FOREIGN KEY (`puerta_de_enlace`)
    REFERENCES `ingusbbo_piico`.`puerta_de_enlace` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`actuador` (
  `id` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `estado` TINYINT(4) NOT NULL,
  `tipo` VARCHAR(80) NOT NULL,
  `nodo` VARCHAR(45) NOT NULL,
  `sensor` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_actuador_nodo_idx` (`nodo` ASC),
  INDEX `fk_actuador_sensor_idx` (`sensor` ASC),
  CONSTRAINT `fk_actuador_nodo`
    FOREIGN KEY (`nodo`)
    REFERENCES `ingusbbo_piico`.`nodo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_actuador_sensor`
    FOREIGN KEY (`sensor`)
    REFERENCES `ingusbbo_piico`.`sensor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`puerta_de_enlace` (
  `id` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(80) NOT NULL,
  `estado` TINYINT(4) NOT NULL,
  `direccion_logica` VARCHAR(60) NOT NULL,
  `puerto_de_servicio` VARCHAR(10) NOT NULL,
  `prot_comun_ext` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`sensor` (
  `id` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(80) NOT NULL,
  `estado` TINYINT(4) NOT NULL,
  `tipo` VARCHAR(80) NOT NULL,
  `magnitud` VARCHAR(50) NOT NULL,
  `frecuencia` INT(11) NOT NULL,
  `nodo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Sensor_nodo_idx` (`nodo` ASC),
  CONSTRAINT `fk_Sensor_nodo`
    FOREIGN KEY (`nodo`)
    REFERENCES `ingusbbo_piico`.`nodo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`mensajes` (
  `id` VARCHAR(45) NOT NULL,
  `fecha` DATETIME NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `mensaje` LONGTEXT NOT NULL,
  `estado` TINYINT(4) NOT NULL,
  `puerta_de_enlace` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_mensajes_puerta_de_enlace_idx` (`puerta_de_enlace` ASC),
  CONSTRAINT `fk_mensajes_puerta_de_enlace`
    FOREIGN KEY (`puerta_de_enlace`)
    REFERENCES `ingusbbo_piico`.`puerta_de_enlace` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`proyecto` (
  `id` INT(11) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(10) NOT NULL,
  `fecha_inicio` DATE NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`rol` (
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`nombre`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`usuario_rol` (
  `usuario` VARCHAR(45) NOT NULL,
  `rol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`usuario`, `rol`),
  INDEX `fk_usuario_roles_rol_idx` (`rol` ASC),
  INDEX `fk_usuario_roles_usuario_idx` (`usuario` ASC),
  CONSTRAINT `fk_usuario_roles_usuario`
    FOREIGN KEY (`usuario`)
    REFERENCES `ingusbbo_piico`.`usuario` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_roles_rol`
    FOREIGN KEY (`rol`)
    REFERENCES `ingusbbo_piico`.`rol` (`nombre`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`institucion` (
  `id` INT(11) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `ciudad` VARCHAR(45) NOT NULL,
  `area` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`proyecto_institucion` (
  `proyecto` INT(11) NOT NULL,
  `institucion` INT(11) NOT NULL,
  PRIMARY KEY (`proyecto`, `institucion`),
  INDEX `fk_proyecto_institucion_institucion_idx` (`institucion` ASC),
  INDEX `fk_proyecto_institucion_proyecto_idx` (`proyecto` ASC),
  CONSTRAINT `fk_proyecto_has_institucion_proyecto1`
    FOREIGN KEY (`proyecto`)
    REFERENCES `ingusbbo_piico`.`proyecto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_proyecto_has_institucion_institucion1`
    FOREIGN KEY (`institucion`)
    REFERENCES `ingusbbo_piico`.`institucion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`puerta_enlace_red` (
  `puerta_de_enlace` VARCHAR(45) NOT NULL,
  `red` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`puerta_de_enlace`, `red`),
  INDEX `fk_puerta_enlace_red_red_idx` (`red` ASC),
  INDEX `fk_puerta_enlace_red_puerta_de_enlace_idx` (`puerta_de_enlace` ASC),
  CONSTRAINT `fk_puerta_enlace_red_puerta_de_enlace`
    FOREIGN KEY (`puerta_de_enlace`)
    REFERENCES `ingusbbo_piico`.`puerta_de_enlace` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_puerta_enlace_red_red`
    FOREIGN KEY (`red`)
    REFERENCES `ingusbbo_piico`.`red` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`orden` (
  `id` VARCHAR(45) NOT NULL,
  `accion` LONGTEXT NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`dato` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `valor` VARCHAR(45) NOT NULL,
  `fecha` DATETIME NOT NULL,
  `ubicacion` LONGTEXT NOT NULL,
  `sensor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_dato_sensor_idx` (`sensor` ASC),
  CONSTRAINT `fk_dato_sensor`
    FOREIGN KEY (`sensor`)
    REFERENCES `ingusbbo_piico`.`sensor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`orden_actuador` (
  `orden_id` VARCHAR(45) NOT NULL,
  `actuador_id` VARCHAR(45) NOT NULL,
  `fecha` DATETIME NOT NULL,
  `confirmacion` TINYINT(4) NOT NULL,
  PRIMARY KEY (`orden_id`, `actuador_id`),
  INDEX `fk_orden_actuador_actuador_idx` (`actuador_id` ASC),
  INDEX `fk_orden_actuador_orden_idx` (`orden_id` ASC),
  CONSTRAINT `fk_orden_has_actuador_orden`
    FOREIGN KEY (`orden_id`)
    REFERENCES `ingusbbo_piico`.`orden` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orden_has_actuador_actuador`
    FOREIGN KEY (`actuador_id`)
    REFERENCES `ingusbbo_piico`.`actuador` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`usuario_proyecto` (
  `usuario_username` VARCHAR(45) NOT NULL,
  `proyecto_id` INT(11) NOT NULL,
  PRIMARY KEY (`usuario_username`, `proyecto_id`),
  INDEX `fk_usuario_has_proyecto_proyecto_idx` (`proyecto_id` ASC),
  INDEX `fk_usuario_has_proyecto_usuario_idx` (`usuario_username` ASC),
  CONSTRAINT `fk_usuario_has_proyecto_usuario`
    FOREIGN KEY (`usuario_username`)
    REFERENCES `ingusbbo_piico`.`usuario` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_has_proyecto_proyecto`
    FOREIGN KEY (`proyecto_id`)
    REFERENCES `ingusbbo_piico`.`proyecto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`auth` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `user` VARCHAR(80) NOT NULL,
  `pass` VARCHAR(512) NOT NULL,
  `topic` VARCHAR(45) NOT NULL,
  `puerta_de_enlace` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_auth_puerta_de_enlace_idx` (`puerta_de_enlace` ASC),
  CONSTRAINT `fk_auth_puerta_de_enlace`
    FOREIGN KEY (`puerta_de_enlace`)
    REFERENCES `ingusbbo_piico`.`puerta_de_enlace` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
