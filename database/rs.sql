-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 24, 2016 at 04:12 PM
-- Server version: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rs`
--

-- --------------------------------------------------------

--
-- Table structure for table `coupon`
--

CREATE TABLE IF NOT EXISTS `coupon` (
  `Cou_id` int(11) NOT NULL,
  `Cou_name` varchar(55) COLLATE utf8_unicode_ci NOT NULL,
  `Cou_discount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `coupon`
--

INSERT INTO `coupon` (`Cou_id`, `Cou_name`, `Cou_discount`) VALUES
(123, 'happyวันโกหก', 10),
(234, 'อยากลดมาก', 15),
(456, 'วันปีใหม่', 10),
(54853, 'วันแม่', 20);

-- --------------------------------------------------------

--
-- Table structure for table `empolyee`
--

CREATE TABLE IF NOT EXISTS `empolyee` (
  `Em_id` int(11) NOT NULL,
  `Em_password` varchar(55) COLLATE utf8_unicode_ci NOT NULL,
  `Em_depart` varchar(55) COLLATE utf8_unicode_ci NOT NULL,
  `Em_name` varchar(55) COLLATE utf8_unicode_ci NOT NULL,
  `Em_addr` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Em_tel` varchar(15) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10000006 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `empolyee`
--

INSERT INTO `empolyee` (`Em_id`, `Em_password`, `Em_depart`, `Em_name`, `Em_addr`, `Em_tel`) VALUES
(10000002, '077247995', 'CEO', 'เอกวรรณ์ กลับสัน', '80/1', '0887602976'),
(10000003, '123', 'ผู้จัดการร้านน', 'มัชฌิมา หมีนหวัง', 'บ้าน', '191'),
(10000004, '111', 'รองผู้จัดการ', 'สาวินี จิตจารักษณ์', 'บ้าน', '1150'),
(10000005, '1234', 'แม่บ้าน', 'ffff', 'บ้าน', '5555555');

-- --------------------------------------------------------

--
-- Table structure for table `food`
--

CREATE TABLE IF NOT EXISTS `food` (
  `Food_name` varchar(55) COLLATE utf8_unicode_ci NOT NULL,
  `Food_price` int(11) NOT NULL,
  `Food_type` varchar(55) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `food`
--

INSERT INTO `food` (`Food_name`, `Food_price`, `Food_type`) VALUES
('ข้าวผัดไก่', 49, 'food'),
('ต้มยำกุ้ง', 120, 'food'),
('ต้มยำกุ้งน้ำข้น', 120, 'food'),
('น้ำส้มปั่น', 20, 'drink'),
('ปลาทอดสามรส', 159, 'food'),
('ปังเย็น', 49, 'sweet'),
('ผัดไทยกุ้งสดมาก', 89, 'food'),
('หูฉลาม', 999, 'food'),
('ฮันนี่โทตส์', 99, 'sweet'),
('เค้กช้อคโกแลต', 59, 'sweet'),
('เครปสตอเบอร์รี่', 79, 'sweet'),
('แตงโมปั่น', 100, 'drink'),
('โกโก้ร้อน', 20, 'drink'),
('โกโก้เย็น', 25, 'drink'),
('ไข่เจียวกุ้ง', 69, 'food');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE IF NOT EXISTS `member` (
  `Mem_id` int(11) NOT NULL,
  `Mem_name` varchar(55) COLLATE utf8_unicode_ci NOT NULL,
  `Mem_addr` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Mem_tel` varchar(15) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10005 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`Mem_id`, `Mem_name`, `Mem_addr`, `Mem_tel`) VALUES
(10000, 'เอกวรรณ์ กลับสัน', '80/1 ม.1 ต.กะทู้ อ.กะทู้ จ.ภูเก็ต 83120', '887602976'),
(10001, 'aekawan ks', '80/1', '191'),
(10002, 'jj mall', 'uuu', '1150'),
(10004, 'มัชฌิมา หมีนหวัง', 'บ้าน', '1150');

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE IF NOT EXISTS `order` (
  `Order_id` int(55) NOT NULL,
  `Food_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Food_price` double NOT NULL,
  `Food_total` int(11) NOT NULL,
  `Food_sumtotal` double NOT NULL,
  `Or_sumtotal` int(11) NOT NULL,
  `Or_totalprice` double NOT NULL,
  `Or_netprice` double NOT NULL,
  `Or_discount` double DEFAULT NULL,
  `Mem_id` int(11) NOT NULL,
  `Cou_id` int(11) DEFAULT NULL,
  `Em_id` int(11) NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`Order_id`, `Food_name`, `Food_price`, `Food_total`, `Food_sumtotal`, `Or_sumtotal`, `Or_totalprice`, `Or_netprice`, `Or_discount`, `Mem_id`, `Cou_id`, `Em_id`, `date`) VALUES
(0, '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2016-04-24 20:38:09'),
(1, 'ข้าวผัดไก่', 49, 1, 49, 15, 2078, 1590, 488, 10000, 123, 10000002, '2016-04-24 20:38:57'),
(1, 'ต้มยำกุ้ง', 120, 2, 240, 15, 2078, 1590, 488, 10000, 123, 10000002, '2016-04-24 20:38:57'),
(1, 'ปลาทอดสามรส', 159, 1, 159, 15, 2078, 1590, 488, 10000, 123, 10000002, '2016-04-24 20:38:59'),
(1, 'ผัดไทยกุ้งสดมาก', 89, 1, 89, 15, 2078, 1590, 488, 10000, 123, 10000002, '2016-04-24 20:38:59'),
(1, 'หูฉลาม', 999, 1, 999, 15, 2078, 1590, 488, 10000, 123, 10000002, '2016-04-24 20:38:59'),
(1, 'ไข่เจียวกุ้ง', 69, 1, 69, 15, 2078, 1590, 488, 10000, 123, 10000002, '2016-04-24 20:38:59'),
(1, 'น้ำส้มปั่น', 20, 1, 20, 15, 2078, 1590, 488, 10000, 123, 10000002, '2016-04-24 20:38:59'),
(1, 'แตงโมปั่น', 100, 3, 300, 15, 2078, 1590, 488, 10000, 123, 10000002, '2016-04-24 20:39:00'),
(1, 'โกโก้ร้อน', 20, 1, 20, 15, 2078, 1590, 488, 10000, 123, 10000002, '2016-04-24 20:39:00'),
(1, 'โกโก้เย็น', 25, 1, 25, 15, 2078, 1590, 488, 10000, 123, 10000002, '2016-04-24 20:39:00'),
(1, 'ปังเย็น', 49, 1, 49, 15, 2078, 1590, 488, 10000, 123, 10000002, '2016-04-24 20:39:00'),
(1, 'เค้กช้อคโกแลต', 59, 1, 59, 15, 2078, 1590, 488, 10000, 123, 10000002, '2016-04-24 20:39:00'),
(2, 'ต้มยำกุ้งน้ำข้น', 120, 1, 120, 6, 1277, 1085, 192, 10000, 0, 10000003, '2016-04-24 20:42:00'),
(2, 'หูฉลาม', 999, 1, 999, 6, 1277, 1085, 192, 10000, 0, 10000003, '2016-04-24 20:42:01'),
(2, 'ไข่เจียวกุ้ง', 69, 1, 69, 6, 1277, 1085, 192, 10000, 0, 10000003, '2016-04-24 20:42:01'),
(2, 'น้ำส้มปั่น', 20, 2, 40, 6, 1277, 1085, 192, 10000, 0, 10000003, '2016-04-24 20:42:01'),
(2, 'ปังเย็น', 49, 1, 49, 6, 1277, 1085, 192, 10000, 0, 10000003, '2016-04-24 20:42:01'),
(3, 'ข้าวผัดไก่', 49, 1, 49, 4, 288, 220, 68, 10000, 123, 10000002, '2016-04-24 20:57:52'),
(3, 'ต้มยำกุ้งน้ำข้น', 120, 2, 240, 4, 288, 220, 68, 10000, 123, 10000002, '2016-04-24 20:57:52'),
(3, 'ฮันนี่โทตส์', 99, 1, 99, 4, 288, 220, 68, 10000, 123, 10000002, '2016-04-24 20:57:52'),
(4, 'ข้าวผัดไก่', 49, 1, 49, 6, 1239, 1239, 0, 10000, 123, 10000002, '2016-04-24 20:58:31'),
(4, 'ต้มยำกุ้งน้ำข้น', 120, 2, 240, 6, 1239, 1239, 0, 10000, 123, 10000002, '2016-04-24 20:58:31'),
(4, 'ฮันนี่โทตส์', 99, 1, 99, 6, 1239, 1239, 0, 10000, 123, 10000002, '2016-04-24 20:58:32'),
(4, 'หูฉลาม', 999, 1, 999, 6, 1239, 1239, 0, 10000, 123, 10000002, '2016-04-24 20:58:32'),
(4, 'โกโก้ร้อน', 20, 1, 20, 6, 1239, 1239, 0, 10000, 123, 10000002, '2016-04-24 20:58:32');

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE IF NOT EXISTS `payments` (
  `Pay_id` int(11) NOT NULL,
  `Order_id` int(11) NOT NULL,
  `Pay_Cash` int(11) NOT NULL,
  `Pay_change` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `payments`
--

INSERT INTO `payments` (`Pay_id`, `Order_id`, `Pay_Cash`, `Pay_change`) VALUES
(55, 1, 1600, 10),
(56, 2, 2000, 915),
(57, 3, 250, 30),
(58, 4, 1300, 61);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `empolyee`
--
ALTER TABLE `empolyee`
  ADD PRIMARY KEY (`Em_id`);

--
-- Indexes for table `food`
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`Food_name`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`Mem_id`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`Pay_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `empolyee`
--
ALTER TABLE `empolyee`
  MODIFY `Em_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10000006;
--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `Mem_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10005;
--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `Pay_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=59;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
