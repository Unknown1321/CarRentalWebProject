package com.example.carrentalweb.Repository;

import com.example.carrentalweb.Model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

@Repository
public class CustomerRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Customer> fetchAll(){

        String sql = "SELECT driver_license_number, driver_since_number, first_name, last_name, phone_number, mobile_number, email, zip_table.zip_code, city FROM customer_table " +
                "INNER JOIN zip_table ON customer_table.zip_code = zip_table.zip_code";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return jdbcTemplate.query(sql,rowMapper);

    }


}
