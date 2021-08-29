package br.com.pandemic.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pandemic.dto.HospitalDTO;
import br.com.pandemic.entities.Hospital;
import br.com.pandemic.repositories.HospitalRepository;
import br.com.pandemic.services.exceptions.ResourceNotFoundException;

@Service
public class HospitalService {

	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Transactional(readOnly = true)
	public List<HospitalDTO> findAll(){
		List<Hospital> list = hospitalRepository.findAll();
		return list.stream().map(x -> new HospitalDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public HospitalDTO findById(Integer id) {
		try {
			Optional<Hospital> obj = hospitalRepository.findById(id);
			Hospital entity = obj.get();
			return new HospitalDTO(entity);
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException("PCAS11 - Address not found " + id);
		}
	}
	
	@Transactional(readOnly = true)
	public HospitalDTO insert(HospitalDTO dto){
		Hospital entity = new Hospital();
		entity.setHospital_name(dto.getHospital_name());
		entity.setAddress(dto.getAddress());
		entity.setCnpj(dto.getCnpj());
		entity.setLocalization_id(dto.getLocalization_id());
		entity.setHospital_capacity_id(dto.getHospital_capacity_id());
		entity.setAddress_id(dto.getAddress_id());//Nessa linha está incluindo o Address do Hospital
		entity = hospitalRepository.save(entity);
		return new HospitalDTO(entity);
	}
	
	@Transactional
	public HospitalDTO update(Integer id, HospitalDTO dto) {
		try {
			Hospital entity = hospitalRepository.getOne(id);
			entity.setHospital_name(dto.getHospital_name());
			entity.setAddress(dto.getAddress());
			entity.setCnpj(dto.getCnpj());
			entity.setLocalization_id(dto.getLocalization_id());
			entity.setHospital_capacity_id(dto.getHospital_capacity_id());
			entity = hospitalRepository.save(entity);
			return new HospitalDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("PCAS11 - Address not found " + id);
		}
	}
	
}
