-- CREATE DATABASE shop DEFAULT CHARACTER SET utf8;

DROP TABLE IF EXISTS tb_user;
DROP TABLE IF EXISTS tb_brand;
DROP TABLE IF EXISTS tb_category;
DROP TABLE IF EXISTS tb_commodity_types;
DROP TABLE IF EXISTS tb_commodity_image;
DROP TABLE IF EXISTS tb_commodity;
DROP TABLE IF EXISTS tb_carousel;
DROP TABLE IF EXISTS tb_carousel_image;

-- 用户表
CREATE TABLE tb_user(
  id BIGINT(50) AUTO_INCREMENT COMMENT '用户ID',
  username VARCHAR(100) NOT NULL COMMENT '用户名',
  password VARCHAR(100) NOT NULL COMMENT '密码',
  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  enabled tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否停用，默认为1',
  CONSTRAINT pk_sys_user PRIMARY KEY(id)
) CHARSET=utf8 ENGINE=InnoDB;

INSERT INTO tb_user(username,password) VALUES('proaim', '123');
INSERT INTO tb_user(username,password) VALUES('邢子铭', '123');

-- 品牌表
CREATE TABLE tb_brand(
  id BIGINT(50) AUTO_INCREMENT COMMENT '品牌ID',
  name varchar(100) NOT NULL COMMENT '品牌名称',
  cover_url varchar(200) NOT NULL COMMENT '封面url',
  logo_lg varchar(100) NOT NULL COMMENT '品牌logo，大图',
  logo_sm varchar(100) NOT NULL COMMENT '中图',
  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  description varchar(300) NOT NULL COMMENT '品牌描述',
  enabled tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否删除，默认为1',
  CONSTRAINT pk_sys_user PRIMARY KEY (id)
) CHARSET=utf8 ENGINE=InnoDB;

-- 商品分类总表
CREATE TABLE tb_category (
  id bigint(50) AUTO_INCREMENT COMMENT '分类ID',
  name varchar(100) NOT NULL COMMENT '分类名称',
  parent_id smallint(5) NOT NULL COMMENT '父分类id',
  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  enabled tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否删除，默认为1',
  CONSTRAINT pk_sys_user PRIMARY KEY (id)
) CHARSET=utf8 ENGINE=InnoDB;

-- 商品分类表
CREATE TABLE tb_commodity_types (
  type_id smallint(5) unsigned AUTO_INCREMENT COMMENT '分类ID',
  type_name varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '分类名称',
  parent_id bigint(10) unsigned NOT NULL DEFAULT '0' COMMENT '父分类id',
  PRIMARY KEY (type_id)
) CHARSET=utf8 ENGINE=InnoDB;

-- 商品图片表
CREATE TABLE tb_commodity_image (
  id bigint(50) AUTO_INCREMENT COMMENT '图片ID',
  commodity_id bigint(50) NOT NULL COMMENT '商品ID',
  url varchar(200) NOT NULL COMMENT '商品图片',
  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  enabled tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否删除，默认为1',
  CONSTRAINT pk_sys_user PRIMARY KEY (id)
) CHARSET=utf8 ENGINE=InnoDB;

-- 商品表
CREATE TABLE tb_commodity(
  id BIGINT(50) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  brand_id bigint(50) NOT NULL COMMENT '品牌ID',
  category_id bigint(50) NOT NULL COMMENT '分类ID',
  name varchar(150) COMMENT '商品名称',
  description text NOT NULL COMMENT '商品描述',
  price decimal(10,2) COMMENT '商品价格',
  detail text NOT NULL COMMENT '商品详情',
  order_commodity tinyint(3) NOT NULL COMMENT '排序',
  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  enabled tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否删除，默认为1',
  CONSTRAINT pk_sys_user PRIMARY KEY(id)
) CHARSET=utf8 ENGINE=InnoDB;

-- 商品轮播表
CREATE TABLE tb_carousel (
  id bigint(10) AUTO_INCREMENT COMMENT '轮播ID',
  start_time datetime NOT NULL,
  end_time datetime NOT NULL,
  round_at_last tinyint(1) NOT NULL DEFAULT '1',
  auto tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否自动播放',
  order_commodity tinyint(3) NOT NULL DEFAULT '1' COMMENT '按照0、1、2排序的先后顺序显示',
  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  enabled tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否删除，默认为1',
  CONSTRAINT pk_sys_user PRIMARY KEY(id)
) CHARSET=utf8 ENGINE=InnoDB;

-- 商品轮播图片表
CREATE TABLE tb_carousel_image (
  id bigint(10) NOT NULL AUTO_INCREMENT,
  carousel_id bigint(10) NOT NULL COMMENT '轮播ID',
  name varchar(100) NOT NULL COMMENT '图片名称',
  width double NOT NULL COMMENT '宽度',
  height double NOT NULL COMMENT '高度',
  format varchar(10) NOT NULL COMMENT '格式，png，jpg，jpeg，gif',
  url varchar(200) NOT NULL COMMENT '图片的访问地址',
  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  enabled tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否删除，默认为1',
  CONSTRAINT pk_sys_user PRIMARY KEY(id)
) CHARSET=utf8 ENGINE=InnoDB;