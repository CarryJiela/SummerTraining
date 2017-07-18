-- auto-generated definition
create table userinfo
(
	uno varchar(9) not null
		primary key,
	uname varchar(20) null,
	age int(3) null,
	phone int null,
	sex varchar(2) null,
	nickname varchar(20) null,
	password varchar(20) null,
	email varchar(50) null,
	exp int(20) null,
	img_addr varchar(20) null,
	register_date date null,
	constraint userinfo_uno_uindex
		unique (uno),
	constraint userinfo_nickname_uindex
		unique (nickname)
)
;
