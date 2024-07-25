package com.estate.information.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estate.information.entity.EstateDTO;
import com.estate.information.service.EstateService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/estate")
public class EstateController {

	final EstateService estateService;

	@GetMapping("/getEstates")
	public ResponseEntity<List<EstateDTO>> getAllEstate() {
		return ResponseEntity.ok(estateService.getAllEstate());
	}
	
	@GetMapping("/{estateId}")
	public ResponseEntity<EstateDTO> getEstate(@PathVariable("estateId")String estateId){
		return ResponseEntity.ok(estateService.getEstate(estateId).get());
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registerEstate(@RequestBody EstateDTO estate){
		estateService.registerEstate(estate);
		return ResponseEntity.ok(HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{estateId}")
	public ResponseEntity<?> updateEstate(@PathVariable("estateId") String estateId
			, @RequestBody EstateDTO estate) {
		estateService.updateEstate(estateId, estate);
		
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@DeleteMapping("/remove/{estateId}")
	public ResponseEntity<?> romveEstate(@PathVariable("estateId") String estateId) {
		estateService.removeEstate(estateId);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
}
