package br.com.pandemic.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pandemic.dto.CapacityExchangeDTO;
import br.com.pandemic.entities.CapacityExchange;
import br.com.pandemic.repositories.CapacityExchangeRepository;
import br.com.pandemic.services.exceptions.ResourceNotFoundException;

@Service
public class CapacityExchangeService {

	@Autowired
	private CapacityExchangeRepository capacityExchangeRepository;
	
	@Transactional(readOnly = true)
	public List<CapacityExchangeDTO> findAll(){
		List<CapacityExchange> list = capacityExchangeRepository.findAll();
		return list.stream().map(x -> new CapacityExchangeDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public CapacityExchangeDTO findById(Integer id) {
		try {
			Optional<CapacityExchange> obj = capacityExchangeRepository.findById(id);
			CapacityExchange entity = obj.get();
			return new CapacityExchangeDTO(entity);
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException("PCAS13 - Capacity Exchange not found " + id);
		}
	}
	
	@Transactional(readOnly = true)
	public CapacityExchangeDTO insert(CapacityExchangeDTO dto){
		CapacityExchange entity = new CapacityExchange();
		entity.setItem_origin(dto.getItem_origin());
		entity.setItem_destiny(dto.getItem_destiny());
		entity.setHospital_capacity_id(dto.getHospital_capacity_id());
		entity.setHospital_id(dto.getHospital_id());
		entity = capacityExchangeRepository.save(entity);
		return new CapacityExchangeDTO(entity);
	}
	
	@Transactional
	public CapacityExchangeDTO update(Integer id, CapacityExchangeDTO dto) {
		try {
			CapacityExchange entity = capacityExchangeRepository.getOne(id);
			entity.setItem_origin(dto.getItem_origin());
			entity.setItem_destiny(dto.getItem_destiny());
			entity.setHospital_capacity_id(dto.getHospital_capacity_id());
			entity.setHospital_id(dto.getHospital_id());
			return new CapacityExchangeDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("PCAS13 - Capacity Exchange not found " + id);
		}
	}
}
