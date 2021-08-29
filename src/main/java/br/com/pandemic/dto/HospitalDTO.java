package br.com.pandemic.dto;

import java.io.Serializable;
import java.time.Instant;

import br.com.pandemic.entities.Address;
import br.com.pandemic.entities.Hospital;

public class HospitalDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer hospital_id;
	private String hospital_name;
	private Integer address;
	private String cnpj;
	private Integer localization_id;
	private Instant hospital_create_date;
	private Instant hospital_last_update;
	private Integer hospital_capacity_id;
	
	private Address address_id;
	
	public HospitalDTO() {
	}
	
	public HospitalDTO(Integer hospital_id, String hospital_name, Integer address, String cnpj, Integer localization_id,
			Instant hospital_create_date, Instant hospital_last_update, Integer hospital_capacity_id) {
		super();
		this.hospital_id = hospital_id;
		this.hospital_name = hospital_name;
		this.address = address;
		this.cnpj = cnpj;
		this.localization_id = localization_id;
		this.hospital_create_date = hospital_create_date;
		this.hospital_last_update = hospital_last_update;
		this.hospital_capacity_id = hospital_capacity_id;
	}
	
	public HospitalDTO(Hospital entity) {
		this.hospital_id = entity.getHospital_id();
		this.hospital_name = entity.getHospital_name();
		this.address = entity.getAddress();
		this.cnpj = entity.getCnpj();
		this.localization_id = entity.getLocalization_id();
		this.hospital_create_date = entity.getHospital_create_date();
		this.hospital_last_update = entity.getHospital_last_update();
		this.hospital_capacity_id = entity.getHospital_capacity_id();
	}
	
	public Address getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Address address_id) {
		this.address_id = address_id;
	}
	

	public Integer getHospital_id() {
		return hospital_id;
	}

	public void setHospital_id(Integer hospital_id) {
		this.hospital_id = hospital_id;
	}

	public String getHospital_name() {
		return hospital_name;
	}

	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}

	public Integer getAddress() {
		return address;
	}

	public void setAddress(Integer address) {
		this.address = address;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Integer getLocalization_id() {
		return localization_id;
	}

	public void setLocalization_id(Integer localization_id) {
		this.localization_id = localization_id;
	}

	public Instant getHospital_create_date() {
		return hospital_create_date;
	}

	public void setHospital_create_date(Instant hospital_create_date) {
		this.hospital_create_date = hospital_create_date;
	}

	public Instant getHospital_last_update() {
		return hospital_last_update;
	}

	public void setHospital_last_update(Instant hospital_last_update) {
		this.hospital_last_update = hospital_last_update;
	}

	public Integer getHospital_capacity_id() {
		return hospital_capacity_id;
	}

	public void setHospital_capacity_id(Integer hospital_capacity_id) {
		this.hospital_capacity_id = hospital_capacity_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((hospital_capacity_id == null) ? 0 : hospital_capacity_id.hashCode());
		result = prime * result + ((hospital_create_date == null) ? 0 : hospital_create_date.hashCode());
		result = prime * result + ((hospital_id == null) ? 0 : hospital_id.hashCode());
		result = prime * result + ((hospital_last_update == null) ? 0 : hospital_last_update.hashCode());
		result = prime * result + ((hospital_name == null) ? 0 : hospital_name.hashCode());
		result = prime * result + ((localization_id == null) ? 0 : localization_id.hashCode());
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
		HospitalDTO other = (HospitalDTO) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (hospital_capacity_id == null) {
			if (other.hospital_capacity_id != null)
				return false;
		} else if (!hospital_capacity_id.equals(other.hospital_capacity_id))
			return false;
		if (hospital_create_date == null) {
			if (other.hospital_create_date != null)
				return false;
		} else if (!hospital_create_date.equals(other.hospital_create_date))
			return false;
		if (hospital_id == null) {
			if (other.hospital_id != null)
				return false;
		} else if (!hospital_id.equals(other.hospital_id))
			return false;
		if (hospital_last_update == null) {
			if (other.hospital_last_update != null)
				return false;
		} else if (!hospital_last_update.equals(other.hospital_last_update))
			return false;
		if (hospital_name == null) {
			if (other.hospital_name != null)
				return false;
		} else if (!hospital_name.equals(other.hospital_name))
			return false;
		if (localization_id == null) {
			if (other.localization_id != null)
				return false;
		} else if (!localization_id.equals(other.localization_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HospitalDTO [hospital_id=" + hospital_id + ", hospital_name=" + hospital_name + ", address=" + address
				+ ", cnpj=" + cnpj + ", localization_id=" + localization_id + ", hospital_create_date="
				+ hospital_create_date + ", hospital_last_update=" + hospital_last_update + ", hospital_capacity_id="
				+ hospital_capacity_id + "]";
	}
	
}
