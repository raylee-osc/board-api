INSERT INTO user(user_id,user_name,user_password,user_tel,user_address,detail_address,created_date) VALUES ("TestUser1","Merry",    "set0000","010-1234-4132","���� ���ʱ� �����8�� 35",            "403ȣ","2023-06-30");
INSERT INTO user(user_id,user_name,user_password,user_tel,user_address,detail_address,created_date) VALUES ("TestUser2","John",     "pwd1234","010-2534-4131","���� ���ʱ� �����ͷ�12�� 18 ���κ���","802ȣ","2023-06-02");
INSERT INTO user(user_id,user_name,user_password,user_tel,user_address,detail_address,created_date) VALUES ("TestUser3","Petter",   "pwd5674","010-3257-5322","���� ���ʱ� �������95�� 19-4",       "301ȣ","2023-06-04");
INSERT INTO user(user_id,user_name,user_password,user_tel,user_address,detail_address,created_date) VALUES ("TestUser4","Ray",      "pwd0122","010-4356-1331","���� ������ �е���12�� 18",           "710ȣ","2023-06-23");
INSERT INTO user(user_id,user_name,user_password,user_tel,user_address,detail_address,created_date) VALUES ("TestUser5","Christina","pwd4678","010-4536-3112","���� ������ ������ 627 ��������",     "410ȣ","2023-06-11");
INSERT INTO user(user_id,user_name,user_password,user_tel,user_address,detail_address,created_date) VALUES ("TestUser6","Chris",    "pwd4556","010-6436-3213","���� ������ ���ַ� 506",              "101ȣ","2023-06-20");
INSERT INTO user(user_id,user_name,user_password,user_tel,user_address,detail_address,created_date) VALUES ("TestUser7","Thomas",   "pwd7983","010-5343-1231","���� ������ �������71�� 24",         "901ȣ","2023-06-25");
INSERT INTO user(user_id,user_name,user_password,user_tel,user_address,detail_address,created_date) VALUES ("TestUser8","Jenny",    "pwd10549","010-5435-3127","���� ��걸 ������30���� 32",       "506ȣ","2023-06-18");
INSERT INTO user(user_id,user_name,user_password,user_tel,user_address,detail_address,created_date) VALUES ("TestUser9","Jack",     "pwd0524","010-4324-4310","���� ��걸 �������14�� 62",         "105ȣ","2023-06-10");
INSERT INTO user(user_id,user_name,user_password,user_tel,user_address,detail_address,created_date) VALUES ("TestUser10","Parker",  "pwd12394","010-6783-6547","���� ��걸 ������� 66",           "1002ȣ","2023-06-14");

INSERT INTO address(address,address_zipcode) VALUES ("서울 서초구 잠원로8길 35","06518");
INSERT INTO address(address,address_zipcode) VALUES ("서울 서초구 나루터로12길 18 수인빌딩","06527");
INSERT INTO address(address,address_zipcode) VALUES ("서울 서초구 강남대로95길 19-4","06530");
INSERT INTO address(address,address_zipcode) VALUES ("서울 강남구 학동로12길 18","06113");
INSERT INTO address(address,address_zipcode) VALUES ("서울 강남구 논현로 627 유현빌딩","06117");
INSERT INTO address(address,address_zipcode) VALUES ("서울 강남구 언주로 506","06152");
INSERT INTO address(address,address_zipcode) VALUES ("서울 강남구 영동대로71길 24","06187");
INSERT INTO address(address,address_zipcode) VALUES ("서울 용산구 대사관로30나길 32","04409");
INSERT INTO address(address,address_zipcode) VALUES ("서울 용산구 독서당로14길 62","04410");
INSERT INTO address(address,address_zipcode) VALUES ("서울 용산구 녹사평대로 66","04398");

INSERT INTO board(board_title,board_contents,write_id,modify_id,write_date,modify_date) VALUES("Test Board Title 1","Test Board Contents","TestUser1","TestUser10","2023-06-22","2023-06-30");
INSERT INTO board(board_title,board_contents,write_id,modify_id,write_date,modify_date) VALUES("Test Board Title 2","Test Board Contents","TestUser2","TestUser9","2023-06-16" ,"2023-06-30");
INSERT INTO board(board_title,board_contents,write_id,modify_id,write_date,modify_date) VALUES("Test Board Title 3","Test Board Contents","TestUser3","TestUser8","2023-06-23" ,"2023-06-30");
INSERT INTO board(board_title,board_contents,write_id,modify_id,write_date,modify_date) VALUES("Test Board Title 4","Test Board Contents","TestUser4","TestUser7","2023-06-13" ,"2023-06-30");
INSERT INTO board(board_title,board_contents,write_id,modify_id,write_date,modify_date) VALUES("Test Board Title 5","Test Board Contents","TestUser5","TestUser6","2023-06-21","2023-06-30");
INSERT INTO board(board_title,board_contents,write_id,write_date) VALUES("Test Board Title 6","Test Board Contents","TestUser6","2023-06-30");
INSERT INTO board(board_title,board_contents,write_id,write_date) VALUES("Test Board Title 7","Test Board Contents","TestUser7","2023-06-30");
INSERT INTO board(board_title,board_contents,write_id,write_date) VALUES("Test Board Title 8","Test Board Contents","TestUser9","2023-06-30");
INSERT INTO board(board_title,board_contents,write_id,write_date) VALUES("Test Board Title 9","Test Board Contents","TestUser9","2023-06-30");
INSERT INTO board(board_title,board_contents,write_id,write_date) VALUES("Test Board Title 10","Test Board Contents","TestUser10","2023-06-30");