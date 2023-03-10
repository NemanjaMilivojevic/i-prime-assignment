CREATE TABLE employee (
  id BIGSERIAL PRIMARY KEY,
  full_name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  phone_number VARCHAR(20) NOT NULL,
  date_of_birth DATE NOT NULL,
  monthly_salary DECIMAL(10, 2) NOT NULL
);

CREATE TABLE task (
  id BIGSERIAL PRIMARY KEY,
  title VARCHAR(255),
  description TEXT,
  employee_id BIGINT,
  due_date DATE,
  CONSTRAINT fk_employee
    FOREIGN KEY (employee_id)
    REFERENCES employee (id)
);
