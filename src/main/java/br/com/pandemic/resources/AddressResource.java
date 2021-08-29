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

import br.com.pandemic.dto.AddressDTO;
import br.com.pandemic.dto.SystemExecutorDTO;
import br.com.pandemic.factorys.SystemExecutorFactory;
import br.com.pandemic.services.AddressService;
import br.com.pandemic.services.SystemExecutorService;

@RestController
@RequestMapping(value = "/api/address")
public class AddressResource{

	@Autowired
	private AddressService addressService;
	
	@Autowired
	private SystemExecutorService systemExecutorServices;
	
	//@Autowired
	//private SystemExecutorFactory systemExecutorFactory;
	
	SystemExecutorFactory sef = new SystemExecutorFactory();
	
	@GetMapping
	public ResponseEntity<List<AddressDTO>> findAll(){
		List<AddressDTO> list = addressService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AddressDTO> findById(@PathVariable Integer id){
		AddressDTO dto = addressService.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<AddressDTO> insert(@RequestBody AddressDTO dto){
		dto = addressService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getAddress_id()).toUri();
		systemExecutorDo(dto.toString(), "POST", dto.getAddress_id());//Este método é chamado para registrar o insert na entidade que processa todas as execuções.
		//SystemExecutorFactory.systemExecutorInstatiate(12, dto.toString(), "POST", 0, 0, 0, dto.getAddress_id()); //Registrar na tabela de processamento chamando a factory.
		//sef.systemExecutorInstatiate(12, dto.toString(), "POST", 0, 0, 0, dto.getAddress_id()); //Registrar na tabela de processamento chamando a factory.
		return ResponseEntity.created(uri).body(dto);
	}
	
	/*Este método deve ser chamado sempre que for necessário gravar dados da execução do serviço na tabela PCAS_SYSTEM_EXECUTOR.*/
	private void systemExecutorDo(String localization, String method, Integer address_id) {
		SystemExecutorDTO se = new SystemExecutorDTO(12, Instant.now(), localization.toString(), method, null, null, null, address_id);
		systemExecutorServices.insert(se);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<AddressDTO> update(@PathVariable Integer id, @RequestBody AddressDTO dto){
		dto = addressService.update(id, dto);
		systemExecutorDo(dto.toString(), "PUT", dto.getAddress_id());//Este método é chamado para registrar o insert na entidade que processa todas as execuções.
		//SystemExecutorFactory.systemExecutorInstatiate(12, dto.toString(), "PUT", null, null, null, dto.getAddress_id()); //Registrar na tabela de processamento chamando a factory.
		//sef.systemExecutorInstatiate(12, dto.toString(), "PUT", null, null, null, dto.getAddress_id()); //Registrar na tabela de processamento chamando a factory.
		return ResponseEntity.ok().body(dto);
	}
	
}
