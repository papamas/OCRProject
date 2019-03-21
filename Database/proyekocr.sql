-- phpMyAdmin SQL Dump
-- version 3.1.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 22, 2019 at 04:56 AM
-- Server version: 5.7.17
-- PHP Version: 5.2.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `proyekocr`
--

-- --------------------------------------------------------

--
-- Table structure for table `app_user`
--

CREATE TABLE IF NOT EXISTS `app_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sso_id` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sso_id` (`sso_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `app_user`
--

INSERT INTO `app_user` (`id`, `sso_id`, `password`, `first_name`, `last_name`, `email`) VALUES
(1, 'nurmuhamadh', '$2a$10$csVyFWNRXZhaGIJ6NgBO3ORnvfZ1SA2IxzgKVXgE6qdtjryPP/8r.', 'Nur Muhamad', 'Holik', 'nurmuhamadh@gmail.com'),
(8, 'dba', '$2a$10$h5B7qSOPCa7/P.xdbnzZouNfdFq59ysevxdCJ/VwA7A1mGi64oKJy', 'DBA User', 'DBA', 'dba@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `app_user_user_profile`
--

CREATE TABLE IF NOT EXISTS `app_user_user_profile` (
  `user_id` bigint(20) NOT NULL,
  `user_profile_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`user_profile_id`),
  KEY `FK_USER_PROFILE` (`user_profile_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `app_user_user_profile`
--

INSERT INTO `app_user_user_profile` (`user_id`, `user_profile_id`) VALUES
(1, 2),
(8, 3);

-- --------------------------------------------------------

--
-- Table structure for table `file_bucket`
--

CREATE TABLE IF NOT EXISTS `file_bucket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `original_file_name` varchar(300) NOT NULL,
  `jenis_doc` varchar(10) DEFAULT NULL,
  `instansi` varchar(500) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `analis_file_name` varchar(300) DEFAULT NULL,
  `analis_created` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `dms_file_name` varchar(300) DEFAULT NULL,
  `dms_created` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `nip` varchar(20) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `kode_instansi` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `file_bucket`
--

INSERT INTO `file_bucket` (`id`, `original_file_name`, `jenis_doc`, `instansi`, `status`, `created_date`, `update_date`, `analis_file_name`, `analis_created`, `dms_file_name`, `dms_created`, `nip`, `user_id`, `kode_instansi`) VALUES
(1, '012529b4-75f4-4770-8fd9-96f98d758910.jpg', 'SK_MUTASI_', 'Pemerintah Provinsi Gorontalo', 1, '2017-08-30 12:42:49', '2017-08-30 12:45:22', 'SK_MUTASI_null_1.pdf', '2017-08-30 12:45:22', NULL, '2017-08-30 12:42:49', NULL, NULL, '27500'),
(2, '0fa75007-9392-484d-8aaf-6e2f884282ec.jpg', 'SK_MUTASI_', 'Pemerintah Provinsi Gorontalo', 1, '2017-08-30 15:23:04', '2017-08-30 15:25:29', 'SK_MUTASI_null_2.pdf', '2017-08-30 15:25:29', NULL, '2017-08-30 15:23:03', NULL, NULL, '27500'),
(3, 'ffb5b14b-9669-4bc7-b0ac-9b1fb83dec97.jpg', 'SK_KP_', 'Pemerintah Kab. Bone Bolango', 2, '2017-08-30 15:24:40', '2017-08-30 15:33:13', 'SK_KP_198408022011012002_3.pdf', '2017-08-30 15:29:58', '1fbb0f63-0e66-4f8e-a79c-ff053e4206cc', '2017-08-30 15:33:13', '198408022011012002', NULL, '27504'),
(4, 'e4977d4d-a568-4abe-b6b7-2e6239fe9429.jpg', 'SK_KP_', 'Pemerintah Kab. Bone Bolango', 2, '2017-08-30 15:24:40', '2017-08-30 15:33:14', 'SK_KP_198010072010012012_4.pdf', '2017-08-30 15:31:00', '20131ce8-24d2-4c99-9011-f01131f91c8b', '2017-08-30 15:33:14', '198010072010012012', NULL, '27504'),
(5, '7be823b9-d0e8-457c-8800-35787b0b3801.jpg', 'SK_KP_', 'Pemerintah Kab. Bone Bolango', 2, '2017-08-30 15:24:41', '2017-08-30 15:33:16', 'SK_KP_196904222009061003_5.pdf', '2017-08-30 15:31:41', '8053ec70-5270-4dd6-991c-f2159cc6eb7c', '2017-08-30 15:33:16', '196904222009061003', NULL, '27504'),
(6, '382e1122-a4d8-43aa-9016-2399be00deea.jpg', NULL, NULL, 0, '2018-02-02 17:53:55', '2018-02-02 17:53:55', NULL, '2018-02-02 17:53:54', NULL, '2018-02-02 17:53:54', NULL, NULL, NULL),
(7, '301fda99-9013-4a0f-9b39-f8cf5f53585f.jpg', NULL, NULL, 0, '2018-02-02 18:02:53', '2018-02-02 18:02:53', NULL, '2018-02-02 18:02:53', NULL, '2018-02-02 18:02:53', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `instansi`
--

CREATE TABLE IF NOT EXISTS `instansi` (
  `kode_instansi` varchar(5) NOT NULL DEFAULT '',
  `nama` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`kode_instansi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `instansi`
--

INSERT INTO `instansi` (`kode_instansi`, `nama`) VALUES
('27100', 'Pemerintah Provinsi Sulawesi Utara'),
('27101', 'Pemerintah Kab. Bolaang Mongondow'),
('27102', 'Pemerintah Kab. Minahasa'),
('27103', 'Pemerintah Kab. Kepulauan Sangihe'),
('27104', 'Pemerintah Kab. Kepulauan Talaud'),
('27105', 'Pemerintah Kab. Minahasa Selatan'),
('27106', 'Pemerintah Kab. Minahasa Utara'),
('27107', 'Pemerintah Kab. Bolaang Mongondow Utara'),
('27108', 'Pemerintah Kab. Siau Tagulandang Biaro'),
('27109', 'Pemerintah Kab. Minahasa Tenggara'),
('27110', 'Pemerintah Kab. Bolaang Mongondow Selatan'),
('27111', 'Pemerintah Kab. Bolaang Mongondow Timur'),
('27171', 'Pemerintah Kota Manado'),
('27172', 'Pemerintah Kota Bitung'),
('27173', 'Pemerintah Kota Tomohon'),
('27174', 'Pemerintah Kota KotaMobagu'),
('27500', 'Pemerintah Provinsi Gorontalo'),
('27501', 'Pemerintah Kab. Boalemo'),
('27502', 'Pemerintah Kab. Gorontalo'),
('27503', 'Pemerintah Kab. Pohuwato'),
('27504', 'Pemerintah Kab. Bone Bolango'),
('27505', 'Pemerintah Kab. Gorontalo Utara'),
('27571', 'Pemerintah Kota Gorontalo'),
('28200', 'Pemerintah Provinsi Maluku Utara'),
('28201', 'Pemerintah Kab. Halmahera Barat'),
('28202', 'Pemerintah Kab. Halmahera Tengah'),
('28203', 'Pemerintah Kab. Kepulauan Sula'),
('28204', 'Pemerintah Kab. Halmahera Selatan'),
('28205', 'Pemerintah Kab. Halmahera Utara'),
('28206', 'Pemerintah Kab. Halmahera Timur'),
('28207', 'Pemerintah Kab. Pulau Morotai'),
('28208', 'Pemerintah Kab. Pulau Taliabu'),
('28271', 'Pemerintah Kota Ternate'),
('28272', 'Pemerintah Kota Tidore Kepulauan');

-- --------------------------------------------------------

--
-- Table structure for table `jenis_sk`
--

CREATE TABLE IF NOT EXISTS `jenis_sk` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `alias` varchar(20) NOT NULL,
  `nama_sk` varchar(200) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `created_by` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `jenis_sk`
--

INSERT INTO `jenis_sk` (`id`, `alias`, `nama_sk`, `created_date`, `update_date`, `user_id`) VALUES
(1, 'SK_CPNS_', 'SK Pengangkatan Sebagai Calon Pegawai Negeri Sipil', '2017-06-01 12:20:46', '2017-06-04 20:14:37', 1),
(2, 'SK_PNS_', 'SK Pengangkatan Sebagai Pegawai Negeri Sipil', '2017-06-01 12:20:46', '2017-06-04 20:14:26', 1),
(3, 'SK_KP_', 'SK Kenaikan Pangkat', '2017-06-01 12:22:00', '2017-06-04 20:14:50', 1),
(4, 'SK_MUTASI_', 'SK Pengalihan Jenis Kepegawaian', '2017-06-01 12:22:00', '2017-06-04 20:15:06', 1);

-- --------------------------------------------------------

--
-- Table structure for table `keyword_instansi`
--

CREATE TABLE IF NOT EXISTS `keyword_instansi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kode_instansi` varchar(5) NOT NULL,
  `nama_keyword` varchar(200) NOT NULL,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `kode_instansi` (`kode_instansi`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=29 ;

--
-- Dumping data for table `keyword_instansi`
--

INSERT INTO `keyword_instansi` (`id`, `kode_instansi`, `nama_keyword`, `created_date`, `update_date`, `user_id`) VALUES
(1, '27100', 'PROVINSI SULAWESI UTARA', '2017-06-01 12:03:24', '2017-06-01 12:03:24', 1),
(2, '27100', 'KEPALA BADAN KEPEGAWAIAN DAERAH PROVINSI SULAWESI UTARA', '2017-06-01 12:03:24', '2017-06-01 12:03:24', 1),
(3, '27100', 'GUBERNUR SULAWESI UTARA', '2017-06-01 12:03:24', '2017-06-01 12:03:24', 1),
(4, '27101', 'BUPATI BOLAANG MONGONDOW', '2017-06-01 12:03:24', '2017-06-01 12:03:24', 1),
(5, '27102', 'BUPATI MINAHASA', '2017-06-01 12:05:45', '2017-06-01 12:05:45', 1),
(6, '27103', 'BUPATI SANGIHE', '2017-06-01 12:05:45', '2017-06-01 12:05:45', 1),
(7, '27104', 'BUPATI KEPULAUAN TALAUD', '2017-06-01 12:05:45', '2017-06-01 12:05:45', 1),
(8, '27105', 'BUPATI MINAHASA SELATAN', '2017-06-01 12:05:45', '2017-06-01 12:05:45', 1),
(9, '27106', 'BUPATI MINAHASA UTARA', '2017-06-01 12:05:45', '2017-06-01 12:05:45', 1),
(10, '27107', 'BUPATI BOLAANG MONGONDOW UTARA', '2017-06-01 12:08:11', '2017-06-01 12:08:11', 1),
(11, '27108', 'BUPATI SITARO', '2017-06-01 12:08:11', '2017-06-01 12:08:27', 1),
(12, '27109', 'BUPATI MINAHASA TENGGARA', '2017-06-01 12:08:11', '2017-06-01 12:08:11', 1),
(13, '27110', 'BUPATI BOLAANG MONGONDOW SELATAN', '2017-06-01 12:08:11', '2017-06-01 12:08:11', 1),
(14, '27111', 'BUPATI BOLAANG MONGONDOW TIMUR\r\n', '2017-06-01 12:08:11', '2017-06-01 12:08:11', 1),
(15, '27171', 'WALIKOTA MANADO', '2017-06-01 12:10:15', '2017-06-01 12:10:15', 1),
(16, '27172', 'WALIKOTA BITUNG', '2017-06-01 12:10:15', '2017-06-01 12:10:15', 1),
(17, '27173', 'WALIKOTA TOMOHON', '2017-06-01 12:10:15', '2017-06-01 12:10:15', 1),
(18, '27174', 'WALIKOTA KOTAMOBAGU', '2017-06-01 12:10:15', '2017-06-01 12:10:15', 1),
(19, '27500', 'GUBERNUR GORONTALO', '2017-06-01 12:14:14', '2017-06-01 12:14:14', 1),
(20, '27501', 'BUPATI BOALEMO', '2017-06-01 12:14:14', '2017-06-01 12:14:14', 1),
(21, '27502', 'BUPATI GORONTALO', '2017-06-01 12:14:14', '2017-06-01 12:14:28', 1),
(22, '27503', 'BUPATI POHUWATO', '2017-06-01 12:14:14', '2017-06-01 12:14:14', 1),
(23, '27504', 'BUPATI BONE BOLANGO', '2017-06-01 12:14:14', '2017-08-30 15:25:25', 1),
(24, '27505', 'BUPATI GORONTALO UTARA', '2017-06-01 12:14:14', '2017-06-01 12:14:14', 1),
(25, '27571', 'WALIKOTA GORONTALO', '2017-06-01 12:14:14', '2017-06-01 12:14:38', 1),
(26, '28200', 'GUBERNUR MALUKU UTARA', '2017-06-01 12:14:14', '2017-06-01 12:14:14', 1),
(27, '28201', 'BUPATI HALMAHERA BARAT', '2017-06-01 12:47:31', '2017-06-01 12:47:31', 1),
(28, '28202', 'BUPATI HALMAHERA TENGAH', '2017-06-01 12:47:31', '2017-06-01 12:47:31', 1);

-- --------------------------------------------------------

--
-- Table structure for table `keyword_jenis_sk`
--

CREATE TABLE IF NOT EXISTS `keyword_jenis_sk` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_jenis_sk` int(11) NOT NULL,
  `nama_keyword` varchar(200) NOT NULL,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_jenis_sk` (`id_jenis_sk`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=25 ;

--
-- Dumping data for table `keyword_jenis_sk`
--

INSERT INTO `keyword_jenis_sk` (`id`, `id_jenis_sk`, `nama_keyword`, `created_date`, `update_date`, `user_id`) VALUES
(1, 1, 'formasi yang lowong', '2017-06-01 11:26:54', '2017-06-01 11:27:13', 1),
(2, 1, 'percobaan\r\n', '2017-06-01 11:26:54', '2017-06-01 11:27:52', 1),
(3, 1, 'mengangkat sebagai calon', '2017-06-01 11:28:48', '2017-06-01 11:28:48', 1),
(4, 1, 'mengangkat sebagai Calon', '2017-06-01 11:28:48', '2017-06-01 11:28:48', 1),
(5, 1, 'sebagai calon', '2017-06-01 11:29:17', '2017-06-01 11:29:17', 1),
(6, 1, 'sebagai Calon', '2017-06-01 11:29:17', '2017-06-01 11:29:17', 1),
(7, 2, 'PENGANGKATAN CALON PEGAWAI NEGERI SIPIL MENJADI', '2017-06-01 11:31:27', '2017-06-01 11:31:27', 1),
(8, 2, 'MENJADI PEGAWAI NEGERI SIPIL', '2017-06-01 11:31:27', '2017-06-01 11:31:27', 1),
(9, 2, 'MENJADI PEGAWAI NEGERI SlPlL', '2017-06-01 11:32:18', '2017-06-01 11:32:18', 1),
(10, 2, 'PENGANGKATAN CALON IEGAWAI NEGERI SlPlL', '2017-06-01 11:32:18', '2017-06-01 11:32:18', 1),
(11, 2, 'MENJADI PEGAWAI NEGERI SlPIL', '2017-06-01 11:33:07', '2017-06-01 11:33:07', 1),
(12, 2, 'diangkat menjadi Pegawai', '2017-06-01 11:33:07', '2017-06-01 11:33:07', 1),
(13, 2, 'STTPL', '2017-06-01 11:34:12', '2017-06-01 11:34:12', 1),
(14, 2, 'TMT Calon PNS', '2017-06-01 11:34:12', '2017-06-01 11:34:12', 1),
(15, 2, 'Surat Keterangan Tim Penguji', '2017-06-01 11:34:12', '2017-06-01 11:34:12', 1),
(16, 3, 'KENAIKAN', '2017-06-01 11:36:46', '2017-06-01 11:36:46', 1),
(17, 3, 'dinaikkan', '2017-06-01 11:36:46', '2017-06-01 11:36:46', 1),
(18, 4, 'dialihkan', '2017-06-01 11:38:16', '2017-06-01 11:38:16', 1),
(19, 4, 'dipindahkan', '2017-06-01 11:38:16', '2017-06-01 11:38:16', 1),
(20, 4, 'dipindahkan antar instansi', '2017-06-01 11:40:03', '2017-06-01 11:40:03', 1),
(21, 4, 'untuk dipindahkan', '2017-06-01 11:40:03', '2017-06-01 11:40:03', 1),
(22, 4, 'Pindah', '2017-06-01 11:40:03', '2017-06-01 11:40:03', 1),
(23, 4, 'Keluar ASN', '2017-06-01 11:40:03', '2017-06-01 11:40:03', 1),
(24, 4, 'PENEMPATAN', '2017-06-01 11:40:03', '2017-06-01 11:40:03', 1);

-- --------------------------------------------------------

--
-- Table structure for table `persistent_logins`
--

CREATE TABLE IF NOT EXISTS `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `persistent_logins`
--


-- --------------------------------------------------------

--
-- Table structure for table `template`
--

CREATE TABLE IF NOT EXISTS `template` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `template_name` varchar(200) NOT NULL,
  `kode_instansi` varchar(5) NOT NULL,
  `file_name` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `template_name` (`template_name`,`kode_instansi`),
  KEY `kode_instansi` (`kode_instansi`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=34 ;

--
-- Dumping data for table `template`
--

INSERT INTO `template` (`id`, `template_name`, `kode_instansi`, `file_name`, `type`, `active`, `create_date`, `user_id`, `update_date`) VALUES
(33, 'SK_PNS', '27107', 'skpns.png', 'image/png', 1, '2017-06-03 14:53:24', 1, '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `template_cordinate`
--

CREATE TABLE IF NOT EXISTS `template_cordinate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `template_id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `height` double NOT NULL,
  `width` double NOT NULL,
  `x1` double NOT NULL,
  `y1` double NOT NULL,
  `x2` double NOT NULL,
  `y2` double NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `template_id` (`template_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=55 ;

--
-- Dumping data for table `template_cordinate`
--

INSERT INTO `template_cordinate` (`id`, `template_id`, `name`, `height`, `width`, `x1`, `y1`, `x2`, `y2`, `created_date`, `update_date`, `user_id`) VALUES
(54, 33, 'Instansi', 57.456, 793.4399999999999, 424.08, 569.0880000000001, 1217.52, 626.5440000000001, '2017-06-03 14:55:52', '2017-06-08 09:02:49', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_profile`
--

CREATE TABLE IF NOT EXISTS `user_profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `user_profile`
--

INSERT INTO `user_profile` (`id`, `type`) VALUES
(2, 'ADMIN'),
(3, 'DBA'),
(1, 'USER');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `jenis_sk`
--
ALTER TABLE `jenis_sk`
  ADD CONSTRAINT `jenis_sk_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`);

--
-- Constraints for table `keyword_instansi`
--
ALTER TABLE `keyword_instansi`
  ADD CONSTRAINT `keyword_instansi_ibfk_1` FOREIGN KEY (`kode_instansi`) REFERENCES `instansi` (`kode_instansi`);

--
-- Constraints for table `keyword_jenis_sk`
--
ALTER TABLE `keyword_jenis_sk`
  ADD CONSTRAINT `keyword_jenis_sk_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`),
  ADD CONSTRAINT `keyword_jenis_sk_ibfk_2` FOREIGN KEY (`id_jenis_sk`) REFERENCES `jenis_sk` (`id`);

--
-- Constraints for table `template`
--
ALTER TABLE `template`
  ADD CONSTRAINT `template_ibfk_1` FOREIGN KEY (`kode_instansi`) REFERENCES `instansi` (`kode_instansi`),
  ADD CONSTRAINT `template_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`);

--
-- Constraints for table `template_cordinate`
--
ALTER TABLE `template_cordinate`
  ADD CONSTRAINT `template_cordinate_ibfk_1` FOREIGN KEY (`template_id`) REFERENCES `template` (`id`);
