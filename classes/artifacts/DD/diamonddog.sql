--
-- Database: `diamonddog`
--
CREATE DATABASE IF NOT EXISTS `diamonddog` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `user_id_2` (`user_id`),
  ADD KEY `user_id` (`user_id`);

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=33;
	
--
-- Create User
--

CREATE USER 'diamonddog'@'localhost' IDENTIFIED BY '***';GRANT USAGE ON *.* TO 'diamonddog'@'localhost' IDENTIFIED BY '***' REQUIRE NONE WITH MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;

GRANT ALL PRIVILEGES ON `diamonddog`.* TO 'diamonddog'@'localhost' WITH GRANT OPTION;