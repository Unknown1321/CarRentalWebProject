package com.example.carrentalweb.Repository;

import com.example.carrentalweb.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO customer_table(driver_license_number, driver_since_number, first_name, last_name, phone_number, mobile_number, email, zip_code) VALUES(?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, customer.getDriver_license_number(), customer.getDriver_since_number(),
                customer.getFirst_name(), customer.getLast_name(), customer.getPhone_number(), customer.getMobile_number(),
                customer.getEmail(), customer.getZip_code());
    }

//    public void addNewCustomer(Customer customer) {
//        String sql = "INSERT INTO customer_table(driver_license_number, driver_since_number, first_name, last_name, phone_number, mobile_number, email) VALUES (?,?,?,?,?,?,?)";
//        jdbcTemplate.update(sql, customer.getDriver_license_number(), customer.getDriver_since_number(),
//                customer.getFirst_name(), customer.getFirst_name(), customer.getPhone_number(), customer.getMobile_number(),
//                customer.getEmail());
//    }

    public List<Customer> fetchAll() {
        String sql = "SELECT driver_license_number, driver_since_number, first_name, last_name, phone_number, mobile_number, email, zip_table.zip_code, city FROM customer_table " + "INNER JOIN zip_table ON customer_table.zip_code = zip_table.zip_code";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Customer getCustomerByLicenceNumber(String licenceNumber) {
        String sql = "SELECT driver_license_number, driver_since_number, first_name, last_name, " +
                "phone_number, mobile_number, email, zip_table.zip_code, " +
                "city FROM customer_table " +
                "INNER JOIN zip_table ON customer_table.zip_code = " +
                "zip_table.zip_code WHERE driver_license_number = ?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        Customer customer = jdbcTemplate.queryForObject(sql, rowMapper, licenceNumber);
        return customer;
    }

    public void updateCustomer(String license, Customer customer) {
        String sql = "UPDATE customer_table SET driver_since_number = ?, first_name = ?,last_name = ?, phone_number = ?, mobile_number = ?, email = ?, zip_code = ?  WHERE driver_license_number = ?";
        jdbcTemplate.update(sql, customer.getDriver_since_number(),
                customer.getFirst_name(), customer.getLast_name(), customer.getPhone_number(), customer.getMobile_number(),
                customer.getEmail(), customer.getZip_code(), customer.getDriver_license_number());
    }

    public void deleteCustomer(String licenceNumber) {
        String sql = "DELETE FROM customer_table WHERE driver_license_number = ?";
        jdbcTemplate.update(sql, licenceNumber);
    }
}

/*<table>

    <thead>

    <th>Driver licence:</th>
    <th>Driver since:</th>
    <th>First name</th>
    <th>Last name</th>
    <th>Phone number</th>
    <th>Mobile number</th>
    <th>Email</th>
    <th>Zip code</th>
    <th>City</th>


    </thead>

    <tbody>

    <tr th:each="customer: ${customers}">
        <td th:text="${customer.driver_license_number}" > </td>
        <td th:text="${customer.driver_since_number}" > </td>
        <td th:text="${customer.first_name}" > </td>
        <td th:text="${customer.last_name}" > </td>
        <td th:text="${customer.phone_number}" > </td>
        <td th:text="${customer.mobile_number}" > </td>
        <td th:text="${customer.email}" > </td>
        <td th:text="${customer.zip_code}" > </td>
        <td th:text="${customer.city}" > </td>

    </tr>
    </tbody>


 </table>*/