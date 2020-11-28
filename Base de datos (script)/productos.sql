-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Servidor: db5001211410.hosting-data.io
-- Tiempo de generación: 27-11-2020 a las 23:34:22
-- Versión del servidor: 5.7.32-log
-- Versión de PHP: 7.0.33-0+deb9u10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dbs1036078`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `clave` int(11) NOT NULL,
  `nombre_producto` varchar(25) NOT NULL,
  `precio_producto` float(10,2) NOT NULL,
  `descripcion_producto` varchar(50) NOT NULL,
  `cantidad_producto` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`clave`, `nombre_producto`, `precio_producto`, `descripcion_producto`, `cantidad_producto`) VALUES
(0, 'hasd', 123.00, 'asd', 12),
(1, 'samsung', 12.00, 'Hola mundo', 22),
(2, 'Iphone 8', 352.00, 'Gama baja', 12),
(3, 'Alienware', 9999.99, 'Laptop', 13),
(11, 'exe', 235.00, 'da', 67),
(12, 'Chatonte', 123.00, 'hola', 12),
(13, 'Fresas', 124.00, 'ohas', 43),
(1400, 'Holas', 123.00, 'hugo', 12),
(1401, 'asd', 123432.00, 'asd', 59);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`clave`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
