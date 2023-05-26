package com.matyasbures.exchangerateproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This is an interface that extends JpaRepository, which provides generic CRUD
 * operations for a given model (in this case, ExchangeRateModel) and ID type (Long).
 */
@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRateModel, Long> {

}