-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 22, 2022 at 01:48 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fast_food_store`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `Account_ID` char(8) NOT NULL,
  `UserName` char(30) NOT NULL,
  `Password` char(20) NOT NULL,
  `UserType` char(50) NOT NULL,
  `Staff_ID` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`Account_ID`, `UserName`, `Password`, `UserType`, `Staff_ID`) VALUES
('1', '1', '1', '1', 'AA01'),
('AC01', 'nhamgiaphat', '123456', 'Admin', 'AA02'),
('AC02', 'staff1', 'pass1', 'staff', 'AA03');

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `Bill_ID` char(11) NOT NULL,
  `Date` datetime NOT NULL,
  `TotalValue` double NOT NULL,
  `ReceivedMoney` double NOT NULL,
  `ExcessMoney` double NOT NULL,
  `Staff_id` char(8) NOT NULL,
  `Customer_id` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`Bill_ID`, `Date`, `TotalValue`, `ReceivedMoney`, `ExcessMoney`, `Staff_id`, `Customer_id`) VALUES
('B1', '2022-11-01 13:38:59', 130000, 200000, 40000, 'AA01', 'C0'),
('B10', '2022-11-18 14:02:16', 120000, 1111111, -991111, 'AA01', 'C0'),
('B11', '2022-11-18 14:02:16', 120000, 1111111, -991111, 'AA01', 'C0'),
('B12', '2022-11-18 14:02:16', 120000, 1111111, -991111, 'AA01', 'C0'),
('B13', '2022-11-18 14:02:35', 120000, 1, 119999, 'AA01', 'C0'),
('B14', '2022-11-18 14:02:36', 120000, 1, 119999, 'AA01', 'C0'),
('B15', '2022-11-18 14:02:36', 120000, 1, 119999, 'AA01', 'C0'),
('B16', '2022-11-18 14:02:36', 120000, 1, 119999, 'AA01', 'C0'),
('B17', '2022-11-18 14:02:36', 120000, 1, 119999, 'AA01', 'C0'),
('B18', '2022-11-18 14:02:37', 120000, 1, 119999, 'AA01', 'C0'),
('B19', '2022-11-18 14:05:26', 120000, 1111111, -991111, 'AA01', 'C0'),
('B2', '2022-11-07 00:00:00', 5000000, 5000000, 0, 'AA03', 'C3'),
('B20', '2022-11-18 14:05:27', 120000, 1111111, -991111, 'AA01', 'C0'),
('B21', '2022-11-18 14:05:28', 120000, 1111111, -991111, 'AA01', 'C0'),
('B22', '2022-11-18 14:05:28', 120000, 1111111, -991111, 'AA01', 'C0'),
('B23', '2022-11-19 18:11:59', 30000, 300000, -270000, 'AA01', 'C0'),
('B24', '2022-11-19 18:15:35', 30000, 20000, 10000, 'AA01', 'C0'),
('B25', '2022-11-19 18:15:37', 30000, 20000, 10000, 'AA01', 'C0'),
('B26', '2022-11-19 18:17:25', 30000, 100000, -70000, 'AA01', 'C0'),
('B27', '2022-11-19 18:17:26', 30000, 100000, -70000, 'AA01', 'C0'),
('B28', '2022-11-19 18:19:35', 30000, 100000, -70000, 'AA01', 'C1'),
('B29', '2022-11-20 13:14:45', 130000, 100000, 30000, 'AA01', 'C1'),
('B3', '2022-11-07 19:12:01', 1370000, 0, 0, 'AA03', 'C3'),
('B30', '2022-11-20 13:18:32', 90000, 10000000, -9910000, 'AA01', 'C1'),
('B31', '2022-11-20 13:20:36', 50000, 30000, 20000, 'AA01', 'C1'),
('B32', '2022-11-20 13:40:57', 90000, 1999999, -1909999, 'AA01', 'C4'),
('B33', '2022-11-20 13:43:20', 50000, 1000000, -950000, 'AA01', 'C1'),
('B34', '2022-11-20 14:30:31', 220000, 1000000, -780000, 'AA01', 'C3'),
('B35', '2022-11-20 14:32:08', 340000, 10000, 330000, 'AA01', 'C0'),
('B36', '2022-11-20 14:32:23', 340000, 10000, 330000, 'AA01', 'C3'),
('B37', '2022-11-20 14:34:55', 140000, 100, 139900, 'AA01', 'C2'),
('B38', '2022-11-20 15:02:59', 130000, 10000, 120000, 'AA01', 'C1'),
('B39', '2022-11-20 15:04:20', 90000, 110000, -20000, 'AA01', 'C1'),
('B4', '2022-11-07 19:21:58', 280000, 270000, 10000, 'AA03', 'C4'),
('B40', '2022-11-20 15:05:00', 90000, 110000, -20000, 'AA01', 'C1'),
('B41', '2022-11-20 15:13:49', 130000, 1, 129999, 'AA01', 'C1'),
('B42', '2022-11-20 15:36:09', 140000, 10000, 130000, 'AA01', 'C0'),
('B43', '2022-11-20 15:36:13', 140000, 10000, 130000, 'AA01', 'C0'),
('B44', '2022-11-20 15:37:18', 130000, 10, 129990, 'AA01', 'C0'),
('B45', '2022-11-20 15:37:20', 130000, 10, 129990, 'AA01', 'C0'),
('B46', '2022-11-20 15:37:21', 130000, 10, 129990, 'AA01', 'C0'),
('B47', '2022-11-20 15:37:22', 130000, 10, 129990, 'AA01', 'C0'),
('B48', '2022-11-20 15:37:22', 130000, 10, 129990, 'AA01', 'C0'),
('B49', '2022-11-20 15:37:25', 130000, 10, 129990, 'AA01', 'C1'),
('B5', '2022-11-07 19:39:12', 690000, 690000, 0, 'AA03', 'C4'),
('B50', '2022-11-20 15:37:26', 130000, 10, 129990, 'AA01', 'C1'),
('B51', '2022-11-20 15:37:27', 130000, 10, 129990, 'AA01', 'C1'),
('B52', '2022-11-20 15:41:55', 90000, 1, 89999, 'AA01', 'C1'),
('B53', '2022-11-20 15:41:56', 90000, 1, 89999, 'AA01', 'C1'),
('B54', '2022-11-20 15:41:57', 90000, 1, 89999, 'AA01', 'C1'),
('B55', '2022-11-20 15:41:58', 90000, 1, 89999, 'AA01', 'C1'),
('B56', '2022-11-20 15:44:16', 90000, 1, 89999, 'AA01', 'C0'),
('B57', '2022-11-20 15:44:17', 90000, 1, 89999, 'AA01', 'C0'),
('B58', '2022-11-20 15:44:25', 90000, 1, 89999, 'AA01', 'C2'),
('B59', '2022-11-20 15:45:55', 90000, 1, 89999, 'AA01', 'C4'),
('B6', '2022-11-18 14:01:11', 120000, 111111, 8889, 'AA01', 'C0'),
('B60', '2022-11-20 16:01:54', 90000, 1, 89999, 'AA01', 'C1'),
('B61', '2022-11-20 16:05:52', 130000, 1, 129999, 'AA01', 'C4'),
('B62', '2022-11-20 16:07:30', 90000, 1, 89999, 'AA01', 'C3'),
('B63', '2022-11-20 16:08:48', 90000, 1, 89999, 'AA01', 'C2'),
('B64', '2022-11-20 16:10:45', 90000, 1, 89999, 'AA01', 'C3'),
('B65', '2022-11-20 16:12:04', 130000, 1, 129999, 'AA01', 'C4'),
('B66', '2022-11-20 16:17:15', 90000, 1, 89999, 'AA01', 'C3'),
('B67', '2022-11-20 16:24:51', 140000, 1, 139999, 'AA01', 'C1'),
('B68', '2022-11-20 16:28:35', 270000, 1, 269999, 'AA01', 'C0'),
('B69', '2022-11-20 16:28:37', 270000, 1, 269999, 'AA01', 'C0'),
('B7', '2022-11-18 14:01:12', 120000, 111111, 8889, 'AA01', 'C0'),
('B70', '2022-11-20 16:28:38', 270000, 1, 269999, 'AA01', 'C0'),
('B71', '2022-11-20 16:28:42', 270000, 1, 269999, 'AA01', 'C3'),
('B72', '2022-11-20 19:11:50', 140000, 11, 139989, 'AA01', 'C2'),
('B73', '2022-11-20 19:22:38', 410000, 1111, 408889, 'AA01', 'C0'),
('B74', '2022-11-20 19:22:39', 410000, 1111, 408889, 'AA01', 'C0'),
('B75', '2022-11-20 19:22:43', 410000, 1111, 408889, 'AA01', 'C4'),
('B76', '2022-11-20 19:27:26', 220000, 1, 219999, 'AA01', 'C0'),
('B77', '2022-11-20 19:38:31', 510000, 1111, 508889, 'AA01', 'C0'),
('B78', '2022-11-20 19:41:00', 330000, 1, 329999, 'AA01', 'C0'),
('B79', '2022-11-20 19:43:02', 390000, 11, 389989, 'AA01', 'C0'),
('B8', '2022-11-18 14:01:13', 120000, 111111, 8889, 'AA01', 'C0'),
('B80', '2022-11-20 19:44:03', 50000, 1, 49999, 'AA01', 'C0'),
('B81', '2022-11-20 19:45:15', 130000, 1, 129999, 'AA01', 'C0'),
('B82', '2022-11-20 19:47:44', 50000, 1, 49999, 'AA01', 'C0'),
('B83', '2022-11-20 19:50:11', 290000, 1, 289999, 'AA01', 'C0'),
('B84', '2022-11-20 19:51:26', 90000, 1, 89999, 'AA01', 'C0'),
('B85', '2022-11-20 19:51:53', 420000, 1, 419999, 'AA01', 'C2'),
('B86', '2022-11-20 19:54:50', 50000, 1, 49999, 'AA01', 'C0'),
('B87', '2022-11-20 19:56:25', 340000, 1, 339999, 'AA01', 'C0'),
('B88', '2022-11-20 20:06:05', 90000, 1, 89999, 'AA01', 'C0'),
('B89', '2022-11-20 20:08:54', 40000, 1, 39999, 'AA01', 'C0'),
('B9', '2022-11-18 14:02:15', 120000, 1111111, -991111, 'AA01', 'C0'),
('B90', '2022-11-22 19:29:23', 218200, 1000000, -781800, 'AA01', 'C0'),
('B91', '2022-11-22 19:29:28', 218200, 1000000, -781800, 'AA01', 'C0'),
('B92', '2022-11-22 19:29:29', 218200, 1000000, -781800, 'AA01', 'C0'),
('B93', '2022-11-22 19:29:30', 218200, 1000000, -781800, 'AA01', 'C0'),
('B94', '2022-11-22 19:45:01', 512000, 1000000, -488000, 'AA01', 'C0'),
('B95', '2022-11-22 19:47:59', 96000, 100000, -4000, 'AA01', 'C0');

-- --------------------------------------------------------

--
-- Table structure for table `bill_detail`
--

CREATE TABLE `bill_detail` (
  `Bill_id` char(8) NOT NULL,
  `Product_id` char(8) NOT NULL,
  `Size` char(8) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `TotalValue` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bill_detail`
--

INSERT INTO `bill_detail` (`Bill_id`, `Product_id`, `Size`, `Quantity`, `TotalValue`) VALUES
('B1', 'P01', '3.5 oz', 50, 160000),
('B2', 'P01', '4 oz', 50, 2000000),
('B2', 'P01', '5oz', 50, 3000000),
('B28', 'P01', '3.5 oz', 1, 30000),
('B29', 'P02', '1 con', 1, 130000),
('B3', 'P01', '3.5 oz', 1, 30000),
('B3', 'P01', '4 oz', 5, 200000),
('B3', 'P01', '5oz', 19, 1140000),
('B30', 'P04', 'Nhỏ', 1, 90000),
('B31', 'P03', 'Lớn', 1, 50000),
('B32', 'P04', 'Nhỏ', 1, 90000),
('B33', 'P03', 'Lớn', 1, 50000),
('B34', 'P02', '1 con', 1, 130000),
('B34', 'P04', 'Nhỏ', 1, 90000),
('B36', 'P01', '4 oz', 5, 200000),
('B36', 'P03', 'Lớn', 1, 50000),
('B36', 'P04', 'Nhỏ', 1, 90000),
('B37', 'P03', 'Lớn', 1, 50000),
('B37', 'P04', 'Nhỏ', 1, 90000),
('B38', 'P02', '1 con', 1, 130000),
('B39', 'P04', 'Nhỏ', 1, 90000),
('B4', 'P03', 'Lớn', 2, 100000),
('B4', 'P04', 'Nhỏ', 2, 180000),
('B40', 'P04', 'Nhỏ', 1, 90000),
('B41', 'P02', '1 con', 1, 130000),
('B49', 'P02', '1 con', 1, 130000),
('B5', 'P02', '1 con', 2, 260000),
('B5', 'P02', '1/2 con', 1, 70000),
('B5', 'P04', 'Nhỏ', 4, 360000),
('B50', 'P02', '1 con', 1, 130000),
('B51', 'P02', '1 con', 1, 130000),
('B52', 'P04', 'Nhỏ', 1, 90000),
('B53', 'P04', 'Nhỏ', 1, 90000),
('B54', 'P04', 'Nhỏ', 1, 90000),
('B55', 'P04', 'Nhỏ', 1, 90000),
('B58', 'P04', 'Nhỏ', 1, 90000),
('B59', 'P04', 'Nhỏ', 1, 90000),
('B60', 'P04', 'Nhỏ', 1, 90000),
('B61', 'P02', '1 con', 1, 130000),
('B62', 'P04', 'Nhỏ', 1, 90000),
('B63', 'P04', 'Nhỏ', 1, 90000),
('B64', 'P04', 'Nhỏ', 1, 90000),
('B65', 'P02', '1 con', 1, 130000),
('B66', 'P04', 'Nhỏ', 1, 90000),
('B67', 'P03', 'Lớn', 1, 50000),
('B67', 'P04', 'Nhỏ', 1, 90000),
('B71', 'P02', '1 con', 1, 130000),
('B71', 'P03', 'Lớn', 1, 50000),
('B71', 'P04', 'Nhỏ', 1, 90000),
('B72', 'P03', 'Lớn', 1, 50000),
('B72', 'P04', 'Nhỏ', 1, 90000),
('B75', 'P03', 'Lớn', 1, 50000),
('B75', 'P04', 'Nhỏ', 4, 360000),
('B76', 'P02', '1 con', 1, 130000),
('B76', 'P04', 'Nhỏ', 1, 90000),
('B77', 'P01', '4 oz', 1, 40000),
('B77', 'P03', 'Lớn', 4, 200000),
('B77', 'P04', 'Nhỏ', 3, 270000),
('B78', 'P01', '4 oz', 1, 40000),
('B78', 'P03', 'Lớn', 4, 200000),
('B78', 'P04', 'Nhỏ', 1, 90000),
('B79', 'P03', 'Vừa', 3, 120000),
('B79', 'P04', 'Nhỏ', 3, 270000),
('B80', 'P03', 'Lớn', 1, 50000),
('B81', 'P02', '1 con', 1, 130000),
('B82', 'P03', 'Lớn', 1, 50000),
('B83', 'P03', 'Lớn', 4, 200000),
('B83', 'P04', 'Nhỏ', 1, 90000),
('B84', 'P04', 'Nhỏ', 1, 90000),
('B85', 'P03', 'Lớn', 3, 150000),
('B85', 'P04', 'Nhỏ', 3, 270000),
('B86', 'P03', 'Lớn', 1, 50000),
('B87', 'P02', '1 con', 1, 130000),
('B87', 'P02', '1/2 con', 1, 70000),
('B87', 'P03', 'Lớn', 1, 50000),
('B87', 'P04', 'Nhỏ', 1, 90000),
('B88', 'P04', 'Nhỏ', 1, 90000),
('B89', 'P01', '4 oz', 1, 40000),
('B94', 'P01', '4 oz', 4, 96000),
('B94', 'P02', '1 con', 4, 416000),
('B95', 'P01', '4 oz', 4, 96000);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `Category_ID` char(8) NOT NULL,
  `Category_Name` char(40) NOT NULL,
  `Business_Status` char(8) NOT NULL,
  `IsDeleted` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`Category_ID`, `Category_Name`, `Business_Status`, `IsDeleted`) VALUES
('01', 'Hamburger', 'On', 1),
('02', 'Cơm', 'On', 0),
('03', 'Thịt heo', 'On', 0),
('04', 'Thịt bò', 'On', 0),
('05', 'Thịt gà', 'On', 0),
('CT5', 'Pizza', 'On', 0),
('CT6', 'Bánh Mì', 'On', 0);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Customer_id` char(8) NOT NULL,
  `Customer_name` char(40) DEFAULT NULL,
  `YearOfBirth` year(4) DEFAULT NULL,
  `phoneNum` char(10) DEFAULT NULL,
  `Purchase_Time` int(11) DEFAULT NULL,
  `IsDeleted` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Customer_id`, `Customer_name`, `YearOfBirth`, `phoneNum`, `Purchase_Time`, `IsDeleted`) VALUES
('C0', NULL, NULL, NULL, 0, 0),
('C1', 'Nguyễn', 2001, '0331231234', 12, 0),
('C2', 'Ngọc', 2005, '0334567890', 8, 0),
('C3', 'Việt Thái', 2002, '0339518566', 7, 0),
('C4', 'test', 1997, '0389283914', 6, 0);

-- --------------------------------------------------------

--
-- Table structure for table `discount`
--

CREATE TABLE `discount` (
  `discount_Id` char(8) NOT NULL,
  `discount_Percent` int(3) NOT NULL,
  `start_Time` varchar(255) NOT NULL,
  `end_Time` varchar(255) NOT NULL,
  `status` int(1) NOT NULL,
  `isDeleted` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `discount`
--

INSERT INTO `discount` (`discount_Id`, `discount_Percent`, `start_Time`, `end_Time`, `status`, `isDeleted`) VALUES
('KM0', 20, '01-11-2022', '03-12-2022', 1, 0),
('KM1', 2, '01-11-2022', '01-12-2022', 1, 0),
('KM2', 4, '11-11-2022', '11-11-2022', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `discount_detail`
--

CREATE TABLE `discount_detail` (
  `discount_Id` char(8) NOT NULL,
  `product_Id` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `discount_detail`
--

INSERT INTO `discount_detail` (`discount_Id`, `product_Id`) VALUES
('KM0', 'P01'),
('KM0', 'P02'),
('KM1', 'P03'),
('KM1', 'P04');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `Product_ID` char(8) NOT NULL,
  `Size` char(8) NOT NULL,
  `Product_Name` char(40) NOT NULL,
  `UnitPrice` double NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Image` varchar(100) NOT NULL,
  `Category_ID` char(8) NOT NULL,
  `IsDeleted` tinyint(1) NOT NULL,
  `BusinessStatus` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`Product_ID`, `Size`, `Product_Name`, `UnitPrice`, `Quantity`, `Image`, `Category_ID`, `IsDeleted`, `BusinessStatus`) VALUES
('P01', '3.5 oz', 'Hamburger gà sốt BBQ', 30000, 1, 'src\\Img\\burger_bbqChicken.jpg', '01', 0, 1),
('P01', '4 oz', 'Hamburger gà sốt BBQ', 40000, 176, 'src\\Img\\burger_bbqChicken.jpg', '01', 0, 1),
('P01', '5oz', 'Hamburger gà sốt BBQ', 60000, 1, 'src\\Img\\HBG.jpg', '01', 0, 1),
('P02', '1 con', 'Gà nướng muối ớt', 130000, 28, 'src\\Img\\chicken_chilliSalt.jpg', '05', 0, 1),
('P02', '1/2 con', 'Gà nướng muối ớt', 70000, 48, 'src\\Img\\chicken_chilliSalt.jpg', '05', 0, 1),
('P03', 'Lớn', 'Cơm xèo gà mắm tỏi', 50000, 19, 'src\\Img\\comXeo_garlicChicken.jpeg', '02', 0, 1),
('P03', 'Vừa', 'Cơm xèo gà mắm tỏi', 40000, 27, 'src\\Img\\comXeo_garlicChicken.jpeg', '02', 0, 1),
('P04', 'Nhỏ', 'Bít tết đặc biệt', 90000, 97, 'src\\Img\\beef_beefsteak.jpg', '04', 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `received_note`
--

CREATE TABLE `received_note` (
  `Received_Note_ID` char(8) NOT NULL,
  `Date` datetime NOT NULL DEFAULT current_timestamp(),
  `Total_Value` double NOT NULL,
  `Tax_Value` double NOT NULL,
  `Final_Value` double NOT NULL,
  `Supplier` char(40) NOT NULL,
  `Staff_ID` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `received_note`
--

INSERT INTO `received_note` (`Received_Note_ID`, `Date`, `Total_Value`, `Tax_Value`, `Final_Value`, `Supplier`, `Staff_ID`) VALUES
('RN1', '2022-11-01 15:48:46', 150000, 15000, 165000, 'Công ty Productiness', 'AA01');

-- --------------------------------------------------------

--
-- Table structure for table `received_note_detail`
--

CREATE TABLE `received_note_detail` (
  `Received_Note_ID` char(8) NOT NULL,
  `Product_ID` char(8) NOT NULL,
  `Size` char(8) NOT NULL,
  `UnitPrice` double NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `received_note_detail`
--

INSERT INTO `received_note_detail` (`Received_Note_ID`, `Product_ID`, `Size`, `UnitPrice`, `Quantity`, `Price`) VALUES
('RN1', 'P02', '1 con', 120000, 1, 120000),
('RN1', 'P03', 'Lớn', 30000, 1, 30000);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `Staff_id` char(12) NOT NULL,
  `Full_Name` char(40) NOT NULL,
  `Year_Of_Birth` year(4) NOT NULL,
  `Gender` char(8) NOT NULL,
  `HomeTown` char(30) NOT NULL,
  `Phone_Num` char(11) NOT NULL,
  `Salary` int(11) NOT NULL,
  `IsDeleted` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`Staff_id`, `Full_Name`, `Year_Of_Birth`, `Gender`, `HomeTown`, `Phone_Num`, `Salary`, `IsDeleted`) VALUES
('AA01', 'Nguyễn Ngọc Trường Chinh', 2001, 'Nam', 'TP.HCM', '0862863753', 30000000, 0),
('AA02', 'Nhâm Gia Phát', 2002, 'Nam', 'TP. Hồ Chí Minh', '0762991979', 40000000, 0),
('AA03', 'Trần Nguyễn V. Thái', 2002, 'Nam', 'VietNam', '033951xxxx', 7500000, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`Account_ID`),
  ADD KEY `Account_FK_1` (`Staff_ID`);

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`Bill_ID`),
  ADD KEY `Bill_FK_1` (`Staff_id`),
  ADD KEY `Bill_FK_2` (`Customer_id`);

--
-- Indexes for table `bill_detail`
--
ALTER TABLE `bill_detail`
  ADD PRIMARY KEY (`Bill_id`,`Product_id`,`Size`),
  ADD KEY `BillDetail_FK_2` (`Product_id`,`Size`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`Category_ID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Customer_id`);

--
-- Indexes for table `discount`
--
ALTER TABLE `discount`
  ADD PRIMARY KEY (`discount_Id`);

--
-- Indexes for table `discount_detail`
--
ALTER TABLE `discount_detail`
  ADD PRIMARY KEY (`discount_Id`,`product_Id`),
  ADD KEY `product_Id` (`product_Id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`Product_ID`,`Size`),
  ADD KEY `Catagory_FK_1` (`Category_ID`);

--
-- Indexes for table `received_note`
--
ALTER TABLE `received_note`
  ADD PRIMARY KEY (`Received_Note_ID`),
  ADD KEY `Staff_ID` (`Staff_ID`);

--
-- Indexes for table `received_note_detail`
--
ALTER TABLE `received_note_detail`
  ADD PRIMARY KEY (`Received_Note_ID`,`Product_ID`,`Size`),
  ADD KEY `ReceivedNote_Detail_FK_2` (`Product_ID`,`Size`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`Staff_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `Account_FK_1` FOREIGN KEY (`Staff_ID`) REFERENCES `staff` (`Staff_id`);

--
-- Constraints for table `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `Bill_FK_1` FOREIGN KEY (`Staff_id`) REFERENCES `staff` (`Staff_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Bill_FK_2` FOREIGN KEY (`Customer_id`) REFERENCES `customer` (`Customer_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `bill_detail`
--
ALTER TABLE `bill_detail`
  ADD CONSTRAINT `BillDetail_FK_1` FOREIGN KEY (`Bill_id`) REFERENCES `bill` (`Bill_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `BillDetail_FK_2` FOREIGN KEY (`Product_id`,`Size`) REFERENCES `product` (`Product_ID`, `Size`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `discount_detail`
--
ALTER TABLE `discount_detail`
  ADD CONSTRAINT `discount_detail_ibfk_1` FOREIGN KEY (`discount_Id`) REFERENCES `discount` (`discount_Id`),
  ADD CONSTRAINT `discount_detail_ibfk_2` FOREIGN KEY (`product_Id`) REFERENCES `product` (`Product_ID`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `Catagory_FK_1` FOREIGN KEY (`Category_ID`) REFERENCES `category` (`Category_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `received_note`
--
ALTER TABLE `received_note`
  ADD CONSTRAINT `Product_FK_1` FOREIGN KEY (`Staff_ID`) REFERENCES `staff` (`Staff_id`) ON UPDATE CASCADE;

--
-- Constraints for table `received_note_detail`
--
ALTER TABLE `received_note_detail`
  ADD CONSTRAINT `ReceivedNote_Detail_FK_2` FOREIGN KEY (`Product_ID`,`Size`) REFERENCES `product` (`Product_ID`, `Size`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Received_Note_FK_1` FOREIGN KEY (`Received_Note_ID`) REFERENCES `received_note` (`Received_Note_ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
