package com.example.carrentalweb.Repository;


import com.example.carrentalweb.Model.SportCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SportRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addSportCar(SportCar car){
        String sql = "INSERT INTO sport_cars(registration_number, manual_gear, over200HP) VALUES(?,?,?)";
        jdbcTemplate.update(sql,car.getRegistrationNumber(), car.isManualGear(), car.isOver200HP());
    }

    public List<SportCar> fetchAll() {
        String sql = ("SELECT * FROM car_table INNER JOIN sport_cars ON car_table.registration_number = sport_cars.registration_number");
        RowMapper<SportCar> rowMapper = new BeanPropertyRowMapper<>(SportCar.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public SportCar getSportCarByRegistrationNumber(String registrationNumber) {
        String sql = "SELECT * FROM car_table SELECT manual_gear, over200HP WHERE registration_number = ?";
        RowMapper<SportCar> rowMapper = new BeanPropertyRowMapper<>(SportCar.class);
        SportCar car = jdbcTemplate.queryForObject(sql, rowMapper, registrationNumber);
        return car;
    }

    public void updateSportCar(SportCar car) {
        String sql = "UPDATE sport_cars SET registration_number = ?, manualGear = ?, over200HP = ?" +
                " WHERE registration_number = ? ";
        jdbcTemplate.update(sql, car.getRegistrationNumber(), car.isManualGear(), car.isOver200HP());
    }

    public void deleteSportCar(String registrationNumber) {
        String sql = "DELETE FROM sport_cars WHERE registration_number =?";
        jdbcTemplate.update(sql, registrationNumber);
    }
}
