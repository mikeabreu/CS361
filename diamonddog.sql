-- phpMyAdmin SQL Dump
-- version 4.4.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 19, 2015 at 04:35 PM
-- Server version: 5.6.25
-- PHP Version: 5.6.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `diamonddog`
--
CREATE DATABASE IF NOT EXISTS `diamonddog` DEFAULT CHARACTER SET utf8_bin COLLATE utf8_bin;
USE `diamonddog`;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `user_email` varchar(150) NOT NULL,
  `user_cc` int(15) NOT NULL,
  `user_pass` varchar(30) NOT NULL,
  `user_account` int(9) NOT NULL,
  `user_balance` int(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_name`, `user_email`, `user_cc`, `user_pass`, `user_account`, `user_balance`) VALUES
(13, 'james', 'james@email.com', 88888888, 'jame', 8514, 1485),
(14, 'sam', 'sam@email.com', 77777777, 'sammy', 9207, 891),
(15, 'tom', 'tommy@email.com', 99999999, 'tommy', 3663, 891),
(16, 'sally', 'sally@email.com', 66666666, 'sally', 8910, 792),
(17, 'manny', 'manny@email.com', 66666666, 'manny', 396, 891),
(18, 'mikey', 'mikeabreu@email.com', 99999999, 'mike', 1881, 1881),
(19, 'lance', 'lance@email.com', 88888888, 'lance', 5346, 693),
(20, 'tim', 'tim@email.com', 66666666, 'timmy', 297, 891),
(21, 'kyle', 'kyle@email.com', 99999999, 'kyle', 3366, 198),
(22, 'bill', 'bill@email.com', 66666666, 'billy', 9207, 0),
(23, 'jones', 'jones@email.com', 33333333, 'jones', 4455, 99),
(24, 'peter', 'peter@email.com', 55555555, 'peter', 4851, 1089),
(25, 'kat', 'kat@email.com', 22222222, 'kat', 5841, 990),
(26, 'test', 'test', 33333333, 'test', 594, 1386),
(27, 'test1', 'test1', 44444444, 'test1', 9702, 792),
(28, 'test2', 'test2', 55555555, 'test2', 3168, 297),
(29, 'test3', 'test3', 99999999, 'test3', 3465, 198),
(30, 'test4', 'test4', 44444444, 'test4', 9603, 990),
(31, 'test5', 'test5', 66666666, 'test5', 9405, 1386),
(32, 'jim', 'jim@email.com', 99999999, 'jim', 1386, 99);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `user_id_2` (`user_id`),
  ADD KEY `user_id` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=33;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
