package com.example.carrentalweb.Repository;

import com.example.carrentalweb.Model.Car;
import com.example.carrentalweb.Model.LuxuryCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LuxuryRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addLuxuryCar(LuxuryCar car){
        String sql = "INSERT INTO luxury_cars(registration_number, ccm, automatic_gear, cruise_control, leather_seats) VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql,car.getRegistrationNumber(), car.isOver3000CCM(), car.isAutomaticGear(), car.isCruiseControl(), car.isLeatherSeats());
    }

    public List<LuxuryCar> fetchAll() {
        String sql = ("SELECT * FROM car_table INNER JOIN luxury_cars ON car_table.registration_number = luxury_cars.registration_number");
        RowMapper<LuxuryCar> rowMapper = new BeanPropertyRowMapper<>(LuxuryCar.class);
        return jdbcTemplate.query(sql, rowMapper);
    }



    public LuxuryCar getLuxuryCarByRegistrationNumber(String registrationNumber) {
        String sql = "SELECT * FROM luxury_cars WHERE registration_number = ?";
        RowMapper<LuxuryCar> rowMapper = new BeanPropertyRowMapper<>(LuxuryCar.class);
        LuxuryCar car = jdbcTemplate.queryForObject(sql, rowMapper, registrationNumber);
        return car;
    }

    public void updateLuxuryCar(LuxuryCar car) {
        String sql = "UPDATE luxury_cars SET registration_number = ?, over3000CCM = ?, automaticGear = ?, " +
                "cruiseControl = ?, leatherSeats = ? WHERE registration_number = ? ";
        jdbcTemplate.update(sql, car.getRegistrationNumber(), car.isOver3000CCM(), car.isAutomaticGear(), car.isCruiseControl(), car.isLeatherSeats());
    }

    public void deleteLuxuryCar(String registrationNumber) {
        String sql = "DELETE FROM luxury_cars WHERE registration_number =?";
        jdbcTemplate.update(sql, registrationNumber);
    }
}
