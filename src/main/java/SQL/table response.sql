DROP TABLE IF EXISTS response;

CREATE TABLE response(
postId BIGINT AUTO_INCREMENT PRIMARY KEY,
userId BIGINT NOT NULL,
tid INT NOT NULL,
content VARCHAR(500) NOT NULL,
respondId BIGINT NOT NULL,
createTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY(userId) REFERENCES users(userId)
)ENGINE=INNODB AUTO_INCREMENT=10001 DEFAULT CHARSET=GBK ;