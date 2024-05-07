DELETE FROM member where 1 = 1;
DELETE FROM product where 1 = 1;
DELETE FROM category;

INSERT INTO `member` (`mem_no`, `mem_email`, `mem_name`, `mem_pwd`, `phone`, `address1`, `address2`, `post_no`, `ad_check`, enroll_date) VALUES (2, 'admin01@nieve.com', '관리자', 'admin01', '010-1234-5678', '서울시', '구로구', '01478', 'Y', '2022-11-17');
INSERT INTO `category` (`category_no`, `category_name`) VALUES (1, 'Top');
INSERT INTO `category` (`category_no`, `category_name`) VALUES (2, '아우터');
INSERT INTO `attachment` (`file_no`, `upload_date`, `change_name`, `file_path`, `origin_name`, `status`) VALUES (1, '2024-05-07 13:42:41.000000', 'product_1.png', 'upload-dir/product_1.png', 'product_1.png', 'Y');
INSERT INTO `attachment` (`file_no`, `upload_date`, `change_name`, `file_path`, `origin_name`, `status`) VALUES (2, '2024-05-07 13:42:41.000000', 'product_2.png', 'upload-dir/product_2.png', 'product_2.png', 'Y');
INSERT INTO `attachment` (`file_no`, `upload_date`, `change_name`, `file_path`, `origin_name`, `status`) VALUES (3, '2024-05-07 13:42:41.000000', 'product_3.png', 'upload-dir/product_3.png', 'product_3.png', 'Y');
INSERT INTO `attachment` (`file_no`, `upload_date`, `change_name`, `file_path`, `origin_name`, `status`) VALUES (4, '2024-05-07 13:42:41.000000', 'product_4.png', 'upload-dir/product_4.png', 'product_4.png', 'Y');
INSERT INTO `attachment` (`file_no`, `upload_date`, `change_name`, `file_path`, `origin_name`, `status`) VALUES (5, '2024-05-07 13:42:41.000000', 'product_5.png', 'upload-dir/product_5.png', 'product_5.png', 'Y');

INSERT INTO `product` (`product_name`, `product_price`, `product_stock`, `category_no`, `file_no`) VALUES ('Colorful Stylish Shirt', 15000, 26, 1, 1);
--SELECT 1;