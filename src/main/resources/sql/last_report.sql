 CREATE TABLE `wod`.`Last_report`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `hero_id` varchar(20) NOT NULL,
  `report_name` varchar(255) CHARACTER SET utf8mb4 NOT NULL,
  `report_id` varchar(20) NOT NULL,
  `date_time` datetime(6) NOT NULL,
  PRIMARY KEY (`id`)
);