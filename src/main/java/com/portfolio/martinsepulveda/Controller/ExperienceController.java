package com.portfolio.martinsepulveda.Controller;

import com.portfolio.martinsepulveda.Dto.ExperienceDto;
import com.portfolio.martinsepulveda.Entity.Experience;
import com.portfolio.martinsepulveda.Security.Controller.Message;
import com.portfolio.martinsepulveda.Service.ExperienceService;
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
@RequestMapping("/explab")
@CrossOrigin(origins = {"https://martinsepulvedaportfolio.web.app", "http://localhost:4200"})
public class ExperienceController {
    @Autowired
    ExperienceService experienceService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Experience>> list() {
        List<Experience> list = experienceService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experience> getById(@PathVariable("id") int id) {
        if(!experienceService.existsById(id))
            return new ResponseEntity(new Message("La experiencia no existe"), HttpStatus.NOT_FOUND);
        
        Experience experience = experienceService.getOne(id).get();
        return new ResponseEntity(experience, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ExperienceDto expDto) {
        if(StringUtils.isBlank(expDto.getExpCompName()))
            return new ResponseEntity(new Message("El nombre de la compañía es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(expDto.getExpJobTitle()))
            return new ResponseEntity(new Message("El nombre del puesto es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(expDto.getExpPeriod()))
            return new ResponseEntity(new Message("El periodo de tiempo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(experienceService.existsByExpJobTitle(expDto.getExpJobTitle()))
            return new ResponseEntity(new Message("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        Experience experience =  new Experience(expDto.getPosition(), expDto.getExpCompName(), expDto.getExpJobTitle(), expDto.getExpPeriod(), expDto.getExpDesc());
        experienceService.save(experience);
        
        return new ResponseEntity(new Message("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ExperienceDto expDto) {
        if(StringUtils.isBlank(expDto.getExpCompName()))
            return new ResponseEntity(new Message("El nombre de la compañía es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(expDto.getExpJobTitle()))
            return new ResponseEntity(new Message("El nombre del puesto es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(expDto.getExpPeriod()))
            return new ResponseEntity(new Message("El periodo de tiempo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(!experienceService.existsById(id))
            return new ResponseEntity(new Message("La experiencia no existe"), HttpStatus.NOT_FOUND);
        
        if(experienceService.existsByExpJobTitle(expDto.getExpJobTitle()) && experienceService.getByExpJobTitle(expDto.getExpJobTitle()).get().getId() != id)
            return new ResponseEntity(new Message("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        Experience experience = experienceService.getOne(id).get();
        experience.setExpCompName(expDto.getExpCompName());
        experience.setExpJobTitle(expDto.getExpJobTitle());
        experience.setExpPeriod(expDto.getExpPeriod());
        experience.setExpDesc(expDto.getExpDesc());
        
        experienceService.save(experience);
        return new ResponseEntity(new Message("Experiencia actualizada"), HttpStatus.OK);
        
    }
    
    @PutMapping("/updatepos/{id}")
    public ResponseEntity<?> updatePos(@PathVariable("id") int id, @RequestBody ExperienceDto expDto) {
        if(!experienceService.existsById(id))
            return new ResponseEntity(new Message("La experiencia no existe"), HttpStatus.NOT_FOUND);
        
        Experience experience = experienceService.getOne(id).get();
        experience.setPosition(expDto.getPosition());
        
        experienceService.save(experience);
        return new ResponseEntity(new Message("Posición actualizada"), HttpStatus.OK);
        
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!experienceService.existsById(id))
            return new ResponseEntity(new Message("La experiencia no existe"), HttpStatus.NOT_FOUND);
        
        experienceService.delete(id);
        return new ResponseEntity(new Message("Experiencia eliminada"), HttpStatus.OK);
    }

}
