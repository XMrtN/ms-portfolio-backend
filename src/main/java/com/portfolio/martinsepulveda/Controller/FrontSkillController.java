package com.portfolio.martinsepulveda.Controller;

import com.portfolio.martinsepulveda.Dto.FrontSkillDto;
import com.portfolio.martinsepulveda.Entity.FrontSkill;
import com.portfolio.martinsepulveda.Security.Controller.Message;
import com.portfolio.martinsepulveda.Service.FrontSkillService;
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
@RequestMapping("/frontskill")
@CrossOrigin(origins = "http://localhost:4200")
public class FrontSkillController {
    @Autowired
    FrontSkillService frontskillService;
    
    @GetMapping("/list")
    public ResponseEntity<List<FrontSkill>> list() {
        List<FrontSkill> list = frontskillService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<FrontSkill> getById(@PathVariable("id") int id){
        if(!frontskillService.existsById(id))
            return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
        
        FrontSkill frontskill = frontskillService.getOne(id).get();
        return new ResponseEntity(frontskill, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody FrontSkillDto frontskillDto) {
        if(StringUtils.isBlank(frontskillDto.getName()))
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(frontskillService.existsByName(frontskillDto.getName()))
            return new ResponseEntity(new Message("Habilidad existente"), HttpStatus.BAD_REQUEST);
        
        FrontSkill frontskill =  new FrontSkill(frontskillDto.getName(), frontskillDto.getPercentage());
        frontskillService.save(frontskill);
        
        return new ResponseEntity(new Message("Habilidad agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody FrontSkillDto frontskillDto) {
        if(!frontskillService.existsById(id))
            return new ResponseEntity(new Message("El ID no existe"), HttpStatus.NOT_FOUND);
        
        if(frontskillService.existsByName(frontskillDto.getName()) && frontskillService.getByName(frontskillDto.getName()).get().getId() != id)
            return new ResponseEntity(new Message("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(frontskillDto.getName()))
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        FrontSkill frontskill = frontskillService.getOne(id).get();
        frontskill.setName(frontskillDto.getName());
        frontskill.setPercentage(frontskillDto.getPercentage());
        
        frontskillService.save(frontskill);
        return new ResponseEntity(new Message("Habilidad actualizada"), HttpStatus.OK);
        
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!frontskillService.existsById(id))
            return new ResponseEntity(new Message("El ID no existe"), HttpStatus.NOT_FOUND);
        
        frontskillService.delete(id);
        return new ResponseEntity(new Message("Habilidad eliminada"), HttpStatus.OK);
    }
    
}
