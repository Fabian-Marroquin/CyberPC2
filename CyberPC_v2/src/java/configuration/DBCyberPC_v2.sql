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
			codigoFactura int not null,
				codigoProducto int not null,
	primary key PK_codigoDetalleFactura(codigoDetalleFactura),
	constraint FK_DetalleFactura_Factura foreign key (codigoFactura) references Factura (codigoFactura),
	constraint FK_DetalleFactura_Producto foreign key (codigoProducto) references Producto (codigoProducto) 
);

insert into Cliente(NIT, nombresCliente, apellidosCliente, direccionCliente, telefonoCliente, emailCliente) values(12345,'Gerson','Aguilar','Zona 11',12345678,'gmatta@outlook.com');
insert into Cliente(NIT, nombresCliente, apellidosCliente, direccionCliente, telefonoCliente, emailCliente) values(123456,'Jose','Maldonado','Zona 10',12345678,'jestrada@outlook.com');
insert into Cliente(NIT, nombresCliente, apellidosCliente, direccionCliente, telefonoCliente, emailCliente) values(1234567,'Miguel','Sandoval','Zona 9',12345678,'mgonzales@outlook.com');

insert into Empleado(DPIEmpleado, nombresEmpleado, telefonoEmpleado, emailEmpleado, contrasenaLogin) values(123456789, 'Gerson Aarón Matta Aguilar', '12345678', 'gmatta@gmail.com', '223');
insert into Empleado(DPIEmpleado, nombresEmpleado, telefonoEmpleado, emailEmpleado, contrasenaLogin) values(111111111, 'Mynor Mogue', '12345678', 'mmogue@gmail.com', '220');
insert into Empleado(DPIEmpleado, nombresEmpleado, telefonoEmpleado, emailEmpleado, contrasenaLogin) values(222222222, 'Fabian Marroquin', '12345678', 'fmarroquin@gmail.com', '218');

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

insert into Factura(fechaFactura, NIT, DPIEmpleado, codigoTipoPago, codigoSucursal) values ('2022-09-01',12345,123456789,1,1);
insert into Factura(fechaFactura, NIT, DPIEmpleado, codigoTipoPago, codigoSucursal) values ('2022-09-01',123456,123456789,1,2);
insert into Factura(fechaFactura, NIT, DPIEmpleado, codigoTipoPago, codigoSucursal) values ('2022-09-01',1234567,123456789,1,3);

insert into Producto(nombreProducto, stock, precioUnitario, codigoTipoProducto, codigoMarca) values ('Televisor de 40"',12,15000.65,2,1);
insert into Producto(nombreProducto, stock, precioUnitario, codigoTipoProducto, codigoMarca) values ('Televisor de 50"',11,16000.65,2,1);
insert into Producto(nombreProducto, stock, precioUnitario, codigoTipoProducto, codigoMarca) values ('Televisor de 60"',10,17000.65,2,1);

insert into DetalleFactura(cantidad, codigoFactura, codigoProducto) values (2,1,1);
insert into DetalleFactura(cantidad, codigoFactura, codigoProducto) values (3,2,2);
insert into DetalleFactura(cantidad, codigoFactura, codigoProducto) values (4,3,3);