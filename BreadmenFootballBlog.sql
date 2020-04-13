drop database if exists BreadmenFootballBlog;

create database BreadmenFootballBlog;

use BreadmenFootballBlog;

create table users(
	`id` int primary key auto_increment,
	username varchar(30) not null unique,
	`password` varchar(100) not null,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    email varchar(50) not null,
    phone varchar(50),
	enabled boolean not null);

create table roles(
	id int primary key auto_increment,
	`role` varchar(30) not null
);

create table user_roles(
	user_id int not null,
	role_id int not null,
	primary key(`user_id`,`role_id`),
	foreign key (`user_id`) references users(id),
	foreign key (`role_id`) references roles(id)
);

create table Contributors(
	contributor_id int primary key auto_increment,
    `name` varchar(50) not null
);

Create table articles(
	article_id int primary key auto_increment,
    title varChar(50) not null,
    content mediumtext,
	user_id int not null,
    foreign key (user_id) references users(id)
);

create table tags(
	tag_id int primary key auto_increment,
    `name` varchar(30) not null
);

create table article_tags(
	tag_id int not null,
    article_id int not null,
    foreign key (tag_id) references tags(tag_id),
    foreign key (article_id) references articles(article_id)
);

create table comments(
	comment_id int primary key auto_increment,
    content varchar(2000) not null,
    article_id int not null,
    user_id int not null,
    foreign key (article_id) references articles(article_id),
    foreign key (user_id) references users(id)
);

create table reports(
	report_id int Primary Key not null auto_increment,
	user_complaint varchar(1000) not null,
	user_id int not null,
	article_id int,
	comment_id int,
	foreign key (`user_id`) references users(id),
	foreign key (article_id) references articles(article_id),
	foreign key (comment_id) references comments(comment_id)
);

Create table user_contributors(
	user_id int not null,
	contributor_id int not null,
	foreign key (`user_id`) references users(id),
	foreign key (contributor_id) references contributors(contributor_id)
);


insert into users(username,`password`,first_name, last_name, email, enabled) values
	("sryan", "$2a$10$2moI2Qphuq5fVuXi7lim5u7lWP1GV40hCd6zTJIRGdz2TAyKJ0/76", "steve", "ryan", "sryan380@gmail.com", 1),
	("admin", "$2a$10$.eqOOp7lmvwb8lJ5Lbsj8.5GxYvslO3KiQZTIcu1XH3r5FOSRxieu", "admin", "admin", "admin@gmail.com", 1),
    ("dave", "$2a$10$2moI2Qphuq5fVuXi7lim5u7lWP1GV40hCd6zTJIRGdz2TAyKJ0/76", "dave", "steffes", "dave@gmail.com", 1),
    ("rodney","$2a$10$2moI2Qphuq5fVuXi7lim5u7lWP1GV40hCd6zTJIRGdz2TAyKJ0/76", "rodney", "breadman", "breadman@gmail.com", 1),
    ("bvance","$2a$10$2moI2Qphuq5fVuXi7lim5u7lWP1GV40hCd6zTJIRGdz2TAyKJ0/76", "ben", "vance", "bvance@gmail.com", 1);

insert into roles(`role`) values
	("ROLE_ADMIN"), 
	("ROLE_USER"),
    ("ROLE_CONTRIBUTOR");
    
insert into user_roles(user_id, role_id) values
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

 