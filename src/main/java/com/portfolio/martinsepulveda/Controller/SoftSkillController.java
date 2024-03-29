package com.portfolio.martinsepulveda.Controller;

import com.portfolio.martinsepulveda.Dto.SoftSkillDto;
import com.portfolio.martinsepulveda.Entity.SoftSkill;
import com.portfolio.martinsepulveda.Security.Controller.Message;
import com.portfolio.martinsepulveda.Service.SoftSkillService;
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
@RequestMapping("/softskill")
@CrossOrigin(origins = {"https://martinsepulvedaportfolio.web.app", "http://localhost:4200"})
public class SoftSkillController {
    @Autowired
    SoftSkillService softskillService;
    
    @GetMapping("/list")
    public ResponseEntity<List<SoftSkill>> list() {
        List<SoftSkill> list = softskillService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<SoftSkill> getById(@PathVariable("id") int id){
        if(!softskillService.existsById(id))
            return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
        
        SoftSkill softskill = softskillService.getOne(id).get();
        return new ResponseEntity(softskill, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody SoftSkillDto softskillDto) {
        if(StringUtils.isBlank(softskillDto.getName()))
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(softskillService.existsByName(softskillDto.getName()))
            return new ResponseEntity(new Message("Habilidad existente"), HttpStatus.BAD_REQUEST);
        
        SoftSkill softskill =  new SoftSkill(softskillDto.getPosition(), softskillDto.getName(), softskillDto.getPercentage());
        softskillService.save(softskill);
        
        return new ResponseEntity(new Message("Habilidad agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody SoftSkillDto softskillDto) {
        if(!softskillService.existsById(id))
            return new ResponseEntity(new Message("El ID no existe"), HttpStatus.NOT_FOUND);
        
        if(softskillService.existsByName(softskillDto.getName()) && softskillService.getByName(softskillDto.getName()).get().getId() != id)
            return new ResponseEntity(new Message("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(softskillDto.getName()))
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        SoftSkill softskill = softskillService.getOne(id).get();
        softskill.setName(softskillDto.getName());
        softskill.setPercentage(softskillDto.getPercentage());
        
        softskillService.save(softskill);
        return new ResponseEntity(new Message("Habilidad actualizada"), HttpStatus.OK);
        
    }
    
    @PutMapping("/updatepos/{id}")
    public ResponseEntity<?> updatePos(@PathVariable("id") int id, @RequestBody SoftSkillDto softskillDto) {
        if(!softskillService.existsById(id))
            return new ResponseEntity(new Message("El ID no existe"), HttpStatus.NOT_FOUND);
        
        SoftSkill softskill = softskillService.getOne(id).get();
        softskill.setPosition(softskillDto.getPosition());
        
        softskillService.save(softskill);
        return new ResponseEntity(new Message("Posición actualizada"), HttpStatus.OK);
        
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!softskillService.existsById(id))
            return new ResponseEntity(new Message("El ID no existe"), HttpStatus.NOT_FOUND);
        
        softskillService.delete(id);
        return new ResponseEntity(new Message("Habilidad eliminada"), HttpStatus.OK);
    }
    
}
