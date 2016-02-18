-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Client :  localhost:3306
-- Généré le :  Jeu 18 Février 2016 à 15:11
-- Version du serveur :  5.5.42
-- Version de PHP :  7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `supfitness`
--
CREATE DATABASE IF NOT EXISTS `supfitness` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `supfitness`;

-- --------------------------------------------------------

--
-- Structure de la table `RACE`
--

CREATE TABLE `RACE` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `STARTDATE` datetime NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `RACE`
--

INSERT INTO `RACE` (`ID`, `NAME`, `user_id`, `STARTDATE`) VALUES
(1, 'Race 01', 1, '2016-02-18 09:00:00'),
(2, 'Race Old 01', 1, '2016-02-02 00:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `TRACK`
--

CREATE TABLE `TRACK` (
  `ID` bigint(20) NOT NULL,
  `LATITUDE` double NOT NULL,
  `LONGITUDE` double NOT NULL,
  `SPEED` double NOT NULL,
  `race_id` bigint(20) DEFAULT NULL,
  `STARTDATE` datetime NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `TRACK`
--

INSERT INTO `TRACK` (`ID`, `LATITUDE`, `LONGITUDE`, `SPEED`, `race_id`, `STARTDATE`) VALUES
(1, 44.2, 7.5, 13, 1, '2016-02-18 10:00:00'),
(2, 44.1, 7.4, 8, 1, '2016-02-18 11:00:00'),
(3, 44, 7.3, 6, 1, '2016-02-18 10:02:00');

-- --------------------------------------------------------

--
-- Structure de la table `USER`
--

CREATE TABLE `USER` (
  `ID` bigint(20) NOT NULL,
  `EMAIL` varchar(255) NOT NULL,
  `FIRSTNAME` varchar(255) NOT NULL,
  `LASTNAME` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `USERNAME` varchar(255) NOT NULL,
  `POSTALCODE` varchar(5) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `USER`
--

INSERT INTO `USER` (`ID`, `EMAIL`, `FIRSTNAME`, `LASTNAME`, `PASSWORD`, `USERNAME`, `POSTALCODE`) VALUES
(1, 'test@supinfo.com', 'Test', 'Test', '9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08', 'test', '');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `RACE`
--
ALTER TABLE `RACE`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_RACE_user_id` (`user_id`);

--
-- Index pour la table `TRACK`
--
ALTER TABLE `TRACK`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_TRACK_race_id` (`race_id`);

--
-- Index pour la table `USER`
--
ALTER TABLE `USER`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `USERNAME` (`USERNAME`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `RACE`
--
ALTER TABLE `RACE`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `TRACK`
--
ALTER TABLE `TRACK`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `USER`
--
ALTER TABLE `USER`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `RACE`
--
ALTER TABLE `RACE`
  ADD CONSTRAINT `FK_RACE_user_id` FOREIGN KEY (`user_id`) REFERENCES `USER` (`ID`);

--
-- Contraintes pour la table `TRACK`
--
ALTER TABLE `TRACK`
  ADD CONSTRAINT `FK_TRACK_race_id` FOREIGN KEY (`race_id`) REFERENCES `RACE` (`ID`);

