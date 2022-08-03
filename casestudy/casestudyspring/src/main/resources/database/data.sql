use furamaspring;
insert into customer_type (customer_type_name) values
                              ('Diamond'),
                              ('Platinium'),
                              ('Gold'),
                              ('Silver'),
                              ('Member');
insert into customer(address,birthday,email,gender,id_card,`name`,phone,`status`,customer_type_id) value
('Da Nang','1996-08-08','cuong@gmail.com',1,222222222,'Tieu Cuong',090333333,0,3),
('Quang Nam','1994-01-01','luan@gmail.com',1,4444444,'Tieu Luan',090888888,0,2),
('Da Lat','2000-02-04','my@gmail.com',0,5555555,'My',090789789,0,2),
('Da Nang','1999-09-09','hao@gmail.com',0,3333333,'Hoang Hao',090222222222,0,2);

INSERT INTO position (`name`) values 
('Quản li 1'),
('Quản li 2'),
('nhân viên 1');

INSERT INTO education_degree (`name`) VALUE 
 ('Đại học'),
 ('cao đẳng'),
 ('Trung cấp');

 INSERT INTO division (`name`) VALUE
('hành chính'),
('làm nhân viên'),
('làm full time');
INSERT INTO `role`(role_name) VALUE 
('Admin'),
('nhân viên thường');

INSERT INTO `user`(username,pass_word) VALUE
('duytrung123','111' ),
('luuhoa0801','222' );

SET FOREIGN_KEY_CHECKS=0;
INSERT INTO user_role(role_id,user_name) VALUE
(1,2),
(2,1);
SET FOREIGN_KEY_CHECKS=1;

INSERT INTO employee(date_of_birth,email,id_card,`name`,phone,salary,`status`,division_id,education_degree_id,position_id,username) VALUE
('1994-04-14','nguyenvana@gmail.com','111111111','Nguyen Van A','0978654111',10000.0,0,1,2,1,'duytrung123'),
('1997-07-18','huongvanb@gmail.com','222222222','Huong Van B','0978652222',20000.0,0,2,3,2,'luuhoa0801')
;
insert into facility_type (`name`) value
('Villa'),
('House'),
('Room');
insert into rent_type (`name`) value
('giờ'),
('ngày'),
('tháng'),
('năm');
insert into facility (area,cost,description_other_convenience,facility_free,max_people,`name`,number_of_floors,pool_area,standard_room,`status`,facility_type_id,rent_type_id) value
(1,111.0,'mo ta khac','nuoc uong',5,'du lich',3,10.0,'thuong',0,1,1),
(2,222.0,'mo ta nay','do an',3,'nghi duong',4,20.0,'vip',0,2,2);


