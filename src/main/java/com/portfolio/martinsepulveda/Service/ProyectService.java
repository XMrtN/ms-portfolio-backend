package com.portfolio.martinsepulveda.Service;

import com.portfolio.martinsepulveda.Entity.Proyect;
import com.portfolio.martinsepulveda.Repository.IProyectRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectService {
    @Autowired IProyectRepository iproyectrepository;
    
    public List<Proyect> list() {
        return iproyectrepository.findAll(Sort.by("position"));
    }
    
    public Optional<Proyect> getOne(int id) {
        return iproyectrepository.findById(id);
    }
    
    public Optional<Proyect> getByTitle(String title) {
        return iproyectrepository.findByTitle(title);
    }
    
    public void save(Proyect proyect) {
        iproyectrepository.save(proyect);
    }
    
    public void delete(int id) {
        iproyectrepository.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return iproyectrepository.existsById(id);
    }
    
    public boolean existsByTitle(String title) {
        return iproyectrepository.existsByTitle(title);
    }
}
