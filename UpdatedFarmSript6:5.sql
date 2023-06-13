-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema Farm
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Farm
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Farm` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `Farm` ;

-- -----------------------------------------------------
-- Table `Farm`.`Animal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Farm`.`Animal` (
  `animal_id` INT NOT NULL,
  `farm_id` INT NULL DEFAULT NULL,
  `species` VARCHAR(50) NOT NULL,
  `breed` VARCHAR(50) NULL DEFAULT NULL,
  `age` INT NULL DEFAULT NULL,
  `gender` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`animal_id`),
  INDEX `farm_id_idx` (`farm_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Farm`.`Animal_Medical_Record`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Farm`.`Animal_Medical_Record` (
  `record_id` INT NOT NULL,
  `animal_id` INT NOT NULL,
  `date` DATETIME NULL DEFAULT NULL,
  `diagnosis` VARCHAR(100) NULL DEFAULT NULL,
  `treatment` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`record_id`),
  INDEX `animal_id_idx` (`animal_id` ASC) VISIBLE,
  CONSTRAINT `fk_animal_id`
    FOREIGN KEY (`animal_id`)
    REFERENCES `Farm`.`Animal` (`animal_id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Farm`.`Farmstead`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Farm`.`Farmstead` (
  `farm_id` INT NOT NULL DEFAULT '0',
  `farmer_id` INT NULL DEFAULT NULL,
  `name` VARCHAR(100) NULL DEFAULT NULL,
  `established` INT NULL DEFAULT NULL,
  `type` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`farm_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Farm`.`Barn`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Farm`.`Barn` (
  `barn_id` INT NOT NULL,
  `farm_id` INT NOT NULL,
  `capacity` INT NULL DEFAULT NULL,
  `location` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`barn_id`),
  INDEX `farm_id_idx` (`farm_id` ASC) VISIBLE,
  CONSTRAINT `fk_farm_id`
    FOREIGN KEY (`barn_id`)
    REFERENCES `Farm`.`Farmstead` (`farm_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Farm`.`Barn_Animal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Farm`.`Barn_Animal` (
  `barn_id` INT NOT NULL,
  `animal_id` INT NOT NULL,
  INDEX `animal_id_idx` (`animal_id` ASC) VISIBLE,
  INDEX `barn_id_idx` (`barn_id` ASC) VISIBLE,
  CONSTRAINT `animal_id`
    FOREIGN KEY (`animal_id`)
    REFERENCES `Farm`.`Animal` (`animal_id`),
  CONSTRAINT `barn_id`
    FOREIGN KEY (`barn_id`)
    REFERENCES `Farm`.`Barn` (`barn_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Farm`.`Crop`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Farm`.`Crop` (
  `crop_id` INT NOT NULL,
  `farm_id` INT NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `planting_date` VARCHAR(45) NULL DEFAULT NULL,
  `harvest_date` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`crop_id`),
  INDEX `fk_farm_id_idx_idx` (`farm_id` ASC) VISIBLE,
  CONSTRAINT `fk_farm_id_idx`
    FOREIGN KEY (`farm_id`)
    REFERENCES `Farm`.`Farmstead` (`farm_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Farm`.`Farmer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Farm`.`Farmer` (
  `farmer_id` INT NOT NULL DEFAULT '0',
  `first_name` VARCHAR(50) NULL DEFAULT NULL,
  `last_name` VARCHAR(50) NULL DEFAULT NULL,
  `address` VARCHAR(50) NULL DEFAULT NULL,
  `contact_number` VARCHAR(15) NULL DEFAULT NULL,
  `contact_email` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`farmer_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Farm`.`Employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Farm`.`Employee` (
  `employee_id` INT NOT NULL,
  `farm_id` INT NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `position` VARCHAR(45) NULL DEFAULT NULL,
  `salary` DOUBLE NOT NULL,
  `farmer_id` INT NOT NULL,
  PRIMARY KEY (`employee_id`),
  INDEX `ff_farm_id_idx` (`farm_id` ASC) VISIBLE,
  INDEX `farm_id_inx_idx` (`farm_id` ASC) VISIBLE,
  CONSTRAINT `farm_id_inx`
    FOREIGN KEY (`farm_id`)
    REFERENCES `Farm`.`Farmstead` (`farm_id`),
  CONSTRAINT `farmer_id`
    FOREIGN KEY (`employee_id`)
    REFERENCES `Farm`.`Farmer` (`farmer_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Farm`.`Crop_Harvested`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Farm`.`Crop_Harvested` (
  `crop_id` INT NOT NULL,
  `employee_id` INT NOT NULL,
  INDEX `crop_id_idx` (`crop_id` ASC) VISIBLE,
  INDEX `employee_id_idx` (`employee_id` ASC) VISIBLE,
  CONSTRAINT `crop_id`
    FOREIGN KEY (`crop_id`)
    REFERENCES `Farm`.`Crop` (`crop_id`),
  CONSTRAINT `employee_id`
    FOREIGN KEY (`employee_id`)
    REFERENCES `Farm`.`Employee` (`employee_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Farm`.`Equipment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Farm`.`Equipment` (
  `equipment_id` INT NOT NULL,
  `farm_id` INT NOT NULL,
  `name` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`equipment_id`),
  INDEX `fk_farm_id_idx_idx` (`farm_id` ASC) VISIBLE,
  INDEX `farm_id_idx_2_idx` (`farm_id` ASC) VISIBLE,
  CONSTRAINT `farm_id_idx_2`
    FOREIGN KEY (`farm_id`)
    REFERENCES `Farm`.`Farmstead` (`farm_id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
