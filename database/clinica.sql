-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 02/10/2023 às 03:13
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `clinica`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `medico`
--

CREATE TABLE `medico` (
  `id` int(11) NOT NULL,
  `CRM` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `especialidade` varchar(255) DEFAULT NULL,
  `salario` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `medico`
--

INSERT INTO `medico` (`id`, `CRM`, `nome`, `especialidade`, `salario`) VALUES
(5, '12345', 'Dr. João', 'Cardiologista', 8000.00),
(6, '54321', 'Dr. Maria', 'Dermatologista', 7500.00),
(7, '98765', 'Dr. Pedro', 'Ortopedista', 8200.00),
(8, '45678', 'Dr. Ana', 'Ginecologista', 7800.00),
(9, '13579', 'Dr. Luiza', 'Oftalmologista', 7900.00),
(10, '24680', 'Dr. Rafael', 'Pneumologista', 8100.00),
(11, '78901', 'Dr. Carla', 'Neurologista', 8200.00),
(12, '10234', 'Dr. Marcos', 'Urologista', 7900.00),
(13, '56789', 'Dr. Laura', 'Pediatra', 7600.00),
(14, '54321', 'Dr. Mateus', 'Cirurgião', 8500.00);

-- --------------------------------------------------------

--
-- Estrutura para tabela `paciente`
--

CREATE TABLE `paciente` (
  `id` int(11) NOT NULL,
  `medRes` int(11) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `rg` varchar(20) DEFAULT NULL,
  `cpf` varchar(14) DEFAULT NULL,
  `end` varchar(255) DEFAULT NULL,
  `tel` varchar(15) DEFAULT NULL,
  `quarto` varchar(10) DEFAULT NULL,
  `andar` varchar(10) DEFAULT NULL,
  `dataNasc` date DEFAULT NULL,
  `horaVis` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `paciente`
--

INSERT INTO `paciente` (`id`, `medRes`, `nome`, `rg`, `cpf`, `end`, `tel`, `quarto`, `andar`, `dataNasc`, `horaVis`) VALUES
(6, 5, 'Paciente 1', '12345678', '11111111111', 'Endereço 1', '111-111-1111', '101', '1', '1990-01-01', '10:00:00'),
(7, 6, 'Paciente 2', '23456789', '22222222222', 'Endereço 2', '222-222-2222', '102', '1', '1991-02-02', '11:00:00'),
(8, 7, 'Paciente 3', '34567890', '33333333333', 'Endereço 3', '333-333-3333', '201', '2', '1992-03-03', '12:00:00'),
(9, 8, 'Paciente 4', '45678901', '44444444444', 'Endereço 4', '444-444-4444', '202', '2', '1993-04-04', '13:00:00'),
(10, 9, 'Paciente 5', '56789012', '55555555555', 'Endereço 5', '555-555-5555', '301', '3', '1994-05-05', '14:00:00'),
(11, 10, 'Paciente 6', '67890123', '66666666666', 'Endereço 6', '666-666-6666', '302', '3', '1995-06-06', '15:00:00'),
(12, 11, 'Paciente 7', '78901234', '77777777777', 'Endereço 7', '777-777-7777', '401', '4', '1996-07-07', '16:00:00'),
(13, 12, 'Paciente 8', '89012345', '88888888888', 'Endereço 8', '888-888-8888', '402', '4', '1997-08-08', '17:00:00');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tratamentos`
--

CREATE TABLE `tratamentos` (
  `id` int(11) NOT NULL,
  `id_paciente` int(11) DEFAULT NULL,
  `id_medico` int(11) DEFAULT NULL,
  `nome_tratamento` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tratamentos`
--

INSERT INTO `tratamentos` (`id`, `id_paciente`, `id_medico`, `nome_tratamento`) VALUES
(41, 6, 5, 'Tratamento 1'),
(42, 7, 6, 'Tratamento 2'),
(43, 8, 7, 'Tratamento 3'),
(44, 9, 8, 'Tratamento 4'),
(45, 10, 9, 'Tratamento 5'),
(46, 11, 10, 'Tratamento 6'),
(47, 12, 11, 'Tratamento 7'),
(48, 13, 12, 'Tratamento 8');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `medRes` (`medRes`);

--
-- Índices de tabela `tratamentos`
--
ALTER TABLE `tratamentos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_paciente` (`id_paciente`),
  ADD KEY `id_medico` (`id_medico`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `medico`
--
ALTER TABLE `medico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de tabela `paciente`
--
ALTER TABLE `paciente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de tabela `tratamentos`
--
ALTER TABLE `tratamentos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `paciente`
--
ALTER TABLE `paciente`
  ADD CONSTRAINT `paciente_ibfk_1` FOREIGN KEY (`medRes`) REFERENCES `medico` (`id`);

--
-- Restrições para tabelas `tratamentos`
--
ALTER TABLE `tratamentos`
  ADD CONSTRAINT `tratamentos_ibfk_1` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id`),
  ADD CONSTRAINT `tratamentos_ibfk_2` FOREIGN KEY (`id_medico`) REFERENCES `medico` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
