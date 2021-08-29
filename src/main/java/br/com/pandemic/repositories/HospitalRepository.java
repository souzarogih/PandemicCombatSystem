package br.com.pandemic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pandemic.entities.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer>{

}
