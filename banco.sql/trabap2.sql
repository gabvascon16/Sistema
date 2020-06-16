-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 11-Jun-2020 às 05:34
-- Versão do servidor: 10.1.38-MariaDB
-- versão do PHP: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ap2`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

CREATE TABLE `categoria` (
  `categoria_id` tinyint(3) UNSIGNED NOT NULL,
  `nome` varchar(25) NOT NULL,
  `ultima_atualizacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `categoria`
--

INSERT INTO `categoria` (`categoria_id`, `nome`, `ultima_atualizacao`) VALUES
(1, 'Action', '2006-02-15 07:46:27'),
(2, 'Animation', '2006-02-15 07:46:27'),
(3, 'Children', '2006-02-15 07:46:27'),
(4, 'Classics', '2006-02-15 07:46:27'),
(5, 'Comedy', '2006-02-15 07:46:27'),
(6, 'Documentary', '2006-02-15 07:46:27'),
(7, 'Drama', '2006-02-15 07:46:27'),
(8, 'Family', '2006-02-15 07:46:27'),
(9, 'Foreign', '2006-02-15 07:46:27'),
(10, 'Games', '2006-02-15 07:46:27'),
(11, 'Horror', '2006-02-15 07:46:27'),
(12, 'Music', '2006-02-15 07:46:27'),
(13, 'New', '2006-02-15 07:46:27'),
(14, 'Sci-Fi', '2006-02-15 07:46:27'),
(15, 'Sports', '2006-02-15 07:46:27'),
(16, 'Travel', '2006-02-15 07:46:27');

-- --------------------------------------------------------

--
-- Estrutura da tabela `filme`
--

CREATE TABLE `filme` (
  `filme_id` smallint(5) UNSIGNED NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `descricao` text,
  `ano_de_lancamento` year(4) DEFAULT NULL,
  `idioma_id` tinyint(3) UNSIGNED NOT NULL,
  `idioma_original_id` tinyint(3) UNSIGNED DEFAULT NULL,
  `duracao_da_locacao` tinyint(3) UNSIGNED NOT NULL DEFAULT '3',
  `preco_da_locacao` decimal(4,2) NOT NULL DEFAULT '4.99',
  `duracao_do_filme` smallint(5) UNSIGNED DEFAULT NULL,
  `custo_de_substituicao` decimal(5,2) NOT NULL DEFAULT '19.99',
  `classificacao` enum('G','PG','PG-13','R','NC-17') DEFAULT 'G',
  `recursos_especiais` set('Trailers','Commentaries','Deleted Scenes','Behind the Scenes') DEFAULT NULL,
  `ultima_atualizacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `filme`
--

INSERT INTO `filme` (`filme_id`, `titulo`, `descricao`, `ano_de_lancamento`, `idioma_id`, `idioma_original_id`, `duracao_da_locacao`, `preco_da_locacao`, `duracao_do_filme`, `custo_de_substituicao`, `classificacao`, `recursos_especiais`, `ultima_atualizacao`) VALUES
(1, 'ACADEMY DINOSAUR', 'A Epic Drama of a Feminist And a Mad Scientist who must Battle a Teacher in The Canadian Rockies', 2006, 1, NULL, 6, '0.99', 86, '20.99', 'PG', 'Deleted Scenes,Behind the Scenes', '2006-02-15 08:03:42'),
(2, 'ACE GOLDFINGER', 'A Astounding Epistle of a Database Administrator And a Explorer who must Find a Car in Ancient China', 2006, 1, NULL, 3, '4.99', 48, '12.99', 'G', 'Trailers,Deleted Scenes', '2006-02-15 08:03:42'),
(3, 'ADAPTATION HOLES', 'A Astounding Reflection of a Lumberjack And a Car who must Sink a Lumberjack in A Baloon Factory', 2006, 1, NULL, 7, '2.99', 50, '18.99', 'NC-17', 'Trailers,Deleted Scenes', '2006-02-15 08:03:42'),
(4, 'AFFAIR PREJUDICE', 'A Fanciful Documentary of a Frisbee And a Lumberjack who must Chase a Monkey in A Shark Tank', 2006, 1, NULL, 5, '2.99', 117, '26.99', 'G', 'Commentaries,Behind the Scenes', '2006-02-15 08:03:42'),
(5, 'AFRICAN EGG', 'A Fast-Paced Documentary of a Pastry Chef And a Dentist who must Pursue a Forensic Psychologist in The Gulf of Mexico', 2006, 1, NULL, 6, '2.99', 130, '22.99', 'G', 'Deleted Scenes', '2006-02-15 08:03:42'),
(6, 'AGENT TRUMAN', 'A Intrepid Panorama of a Robot And a Boy who must Escape a Sumo Wrestler in Ancient China', 2006, 1, NULL, 3, '2.99', 169, '17.99', 'PG', 'Deleted Scenes', '2006-02-15 08:03:42'),
(7, 'AIRPLANE SIERRA', 'A Touching Saga of a Hunter And a Butler who must Discover a Butler in A Jet Boat', 2006, 1, NULL, 6, '4.99', 62, '28.99', 'PG-13', 'Trailers,Deleted Scenes', '2006-02-15 08:03:42'),
(8, 'AIRPORT POLLOCK', 'A Epic Tale of a Moose And a Girl who must Confront a Monkey in Ancient India', 2006, 1, NULL, 6, '4.99', 54, '15.99', 'R', 'Trailers', '2006-02-15 08:03:42'),
(9, 'ALABAMA DEVIL', 'A Thoughtful Panorama of a Database Administrator And a Mad Scientist who must Outgun a Mad Scientist in A Jet Boat', 2006, 1, NULL, 3, '2.99', 114, '21.99', 'PG-13', 'Trailers,Deleted Scenes', '2006-02-15 08:03:42'),
(10, 'ALADDIN CALENDAR', 'A Action-Packed Tale of a Man And a Lumberjack who must Reach a Feminist in Ancient China', 2006, 1, NULL, 6, '4.99', 63, '24.99', 'NC-17', 'Trailers,Deleted Scenes', '2006-02-15 08:03:42');

-- --------------------------------------------------------

--
-- Estrutura da tabela `filme_categoria`
--

CREATE TABLE `filme_categoria` (
  `filme_id` smallint(5) UNSIGNED NOT NULL,
  `categoria_id` tinyint(3) UNSIGNED NOT NULL,
  `ultima_atualizacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `filme_categoria`
--

INSERT INTO `filme_categoria` (`filme_id`, `categoria_id`, `ultima_atualizacao`) VALUES
(1, 6, '2006-02-15 08:07:09'),
(2, 11, '2006-02-15 08:07:09'),
(3, 6, '2006-02-15 08:07:09'),
(4, 11, '2006-02-15 08:07:09'),
(5, 8, '2006-02-15 08:07:09'),
(6, 9, '2006-02-15 08:07:09'),
(7, 5, '2006-02-15 08:07:09'),
(8, 11, '2006-02-15 08:07:09'),
(9, 11, '2006-02-15 08:07:09'),
(10, 15, '2006-02-15 08:07:09');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`categoria_id`);

--
-- Indexes for table `filme`
--
ALTER TABLE `filme`
  ADD PRIMARY KEY (`filme_id`),
  ADD KEY `idx_titulo` (`titulo`),
  ADD KEY `idx_fk_idioma_id` (`idioma_id`),
  ADD KEY `idx_fk_idioma_original_id` (`idioma_original_id`);

--
-- Indexes for table `filme_categoria`
--
ALTER TABLE `filme_categoria`
  ADD PRIMARY KEY (`filme_id`,`categoria_id`),
  ADD KEY `fk_filme_categoria_categoria` (`categoria_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categoria`
--
ALTER TABLE `categoria`
  MODIFY `categoria_id` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `filme`
--
ALTER TABLE `filme`
  MODIFY `filme_id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1001;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `filme_categoria`
--
ALTER TABLE `filme_categoria`
  ADD CONSTRAINT `fk_filme_categoria_categoria` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`categoria_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_filme_categoria_filme` FOREIGN KEY (`filme_id`) REFERENCES `filme` (`filme_id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
