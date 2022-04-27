package com.example.carrentalweb.Repository;

import com.example.carrentalweb.Model.Car;
import com.example.carrentalweb.Model.Customer;
import com.example.carrentalweb.Model.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RentalRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<Rental> fetchAll() {
        String sql = "SELECT rental_from_date, rental_to_date, rental_max_km FROM rental_table ";
        RowMapper<Rental> rowMapper = new BeanPropertyRowMapper<>(Rental.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public void addRental(Rental rental){
        String sql = "INSERT INTO rental_table (rental_from_date, rental_to_date, rental_max_km) VALUES(?,?,?)";
        jdbcTemplate.update(sql, rental.getFromDateAndTime(), rental.getToDateAndTime(), rental.getMaxKm());
    }

    public Rental getRentalByRentalId(int rentalId){
        String sql = "SELECT * FROM rental_table WHERE rental_id = ?";
        RowMapper<Rental> rowMapper = new BeanPropertyRowMapper<>(Rental.class);
        Rental rental = jdbcTemplate.queryForObject(sql, rowMapper, rentalId);
        return rental;
    }

}
