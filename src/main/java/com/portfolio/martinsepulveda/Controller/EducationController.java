package com.portfolio.martinsepulveda.Controller;

import com.portfolio.martinsepulveda.Dto.EducationDto;
import com.portfolio.martinsepulveda.Entity.Education;
import com.portfolio.martinsepulveda.Security.Controller.Message;
import com.portfolio.martinsepulveda.Service.EducationService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/edu")
@CrossOrigin(origins = "http://localhost:4200")
public class EducationController {
    @Autowired
    EducationService educationService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Education>> list() {
        List<Education> list = educationService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") int id){
        if(!educationService.existsById(id))
            return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
        
        Education education = educationService.getOne(id).get();
        return new ResponseEntity(education, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EducationDto edDto) {
        if(StringUtils.isBlank(edDto.getEdName()))
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(educationService.existsByEdName(edDto.getEdName()))
            return new ResponseEntity(new Message("Educación existente"), HttpStatus.BAD_REQUEST);
        
        Education education =  new Education(edDto.getEdName(), edDto.getEdDesc());
        educationService.save(education);
        
        return new ResponseEntity(new Message("Educación agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody EducationDto edDto) {
        if(!educationService.existsById(id))
            return new ResponseEntity(new Message("El ID no existe"), HttpStatus.NOT_FOUND);
        
        if(educationService.existsByEdName(edDto.getEdName()) && educationService.getByEdName(edDto.getEdName()).get().getId() != id)
            return new ResponseEntity(new Message("Esa educación ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(edDto.getEdName()))
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Education education = educationService.getOne(id).get();
        education.setEdName(edDto.getEdName());
        education.setEdDesc(edDto.getEdDesc());
        
        educationService.save(education);
        return new ResponseEntity(new Message("Educación actualizada"), HttpStatus.OK);
        
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!educationService.existsById(id))
            return new ResponseEntity(new Message("El ID no existe"), HttpStatus.NOT_FOUND);
        
        educationService.delete(id);
        return new ResponseEntity(new Message("Educación eliminada"), HttpStatus.OK);
    }
    
}
