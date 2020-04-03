drop database if exists securityDBforATeam;

create database securityDBforATeam;

use securityDBforATeam;

create table `user`(
`id` int primary key auto_increment,
username varchar(30) not null unique,
`password` varchar(100) not null,
enabled boolean not null);

create table `role`(
id int primary key auto_increment,
`role` varchar(30) not null
);

create table `user_role`(
user_id int not null,
role_id int not null,
primary key(`user_id`,`role_id`),
foreign key (`user_id`) references `user`(id),
foreign key (`role_id`) references `role`(id));

Create table article(
article_id int auto_increment,
author varchar(50) not null
);

Create table user_contributor(
user_id int not null,
contributor_id int not null,

foreign key (`user_id`) references `user`(id),
foreign key (contributor_id) references contributor (contributor_id)
);




insert into `user`(username,`password`,enabled) values
	("sryan", "$2a$10$2moI2Qphuq5fVuXi7lim5u7lWP1GV40hCd6zTJIRGdz2TAyKJ0/76" , 1),
	("admin", "$2a$10$2moI2Qphuq5fVuXi7lim5u7lWP1GV40hCd6zTJIRGdz2TAyKJ0/76", 1),
    ("dave", "$2a$10$2moI2Qphuq5fVuXi7lim5u7lWP1GV40hCd6zTJIRGdz2TAyKJ0/76",1),
    ("rodney","$2a$10$2moI2Qphuq5fVuXi7lim5u7lWP1GV40hCd6zTJIRGdz2TAyKJ0/76",1),
    ("bvance","$2a$10$2moI2Qphuq5fVuXi7lim5u7lWP1GV40hCd6zTJIRGdz2TAyKJ0/76", 1);

insert into `role`(`role`) values
	("ROLE_ADMIN"), 
	("ROLE_USER");
    
insert into `user_role`(user_id, role_id) values
	(1,1),
    (1,2),
    (2,1),
    (2,2),
    (3,1),
    (3,2),
    (4,1),
    (4,2),
    (5,1),
    (5,2);

 