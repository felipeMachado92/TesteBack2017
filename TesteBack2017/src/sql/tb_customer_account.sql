-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 05-Set-2017 às 19:19
-- Versão do servidor: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `customerdb`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_customer_account`
--

CREATE TABLE `tb_customer_account` (
  `id_customer` int(11) NOT NULL,
  `cpf_cnpj` varchar(14) NOT NULL,
  `nm_customer` varchar(50) NOT NULL,
  `is_active` int(11) NOT NULL,
  `vl_total` decimal(9,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tb_customer_account`
--

INSERT INTO `tb_customer_account` (`id_customer`, `cpf_cnpj`, `nm_customer`, `is_active`, `vl_total`) VALUES
(2, '333', 'jose', 1, '300.00'),
(10, '12345', 'nana', 0, '1200.00'),
(30, '555', 'teste', 1, '1800.00'),
(1500, '39725222822', 'felipe', 1, '600.00'),
(1558, '88888888', 'noah', 1, '900.00'),
(1560, '1234567', 'joana', 0, '355.67'),
(2600, '333335555', 'andre', 0, '800.00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_customer_account`
--
ALTER TABLE `tb_customer_account`
  ADD PRIMARY KEY (`id_customer`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
