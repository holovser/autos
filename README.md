# autos

## Guide
For recreating a full functionality of the complete system, every microservice has to be started as a separate Maven project. For Catalog, Similarity and Creation microservice a MySql database has to be established. The create scripts for all microservices are shown below. After that all microservices has to be wired with their data sources.

The order of starting individual services: Discovery Server, All microservices except Gateway, Gateway microservice

### Catalog, Similarity and Creation data source create script 

create schema catalog collate utf8mb4_0900_ai_ci;

create table Author
(
	authorID int not null
		primary key,
	name varchar(45) not null,
	surname varchar(45) not null
);

create table Engine
(
	engine_brand varchar(45) not null,
	engine_model varchar(45) not null,
	engine_volume double not null,
	primary key (engine_brand, engine_model, engine_volume)
);

create table Gearbox
(
	gearbox_brand varchar(45) not null,
	gearbox_model varchar(45) not null,
	gearbox_type varchar(45) not null,
	primary key (gearbox_brand, gearbox_model, gearbox_type)
);

create table Car
(
	carID int not null,
	brand varchar(45) not null,
	model varchar(45) not null,
	Gearbox_gearbox_brand varchar(45) not null,
	Gearbox_gearbox_model varchar(45) not null,
	Gearbox_gearbox_type varchar(45) not null,
	Engine_engine_brand varchar(45) not null,
	Engine_engine_model varchar(45) not null,
	Engine_engine_volume double not null,
	primary key (carID, Gearbox_gearbox_brand, Gearbox_gearbox_model, Gearbox_gearbox_type, Engine_engine_brand, Engine_engine_model, Engine_engine_volume),
	constraint fk_Car_Engine1
		foreign key (Engine_engine_brand, Engine_engine_model, Engine_engine_volume) references Engine (engine_brand, engine_model, engine_volume),
	constraint fk_Car_Gearbox1
		foreign key (Gearbox_gearbox_brand, Gearbox_gearbox_model, Gearbox_gearbox_type) references Gearbox (gearbox_brand, gearbox_model, gearbox_type)
);

create table Advertisement
(
	AdvertisementID int not null
		primary key,
	created datetime null,
	authorID int not null,
	carID int null,
	constraint fk_Advertisement_Author1
		foreign key (authorID) references Author (authorID),
	constraint fk_Advertisement_Car1
		foreign key (carID) references Car (carID)
);

create index fk_Advertisement_Author1_idx
	on Advertisement (authorID);

create index fk_Advertisement_Car1_idx
	on Advertisement (carID);

create index fk_Car_Engine1_idx
	on Car (Engine_engine_brand, Engine_engine_model, Engine_engine_volume);

create index fk_Car_Gearbox1_idx
	on Car (Gearbox_gearbox_brand, Gearbox_gearbox_model, Gearbox_gearbox_type);


### Gateway data source create script

create schema users collate utf8_general_ci;

create table Role
(
	role varchar(100) not null
		primary key
);

create table User
(
	username varchar(100) not null,
	password varchar(100) not null,
	Role_role varchar(100) not null,
	primary key (username, Role_role),
	constraint fk_User_Role
		foreign key (Role_role) references Role (role)
);

create index fk_User_Role_idx
	on User (Role_role);
  
  
### Rating data source create script  
 
create schema rating collate utf8mb4_0900_ai_ci;

create table Engine_rating
(
	brand varchar(255) charset utf8 not null,
	model varchar(255) charset utf8 not null,
	volume double not null,
	rating int null,
	primary key (brand, model, volume)
);

create table Gearbox_rating
(
	brand varchar(255) charset utf8 not null,
	type varchar(255) charset utf8 not null,
	rating int not null,
	model varchar(45) not null,
	primary key (brand, type, model)
);

create table General_car_rating
(
	car_brand varchar(45) not null,
	car_model varchar(45) not null,
	rating int null,
	primary key (car_brand, car_model)
);




