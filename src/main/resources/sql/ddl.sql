-- 部署テーブル
CREATE TABLE department (
    department_id VARCHAR(20) PRIMARY KEY,
    department_name VARCHAR(100) NOT NULL,
    establishment_date DATE,
    dissolution_flag BOOLEAN DEFAULT FALSE
);

-- 社員テーブル
CREATE TABLE employee (
    employee_id VARCHAR(20) PRIMARY KEY,
    department_id VARCHAR(20),
    FOREIGN KEY (department_id) REFERENCES department(department_id)
);

-- 社員詳細テーブル
CREATE TABLE employee_detail (
    employee_id VARCHAR(20) PRIMARY KEY,
    department_id VARCHAR(20),
    name VARCHAR(100) NOT NULL,
    address VARCHAR(255),
    email VARCHAR(100),
    phone_number VARCHAR(20),
    birth_date DATE,
    hire_date DATE,
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);

-- プロジェクトテーブル
CREATE TABLE project (
    project_id VARCHAR(20) PRIMARY KEY,
    project_name VARCHAR(100) NOT NULL,
    start_date DATE,
    end_date DATE
);

-- プロジェクト詳細テーブル
CREATE TABLE project_detail (
    project_detail_id INT AUTO_INCREMENT PRIMARY KEY,
    project_id VARCHAR(20),
    employee_id VARCHAR(20),
    role_name VARCHAR(100),
    assignment_date DATE
);

-- タスクテーブル
CREATE TABLE task (
    task_id INT AUTO_INCREMENT PRIMARY KEY,
    task_name VARCHAR(100) NOT NULL,
    project_id VARCHAR(20),
    employee_id VARCHAR(20),
    progress_status VARCHAR(50)
);
