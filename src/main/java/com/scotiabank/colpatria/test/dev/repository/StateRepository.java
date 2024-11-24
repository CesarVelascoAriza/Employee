package com.scotiabank.colpatria.test.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scotiabank.colpatria.test.dev.entiti.State;

public interface StateRepository extends JpaRepository<State, Long> {

}
