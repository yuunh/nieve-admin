
DELETE FROM member where 1 = 1;
DELETE FROM product where 1 = 1;
DELETE FROM category;
DELETE FROM attachment;

INSERT INTO `member` (`mem_no`, `mem_email`, `mem_name`, `mem_pwd`, `phone`, `address1`, `address2`, `post_no`, `ad_check`, `enroll_date`, `mem_state`) VALUES (1, 'admin01@nieve.com', '관리자', 'admin01', '010-1234-5678', '서울시', '구로구', '01478', 'Y', '2022-11-17', 'Y');
INSERT INTO `category` (`category_no`, `category_name`) VALUES (1, 'Top');
INSERT INTO `category` (`category_no`, `category_name`) VALUES (2, '아우터');
INSERT INTO `attachment` (`file_no`, `upload_date`, `change_name`, `file_path`, `origin_name`, `status`) VALUES (1, '2024-05-07 13:42:41.000000', 'product_1.png', 'upload-dir/product_1.png', 'product_1.png', 'Y');
INSERT INTO `attachment` (`file_no`, `upload_date`, `change_name`, `file_path`, `origin_name`, `status`) VALUES (2, '2024-05-07 13:42:41.000000', 'product_2.png', 'upload-dir/product_2.png', 'product_2.png', 'Y');
INSERT INTO `attachment` (`file_no`, `upload_date`, `change_name`, `file_path`, `origin_name`, `status`) VALUES (3, '2024-05-07 13:42:41.000000', 'product_3.png', 'upload-dir/product_3.png', 'product_3.png', 'Y');
INSERT INTO `attachment` (`file_no`, `upload_date`, `change_name`, `file_path`, `origin_name`, `status`) VALUES (4, '2024-05-07 13:42:41.000000', 'product_4.png', 'upload-dir/product_4.png', 'product_4.png', 'Y');
INSERT INTO `attachment` (`file_no`, `upload_date`, `change_name`, `file_path`, `origin_name`, `status`) VALUES (5, '2024-05-07 13:42:41.000000', 'product_5.png', 'upload-dir/product_5.png', 'product_5.png', 'Y');

INSERT INTO `product` (`product_no`, `product_name`, `product_price`, `product_stock`, `category_no`, `file_no1`, `file_no2`, `file_no3`, `product_state`) VALUES (1, 'Colorful Stylish Shirt', 15000, 26, 1, 2, 3, 1, 'Y');
INSERT INTO `product` (`product_no`, `product_name`, `product_price`, `product_stock`, `category_no`, `file_no1`, `file_no2`, `file_no3`,  `product_state`) VALUES (2, 'Quartz Belt Watch', 35000, 18, 2, 3, 4,  2, 'Y');


DELETE FROM review where 1 = 1;
INSERT INTO review (review_no, file_no, mem_no, product_no, review_title, review_content, review_date, review_star, review_state) VALUES (1, '1', '1', '1', '생각했던 원단재질이 아니라 조금실망스러워요', '55사이즈인 분들에게는 조금넉넉한핏입니다', '2024-05-13', 3, 'Y');
INSERT INTO review (review_no, file_no, mem_no, product_no, review_title, review_content, review_date, review_star, review_state) VALUES (2, '2', '1', '1', '베스트 코디아이템이 될것같습니다', '주줌옷은 좀많이큰편이여서 많이 망설이다가 픽!!! 입어보니 넘만족합니다 적당한여유핏과 가벼운착용감 스판소재', '2024-05-04', 5, 'Y');
INSERT INTO review (review_no, file_no, mem_no, product_no, review_title, review_content, review_date, review_star, review_state) VALUES (3, '3', '1', '1', '작년에 브라운 구입 후 올해는 네이비 구입했어요..', '네이비도 넘 하늘하늘 이뻐요.. 저는 아이보리 조끼랑 같이 입고 출근했어요..@^^@', '2024-04-10', 5, 'Y');
INSERT INTO review (review_no, file_no, mem_no, product_no, review_title, review_content, review_date, review_star, review_state) VALUES (4, '4', '1', '1', '잘입겠슴니다.', '제가 좋아하는 스타일이라 맘설임없이 주문했는데. 원단 고급지고 스타일도 예쁘네요. 약간 오버핏이네요.', '2024-04-01', 5, 'Y');
INSERT INTO review (review_no, file_no, mem_no, product_no, review_title, review_content, review_date, review_star, review_state) VALUES (5, '5', '1', '1', '마음에 듭니다', '옷감이 부드럽고 색상도 환하니 얼굴이 더 밝아 보여서 마음에 듭니다.', '2024-03-13', 5, 'Y');
