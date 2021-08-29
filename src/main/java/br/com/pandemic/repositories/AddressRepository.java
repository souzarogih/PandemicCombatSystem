package br.com.pandemic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pandemic.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
