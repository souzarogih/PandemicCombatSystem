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

import br.com.pandemic.dto.CapacityExchangeDTO;
import br.com.pandemic.dto.SystemExecutorDTO;
import br.com.pandemic.services.CapacityExchangeService;
import br.com.pandemic.services.SystemExecutorService;

@RestController
@RequestMapping(value = "/api/capacityExchange")
public class CapacityExchangeResource {

	@Autowired
	private CapacityExchangeService capacityExchangeService;
	
	@Autowired
	private SystemExecutorService systemExecutorServices;
	
	@GetMapping
	public ResponseEntity<List<CapacityExchangeDTO>> findAll(){
		List<CapacityExchangeDTO> list = capacityExchangeService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CapacityExchangeDTO> findById(@PathVariable Integer id){
		CapacityExchangeDTO dto = capacityExchangeService.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<CapacityExchangeDTO> insert(@RequestBody CapacityExchangeDTO dto){
		dto = capacityExchangeService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getCapacity_exchange_id()).toUri();
		systemExecutorDo(dto.toString(), "POST", dto.getCapacity_exchange_id());//Este método é chamado para registrar o insert na entidade que processa todas as execuções.
		//SystemExecutorFactory.systemExecutorInstatiate(13, dto.toString(), "POST", 0, 0, 0, dto.getAddress_id()); //Registrar na tabela de processamento chamando a factory.
		//sef.systemExecutorInstatiate(13, dto.toString(), "POST", 0, 0, 0, dto.getAddress_id()); //Registrar na tabela de processamento chamando a factory.
		return ResponseEntity.created(uri).body(dto);
	}
	
	/*Este método deve ser chamado sempre que for necessário gravar dados da execução do serviço na tabela PCAS_SYSTEM_EXECUTOR.*/
	private void systemExecutorDo(String localization, String method, Integer address_id) {
		SystemExecutorDTO se = new SystemExecutorDTO(13, Instant.now(), localization.toString(), method, null, null, null, address_id);
		systemExecutorServices.insert(se);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<CapacityExchangeDTO> update(@PathVariable Integer id, @RequestBody CapacityExchangeDTO dto){
		dto = capacityExchangeService.update(id, dto);
		systemExecutorDo(dto.toString(), "PUT", dto.getCapacity_exchange_id());//Este método é chamado para registrar o insert na entidade que processa todas as execuções.
		//SystemExecutorFactory.systemExecutorInstatiate(13, dto.toString(), "PUT", null, null, null, dto.getAddress_id()); //Registrar na tabela de processamento chamando a factory.
		//sef.systemExecutorInstatiate(13, dto.toString(), "PUT", null, null, null, dto.getAddress_id()); //Registrar na tabela de processamento chamando a factory.
		return ResponseEntity.ok().body(dto);
	}
}
