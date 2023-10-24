-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-10-2023 a las 01:31:11
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

CREATE TABLE `datospersonales` (
  `apellido_familiar` varchar(80) DEFAULT NULL,
  `ci_jefe_familia` varchar(80) DEFAULT NULL,
  `Numero_de_Historia` varchar(80) DEFAULT NULL,
  `ci_tipo` varchar(80) DEFAULT NULL,
  `Ci_cedula` varchar(80) DEFAULT NULL,
  `apellido` varchar(80) DEFAULT NULL,
  `nombre` varchar(80) DEFAULT NULL,
  `estadoCivil` varchar(80) DEFAULT NULL,
  `Ocupacion` varchar(80) DEFAULT NULL,
  `estudio` varchar(80) DEFAULT NULL,
  `anosAprobados` varchar(80) DEFAULT NULL,
  `Analfabeta` varchar(80) DEFAULT NULL,
  `sexo` varchar(80) DEFAULT NULL,
  `NDia` varchar(80) DEFAULT NULL,
  `NMes` varchar(80) DEFAULT NULL,
  `NaAno` varchar(80) DEFAULT NULL,
  `LugarNacimiento` varchar(80) DEFAULT NULL,
  `Estado` varchar(80) DEFAULT NULL,
  `Pais` varchar(80) DEFAULT NULL,
  `Direccion` varchar(80) DEFAULT NULL,
  `Telefono` varchar(80) DEFAULT NULL,
  `Religion` varchar(80) DEFAULT NULL,
  `Establecimiento` varchar(80) DEFAULT NULL,
  `Municipio` varchar(80) DEFAULT NULL,
  `Parroquia` varchar(80) DEFAULT NULL,
  `Comunidad` varchar(80) DEFAULT NULL,
  `Madre_N_A` varchar(80) DEFAULT NULL,
  `Madre_Ocupacion` varchar(80) DEFAULT NULL,
  `Padre_N_A` varchar(80) DEFAULT NULL,
  `Padre_Ocupacion` varchar(80) DEFAULT NULL,
  `Representante` varchar(80) DEFAULT NULL,
  `Representante_N` varchar(80) DEFAULT NULL,
  `Representante_tipo_ci` varchar(80) DEFAULT NULL,
  `Representante_ci` varchar(80) DEFAULT NULL,
  `Representante_Telefono` varchar(80) DEFAULT NULL,
  `Carnet_prenatal` varchar(80) DEFAULT NULL,
  `patologiaEmbarazo` varchar(80) DEFAULT NULL,
  `patologiaParto` varchar(80) DEFAULT NULL,
  `patologiaPuerperio` varchar(80) DEFAULT NULL,
  `NConsultasPrenatales` varchar(80) DEFAULT NULL,
  `Hrs_fuera_de_casa` varchar(80) DEFAULT NULL,
  `MadreFamilia` varchar(80) DEFAULT NULL,
  `PadreFamilia` varchar(80) DEFAULT NULL,
  `HermanoFamilia` varchar(80) DEFAULT NULL,
  `OtrosFamilia` varchar(80) DEFAULT NULL,
  `Edad_Gestacional` varchar(80) DEFAULT NULL,
  `sem` varchar(80) DEFAULT NULL,
  `Forceps` varchar(80) DEFAULT NULL,
  `Cesarea` varchar(80) DEFAULT NULL,
  `Parto` varchar(80) DEFAULT NULL,
  `ApgarMin` varchar(80) DEFAULT NULL,
  `Reanimacion` varchar(80) DEFAULT NULL,
  `EgresoRN` varchar(80) DEFAULT NULL,
  `Exclusiva` varchar(80) DEFAULT NULL,
  `Mixta` varchar(80) DEFAULT NULL,
  `Ablactacion` varchar(80) DEFAULT NULL,
  `Peso_al_nacer` varchar(80) DEFAULT NULL,
  `Talla` varchar(80) DEFAULT NULL,
  `Circunferencia` varchar(80) DEFAULT NULL,
  `Asfixia` varchar(80) DEFAULT NULL,
  `PatologiasRN` varchar(80) DEFAULT NULL,
  `Alergia` varchar(80) DEFAULT NULL,
  `Asma` varchar(80) DEFAULT NULL,
  `TBC` varchar(80) DEFAULT NULL,
  `Cardiopatia` varchar(80) DEFAULT NULL,
  `Hipertension` varchar(80) DEFAULT NULL,
  `Varice` varchar(80) DEFAULT NULL,
  `Desnutricion` varchar(80) DEFAULT NULL,
  `Diabetes` varchar(80) DEFAULT NULL,
  `Obesidad` varchar(80) DEFAULT NULL,
  `Gastropatia` varchar(80) DEFAULT NULL,
  `Neurologica` varchar(80) DEFAULT NULL,
  `Enf_Renal` varchar(80) DEFAULT NULL,
  `Cancer` varchar(80) DEFAULT NULL,
  `Alcohol` varchar(80) DEFAULT NULL,
  `Drogas` varchar(80) DEFAULT NULL,
  `Sifilis` varchar(80) DEFAULT NULL,
  `SIDA` varchar(80) DEFAULT NULL,
  `Artritis` varchar(80) DEFAULT NULL,
  `otros_1` varchar(80) DEFAULT NULL,
  `Padre` varchar(80) DEFAULT NULL,
  `Madre` varchar(80) DEFAULT NULL,
  `Hermanos` varchar(80) DEFAULT NULL,
  `Otros_2` varchar(80) DEFAULT NULL,
  `Menarquia` varchar(80) DEFAULT NULL,
  `Ciclo_menstrual` varchar(80) DEFAULT NULL,
  `PRSexual` varchar(80) DEFAULT NULL,
  `FrecuenciaRSexual` varchar(80) DEFAULT NULL,
  `N_Parejas` varchar(80) DEFAULT NULL,
  `Dispareunia` varchar(80) DEFAULT NULL,
  `Anticoncepcion` varchar(80) DEFAULT NULL,
  `AC_DIU` varchar(80) DEFAULT NULL,
  `Menopausia` varchar(80) DEFAULT NULL,
  `Gesta` varchar(80) DEFAULT NULL,
  `Partos` varchar(80) DEFAULT NULL,
  `Cesarea2` varchar(80) DEFAULT NULL,
  `Aborto` varchar(80) DEFAULT NULL,
  `E1erparto` varchar(80) DEFAULT NULL,
  `F_Uparto` varchar(80) DEFAULT NULL,
  `F_UAborto` varchar(80) DEFAULT NULL,
  `Curetaje` varchar(80) DEFAULT NULL,
  `N_de_Hijos` varchar(80) DEFAULT NULL,
  `Vivos` varchar(80) DEFAULT NULL,
  `Muertos` varchar(80) DEFAULT NULL,
  `RN_de_mayor_peso` varchar(80) DEFAULT NULL,
  `Alergia2` varchar(80) DEFAULT NULL,
  `Asma2` varchar(80) DEFAULT NULL,
  `Neumonia` varchar(80) DEFAULT NULL,
  `TBC2` varchar(80) DEFAULT NULL,
  `Cardiopatia2` varchar(80) DEFAULT NULL,
  `Hipertension2` varchar(80) DEFAULT NULL,
  `Hiperlipidemias` varchar(80) DEFAULT NULL,
  `Varices` varchar(80) DEFAULT NULL,
  `Hepatopatia` varchar(80) DEFAULT NULL,
  `Desnutricion2` varchar(80) DEFAULT NULL,
  `Diabetes2` varchar(80) DEFAULT NULL,
  `Obesidad2` varchar(80) DEFAULT NULL,
  `Gastroenteritis` varchar(80) DEFAULT NULL,
  `Encoprexis` varchar(80) DEFAULT NULL,
  `Enf_Renal2` varchar(80) DEFAULT NULL,
  `Enuresis` varchar(80) DEFAULT NULL,
  `Cancer2` varchar(80) DEFAULT NULL,
  `Tromboembolica` varchar(80) DEFAULT NULL,
  `Tumor_Mamario` varchar(80) DEFAULT NULL,
  `Meningitis` varchar(80) DEFAULT NULL,
  `TCraneoencefal` varchar(80) DEFAULT NULL,
  `Enf_Eruptivas` varchar(80) DEFAULT NULL,
  `Dengue` varchar(80) DEFAULT NULL,
  `Hospitalizacion` varchar(80) DEFAULT NULL,
  `Interv_Quirurgica` varchar(80) DEFAULT NULL,
  `Accidentes` varchar(80) DEFAULT NULL,
  `Artritis2` varchar(80) DEFAULT NULL,
  `Enf_TS` varchar(80) DEFAULT NULL,
  `Enf_Infec_Tran` varchar(80) DEFAULT NULL,
  `Enf_Laboral` varchar(80) DEFAULT NULL,
  `Otros_3` varchar(80) DEFAULT NULL,
  `Alcohol2` varchar(80) DEFAULT NULL,
  `Drogas2` varchar(80) DEFAULT NULL,
  `Insecticidas` varchar(80) DEFAULT NULL,
  `Deportes` varchar(80) DEFAULT NULL,
  `Sedentarismo` varchar(80) DEFAULT NULL,
  `Sueno` varchar(80) DEFAULT NULL,
  `ChuparDedo` varchar(80) DEFAULT NULL,
  `Onicofagia` varchar(80) DEFAULT NULL,
  `Micciones` varchar(80) DEFAULT NULL,
  `Evacuaciones` varchar(80) DEFAULT NULL,
  `Estres` varchar(80) DEFAULT NULL,
  `Metales_Pensados` varchar(80) DEFAULT NULL,
  `Alimentacion` varchar(80) DEFAULT NULL,
  `Fuma` varchar(80) DEFAULT NULL,
  `NCigarrillos_diarios` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `datospersonales`
--

INSERT INTO `datospersonales` (`apellido_familiar`, `ci_jefe_familia`, `Numero_de_Historia`, `ci_tipo`, `Ci_cedula`, `apellido`, `nombre`, `estadoCivil`, `Ocupacion`, `estudio`, `anosAprobados`, `Analfabeta`, `sexo`, `NDia`, `NMes`, `NaAno`, `LugarNacimiento`, `Estado`, `Pais`, `Direccion`, `Telefono`, `Religion`, `Establecimiento`, `Municipio`, `Parroquia`, `Comunidad`, `Madre_N_A`, `Madre_Ocupacion`, `Padre_N_A`, `Padre_Ocupacion`, `Representante`, `Representante_N`, `Representante_tipo_ci`, `Representante_ci`, `Representante_Telefono`, `Carnet_prenatal`, `patologiaEmbarazo`, `patologiaParto`, `patologiaPuerperio`, `NConsultasPrenatales`, `Hrs_fuera_de_casa`, `MadreFamilia`, `PadreFamilia`, `HermanoFamilia`, `OtrosFamilia`, `Edad_Gestacional`, `sem`, `Forceps`, `Cesarea`, `Parto`, `ApgarMin`, `Reanimacion`, `EgresoRN`, `Exclusiva`, `Mixta`, `Ablactacion`, `Peso_al_nacer`, `Talla`, `Circunferencia`, `Asfixia`, `PatologiasRN`, `Alergia`, `Asma`, `TBC`, `Cardiopatia`, `Hipertension`, `Varice`, `Desnutricion`, `Diabetes`, `Obesidad`, `Gastropatia`, `Neurologica`, `Enf_Renal`, `Cancer`, `Alcohol`, `Drogas`, `Sifilis`, `SIDA`, `Artritis`, `otros_1`, `Padre`, `Madre`, `Hermanos`, `Otros_2`, `Menarquia`, `Ciclo_menstrual`, `PRSexual`, `FrecuenciaRSexual`, `N_Parejas`, `Dispareunia`, `Anticoncepcion`, `AC_DIU`, `Menopausia`, `Gesta`, `Partos`, `Cesarea2`, `Aborto`, `E1erparto`, `F_Uparto`, `F_UAborto`, `Curetaje`, `N_de_Hijos`, `Vivos`, `Muertos`, `RN_de_mayor_peso`, `Alergia2`, `Asma2`, `Neumonia`, `TBC2`, `Cardiopatia2`, `Hipertension2`, `Hiperlipidemias`, `Varices`, `Hepatopatia`, `Desnutricion2`, `Diabetes2`, `Obesidad2`, `Gastroenteritis`, `Encoprexis`, `Enf_Renal2`, `Enuresis`, `Cancer2`, `Tromboembolica`, `Tumor_Mamario`, `Meningitis`, `TCraneoencefal`, `Enf_Eruptivas`, `Dengue`, `Hospitalizacion`, `Interv_Quirurgica`, `Accidentes`, `Artritis2`, `Enf_TS`, `Enf_Infec_Tran`, `Enf_Laboral`, `Otros_3`, `Alcohol2`, `Drogas2`, `Insecticidas`, `Deportes`, `Sedentarismo`, `Sueno`, `ChuparDedo`, `Onicofagia`, `Micciones`, `Evacuaciones`, `Estres`, `Metales_Pensados`, `Alimentacion`, `Fuma`, `NCigarrillos_diarios`) VALUES
('Caldera', '465464', '8793', 'V', '31340422', 'Caldera', 'Raimond', 'S', '146', 'S', '46', 'Si', 'M', 'DD', 'MM4654', 'AA654', '6546', '5465', '46', '4654', '4654', '64', '61', '61', '616', '6', '16', '16', '16', '16', 'Padre', '61', 'V', '16', '161', 'Si', 'Si', 'Si', 'Si', 'Si', '', 'Si', 'Si', 'Si', '', '', '', 'Si', 'Si', 'Si', '', 'Si', 'Sanos', '', '', '', '', '', '', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', '', '', '', '', '', 'Si', 'Si', 'ACO', 'Si', 'Si', 'Si', 'Si', 'Si', '', '', '', '', '', '', '', '', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', '', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', ''),
('LUISA', '57135963', '7417', 'V', 'JO', 'JOI', 'MARIAN', 'S', 'MOM', 'O', 'MO', 'Si', 'M', 'DDMOM', 'MMOM', 'AAOM', 'OM', 'OM', 'OM', 'OM', 'OM', 'OM', 'OMO', 'MO', 'MO', 'MO', 'MO', 'MO', 'MO', 'O', 'Madre', 'MO', 'V', 'OM', 'OMO', 'Si', 'Si', 'Si', 'Si', 'Si', 'MO', 'Si', 'Si', 'Si', 'OM', '', '', 'Si', 'Si', 'Si', '', 'Si', 'Sanos', '', '', '', '', '', '', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', '', '', '', '', '', 'Si', 'Si', 'ACO', 'Si', 'Si', 'Si', 'Si', 'Si', '', '', '', '', '', '', '', '', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', '', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', '5'),
('487487', '8798748', '6905', 'V', '6', '4848484', '848', 'S', '84', 'P', '484', 'Si', 'F', 'DD944884', 'MM9498498', 'AA94498', '498', '498', '4984', '984', '984', '984', '98498', '498', '49', '49', '4', '', '', '', 'Padre', '', 'V', '', '', 'Si', 'Si', 'Si', 'Si', 'Si', '', 'Si', 'Si', 'Si', '', '', '', 'Si', 'Si', 'Si', '', 'Si', 'Sanos', '', '', '', '', '', '', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', '', '', '', '', '', 'Si', 'Si', 'ACO', 'Si', 'Si', 'Si', 'Si', 'Si', '', '', '', '', '', '', '', '', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', '', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', ''),
('4654', '654', '4772', 'V', '465', '4654', '654', 'S', '654', 'P', '465', 'Si', 'F', 'DD654', 'MM65465', 'AA465', '465', '4654', '654', '6546', '5465', '465', '465', '465', '4654', '65465', '', '', '', '', 'Padre', '', 'V', '', '', 'Si', 'Si', 'Si', 'Si', 'Si', '', 'Si', 'Si', 'Si', '', '', '', 'Si', 'Si', 'Si', '', 'Si', 'Sanos', '', '', '', '', '', '', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', '', '', '', '', '', 'Si', 'Si', 'ACO', 'Si', 'Si', 'Si', 'Si', 'Si', '', '', '', '', '', '', '', '', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', '', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', 'Si', '');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre_usuario`, `contrasena`, `nivel_acceso`, `Nombre`, `Apellido`, `cedula`, `telefono`) VALUES
(1, 'usuario1', 'contrasena1', 'lectura', 'Yuranyd', 'Caldera', '31340422', '04126533814'),
(2, 'usuario2', 'contrasena2', 'modificacion', 'Reimond', 'Caldera', '5713593', '04126559653'),
(3, 'admin', 'contrasena3', 'administrador', 'Raimond', 'Caldera', '11455950', '04126854641'),
(4, 'codeonyx', '31340422', 'administrador', 'Raimon', 'Caldera', '605', '04124595473');

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
