package com.portfolio.martinsepulveda.Controller;

import com.portfolio.martinsepulveda.Dto.PersonDto;
import com.portfolio.martinsepulveda.Entity.Person;
import com.portfolio.martinsepulveda.Security.Controller.Message;
import com.portfolio.martinsepulveda.Service.PersonService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {
    @Autowired
    PersonService personService;
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Person> getById(@PathVariable("id") int id){
        if(!personService.existsById(id))
            return new ResponseEntity(new Message("No existe"), HttpStatus.BAD_REQUEST);
        
        Person person = personService.getOne(id).get();
        return new ResponseEntity(person, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public ResponseEntity<List<Person>> list() {
        List<Person> list = personService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    /*@PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PersonDto personDto) {
        if(StringUtils.isBlank(personDto.getName()))
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(personService.existsByName(personDto.getName()))
            return new ResponseEntity(new Message("Persona existente"), HttpStatus.BAD_REQUEST);
        
        Person person =  new Person(personDto.getName(), personDto.getDescription());
        personService.save(person);
        
        return new ResponseEntity(new Message("Persona agregada"), HttpStatus.OK);
    }*/
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody PersonDto personDto) {
        if(!personService.existsById(id))
            return new ResponseEntity(new Message("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        if(personService.existsByName(personDto.getName()) && personService.getByName(personDto.getName()).get().getId() != id)
            return new ResponseEntity(new Message("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(personDto.getName()))
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Person person = personService.getOne(id).get();
        person.setName(personDto.getName());
        person.setLastName(personDto.getLastName());
        person.setDescription(personDto.getDescription());
        person.setImg(personDto.getImg());
        
        personService.save(person);
        return new ResponseEntity(new Message("Persona actualizada"), HttpStatus.OK);
        
    }
    
    /*@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!personService.existsById(id))
            return new ResponseEntity(new Message("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        personService.delete(id);
        return new ResponseEntity(new Message("Persona eliminada"), HttpStatus.OK);
    }*/
    
}
