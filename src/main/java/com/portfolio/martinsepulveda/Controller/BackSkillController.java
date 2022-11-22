package com.portfolio.martinsepulveda.Controller;

import com.portfolio.martinsepulveda.Dto.BackSkillDto;
import com.portfolio.martinsepulveda.Entity.BackSkill;
import com.portfolio.martinsepulveda.Security.Controller.Message;
import com.portfolio.martinsepulveda.Service.BackSkillService;
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
@RequestMapping("/backskill")
@CrossOrigin(origins = {"https://frontendmartinsepulveda.web.app", "http://localhost:4200"})
public class BackSkillController {
    @Autowired
    BackSkillService backskillService;
    
    @GetMapping("/list")
    public ResponseEntity<List<BackSkill>> list() {
        List<BackSkill> list = backskillService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<BackSkill> getById(@PathVariable("id") int id){
        if(!backskillService.existsById(id))
            return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
        
        BackSkill backskill = backskillService.getOne(id).get();
        return new ResponseEntity(backskill, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody BackSkillDto backskillDto) {
        if(StringUtils.isBlank(backskillDto.getName()))
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(backskillService.existsByName(backskillDto.getName()))
            return new ResponseEntity(new Message("Habilidad existente"), HttpStatus.BAD_REQUEST);
        
        BackSkill backskill =  new BackSkill(backskillDto.getName(), backskillDto.getPercentage());
        backskillService.save(backskill);
        
        return new ResponseEntity(new Message("Habilidad agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody BackSkillDto backskillDto) {
        if(!backskillService.existsById(id))
            return new ResponseEntity(new Message("El ID no existe"), HttpStatus.NOT_FOUND);
        
        if(backskillService.existsByName(backskillDto.getName()) && backskillService.getByName(backskillDto.getName()).get().getId() != id)
            return new ResponseEntity(new Message("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(backskillDto.getName()))
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        BackSkill backskill = backskillService.getOne(id).get();
        backskill.setName(backskillDto.getName());
        backskill.setPercentage(backskillDto.getPercentage());
        
        backskillService.save(backskill);
        return new ResponseEntity(new Message("Habilidad actualizada"), HttpStatus.OK);
        
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!backskillService.existsById(id))
            return new ResponseEntity(new Message("El ID no existe"), HttpStatus.NOT_FOUND);
        
        backskillService.delete(id);
        return new ResponseEntity(new Message("Habilidad eliminada"), HttpStatus.OK);
    }
    
}
