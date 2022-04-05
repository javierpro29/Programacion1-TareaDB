Create table agendañ

use agenda;

create table evento(
id int not null auto_increment primary key,
nombre varchar(200),
horario varchar(30),
direccion varchar(200),
cargo varchar(100)
);


select * from evento