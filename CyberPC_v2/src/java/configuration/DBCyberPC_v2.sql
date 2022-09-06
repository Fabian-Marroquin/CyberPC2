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
		descripcionTipoProsucto varchar(200) not null,
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
	primary key PK_codigoFactura(codigoFactura),
	constraint FK_Factura_Cliente foreign key (NIT) references Cliente(NIT),
    constraint FK_Factura_Empleado foreign key (DPIEmpleado) references Empleado(DPIEmpleado)    
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