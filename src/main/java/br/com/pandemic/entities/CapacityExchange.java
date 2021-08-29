package br.com.pandemic.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

/**
 * Esta classe possui a implementação do objeto de transferÊncia de recursos entre hospitais.
 * @author Higor Souza
 *
 */

@Entity
@Table(name = "PCAS_CAPACITY_EXCHANGE")
public class CapacityExchange {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer capacity_exchange_id;
	private String item_origin;
	private String item_destiny;
	
	@OneToOne
	private HospitalCapacity hospital_capacity_id;
	
	@OneToOne
	private Hospital hospital_id;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant capacity_exchange_create_Date;
	
	public CapacityExchange() {
		
	}
	
	public CapacityExchange(Integer capacity_exchange_id, String item_origin, String item_destiny,
			HospitalCapacity hospital_capacity_id, Hospital hospital_id, Instant capacity_exchange_create_Date) {
		this.capacity_exchange_id = capacity_exchange_id;
		this.item_origin = item_origin;
		this.item_destiny = item_destiny;
		this.hospital_capacity_id = hospital_capacity_id;
		this.hospital_id = hospital_id;
		this.capacity_exchange_create_Date = capacity_exchange_create_Date;
	}
	
	public Integer getCapacity_exchange_id() {
		return capacity_exchange_id;
	}
	public void setCapacity_exchange_id(Integer capacity_exchange) {
		this.capacity_exchange_id = capacity_exchange;
	}
	public String getItem_origin() {
		return item_origin;
	}
	public void setItem_origin(String item_origin) {
		this.item_origin = item_origin;
	}
	public String getItem_destiny() {
		return item_destiny;
	}
	public void setItem_destiny(String item_destiny) {
		this.item_destiny = item_destiny;
	}
	public HospitalCapacity getHospital_capacity_id() {
		return hospital_capacity_id;
	}
	public void setHospital_capacity_id(HospitalCapacity hospital_capacity_id) {
		this.hospital_capacity_id = hospital_capacity_id;
	}
	public Hospital getHospital_id() {
		return hospital_id;
	}
	public void setHospital_id(Hospital hospital_id) {
		this.hospital_id = hospital_id;
	}
	public Instant getCapacity_exchange_create_Date() {
		return capacity_exchange_create_Date;
	}
	public void setCapacity_exchange_create_Date(Instant capacity_exchange_create_Date) {
		this.capacity_exchange_create_Date = capacity_exchange_create_Date;
	}

	@PrePersist
	public void prePersist() {
		capacity_exchange_create_Date = Instant.now();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capacity_exchange_id == null) ? 0 : capacity_exchange_id.hashCode());
		result = prime * result + ((hospital_capacity_id == null) ? 0 : hospital_capacity_id.hashCode());
		result = prime * result + ((hospital_id == null) ? 0 : hospital_id.hashCode());
		result = prime * result + ((item_destiny == null) ? 0 : item_destiny.hashCode());
		result = prime * result + ((item_origin == null) ? 0 : item_origin.hashCode());
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
		CapacityExchange other = (CapacityExchange) obj;
		if (capacity_exchange_id == null) {
			if (other.capacity_exchange_id != null)
				return false;
		} else if (!capacity_exchange_id.equals(other.capacity_exchange_id))
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
		if (item_destiny == null) {
			if (other.item_destiny != null)
				return false;
		} else if (!item_destiny.equals(other.item_destiny))
			return false;
		if (item_origin == null) {
			if (other.item_origin != null)
				return false;
		} else if (!item_origin.equals(other.item_origin))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CapacityExchange [capacity_exchange=" + capacity_exchange_id + ", item_origin=" + item_origin
				+ ", item_destiny=" + item_destiny + ", hospital_capacity_id=" + hospital_capacity_id + ", hospital_id="
				+ hospital_id + "]";
	}
		
}
