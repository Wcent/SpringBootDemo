DROP TABLE if EXISTS user;
CREATE TABLE user (
id int(10) NOT NULL AUTO_INCREMENT COMMENT 'id号',
tel bigint(20) NOT NULL COMMENT '手机号=用户名',
nick_name varchar(30) DEFAULT NULL COMMENT '昵称',
password varchar(30) NOT NULL COMMENT '密码',
create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
update_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;