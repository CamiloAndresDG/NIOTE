-- phpMyAdmin SQL Dump
-- version 4.6.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 26-05-2017 a las 20:17:44
-- Versión del servidor: 5.7.17-log
-- Versión de PHP: 5.6.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `seg_iotdb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `attribute_type`
--

CREATE TABLE `attribute_type` (
  `attribute_type_id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `attribute_type`
--

INSERT INTO `attribute_type` (`attribute_type_id`, `description`) VALUES
(1, 'Medida Temperatura'),
(2, 'Medida Peso'),
(3, 'Medida Presión');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `node_type`
--

CREATE TABLE `node_type` (
  `node_type_id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `node_type`
--

INSERT INTO `node_type` (`node_type_id`, `description`) VALUES
(0, 'SIP'),
(1, 'IPv6'),
(2, 'bluetooth');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `protocol_type`
--

CREATE TABLE `protocol_type` (
  `protocol_type_id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `protocol_type`
--

INSERT INTO `protocol_type` (`protocol_type_id`, `description`) VALUES
(0, 'MQTT'),
(1, 'UDP'),
(2, 'COaP');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sequence`
--

CREATE TABLE `sequence` (
  `seq_name` varchar(255) NOT NULL,
  `seq_count` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `sequence`
--

INSERT INTO `sequence` (`seq_name`, `seq_count`) VALUES
('SEQ_GEN', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `service`
--

CREATE TABLE `service` (
  `id_catalog` int(11) NOT NULL,
  `date_last_value` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `id_susn` varchar(255) DEFAULT NULL,
  `last_value` varchar(255) DEFAULT NULL,
  `service_state` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `service`
--

INSERT INTO `service` (`id_catalog`, `date_last_value`, `description`, `id_susn`, `last_value`, `service_state`) VALUES
(1, NULL, 'Temperatura Casa', 'temp@casa.com', '', 1),
(2, '2014-11-27 00:00:00', 'Servicio de Estado Trabajo', 'tcp://localhost:1883', '12,5', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `service_attribute`
--

CREATE TABLE `service_attribute` (
  `id_service_attribute` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `attribute_type_id` int(11) DEFAULT NULL,
  `id_catalog` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `service_attribute`
--

INSERT INTO `service_attribute` (`id_service_attribute`, `description`, `value`, `attribute_type_id`, `id_catalog`) VALUES
(1, 'Estado', '12,50', 1, 1),
(2, 'Temperatura', '32,5', 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `service_node`
--

CREATE TABLE `service_node` (
  `id_service_node` int(11) NOT NULL,
  `id_node` varchar(255) DEFAULT NULL,
  `id_swsn` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `service_node_state` int(11) DEFAULT NULL,
  `node_type_id` int(11) DEFAULT NULL,
  `protocol_type_id` int(11) DEFAULT NULL,
  `id_catalog` int(11) DEFAULT NULL,
  `service_type_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `service_node`
--

INSERT INTO `service_node` (`id_service_node`, `id_node`, `id_swsn`, `ip`, `service_node_state`, `node_type_id`, `protocol_type_id`, `id_catalog`, `service_type_id`) VALUES
(1, '1', 'localhost', 'localhost:2020', 1, 0, 1, 1, 1),
(2, '2', 'MQTT/Topico', 'tcp://localhost:1883', 1, 1, 0, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `service_node_attribute`
--

CREATE TABLE `service_node_attribute` (
  `id_service_node_attribute` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `attribute_type_id` int(11) DEFAULT NULL,
  `id_service_node` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `service_node_attribute`
--

INSERT INTO `service_node_attribute` (`id_service_node_attribute`, `description`, `value`, `attribute_type_id`, `id_service_node`) VALUES
(1, 'Atributo 1', '23', 1, 1),
(2, 'Atributo 2', '10', 3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `service_node_value`
--

CREATE TABLE `service_node_value` (
  `id_service_node_value` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `id_service_node` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `service_node_value`
--

INSERT INTO `service_node_value` (`id_service_node_value`, `date`, `value`, `id_service_node`) VALUES
(101, '2014-11-10 14:24:23', '45,35', 2),
(151, '2014-11-10 15:11:31', '23,67', 1),
(152, '2014-11-10 15:12:04', '25,67', 1),
(153, '2014-11-10 15:17:25', '35,25', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `service_type`
--

CREATE TABLE `service_type` (
  `sevice_type_id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `service_type`
--

INSERT INTO `service_type` (`sevice_type_id`, `description`) VALUES
(1, 'Temperatura °C'),
(2, 'Temperatura °F'),
(3, 'Velocidad K/H'),
(4, 'Velocidad m/s');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `attribute_type`
--
ALTER TABLE `attribute_type`
  ADD PRIMARY KEY (`attribute_type_id`);

--
-- Indices de la tabla `node_type`
--
ALTER TABLE `node_type`
  ADD PRIMARY KEY (`node_type_id`);

--
-- Indices de la tabla `protocol_type`
--
ALTER TABLE `protocol_type`
  ADD PRIMARY KEY (`protocol_type_id`);

--
-- Indices de la tabla `sequence`
--
ALTER TABLE `sequence`
  ADD PRIMARY KEY (`seq_name`);

--
-- Indices de la tabla `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`id_catalog`);

--
-- Indices de la tabla `service_attribute`
--
ALTER TABLE `service_attribute`
  ADD PRIMARY KEY (`id_service_attribute`),
  ADD KEY `FK_service_attribute_attribute_type_id` (`attribute_type_id`),
  ADD KEY `FK_service_attribute_id_catalog` (`id_catalog`);

--
-- Indices de la tabla `service_node`
--
ALTER TABLE `service_node`
  ADD PRIMARY KEY (`id_service_node`),
  ADD KEY `FK_service_node_node_type_id` (`node_type_id`),
  ADD KEY `FK_service_node_protocol_type_id` (`protocol_type_id`),
  ADD KEY `FK_service_node_id_catalog` (`id_catalog`),
  ADD KEY `FK_service_node_service_type_id` (`service_type_id`);

--
-- Indices de la tabla `service_node_attribute`
--
ALTER TABLE `service_node_attribute`
  ADD PRIMARY KEY (`id_service_node_attribute`),
  ADD KEY `FK_service_node_attribute_id_service_node` (`id_service_node`),
  ADD KEY `FK_service_node_attribute_attribute_type_id` (`attribute_type_id`);

--
-- Indices de la tabla `service_node_value`
--
ALTER TABLE `service_node_value`
  ADD PRIMARY KEY (`id_service_node_value`),
  ADD KEY `FK_service_node_value_id_service_node` (`id_service_node`);

--
-- Indices de la tabla `service_type`
--
ALTER TABLE `service_type`
  ADD PRIMARY KEY (`sevice_type_id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `service_attribute`
--
ALTER TABLE `service_attribute`
  ADD CONSTRAINT `FK_service_attribute_attribute_type_id` FOREIGN KEY (`attribute_type_id`) REFERENCES `attribute_type` (`attribute_type_id`),
  ADD CONSTRAINT `FK_service_attribute_id_catalog` FOREIGN KEY (`id_catalog`) REFERENCES `service` (`id_catalog`);

--
-- Filtros para la tabla `service_node`
--
ALTER TABLE `service_node`
  ADD CONSTRAINT `FK_service_node_id_catalog` FOREIGN KEY (`id_catalog`) REFERENCES `service` (`id_catalog`),
  ADD CONSTRAINT `FK_service_node_node_type_id` FOREIGN KEY (`node_type_id`) REFERENCES `node_type` (`node_type_id`),
  ADD CONSTRAINT `FK_service_node_protocol_type_id` FOREIGN KEY (`protocol_type_id`) REFERENCES `protocol_type` (`protocol_type_id`),
  ADD CONSTRAINT `FK_service_node_service_type_id` FOREIGN KEY (`service_type_id`) REFERENCES `service_type` (`sevice_type_id`);

--
-- Filtros para la tabla `service_node_attribute`
--
ALTER TABLE `service_node_attribute`
  ADD CONSTRAINT `FK_service_node_attribute_attribute_type_id` FOREIGN KEY (`attribute_type_id`) REFERENCES `attribute_type` (`attribute_type_id`),
  ADD CONSTRAINT `FK_service_node_attribute_id_service_node` FOREIGN KEY (`id_service_node`) REFERENCES `service_node` (`id_service_node`);

--
-- Filtros para la tabla `service_node_value`
--
ALTER TABLE `service_node_value`
  ADD CONSTRAINT `FK_service_node_value_id_service_node` FOREIGN KEY (`id_service_node`) REFERENCES `service_node` (`id_service_node`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
