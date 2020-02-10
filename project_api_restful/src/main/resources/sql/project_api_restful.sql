-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-02-2020 a las 22:27:47
-- Versión del servidor: 10.4.8-MariaDB
-- Versión de PHP: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `project_api_restful`
--
CREATE DATABASE IF NOT EXISTS `project_api_restful` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `project_api_restful`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `item`
--

DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `item_code` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `creator_user` int(11) NOT NULL,
  `state` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `item_prices_reduction`
--

DROP TABLE IF EXISTS `item_prices_reduction`;
CREATE TABLE `item_prices_reduction` (
  `item_id` int(11) NOT NULL,
  `prices_reduction_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `item_state`
--

DROP TABLE IF EXISTS `item_state`;
CREATE TABLE `item_state` (
  `id` int(11) NOT NULL,
  `is_active` tinyint(1) DEFAULT 1,
  `reason` varchar(255) DEFAULT NULL,
  `changed_by` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `item_supplier`
--

DROP TABLE IF EXISTS `item_supplier`;
CREATE TABLE `item_supplier` (
  `id_item` int(11) NOT NULL,
  `id_supplier` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `price_reduction`
--

DROP TABLE IF EXISTS `price_reduction`;
CREATE TABLE `price_reduction` (
  `id` int(11) NOT NULL,
  `end_date` datetime DEFAULT NULL,
  `reduce_price` float DEFAULT NULL,
  `start_date` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `supplier`
--

DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `id` int(11) NOT NULL,
  `country` varchar(75) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `supplier`
--

INSERT INTO `supplier` (`id`, `country`, `name`) VALUES
(1, 'España', 'El Corte Inglés');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `name`, `password`) VALUES
(1, 'admin', 'admin');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKp62bjs3glwnqcrlmlxnmyaekc` (`creator_user`),
  ADD KEY `FKf4617p34njoupugq9587xoau6` (`state`);

--
-- Indices de la tabla `item_prices_reduction`
--
ALTER TABLE `item_prices_reduction`
  ADD UNIQUE KEY `UK_7wnk6n5nkehhdfhovoletnajh` (`prices_reduction_id`),
  ADD KEY `FK60knm82h29o4x1p5et13h173q` (`item_id`);

--
-- Indices de la tabla `item_state`
--
ALTER TABLE `item_state`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKo315hllb0ldvertx8wn05j7co` (`changed_by`);

--
-- Indices de la tabla `item_supplier`
--
ALTER TABLE `item_supplier`
  ADD KEY `FK5awv2fslf5m7le6mmqc2oc3yg` (`id_supplier`),
  ADD KEY `FKnm56e4bn9idhva4hwyn9dtoe4` (`id_item`);

--
-- Indices de la tabla `price_reduction`
--
ALTER TABLE `price_reduction`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `item`
--
ALTER TABLE `item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `item_state`
--
ALTER TABLE `item_state`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
