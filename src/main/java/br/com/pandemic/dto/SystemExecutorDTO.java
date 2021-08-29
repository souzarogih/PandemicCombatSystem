package br.com.pandemic.dto;

import java.io.Serializable;
import java.time.Instant;

import br.com.pandemic.entities.SystemExecutor;

public class SystemExecutorDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer system_executor_id;
	private Integer system_executor_type;
	private Instant system_date_time_executor;
	private String data;
	private String method;
	
	private Integer localization_id;
	private Integer hospital_id;
	private Integer hospital_capacity_id;
	private Integer address_id;
		
	public SystemExecutorDTO() {
		
	}
	
	public SystemExecutorDTO(Integer system_executor_id, Integer system_executor_type, Instant system_date_time_executor, String data, String method) {
		this.system_executor_id = system_executor_id;
		this.system_executor_type = system_executor_type;
		this.system_date_time_executor = system_date_time_executor;
		this.data = data;
		this.method = method;
	}
	
	public SystemExecutorDTO( Integer system_executor_type, Instant system_date_time_executor, String data, String method, Integer localization_id, Integer hospital_id, Integer hospital_capacity_id, Integer address_id) {
		this.system_executor_type = system_executor_type;
		this.system_date_time_executor = system_date_time_executor;
		this.data = data;
		this.method = method;
		this.localization_id = localization_id;
		this.hospital_id=hospital_id;
		this.hospital_capacity_id=hospital_capacity_id;
		this.address_id=address_id;
	}
		
	public SystemExecutorDTO(SystemExecutor entity) {
		this.system_executor_type = entity.getSystem_executor_type();
		this.system_date_time_executor = entity.getSystem_date_time_executor();
		this.data = entity.getData();
		this.method = entity.getMethod();
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
		SystemExecutorDTO other = (SystemExecutorDTO) obj;
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
		return "SystemExecutorDTO [system_executor_id=" + system_executor_id + ", system_executor_type="
				+ system_executor_type + ", system_date_time_executor=" + system_date_time_executor + ", data=" + data
				+ ", method=" + method + ", localization_id=" + localization_id + ", hospital_id=" + hospital_id
				+ ", hospital_capacity_id=" + hospital_capacity_id + ", address_id=" + address_id + "]";
	}
	
}
