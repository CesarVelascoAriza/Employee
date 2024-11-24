package com.scotiabank.colpatria.test.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scotiabank.colpatria.test.dev.entiti.City;

public interface CityRepository extends JpaRepository<City, Long> {

}
