DROP DATABASE IF EXISTS DBCyberPC_v2;
CREATE DATABASE DBCyberPC_v2;

USE DBCyberPC_v2;

CREATE TABLE Cliente(
	NIT int not null auto_increment,
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
			NIT int not null,
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

insert into Cliente (nombresCliente, apellidosCliente, direccionCliente, telefonoCliente, emailCliente) values ('Pedrito','Weapons','Zona kina','1234567890','pedrito@gmail.com');
insert into Empleado(DPIEmpleado, nombresEmpleado, telefonoEmpleado, emailEmpleado, contrasenaLogin) values ('1234556','Marvin Daniel','123456789','md@gmail.com','123');
insert into TipoProducto(descripcionTipoProducto) values ('Esta en perfecto estado');
insert into Marca(descripcionMarca) values ('Dell');
insert into TipoPago(descripcionTipoPago) values ('Paypal');
insert into Sucursal(nombreSucursal, direccionSucursal) values ('CyberPc Peri','Zona 7');
insert into Factura(fechaFactura, NIT, DPIEmpleado,codigoTipoPago,codigoSucursal) values ('2022-9-6',1,1234556,1,1);
insert into Producto(nombreProducto, stock, precioUnitario, codigoTipoProducto, codigoMarca) values ('Monitor',10,1000.25,1,1);
insert into DetalleFactura(cantidad, codigoFactura, codigoProducto) values (15,1,1);




