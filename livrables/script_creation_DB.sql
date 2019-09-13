-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  lun. 24 déc. 2018 à 23:22
-- Version du serveur :  10.1.37-MariaDB
-- Version de PHP :  7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

-- Création d'un utilisateur de la base de données
-- CREATE USER 'theuser'@'localhost' IDENTIFIED BY '12-_password';
GRANT ALL PRIVILEGES ON elibrary.* TO 'theuser'@'localhost';


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `elibrary`
--
CREATE DATABASE IF NOT EXISTS `elibrary` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `elibrary`;

-- --------------------------------------------------------

--
-- Structure de la table `book`
--

CREATE TABLE `book` (
  `bookId` int(11) NOT NULL,
  `isAvailable` bit(1) NOT NULL,
  `borrowing_idborrow` int(11) DEFAULT NULL,
  `work_worksId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `borrowing`
--

CREATE TABLE `borrowing` (
  `idborrow` int(11) NOT NULL,
  `isExtended` bit(1) NOT NULL,
  `issueDate` datetime(6) DEFAULT NULL,
  `returnDate` datetime(6) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `book_bookId` int(11) DEFAULT NULL,
  `member_iduser` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `library`
--

CREATE TABLE `library` (
  `libId` int(11) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `libName` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `library_work`
--

CREATE TABLE `library_work` (
  `Library_libId` int(11) NOT NULL,
  `works_worksId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `member`
--

CREATE TABLE `member` (
  `address` varchar(512) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `iduser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `member_borrowing`
--

CREATE TABLE `member_borrowing` (
  `Member_iduser` int(11) NOT NULL,
  `borrowing_idborrow` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `seq_borrow`
--

CREATE TABLE `seq_borrow` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `seq_user`
--

CREATE TABLE `seq_user` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `seq_work`
--

CREATE TABLE `seq_work` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `iduser` int(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `work`
--

CREATE TABLE `work` (
  `worksId` int(11) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `bookDescription` varchar(255) DEFAULT NULL,
  `imgUrl` varchar(255) DEFAULT NULL,
  `literaryGenre` varchar(255) DEFAULT NULL,
  `publicationYear` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `copies` int(11) NOT NULL,
  `library_libId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `work_book`
--

CREATE TABLE `work_book` (
  `Work_worksId` int(11) NOT NULL,
  `books_bookId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`bookId`),
  ADD KEY `FK190fkfdspjs7x9oncsx6p03v6` (`borrowing_idborrow`),
  ADD KEY `FKl1uqjikhm7xkm0ciei67h23lo` (`work_worksId`);

--
-- Index pour la table `borrowing`
--
ALTER TABLE `borrowing`
  ADD PRIMARY KEY (`idborrow`),
  ADD KEY `FK40b4unx1l8tvghtqvdfbt7br4` (`book_bookId`),
  ADD KEY `FKrox0u4emv7qemi2muiiwc6ge0` (`member_iduser`);

--
-- Index pour la table `library`
--
ALTER TABLE `library`
  ADD PRIMARY KEY (`libId`);

--
-- Index pour la table `library_work`
--
ALTER TABLE `library_work`
  ADD UNIQUE KEY `UK_j6pjnoqj96f7r4r1la293lkae` (`works_worksId`),
  ADD KEY `FKbgoseo8mmwlqvour609btoyb2` (`Library_libId`);

--
-- Index pour la table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`iduser`);

--
-- Index pour la table `member_borrowing`
--
ALTER TABLE `member_borrowing`
  ADD UNIQUE KEY `UK_hgb8mjtafwkj2o3v3bx0bo2a0` (`borrowing_idborrow`),
  ADD KEY `FKewnrm1jygoklnxrnw7qdhwk54` (`Member_iduser`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`iduser`);

--
-- Index pour la table `work`
--
ALTER TABLE `work`
  ADD PRIMARY KEY (`worksId`),
  ADD KEY `FK8pel8ttd4mn8ofbpwf1381yfn` (`library_libId`);

--
-- Index pour la table `work_book`
--
ALTER TABLE `work_book`
  ADD UNIQUE KEY `UK_4y3ap09kijgyxx6l3tyy6n7vc` (`books_bookId`),
  ADD KEY `FK198b03kyqdur4d9qwuovsjxjb` (`Work_worksId`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `FK190fkfdspjs7x9oncsx6p03v6` FOREIGN KEY (`borrowing_idborrow`) REFERENCES `borrowing` (`idborrow`),
  ADD CONSTRAINT `FKl1uqjikhm7xkm0ciei67h23lo` FOREIGN KEY (`work_worksId`) REFERENCES `work` (`worksId`);

--
-- Contraintes pour la table `borrowing`
--
ALTER TABLE `borrowing`
  ADD CONSTRAINT `FK40b4unx1l8tvghtqvdfbt7br4` FOREIGN KEY (`book_bookId`) REFERENCES `book` (`bookId`),
  ADD CONSTRAINT `FKrox0u4emv7qemi2muiiwc6ge0` FOREIGN KEY (`member_iduser`) REFERENCES `member` (`iduser`);

--
-- Contraintes pour la table `library_work`
--
ALTER TABLE `library_work`
  ADD CONSTRAINT `FKbgoseo8mmwlqvour609btoyb2` FOREIGN KEY (`Library_libId`) REFERENCES `library` (`libId`),
  ADD CONSTRAINT `FKp7aboria5nrsbulmhk3l0ocvr` FOREIGN KEY (`works_worksId`) REFERENCES `work` (`worksId`);

--
-- Contraintes pour la table `member`
--
ALTER TABLE `member`
  ADD CONSTRAINT `FKnn7c8oswm82cl4rs616b9ylnu` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`);

--
-- Contraintes pour la table `member_borrowing`
--
ALTER TABLE `member_borrowing`
  ADD CONSTRAINT `FKewnrm1jygoklnxrnw7qdhwk54` FOREIGN KEY (`Member_iduser`) REFERENCES `member` (`iduser`),
  ADD CONSTRAINT `FKki566xp525wi4ibmb9wl716x5` FOREIGN KEY (`borrowing_idborrow`) REFERENCES `borrowing` (`idborrow`);

--
-- Contraintes pour la table `work`
--
ALTER TABLE `work`
  ADD CONSTRAINT `FK8pel8ttd4mn8ofbpwf1381yfn` FOREIGN KEY (`library_libId`) REFERENCES `library` (`libId`);

--
-- Contraintes pour la table `work_book`
--
ALTER TABLE `work_book`
  ADD CONSTRAINT `FK198b03kyqdur4d9qwuovsjxjb` FOREIGN KEY (`Work_worksId`) REFERENCES `work` (`worksId`),
  ADD CONSTRAINT `FK6chcgo0egn98j4hhcwoatduve` FOREIGN KEY (`books_bookId`) REFERENCES `book` (`bookId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
