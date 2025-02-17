
#	1. Find the Customer who has the most orders. If more than 1 customer has the most orders then all customers should be displayed

USE classicmodels;
SELECT c.customerNumber, c.customerName, COUNT(o.orderNumber) AS orderCount
FROM customers c
JOIN orders o ON c.customerNumber = o.customerNumber
GROUP BY c.customerNumber, c.customerName
HAVING orderCount = (SELECT MAX(orderCount)
                     FROM (SELECT customerNumber, COUNT(orderNumber) AS orderCount 
                           FROM orders 
                           GROUP BY customerNumber) AS orderCounts);
						   


#   2. View all “Germany” customers and their orderdetails. If a customer has not made any orders then he should not be included in the result.

USE classicmodels;
SELECT c.customerNumber, c.customerName, o.orderNumber, od.productCode, od.quantityOrdered, od.priceEach
FROM customers c
JOIN orders o ON c.customerNumber = o.customerNumber
JOIN orderdetails od ON o.orderNumber = od.orderNumber
WHERE c.country = 'Germany';



#   3.	List all employees and the their revenue amount (based on payments table)

USE classicmodels;
SELECT e.employeeNumber, e.lastName, e.firstName, e.jobTitle, 
       COALESCE(SUM(p.amount), 0) AS totalRevenue
FROM employees e
LEFT JOIN customers c ON e.employeeNumber = c.salesRepEmployeeNumber
LEFT JOIN payments p ON c.customerNumber = p.customerNumber
GROUP BY e.employeeNumber, e.lastName, e.firstName, e.jobTitle
ORDER BY totalRevenue DESC;



#   4.	List all products which have been ordered the last month. (since the database is a bit old we assume we are now at 2005-01-01)

USE classicmodels;
SELECT DISTINCT p.productCode, p.productName, p.productLine, p.buyPrice
FROM products p
JOIN orderdetails od ON p.productCode = od.productCode
JOIN orders o ON od.orderNumber = o.orderNumber
WHERE o.orderDate BETWEEN '2004-12-01' AND '2004-12-31';



#   5.	Create a new table named employeedetails which should contain data like:  bankAccount, address, phoneNumber, personalEmail

USE classicmodels;
CREATE TABLE employeedetails (
    employeeNumber INT PRIMARY KEY,
    bankAccount VARCHAR(50) NOT NULL,
    address VARCHAR(255) NOT NULL,
    phoneNumber VARCHAR(20) NOT NULL,
    personalEmail VARCHAR(100) NOT NULL,
    FOREIGN KEY (employeeNumber) REFERENCES employees(employeeNumber) ON DELETE CASCADE
);