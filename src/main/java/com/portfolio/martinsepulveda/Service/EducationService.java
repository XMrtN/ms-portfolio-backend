package com.portfolio.martinsepulveda.Service;

import com.portfolio.martinsepulveda.Entity.Education;
import com.portfolio.martinsepulveda.Repository.IEducationRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducationService {
    @Autowired
    IEducationRepository ieducationRepository;
    
    public List<Education> list() {
        return ieducationRepository.findAll(Sort.by("position"));
    }
    
    public Optional<Education> getOne(int id) {
        return ieducationRepository.findById(id);
    }
    
    public Optional<Education> getByEdCareerName(String edCareerName) {
        return ieducationRepository.findByEdCareerName(edCareerName);
    }
    
    public void save(Education ed) {
        ieducationRepository.save(ed);
    }
    
    public void delete(int id) {
        ieducationRepository.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return ieducationRepository.existsById(id);
    }
    
    public boolean existsByEdCareerName(String edCareerName) {
        return ieducationRepository.existsByEdCareerName(edCareerName);
    }
    
}
