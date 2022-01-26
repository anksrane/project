create database shortenurldb;
use urlshortendb;

-- create table
CREATE TABLE links (
  vid INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
  longUrl varchar(255) UNIQUE,
  shortUrl varchar(255) UNIQUE
);

CREATE TABLE users (
  uid INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
  longUrlVisitor varchar(255),
  shortUrlVisitor varchar(255),
  ipAddress varchar(255),
  visitedDate date,
  visitedTime time,
  FOREIGN KEY (longUrlVisitor) REFERENCES links(longUrl),
  FOREIGN KEY (shortUrlVisitor) REFERENCES links(shortUrl)
);
select * from links;
select * from users;