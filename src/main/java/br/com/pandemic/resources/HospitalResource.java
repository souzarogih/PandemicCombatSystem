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

import br.com.pandemic.dto.HospitalDTO;
import br.com.pandemic.dto.SystemExecutorDTO;
import br.com.pandemic.services.HospitalService;
import br.com.pandemic.services.SystemExecutorService;

@RestController
@RequestMapping(value = "/api/hospital")
public class HospitalResource {

	@Autowired
	private HospitalService hospitalServices;
	
	@Autowired
	private SystemExecutorService systemExecutorServices;
	
	@GetMapping
	public ResponseEntity<List<HospitalDTO>> findAll(){
		List<HospitalDTO> list = hospitalServices.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<HospitalDTO> findById(@PathVariable Integer id){
		HospitalDTO dto = hospitalServices.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<HospitalDTO> insert(@RequestBody HospitalDTO dto){
		dto = hospitalServices.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getHospital_id()).toUri();
		systemExecutorDo(dto.toString(), "POST",dto.getHospital_id());//Este método é chamado para registrar o insert na entidade que processa todas as execuções.
		return ResponseEntity.created(uri).body(dto);
	}
	
	/*Este método deve ser chamado sempre que for necessário gravar dados da execução do serviço na tabela PCAS_SYSTEM_EXECUTOR.*/
	public void systemExecutorDo(String localization, String method, Integer hospital_id) {
		SystemExecutorDTO se = new SystemExecutorDTO(11, Instant.now(), localization.toString(),method,null, hospital_id, null, null);
		systemExecutorServices.insert(se);	
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<HospitalDTO> update(@PathVariable Integer id, @RequestBody HospitalDTO dto){
		dto = hospitalServices.update(id, dto);
		systemExecutorDo(dto.toString(), "PUT",dto.getHospital_id());//Este método é chamado para registrar o insert na entidade que processa todas as execuções.
		return ResponseEntity.ok().body(dto);
	}
}
