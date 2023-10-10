-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-09-2023 a las 03:29:44
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `historia_clinica_integral`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datospersonales`
--
-- Error leyendo la estructura de la tabla historia_clinica_integral.datospersonales: #1932 - Table 'historia_clinica_integral.datospersonales' doesn't exist in engine
-- Error leyendo datos de la tabla historia_clinica_integral.datospersonales: #1064 - Algo está equivocado en su sintax cerca 'FROM `historia_clinica_integral`.`datospersonales`' en la linea 1

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre_usuario` varchar(50) NOT NULL,
  `contrasena` varchar(255) NOT NULL,
  `nivel_acceso` enum('lectura','modificacion','administrador') NOT NULL,
  `Nombre` varchar(20) DEFAULT NULL,
  `Apellido` varchar(20) DEFAULT NULL,
  `cedula` varchar(10) DEFAULT NULL,
  `telefono` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre_usuario`, `contrasena`, `nivel_acceso`, `Nombre`, `Apellido`, `cedula`, `telefono`) VALUES
(1, 'usuario1', 'contrasena1', 'lectura', 'Yuranyd', 'Caldera', '31340422', '04126533814'),
(2, 'usuario2', 'contrasena2', 'modificacion', 'Reimond', 'Caldera', '5713593', '04126559653'),
(3, 'admin', 'contrasena3', 'administrador', 'Raimond', 'Caldera', '11455950', '04126854641'),
(4, 'codeonyx', '31340422', 'administrador', 'Raimond', 'Caldera342', '605', '04124595473');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre_usuario` (`nombre_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
