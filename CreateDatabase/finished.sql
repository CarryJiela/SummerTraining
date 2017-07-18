create table finished
(
	uno_A varchar(9) null,
	uno_B varchar(9) null,
	start_point_A int null,
	end_point_A int null,
	start_time_A time null,
	end_time_A time null,
	date_r date null,
	remark_A varchar(50) null,
	remark_B varchar(50) null,
	start_point_B int null,
	end_point_B int null,
	start_time_B time null,
	end_time_B time null
)
;

create index records_userinfo__fk
	on finished (uno_A)
;
