package com.portfolio.martinsepulveda.Controller;

import com.portfolio.martinsepulveda.Dto.SocialDto;
import com.portfolio.martinsepulveda.Entity.Social;
import com.portfolio.martinsepulveda.Security.Controller.Message;
import com.portfolio.martinsepulveda.Service.SocialService;
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
@RequestMapping("/social")
@CrossOrigin(origins = {"https://frontendmartinsepulveda.web.app", "http://localhost:4200"})
public class SocialController {
    @Autowired
    SocialService socialService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Social>> list() {
        List<Social> list = socialService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Social> getById(@PathVariable("id") int id){
        if(!socialService.existsById(id))
            return new ResponseEntity(new Message("La cuenta no existe"), HttpStatus.NOT_FOUND);
        
        Social social = socialService.getOne(id).get();
        return new ResponseEntity(social, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody SocialDto socialDto) {
        if(StringUtils.isBlank(socialDto.getIcon()))
            return new ResponseEntity(new Message("El icono es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(socialDto.getUrl()))
            return new ResponseEntity(new Message("El link es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(socialService.existsByUrl(socialDto.getUrl()))
            return new ResponseEntity(new Message("Esa cuenta ya existe"), HttpStatus.BAD_REQUEST);
        
        Social social =  new Social(socialDto.getIcon(), socialDto.getUrl());
        socialService.save(social);
        
        return new ResponseEntity(new Message("Cuenta agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody SocialDto socialDto) {
        if(StringUtils.isBlank(socialDto.getIcon()))
            return new ResponseEntity(new Message("El icono es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(socialDto.getUrl()))
            return new ResponseEntity(new Message("El link es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(!socialService.existsById(id))
            return new ResponseEntity(new Message("La cuenta no existe"), HttpStatus.NOT_FOUND);
        
        if(socialService.existsByUrl(socialDto.getUrl()) && socialService.getByUrl(socialDto.getUrl()).get().getId() != id)
            return new ResponseEntity(new Message("Esa cuenta ya existe"), HttpStatus.BAD_REQUEST);
        
        Social social = socialService.getOne(id).get();
        social.setIcon(socialDto.getIcon());
        social.setUrl(socialDto.getUrl());
        
        socialService.save(social);
        return new ResponseEntity(new Message("Cuenta actualizada"), HttpStatus.OK);
        
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!socialService.existsById(id))
            return new ResponseEntity(new Message("La cuenta no existe"), HttpStatus.NOT_FOUND);
        
        socialService.delete(id);
        return new ResponseEntity(new Message("Cuenta eliminada"), HttpStatus.OK);
    }
    
}
