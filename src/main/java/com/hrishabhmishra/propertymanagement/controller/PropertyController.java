package com.hrishabhmishra.propertymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrishabhmishra.propertymanagement.dto.PropertyDTO;
import com.hrishabhmishra.propertymanagement.service.PropertyService;

@RestController // to interact with the browser.
@RequestMapping("/api/v1/property") // to map it with the url.

/**
 *We must specify which method inside the class the mapped url must go to.
 *Any http request has - get, post, put, delete, head, patch etc.
 */

public class PropertyController {
	
	
	/**
	 * Dependency Injection of Service bean in the controller layer.
	 * This is done to establish communication between controller and service layers.
	 */
	@Autowired
	PropertyService propertyService;
	
	
	//RESTfull API is just a mapping of the url with a java class method.
	//http://localhost:8080/api/v1/property/hello
	
	@GetMapping("/hello") //Handles any get request from the client side (Browser).
	// url to hit this method - http://localhost:8080/api/property/hello
	public String sayHello() {
		return "Hello - by Hrishabh.";
	}
	
	//API to create a new property in the record.
	@PostMapping("/save")
	public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO) {
		
		propertyDTO = propertyService.saveProperty(propertyDTO);
		return new ResponseEntity<>(propertyDTO, HttpStatus.CREATED); 
	}
	
	//API to retrieve all the entries from the DB
	@GetMapping("/getall")
	public ResponseEntity<List<PropertyDTO>> getAllProperties() {
		List<PropertyDTO> propertyDTOList = propertyService.getAll();
		return new ResponseEntity<>(propertyDTOList, HttpStatus.OK);
	}
	
	//API to update and existing data record.
	@PutMapping("/update/{propertyId}")
	public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
		propertyDTO = propertyService.updateProperty(propertyDTO, propertyId);
		return new ResponseEntity<>(propertyDTO, HttpStatus.OK);
	}
	
	//API to partially update the records.
	@PatchMapping("/update-title/{propertyId}")
	public ResponseEntity<PropertyDTO> updatePropertyTitle(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
		propertyDTO = propertyService.updatePropertyTitle(propertyDTO, propertyId);
		return new ResponseEntity<>(propertyDTO, HttpStatus.OK);
	}
	
	//description-Update
	@PatchMapping("/update-description/{propertyId}")
	public ResponseEntity<PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
		propertyDTO = propertyService.updatePropertyDescription(propertyDTO, propertyId);
		return new ResponseEntity<>(propertyDTO, HttpStatus.OK);
	}
	
	//address-Update
	@PatchMapping("/update-address/{propertyId}")
	public ResponseEntity<PropertyDTO> updatePropertyAddress(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
		propertyDTO = propertyService.updatePropertyAddress(propertyDTO, propertyId);
		return new ResponseEntity<>(propertyDTO, HttpStatus.OK);
	}
	
	//price-Update
	@PatchMapping("/update-price/{propertyId}")
	public ResponseEntity<PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
		propertyDTO = propertyService.updatePropertyPrice(propertyDTO, propertyId);
		return new ResponseEntity<>(propertyDTO, HttpStatus.OK);
	}
	
	//Delete property record by Id
	@DeleteMapping("/delete/{propertyId}")
	public ResponseEntity<Void> deleteProperty(@PathVariable Long propertyId) {
		propertyService.deleteProperty(propertyId);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}
