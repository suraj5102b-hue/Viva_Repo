-- ============================================================
--   HCL EMPLOYEE MANAGEMENT SYSTEM - COMPLETE SQL FILE
-- ============================================================

-- 1. CREATE DATABASE
DROP DATABASE IF EXISTS HCL_Management;
CREATE DATABASE HCL_Management;
USE HCL_Management;

-- 2. CREATE EMPLOYEE TABLE
CREATE TABLE Employee (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(100) NOT NULL,
    salary DECIMAL(10,2) NOT NULL,
    department VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ============================================================
-- 3. INSERT EMPLOYEES
-- ============================================================

INSERT INTO Employee (emp_id, emp_name, salary, department)
VALUES 
(101, 'John Doe', 55000, 'IT'),
(102, 'Priya Sharma', 62000, 'HR'),
(103, 'Michael Lee', 70000, 'Finance');

-- ============================================================
-- 4. UPDATE SALARY
-- ============================================================

-- Example: Update salary of employee 101
UPDATE Employee
SET salary = 65000
WHERE emp_id = 101;

-- ============================================================
-- 5. REMOVE EMPLOYEE
-- ============================================================

-- Example: Remove employee 103
DELETE FROM Employee
WHERE emp_id = 103;

-- ============================================================
-- 6. VIEW ONE EMPLOYEE
-- ============================================================

SELECT * FROM Employee
WHERE emp_id = 101;

-- ============================================================
-- 7. VIEW ALL EMPLOYEES
-- ============================================================

SELECT * FROM Employee;

-- ============================================================
-- 8. COUNT EMPLOYEES
-- ============================================================

SELECT COUNT(*) AS total_employees
FROM Employee;

-- ============================================================
-- 9. OPTIONAL: INCREASE SALARY BY PERCENTAGE
-- ============================================================

-- Increase all salaries by 10%
UPDATE Employee
SET salary = salary * 1.10;

-- ============================================================
-- 10. OPTIONAL: EMPLOYEES BY DEPARTMENT
-- ============================================================

SELECT * FROM Employee
WHERE department = 'IT';

-- ============================================================
-- 11. OPTIONAL STORED PROCEDURES
-- ============================================================

-- Procedure: Add Employee
DELIMITER $$
CREATE PROCEDURE add_employee(IN id INT, IN name VARCHAR(100), IN sal DECIMAL(10,2), IN dept VARCHAR(50))
BEGIN
    INSERT INTO Employee(emp_id, emp_name, salary, department)
    VALUES(id, name, sal, dept);
END $$
DELIMITER ;

-- Procedure: Remove Employee
DELIMITER $$
CREATE PROCEDURE remove_employee(IN id INT)
BEGIN
    DELETE FROM Employee WHERE emp_id = id;
END $$
DELIMITER ;

-- Procedure: Update Salary
DELIMITER $$
CREATE PROCEDURE update_salary(IN id INT, IN newSal DECIMAL(10,2))
BEGIN
    UPDATE Employee SET salary = newSal WHERE emp_id = id;
END $$
DELIMITER ;

-- Procedure: Show All Employees
DELIMITER $$
CREATE PROCEDURE show_all()
BEGIN
    SELECT * FROM Employee;
END $$
DELIMITER ;

-- ============================================================
-- END OF FILE
-- ============================================================
