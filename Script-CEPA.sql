CREATE DATABASE `Cepa3` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE Cepa3;

CREATE TABLE `Autor` (
  `idAutor` int(20) NOT NULL AUTO_INCREMENT,
  `nacionalitat` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idAutor`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `Libro` (
  `idLibro` int(11) NOT NULL AUTO_INCREMENT,
  `tipus` varchar(255) DEFAULT NULL,
  `titol` varchar(255) DEFAULT NULL,
  `idAutor` int(20) DEFAULT NULL,
  PRIMARY KEY (`idLibro`),
  KEY `FK_LIB_AUT` (`idAutor`),
  CONSTRAINT `FK_LIB_AUT` FOREIGN KEY (`idAutor`) REFERENCES `Autor` (`idAutor`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` enum('ADMIN','USER') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;