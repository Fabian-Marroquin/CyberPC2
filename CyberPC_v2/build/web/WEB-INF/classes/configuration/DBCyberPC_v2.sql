DROP DATABASE IF EXISTS DBCyberPC_v2;
CREATE DATABASE DBCyberPC_v2;

USE DBCyberPC_v2;

CREATE TABLE Cliente(
	NIT bigint not null,
		nombresCliente varchar(150) not null,
			apellidosCliente varchar(150) not null,
				direccionCliente varchar(200) not null,
					telefonoCliente varchar(10) not null,	
						emailCliente varchar(255) not null,
	primary key PK_NIT(NIT)
);

CREATE TABLE Empleado(
	DPIEmpleado bigint not null,
		nombresEmpleado varchar(150) not null,
			telefonoEmpleado varchar(10) not null,
				emailEmpleado varchar(255) not null,
					contrasenaLogin varchar(255) not null,
						fotoPerfil varchar(255), 
	primary key PK_DPIEmpleado(DPIEmpleado)
);

CREATE TABLE TipoProducto(
	codigoTipoProducto int not null auto_increment,
		descripcionTipoProducto varchar(200) not null,
	primary key PK_codigoTipoProducto(codigoTipoProducto)
);

CREATE TABLE Marca(
	codigoMarca int not null auto_increment, 
		descripcionMarca varchar(150) not null,
	primary key PK_codigoMarca(codigoMarca)
);

CREATE TABLE TipoPago(
	codigoTipoPago int not null auto_increment,
		descripcionTipoPago varchar(150) not null,
	primary key PK_codigoTipoPago(codigoTipoPago)
);

CREATE TABLE Sucursal(
	codigoSucursal int not null auto_increment,
		nombreSucursal varchar(150) not null,
			direccionSucursal varchar(200) not null,
	primary key PK_codigoSucursal(codigoSucursal)
);

CREATE TABLE Factura(
	codigoFactura int not null auto_increment,
		fechaFactura date not null,
			NIT bigint not null,
				DPIEmpleado bigint not null,
					codigoTipoPago int not null,
						codigoSucursal int not null,
	primary key PK_codigoFactura(codigoFactura),
	constraint FK_Factura_Cliente foreign key (NIT) references Cliente(NIT),
    constraint FK_Factura_Empleado foreign key (DPIEmpleado) references Empleado(DPIEmpleado),
    constraint FK_Factura_TipoPago foreign key (codigoTipoPago) references TipoPago(codigoTipoPago),
    constraint FK_Factura_Sucursal foreign key (codigoSucursal) references Sucursal(codigoSucursal)
);

CREATE TABLE Producto(
	codigoProducto int not null auto_increment,
		nombreProducto varchar(100) not null,
			stock int not null,
				precioUnitario double not null,
					codigoTipoProducto int not null,
						codigoMarca int not null,
	primary key PK_codigoProducto(codigoProducto),
	constraint FK_Producto_TipoProducto foreign key (codigoTipoProducto) references TipoProducto(codigoTipoProducto),
	constraint FK_Producto_Marca foreign key (codigoMarca) references Marca(codigoMarca)
);

CREATE TABLE DetalleFactura(
	codigoDetalleFactura int not null auto_increment,
		cantidad int not null,
			subtotal double,
				codigoFactura int not null,
					codigoProducto int not null,
	primary key PK_codigoDetalleFactura(codigoDetalleFactura),
	constraint FK_DetalleFactura_Factura foreign key (codigoFactura) references Factura (codigoFactura),
	constraint FK_DetalleFactura_Producto foreign key (codigoProducto) references Producto (codigoProducto) 
);

insert into Cliente(NIT, nombresCliente, apellidosCliente, direccionCliente, telefonoCliente, emailCliente) values(0,'C/F','','Ciudad','','');
insert into Cliente(NIT, nombresCliente, apellidosCliente, direccionCliente, telefonoCliente, emailCliente) values(12345,'Gerson','Aguilar','Zona 11',12345678,'gmatta@outlook.com');
insert into Cliente(NIT, nombresCliente, apellidosCliente, direccionCliente, telefonoCliente, emailCliente) values(123456,'Jose','Maldonado','Zona 10',12345678,'jestrada@outlook.com');
insert into Cliente(NIT, nombresCliente, apellidosCliente, direccionCliente, telefonoCliente, emailCliente) values(1234567,'Miguel','Sandoval','Zona 9',12345678,'mgonzales@outlook.com');

insert into Empleado(DPIEmpleado, nombresEmpleado, telefonoEmpleado, emailEmpleado, contrasenaLogin, fotoPerfil) values(2021002230, 'Gerson Matta', '57841073', 'gmatta@cyberpc.com', '223','./img/fotosPerfil/gmatta.jpeg');
insert into Empleado(DPIEmpleado, nombresEmpleado, telefonoEmpleado, emailEmpleado, contrasenaLogin, fotoPerfil) values(2021002200, 'Mynor Mogue', '49528631', 'mmogue@cyberpc.com', '220','./img/fotosPerfil/mmogue.png');
insert into Empleado(DPIEmpleado, nombresEmpleado, telefonoEmpleado, emailEmpleado, contrasenaLogin, fotoPerfil) values(2018004820, 'Fabien Marroquin', '49906317', 'fmarroquin@cyberpc.com', '218','./img/fotosPerfil/fmarroquin.jpeg');
insert into Empleado(DPIEmpleado, nombresEmpleado, telefonoEmpleado, emailEmpleado, contrasenaLogin, fotoPerfil) values(2018004950, 'Josué Pérez', '54793220', 'jperez@cyberpc.com', '495','./img/fotosPerfil/jperez.jpeg');
insert into Empleado(DPIEmpleado, nombresEmpleado, telefonoEmpleado, emailEmpleado, contrasenaLogin, fotoPerfil) values(2018001400, 'Diego Monzón', '35124405', 'dmonzon@cyberpc.com', '140','./img/fotosPerfil/dmonzon.jpeg');
insert into Empleado(DPIEmpleado, nombresEmpleado, telefonoEmpleado, emailEmpleado, contrasenaLogin, fotoPerfil) values(2021001580, 'Marcos Orellana', '51156466', 'morellana@cyberpc.com', '158','./img/fotosPerfil/morellana.jpeg');
insert into Empleado(DPIEmpleado, nombresEmpleado, telefonoEmpleado, emailEmpleado, contrasenaLogin, fotoPerfil) values(2021001630, 'Gabriel Pinzón', '50207724', 'gpinzon@cyberpc.com', '163','./img/fotosPerfil/gpinzon.jpeg');
insert into Empleado(DPIEmpleado, nombresEmpleado, telefonoEmpleado, emailEmpleado, contrasenaLogin, fotoPerfil) values(2021001860, 'José Morales', '41305658', 'jmorales@cyberpc.com', '186','./img/fotosPerfil/jmorales.jpeg');
insert into Empleado(DPIEmpleado, nombresEmpleado, telefonoEmpleado, emailEmpleado, contrasenaLogin, fotoPerfil) values(2021001340, 'Lius López', '47502132', 'llopez@cyberpc.com', '134','./img/fotosPerfil/llopez.jpeg');
insert into Empleado(DPIEmpleado, nombresEmpleado, telefonoEmpleado, emailEmpleado, contrasenaLogin, fotoPerfil) values(2018005460, 'Dennis Pérez', '42005328', 'dperez@cyberpc.com', '546','./img/fotosPerfil/dperez.jpeg');

SELECT * FROM Empleado WHERE emailEmpleado = 'jperez@cyberpc.com' and contrasenaLogin = 495;

-- delete from Empleado where DPIEmpleado = 111111111;
-- select * from Empleado;

insert into TipoProducto(descripcionTipoProducto) values('Computadora');
insert into TipoProducto(descripcionTipoProducto) values('Television');
insert into TipoProducto(descripcionTipoProducto) values('Cables');

insert into Marca(descripcionMarca) values ('Dell');
insert into Marca(descripcionMarca) values ('HP');
insert into Marca(descripcionMarca) values ('Asus');

insert into TipoPago(descripcionTipoPago) values('Efectivo');
insert into TipoPago(descripcionTipoPago) values('Tarjeta de Crédito');
insert into TipoPago(descripcionTipoPago) values('Tarjeta de Débito');

insert into Sucursal(nombreSucursal, direccionSucursal) values ('Sucursal Dos','Zona 10');
insert into Sucursal(nombreSucursal, direccionSucursal) values ('Sucursal Tres','Zona 11');
insert into Sucursal(nombreSucursal, direccionSucursal) values ('Sucursal Cuatro','Zona 1');

insert into Factura(fechaFactura, NIT, DPIEmpleado, codigoTipoPago, codigoSucursal) values ('2022-09-01',12345,2021002230,1,1);
insert into Factura(fechaFactura, NIT, DPIEmpleado, codigoTipoPago, codigoSucursal) values ('2022-09-01',123456,2018004950,1,2);
insert into Factura(fechaFactura, NIT, DPIEmpleado, codigoTipoPago, codigoSucursal) values ('2022-09-01',1234567,2021001340,1,3);

insert into Producto(nombreProducto, stock, precioUnitario, codigoTipoProducto, codigoMarca) values ('Televisor de 40"',12,15000.65,2,1);
insert into Producto(nombreProducto, stock, precioUnitario, codigoTipoProducto, codigoMarca) values ('Televisor de 50"',11,16000.65,2,1);
insert into Producto(nombreProducto, stock, precioUnitario, codigoTipoProducto, codigoMarca) values ('Televisor de 60"',10,17000.65,2,1);

DELIMITER //
	CREATE TRIGGER tr_DetalleFactura_After_Insert
		AFTER INSERT ON DetalleFactura
			FOR EACH ROW
		BEGIN
			UPDATE Producto P
				SET P.stock = P.stock - new.cantidad
			WHERE P.codigoProducto = new.codigoProducto;
        END//
DELIMITER ;

SELECT * FROM Producto;

insert into DetalleFactura(cantidad, subtotal, codigoFactura, codigoProducto) values(2,2*15000.65,1,1);
insert into DetalleFactura(cantidad, subtotal, codigoFactura, codigoProducto) values (3,3*16000.65,2,2);
insert into DetalleFactura(cantidad, subtotal, codigoFactura, codigoProducto) values (4,4*17000.65,3,3);

-- select 2,(2 * P.precioUnitario),1,1 FROM Producto P WHERE P.codigoProducto = 1;

-- SELECT * FROM Producto;
-- SELECT D.codigoDetalleFactura, D.cantidad, D.codigoFactura, D.codigoProducto, subtotal FROM DetalleFactura D INNER JOIN Producto P 
-- ON D.codigoProducto = P.codigoProducto;
-- select sum(subtotal) From DetalleFactura;

-- SELECT * FROM DetalleFactura WHERE codigoFactura =1;

 select * FROM DetalleFactura;
-- select * FROM Cliente;
-- SELECT *,concat(C.nombresCliente,' ',C.apellidosCliente),sum(D.subtotal) FROM DetalleFactura D INNER JOIN Producto P ON D.codigoProducto = P.codigoProducto INNER JOIN Marca M ON P.codigoMarca = M.codigoMarca INNER JOIN TipoProducto T ON P.codigoTipoProducto = T.codigoTipoProducto INNER JOIN Factura F ON D.codigoFactura = F.codigoFactura INNER JOIN Cliente C ON F.NIT = C.NIT INNER JOIN Empleado E ON F.DPIEmpleado = E.DPIEmpleado INNER JOIN TipoPago TP ON F.codigoTipoPago = TP.codigoTipoPago WHERE D.codigoFactura = 1;

-- select *, concat(C.nombresCliente,' ',C.apellidosCliente) as NombreCliente From DetalleFactura D INNER JOIN Factura F ON D.codigoFactura = F.codigoFactura INNER JOIN Cliente C ON F.NIT = C.NIT INNER JOIN Empleado E ON F.DPIEmpleado = E.DPIEmpleado INNER JOIN Producto P ON D.codigoProducto = P.codigoProducto INNER JOIN TipoPago T ON F.codigoTipoPago = T.codigoTipoPago INNER JOIN TipoProducto G ON P.codigoTipoProducto = G.codigoTipoProducto INNER JOIN Marca M ON P.codigoMarca = M.codigoMarca WHERE D.codigoFactura = 1;

 select * from empleado;
 select * from factura;