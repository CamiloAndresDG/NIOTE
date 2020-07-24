-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 12-09-2019 a las 16:19:13
-- Versión del servidor: 5.7.23-log
-- Versión de PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ingusbbo_piico`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actuador`
--

CREATE TABLE `actuador` (
  `id` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  `tipo` varchar(80) NOT NULL,
  `nodo` varchar(45) NOT NULL,
  `sensor` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `auth`
--

CREATE TABLE `auth` (
  `id` int(11) NOT NULL,
  `user` varchar(80) NOT NULL,
  `pass` varchar(512) NOT NULL,
  `topic` varchar(45) NOT NULL,
  `puerta_de_enlace` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dato`
--

CREATE TABLE `dato` (
  `id` int(11) NOT NULL,
  `valor` varchar(45) NOT NULL,
  `fecha` datetime NOT NULL,
  `ubicacion` longtext NOT NULL,
  `sensor` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `institucion`
--

CREATE TABLE `institucion` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  `area` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensajes`
--

CREATE TABLE `mensajes` (
  `id` varchar(45) NOT NULL,
  `fecha` datetime NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `mensaje` longtext NOT NULL,
  `estado` tinyint(4) NOT NULL,
  `puerta_de_enlace` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nodo`
--

CREATE TABLE `nodo` (
  `id` varchar(45) NOT NULL,
  `descripcion` varchar(80) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  `protocolo_comunicacion` varchar(45) NOT NULL,
  `puerta_de_enlace` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orden`
--

CREATE TABLE `orden` (
  `id` varchar(45) NOT NULL,
  `accion` longtext NOT NULL,
  `tipo` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orden_actuador`
--

CREATE TABLE `orden_actuador` (
  `orden_id` varchar(45) NOT NULL,
  `actuador_id` varchar(45) NOT NULL,
  `fecha` datetime NOT NULL,
  `confirmacion` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyecto`
--

CREATE TABLE `proyecto` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(10) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `tipo` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyecto_institucion`
--

CREATE TABLE `proyecto_institucion` (
  `proyecto` int(11) NOT NULL,
  `institucion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puerta_de_enlace`
--

CREATE TABLE `puerta_de_enlace` (
  `id` varchar(45) NOT NULL,
  `descripcion` varchar(80) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  `direccion_logica` varchar(60) NOT NULL,
  `puerto_de_servicio` varchar(10) NOT NULL,
  `prot_comun_ext` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puerta_enlace_red`
--

CREATE TABLE `puerta_enlace_red` (
  `puerta_de_enlace` varchar(45) NOT NULL,
  `red` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `red`
--

CREATE TABLE `red` (
  `id` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(80) NOT NULL,
  `proyecto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reportes`
--

CREATE TABLE `reportes` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `fecha` datetime NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `data` longtext NOT NULL,
  `usuario` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sensor`
--

CREATE TABLE `sensor` (
  `id` varchar(45) NOT NULL,
  `descripcion` varchar(80) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  `tipo` varchar(80) NOT NULL,
  `magnitud` varchar(50) NOT NULL,
  `frecuencia` int(11) NOT NULL,
  `nodo` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `username` varchar(45) NOT NULL,
  `nombres` varchar(60) NOT NULL,
  `apellidos` varchar(60) NOT NULL,
  `pass` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_proyecto`
--

CREATE TABLE `usuario_proyecto` (
  `usuario_username` varchar(45) NOT NULL,
  `proyecto_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_rol`
--

CREATE TABLE `usuario_rol` (
  `usuario` varchar(45) NOT NULL,
  `rol` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actuador`
--
ALTER TABLE `actuador`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_actuador_nodo_idx` (`nodo`),
  ADD KEY `fk_actuador_sensor_idx` (`sensor`);

--
-- Indices de la tabla `auth`
--
ALTER TABLE `auth`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_auth_puerta_de_enlace_idx` (`puerta_de_enlace`);

--
-- Indices de la tabla `dato`
--
ALTER TABLE `dato`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_dato_sensor_idx` (`sensor`);

--
-- Indices de la tabla `institucion`
--
ALTER TABLE `institucion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `mensajes`
--
ALTER TABLE `mensajes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_mensajes_puerta_de_enlace_idx` (`puerta_de_enlace`);

--
-- Indices de la tabla `nodo`
--
ALTER TABLE `nodo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_nodo_puerta_de_enlace_idx` (`puerta_de_enlace`);

--
-- Indices de la tabla `orden`
--
ALTER TABLE `orden`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `orden_actuador`
--
ALTER TABLE `orden_actuador`
  ADD PRIMARY KEY (`orden_id`,`actuador_id`),
  ADD KEY `fk_orden_actuador_actuador_idx` (`actuador_id`),
  ADD KEY `fk_orden_actuador_orden_idx` (`orden_id`);

--
-- Indices de la tabla `proyecto`
--
ALTER TABLE `proyecto`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `proyecto_institucion`
--
ALTER TABLE `proyecto_institucion`
  ADD PRIMARY KEY (`proyecto`,`institucion`),
  ADD KEY `fk_proyecto_institucion_institucion_idx` (`institucion`),
  ADD KEY `fk_proyecto_institucion_proyecto_idx` (`proyecto`);

--
-- Indices de la tabla `puerta_de_enlace`
--
ALTER TABLE `puerta_de_enlace`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `puerta_enlace_red`
--
ALTER TABLE `puerta_enlace_red`
  ADD PRIMARY KEY (`puerta_de_enlace`,`red`),
  ADD KEY `fk_puerta_enlace_red_red_idx` (`red`),
  ADD KEY `fk_puerta_enlace_red_puerta_de_enlace_idx` (`puerta_de_enlace`);

--
-- Indices de la tabla `red`
--
ALTER TABLE `red`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_red_proyecto_idx` (`proyecto`);

--
-- Indices de la tabla `reportes`
--
ALTER TABLE `reportes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_reportes_usuario_idx` (`usuario`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`nombre`);

--
-- Indices de la tabla `sensor`
--
ALTER TABLE `sensor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Sensor_nodo_idx` (`nodo`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`username`);

--
-- Indices de la tabla `usuario_proyecto`
--
ALTER TABLE `usuario_proyecto`
  ADD PRIMARY KEY (`usuario_username`,`proyecto_id`),
  ADD KEY `fk_usuario_has_proyecto_proyecto_idx` (`proyecto_id`),
  ADD KEY `fk_usuario_has_proyecto_usuario_idx` (`usuario_username`);

--
-- Indices de la tabla `usuario_rol`
--
ALTER TABLE `usuario_rol`
  ADD PRIMARY KEY (`usuario`,`rol`),
  ADD KEY `fk_usuario_roles_rol_idx` (`rol`),
  ADD KEY `fk_usuario_roles_usuario_idx` (`usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `auth`
--
ALTER TABLE `auth`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `dato`
--
ALTER TABLE `dato`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `reportes`
--
ALTER TABLE `reportes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `actuador`
--
ALTER TABLE `actuador`
  ADD CONSTRAINT `fk_actuador_nodo` FOREIGN KEY (`nodo`) REFERENCES `nodo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_actuador_sensor` FOREIGN KEY (`sensor`) REFERENCES `sensor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `auth`
--
ALTER TABLE `auth`
  ADD CONSTRAINT `fk_auth_puerta_de_enlace` FOREIGN KEY (`puerta_de_enlace`) REFERENCES `puerta_de_enlace` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `dato`
--
ALTER TABLE `dato`
  ADD CONSTRAINT `fk_dato_sensor` FOREIGN KEY (`sensor`) REFERENCES `sensor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `mensajes`
--
ALTER TABLE `mensajes`
  ADD CONSTRAINT `fk_mensajes_puerta_de_enlace` FOREIGN KEY (`puerta_de_enlace`) REFERENCES `puerta_de_enlace` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `nodo`
--
ALTER TABLE `nodo`
  ADD CONSTRAINT `fk_nodo_puerta_de_enlace` FOREIGN KEY (`puerta_de_enlace`) REFERENCES `puerta_de_enlace` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `orden_actuador`
--
ALTER TABLE `orden_actuador`
  ADD CONSTRAINT `fk_orden_has_actuador_actuador` FOREIGN KEY (`actuador_id`) REFERENCES `actuador` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_orden_has_actuador_orden` FOREIGN KEY (`orden_id`) REFERENCES `orden` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `proyecto_institucion`
--
ALTER TABLE `proyecto_institucion`
  ADD CONSTRAINT `fk_proyecto_has_institucion_institucion1` FOREIGN KEY (`institucion`) REFERENCES `institucion` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_proyecto_has_institucion_proyecto1` FOREIGN KEY (`proyecto`) REFERENCES `proyecto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `puerta_enlace_red`
--
ALTER TABLE `puerta_enlace_red`
  ADD CONSTRAINT `fk_puerta_enlace_red_puerta_de_enlace` FOREIGN KEY (`puerta_de_enlace`) REFERENCES `puerta_de_enlace` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_puerta_enlace_red_red` FOREIGN KEY (`red`) REFERENCES `red` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `red`
--
ALTER TABLE `red`
  ADD CONSTRAINT `fk_red_proyecto` FOREIGN KEY (`proyecto`) REFERENCES `proyecto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `reportes`
--
ALTER TABLE `reportes`
  ADD CONSTRAINT `fk_reportes_usuario` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `sensor`
--
ALTER TABLE `sensor`
  ADD CONSTRAINT `fk_Sensor_nodo` FOREIGN KEY (`nodo`) REFERENCES `nodo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario_proyecto`
--
ALTER TABLE `usuario_proyecto`
  ADD CONSTRAINT `fk_usuario_has_proyecto_proyecto` FOREIGN KEY (`proyecto_id`) REFERENCES `proyecto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_usuario_has_proyecto_usuario` FOREIGN KEY (`usuario_username`) REFERENCES `usuario` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario_rol`
--
ALTER TABLE `usuario_rol`
  ADD CONSTRAINT `fk_usuario_roles_rol` FOREIGN KEY (`rol`) REFERENCES `rol` (`nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_usuario_roles_usuario` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
