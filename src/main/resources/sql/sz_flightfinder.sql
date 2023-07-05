-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema sz_flightfinder
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sz_flightfinder` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `sz_flightfinder` ;

-- -----------------------------------------------------
-- Table `flightfinder`.`airlines`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sz_flightfinder`.`airlines` (
  `airline_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`airline_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `sz_flightfinder`.`countries`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sz_flightfinder`.`countries` (
  `country_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`country_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `sz_flightfinder`.`cities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sz_flightfinder`.`cities` (
  `city_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `country_id` INT NOT NULL,
  PRIMARY KEY (`city_id`),
  INDEX `country_id` (`country_id` ASC),
  CONSTRAINT `cities_ibfk_1`
    FOREIGN KEY (`country_id`)
    REFERENCES `sz_flightfinder`.`countries` (`country_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `sz_flightfinder`.`airports`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sz_flightfinder`.`airports` (
  `airport_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `city_id` INT NOT NULL,
  `latitude` DECIMAL(9,6) NOT NULL,
  `longitude` DECIMAL(9,6) NOT NULL,
  PRIMARY KEY (`airport_id`),
  INDEX `city_id` (`city_id` ASC),
  CONSTRAINT `airports_ibfk_1`
    FOREIGN KEY (`city_id`)
    REFERENCES `sz_flightfinder`.`cities` (`city_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `sz_flightfinder`.`flights`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sz_flightfinder`.`flights` (
  `flight_id` INT NOT NULL AUTO_INCREMENT,
  `airline_id` INT NOT NULL,
  `source_airport_id` INT NOT NULL,
  `destination_airport_id` INT NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`flight_id`),
  INDEX `airline_id` (`airline_id` ASC),
  INDEX `source_airport_id` (`source_airport_id` ASC),
  INDEX `destination_airport_id` (`destination_airport_id` ASC),
  CONSTRAINT `flights_ibfk_1`
    FOREIGN KEY (`airline_id`)
    REFERENCES `sz_flightfinder`.`airlines` (`airline_id`),
  CONSTRAINT `flights_ibfk_2`
    FOREIGN KEY (`source_airport_id`)
    REFERENCES `sz_flightfinder`.`airports` (`airport_id`),
  CONSTRAINT `flights_ibfk_3`
    FOREIGN KEY (`destination_airport_id`)
    REFERENCES `sz_flightfinder`.`airports` (`airport_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
