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

import br.com.pandemic.dto.LocalizationDTO;
import br.com.pandemic.dto.SystemExecutorDTO;
import br.com.pandemic.services.LocalizationService;
import br.com.pandemic.services.SystemExecutorService;

@RestController
@RequestMapping(value = "/api/localization")
public class LocalizationResource {

	@Autowired
	private LocalizationService localizationServices;
	
	@Autowired
	private SystemExecutorService systemExecutorServices;
	
	@GetMapping
	public ResponseEntity<List<LocalizationDTO>> findAll(){
		List<LocalizationDTO> list = localizationServices.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<LocalizationDTO> findById(@PathVariable Integer id){
		LocalizationDTO dto = localizationServices.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<LocalizationDTO> insert(@RequestBody LocalizationDTO dto){
		dto = localizationServices.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getLocalization_id()).toUri();
		systemExecutorDo(dto.toString(), "POST",dto.getLocalization_id());//Este método é chamado para registrar o insert na entidade que processa todas as execuções.
		return ResponseEntity.created(uri).body(dto);
	}
	
	/*Este método deve ser chamado sempre que for necessário gravar dados da execução do serviço na tabela PCAS_SYSTEM_EXECUTOR.*/
	public void systemExecutorDo(String localization, String method, Integer localization_id) {
		SystemExecutorDTO se = new SystemExecutorDTO(10, Instant.now(), localization.toString(),method,localization_id, null, null, null);
		systemExecutorServices.insert(se);
		
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<LocalizationDTO> update(@PathVariable Integer id, @RequestBody LocalizationDTO dto){
		dto = localizationServices.update(id, dto);
		systemExecutorDo(dto.toString(), "PUT",dto.getLocalization_id());//Este método é chamado para registrar o insert na entidade que processa todas as execuções.
		return ResponseEntity.ok().body(dto);
	}
	
}
