package br.com.pandemic.testes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.pandemic.entities.SystemExecutor;
import br.com.pandemic.testes.factory.SystemExecutorFactoryTests;

public class AddressServiceTests {

	/**
	 * @author Higor Souza
	 * Teste para consulta do tipo de executor do sistema que retorna uma string com Address que o type for 12. 
	 */
	@Test
	public void consultTypeSystemExecutorShouldReturnAddressWhenSystemExecutorTypeForTwelve() {
		Integer system_executor_type=12;
		String expectedValue = "Address";
		
		SystemExecutor se = SystemExecutorFactoryTests.consultSystemExecutorTwelve();
		
		se.systemExecutorType(system_executor_type);
		
		Assertions.assertEquals(expectedValue, se.systemExecutorType(system_executor_type));
	}
	
	/**
	 * @author Higor Souza
	 * Teste para consulta do tipo de executor do sistema que retorna uma string com Hospital Capacity que o type for 13. 
	 */
	@Test
	public void consultTypeSystemExecutorShouldReturnHospitalCapacityWhenSystemExecutorTypeForThirteen() {
		Integer system_executor_type=13;
		String expectedValue = "HospitalCapacity";
		
		SystemExecutor se = SystemExecutorFactoryTests.consultSystemExecutorThirteen();
		
		se.systemExecutorType(system_executor_type);
		
		Assertions.assertEquals(expectedValue, se.systemExecutorType(system_executor_type));

	}
	
	/**
	 * @author Higor Souza
	 * Teste para consulta do tipo de executor do sistema que retorna uma string com Localization que o type for 10. 
	 */
	@Test
	public void consultTypeSystemExecutorShouldReturnLocalizationWhenSystemExecutorTypeForTen() {
		Integer system_executor_type=10;
		String expectedValue = "Localization";
		
		SystemExecutor se = SystemExecutorFactoryTests.consultSystemExecutorTen();
		
		se.systemExecutorType(system_executor_type);
		
		Assertions.assertEquals(expectedValue, se.systemExecutorType(system_executor_type));

	}
	
	/**
	 * @author Higor Souza
	 * Teste para consulta do tipo de executor do sistema que retorna uma string com Hospital que o type for 11. 
	 */
	@Test
	public void consultTypeSystemExecutorShouldReturnHospitalWhenSystemExecutorTypeForEleven() {
		Integer system_executor_type=11;
		String expectedValue = "Hospital";
		
		SystemExecutor se = SystemExecutorFactoryTests.consultSystemExecutorEleven();
		
		se.systemExecutorType(system_executor_type);
		
		Assertions.assertEquals(expectedValue, se.systemExecutorType(system_executor_type));

	}
}
