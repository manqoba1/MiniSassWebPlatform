# ************************************************************
# Sequel Pro SQL dump
# Version 4135
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.5.34)
# Database: minisass
# Generation Time: 2015-01-29 11:27:48 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table category
# ------------------------------------------------------------

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `categoryId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(45) NOT NULL,
  PRIMARY KEY (`categoryId`),
  UNIQUE KEY `index2` (`categoryName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table comment
# ------------------------------------------------------------

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `commentID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `remarks` text NOT NULL,
  PRIMARY KEY (`commentID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table condition
# ------------------------------------------------------------

DROP TABLE IF EXISTS `condition`;

CREATE TABLE `condition` (
  `conditionID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `conditionName` varchar(255) NOT NULL,
  `categoryID` int(10) unsigned NOT NULL,
  `low` double NOT NULL,
  `high` double NOT NULL,
  PRIMARY KEY (`conditionID`),
  UNIQUE KEY `index2` (`conditionName`),
  KEY `index3` (`categoryID`),
  KEY `fk23` (`categoryID`),
  CONSTRAINT `fk23` FOREIGN KEY (`categoryID`) REFERENCES `category` (`categoryId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table country
# ------------------------------------------------------------

DROP TABLE IF EXISTS `country`;

CREATE TABLE `country` (
  `countryID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `countryName` varchar(255) NOT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  PRIMARY KEY (`countryID`),
  UNIQUE KEY `index2` (`countryName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table evaluation
# ------------------------------------------------------------

DROP TABLE IF EXISTS `evaluation`;

CREATE TABLE `evaluation` (
  `evaluationID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `teamMemberID` int(10) unsigned NOT NULL,
  `evaluationSiteID` int(10) unsigned NOT NULL,
  `evaluationDate` datetime NOT NULL,
  `remarks` text,
  `score` double DEFAULT NULL,
  `pH` double DEFAULT NULL,
  `waterTemperature` double DEFAULT NULL,
  `oxygen` double DEFAULT NULL,
  `waterClarity` double DEFAULT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `conditionID` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`evaluationID`),
  KEY `index2` (`teamMemberID`),
  KEY `index3` (`evaluationSiteID`),
  KEY `fk10` (`teamMemberID`),
  KEY `fk11` (`evaluationSiteID`),
  KEY `index6` (`conditionID`),
  KEY `fk22` (`conditionID`),
  CONSTRAINT `fk10` FOREIGN KEY (`teamMemberID`) REFERENCES `teamMember` (`teamMemberID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk11` FOREIGN KEY (`evaluationSiteID`) REFERENCES `evaluationSite` (`evaluationSiteID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk22` FOREIGN KEY (`conditionID`) REFERENCES `condition` (`conditionID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table evaluationComment
# ------------------------------------------------------------

DROP TABLE IF EXISTS `evaluationComment`;

CREATE TABLE `evaluationComment` (
  `evaluationCommentID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `evaluationID` int(10) unsigned NOT NULL,
  `commentID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`evaluationCommentID`),
  KEY `index2` (`evaluationID`),
  KEY `index3` (`commentID`),
  KEY `fk24` (`evaluationID`),
  KEY `fk25` (`commentID`),
  CONSTRAINT `fk24` FOREIGN KEY (`evaluationID`) REFERENCES `evaluation` (`evaluationID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk25` FOREIGN KEY (`commentID`) REFERENCES `comment` (`commentID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table evaluationImage
# ------------------------------------------------------------

DROP TABLE IF EXISTS `evaluationImage`;

CREATE TABLE `evaluationImage` (
  `evaluationImageID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `evaluationID` int(10) unsigned NOT NULL,
  `dateTaken` datetime NOT NULL,
  `fileName` varchar(255) NOT NULL,
  PRIMARY KEY (`evaluationImageID`),
  KEY `index2` (`evaluationID`),
  KEY `fk18` (`evaluationID`),
  CONSTRAINT `fk18` FOREIGN KEY (`evaluationID`) REFERENCES `evaluation` (`evaluationID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table evaluationInsect
# ------------------------------------------------------------

DROP TABLE IF EXISTS `evaluationInsect`;

CREATE TABLE `evaluationInsect` (
  `evaluationInsectID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `evaluationID` int(10) unsigned NOT NULL,
  `evaluationFlag` int(11) NOT NULL,
  `insectID` int(10) unsigned NOT NULL,
  `evaluationColor` int(11) DEFAULT NULL,
  `remarks` text,
  PRIMARY KEY (`evaluationInsectID`),
  UNIQUE KEY `index6` (`evaluationID`,`insectID`),
  KEY `index2` (`evaluationID`),
  KEY `fk13` (`evaluationID`),
  KEY `index4` (`insectID`),
  KEY `fk14` (`insectID`),
  CONSTRAINT `fk13` FOREIGN KEY (`evaluationID`) REFERENCES `evaluation` (`evaluationID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk14` FOREIGN KEY (`insectID`) REFERENCES `insect` (`insectID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table evaluationSite
# ------------------------------------------------------------

DROP TABLE IF EXISTS `evaluationSite`;

CREATE TABLE `evaluationSite` (
  `evaluationSiteID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `riverID` int(10) unsigned NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `dateRegistered` datetime NOT NULL,
  `categoryID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`evaluationSiteID`),
  KEY `index2` (`riverID`),
  KEY `fk9` (`categoryID`),
  KEY `index5` (`categoryID`),
  KEY `fk19` (`riverID`),
  CONSTRAINT `fk9` FOREIGN KEY (`categoryID`) REFERENCES `category` (`categoryId`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk19` FOREIGN KEY (`riverID`) REFERENCES `river` (`riverID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table insect
# ------------------------------------------------------------

DROP TABLE IF EXISTS `insect`;

CREATE TABLE `insect` (
  `insectID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `groupName` varchar(255) NOT NULL,
  `sensitivityScore` int(11) NOT NULL,
  PRIMARY KEY (`insectID`),
  UNIQUE KEY `index2` (`groupName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table insectImage
# ------------------------------------------------------------

DROP TABLE IF EXISTS `insectImage`;

CREATE TABLE `insectImage` (
  `insectImageID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `insectID` int(10) unsigned NOT NULL,
  `uri` varchar(255) NOT NULL,
  `dateRegistered` datetime NOT NULL,
  PRIMARY KEY (`insectImageID`),
  UNIQUE KEY `index4` (`insectID`,`uri`),
  KEY `index2` (`insectID`),
  KEY `fk12` (`insectID`),
  CONSTRAINT `fk12` FOREIGN KEY (`insectID`) REFERENCES `insect` (`insectID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table province
# ------------------------------------------------------------

DROP TABLE IF EXISTS `province`;

CREATE TABLE `province` (
  `provinceID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `countryID` int(10) unsigned NOT NULL,
  `provinceName` varchar(255) NOT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  PRIMARY KEY (`provinceID`),
  UNIQUE KEY `index4` (`countryID`,`provinceName`),
  KEY `index2` (`countryID`),
  KEY `fk1` (`countryID`),
  CONSTRAINT `fk1` FOREIGN KEY (`countryID`) REFERENCES `country` (`countryID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table river
# ------------------------------------------------------------

DROP TABLE IF EXISTS `river`;

CREATE TABLE `river` (
  `riverID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `riverName` varchar(255) NOT NULL,
  `originLatitude` double DEFAULT NULL,
  `originLongitude` double DEFAULT NULL,
  `endLatitude` double DEFAULT NULL,
  `endLongitude` double DEFAULT NULL,
  `originCountryID` int(10) unsigned DEFAULT NULL,
  `endCountryID` int(10) unsigned DEFAULT NULL,
  `dateRegistered` datetime NOT NULL,
  PRIMARY KEY (`riverID`),
  UNIQUE KEY `index6` (`riverName`),
  KEY `index2` (`originCountryID`),
  KEY `index3` (`endCountryID`),
  KEY `fk3` (`originCountryID`),
  KEY `fk4` (`endCountryID`),
  CONSTRAINT `fk3` FOREIGN KEY (`originCountryID`) REFERENCES `country` (`countryID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk4` FOREIGN KEY (`endCountryID`) REFERENCES `country` (`countryID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table riverTown
# ------------------------------------------------------------

DROP TABLE IF EXISTS `riverTown`;

CREATE TABLE `riverTown` (
  `riverTownID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `riverID` int(10) unsigned NOT NULL,
  `townID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`riverTownID`),
  UNIQUE KEY `index6` (`riverID`,`townID`),
  KEY `index2` (`riverID`),
  KEY `index3` (`townID`),
  KEY `fk5` (`riverID`),
  KEY `fk6` (`townID`),
  CONSTRAINT `fk5` FOREIGN KEY (`riverID`) REFERENCES `river` (`riverID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk6` FOREIGN KEY (`townID`) REFERENCES `town` (`townID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table team
# ------------------------------------------------------------

DROP TABLE IF EXISTS `team`;

CREATE TABLE `team` (
  `teamID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `townID` int(10) unsigned NOT NULL,
  `teamName` varchar(255) NOT NULL,
  `dateRegistered` datetime NOT NULL,
  PRIMARY KEY (`teamID`),
  UNIQUE KEY `index4` (`townID`,`teamName`),
  KEY `index2` (`townID`),
  KEY `fk8` (`townID`),
  CONSTRAINT `fk8` FOREIGN KEY (`townID`) REFERENCES `town` (`townID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table teamMember
# ------------------------------------------------------------

DROP TABLE IF EXISTS `teamMember`;

CREATE TABLE `teamMember` (
  `teamMemberID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `teamID` int(10) unsigned NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `cellphone` varchar(45) DEFAULT NULL,
  `dateRegistered` datetime NOT NULL,
  `pin` varchar(45) NOT NULL,
  `activeFlag` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`teamMemberID`),
  KEY `index2` (`teamID`),
  KEY `fk7` (`teamID`),
  CONSTRAINT `fk7` FOREIGN KEY (`teamID`) REFERENCES `team` (`teamID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table town
# ------------------------------------------------------------

DROP TABLE IF EXISTS `town`;

CREATE TABLE `town` (
  `townID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `provinceID` int(10) unsigned NOT NULL,
  `townName` varchar(255) NOT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  PRIMARY KEY (`townID`),
  UNIQUE KEY `index4` (`provinceID`,`townName`),
  KEY `index2` (`provinceID`),
  KEY `fk2` (`provinceID`),
  CONSTRAINT `fk2` FOREIGN KEY (`provinceID`) REFERENCES `province` (`provinceID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
