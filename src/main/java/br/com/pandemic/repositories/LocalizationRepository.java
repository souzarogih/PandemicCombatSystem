package br.com.pandemic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pandemic.entities.Localization;

@Repository
public interface LocalizationRepository extends JpaRepository<Localization, Integer>{

}
