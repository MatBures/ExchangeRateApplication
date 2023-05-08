package com.matyasbures.exchangerateproject;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This is an interface that extends JpaRepository, which provides generic CRUD
 * operations for a given model (in this case, ExchangeRateModel) and ID type (Long).
 */
public interface ExchangeRateRepository extends JpaRepository<ExchangeRateModel, Long> {

}