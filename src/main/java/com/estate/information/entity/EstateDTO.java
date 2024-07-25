package com.estate.information.entity;

import java.beans.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EstateDTO {

	private String estateId;
	private String name;
	private String phoneNumber;
	private String address;
	private String description;
	private String uri;
	
	@Transient
	@JsonIgnore
	public Estate getEntity() {
		return Estate.builder()
				.estateId(getEstateId())
				.name(getName())
				.phoneNumber(getPhoneNumber())
				.address(getAddress())
				.description(getDescription())
				.uri(getUri())
				.build();
	}
}
