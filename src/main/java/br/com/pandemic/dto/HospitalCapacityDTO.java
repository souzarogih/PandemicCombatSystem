package br.com.pandemic.dto;

import java.io.Serializable;

import br.com.pandemic.entities.HospitalCapacity;

public class HospitalCapacityDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer hospital_capacity_id;
	private Integer hospital_capacity_number;
	private Double percentage_occupancy;
	private String item;
	private Integer score;
	
	public HospitalCapacityDTO() {
	}
	
	public HospitalCapacityDTO(Integer hospital_capacity_id, Integer hospital_capacity_number, Double percentage_occupancy, String item, Integer score) {
		this.hospital_capacity_number = hospital_capacity_number;
		this.percentage_occupancy = percentage_occupancy;
		this.item = item;
		this.score = score;
	}
	public HospitalCapacityDTO(HospitalCapacity entity) {
		this.hospital_capacity_id = entity.getHospital_capacity_id();
		this.hospital_capacity_number = entity.getHospital_capacity_number();
		this.percentage_occupancy = entity.getPercentage_occupancy();
		this.item = entity.getItem();
		this.score = entity.getScore();
	}

	public Integer getHospital_capacity_id() {
		return hospital_capacity_id;
	}

	public void setHospital_capacity_id(Integer hospital_capacity_id) {
		this.hospital_capacity_id = hospital_capacity_id;
	}

	public Integer getHospital_capacity_number() {
		return hospital_capacity_number;
	}

	public void setHospital_capacity_number(Integer hospital_capacity_number) {
		this.hospital_capacity_number = hospital_capacity_number;
	}

	public Double getPercentage_occupancy() {
		return percentage_occupancy;
	}

	public void setPercentage_occupancy(Double percentage_occupancy) {
		this.percentage_occupancy = percentage_occupancy;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hospital_capacity_number == null) ? 0 : hospital_capacity_number.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((percentage_occupancy == null) ? 0 : percentage_occupancy.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
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
		HospitalCapacityDTO other = (HospitalCapacityDTO) obj;
		if (hospital_capacity_number == null) {
			if (other.hospital_capacity_number != null)
				return false;
		} else if (!hospital_capacity_number.equals(other.hospital_capacity_number))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (percentage_occupancy == null) {
			if (other.percentage_occupancy != null)
				return false;
		} else if (!percentage_occupancy.equals(other.percentage_occupancy))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HospitalCapacityDTO [hospital_capacity=" + hospital_capacity_number + ", percentage_occupancy="
				+ percentage_occupancy + ", item=" + item + ", score=" + score + "]";
	}
	
}
