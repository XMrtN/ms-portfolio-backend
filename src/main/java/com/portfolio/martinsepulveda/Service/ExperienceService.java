package com.portfolio.martinsepulveda.Service;

import com.portfolio.martinsepulveda.Entity.Experience;
import com.portfolio.martinsepulveda.Repository.IExperienceRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienceService {
    @Autowired
    IExperienceRepository iexperienceRepository;
    
    public List<Experience> list() {
        return iexperienceRepository.findAll(Sort.by("position"));
    }
    
    public Optional<Experience> getOne(int id) {
        return iexperienceRepository.findById(id);
    }
    
    public Optional<Experience> getByExpJobTitle(String expJobTitle) {
        return iexperienceRepository.findByExpJobTitle(expJobTitle);
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
    
    public boolean existsByExpJobTitle(String expJobTitle) {
        return iexperienceRepository.existsByExpJobTitle(expJobTitle);
    }
    
}
