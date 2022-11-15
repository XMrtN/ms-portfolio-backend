package com.portfolio.martinsepulveda.Controller;

import com.portfolio.martinsepulveda.Entity.Person;
import com.portfolio.martinsepulveda.Interface.IPersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {
    @Autowired IPersonService ipersonservice;
    
    @GetMapping("person/get")
    public List<Person> getPerson() {
        return ipersonservice.getPerson();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("person/create")
    public String createPerson(@RequestBody Person person) {
        ipersonservice.savePerson(person);
        return "La persona fue creada";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("person/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        ipersonservice.deletePerson(id);
        return "La persona fue eliminada";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("person/edit/{id}")
    public Person editPerson(@PathVariable Long id,
                             @RequestParam("name") String newName,
                             @RequestParam("lastName") String newLastName,
                             @RequestParam("img") String newImg) {
        Person person = ipersonservice.findPerson(id);
        person.setName(newName);
        person.setLastName(newLastName);
        person.setImg(newImg);
        
        ipersonservice.savePerson(person);
        return person;
    }
    
    @GetMapping("person/get/profile")
    public Person findPerson() {
        return ipersonservice.findPerson((long)4);
    }
}
