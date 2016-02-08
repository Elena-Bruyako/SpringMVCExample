DROP TABLE IF EXISTS Goods;

CREATE TABLE `Goods` (
  `Good_id` int PRIMARY key AUTO_INCREMENT,
  `Name` VARCHAR(45),
  `Price` int,
  PRIMARY KEY (`Good_id`)
);