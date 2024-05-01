DELETE FROM product where 1 = 1;
INSERT INTO `product` (`product_name`, `product_price`) VALUES ('Colorful Stylish Shirt', 150);
INSERT INTO `member` (`mem_no`, `mem_email`, `mem_name`, `mem_pwd`, `phone`, `address1`, `address2`, `post_no`, `ad_check`, enroll_date) VALUES (1, 'admin01@nieve.com', '관리자', 'admin01', '010-1234-5678', '서울시', '구로구', '01478', 'Y', to_date('22/11/17','RR/MM/DD'));