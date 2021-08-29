package br.com.pandemic.factorys;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.pandemic.dto.SystemExecutorDTO;
import br.com.pandemic.entities.SystemExecutor;
import br.com.pandemic.services.SystemExecutorService;

public class SystemExecutorFactory {

	@Autowired
	private SystemExecutorService systemExecutorServices;
	
	/*Este método deve ser chamado sempre que for necessário gravar dados da execução do serviço na tabela PCAS_SYSTEM_EXECUTOR.*/
	public void systemExecutorFactory(Integer system_executor_type, String localization, String method) {
		SystemExecutorDTO se = new SystemExecutorDTO(12, Instant.now(), localization.toString(), method, null, null, null, 1);
		systemExecutorServices.insert(se);
		
	}
	
	/*public static SystemExecutorDTO systemExecutorInstatiate(Integer system_executor_type, Instant system_date_time_executor, String data, String method, Integer localization_id, Integer hospital_id, Integer hospital_capacity_id, Integer address_id) {
		return new SystemExecutorDTO();
	}*/
	
	public SystemExecutor systemExecutorInstatiate(Integer system_executor_type, String data, String method, Integer localization_id, Integer hospital_id, Integer hospital_capacity_id, Integer address_id) {
		//SystemExecutorDTO se = new SystemExecutorDTO(system_executor_type, Instant.now(), data, method, localization_id, hospital_id, hospital_capacity_id, address_id);
		SystemExecutorDTO se = new SystemExecutorDTO(system_executor_type, Instant.now(), data, method, localization_id, address_id, hospital_id, hospital_capacity_id);
		systemExecutorServices.insert(se);
		return new SystemExecutor();
	}
	
}
