create table t_file (
    id int not null auto_increment primary key,
    name varchar(100),
    type varchar(50),
    backup boolean,
    content varchar(200)
);