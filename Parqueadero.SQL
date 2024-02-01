-- Active: 1693573825264@@127.0.0.1@3306@parqueadero
Create DATABASE Parqueadero;

create table Administrador(
    idadministrador INT AUTO_INCREMENT,
    primerNombre VARCHAR (20) NOT NULL,
    segundoNombre VARCHAR (20) NOT NULL,
    primerApellido VARCHAR(20) NOT NULL,
    segundoApellido Varchar (20) NOT NULL,
    tipoDocumento ENUM ('Cedula Ciudadania', 'PEP','Visa De Trabajo','Cedula Extranjería'),
    numeroIdentificacion VARCHAR (30) NOT NULL,
    CorreoElectronico VARCHAR (70)NOT NULL,
    celular VARCHAR (15) NOT NULL,
    contraseña VARCHAR (20) NOT NULL,
    CONSTRAINT pk_idAdministrador primary Key (idadministrador),
    CONSTRAINT unico_Identi_Admi UNIQUE (numeroIdentificacion));

CREATE TABLE Parqueadero (
    idParqueadero INT AUTO_INCREMENT,
    nit varchar (30) not null,
    razonSocial Varchar (50) not null,
    dirección varchar (50)not null,
    telefono varchar (15) not null,
    idadministrador INT NOT NULL,
    CONSTRAINT Pk_idParqueadero PRIMARY KEY (idParqueadero),
    CONSTRAINT Unico_Nit UNIQUE (nit),
    CONSTRAINT Fk_Admin FOREIGN KEY (idadministrador) REFERENCES Administrador(idadministrador))

    CREATE TABLE TipoVehiculo(
        idTipoVehiculo INT AUTO_INCREMENT,
        Nombre Varchar (15) NOT NULL,
        descripcion VARCHAR(200) NOT NULL,
        idadministrador INT NOT NULL,
        CONSTRAINT Pk_idtipo PRIMARY KEY (idTipoVehiculo),
        CONSTRAINT Fk_admin_tipoVehiculo FOREIGN KEY (idadministrador) REFERENCES Administrador(idadministrador))

      CREATE TABLE Cubiculo (
        idCubiculo INT AUTO_INCREMENT,
        tamaño VARCHAR (30) NOT NULL,
        precioHora DECIMAL (10,2) NOT NULL,
        nomenclaturaUbicación VARCHAR (10) NOT NULL,
         idTipoVehiculo INT NOT NULL,
         CONSTRAINT Pk_idCubiculo primary key (idCubiculo),
         CONSTRAINT Fk_idTipoVehiculo FOREIGN KEY (idTipoVehiculo) REFERENCES TipoVehiculo(idTipoVehiculo)) 


CREATE TABLE Cliente (
    idCliente INT AUTO_INCREMENT,
    primerNombre VARCHAR (20) NOT NULL,
    segundoNombre VARCHAR (20) NOT NULL,
    primerApellido VARCHAR(20) NOT NULL,
    segundoApellido Varchar (20) NOT NULL,
    tipoDocumento ENUM ('Cedula Ciudadania', 'PEP','Visa De Trabajo','Cedula Extranjería', 'Pasaporte','Otro') NOT NULL,
    numeroIdentificacion VARCHAR (30) NOT NULL,
    CorreoElectronico VARCHAR (70)NOT NULL,
    celular VARCHAR (15) NOT NULL,
    contraseña VARCHAR (20) NOT NULL,
    CONSTRAINT Pk_idcliente PRIMARY KEY (idCliente),
    CONSTRAINT unico_Identi_Cliente UNIQUE (numeroIdentificacion));

    CREATE TABLE Vehiculo (
        idVehiculo INT AUTO_INCREMENT,
        placa VARCHAR (10) NOT NULL,
        marca VARCHAR (15) NOT NULL,
        modelo VARCHAR (10) NOT NULL,
        descripcion VARCHAR (70) NOT NULL,
        idCliente INT NOT NULL,
        idTipoVehiculo INT NOT NULL,
        CONSTRAINT Pk_idVehiculo PRIMARY KEY(idVehiculo),
        CONSTRAINT Unico_Placa UNIQUE (placa),
        CONSTRAINT Fk_cliente FOREIGN KEY (idCliente) REFERENCES Cliente (idCliente),
        CONSTRAINT Fk_TipoVehículo  FOREIGN KEY (idTipoVehiculo) REFERENCES TipoVehiculo(idTipoVehiculo))


CREATE TABLE Colaborador(
    idColaborador INT AUTO_INCREMENT,
    primerNombre VARCHAR (20) NOT NULL,
    segundoNombre VARCHAR (20) NOT NULL,
    primerApellido VARCHAR(20) NOT NULL,
    segundoApellido Varchar (20) NOT NULL,
    tipoDocumento ENUM ('Cedula Ciudadania', 'PEP','Visa De Trabajo','Cedula Extranjería'),
    numeroIdentificacion VARCHAR (30) NOT NULL,
    CorreoElectronico VARCHAR (70)NOT NULL,
    celular VARCHAR (15) NOT NULL,
    contraseña VARCHAR (20) NOT NULL,
    salario DECIMAL (12,2) NOT NULL,
    direccion VARCHAR (25) NOT NULL,
    eps VARCHAR (15) NOT NULL,
    fondoPensional VARCHAR(15)NOT NULL,
    arl VARCHAR (15) NOT NULL,
    idParqueadero INT NOT NULL,
    CONSTRAINT Pk_idColaborador PRIMARY KEY (idColaborador),
    CONSTRAINT Unico_identificacionColaborador UNIQUE (numeroIdentificacion),
    CONSTRAINT Fk_idParqueadero FOREIGN KEY (idParqueadero) REFERENCES Parqueadero (idParqueadero))  

    CREATE TABLE Reserva(
        idReserva INT AUTO_INCREMENT,
        fechaAReservar DATE NOT NULL,
        HoraAReservar TIME NOT NULL,
        FechaRealizacionReserva DATETIME NOT NULL,
        chekin BOOLEAN NOT NULL,
        Estado BOOLEAN NOT NULL,
        idVehiculo INT NOT NULL,
        CONSTRAINT Pk_idReserva PRIMARY KEY(idReserva),
        CONSTRAINT Fk_idVehiculo FOREIGN KEY (idVehiculo) REFERENCES Vehiculo(idVehiculo))



    

Create Table Factura (
    numFactura INT AUTO_INCREMENT,
    horaFinalizacionServicio INT NOT NULL,
    minutoFinalizacionServicio INT NOT NULL,
    fechaFacturacion DATE NOT NULL,
    iva decimal (20,2) NOT NULL,
    tiempoFacturado  decimal (10,2) NOT NULL,
    metodoPago ENUM('Efectivo','Tarjeta Credito','Tarjeta Debito') NOT NULL,
    subtotalSinIva DECIMAL(20,2) NOT NULL,
    totalAPagar DECIMAL (20,2) NOT NULL,
    idColaborador INT NOT NULL,
    idReserva INT NOT NULL,
    CONSTRAINT Pk_numFactura PRIMARY KEY (numFactura),
    CONSTRAINT Fk_idColaborador_Factura FOREIGN KEY(idColaborador) REFERENCES Colaborador (idColaborador),
    CONSTRAINT Fk_idReserva_Factura FOREIGN KEY (idReserva) REFERENCES Reserva(idReserva))

    CREATE TABLE ListaDeChequeo(
        idListaChequeo INT AUTO_INCREMENT,
        presentaDaños BOOLEAN NOT NULL,
        descripcion VARCHAR(200) NULL,
        firmaCliente BLOB NOT NULL,
        idReserva INT NOT NULL,
        idColaborador INT NOT NULL,
        CONSTRAINT Pk_idListaChequeo PRIMARY KEY (idListaChequeo),
         CONSTRAINT Fk_idColaborador_ListaChequeo FOREIGN KEY(idColaborador) REFERENCES Colaborador (idColaborador),
         CONSTRAINT Fk_idReserva_ListaChequeo FOREIGN KEY (idReserva) REFERENCES Reserva(idReserva))

    


ALTER TABLE cliente
ADD COLUMN EstadoCliente BOOLEAN NOT NULL;

ALTER TABLE vehiculo
ADD COLUMN EstadoVehiculo TINYINT(1) NOT NULL;

ALTER TABLE tipovehiculo
ADD COLUMN EstadoTipoVehiculo TINYINT(1) NOT NULL;

ALTER TABLE Administrador
ADD COLUMN EstadoAdministrador TINYINT(1) NOT NULL;

ALTER TABLE parqueadero
ADD COLUMN EstadoParqueadero TINYINT(1) NOT NULL;

ALTER TABLE colaborador
ADD COLUMN EstadoColaborador TINYINT(1) NOT NULL;






    
