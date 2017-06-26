Drop TABLE IF EXISTS users_info;

Create TABLE users_info(
userId BIGINT PRIMARY KEY,
userName VARCHAR(20) NOT NULL UNIQUE,
userSex ENUM('男','女','保密') NOT NULL DEFAULT '保密',
userEmail VARCHAR(200),
userTel VARCHAR(200),
FOREIGN KEY(userId) REFERENCES users(userId)
)engine=INNODB DEFAULT CHARSET=GBK