package br.com.pandemic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pandemic.dto.SystemExecutorDTO;
import br.com.pandemic.entities.SystemExecutor;
import br.com.pandemic.repositories.SystemExecutorRepository;

@Service
public class SystemExecutorService {
	
	@Autowired
	private SystemExecutorRepository systemExecutorRepository;

	@Transactional
	public SystemExecutorDTO insert(SystemExecutorDTO dto) {
		SystemExecutor entity = new SystemExecutor();
		entity.setSystem_executor_type(dto.getSystem_executor_type());
		entity.setSystem_date_time_executor(dto.getSystem_date_time_executor());
		entity.setData(dto.getData());
		entity.setMethod(dto.getMethod());
		entity.setLocalization_id(dto.getLocalization_id());
		entity.setAddress_id(dto.getAddress_id());
		entity.setHospital_id(dto.getHospital_id());
		entity.setHospital_capacity_id(dto.getHospital_capacity_id());
		entity = systemExecutorRepository.save(entity);
		return new SystemExecutorDTO(entity);
	}
	
}
