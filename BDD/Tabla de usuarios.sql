
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_usuario` varchar(50) NOT NULL,
  `contrasena` varchar(255) NOT NULL,
  `nivel_acceso` enum('lectura','modificacion','administrador') NOT NULL,
  `Nombre` varchar(20) DEFAULT NULL,
  `Apellido` varchar(20) DEFAULT NULL,
  `cedula` varchar(10) DEFAULT NULL,
  `telefono` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_usuario` (`nombre_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `usuarios` (`id`, `nombre_usuario`, `contrasena`, `nivel_acceso`, `Nombre`, `Apellido`, `cedula`, `telefono`) VALUES
(1, 'admin', 'contrasena3', 'administrador', 'Nombre', 'Apellido', '123', '123');


