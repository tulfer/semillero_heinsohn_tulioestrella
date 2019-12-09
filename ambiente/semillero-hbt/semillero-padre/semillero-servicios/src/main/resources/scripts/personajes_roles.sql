--@Author: Tulio Estrella
--Se crea la secuenta para autoincrement de personajes (en este caso incrementa en 2) 
create sequence "SEC_PERSONAJE" minvalue 1 start with 1 increment by 2;

--Se crea la tabla personajes con una constraint en pers_estado que solo permite como valor 'ACTIVO' o 'INACTIVO'
--y al final se agrega la columna pers_id como la clave primaria
create table personaje(
 pers_id number(10) not null,
 pers_nombre varchar2(50) not null,
 pers_id_comic number(3) not null,
 pers_estado varchar2(50 char) not null,
 pers_superpoder varchar2(200 char) not null,
 constraint "personaje_estado_CHK" check (pers_estado IN('ACTIVO','INACTIVO')),
 constraint "PK_personaje" PRIMARY KEY (pers_id)
);

--Se modifica la tabla personaje par agregar una foreign key hacia comic
ALTER TABLE personaje
ADD CONSTRAINT "FK_PERSONAJE_ID"
FOREIGN KEY (pers_id_comic)
REFERENCES comic (SCID);

--Se inserta un valor en personaje
INSERT INTO personaje (pers_id, pers_nombre, pers_id_comic,pers_estado,pers_superpoder) VALUES (SEC_PERSONAJE.nextval, 'SUPERMAN',2, 'INACTIVO', 'SUPER FUERZA');

--Confirma la peticion anterior
commit;

--Se altera la tabla añadiendo una constraint que valida que en la columna pers_nombre no se repitan los valores 
ALTER TABLE personaje
ADD CONSTRAINT "pers_unico"
UNIQUE (pers_nombre);

--Se crea la secuenta para la tabla roles autoincrement en 1 
create sequence "SEC_ROL" minvalue 1 start with 1 increment by 1;

--Se crea tabla roles con constraint UNIQUE en la columna rol_nombre para no permitir valores repetidos, luego se agrega la clave primaria en la columna rol_id
create table roles(
 rol_id number(10) not null,
 rol_nombre varchar2(50) not null,
 rol_estado varchar2(50 char) not null,
 constraint "rol_unico" UNIQUE (rol_nombre),
 constraint "PK_rol" PRIMARY KEY (rol_id)
);

--Se altera la tabla agregando constraint en rol_estado para que solo permita valores 'ACTIVO' o 'INACTIVO'
ALTER TABLE roles
ADD CONSTRAINT "roles_estado_CHK"
CHECK (rol_estado IN('ACTIVO','INACTIVO'));

--Se inserta un valor en roles
INSERT INTO roles (rol_id, rol_nombre, rol_estado) VALUES (SEC_ROL.nextval, 'Admin', 'ACTIVO');

--Confirma la peticion anterior
commit;
