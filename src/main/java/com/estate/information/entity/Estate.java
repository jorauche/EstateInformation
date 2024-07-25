package com.estate.information.entity;

import static com.estate.information.util.Constants.GENERATOR;

import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "estate")
public class Estate {

	@Id
	@GeneratedValue(generator = GENERATOR)
	@GenericGenerator(name = GENERATOR, strategy = "org.hibernate.id.UUIDGenerator")
	private String estateId;
	private String name;
	private String phoneNumber;
	private String address;
	@Column(name = "description", length = 1024)
	private String description;
	private String uri;
	
	@Transient
	@JsonIgnore
	public EstateDTO getDTO() {
		return EstateDTO.builder()
				.estateId(getEstateId())
				.name(getName())
				.phoneNumber(getPhoneNumber())
				.address(getAddress())
				.description(getDescription())
				.uri(getUri())
				.build();
	}
	
	
}
