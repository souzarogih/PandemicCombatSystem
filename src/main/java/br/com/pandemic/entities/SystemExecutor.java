package br.com.pandemic.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Esta é a Classe da entidade de execução que registra todas as execuções feitas pelo programa para guarda um histórico.
 * @author Higor Souza
 *
 */

@Entity
@Table(name = "PCAS_SYSTEM_EXECUTOR")
public class SystemExecutor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer system_executor_id;
	
	private Integer system_executor_type;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant system_date_time_executor;
	private String data;
	private String method;
	
	private Integer localization_id;
	private Integer hospital_id;
	private Integer hospital_capacity_id;
	private Integer address_id;
	
	public SystemExecutor() {
		
	}
	
	public SystemExecutor(Integer system_executor_id, Integer system_executor_type, Instant system_date_time_executor, String data, String method, Integer localization_id, Integer hospital_id, Integer hospital_capacity_id, Integer address_id) {
		this.system_executor_id = system_executor_id;
		this.system_executor_type = system_executor_type;
		this.system_date_time_executor = system_date_time_executor;
		this.data = data;
		this.method = method;
		this.localization_id = localization_id;
		this.hospital_id=hospital_id;
		this.hospital_capacity_id=hospital_capacity_id;
		this.address_id=address_id;
	}
	
	public SystemExecutor(Integer system_executor_type, Instant system_date_time_executor, String data, String method, Integer localization_id, Integer hospital_id, Integer hospital_capacity_id, Integer address_id) {
		this.system_executor_type = system_executor_type;
		this.system_date_time_executor = system_date_time_executor;
		this.data = data;
		this.method = method;
		this.localization_id = localization_id;
		this.hospital_id=hospital_id;
		this.hospital_capacity_id=hospital_capacity_id;
		this.address_id=address_id;
	}
	
	public Integer getLocalization_id() {
		return localization_id;
	}

	public void setLocalization_id(Integer localization_id) {
		this.localization_id = localization_id;
	}

	public Integer getHospital_id() {
		return hospital_id;
	}

	public void setHospital_id(Integer hospital_id) {
		this.hospital_id = hospital_id;
	}

	public Integer getHospital_capacity_id() {
		return hospital_capacity_id;
	}

	public void setHospital_capacity_id(Integer hospital_capacity_id) {
		this.hospital_capacity_id = hospital_capacity_id;
	}

	public Integer getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}

	public Integer getSystem_executor_id() {
		return system_executor_id;
	}

	public void setSystem_executor_id(Integer system_executor_id) {
		this.system_executor_id = system_executor_id;
	}

	public Integer getSystem_executor_type() {
		return system_executor_type;
	}

	public void setSystem_executor_type(Integer system_executor_type) {
		this.system_executor_type = system_executor_type;
	}

	public Instant getSystem_date_time_executor() {
		return system_date_time_executor;
	}

	public void setSystem_date_time_executor(Instant system_date_time_executor) {
		this.system_date_time_executor = system_date_time_executor;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	public String systemExecutorType(Integer system_executor_type) {
		String data_type = null;
		if(system_executor_type == 10) {
			data_type = "Localization";
		}else if(system_executor_type == 11) {
			data_type = "Hospital";
		}else if(system_executor_type == 12) {
			data_type = "Address";
		}else if(system_executor_type == 13) {
			data_type = "HospitalCapacity";
		}else if((system_executor_type !=10)||(system_executor_type !=11)||(system_executor_type !=12)||(system_executor_type !=13)) {
			data_type = "Type Error";
		}
		return data_type;	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address_id == null) ? 0 : address_id.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((hospital_capacity_id == null) ? 0 : hospital_capacity_id.hashCode());
		result = prime * result + ((hospital_id == null) ? 0 : hospital_id.hashCode());
		result = prime * result + ((localization_id == null) ? 0 : localization_id.hashCode());
		result = prime * result + ((method == null) ? 0 : method.hashCode());
		result = prime * result + ((system_date_time_executor == null) ? 0 : system_date_time_executor.hashCode());
		result = prime * result + ((system_executor_id == null) ? 0 : system_executor_id.hashCode());
		result = prime * result + ((system_executor_type == null) ? 0 : system_executor_type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SystemExecutor other = (SystemExecutor) obj;
		if (address_id == null) {
			if (other.address_id != null)
				return false;
		} else if (!address_id.equals(other.address_id))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (hospital_capacity_id == null) {
			if (other.hospital_capacity_id != null)
				return false;
		} else if (!hospital_capacity_id.equals(other.hospital_capacity_id))
			return false;
		if (hospital_id == null) {
			if (other.hospital_id != null)
				return false;
		} else if (!hospital_id.equals(other.hospital_id))
			return false;
		if (localization_id == null) {
			if (other.localization_id != null)
				return false;
		} else if (!localization_id.equals(other.localization_id))
			return false;
		if (method == null) {
			if (other.method != null)
				return false;
		} else if (!method.equals(other.method))
			return false;
		if (system_date_time_executor == null) {
			if (other.system_date_time_executor != null)
				return false;
		} else if (!system_date_time_executor.equals(other.system_date_time_executor))
			return false;
		if (system_executor_id == null) {
			if (other.system_executor_id != null)
				return false;
		} else if (!system_executor_id.equals(other.system_executor_id))
			return false;
		if (system_executor_type == null) {
			if (other.system_executor_type != null)
				return false;
		} else if (!system_executor_type.equals(other.system_executor_type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SystemExecutor [system_executor_id=" + system_executor_id + ", system_executor_type="
				+ system_executor_type + ", system_date_time_executor=" + system_date_time_executor + ", data=" + data
				+ ", method=" + method + ", localization_id=" + localization_id + ", hospital_id=" + hospital_id
				+ ", hospital_capacity_id=" + hospital_capacity_id + ", address_id=" + address_id + "]";
	}
		
}
