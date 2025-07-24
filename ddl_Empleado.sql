CREATE TABLE empleado
(
    id                BIGINT AUTO_INCREMENT NOT NULL,
    nombres           VARCHAR(255)          NULL,
    apellidos         VARCHAR(255)          NULL,
    tipo_documento    VARCHAR(255)          NULL,
    numero_documento  VARCHAR(255)          NULL,
    fecha_nacimiento  datetime              NULL,
    fecha_vinculacion datetime              NULL,
    cargo             VARCHAR(255)          NULL,
    salario           DOUBLE                NULL,
    CONSTRAINT pk_empleado PRIMARY KEY (id)
);