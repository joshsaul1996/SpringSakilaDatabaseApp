package qa.saul.josh.spring.database.SpringDatabaseApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import qa.saul.josh.spring.database.SpringDatabaseApp.exception.ResourceNotFoundException;
import qa.saul.josh.spring.database.SpringDatabaseApp.model.*;
import qa.saul.josh.spring.database.SpringDatabaseApp.repository.SpringBootRepository;

@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	SpringBootRepository Repository;
	
	// Method to create a person
	@PostMapping("/person")
	public SpringBootDataModel createPerson(@Valid @RequestBody SpringBootDataModel mSDM) {
		return Repository.save(mSDM);
	}

	// Method to get a person 
	@GetMapping("person/{id}")
	public SpringBootDataModel getPersonByID(@PathVariable(value = "id") Long personID) {
		return Repository.findById(personID).orElseThrow(()-> new ResourceNotFoundException("SpringBootDataModel","id",personID));
	}
	//Method to get all people
	@GetMapping("/person")
	public List<SpringBootDataModel> getAllPeople(){
		return Repository.findAll();
	}
	
	//Method to update a person 
	@PutMapping("/person/{id}")
	public SpringBootDataModel updatePerson(@PathVariable(value = "id") Long personID,
			@Valid @RequestBody SpringBootDataModel personDetails) {
		
		SpringBootDataModel mSDM =Repository.findById(personID).orElseThrow(()-> new ResourceNotFoundException("Person","id",personID));
		
		
		mSDM.setName(personDetails.getName());
		mSDM.setAddress(personDetails.getAddress());
		mSDM.setAge(personDetails.getAge());
		
		SpringBootDataModel updateData = Repository.save(mSDM);
		return updateData;
	}
	
	
	//Method to remove a person
	@DeleteMapping("/person/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable(value = "id") Long personID){
		SpringBootDataModel mSDM = Repository.findById(personID).orElseThrow(()-> new ResourceNotFoundException("Person","id", personID));
		
		Repository.delete(mSDM);
		return ResponseEntity.ok().build();
		
	}
	
	}

