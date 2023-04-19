-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 07, 2022 at 12:32 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10
create database fast_food_store;
use fast_food_store;
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
  `decentralize_id` char(50) DEFAULT NULL,
  `Staff_ID` char(8) NOT NULL,
  `IsDeleted` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`Account_ID`, `UserName`, `Password`, `decentralize_id`, `Staff_ID`, `IsDeleted`) VALUES
('1', '1', '1', 'DC01', 'AA01', 0),
('2', '2', '2', 'DC01', 'AA01', 0),
('AC01', 'nhamgiaphat', '123456', 'DC04', 'AA02', 0),
('AC02', 'staff1', 'pass1', 'DC03', 'AA03', 0),
('AC03', 'chinh', 'chinh', 'DC01', 'AA01', 0),
('AC04', 'staff2', 'pass2', 'DC02', 'AA04', 0);

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
('B1', '2022-12-04 12:28:23', 200500, 1111111, -910611, 'AA01', 'C0'),
('B2', '2022-12-07 18:02:42', 560000, 1000000, -440000, 'AA01', 'C0');

-- --------------------------------------------------------

--
-- Table structure for table `bill_detail`
--

CREATE TABLE `bill_detail` (
  `Bill_id` char(8) NOT NULL,
  `Product_id` char(8) NOT NULL,
  `Size` char(8) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `TotalValue` double NOT NULL,
  `percent` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bill_detail`
--

INSERT INTO `bill_detail` (`Bill_id`, `Product_id`, `Size`, `Quantity`, `TotalValue`, `percent`) VALUES
('B1', 'P02', '1 con', 1, 110500, 15),
('B1', 'P04', 'Nhỏ', 1, 90000, 0),
('B2', 'P01', '4 oz', 1, 40000, 0),
('B2', 'P02', '1 con', 4, 520000, 0);

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
('01', 'Hamburger', 'On', 0),
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
-- Table structure for table `decentralization`
--

CREATE TABLE `decentralization` (
  `decentralize_id` varchar(10) NOT NULL,
  `decentralize_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `decentralization`
--

INSERT INTO `decentralization` (`decentralize_id`, `decentralize_name`) VALUES
('DC01', 'manager'),
('DC02', 'staffSale'),
('DC03', 'staffProduct'),
('DC04', 'staffCustomerService'),
('DC05', 'staffSale');

-- --------------------------------------------------------

--
-- Table structure for table `decentralization_detail`
--

CREATE TABLE `decentralization_detail` (
  `decentralize_id` varchar(10) NOT NULL,
  `isSale` int(11) NOT NULL,
  `isRecept` int(11) NOT NULL,
  `isProduct` int(11) NOT NULL,
  `isCategory` int(11) NOT NULL,
  `isBill` int(11) NOT NULL,
  `isDiscount` int(11) NOT NULL,
  `isCustomer` int(11) NOT NULL,
  `isStaff` int(11) NOT NULL,
  `isAccount` int(11) NOT NULL,
  `isDecentralize` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `decentralization_detail`
--

INSERT INTO `decentralization_detail` (`decentralize_id`, `isSale`, `isRecept`, `isProduct`, `isCategory`, `isBill`, `isDiscount`, `isCustomer`, `isStaff`, `isAccount`, `isDecentralize`) VALUES
('DC01', 2, 2, 2, 2, 2, 2, 2, 2, 2, 2),
('DC02', 2, 1, 2, 1, 1, 2, 1, 0, 0, 0),
('DC03', 1, 2, 2, 2, 0, 0, 0, 0, 0, 0),
('DC04', 0, 0, 0, 0, 0, 2, 2, 0, 0, 0),
('DC05', 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);

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
('KM0', 15, '01-11-2022', '04-12-2022', 0, 0),
('KM1', 2, '01-11-2022', '01-12-2022', 0, 0),
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
('KM0', 'P02');

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
('P01', '3.5 oz', 'Hamburger gà sốt BBQ', 30000, 20, 'src/Img/HBG.jpg', '03', 0, 1),
('P01', '4 oz', 'Hamburger gà sốt BBQ', 40000, 175, 'src/Img/HBG.jpg', '03', 0, 1),
('P01', '5oz', 'Hamburger gà sốt BBQ', 60000, 1, 'src/Img/HBG.jpg', '03', 0, 1),
('P02', '1 con', 'Gà nướng muối ớt', 130000, 24, 'src\\Img\\chicken_chilliSalt.jpg', '05', 0, 1),
('P02', '1/2 con', 'Gà nướng muối ớt', 70000, 64, 'src\\Img\\chicken_chilliSalt.jpg', '05', 0, 1),
('P03', 'Lớn', 'Cơm xèo gà mắm tỏi', 50000, 19, 'src\\Img\\comXeo_garlicChicken.jpeg', '02', 0, 1),
('P03', 'Vừa', 'Cơm xèo gà mắm tỏi', 40000, 27, 'src\\Img\\comXeo_garlicChicken.jpeg', '02', 0, 1),
('P04', 'Nhỏ', 'Bít tết đặc biệt', 90000, 87, 'src\\Img\\beef_beefsteak.jpg', '04', 0, 1),
('P05', 'Nhỏ', 'Bít tết đặc biệt4', 90000, 90, '/Img/chicken-leg.png', '04', 1, 1);

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
('RN1', '2022-11-01 15:48:46', 150000, 15000, 165000, 'Công ty Productiness', 'AA01'),
('RN2', '2022-12-07 17:48:17', 4400000, 352000, 4752000, 'SP01', 'AA01'),
('RN3', '2022-12-07 17:59:01', 1800000, 144000, 1944000, 'SP01', 'AA01'),
('RN4', '2022-12-07 18:00:54', 900000, 72000, 972000, 'SP01', 'AA01'),
('RN5', '2022-12-07 18:06:34', 600000, 48000, 648000, 'SP01', 'AA01');

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
('RN1', 'P03', 'Lớn', 30000, 1, 30000),
('RN2', 'P02', '1 con', 90000, 10, 900000),
('RN2', 'P02', '1/2 con', 40000, 20, 800000),
('RN5', 'P01', '3.5 oz', 30000, 20, 600000);

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
('AA03', 'Trần Nguyễn V. Thái', 2002, 'Nam', 'VietNam', '033951xxxx', 7500000, 0),
('AA04', 'Tổng Giám Đốc Thái', 1985, 'Male', 'Somewhere', '19008198', 1000000, 0),
('AA05', 'Nguyễn Ngọc Trường Chinh', 2001, 'TP.HCM', 'Nam', '0862863753', 30000000, 1),
('AA06', 'Nguyễn Ngọc Trường Chinh', 2001, 'Nam', 'TP.HCM', '0862863753', 30000000, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`Account_ID`),
  ADD KEY `Account_FK_1` (`Staff_ID`),
  ADD KEY `Account_FK_2` (`decentralize_id`);

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
-- Indexes for table `decentralization`
--
ALTER TABLE `decentralization`
  ADD PRIMARY KEY (`decentralize_id`);

--
-- Indexes for table `decentralization_detail`
--
ALTER TABLE `decentralization_detail`
  ADD PRIMARY KEY (`decentralize_id`),
  ADD KEY `decentralize_id` (`decentralize_id`);

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
  ADD CONSTRAINT `Account_FK_1` FOREIGN KEY (`Staff_ID`) REFERENCES `staff` (`Staff_id`),
  ADD CONSTRAINT `Account_FK_2` FOREIGN KEY (`decentralize_id`) REFERENCES `decentralization` (`decentralize_id`) ON DELETE SET NULL ON UPDATE SET NULL;

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
-- Constraints for table `decentralization_detail`
--
ALTER TABLE `decentralization_detail`
  ADD CONSTRAINT `decentralize_FK_1` FOREIGN KEY (`decentralize_id`) REFERENCES `decentralization` (`decentralize_id`);

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
