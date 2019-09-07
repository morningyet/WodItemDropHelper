 * CREATE TABLE `wod`.`items_drop`  (
 * `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
 * `items_name` varchar(255) NOT NULL,
 * `dungeons_id` int(10) NULL,
 * `dungeons_name` varchar(255) NOT NULL,
 * `branch` varchar(20) NULL,
 * `floor` tinyint(8) NULL,
 * `uni` varchar(20) NULL,
 * `role1` tinyint(8) NULL,
 * `role2` tinyint(8) NULL,
 * `role3` tinyint(8) NULL,
 * `role4` tinyint(8) NULL,
 * `role5` tinyint(8) NULL,
 * `role6` tinyint(8) NULL,
 * PRIMARY KEY (`id`)
 * );