-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.41-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5249
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for lettertofuture
DROP DATABASE IF EXISTS `lettertofuture`;
CREATE DATABASE IF NOT EXISTS `lettertofuture` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `lettertofuture`;

-- Dumping structure for table lettertofuture.letter
DROP TABLE IF EXISTS `letter`;
CREATE TABLE IF NOT EXISTS `letter` (
  `LetterID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Recipient` varchar(255) NOT NULL,
  `Content` text NOT NULL,
  `SendDate` date NOT NULL,
  `IsSent` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`LetterID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
