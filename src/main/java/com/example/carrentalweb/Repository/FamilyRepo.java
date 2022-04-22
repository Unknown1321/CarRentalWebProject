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

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addFamilyCar(FamilyCar car){
        String sql = "INSERT INTO family_cars(registration_number, manual_gear, air_condition, cruise_control, seven_seats_or_more) VALUES(?, ?,?,?,?)";
        System.out.println("Debug message!");
        jdbcTemplate.update(sql,car.getRegistrationNumber(), car.isManualGear(), car.isAirCondition(), car.isCruiseControl(), car.isSevenSeatsOrMore());
    }

    public List<FamilyCar> fetchAll() {
        String sql = "SELECT registration_number, manual_gear, air_condition, cruise_control, seven_seats_or_more FROM family_cars ";
        RowMapper<FamilyCar> rowMapper = new BeanPropertyRowMapper<>(FamilyCar.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public FamilyCar getFamilyCarByRegistrationNumber(String registrationNumber) {
        String sql = "SELECT * FROM family_cars WHERE registration_number = ?";
        RowMapper<FamilyCar> rowMapper = new BeanPropertyRowMapper<>(FamilyCar.class);
        FamilyCar familyCar = jdbcTemplate.queryForObject(sql, rowMapper, registrationNumber);
        return familyCar;
    }

    public void updateFamilyCar(FamilyCar car) {
        String sql = "UPDATE family_cars SET registration_number = ?, manual_gear = ?, air_condition = ?, " +
                "cruise_control = ?, seven_seats_or_more = ? WHERE registration_number = ? ";
        jdbcTemplate.update(sql,car.getRegistrationNumber(), car.isManualGear(), car.isAirCondition(), car.isCruiseControl(), car.isSevenSeatsOrMore());
    }

    public void deleteFamilyCar(String registrationNumber) {
        String sql = "DELETE FROM family_cars WHERE registration_number =?";
        jdbcTemplate.update(sql, registrationNumber);
    }
}
