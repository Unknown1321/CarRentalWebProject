package com.example.carrentalweb.Repository;

import com.example.carrentalweb.Model.Car;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

@Repository
public class CarRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void addCar(Car car){
        String sql = "INSERT INTO car_table(registration_number, brand, model, registration_date, km_driven) VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, car.getRegistrationNumber(), car.getBrand(), car.getModel(), car.getRegistrationDate(), car.getKmDriven());
    }

    public List<Car> fetchAll() {
        String sql = "SELECT registration_number, brand, model, registration_date, km_driven FROM car_table ";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        System.out.println("family car from carRepo");
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Car getCarByRegistrationNumber(String registrationNumber) {
        String sql = "SELECT * FROM car_table WHERE registration_number = ?";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        Car car = jdbcTemplate.queryForObject(sql, rowMapper, registrationNumber);
        return car;
    }

    public void updateCar(String reg, Car car) {
        String sql = "UPDATE car_table SET registration_number = ?, brand = ?, model = ?, " +
                "registration_date = ?, km_driven = ? WHERE registration_number = ? ";
        jdbcTemplate.update(sql, car.getRegistrationNumber(), car.getBrand(), car.getModel(), car.getRegistrationDate(), car.getKmDriven(), reg);
    }

    public void deleteCar(String registrationNumber) {
        String sql = "DELETE FROM car_table WHERE registration_number =?";
        jdbcTemplate.update(sql, registrationNumber);
    }
}
