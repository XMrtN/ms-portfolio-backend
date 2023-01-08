// COLORS SE USABA PARA CAMBIAR LOS COLORES DE LA PÁGINA DINÁMICAMENTE. YA NO SE USA DEBIDO A QUE SE CAMBIÓ DE CSS A SASS
package com.portfolio.martinsepulveda.Controller;

import com.portfolio.martinsepulveda.Dto.ColorsDto;
import com.portfolio.martinsepulveda.Entity.Colors;
import com.portfolio.martinsepulveda.Security.Controller.Message;
import com.portfolio.martinsepulveda.Service.ColorsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colors")
@CrossOrigin(origins = {"https://martinsepulvedaportfolio.web.app", "http://localhost:4200"})
public class ColorsController {
    @Autowired
    ColorsService colorsService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Colors>> list() {
        List<Colors> list = colorsService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Colors> getById(@PathVariable("id") int id){
        if(!colorsService.existsById(id))
            return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
        
        Colors colors = colorsService.getOne(id).get();
        return new ResponseEntity(colors, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ColorsDto colorsDto) {
        Colors colors =  new Colors(colorsDto.getFirstColor(), colorsDto.getSecondColor());
        colorsService.save(colors);
        
        return new ResponseEntity(new Message("Colores agregados"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ColorsDto colorsDto) {
        if(!colorsService.existsById(id))
            return new ResponseEntity(new Message("El ID no existe"), HttpStatus.NOT_FOUND);
        
        Colors colors = colorsService.getOne(id).get();
        colors.setFirstColor(colorsDto.getFirstColor());
        colors.setSecondColor(colorsDto.getSecondColor());
        
        colorsService.save(colors);
        return new ResponseEntity(new Message("Colores actualizados"), HttpStatus.OK);
        
    }
    
    /*@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!colorsService.existsById(id))
            return new ResponseEntity(new Message("El ID no existe"), HttpStatus.NOT_FOUND);
        
        colorsService.delete(id);
        return new ResponseEntity(new Message("Colores eliminados"), HttpStatus.OK);
    }*/
}
