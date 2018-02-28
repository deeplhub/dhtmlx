-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.17 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 dhtmlx 的数据库结构
CREATE DATABASE IF NOT EXISTS `dhtmlx` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dhtmlx`;

-- 导出  表 dhtmlx.chart 结构
CREATE TABLE IF NOT EXISTS `chart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sales` float DEFAULT NULL,
  `year` year(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='图表';

-- 正在导出表  dhtmlx.chart 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `chart` DISABLE KEYS */;
INSERT INTO `chart` (`id`, `sales`, `year`) VALUES
	(1, 10, '2010'),
	(2, 60, '2016'),
	(3, 90, '2015'),
	(4, 30, '2016'),
	(5, 23, '2013'),
	(6, 67, '2014');
/*!40000 ALTER TABLE `chart` ENABLE KEYS */;


-- 导出  表 dhtmlx.gantt_links 结构
CREATE TABLE IF NOT EXISTS `gantt_links` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `source` int(11) NOT NULL,
  `target` int(11) NOT NULL,
  `type` varchar(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 正在导出表  dhtmlx.gantt_links 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `gantt_links` DISABLE KEYS */;
INSERT INTO `gantt_links` (`id`, `source`, `target`, `type`) VALUES
	(1, 1, 2, '1'),
	(2, 2, 3, '1'),
	(3, 3, 4, '0'),
	(4, 4, 5, '0'),
	(5, 5, 6, '0');
/*!40000 ALTER TABLE `gantt_links` ENABLE KEYS */;


-- 导出  表 dhtmlx.gantt_tasks 结构
CREATE TABLE IF NOT EXISTS `gantt_tasks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(255) NOT NULL,
  `start_date` varchar(50) NOT NULL,
  `duration` int(11) NOT NULL,
  `progress` float NOT NULL,
  `sortorder` int(11) NOT NULL COMMENT 'sortorder属性是用来生成任务的index的。',
  `parent` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='要';

-- 正在导出表  dhtmlx.gantt_tasks 的数据：~8 rows (大约)
/*!40000 ALTER TABLE `gantt_tasks` DISABLE KEYS */;
INSERT INTO `gantt_tasks` (`id`, `text`, `start_date`, `duration`, `progress`, `sortorder`, `parent`) VALUES
	(1, 'AAA', '2016-08-20 10:40:20', 0, 0, 0, 0),
	(2, 'BBB', '2016-08-20 10:40:20', 0, 0, 0, 0),
	(3, 'CCC', '2016-08-20 10:40:20', 0, 0, 0, 0),
	(4, 'DDD', '2016-08-20 10:40:20', 0, 0, 0, 0),
	(5, 'EEE', '2016-08-20 10:40:20', 0, 0, 0, 0),
	(6, 'FFF', '2016-08-20 10:40', 3, 0, 0, 0),
	(9, 'ASDF', '2016-08-20 00:00', 2, 0, 0, 6),
	(10, 'GGG', '1900-01-01 00:00', 1, 1, 1, 0);
/*!40000 ALTER TABLE `gantt_tasks` ENABLE KEYS */;


-- 导出  表 dhtmlx.scheduler 结构
CREATE TABLE IF NOT EXISTS `scheduler` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(50) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `warn_text` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='日程';

-- 正在导出表  dhtmlx.scheduler 的数据：~13 rows (大约)
/*!40000 ALTER TABLE `scheduler` DISABLE KEYS */;
INSERT INTO `scheduler` (`id`, `text`, `start_date`, `end_date`, `warn_text`) VALUES
	(1, 'AAA', '2016-08-20 10:04:22', '2016-08-20 10:04:27', '1'),
	(2, 'BBB', '2016-08-22 10:04:23', '2016-08-23 10:04:27', '2'),
	(3, 'CCC', '2016-08-22 10:04:24', '2016-08-23 10:04:27', '3'),
	(4, 'EEE', '2016-08-22 10:55:16', '2016-08-29 10:55:17', '4'),
	(5, '2016-08-30 01:05#2016-08-30 01:10#新建日程', '2016-08-30 01:05:00', '2016-08-30 01:10:00', '5'),
	(6, '新建日程', '2016-09-01 01:50:00', '2016-09-01 01:55:00', '6'),
	(7, '新建日程ADFS', '2016-08-24 01:20:00', '2016-08-24 01:25:00', '7'),
	(8, '新建日程', '2016-08-25 01:45:00', '2016-08-25 01:50:00', '8'),
	(9, '新建日程', '2016-08-26 02:15:00', '2016-09-26 02:20:00', '9'),
	(11, '新建日程', '2016-08-23 01:35:00', '2016-08-23 01:40:00', '10'),
	(12, 'A1新建日程', '2016-08-24 03:15:00', '2016-08-24 03:20:00', '常海洋2'),
	(13, 'ASDFGHJKL', '2016-08-27 03:15:00', '2016-08-27 06:30:00', '13'),
	(18, '新建日程', '2016-08-26 01:40:00', '2016-08-26 01:45:00', ''),
	(19, '新建日程', '2016-08-27 01:45:00', '2016-08-27 01:50:00', ''),
	(20, '新建日程', '2016-08-25 03:45:00', '2016-08-25 03:50:00', ''),
	(21, '新建日程', '2016-08-23 00:30:00', '2016-08-23 00:35:00', NULL);
/*!40000 ALTER TABLE `scheduler` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
