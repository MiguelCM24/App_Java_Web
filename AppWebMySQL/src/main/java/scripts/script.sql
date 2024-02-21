create database cur_000134_java_web;

use cur_000134_java_web;

create table PRODUCTO(
	CODIGO int not null auto_increment key,
    NOMBRE varchar(120) not null,
    PRECIO decimal(10,2) not null,
    CANTIDAD int not null,
    ESTADO char(1) default '1'
);

insert into PRODUCTO(nombre,precio,cantidad) values	('Ventilador RECCO',150,2);
insert into PRODUCTO(nombre,precio,cantidad) values	('Mouse Logicht',25,4);
insert into PRODUCTO(nombre,precio,cantidad) values	('Televisor LG 15',800,10);
insert into PRODUCTO(nombre,precio,cantidad) values	('Televisor Panasonic 49',2500,2);

COMMIT;

select codigo, nombre,precio,cantidad,estado from PRODUCTO;

