// COLORS SE USABA PARA CAMBIAR LOS COLORES DE LA PÁGINA DINÁMICAMENTE. YA NO SE USA DEBIDO A QUE SE CAMBIÓ DE CSS A SASS
package com.portfolio.martinsepulveda.Service;

import com.portfolio.martinsepulveda.Entity.Colors;
import com.portfolio.martinsepulveda.Repository.IColorsRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ColorsService {
    @Autowired IColorsRepository icolorsrepository;
    
    public List<Colors> list() {
        return icolorsrepository.findAll();
    }
    
    public Optional<Colors> getOne(int id) {
        return icolorsrepository.findById(id);
    }
    
    public void save(Colors colors) {
        icolorsrepository.save(colors);
    }
    
    public void delete(int id) {
        icolorsrepository.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return icolorsrepository.existsById(id);
    }
    
}
