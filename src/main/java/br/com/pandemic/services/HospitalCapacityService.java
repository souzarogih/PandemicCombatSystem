package br.com.pandemic.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pandemic.dto.HospitalCapacityDTO;
import br.com.pandemic.entities.HospitalCapacity;
import br.com.pandemic.repositories.HospitalCapacityRepository;
import br.com.pandemic.services.exceptions.ResourceNotFoundException;

@Service
public class HospitalCapacityService {

	@Autowired
	private HospitalCapacityRepository hospitalCapacityRepository;
	
	@Transactional(readOnly = true)
	public List<HospitalCapacityDTO> findAll() {
		List<HospitalCapacity> list = hospitalCapacityRepository.findAll();
		return list.stream().map(x -> new HospitalCapacityDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public HospitalCapacityDTO findById(Integer id) {
		try {
			Optional<HospitalCapacity> obj = hospitalCapacityRepository.findById(id);
			HospitalCapacity entity = obj.get();
			return new HospitalCapacityDTO(entity);
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException("PCAS13 - Address not found " + id);
		}
	}
	
	@Transactional(readOnly = true)
	public HospitalCapacityDTO insert(HospitalCapacityDTO dto){
		HospitalCapacity entity = new HospitalCapacity();
		entity.setHospital_capacity_number(dto.getHospital_capacity_number());
		entity.setPercentage_occupancy(dto.getPercentage_occupancy());
		entity.setItem(dto.getItem());
		entity.setScore(dto.getScore());
		entity = hospitalCapacityRepository.save(entity);
		return new HospitalCapacityDTO(entity);
	}
	
	@Transactional
	public HospitalCapacityDTO update(Integer id, HospitalCapacityDTO dto) {
		try {
			HospitalCapacity entity = hospitalCapacityRepository.getOne(id);
			entity.setHospital_capacity_number(dto.getHospital_capacity_number());
			entity.setPercentage_occupancy(dto.getPercentage_occupancy());
			entity.setItem(dto.getItem());
			entity.setScore(dto.getScore());
			entity = hospitalCapacityRepository.save(entity);
			return new HospitalCapacityDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("PCAS13 - Address not found " + id);
		}
	}
	
}
