
alter session set "_ORACLE_SCRIPT"=true;

create table PRODUCTO(
	CODIGO int not null primary key,
    NOMBRE varchar(120) not null,
    PRECIO decimal(10,2) not null,
    CANTIDAD int not null,
    ESTADO char(1) default '1'
);

CREATE SEQUENCE SEQ_PRODUCTO;

insert into producto(codigo,nombre,precio,cantidad) values	(SEQ_PRODUCTO.nextval, 'Ventilador RECCO',150,2);
insert into producto(codigo,nombre,precio,cantidad) values	(SEQ_PRODUCTO.nextval, 'Mouse Logicht',25,4);
insert into producto(codigo,nombre,precio,cantidad) values	(SEQ_PRODUCTO.nextval, 'Televisor LG 15',800,10);
insert into producto(codigo,nombre,precio,cantidad) values	(SEQ_PRODUCTO.nextval, 'Televisor Panasonic 49',2500,2);

COMMIT;

select codigo, nombre,precio,cantidad,estado from producto;

