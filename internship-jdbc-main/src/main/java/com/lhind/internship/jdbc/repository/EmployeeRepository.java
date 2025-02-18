package com.lhind.internship.jdbc.repository;

import com.lhind.internship.jdbc.mapper.EmployeeMapper;
import com.lhind.internship.jdbc.model.Employee;
import com.lhind.internship.jdbc.model.enums.EmployeeQuery;
import com.lhind.internship.jdbc.util.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeRepository implements Repository<Employee, Integer> {

    private static final String SELECT_ALL = "SELECT * FROM employees;";
    private static final String SELECT_BY_ID = "SELECT * FROM employees WHERE employeeNumber = ?;";
    private static final String SELECT1_BY_ID = "SELECT 1 FROM employees WHERE id = ? LIMIT 1;";
    private static final String DELETE_BY_ID = "DELETE FROM employees WHERE employeeNumber = ?;";
    private static final String UPDATE_LISTINGS =
            "INSERT INTO employees (employeeNumber, firstName, lastName, extension, email, officeCode, reportsTo, jobTitle) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?) " +
                    "ON DUPLICATE KEY UPDATE " +
                    "employeeNumber = VALUES(employeeNumber), " +
                    "firstName = VALUES(firstName), " +
                    "lastName = VALUES(lastName), " +
                    "extension = VALUES(extension), " +
                    "email = VALUES(email), " +
                    "officeCode = VALUES(officeCode), " +
                    "reportsTo = VALUES(reportsTo), " +
                    "jobTitle = VALUES(jobTitle);";


    private EmployeeMapper employeeMapper = EmployeeMapper.getInstance();

    @Override
    public List<Employee> findAll() {
        final List<Employee> response = new ArrayList<>();
        try (final Connection connection = JdbcConnection.connect();
             final PreparedStatement statement = connection.prepareStatement(EmployeeQuery.SELECT_ALL.getQuery())) {
            final ResultSet result = statement.executeQuery();
            while (result.next()) {
                response.add(employeeMapper.toEntity(result));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return response;
    }

    @Override
    public Optional<Employee> findById(final Integer id) {
        try (final Connection connection = JdbcConnection.connect();
             final PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);

            final ResultSet result = statement.executeQuery();

            if (result.next()) {
                final Employee employee = employeeMapper.toEntity(result);
                return Optional.of(employee);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return Optional.empty();
    }

    // TODO: Implement a method which checks if an employee with the given id exists in the employees table
    @Override
    public boolean exists(final Integer id) {

        try (final Connection connection = JdbcConnection.connect();
             final PreparedStatement statement = connection.prepareStatement(SELECT1_BY_ID)) {

            statement.setInt(1, id);
            try (final ResultSet result = statement.executeQuery()) {
                return result.next();
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    // TODO: Implement a method which adds an employee to the employees table
    //If the employee exists then the method should instead update the employee

    @Override
    public Employee save(final Employee employee) {

        try (final Connection connection = JdbcConnection.connect();
             final PreparedStatement statement = connection.prepareStatement(UPDATE_LISTINGS)) {

            statement.setInt(1, employee.getEmployeeNumber());
            statement.setString(2, employee.getFirstName());
            statement.setString(3, employee.getLastName());
            statement.setString(4, employee.getExtension());
            statement.setString(5, employee.getEmail());
            statement.setString(6, employee.getOfficeCode());
            statement.setInt(7, employee.getReportsTo());
            statement.setString(8, employee.getJobTitle());

            statement.executeUpdate();
            return employee;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    //TODO: Implement a method which deletes an employee given the id
    @Override
    public void delete(final Integer employeeId) {
        try (final Connection connection = JdbcConnection.connect();
             final PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setInt(1, employeeId);
            statement.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
