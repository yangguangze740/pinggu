### 数据库

```
CREATE SCHEMA `djtu_pinggu` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
CREATE USER 'pinggu'@'localhost' IDENTIFIED BY 'pingu@djtu123';
GRANT ALL PRIVILEGES ON pinggu.* TO 'djtu_pinggu'@'localhost' WITH GRANT OPTION;
```