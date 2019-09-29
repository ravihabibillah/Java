-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 22, 2019 at 03:05 PM
-- Server version: 10.3.13-MariaDB
-- PHP Version: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bioskop`
--

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `id_kursi` int(11) NOT NULL,
  `id_status` int(11) NOT NULL,
  `id_pembeli` int(11) DEFAULT NULL,
  `id_tayang` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`id_kursi`, `id_status`, `id_pembeli`, `id_tayang`) VALUES
(0, 0, NULL, 1),
(1, 0, NULL, 1),
(2, 0, NULL, 1),
(3, 0, NULL, 1),
(4, 1, 1, 1),
(5, 0, NULL, 1),
(6, 0, NULL, 1),
(7, 0, NULL, 1),
(8, 0, NULL, 1),
(0, 0, 1, 3),
(1, 1, 1, 3),
(2, 0, NULL, 3),
(3, 0, NULL, 3),
(4, 1, 1, 3),
(5, 1, 1, 3),
(6, 0, NULL, 3),
(7, 0, NULL, 3),
(8, 0, NULL, 3),
(1, 0, NULL, 5),
(2, 0, NULL, 5),
(3, 0, NULL, 5),
(4, 0, NULL, 5),
(5, 0, NULL, 5),
(6, 0, NULL, 5),
(7, 0, NULL, 5),
(8, 0, NULL, 5),
(0, 0, NULL, 5),
(0, 0, NULL, 4),
(1, 0, NULL, 4),
(2, 0, NULL, 4),
(3, 0, NULL, 4),
(4, 0, NULL, 4),
(5, 0, NULL, 4),
(6, 0, NULL, 4),
(7, 0, NULL, 4),
(8, 0, NULL, 4);

-- --------------------------------------------------------

--
-- Table structure for table `film`
--

CREATE TABLE `film` (
  `id_film` int(11) NOT NULL,
  `judul` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sinopsis` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tgl_rilis` date DEFAULT NULL,
  `harga` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `film`
--

INSERT INTO `film` (`id_film`, `judul`, `sinopsis`, `tgl_rilis`, `harga`) VALUES
(1, 'Captain Marvel', 'Captain Marvel is an extraterrestrial Kree warrior who finds herself caught in the middle of an intergalactic battle between her people and the Skrulls. Living on Earth in 1995, she keeps having recurring memories of another life as U.S. Air Force pilot Carol Danvers. With help from Nick Fury, Captain Marvel tries to uncover the secrets of her past while harnessing her special superpowers to end the war with the evil Skrulls.', '2019-03-08', 35000),
(2, 'Alita The Battle Angel', 'Alita: Battle Angel is a 2019 American cyberpunk action film based on the 1990s Japanese manga series Gunnm (known as Battle Angel Alita in the English translation) by Yukito Kishiro. Directed by Robert Rodriguez, the film is written by James Cameron and Laeta Kalogridis. Rosa Salazar stars as the titular heroine Alita, an amnesiac cyborg girl who sets out to learn about her destiny after she awakens in a new body with no past memory of who she is. Christoph Waltz, Jennifer Connelly, Mahershala Ali, Ed Skrein, Jackie Earle Haley and Keean Johnson also star in supporting roles.', '2019-01-31', 35000),
(3, 'Shazam!', 'We all have superhero inside of us -- it just takes a bit of magic to bring it out. In 14-year-old Billy Batson case, all he needs to do is shout out one word to transform into the adult superhero Shazam. Still a kid at heart, Shazam revels in the new version of himself by doing what any other teen would do -- have fun while testing out his newfound powers. but he will need to master them quickly before the evil Dr.Thaddeus Sivana can get his hands on Shazam magical abilities.', '2019-04-05', 35000);

-- --------------------------------------------------------

--
-- Table structure for table `jadwal`
--

CREATE TABLE `jadwal` (
  `id_jadwal` int(11) NOT NULL,
  `waktu` varchar(6) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `jadwal`
--

INSERT INTO `jadwal` (`id_jadwal`, `waktu`) VALUES
(1, '11.00'),
(2, '14.00'),
(3, '19.30'),
(4, '21.00');

-- --------------------------------------------------------

--
-- Table structure for table `kursi`
--

CREATE TABLE `kursi` (
  `id_kursi` int(11) NOT NULL,
  `keterangan` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `kursi`
--

INSERT INTO `kursi` (`id_kursi`, `keterangan`) VALUES
(0, 'kursi 1'),
(1, 'kursi 2'),
(2, 'kursi 3'),
(3, 'kursi 4'),
(4, 'kursi 5'),
(5, 'kursi 6'),
(6, 'kursi 7'),
(7, 'kursi 8'),
(8, 'kursi 9');

-- --------------------------------------------------------

--
-- Table structure for table `pembeli`
--

CREATE TABLE `pembeli` (
  `id_pembeli` int(11) NOT NULL,
  `username` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `alamat` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `emoney` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `pembeli`
--

INSERT INTO `pembeli` (`id_pembeli`, `username`, `password`, `email`, `alamat`, `emoney`) VALUES
(1, 'murah', '123456', 'murah@ymail.com', 'Jl.Dewan', 45000),
(2, 'murah', 'murah124', 'R.murah@ymail.com', 'Jl.Dewan', 0),
(3, 'rahmat', 'palembang', 'rahmat@gmail.com', 'Jl.Bapak', 0),
(4, 'rafi', '8998', 'haffirafi@gmail.com', 'sleman', 100000);

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

CREATE TABLE `status` (
  `id_status` int(11) NOT NULL,
  `keterangan` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `status`
--

INSERT INTO `status` (`id_status`, `keterangan`) VALUES
(0, 'kosong'),
(1, 'sudah dipesan');

-- --------------------------------------------------------

--
-- Table structure for table `tayang`
--

CREATE TABLE `tayang` (
  `id_tayang` int(11) NOT NULL,
  `id_jadwal` int(11) DEFAULT NULL,
  `id_film` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `tayang`
--

INSERT INTO `tayang` (`id_tayang`, `id_jadwal`, `id_film`) VALUES
(1, 1, 1),
(3, 3, 1),
(4, 1, 2),
(5, 2, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD KEY `FKid_kursi` (`id_kursi`),
  ADD KEY `FKid_status` (`id_status`),
  ADD KEY `FKid_pembeli` (`id_pembeli`),
  ADD KEY `FKid_tayang` (`id_tayang`);

--
-- Indexes for table `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`id_film`);

--
-- Indexes for table `jadwal`
--
ALTER TABLE `jadwal`
  ADD PRIMARY KEY (`id_jadwal`);

--
-- Indexes for table `kursi`
--
ALTER TABLE `kursi`
  ADD PRIMARY KEY (`id_kursi`);

--
-- Indexes for table `pembeli`
--
ALTER TABLE `pembeli`
  ADD PRIMARY KEY (`id_pembeli`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id_status`);

--
-- Indexes for table `tayang`
--
ALTER TABLE `tayang`
  ADD PRIMARY KEY (`id_tayang`),
  ADD KEY `FkIdJadwal` (`id_jadwal`),
  ADD KEY `FkIdFilm` (`id_film`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `film`
--
ALTER TABLE `film`
  MODIFY `id_film` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `jadwal`
--
ALTER TABLE `jadwal`
  MODIFY `id_jadwal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `pembeli`
--
ALTER TABLE `pembeli`
  MODIFY `id_pembeli` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tayang`
--
ALTER TABLE `tayang`
  MODIFY `id_tayang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `FKid_kursi` FOREIGN KEY (`id_kursi`) REFERENCES `kursi` (`id_kursi`),
  ADD CONSTRAINT `FKid_pembeli` FOREIGN KEY (`id_pembeli`) REFERENCES `pembeli` (`id_pembeli`),
  ADD CONSTRAINT `FKid_status` FOREIGN KEY (`id_status`) REFERENCES `status` (`id_status`),
  ADD CONSTRAINT `FKid_tayang` FOREIGN KEY (`id_tayang`) REFERENCES `tayang` (`id_tayang`);

--
-- Constraints for table `tayang`
--
ALTER TABLE `tayang`
  ADD CONSTRAINT `FkIdFilm` FOREIGN KEY (`id_film`) REFERENCES `film` (`id_film`),
  ADD CONSTRAINT `FkIdJadwal` FOREIGN KEY (`id_jadwal`) REFERENCES `jadwal` (`id_jadwal`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
