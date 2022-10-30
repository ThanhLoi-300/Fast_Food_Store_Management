-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 30, 2022 at 02:44 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

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
  `Account_id` char(8) NOT NULL,
  `UserName` char(25) NOT NULL,
  `Password` char(15) NOT NULL,
  `UserType` char(20) NOT NULL,
  `Staff_id` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `Bill_id` char(8) NOT NULL,
  `Date` datetime NOT NULL,
  `TotalQuantity` int(11) NOT NULL,
  `TotalValue` int(11) NOT NULL,
  `ReceivedMoney` int(11) NOT NULL,
  `ExcessMoney` int(11) NOT NULL,
  `Staff_id` char(8) NOT NULL,
  `Customer_id` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `bill_detail`
--

CREATE TABLE `bill_detail` (
  `Bill_id` char(8) NOT NULL,
  `Product_id` char(8) NOT NULL,
  `Size` char(8) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `TotalValue` int(11) NOT NULL,
  `ReceivedMoney` int(11) NOT NULL,
  `Recharge` int(11) NOT NULL,
  `Customer_ID` char(8) NOT NULL,
  `Staff_ID` char(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `Category_ID` char(8) NOT NULL,
  `Category_Name` char(40) NOT NULL,
  `Business_Status` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`Category_ID`, `Category_Name`, `Business_Status`) VALUES
('01', 'Hamburger', 'On'),
('02', 'Cơm', 'On'),
('03', 'Thịt heo', 'On'),
('04', 'Thịt bò', 'On'),
('05', 'Thịt gà', 'On');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Customer_id` char(8) NOT NULL,
  `Customer_name` char(40) NOT NULL,
  `YearOfBirth` year(4) NOT NULL,
  `Purchase_Time` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Customer_id`, `Customer_name`, `YearOfBirth`, `Purchase_Time`) VALUES
('aaaa', 'aaaa', 2000, 9);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `Product_ID` char(8) NOT NULL,
  `Size` char(8) NOT NULL,
  `Product_Name` char(40) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Category_ID` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`Product_ID`, `Size`, `Product_Name`, `Quantity`, `Category_ID`) VALUES
('P01', '3.5 oz', 'Hamburger gà sốt BBQ', 150, '01'),
('P01', '4 oz', 'Hamburger gà sốt BBQ', 200, '01'),
('P02', '1 con', 'Gà nướng muối ớt', 50, '05'),
('P02', '1/2 con', 'Gà nướng muối ớt', 50, '05'),
('P03', 'Lớn', 'Cơm xèo gà mắm tỏi', 50, '02'),
('P03', 'Vừa', 'Cơm xèo gà mắm tỏi', 30, '02');

-- --------------------------------------------------------

--
-- Table structure for table `received_note`
--

CREATE TABLE `received_note` (
  `Received_Note_ID` char(8) NOT NULL,
  `Date` datetime NOT NULL,
  `Total_Value` int(11) NOT NULL,
  `Supplier` char(40) NOT NULL,
  `Staff_ID` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `received_note_detail`
--

CREATE TABLE `received_note_detail` (
  `Received_Note_ID` char(8) NOT NULL,
  `Product_ID` char(8) NOT NULL,
  `Size` char(8) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  `Salary` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`Staff_id`, `Full_Name`, `Year_Of_Birth`, `Gender`, `HomeTown`, `Phone_Num`, `Salary`) VALUES
('AA01', 'Nguyễn Ngọc Trường Chinh', 2001, 'Nam', 'TP.HCM', '0862863753', 30000000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`Account_id`),
  ADD KEY `Account_FK_1` (`Staff_id`);

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`Bill_id`),
  ADD KEY `Bill_FK_1` (`Staff_id`),
  ADD KEY `Bill_FK_2` (`Customer_id`);

--
-- Indexes for table `bill_detail`
--
ALTER TABLE `bill_detail`
  ADD PRIMARY KEY (`Bill_id`,`Product_id`,`Size`),
  ADD KEY `BillDetail_FK_2` (`Product_id`,`Size`),
  ADD KEY `BillDetail_FK_3` (`Customer_ID`),
  ADD KEY `BillDetail_FK_4` (`Staff_ID`);

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
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`Product_ID`,`Size`),
  ADD KEY `Catagory_FK_1` (`Category_ID`);

--
-- Indexes for table `received_note`
--
ALTER TABLE `received_note`
  ADD PRIMARY KEY (`Received_Note_ID`);

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
  ADD CONSTRAINT `Account_FK_1` FOREIGN KEY (`Staff_id`) REFERENCES `staff` (`Staff_id`);

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
  ADD CONSTRAINT `BillDetail_FK_1` FOREIGN KEY (`Bill_id`) REFERENCES `bill` (`Bill_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `BillDetail_FK_2` FOREIGN KEY (`Product_id`,`Size`) REFERENCES `product` (`Product_ID`, `Size`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `BillDetail_FK_3` FOREIGN KEY (`Customer_ID`) REFERENCES `customer` (`Customer_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `BillDetail_FK_4` FOREIGN KEY (`Staff_ID`) REFERENCES `staff` (`Staff_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `Catagory_FK_1` FOREIGN KEY (`Category_ID`) REFERENCES `category` (`Category_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

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
