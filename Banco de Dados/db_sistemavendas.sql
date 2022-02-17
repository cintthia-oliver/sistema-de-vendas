-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 17-Fev-2022 às 15:23
-- Versão do servidor: 10.4.18-MariaDB
-- versão do PHP: 7.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `db_sistemavendas`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_clientes`
--

CREATE TABLE `tb_clientes` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `rg` varchar(30) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `celular` varchar(30) DEFAULT NULL,
  `cep` varchar(100) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `complemento` varchar(200) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tb_clientes`
--

INSERT INTO `tb_clientes` (`id`, `nome`, `rg`, `cpf`, `email`, `telefone`, `celular`, `cep`, `endereco`, `numero`, `complemento`, `bairro`, `cidade`, `estado`) VALUES
(9, 'charlie', '22.222.222', '111.111.111-11', 'charlie@charliegmail.com', '(11) 1111 - 1111', '(11) 1 1111 - 1111', '11111-111', 'tv raimundinho', 1, 'casa', 'trançador', 'caxambu', 'MG'),
(12, 'joao da silva', '11.111.111', '111.111.111-13', 'charlie@charliegmail.com', '(11) 1111 - 1111', '(11) 1 1111 - 1111', '11111-111', 'tv raimundinho', 1, 'casa', 'trançador', 'caxambu', 'MG'),
(13, ' charlie rodrigues da silva', '11.111.111', '111.111.111-12', 'charlie@charliegmail.com', '(11) 1111 - 1111', '(11) 1 1111 - 1111', '11111-111', 'tv raimundinho', 1, 'casa', 'trançador', 'caxambu', 'MG'),
(14, 'maria dos reis', '77.777.777-7', '111.111.111-14', 'reis@gmail.com', '(11)7777-7777', '(11)77777-7777', '77777-777', 'R. Vilha', 404, '19 B', 'vila verde', 'São Pedro', 'SP'),
(16, 'Juliana Almeida', '11.111.111', '546.513.213-21', 'juliana@gmail.com', '(44) 4444 - 4444', '(66) 6 6666 - 6666', '37440-000', 'trav. dos santos', 45, '', 'trançador', 'caxambu', 'GO'),
(18, 'charlie abraao 2', '11.111.111', '999.999.999-99', 'helio@gmail.com', '(11) 1111 - 1111', '(11) 1 1111 - 1111', '11111-111', 'rua das flores mais lindas', 55, 'alameda', 'entregador', 'cerranos', 'MT'),
(19, 'maria joana', '88.888.888', '999.999.999-99', 'helio@gmail.com', '(11) 1111 - 1111', '(11) 1 1111 - 1111', '22222-222', 'rua das flores mais lindas', 55, 'alameda', 'entregador', 'cerranos', 'MT'),
(20, 'joao lucas', '88.888.888- ', '165.165.516-51', 'lukinha@gmail.com', '(22)2222-2222', '(22)22222-2222', '22222-222', 'rua das flores mais lindas', 55, 'alameda', 'entregador', 'cerranos', 'MG'),
(24, 'Matheus Rodrigues', '55.555.555- ', '111.111.111-11', 'matheus@matheus', '(  )    -    ', '(  )     -    ', '99999-999', 'tv raimundinho', 12, '', 'motoboy', 'caxambu', 'SP'),
(28, 'Pedro Virginio dos Santos', '14.563.258-9', '456.789.321-56', 'pedro@gmail.com', '(11)1111-1111', '(11)11111-1111', '45698-723', 'R. Jandira', 56, 'B', 'São Pedro', 'Santa Clára', 'ES'),
(29, 'Bruno Silva Santana', '25.634.598-7', '123.456.789-95', 'bruno@gmail.com', '(22)2222-2222', '(22)22222-2222', '45698-723', 'R. Diamante', 231, 'A', 'Vale Grande', 'Pinheiros', 'MG'),
(31, 'Mariane Silva Pires', '14.569.778-8', '456.987.123-35', 'mariane@gmail.com', '(11)9999-9999', '(11)99999-9999', '01236-549', 'R. Alameda Pinheiros', 400, 'C', 'Garças', 'Espirito Santo', 'RJ'),
(32, 'Bruna Carla Santos', '88.888.888-8', '888.888.888-88', 'bruna@gmail.com', '(11)9999-9999', '(11)88888-8888', '88888-888', 'R. Carvalho', 8, 'h', 'Santos Matias', 'São Paulo', 'SP');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_fornecedores`
--

CREATE TABLE `tb_fornecedores` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `cnpj` varchar(100) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `celular` varchar(30) DEFAULT NULL,
  `cep` varchar(100) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `complemento` varchar(200) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tb_fornecedores`
--

INSERT INTO `tb_fornecedores` (`id`, `nome`, `cnpj`, `email`, `telefone`, `celular`, `cep`, `endereco`, `numero`, `complemento`, `bairro`, `cidade`, `estado`) VALUES
(1, 'sang sung', '77.777.777/7777-77', 'sangsung@gmail.com', '(88)8888-8888', '(88)88888-8888', '11111-111', 'R. Asteróide', 44, 'mobile', 'São Pedro', 'São Paulo', 'SP'),
(3, 'MOTO ', '22.222.222/2222-22', 'G@gmail.com', '(  )    -    ', '(  )     -    ', '11111-111', 'tv do beco2', 22, 'mobile', '2', 'caxambu2', 'SP'),
(5, 'magazine luiza', '99.999.999/9999-99', 'magazine@yahoo.com.br', '(22)2222-2222', '(22)22222-2222', '11111-111', 'joaquim dos santos', 78, 'empresa', 'vila verde', 'caxambu', 'RJ'),
(7, 'Pernambucanas', '33.333.333/3333-33', 'pernambucanas@yahoo.com.br', '(33)3333-3333', '(33)33333-3333', '33333-333', 'Jardins', 33, 'Condomínio B', 'Villa', 'Turmalina', 'MG'),
(9, 'Marisa', '14.523.658/9654-55', 'marisa@yahoo.com.br', '(44)4444-4444', '(44)44444-4444', '44444-444', 'Muriano', 4, 'Complexo A', 'Garças', 'Santos', 'ES');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_funcionarios`
--

CREATE TABLE `tb_funcionarios` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `rg` varchar(30) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `senha` varchar(10) DEFAULT NULL,
  `cargo` varchar(100) DEFAULT NULL,
  `nivel_acesso` varchar(50) DEFAULT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `celular` varchar(30) DEFAULT NULL,
  `cep` varchar(100) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `complemento` varchar(200) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tb_funcionarios`
--

INSERT INTO `tb_funcionarios` (`id`, `nome`, `rg`, `cpf`, `email`, `senha`, `cargo`, `nivel_acesso`, `telefone`, `celular`, `cep`, `endereco`, `numero`, `complemento`, `bairro`, `cidade`, `estado`) VALUES
(7, 'charlie rodrigues', '31.321.321', '321.321.321-12', 'charlie@gmail.com', '000', 'gerente', 'Administrador', '(11) 1111 - 1111', '(55) 5 5555 - 5555', '11231-321', 'travessa raimundinho', 45, '	tentando...', 'motoboy', 'caxambu', 'AP'),
(10, 'joana maria', '31.321.321', '321.321.321-12', 'j5@charlie', '000', 'balconista', 'Usuário', '(77) 7777 - 7777', '(77) 7 7777 - 7777', '11231-321', 'travessa manoel santoro', 77, '	tentando...', 'motoboy', 'baependi', 'AP'),
(11, 'joana bernadete', '31.321.321- ', '321.321.321-12', 'joana@charlie', '000', 'balconista', 'Usuário', '(  )    -    ', '(  )     -    ', '11231-321', 'travessa manoel santoro', 77, '	tentando...', 'motoboy', 'baependi', 'SP'),
(12, 'Carla Silva', '55.555.555-5', '999.999.999-99', 'carla@gmail.com', '123', 'Auxiliar', 'Administrador', '(11)1111-1111', '(11)11111-1111', '22222-222', 'R. Flores', 11, 'B', 'Guatiringa', 'Porto Seguro', 'RJ'),
(13, 'Nando Viena', '55.555.555-5', '999.999.999-99', 'nando@gmail.com', '123', 'Estagiário', 'Usuário', '(11)3333-3333', '(11)99999-9999', '66666-666', 'R. Leopoldino', 32, 'j', 'Osasco', 'Santa Clara', 'MG'),
(14, 'joana Claricie', '31.321.321-5', '321.321.321-12', 'joana@gamil.com', '123', 'balconista', 'Administrador', '(11)2222-2222', '(12)12122-2222', '11231-321', 'travessa manoel santoro', 77, 'tentando...', 'motoboy', 'baependi', 'SP');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_itensvendas`
--

CREATE TABLE `tb_itensvendas` (
  `id` int(11) NOT NULL,
  `venda_id` int(11) DEFAULT NULL,
  `produto_id` int(11) DEFAULT NULL,
  `qtd` int(11) DEFAULT NULL,
  `subtotal` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tb_itensvendas`
--

INSERT INTO `tb_itensvendas` (`id`, `venda_id`, `produto_id`, `qtd`, `subtotal`) VALUES
(210, 256, 8, 1, '3000.00'),
(211, 256, 9, 2, '200.00'),
(212, 257, 9, 1, '100.00'),
(213, 258, 7, 1, '1100.00'),
(214, 260, 9, 2, '240.00'),
(215, 260, 9, 2, '240.00'),
(216, 261, 9, 1, '120.00'),
(217, 261, 9, 1, '120.00'),
(218, 265, 12, 1, '1500.00'),
(219, 265, 12, 1, '1500.00'),
(220, 267, 9, 1, '120.00'),
(221, 267, 9, 1, '120.00'),
(222, 270, 17, 2, '960.00'),
(223, 270, 17, 2, '960.00'),
(224, 271, 12, 2, '1700.00'),
(225, 272, 17, 1, '480.00'),
(226, 272, 17, 1, '480.00'),
(227, 272, 17, 1, '480.00'),
(228, 273, 9, 1, '120.00'),
(229, 273, 9, 1, '120.00'),
(230, 273, 9, 1, '120.00'),
(231, 277, 7, 1, '1100.00'),
(232, 277, 7, 1, '1100.00'),
(233, 278, 9, 1, '120.00'),
(234, 279, 12, 1, '850.00'),
(235, 279, 8, 1, '3000.00'),
(236, 279, 7, 1, '1100.00'),
(237, 279, 17, 2, '960.00'),
(238, 280, 17, 1, '480.00'),
(239, 281, 9, 1, '120.00'),
(240, 282, 9, 1, '120.00'),
(241, 283, 17, 1, '480.00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_parcelas`
--

CREATE TABLE `tb_parcelas` (
  `id` int(11) NOT NULL,
  `cliente_id` int(11) DEFAULT NULL,
  `data_venda` datetime DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  `parcela` decimal(10,2) DEFAULT NULL,
  `obs` varchar(100) DEFAULT NULL,
  `num_parcelas` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tb_parcelas`
--

INSERT INTO `tb_parcelas` (`id`, `cliente_id`, `data_venda`, `total`, `parcela`, `obs`, `num_parcelas`) VALUES
(46, 12, '2020-11-02 00:00:00', '240.00', '24.00', '', 5),
(47, 14, '2020-11-02 00:00:00', '16000.00', '1000.00', 'maior que quinze mil', 14),
(48, 14, '2020-11-02 00:00:00', '1100.00', '100.00', '', 9),
(49, 9, '2020-11-02 00:00:00', '100.00', '10.00', '', 10);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_produtos`
--

CREATE TABLE `tb_produtos` (
  `id` int(11) NOT NULL,
  `descricao` varchar(100) DEFAULT NULL,
  `preco` decimal(10,2) DEFAULT NULL,
  `qtd_estoque` int(11) DEFAULT NULL,
  `for_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tb_produtos`
--

INSERT INTO `tb_produtos` (`id`, `descricao`, `preco`, `qtd_estoque`, `for_id`) VALUES
(7, 'celular', '1100.00', 72, 7),
(8, 'computador de mesa', '3000.00', 59, 1),
(9, 'teclado de computador', '120.00', 65, 5),
(12, 'Celular', '850.00', 85, 3),
(17, 'mouse gamer', '480.00', 71, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_vendas`
--

CREATE TABLE `tb_vendas` (
  `id` int(11) NOT NULL,
  `cliente_id` int(11) DEFAULT NULL,
  `data_venda` datetime DEFAULT NULL,
  `total_venda` decimal(10,2) DEFAULT NULL,
  `observacoes` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tb_vendas`
--

INSERT INTO `tb_vendas` (`id`, `cliente_id`, `data_venda`, `total_venda`, `observacoes`) VALUES
(256, 24, '2020-12-09 00:00:00', '3200.00', 'tentando..'),
(257, 24, '2020-12-11 00:00:00', '100.00', 'tentando...'),
(258, 24, '2020-12-13 00:00:00', '1100.00', 'testando'),
(259, 24, '2022-02-09 00:00:00', '3120.00', ''),
(260, 24, '2022-02-09 00:00:00', '1340.00', ''),
(261, 24, '2022-02-09 00:00:00', '1220.00', ''),
(262, 24, '2022-02-09 00:00:00', '1100.00', ''),
(263, 24, '2022-02-09 00:00:00', '1420.00', 'teste'),
(264, 24, '2022-02-09 00:00:00', '1500.00', 'teste'),
(265, 24, '2022-02-09 00:00:00', '1620.00', ''),
(266, 24, '2022-02-10 00:00:00', '1100.00', 'teste'),
(267, 24, '2022-02-10 00:00:00', '1220.00', 'teste'),
(268, 24, '2022-02-11 00:00:00', '480.00', 'teste'),
(269, 24, '2022-02-11 00:00:00', '120.00', 'testando novamente...'),
(270, 24, '2022-02-11 00:00:00', '1080.00', 'gcdfh'),
(271, 24, '2022-02-11 00:00:00', '1820.00', 'khgyuuk'),
(272, 24, '2022-02-11 00:00:00', '720.00', 'ççkjj'),
(273, 24, '2022-02-11 00:00:00', '720.00', 'kjbkbk'),
(274, 24, '2022-02-11 00:00:00', '3000.00', ''),
(275, 24, '2022-02-13 00:00:00', '6000.00', 'jgghk'),
(276, 24, '2022-02-13 00:00:00', '850.00', 'jçniojpi'),
(277, 24, '2022-02-13 00:00:00', '1100.00', 'pogiytdrsea'),
(278, 24, '2022-02-13 00:00:00', '120.00', 'bGregrdfg'),
(279, 24, '2022-02-13 00:00:00', '5910.00', 'hghdf'),
(280, 24, '2022-02-15 00:00:00', '480.00', ''),
(281, 24, '2022-02-15 00:00:00', '120.00', 'Teste'),
(282, 24, '2022-02-15 00:00:00', '120.00', ''),
(283, 24, '2022-02-16 00:00:00', '480.00', '');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tb_clientes`
--
ALTER TABLE `tb_clientes`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tb_fornecedores`
--
ALTER TABLE `tb_fornecedores`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tb_funcionarios`
--
ALTER TABLE `tb_funcionarios`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tb_itensvendas`
--
ALTER TABLE `tb_itensvendas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `venda_id` (`venda_id`),
  ADD KEY `produto_id` (`produto_id`);

--
-- Índices para tabela `tb_parcelas`
--
ALTER TABLE `tb_parcelas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cliente_id` (`cliente_id`);

--
-- Índices para tabela `tb_produtos`
--
ALTER TABLE `tb_produtos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `for_id` (`for_id`);

--
-- Índices para tabela `tb_vendas`
--
ALTER TABLE `tb_vendas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cliente_id` (`cliente_id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tb_clientes`
--
ALTER TABLE `tb_clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT de tabela `tb_fornecedores`
--
ALTER TABLE `tb_fornecedores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de tabela `tb_funcionarios`
--
ALTER TABLE `tb_funcionarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de tabela `tb_itensvendas`
--
ALTER TABLE `tb_itensvendas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=242;

--
-- AUTO_INCREMENT de tabela `tb_parcelas`
--
ALTER TABLE `tb_parcelas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT de tabela `tb_produtos`
--
ALTER TABLE `tb_produtos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de tabela `tb_vendas`
--
ALTER TABLE `tb_vendas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=284;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `tb_itensvendas`
--
ALTER TABLE `tb_itensvendas`
  ADD CONSTRAINT `tb_itensvendas_ibfk_1` FOREIGN KEY (`venda_id`) REFERENCES `tb_vendas` (`id`),
  ADD CONSTRAINT `tb_itensvendas_ibfk_2` FOREIGN KEY (`produto_id`) REFERENCES `tb_produtos` (`id`);

--
-- Limitadores para a tabela `tb_parcelas`
--
ALTER TABLE `tb_parcelas`
  ADD CONSTRAINT `tb_parcelas_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `tb_clientes` (`id`);

--
-- Limitadores para a tabela `tb_produtos`
--
ALTER TABLE `tb_produtos`
  ADD CONSTRAINT `tb_produtos_ibfk_1` FOREIGN KEY (`for_id`) REFERENCES `tb_fornecedores` (`id`);

--
-- Limitadores para a tabela `tb_vendas`
--
ALTER TABLE `tb_vendas`
  ADD CONSTRAINT `tb_vendas_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `tb_clientes` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
