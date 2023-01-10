package com.hrishabhMishra.PropertyManagement.controller;

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

import com.hrishabhMishra.PropertyManagement.DTO.PropertyDTO;
import com.hrishabhMishra.PropertyManagement.service.PropertyService;

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
		//propertyService.saveProperty(propertyDTO); //Sending the data received from the client to the service layer.
		//System.out.println(propertyDTO);
		
		propertyDTO = propertyService.saveProperty(propertyDTO);
		ResponseEntity<PropertyDTO> re = new ResponseEntity<PropertyDTO>(propertyDTO, HttpStatus.CREATED); 
		return re;
	}
	
	//API to retrieve all the entries from the DB
	@GetMapping("/getall")
	public ResponseEntity<List<PropertyDTO>> getAllProperties() {
		List<PropertyDTO> propertyDTOList = propertyService.getAll();
		ResponseEntity<List<PropertyDTO>> response = new ResponseEntity<List<PropertyDTO>>(propertyDTOList, HttpStatus.OK);
		return response;
	}
	
	//API to update and existing data record.
	@PutMapping("/update/{propertyId}")
	public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
		propertyDTO = propertyService.updateProperty(propertyDTO, propertyId);
		ResponseEntity<PropertyDTO> response = new ResponseEntity<PropertyDTO>(propertyDTO, HttpStatus.OK);
		return response;
	}
	
	//API to partially update the records.
	@PatchMapping("/update-title/{propertyId}")
	public ResponseEntity<PropertyDTO> updatePropertyTitle(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
		propertyDTO = propertyService.updatePropertyTitle(propertyDTO, propertyId);
		ResponseEntity<PropertyDTO> response = new ResponseEntity<PropertyDTO>(propertyDTO, HttpStatus.OK);
		
		return response;
	}
	
	//description-Update
	@PatchMapping("/update-description/{propertyId}")
	public ResponseEntity<PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
		propertyDTO = propertyService.updatePropertyDescription(propertyDTO, propertyId);
		ResponseEntity<PropertyDTO> response = new ResponseEntity<PropertyDTO>(propertyDTO, HttpStatus.OK);
		
		return response;
	}
	
	//OwnerName-Update
//	@PatchMapping("/update-ownerName/{propertyId}")
//	public ResponseEntity<PropertyDTO> updatePropertyOwnerName(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
//		propertyDTO = propertyService.updatePropertyOwnerName(propertyDTO, propertyId);
//		ResponseEntity<PropertyDTO> response = new ResponseEntity<PropertyDTO>(propertyDTO, HttpStatus.OK);
//		
//		return response;
//	}
	//OwnerName field transfered to UserRegistration flow.
	
	//address-Update
	@PatchMapping("/update-address/{propertyId}")
	public ResponseEntity<PropertyDTO> updatePropertyAddress(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
		propertyDTO = propertyService.updatePropertyAddress(propertyDTO, propertyId);
		ResponseEntity<PropertyDTO> response = new ResponseEntity<PropertyDTO>(propertyDTO, HttpStatus.OK);
		
		return response;
	}
	
	//price-Update
	@PatchMapping("/update-price/{propertyId}")
	public ResponseEntity<PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
		propertyDTO = propertyService.updatePropertyPrice(propertyDTO, propertyId);
		ResponseEntity<PropertyDTO> response = new ResponseEntity<PropertyDTO>(propertyDTO, HttpStatus.OK);
		
		return response;
	}
	
	//Delete property record by Id
	@DeleteMapping("/delete/{propertyId}")
	public ResponseEntity deleteProperty(@PathVariable Long propertyId) {
		propertyService.deleteProperty(propertyId);
		ResponseEntity response = new ResponseEntity(HttpStatus.OK);
		
		return response;
	}

}
