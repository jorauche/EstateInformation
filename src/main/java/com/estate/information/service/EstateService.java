package com.estate.information.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.estate.information.entity.Estate;
import com.estate.information.entity.EstateDTO;
import com.estate.information.repository.EstateRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class EstateService {
	
	final EstateRepository estateRepository;
	
	public List<EstateDTO> getAllEstate(){
		log.info("get all estates from CDMX");
		List<EstateDTO> lstEstate = new ArrayList<>();
		estateRepository.findAll().forEach(itemData -> {
			var estateDao = itemData.getDTO();
			lstEstate.add(estateDao);
		});
		return lstEstate;
	}
	
	public Optional<EstateDTO> getEstate(String estateId) {
		log.info("get details of estate");
		return Optional.of(estateRepository.findById(estateId).get().getDTO());
		
	}
	
	public void registerEstate(EstateDTO estateDto){
		log.info("Register new estate");
		estateRepository.save(estateDto.getEntity());
	}
	
	public void updateEstate(String estateId, EstateDTO estateDto) {
		Optional<Estate> estateDAO = estateRepository.findById(estateId);
		if(estateDAO.isPresent()) {
			estateDto.setEstateId(estateId);
			estateRepository.save(estateDto.getEntity());
		}
	}
	
	
	public void removeEstate(String estateId)  {
		log.info("Remove a especific estate");
		estateRepository.deleteById(estateId);
	}

}
