package br.com.pandemic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pandemic.entities.SystemExecutor;

@Repository
public interface SystemExecutorRepository extends JpaRepository<SystemExecutor, Integer>{

}
