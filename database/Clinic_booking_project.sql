-- CREAT DATABASE CLINIC_BOOKING 
DROP DATABASE IF EXISTS clinic_booking;
CREATE DATABASE clinic_booking
    CHARACTER SET "utf8mb4"
    COLLATE "utf8mb4_unicode_ci";
    
USE clinic_booking;

CREATE TABLE role(
	id SMALLINT PRIMARY KEY  AUTO_INCREMENT,
    name VARCHAR(50) UNIQUE NOT NULL ,
	status VARCHAR(15) NOT NULL CHECK (status IN ('ACTIVE', 'DELETED'))
);  

CREATE TABLE account(
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    role_id SMALLINT NOT NULL,
    status VARCHAR(15) NOT NULL CHECK (status IN ('ACTIVE', 'BLOCKED', 'DELETED')),
    created_at DATETIME NOT NULL DEFAULT NOW(),
    
    FOREIGN KEY (role_id) REFERENCES role(id)
);

CREATE TABLE medical_specialty(
	id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL,
    description TEXT,
    status VARCHAR(15) NOT NULL CHECK ( status IN ('ACTIVE', 'DELETED')),
    created_at DATETIME NOT NULL DEFAULT NOW()
);

CREATE TABLE doctor(
	id VARCHAR(10) PRIMARY KEY,
    account_id  VARCHAR(50) UNIQUE NOT NULL,
    medical_specialty_id VARCHAR(10) NOT NULL,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(15) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    birthday DATE NOT NULL,
    gender BOOLEAN NOT NULL,
    address VARCHAR(255),
    qualification TEXT,
    description TEXT,
    image_link VARCHAR(255),
    status VARCHAR(15) NOT NULL CHECK (status in ('ACTIVE', 'DELETED')),
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
    status VARCHAR(15) NOT NULL CHECK (status in ('ACTIVE', 'DELETED')),
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
    status VARCHAR(15) NOT NULL CHECK (status IN ('ACTIVE', 'DELETED')),
    created_at DATETIME NOT NULL DEFAULT NOW()
);

CREATE TABLE clinic(
	id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    phone CHAR(13) NOT NULL,
    email VARCHAR(255) NOT NULL,
    status VARCHAR(15) NOT NULL CHECK (status IN ('ACTIVE', 'DELETED')),
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
    status VARCHAR(15) NOT NULL CHECK (status in ('ACTIVE', 'ONGOING', 'DELETED', 'UPCOMING', 'PAUSED','EXPIRED', 'CANCELED' )),
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
    status VARCHAR(15) NOT NULL CHECK (status in ('ACTIVE', 'DELETED')),
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
    status VARCHAR(15) NOT NULL CHECK (status in ('PENDING', 'CONFIRMED', 'IN_PROGRESS' , 'COMPLETED', 'CANCELLED', 'NO_SHOW', 'DELETED')),
    updated_at DATETIME DEFAULT NULL,
    updated_by VARCHAR(50) DEFAULT NULL,
    created_at DATETIME NOT NULL DEFAULT NOW(),
    
    UNIQUE (customer_id, schedule_id),
    FOREIGN KEY (schedule_id) REFERENCES schedule(id),
    FOREIGN KEY (service_id) REFERENCES service(id),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE email_otp(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(100) NOT NULL,
    otp VARCHAR(6) NOT NULL,
    created_at DATETIME NOT NULL DEFAULT NOW(),
    expire_at DATETIME NOT NULL,
    is_verified BOOLEAN  NOT NULL DEFAULT FALSE,
    purpose VARCHAR(15) NOT NULL CHECK (purpose IN ('ACCOUNT_VERIFY', 'APPOINTMENT'))
);

INSERT INTO role(name,status) VALUES
('ADMIN', 'ACTIVE'),
('MANAGER', 'ACTIVE'),
('DOCTOR', 'ACTIVE');

INSERT INTO account(username, password, role_id, status) VALUES
('admin1', '$2a$10$EzDLzuQ3s2nhRUjIp/lDieVFG8Nx/dAuxGT.d/A9h366yusDUzazm', 3, 'ACTIVE'),
('manager1', '$2a$10$EzDLzuQ3s2nhRUjIp/lDieVFG8Nx/dAuxGT.d/A9h366yusDUzazm', 2, 'ACTIVE'),
('doctor0', '$2a$10$EzDLzuQ3s2nhRUjIp/lDieVFG8Nx/dAuxGT.d/A9h366yusDUzazm', 3, 'BLOCKED'),
('doctor1', '$2a$10$EzDLzuQ3s2nhRUjIp/lDieVFG8Nx/dAuxGT.d/A9h366yusDUzazm', 3, 'ACTIVE'),
('doctor2', '$2a$10$EzDLzuQ3s2nhRUjIp/lDieVFG8Nx/dAuxGT.d/A9h366yusDUzazm', 3, 'ACTIVE'),
('doctor3', '$2a$10$EzDLzuQ3s2nhRUjIp/lDieVFG8Nx/dAuxGT.d/A9h366yusDUzazm', 3, 'ACTIVE'),
('doctor4', '$2a$10$EzDLzuQ3s2nhRUjIp/lDieVFG8Nx/dAuxGT.d/A9h366yusDUzazm', 3, 'ACTIVE'),
('doctor5', '$2a$10$EzDLzuQ3s2nhRUjIp/lDieVFG8Nx/dAuxGT.d/A9h366yusDUzazm', 3, 'ACTIVE'),
('doctor6', '$2a$10$EzDLzuQ3s2nhRUjIp/lDieVFG8Nx/dAuxGT.d/A9h366yusDUzazm', 3, 'ACTIVE'),
('doctor7', '$2a$10$EzDLzuQ3s2nhRUjIp/lDieVFG8Nx/dAuxGT.d/A9h366yusDUzazm', 3, 'ACTIVE'),
('doctor8', '$2a$10$EzDLzuQ3s2nhRUjIp/lDieVFG8Nx/dAuxGT.d/A9h366yusDUzazm', 3, 'ACTIVE'),
('doctor9', '$2a$10$EzDLzuQ3s2nhRUjIp/lDieVFG8Nx/dAuxGT.d/A9h366yusDUzazm', 3, 'ACTIVE'),
('doctor10', '$2a$10$EzDLzuQ3s2nhRUjIp/lDieVFG8Nx/dAuxGT.d/A9h366yusDUzazm', 3, 'ACTIVE'),
('doctor11', '$2a$10$EzDLzuQ3s2nhRUjIp/lDieVFG8Nx/dAuxGT.d/A9h366yusDUzazm', 3, 'ACTIVE'),
('doctor12', '$2a$10$EzDLzuQ3s2nhRUjIp/lDieVFG8Nx/dAuxGT.d/A9h366yusDUzazm', 3, 'ACTIVE');

INSERT INTO medical_specialty(id, name, description, status) VALUES
('MS01', 'Tim mạch', 'Khám và điều trị các bệnh lý liên quan đến tim (Cardiology - Heart-related diseases)', 'ACTIVE'),
('MS02', 'Da liễu', 'Chẩn đoán và điều trị các bệnh về da, tóc và móng (Dermatology - Skin, hair, and nail diseases)', 'ACTIVE'),
('MS03', 'Nhi khoa', 'Chăm sóc sức khỏe cho trẻ sơ sinh và trẻ nhỏ (Pediatrics - Healthcare for children)', 'DELETED'),
('MS04', 'Tai Mũi Họng', 'Khám và điều trị các bệnh lý tai, mũi, họng (Otolaryngology - Ear, nose, and throat)', 'ACTIVE'),
('MS05', 'Nội tổng quát', 'Khám chữa bệnh nội khoa không cần phẫu thuật (Internal Medicine - Non-surgical treatment of internal diseases)', 'ACTIVE'),
('MS06', 'Ngoại tổng quát', 'Phẫu thuật điều trị các bệnh lý thông thường (General Surgery - Common surgical treatment)', 'ACTIVE'),
('MS07', 'Phụ sản', 'Khám và điều trị cho phụ nữ mang thai, sinh sản (Obstetrics and Gynecology - Pregnancy and reproductive health)', 'ACTIVE'),
('MS08', 'Răng Hàm Mặt', 'Khám và điều trị răng, hàm và mặt (Odonto-Stomatology - Dental and maxillofacial care)', 'ACTIVE'),
('MS09', 'Mắt', 'Khám và điều trị các bệnh về mắt (Ophthalmology - Eye care and vision)', 'ACTIVE'),
('MS10', 'Thần kinh', 'Khám và điều trị các bệnh hệ thần kinh (Neurology - Nervous system disorders)', 'ACTIVE'),
('MS16', 'Tâm lý học', 'Khám và điều trị các vấn đề về sức khỏe tinh thần, tư vấn tâm lý (Psychology - Mental health counseling and therapy)', 'ACTIVE');

-- Bác sĩ 1 - Tim mạch
INSERT INTO doctor(id, account_id, medical_specialty_id, name, phone, email, birthday, gender, address, qualification, description, status)
VALUES
('D001', 'doctor1', 'MS01', 'Nguyễn Văn A', '0901234567', 'nguyenvana@example.com', '1985-04-10', TRUE, 'Hà Nội', 
'Bác sĩ Chuyên khoa II', 
'Bác sĩ tim mạch với hơn 10 năm kinh nghiệm trong điều trị bệnh tim, đã thực hiện hàng trăm ca phẫu thuật thành công.',
'ACTIVE'),
-- Bác sĩ 2 - Da liễu
('D002', 'doctor2', 'MS02', 'Trần Thị B', '0907654321', 'ntvk137@gmail.com', '1990-08-20', FALSE, 'Hồ Chí Minh', 
'Bác sĩ Chuyên khoa I',
'Bác sĩ da liễu chuyên điều trị các bệnh về da như mụn, nám, và thẩm mỹ da. Có kỹ năng trong việc tư vấn chăm sóc da.',
'ACTIVE'),
-- Bác sĩ 3 - Tai Mũi Họng
('D003', 'doctor3', 'MS04', 'Lê Minh C', '0909876543', 'leminhc@example.com', '1982-12-05', TRUE, 'Đà Nẵng', 
'Bác sĩ Chuyên khoa II', 
'Chuyên gia về tai mũi họng với hơn 12 năm kinh nghiệm, đã phẫu thuật thành công hàng trăm ca tai mũi họng.',
'ACTIVE'),
-- Bác sĩ 4 - Nội tổng quát
('D004', 'doctor4', 'MS05', 'Phạm Thị D', '0901122334', 'phamthid@example.com', '1988-07-15', FALSE, 'Hà Nội', 
'Bác sĩ Chuyên khoa I', 
'Bác sĩ nội tổng quát với nhiều năm kinh nghiệm trong việc điều trị các bệnh lý không phẫu thuật.',
'ACTIVE'),
-- Bác sĩ 5 - Phụ khoa
('D005', 'doctor5', 'MS07', 'Lê Thị E', '0902233445', 'lethie@example.com', '1985-03-25', FALSE, 'Hà Nội', 
'Bác sĩ Chuyên khoa II', 
'Chuyên gia sản phụ khoa, chuyên tư vấn và điều trị các vấn đề sinh sản, chăm sóc bà mẹ mang thai.',
'DELETED'),
-- Bác sĩ 6 - Mắt
('D006', 'doctor6', 'MS09', 'Nguyễn Thị F', '0905566778', 'nguyenthif@example.com', '1980-11-12', FALSE, 'Đà Nẵng', 
'Bác sĩ Chuyên khoa I', 
'Chuyên gia về điều trị các bệnh lý về mắt, từ các bệnh thông thường đến các bệnh lý nghiêm trọng về mắt.',
'ACTIVE'),
-- Bác sĩ 7 - Răng Hàm Mặt
('D007', 'doctor7', 'MS08', 'Trần Minh G', '0903344556', 'tranming@example.com', '1978-09-20', TRUE, 'Hồ Chí Minh', 
'Bác sĩ Chuyên khoa II', 
'Chuyên gia về chăm sóc và điều trị các bệnh lý răng miệng, phẫu thuật răng hàm mặt.',
'ACTIVE'),
-- Bác sĩ 8 - Thần kinh
('D008', 'doctor8', 'MS10', 'Vũ Thị H', '0909988776', 'vuthih@example.com', '1991-02-02', FALSE, 'Hà Nội', 
'Bác sĩ Chuyên khoa I', 
'Chuyên gia về các bệnh lý thần kinh, từ các bệnh lý thần kinh nhẹ đến nghiêm trọng.',
'ACTIVE'),
-- Bác sĩ 9 - Ngoại tổng quát
('D009', 'doctor9', 'MS06', 'Hoàng Minh I', '0906677889', 'hoangminhi@example.com', '1984-06-11', TRUE, 'Hồ Chí Minh', 
'Bác sĩ Chuyên khoa II', 
'Chuyên gia trong các phẫu thuật ngoại khoa và điều trị các bệnh lý cần can thiệp ngoại khoa.',
'ACTIVE'),
-- Bác sĩ 10 - Da liễu
('D010', 'doctor10', 'MS02', 'Phan Thị J', '0901112233', 'phanthij@example.com', '1983-12-10', FALSE, 'Hà Nội', 
'Bác sĩ Chuyên khoa I', 
'Chuyên gia da liễu, chuyên điều trị các bệnh về da và thẩm mỹ da, cung cấp các dịch vụ chăm sóc sắc đẹp.',
'ACTIVE'),
-- Bác sĩ 11 - Nhi khoa
('D011', 'doctor11', 'MS03', 'Nguyễn Tiến K', '0901122324', 'nguyentienk@example.com', '1995-05-10', TRUE, 'Hà Nội', 
'Bác sĩ Chuyên khoa I', 
'Bác sĩ nhi khoa chuyên chăm sóc và điều trị bệnh cho trẻ sơ sinh và trẻ nhỏ.',
'DELETED'),
-- Bác sĩ 12 - Tim mạch
('D012', 'doctor12', 'MS01', 'Lê Quốc L', '0903344566', 'lequocl@example.com', '1980-01-30', TRUE, 'Hồ Chí Minh', 
'Bác sĩ Chuyên khoa II', 
'Bác sĩ chuyên điều trị các bệnh về tim mạch và can thiệp tim mạch.',
'DELETED');

INSERT INTO manager (id, account_id, name, phone, email, address, gender, status) VALUES 
('M001', 'manager1', 'Anna Brown', '0987654321', 'anna.brown@clinic.com', '456 Manager Blvd', 0, 'ACTIVE');

INSERT INTO customer (name, phone, email, address, gender, status) VALUES 
('Michael Nguyen', '0901234567', 'michael@example.com', '789 Customer Rd', 1, 'ACTIVE'),
('Linh Tran', '0934567890', 'linh.tran@example.com', '321 Nguyen Van Cu', 0, 'ACTIVE');

INSERT INTO service (id, medical_specialty_id, creator_id, name, description, status)
VALUES 
('SV001', 'MS01', 'M001', 'Khám tim mạch', 'Đánh giá và điều trị các bệnh lý tim mạch (Cardiovascular checkup and treatment)', 'ACTIVE'),
('SV002', 'MS02', 'M001', 'Điều trị Da liễu', 'Khám và điều trị các bệnh về da như mụn, eczema (Skin treatments including acne and eczema)', 'ACTIVE'),
('SV003', 'MS03', 'M001', 'Chăm sóc Nhi khoa', 'Khám và chăm sóc sức khỏe cho trẻ em (Pediatric care for children)', 'DELETED'),
('SV004', 'MS04', 'M001', 'Điều trị Tai Mũi Họng', 'Khám và điều trị các bệnh về tai, mũi, họng (Ear, nose, and throat treatment)', 'ACTIVE'),
('SV005', 'MS05', 'M001', 'Khám Nội tổng quát', 'Chẩn đoán và điều trị bệnh nội khoa (General internal medicine diagnosis and treatment)', 'ACTIVE'),
('SV006', 'MS06', 'M001', 'Phẫu thuật Ngoại tổng quát', 'Phẫu thuật điều trị các bệnh lý thông thường (General surgery for common disorders)', 'ACTIVE'),
('SV007', 'MS07', 'M001', 'Khám Phụ sản', 'Khám và điều trị cho phụ nữ mang thai và vấn đề sinh sản (Obstetric and gynecological care)', 'ACTIVE'),
('SV008', 'MS08', 'M001', 'Khám Răng Hàm Mặt', 'Khám và điều trị các vấn đề về răng, hàm và mặt (Dental and maxillofacial treatment)', 'ACTIVE'),
('SV009', 'MS09', 'M001', 'Khám Mắt', 'Khám và điều trị các bệnh về mắt (Ophthalmic checkup and treatment)', 'ACTIVE'),
('SV010', 'MS10', 'M001', 'Khám Thần kinh', 'Chẩn đoán và điều trị các vấn đề hệ thần kinh (Neurological disorders diagnosis and treatment)', 'ACTIVE'),
('SV011', 'MS16', 'M001', 'Tư vấn Tâm lý', 'Tư vấn và điều trị các vấn đề sức khỏe tinh thần (Psychological counseling and mental health treatment)', 'ACTIVE');

INSERT INTO clinic (id, name, address, description, phone, email, status) VALUES 
('CL01', 'Phòng khám Tim mạch', '101 Main St.', 'Khám và điều trị các bệnh lý liên quan đến tim (Cardiology - Heart-related diseases)', '02812345678', 'info@downtownclinic.com', 'ACTIVE'),
('CL02', 'Phòng khám Da liễu', '101 Main St.', 'Chẩn đoán và điều trị các bệnh về da, tóc và móng (Dermatology - Skin, hair, and nail diseases)', '02898765432', 'contact@cityhealthcenter.com', 'ACTIVE'),
('CL03', 'Phòng khám Nhi khoa', '101 Main St.', 'Chăm sóc sức khỏe cho trẻ sơ sinh và trẻ nhỏ (Pediatrics - Healthcare for children)', '02811223344', 'support@healthplusclinic.com', 'DELETED'),
('CL04', 'Phòng khám Tai Mũi Họng', '101 Main St.', 'Khám và điều trị các bệnh lý tai, mũi, họng (Otolaryngology - Ear, nose, and throat)', '02822334455', 'info@sunriseclinic.com', 'ACTIVE'),
('CL05', 'Phòng khám Nội tổng quát', '101 Main St.', 'Khám chữa bệnh nội khoa không cần phẫu thuật (Internal Medicine - Non-surgical treatment of internal diseases)', '02833445566', 'contact@centralclinic.com', 'ACTIVE'),
('CL06', 'Phòng khám Ngoại tổng quát', '101 Main St.', 'Phẫu thuật điều trị các bệnh lý thông thường (General Surgery - Common surgical treatment)', '02844556677', 'info@medicenter.com', 'ACTIVE'),
('CL07', 'Phòng khám Phụ sản', '101 Main St.', 'Khám và điều trị cho phụ nữ mang thai, sinh sản (Obstetrics and Gynecology - Pregnancy and reproductive health)', '02855667788', 'contact@womenclinic.com', 'ACTIVE'),
('CL08', 'Phòng khám Răng Hàm Mặt', '101 Main St.', 'Khám và điều trị răng, hàm và mặt (Odonto-Stomatology - Dental and maxillofacial care)', '02866778899', 'info@smiledental.com', 'ACTIVE'),
('CL09', 'Phòng khám Mắt', '101 Main St.', 'Khám và điều trị các bệnh về mắt (Ophthalmology - Eye care and vision)', '02877889900', 'contact@visioncare.com', 'ACTIVE'),
('CL10', 'Phòng khám Thần kinh', '101 Main St.', 'Khám và điều trị các bệnh hệ thần kinh (Neurology - Nervous system disorders)', '02888990011', 'info@neuroclinic.com', 'ACTIVE'),
('CL11', 'Phòng khám Tâm lý học', '101 Main St.', 'Khám và điều trị các vấn đề về sức khỏe tinh thần, tư vấn tâm lý (Psychology - Mental health counseling and therapy)', '02899001122', 'support@mindcareclinic.com', 'ACTIVE');

INSERT INTO schedule (id, doctor_id, clinic_id, date, time_start, time_end, max_booking, status)
VALUES 
('SCHED016', 'D001', 'CL01', '2025-06-04', '08:00:00', '11:00:00', 10, 'ACTIVE'),
('SCHED017', 'D002', 'CL02', '2025-06-04', '09:00:00', '12:00:00', 12, 'UPCOMING'),
('SCHED018', 'D003', 'CL03', '2025-06-05', '10:00:00', '13:00:00', 8, 'UPCOMING'),
('SCHED019', 'D004', 'CL04', '2025-06-06', '14:00:00', '17:00:00', 12, 'UPCOMING'),
('SCHED020', 'D005', 'CL05', '2025-06-07', '08:30:00', '11:30:00', 10, 'UPCOMING'),
('SCHED021', 'D001', 'CL06', '2025-06-08', '08:00:00', '11:00:00', 15, 'UPCOMING'),  -- D001 có lịch chung với CL06
('SCHED022', 'D002', 'CL07', '2025-06-08', '08:00:00', '11:00:00', 15, 'UPCOMING'),  -- D002 cũng có lịch chung với CL06
('SCHED023', 'D006', 'CL06', '2025-06-08', '09:00:00', '12:00:00', 10, 'UPCOMING'),
('SCHED024', 'D007', 'CL07', '2025-06-09', '10:00:00', '13:00:00', 10, 'UPCOMING'),
('SCHED025', 'D008', 'CL08', '2025-06-09', '08:00:00', '11:00:00', 12, 'UPCOMING'),
('SCHED026', 'D009', 'CL09', '2025-06-10', '09:00:00', '12:00:00', 10, 'UPCOMING'),
('SCHED027', 'D010', 'CL10', '2025-06-10', '14:00:00', '17:00:00', 15, 'ACTIVE'),
('SCHED028', 'D003', 'CL02', '2025-06-11', '08:00:00', '11:00:00', 8, 'ACTIVE'),  -- D003 có lịch riêng tại CL02
('SCHED029', 'D005', 'CL03', '2025-06-12', '10:00:00', '13:00:00', 12, 'ACTIVE'),
('SCHED030', 'D007', 'CL07', '2025-06-12', '08:00:00', '11:00:00', 10, 'ACTIVE'),
('SCHED031', 'D008', 'CL08', '2025-06-13', '14:00:00', '17:00:00', 15, 'ACTIVE'),
('SCHED032', 'D001', 'CL09', '2025-06-14', '09:00:00', '12:00:00', 10, 'ACTIVE'),  -- D001 có lịch riêng tại CL09
('SCHED033', 'D006', 'CL05', '2025-06-14', '09:00:00', '12:00:00', 10, 'ACTIVE'),
('SCHED034', 'D010', 'CL06', '2025-06-15', '08:00:00', '11:00:00', 12, 'ACTIVE');



DELIMITER $$
	CREATE EVENT IF NOT EXISTS EVT_schedule_status_auto_update
	ON SCHEDULE EVERY 60 MINUTE
	DO
	BEGIN

		UPDATE schedule
		SET status = 'EXPIRED'
		WHERE end_time < NOW()
		  AND status NOT IN ('CANCELED', 'DELETED', 'EXPIRED', 'PAUSED');


		UPDATE schedule
		SET status = 'ONGOING'
		WHERE start_time <= NOW() AND end_time >= NOW()
		  AND status NOT IN ('CANCELED', 'DELETED', 'ONGOING', 'PAUSED');


		UPDATE schedule
		SET status = 'UPCOMING'
		WHERE start_time > NOW()
		  AND status NOT IN ('CANCELED', 'DELETED', 'UPCOMING', 'PAUSED');
	END$$
DELIMITER ;
SET GLOBAL event_scheduler = ON;

SHOW VARIABLES LIKE 'event_scheduler';


-- DELIMITER $$

-- CREATE PROCEDURE sp_get_schedule_and_update_status()
-- BEGIN

--     UPDATE schedule
--     SET status = 'EXPIRED'
-- 	WHERE time_end < NOW()
-- 	  AND status NOT IN ('CANCELED', 'DELETED', 'EXPIRED', 'PAUSED')
-- 	  AND id IS NOT NULL;

--     UPDATE schedule
--     SET status = 'ONGOING'
--     WHERE time_start <= NOW() AND time_end >= NOW()
--       AND status NOT IN ('CANCELED', 'DELETED', 'ONGOING', 'PAUSED')
-- 	  AND id IS NOT NULL;

--     UPDATE schedule
--     SET status = 'UPCOMING'
--     WHERE start_time > NOW()
--       AND status NOT IN ('CANCELED', 'DELETED', 'UPCOMING', 'PAUSED')
-- 	  AND id IS NOT NULL;

--     SELECT * FROM schedule;
-- END$$
-- DELIMITER ;
-- CALL sp_get_schedule_and_update_status();