drop table if exists mtfile;
create table myfile (
	idx int auto_increment primary key,
	name varchar(50) not null,
	title varchar(200) not null,
	cate varchar(100) ,
	ofile varchar(100) not null,
	sfile varchar(30) net null,
	postdate datetime default current_timestamp not null
	
);