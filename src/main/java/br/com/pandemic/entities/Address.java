package br.com.pandemic.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

/**
 * Esta classe possui a implementação do objeto de endereço de um hospital.
 * @author Higor Souza
 *
 */

@Entity
@Table(name = "PCAS_ADDRESS")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer address_id;
	
	private String street;
	private String number;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant address_create_date;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant address_last_update;
	
	@OneToOne
	private Hospital hospital;
	
	public Address() {
		
	}
	
	public Address(Integer address_id, String street, String number, Instant address_create_date,
			Instant address_last_update) {
		this.address_id = address_id;
		this.street = street;
		this.number = number;
		this.address_create_date = address_create_date;
		this.address_last_update = address_last_update;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Integer getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Instant getAddress_create_date() {
		return address_create_date;
	}

	public void setAddress_create_date(Instant address_create_date) {
		this.address_create_date = address_create_date;
	}

	public Instant getAddress_last_update() {
		return address_last_update;
	}

	public void setAddress_last_update(Instant address_last_update) {
		this.address_last_update = address_last_update;
	}
	
	@PrePersist
	public void prePersist() {
		address_create_date = Instant.now();
	}
	
	@PreUpdate
	public void preUpdate() {
		address_last_update = Instant.now();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address_create_date == null) ? 0 : address_create_date.hashCode());
		result = prime * result + ((address_id == null) ? 0 : address_id.hashCode());
		result = prime * result + ((address_last_update == null) ? 0 : address_last_update.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
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
		Address other = (Address) obj;
		if (address_create_date == null) {
			if (other.address_create_date != null)
				return false;
		} else if (!address_create_date.equals(other.address_create_date))
			return false;
		if (address_id == null) {
			if (other.address_id != null)
				return false;
		} else if (!address_id.equals(other.address_id))
			return false;
		if (address_last_update == null) {
			if (other.address_last_update != null)
				return false;
		} else if (!address_last_update.equals(other.address_last_update))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", street=" + street + ", number=" + number
				+ ", address_create_date=" + address_create_date + ", address_last_update=" + address_last_update + "]";
	}
		
}
