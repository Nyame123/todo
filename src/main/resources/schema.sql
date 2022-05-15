DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
    `id` bigInt(20) not null primary key AUTO_INCREMENT,
    `name` varchar(50) DEFAULT NOT NULL;
    `password` varchar(60) not null;
    `created_date` datetime not null;
    `created_by` varchar(100) not null;
);