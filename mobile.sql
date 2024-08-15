DROP DATABASE IF EXISTS mobile;
CREATE DATABASE mobile;
USE mobile;

CREATE TABLE users (
    id INT(11) PRIMARY KEY AUTO_INCREMENT,
    `username` NVARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    fullName NVARCHAR(255) NULL,
    address NVARCHAR(255) NULL,
    phoneNumber INT(11) NULL,
    email VARCHAR(255) NULL,
    img blob,
    coverImg blob
);

CREATE TABLE admins (
    id INT(11) PRIMARY KEY AUTO_INCREMENT,
    `name` NVARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL
);

CREATE TABLE `role` (
    userId INT(11),
    roleId INT(11),
	FOREIGN KEY (userId) REFERENCES users(id),
    FOREIGN KEY (roleId) REFERENCES admins(id),
    roleName VARCHAR(255) NOT NULL
);

INSERT INTO role (userId, roleName)
SELECT id, 'user' FROM users;

INSERT INTO role (roleId, roleName)
SELECT id, 'admin' FROM admins;

create table `categoryProduct`(
	id int(11) primary key auto_increment,
    categoryName nvarchar(255) not null
);
insert into `categoryProduct`(id, categoryName) values
(1,"iPhone 15"),
(2,"iPhone 14"),
(3, "iPhone 13"),
(4, "iPhone 12"),
(5, "iPhone 11"),
(6, "iPhone X"),
(7, "linh kiện");
create table `product`(
	id int(11) primary key auto_increment,
    productName nvarchar(255) not null,
    productCategoryPath nvarchar(255)  null,
    img blob,
    unitPrice decimal(10,3) UNSIGNED,
    oldPrice decimal(10,3) UNSIGNED,
    cid int(11),
    quantity int(11),
    foreign key (cid) references `categoryProduct`(id)
);

INSERT INTO `product` (productName, productCategoryPath, img, unitPrice, oldPrice, cid, quantity)
VALUES (
  "iPhone 14Promax",
  "iPhone / iPhone 14 / iPhone 14Promax",
  LOAD_FILE('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/13Promax-gold.jpg'),
  990,
  1000,
  3,
  11
);
-- SHOW VARIABLES LIKE 'secure_file_priv';

-- delete from `product` where productName = "iPhone 14Promax";
-- SELECT cp.* FROM product p JOIN categoryProduct cp ON p.cid = cp.id WHERE p.id = 6;
-- SELECT img FROM `product` WHERE productName = "iPhone 14Promax";
-- select * from `product`;
CREATE TABLE orders (
    id INT(11) PRIMARY KEY AUTO_INCREMENT,
    customerId INT(11) ,
    orderDate datetime ,
    `status` NVARCHAR(255) ,
    price decimal(10,3) unsigned,
    FOREIGN KEY (customerId) REFERENCES users(id)
);

CREATE TABLE orderDetails (
    id INT(11) PRIMARY KEY AUTO_INCREMENT,
    orderId INT(11),
    productId INT(11),
    quantity INT(11),
    shipAddress nvarchar(255) null,
    price bigint null,
    FOREIGN KEY (orderId) REFERENCES orders(id),
    FOREIGN KEY (productId) REFERENCES `product`(id)
);

CREATE TABLE cart (
	id INT(11) PRIMARY KEY,
    userId INT(11),
    productId INT(11),
    FOREIGN KEY (userId) REFERENCES users(id),
    FOREIGN KEY (productId) REFERENCES `product`(id)
);
-- SELECT p.* FROM `product` p INNER JOIN `cart` c ON p.id = c.productId WHERE c.productId = 1;

CREATE TABLE productDetails (
    id INT(11) PRIMARY KEY AUTO_INCREMENT,
    productId INT(11) NOT NULL,
    screenTechnology NVARCHAR(255) NOT NULL,
    screenResolution NVARCHAR(255) NOT NULL,
    glassQuality NVARCHAR(255) NOT NULL,
    screenSize NVARCHAR(255) NOT NULL,
    rearCameraResolution NVARCHAR(255) NOT NULL,
    frontCameraResolution NVARCHAR(255) NOT NULL,
    rearCameraDetails NVARCHAR(255) NOT NULL,
    videoRecordingCapability NVARCHAR(255) NOT NULL,
    cameraFeatures NVARCHAR(255) NOT NULL,
    processor NVARCHAR(255) NOT NULL,
    chip NVARCHAR(255) NOT NULL,
    operatingSystem NVARCHAR(255) NOT NULL,
    ram NVARCHAR(255) NOT NULL,
    mobileNetworkSupport NVARCHAR(255) NOT NULL,
    wifiSupport NVARCHAR(255) NOT NULL,
    bluetoothSupport NVARCHAR(255) NOT NULL,
    gpsSupport NVARCHAR(255) NOT NULL,
    connectivityPorts NVARCHAR(255) NOT NULL,
    batteryCapacity NVARCHAR(255) NOT NULL,
    FOREIGN KEY (productId) REFERENCES `product`(id)
);

CREATE TABLE `memory` (
    id INT(11) PRIMARY KEY AUTO_INCREMENT,
    productId INT(11),
    `memory` NVARCHAR(255),
    price decimal(10,3) UNSIGNED,
    FOREIGN KEY (productId) REFERENCES `product`(id)
);

create table `color`(
	id int(11) primary key auto_increment,
    productId int(11),
    color nvarchar(255),
    foreign key (productId) references `product`(id)
);

create table memory_color_quantity (
	memory_id int(11),
	color_id int(11),
    quantity int,
    unique(memory_id, color_id),
	foreign key (memory_id) references `memory`(id),
	foreign key (color_id) references `color`(id)    
);

CREATE TABLE ProductColorImages (
    coID INT(11) ,
    imageUrl text ,
    FOREIGN KEY (coID) REFERENCES `color`(id)
);

create table gift(
	id int(11) primary key auto_increment,
    giftName nvarchar(225),
    productId int(11),
    foreign key (productId) references `product`(id)
);

 create table guarantee(
	id int(11) primary key auto_increment,
    guarant nvarchar(255),
    pid int(11),
    foreign key (pid) references `product`(id)
 );

create table news(
	id int(11) primary key auto_increment,
    pnews nvarchar(1000)
);

create table ads(
	id int(11) primary key auto_increment,
    img nvarchar(255),
    recoment nvarchar(255),
    textAd nvarchar(255)
);

-- insert Table --
USE mobile;
insert into users(`username`, `password`) values ( "duong", "Duong3112@"), ( "giang", "Duong3112@");
update users set fullName = "giang tung duong", address = "Son La", phoneNumber = 0332123231, email = "alern@gmail.com" where id = 1;
-- select * from users where id = 1;
insert into admins(`name`, `password`) 
values( "administrator", "Admin123@");
use mobile;

-- select * from categoryProduct;
-- select * from `product`;
-- delete table `product` của database mobile;

INSERT INTO `product` (id, productName, productCategoryPath, img, unitPrice, oldPrice, cid, quantity) VALUES
(13, "iPhone 12Promax",  " iPhone / iPhone 13 / iPhone 12Promax", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRQU9rFt3TDJACGVxJh9WATPXsdSfQcOC8bDg&s",99, 100, 4, 11),
(2, "iPhone 13Pro",  " iPhone / iPhone 13 / iPhone 13Pro", "https://tse2.mm.bing.net/th?id=OIP.JJKJX9HOg7CDK__XAcS9eQHaHa&pid=Api&P=0&h=180",99, 100, 3, 12),
(3, "iPhone 13Promax",  " iPhone / iPhone 13 / iPhone 13Promax", "https://tse4.mm.bing.net/th?id=OIP.SIlqrPXqd1EXFISH0j414AHaJx&pid=Api&P=0&h=180",99, 100, 3, 13),
(6, "iPhone 14Pro",  " iPhone / iPhone 14 / iPhone 14Pro", "https://tse4.mm.bing.net/th?id=OIP.oOQbJAq7SRrQZCcOS3gXNgHaHa&pid=Api&P=0&h=180",98, 100, 2, 19),
(7, "iPhone 14Promax",  " iPhone / iPhone 14 / iPhone 14Promax", "https://example.com/iphone15.jpg",990, 1000, 2, 14),
(9, "iPhone 15",  " iPhone / iPhone 15 / iPhone 15", "https://example.com/iphone15pro.jpg",110, 121, 1, 15),
(10, "iPhone 15Plus", " iPhone / iPhone 15 / iPhone 15Plus", "https://example.com/iphone15plus.jpg",130, 120, 1, 16),
(11, "iPhone 15Pro", " iPhone / iPhone 15 / iPhone 15Pro", "https://example.com/iphone15promax256gb.jpg",140, 122, 1, 17),
(12, "iPhone 15Promax ", " iPhone / iPhone 15 / iPhone 15Promax", "https://example.com/iphone15promax512gb.jpg",110, 150, 1, 18);
  --  select * from `product` where productName like '%13%';
-- Select * from `product` where cid =2;
insert into productDetails (
    productId, 
    screenTechnology, 
    screenResolution, 
    glassQuality, 
    screenSize, 
    rearCameraResolution, 
    frontCameraResolution, 
    rearCameraDetails, 
    videoRecordingCapability, 
    cameraFeatures, 
    processor, 
    chip, 
    operatingSystem, 
    ram, 
    mobileNetworkSupport, 
    wifiSupport, 
    bluetoothSupport, 
    gpsSupport, 
    connectivityPorts, 
    batteryCapacity
) values (
    2, 
    'Super AMOLED', 
    '1080 x 2400 pixels', 
    'Gorilla Glass Victus', 
    '6.5 inches', 
    '64 MP', 
    '32 MP', 
    'Quad Camera Setup', 
    '4K@30fps', 
    'OIS, EIS, HDR', 
    'A15 Bionic', 
    '5G', 
    'IOS', 
    '8 GB', 
    '5G', 
    'Wi-Fi 6', 
    'Bluetooth 5.2', 
    'Yes', 
    'USB Type-C', 
    '4,500 mAh'
);

insert into `memory`(id, productId, `memory`)
values (1, 2, "256Gb");

insert into gift(giftName, productId)
values
	("Tặng kèm sạc nhanh 20W", 2),
    ("Tặng kèm cáp sạc Type-C to Lightning", 2),
    ("Tặng kèm tai nghe", 2),
    ("Tặng kèm ốp lưng chống sóc", 2),
    ("Đã có tem niêm phong ốc", 3),
    ("Tặng kèm cường lực", 3);
    
-- SELECT g.* FROM gift g JOIN product p ON g.productId = p.id WHERE p.id = 2;
insert into guarantee(guarant, pid)
values	("Bảo hành 12 tháng",2),
	("Hỗ trợ 1 đổi 1 trong 30 ngày",2);
    
insert into news(pnews)	
values("Tất cả iPhone chính hãng Apple được phân phối tại Mobile Smart đều được nhập trực tiếp từ Công ty TNHH Apple Việt Nam. Mobile Smart là nhà bán lẻ ủy quyền chính thức của Apple tại Việt Nam."),
("Mobile Smart là cửa hàng điện thoại di động hàng đầu, chuyên cung cấp các sản phẩm từ những thương hiệu nổi tiếng trên toàn thế giới. Với cam kết mang đến cho khách hàng sự lựa chọn đa dạng và chất lượng tốt nhất, chúng tôi tự hào là địa chỉ tin cậy để khám phá và mua sắm điện thoại thông minh."),
("Tại Mobile Smart, chúng tôi hiểu rằng điện thoại di động không chỉ là một công cụ liên lạc, mà còn là một phần của phong cách sống và cá nhân hóa. Vì vậy, chúng tôi tập trung vào việc cung cấp các sản phẩm đa dạng từ các thương hiệu hàng đầu như Apple. Bất kể bạn là người yêu công nghệ, người dùng thông minh hay người muốn thể hiện cá nhân, chúng tôi sẽ có một chiếc điện thoại phù hợp với nhu cầu của bạn."),
("Đặc biệt, Mobile Smart không chỉ cung cấp các dòng điện thoại mới nhất, mà còn có sẵn các sản phẩm công nghệ tiên tiến như tai nghe không dây, đồng hồ thông minh, phụ kiện điện thoại và nhiều hơn nữa. Chúng tôi luôn cập nhật những xu hướng công nghệ mới nhất để đáp ứng nhu cầu đa dạng của khách hàng."),
("Tại Mobile Smart, chúng tôi không chỉ chú trọng đến việc cung cấp các sản phẩm chất lượng mà còn cam kết về dịch vụ tuyệt vời. Đội ngũ nhân viên chuyên nghiệp và thân thiện của chúng tôi sẽ luôn sẵn sàng hỗ trợ bạn trong quá trình mua sắm và tư vấn về sản phẩm. Chúng tôi đảm bảo rằng bạn sẽ có trải nghiệm mua sắm thoải mái và hài lòng tại Mobile Smart."),
("Hãy ghé thăm cửa hàng của chúng tôi để khám phá bộ sưu tập điện thoại di động đa dạng và nhận được sự tư vấn chuyên nghiệp từ đội ngũ của chúng tôi. Chúng tôi rất mong được phục vụ bạn và giúp bạn tìm thấy chiếc điệnthoại hoàn hảo cho mình. Xin cảm ơn và hy vọng sớm được đón tiếp bạn tại Mobile Smart!");