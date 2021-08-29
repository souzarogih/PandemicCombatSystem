package br.com.pandemic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pandemic.entities.CapacityExchange;

@Repository
public interface CapacityExchangeRepository extends JpaRepository<CapacityExchange, Integer> {

}
