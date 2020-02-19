-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 18, 2020 at 11:31 AM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `culture_nstu`
--

-- --------------------------------------------------------

--
-- Table structure for table `registered`
--

CREATE TABLE `registered` (
  `id` int(11) NOT NULL,
  `blood_group` varchar(255) NOT NULL,
  `category` int(11) NOT NULL,
  `department` varchar(255) NOT NULL,
  `dob` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registered`
--

INSERT INTO `registered` (`id`, `blood_group`, `category`, `department`, `dob`, `email`, `enabled`, `gender`, `name`, `password`, `role`) VALUES
(1, 'B+', 1, 'Information And Communication Engineering', '1995-09-04', 'culturenstu@gmail.com', b'1', 'Male', 'NSTU Cultural Club', '$2a$10$Sx3Dl6QUI0l/15m6.OVrke84A7Tg4EWiyuClKcEkqtb7G7M0ky9r2', 'Admin'),
(2, 'O+', 1, 'Information And Communication Engineering', '1996-06-19', 'rojo@gmail.com', b'1', 'Female', 'Rojoyita Das', '$2a$10$tg5rK/.X2CPDdhKwJ6vGcOVgA488h6Wi19HbVCr9sQI3WJwHh0ySW', 'Registered'),
(3, 'O+', 1, 'BBA (Accounting)', '1996-08-16', 'nigar@gmail.com', b'1', 'Female', 'Nigar Sultana Mumu', '$2a$10$OhTX3uaMjlDaLQBZ5K.BeuSML9Ycqz.Y4.IBWepXJHdmekTSMkO9O', 'Registered'),
(4, 'O+', 1, 'BBA (Accounting)', '1996-05-23', 'hridy@gmail.com', b'1', 'Female', 'Tarannum hridy', '$2a$10$z8ye1cLNS3IA9rS/94AwvenL.HNQTkRrzZBBpI.XtdNHnUQgj0LMq', 'Registered'),
(5, 'O-', 1, 'Information And Communication Engineering', '1996-07-16', 'fariha@gmail.com', b'1', 'Female', 'Fariha Nawshin', '$2a$10$pddGVj/N4K2sUuMwYvMGyu6kaZr1nUO6ipiahiIwqfEzRRGX6GL3K', 'Registered'),
(6, 'A+', 1, 'CSTE', '2020-02-09', 'isha@gmail..com', b'1', 'Female', 'isha', '$2a$10$cN2ZOpONYIH3YOlk/Myygu.BRVMy/56PcBazTb0eOBOfDEL/h4E1i', 'Registered');

-- --------------------------------------------------------

--
-- Table structure for table `registered_category`
--

CREATE TABLE `registered_category` (
  `id` int(11) NOT NULL,
  `description` longtext NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registered_category`
--

INSERT INTO `registered_category` (`id`, `description`, `name`) VALUES
(1, '<b>A cultural club</b> is a club dedicated to spreading awareness, understanding, and appreciation of a particular culture, its people, diversity, and values.<br>\r\n<h4>The Importance of Cultural Club:</h4> Such clubs emphasize on respect for the rights of others and promoting ethical standards and the dignity of all occupations. They provide a chance to young students to address the needs and concerns of the community and our world', 'Cultural Club');

-- --------------------------------------------------------

--
-- Table structure for table `registered_cover_img`
--

CREATE TABLE `registered_cover_img` (
  `id` int(11) NOT NULL,
  `active` bit(1) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `imgCoverUrl` varchar(255) DEFAULT NULL,
  `reg_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registered_cover_img`
--

INSERT INTO `registered_cover_img` (`id`, `active`, `description`, `imgCoverUrl`, `reg_id`) VALUES
(1, b'1', '', 'COVERA741C1B11D', 1),
(2, b'1', '', 'COVER152887A72B', 2),
(3, b'1', '', 'COVER2426A2E0D6', 3),
(4, b'1', '', 'COVER39051A194C', 4),
(5, b'1', '', 'COVEREB277C7825', 5),
(6, b'0', NULL, 'COVER1741ACF926', 6);

-- --------------------------------------------------------

--
-- Table structure for table `registered_details`
--

CREATE TABLE `registered_details` (
  `id` int(11) NOT NULL,
  `about` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `aim` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `graduation_program` varchar(255) DEFAULT NULL,
  `hall_room` varchar(255) DEFAULT NULL,
  `reg_id` int(11) NOT NULL,
  `roll` varchar(255) DEFAULT NULL,
  `session` varchar(255) DEFAULT NULL,
  `slogan` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registered_details`
--

INSERT INTO `registered_details` (`id`, `about`, `address`, `aim`, `department`, `graduation_program`, `hall_room`, `reg_id`, `roll`, `session`, `slogan`) VALUES
(1, '', 'Behind Nice Guest House, Maijdi, Noakhali', '', 'Information And Communication Engineering', 'Graduation Program', '302-Abdus Salam Hall, NSTU', 1, 'ASH 1911MSc 117M', '2014-15', ''),
(2, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, NULL, NULL),
(3, NULL, NULL, NULL, NULL, NULL, NULL, 3, NULL, NULL, NULL),
(4, NULL, NULL, NULL, NULL, NULL, NULL, 4, NULL, NULL, NULL),
(5, NULL, NULL, NULL, NULL, NULL, NULL, 5, NULL, NULL, NULL),
(6, NULL, NULL, NULL, NULL, NULL, NULL, 6, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `registered_post`
--

CREATE TABLE `registered_post` (
  `id` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  `imgUrl` varchar(255) DEFAULT NULL,
  `react` int(11) DEFAULT NULL,
  `regId` int(11) DEFAULT NULL,
  `seen` int(11) DEFAULT NULL,
  `status` varchar(2000) DEFAULT NULL,
  `statusTitle` varchar(255) DEFAULT NULL,
  `visible` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registered_post`
--

INSERT INTO `registered_post` (`id`, `date`, `imgUrl`, `react`, `regId`, `seen`, `status`, `statusTitle`, `visible`) VALUES
(1, '2020-02-04 14:33:10', 'welcome', 0, 1, 0, 'Welcome to <b>NSTU CULTURAL CLUB</b>.<br><h3>Congratulations for being a part of our club. </h3>Our whole team welcomes a new member like you. We are looking forward for the club\'s success with you. Welcome aboard.', 'New Registration NSTU Cultural Club!', b'0'),
(2, '2020-02-04 14:34:56', 'welcome', 0, 2, 0, 'Welcome to <b>NSTU CULTURAL CLUB</b>.<br><h3>Congratulations for being a part of our club. </h3>Our whole team welcomes a new member like you. We are looking forward for the club\'s success with you. Welcome aboard.', 'New Registration Rojoyita Das!', b'0'),
(3, '2020-02-04 14:35:44', 'welcome', 0, 3, 0, 'Welcome to <b>NSTU CULTURAL CLUB</b>.<br><h3>Congratulations for being a part of our club. </h3>Our whole team welcomes a new member like you. We are looking forward for the club\'s success with you. Welcome aboard.', 'New Registration Nigar Sultana Mumu!', b'0'),
(4, '2020-02-04 14:36:41', 'welcome', 0, 4, 0, 'Welcome to <b>NSTU CULTURAL CLUB</b>.<br><h3>Congratulations for being a part of our club. </h3>Our whole team welcomes a new member like you. We are looking forward for the club\'s success with you. Welcome aboard.', 'New Registration Tarannum hridy!', b'0'),
(5, '2020-02-04 14:37:30', 'welcome', 0, 5, 0, 'Welcome to <b>NSTU CULTURAL CLUB</b>.<br><h3>Congratulations for being a part of our club. </h3>Our whole team welcomes a new member like you. We are looking forward for the club\'s success with you. Welcome aboard.', 'New Registration Fariha Nawshin!', b'0'),
(11, '2020-02-04 00:00:00', 'POSTBC2983E483', 0, 1, 0, '<b>NSTU Cultural Club</b> regularly organizes cultural programs, celebrating major national events. The club has taken the\r\nexponential steps to create a culture of practicing true artistry on campus. The goal of this club is to highlight the culture of Bangladesh by organizing various cultural activities.<br><br>', 'Cultural Club Notice !', b'1'),
(12, '2020-02-04 00:00:00', 'POST220884AD76', 0, 2, 0, 'The festival date is set according to the lunisolar Bengali calendar as the first day of its first month Baishakh..<br><br>The festival is celebrated with processions, fairs and family time.<br><br>\r\nThe traditional greeting for Bengali New Year is &#2486;&#2497;&#2477; &#2472;&#2476;&#2476;&#2480;&#2509;&#2487; .<br><br>\"Shubho Nabobarsho\" .<br><br>which is literally \"Happy New Year\".', 'Pohela Boishakh organized by NSTU Cultural Club', b'1'),
(13, '2020-02-04 00:00:00', 'POSTAA913A5814', 0, 4, 0, '<h4>International Mother Language Day</h4> is celebrated every year on 21st February. The main purpose of celebrating this day is to promote the awareness of language and cultural diversity all across the world. It was first announced by UNESCO on November 17, 1999.<br><br>\r\n<b>International Mother Language Day (IMLD)</b> is a worldwide annual observance held on 21 February to promote awareness of linguistic and cultural diversity and promote multilingualism.', 'Cultural Club having preparation for upcoming 21\'st February', b'1'),
(14, '2020-02-04 00:00:00', 'POSTFC60864D81', 0, 3, 0, '<h3>The Baul or Bauls </h3><b>(Bengali: &#2476;&#2494;&#2441;&#2482;)</b> are a group of mystic minstrels from the Bengal region ... The music of the Bauls, Baul Sangeet, is a particular type of folk song. Its lyrics carry influences of the Hindu bhakti movements and the suphi, ', 'Boul Song At Hazi Mohammad Iddris Auditorium ', b'1'),
(15, '2020-02-12 10:05:39', 'welcome', 0, 6, 0, 'Welcome to <b>NSTU CULTURAL CLUB</b>.<br><h3>Congratulations for being a part of our club. </h3>Our whole team welcomes a new member like you. We are looking forward for the club\'s success with you. Welcome aboard.', 'New Registration isha!', b'0');

-- --------------------------------------------------------

--
-- Table structure for table `registered_profile_img`
--

CREATE TABLE `registered_profile_img` (
  `id` int(11) NOT NULL,
  `active` bit(1) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `imgProfUrl` varchar(255) DEFAULT NULL,
  `reg_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registered_profile_img`
--

INSERT INTO `registered_profile_img` (`id`, `active`, `description`, `imgProfUrl`, `reg_id`) VALUES
(1, b'1', '', 'PROFILE402984FF20', 1),
(2, b'1', '', 'PROFILE4D7E564984', 2),
(3, b'1', '', 'PROFILED23C7E07D0', 3),
(4, b'1', '', 'PROFILE764E89E7BA', 4),
(5, b'1', '', 'PROFILE6C5B8F97FA', 5),
(6, b'0', NULL, 'PROFILE83AE58EED7', 6);

-- --------------------------------------------------------

--
-- Table structure for table `registered_status`
--

CREATE TABLE `registered_status` (
  `id` int(11) NOT NULL,
  `active` bit(1) NOT NULL,
  `live` bit(1) NOT NULL,
  `reg_id` int(11) NOT NULL,
  `varified` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registered_status`
--

INSERT INTO `registered_status` (`id`, `active`, `live`, `reg_id`, `varified`) VALUES
(1, b'0', b'0', 1, b'0'),
(2, b'0', b'0', 2, b'0'),
(3, b'0', b'0', 3, b'0'),
(4, b'0', b'0', 4, b'0'),
(5, b'0', b'0', 5, b'0'),
(6, b'0', b'0', 6, b'0');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `registered`
--
ALTER TABLE `registered`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `registered_category`
--
ALTER TABLE `registered_category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `registered_cover_img`
--
ALTER TABLE `registered_cover_img`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `registered_details`
--
ALTER TABLE `registered_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `registered_post`
--
ALTER TABLE `registered_post`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `registered_profile_img`
--
ALTER TABLE `registered_profile_img`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `registered_status`
--
ALTER TABLE `registered_status`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `registered`
--
ALTER TABLE `registered`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `registered_category`
--
ALTER TABLE `registered_category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `registered_cover_img`
--
ALTER TABLE `registered_cover_img`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `registered_details`
--
ALTER TABLE `registered_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `registered_post`
--
ALTER TABLE `registered_post`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `registered_profile_img`
--
ALTER TABLE `registered_profile_img`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `registered_status`
--
ALTER TABLE `registered_status`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
