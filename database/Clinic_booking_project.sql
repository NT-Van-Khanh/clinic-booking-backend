-- CREAT DATABASE CLINIC_BOOKING 
DROP DATABASE IF EXISTS clinic_booking;
CREATE DATABASE clinic_booking
    CHARACTER SET "utf8mb4"
    COLLATE "utf8mb4_unicode_ci";
    
USE clinic_booking;

CREATE TABLE role(
	id SMALLINT PRIMARY KEY  AUTO_INCREMENT,
    name VARCHAR(50) UNIQUE NOT NULL ,
	status VARCHAR(15) NOT NULL CHECK (status IN ('ACTIVE', 'DELETING'))
);  

CREATE TABLE account(
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    role_id SMALLINT NOT NULL,
    status VARCHAR(15) NOT NULL CHECK (status IN ('ACTIVE', 'DELETING')),
    created_at DATETIME NOT NULL DEFAULT NOW(),
    
    FOREIGN KEY (role_id) REFERENCES role(id)
);

CREATE TABLE medical_specialty(
	id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL,
    status VARCHAR(15) NOT NULL CHECK ( status IN ('ACTIVE', 'DELETING')),
    created_at DATETIME NOT NULL DEFAULT NOW()
);

CREATE TABLE doctor(
	id VARCHAR(10) PRIMARY KEY,
    account_id  VARCHAR(50) UNIQUE NOT NULL,
    medical_specialty_id VARCHAR(10) NOT NULL,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(15) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    address VARCHAR(255),
    gender BOOLEAN,
    status VARCHAR(15) NOT NULL CHECK (status in ('ACTIVE', 'DELETING')),
    created_at DATETIME NOT NULL DEFAULT NOW(),
    
    FOREIGN KEY (account_id) REFERENCES account(username),
    FOREIGN KEY (medical_specialty_id) REFERENCES medical_specialty(id)
);
    
CREATE TABLE manager(
	id VARCHAR(10) PRIMARY KEY,
    account_id  VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(15) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    address VARCHAR(255),
    gender BOOLEAN,
    status VARCHAR(15) NOT NULL CHECK (status in ('ACTIVE', 'DELETING')),
    created_at datetime NOT NULL DEFAULT NOW(),
    
    FOREIGN KEY (account_id) REFERENCES account(username)
);  


CREATE TABLE customer(
	id INT PRIMARY KEY  AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL,
    address VARCHAR(255),
    gender BOOLEAN,
    status VARCHAR(15) NOT NULL CHECK (status IN ('ACTIVE', 'DELETING')),
    created_at DATETIME NOT NULL DEFAULT NOW()
);

CREATE TABLE clinic(
	id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    phone CHAR(13) NOT NULL,
    email VARCHAR(255) NOT NULL,
    status VARCHAR(15) NOT NULL CHECK (status IN ('ACTIVE', 'DELETING')),
    created_at DATETIME NOT NULL DEFAULT NOW()
);

CREATE TABLE schedule(
	id VARCHAR(15) PRIMARY KEY,
    doctor_id VARCHAR(10) NOT NULL,
    clinic_id VARCHAR(10) NOT NULL,
    date date NOT NULL,
    time_start time NOT NULL,
    time_end time NOT NULL,
    max_booking SMALLINT NOT NULL,
    status VARCHAR(15) NOT NULL CHECK (status in ('ACTIVE', 'DELETING')),
    created_at datetime NOT NULL DEFAULT NOW(),
    FOREIGN KEY (doctor_id) REFERENCES doctor(id),
    FOREIGN KEY (clinic_id) REFERENCES clinic(id)
);  

CREATE TABLE service(
	id VARCHAR(10) PRIMARY KEY,
    medical_specialty_id VARCHAR(10) NOT NULL,
    creator_id VARCHAR(10) NOT NULL,
    name VARCHAR(100) UNIQUE NOT NULL,
	description TEXT,
    status VARCHAR(15) NOT NULL CHECK (status in ('ACTIVE', 'DELETING')),
    created_at DATETIME NOT NULL DEFAULT NOW(),
    
    FOREIGN KEY (creator_id) REFERENCES manager(id),
    FOREIGN KEY (medical_specialty_id) REFERENCES medical_specialty(id)
);

CREATE TABLE appointment(
	id INT PRIMARY KEY AUTO_INCREMENT,
    service_id VARCHAR(10) NOT NULL,
    schedule_id VARCHAR(15) NOT NULL,
    customer_id INT NOT NULL,
    numerical_order SMALLINT NOT NULL CHECK (numerical_order > 0),
    note VARCHAR(255) NOT NULL,
    status VARCHAR(15) NOT NULL CHECK (status in ('PENDING', 'CONFIRMED', 'IN_PROGRESS' , 'COMPLETED', 'CANCELLED', 'NO_SHOW', 'DELETING')),
    updated_at DATETIME DEFAULT NULL,
    updated_by VARCHAR(50) DEFAULT NULL,
    created_at DATETIME NOT NULL DEFAULT NOW(),
    
    UNIQUE (customer_id, schedule_id),
    FOREIGN KEY (schedule_id) REFERENCES schedule(id),
    FOREIGN KEY (service_id) REFERENCES service(id),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);


