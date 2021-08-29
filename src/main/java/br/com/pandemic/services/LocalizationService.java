package br.com.pandemic.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pandemic.dto.LocalizationDTO;
import br.com.pandemic.entities.Localization;
import br.com.pandemic.repositories.LocalizationRepository;
import br.com.pandemic.services.exceptions.ResourceNotFoundException;

@Service
public class LocalizationService {

	@Autowired
	private LocalizationRepository localizationRepository;
		
	@Transactional(readOnly = true)
	public List<LocalizationDTO> findAll() {
		List<Localization> list = localizationRepository.findAll();
		return list.stream().map(x -> new LocalizationDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public LocalizationDTO findById(Integer id) {
		try {
			Optional<Localization> obj = localizationRepository.findById(id);
			Localization entity = obj.get();
			return new LocalizationDTO(entity);
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException("PCAS10 - Address not found " + id);
		}
	}
	
	@Transactional(readOnly = true)
	public LocalizationDTO insert(LocalizationDTO dto){
		Localization entity = new Localization();
		entity.setLat(dto.getLat());
		entity.setLng(dto.getLng());
		entity = localizationRepository.save(entity);
		return new LocalizationDTO(entity);
	}
	
	@Transactional
	public LocalizationDTO update(Integer id, LocalizationDTO dto) {
		try {
			Localization entity = localizationRepository.getOne(id);
			entity.setLat(dto.getLat());
			entity.setLng(dto.getLng());
			entity = localizationRepository.save(entity);
			return new LocalizationDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("PCAS10 - Address not found " + id);
		}
	}
	
}
