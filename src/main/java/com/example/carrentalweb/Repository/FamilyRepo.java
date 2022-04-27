package com.example.carrentalweb.Repository;

import com.example.carrentalweb.Model.Car;
import com.example.carrentalweb.Model.FamilyCar;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

@Repository
public class FamilyRepo {
    // commit
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addFamilyCar(FamilyCar car){
        String sql = "INSERT INTO family_cars(registration_number, manual_gear, air_condition, cruise_control, seven_seats_or_more) VALUES(?,?,?,?,?)";
        System.out.println("Debug message!");
        jdbcTemplate.update(sql,car.getRegistrationNumber(), car.isManualGear(), car.isAirCondition(), car.isCruiseControl(), car.isSevenSeatsOrMore());
    }

    public List<FamilyCar> fetchAll() {
        String sql = ("SELECT * FROM car_table INNER JOIN family_cars ON car_table.registration_number = family_cars.registration_number");
//        String sql = "SELECT registration_number, manual_gear, air_condition, cruise_control, seven_seats_or_more FROM family_cars ";
        RowMapper<FamilyCar> rowMapper = new BeanPropertyRowMapper<>(FamilyCar.class);
        System.out.println("family cars read! ");
        return jdbcTemplate.query(sql, rowMapper);
    }

    public FamilyCar getFamilyCarByRegistrationNumber(String registrationNumber) {
        String sql = "SELECT * FROM car_table  WHERE registration_number = ?";
        RowMapper<FamilyCar> rowMapper = new BeanPropertyRowMapper<>(FamilyCar.class);
        FamilyCar familyCar = jdbcTemplate.queryForObject(sql, rowMapper, registrationNumber);
        return familyCar;
    }

    /*public Customer getCustomerByLicenceNumber(String licenceNumber) {
        String sql = "SELECT driver_license_number, driver_since_number, first_name, last_name, " +
                "phone_number, mobile_number, email, zip_table.zip_code, " +
                "city FROM customer_table " +
                "INNER JOIN zip_table ON customer_table.zip_code = " +
                "zip_table.zip_code WHERE driver_license_number = ?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        Customer customer = jdbcTemplate.queryForObject(sql, rowMapper, licenceNumber);
        return customer;
    }*/

    public void updateFamilyCar(String reg, FamilyCar car) {
        String sql = "UPDATE family_cars SET registration_number = ?, manual_gear = ?, air_condition = ?, " +
                "cruise_control = ?, seven_seats_or_more = ? WHERE registration_number = ? ";
        jdbcTemplate.update(sql,car.getRegistrationNumber(), car.isManualGear(), car.isAirCondition(), car.isCruiseControl(), car.isSevenSeatsOrMore(),reg);
    }

    public void deleteFamilyCar(String registrationNumber) {
        String sql = "DELETE FROM family_cars WHERE registration_number =?";
        jdbcTemplate.update(sql, registrationNumber);
    }
}
