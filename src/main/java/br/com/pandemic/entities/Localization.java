package br.com.pandemic.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

/**
 * Esta classe possui a implementação do objeto de localização de um hospital.
 * @author Higor Souza
 *
 */

@Entity
@Table(name = "PCAS_LOCALIZATION")
public class Localization {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer localization_id;
	
	private String lat;
	private String lng;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant localization_create_date;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant localization_last_update;
	
	public Localization() {
		
	}
	
	public Localization(Integer localization_id, String lat, String lng, Instant localization_create_date,
			Instant localization_last_update) {
		this.localization_id = localization_id;
		this.lat = lat;
		this.lng = lng;
		this.localization_create_date = localization_create_date;
		this.localization_last_update = localization_last_update;
	}

	public Integer getLocalization_id() {
		return localization_id;
	}

	public void setLocalization_id(Integer localization_id) {
		this.localization_id = localization_id;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public Instant getLocalization_create_date() {
		return localization_create_date;
	}

	public void setLocalization_create_date(Instant localization_create_date) {
		this.localization_create_date = localization_create_date;
	}

	public Instant getLocalization_last_update() {
		return localization_last_update;
	}

	public void setLocalization_last_update(Instant localization_last_update) {
		this.localization_last_update = localization_last_update;
	}
	
	@PrePersist
	public void prePersist() {
		localization_create_date = Instant.now();
	}
	
	@PreUpdate
	public void preUpdate() {
		localization_last_update = Instant.now();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lat == null) ? 0 : lat.hashCode());
		result = prime * result + ((lng == null) ? 0 : lng.hashCode());
		result = prime * result + ((localization_create_date == null) ? 0 : localization_create_date.hashCode());
		result = prime * result + ((localization_id == null) ? 0 : localization_id.hashCode());
		result = prime * result + ((localization_last_update == null) ? 0 : localization_last_update.hashCode());
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
		Localization other = (Localization) obj;
		if (lat == null) {
			if (other.lat != null)
				return false;
		} else if (!lat.equals(other.lat))
			return false;
		if (lng == null) {
			if (other.lng != null)
				return false;
		} else if (!lng.equals(other.lng))
			return false;
		if (localization_create_date == null) {
			if (other.localization_create_date != null)
				return false;
		} else if (!localization_create_date.equals(other.localization_create_date))
			return false;
		if (localization_id == null) {
			if (other.localization_id != null)
				return false;
		} else if (!localization_id.equals(other.localization_id))
			return false;
		if (localization_last_update == null) {
			if (other.localization_last_update != null)
				return false;
		} else if (!localization_last_update.equals(other.localization_last_update))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Localization [localization_id=" + localization_id + ", lat=" + lat + ", lng=" + lng
				+ ", localization_create_date=" + localization_create_date + ", localization_last_update="
				+ localization_last_update + "]";
	}
	
}
