DELETE FROM member where 1 = 1;
DELETE FROM product where 1 = 1;
DELETE FROM category;

INSERT INTO `member` (`mem_no`, `mem_email`, `mem_name`, `mem_pwd`, `phone`, `address1`, `address2`, `post_no`, `ad_check`, enroll_date) VALUES (2, 'admin01@nieve.com', '관리자', 'admin01', '010-1234-5678', '서울시', '구로구', '01478', 'Y', '2022-11-17');
INSERT INTO `category` (`category_no`, `category_name`) VALUES (1, 'Top');
INSERT INTO `category` (`category_no`, `category_name`) VALUES (2, '아우터');
INSERT INTO `product` (`product_name`, `product_price`, `product_stock`, `category_no`) VALUES ('Colorful Stylish Shirt', 15000, 26, 1);
--SELECT 1;