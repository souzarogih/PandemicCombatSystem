package br.com.pandemic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pandemic.entities.HospitalCapacity;

@Repository
public interface HospitalCapacityRepository extends JpaRepository<HospitalCapacity, Integer>{

}
