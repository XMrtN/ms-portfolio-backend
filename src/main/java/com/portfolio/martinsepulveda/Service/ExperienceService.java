package com.portfolio.martinsepulveda.Service;

import com.portfolio.martinsepulveda.Entity.Experience;
import com.portfolio.martinsepulveda.Repository.IExperienceRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienceService {
    @Autowired
    IExperienceRepository iexperienceRepository;
    
    public List<Experience> list() {
        return iexperienceRepository.findAll();
    }
    
    public Optional<Experience> getOne(int id) {
        return iexperienceRepository.findById(id);
    }
    
    public Optional<Experience> getByExpName(String expName) {
        return iexperienceRepository.findByExpName(expName);
    }
    
    public void save(Experience exp) {
        iexperienceRepository.save(exp);
    }
    
    public void delete(int id) {
        iexperienceRepository.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return iexperienceRepository.existsById(id);
    }
    
    public boolean existsByExpName(String expName) {
        return iexperienceRepository.existsByExpName(expName);
    }
    
}
