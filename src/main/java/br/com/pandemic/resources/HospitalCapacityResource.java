package br.com.pandemic.resources;

import java.net.URI;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.pandemic.dto.HospitalCapacityDTO;
import br.com.pandemic.dto.SystemExecutorDTO;
import br.com.pandemic.services.HospitalCapacityService;
import br.com.pandemic.services.SystemExecutorService;

@RestController
@RequestMapping(value = "/api/hospitalCapacity")
public class HospitalCapacityResource {

	@Autowired
	private HospitalCapacityService hospitalCapacityService;
	
	@Autowired
	private SystemExecutorService systemExecutorServices;
	
	@GetMapping
	public ResponseEntity<List<HospitalCapacityDTO>> findAll(){
		List<HospitalCapacityDTO> list = hospitalCapacityService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<HospitalCapacityDTO> findById(@PathVariable Integer id){
		HospitalCapacityDTO dto = hospitalCapacityService.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<HospitalCapacityDTO> insert(@RequestBody HospitalCapacityDTO dto){
		dto = hospitalCapacityService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getHospital_capacity_id()).toUri();
		systemExecutorDo(dto.toString(), "POST", dto.getHospital_capacity_id());//Este método é chamado para registrar o insert na entidade que processa todas as execuções.
		return ResponseEntity.created(uri).body(dto);
	}
	
	/*Este método deve ser chamado sempre que for necessário gravar dados da execução do serviço na tabela PCAS_SYSTEM_EXECUTOR.*/
	private void systemExecutorDo(String localization, String method, Integer hospital_capacity_id) {
		SystemExecutorDTO se = new SystemExecutorDTO(13, Instant.now(), localization.toString(),method, null, null, hospital_capacity_id, null);
		systemExecutorServices.insert(se);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<HospitalCapacityDTO> update(@PathVariable Integer id, @RequestBody HospitalCapacityDTO dto){
		dto = hospitalCapacityService.update(id, dto);
		systemExecutorDo(dto.toString(), "PUT", dto.getHospital_capacity_id());//Este método é chamado para registrar o insert na entidade que processa todas as execuções.
		return ResponseEntity.ok().body(dto);
	}
	
}
