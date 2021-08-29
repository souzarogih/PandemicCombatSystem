package br.com.pandemic.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pandemic.dto.AddressDTO;
import br.com.pandemic.entities.Address;
import br.com.pandemic.repositories.AddressRepository;
import br.com.pandemic.services.exceptions.ResourceNotFoundException;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	@Transactional(readOnly = true)
	public List<AddressDTO> findAll(){
		List<Address> list = addressRepository.findAll();
		return list.stream().map(x -> new AddressDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public AddressDTO findById(Integer id) {
		try {
			Optional<Address> obj = addressRepository.findById(id);
			Address entity = obj.get();
			return new AddressDTO(entity);
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException("PCAS12 - Address not found " + id);
		}
	}
	
	@Transactional(readOnly = true)
	public AddressDTO insert(AddressDTO dto){
		Address entity = new Address();
		entity.setStreet(dto.getStreet());
		entity.setNumber(dto.getNumber());
		entity = addressRepository.save(entity);
		return new AddressDTO(entity);
	}
	
	@Transactional
	public AddressDTO update(Integer id, AddressDTO dto) {
		try {
			Address entity = addressRepository.getOne(id);
			entity.setStreet(dto.getStreet());
			entity.setNumber(dto.getNumber());
			entity = addressRepository.save(entity);
			return new AddressDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("PCAS12 - Address not found " + id);
		}
	}
	
}
