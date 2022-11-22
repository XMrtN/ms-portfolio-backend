package com.portfolio.martinsepulveda.Controller;

import com.portfolio.martinsepulveda.Dto.ProyectDto;
import com.portfolio.martinsepulveda.Entity.Proyect;
import com.portfolio.martinsepulveda.Security.Controller.Message;
import com.portfolio.martinsepulveda.Service.ProyectService;
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
@RequestMapping("/proyect")
@CrossOrigin(origins = {"https://frontendmartinsepulveda.web.app", "http://localhost:4200"})
public class ProyectController {
    @Autowired
    ProyectService proyectService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Proyect>> list() {
        List<Proyect> list = proyectService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyect> getById(@PathVariable("id") int id){
        if(!proyectService.existsById(id))
            return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
        
        Proyect proyect = proyectService.getOne(id).get();
        return new ResponseEntity(proyect, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProyectDto proyectDto) {
        if(StringUtils.isBlank(proyectDto.getTitle()))
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(proyectService.existsByTitle(proyectDto.getTitle()))
            return new ResponseEntity(new Message("Proyecto existente"), HttpStatus.BAD_REQUEST);
        
        Proyect proyect =  new Proyect(proyectDto.getTitle(), proyectDto.getSubtitle(), proyectDto.getDescription(), proyectDto.getImg(), proyectDto.getUrl());
        proyectService.save(proyect);
        
        return new ResponseEntity(new Message("Proyecto agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProyectDto proyectDto) {
        if(!proyectService.existsById(id))
            return new ResponseEntity(new Message("El ID no existe"), HttpStatus.NOT_FOUND);
        
        if(proyectService.existsByTitle(proyectDto.getTitle()) && proyectService.getByTitle(proyectDto.getTitle()).get().getId() != id)
            return new ResponseEntity(new Message("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(proyectDto.getTitle()))
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyect proyect = proyectService.getOne(id).get();
        proyect.setTitle(proyectDto.getTitle());
        proyect.setSubtitle(proyectDto.getSubtitle());
        proyect.setDescription(proyectDto.getDescription());
        proyect.setImg(proyectDto.getImg());
        
        proyectService.save(proyect);
        return new ResponseEntity(new Message("Proyecto actualizado"), HttpStatus.OK);
        
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!proyectService.existsById(id))
            return new ResponseEntity(new Message("El ID no existe"), HttpStatus.NOT_FOUND);
        
        proyectService.delete(id);
        return new ResponseEntity(new Message("Proyecto eliminado"), HttpStatus.OK);
    }
    
}
